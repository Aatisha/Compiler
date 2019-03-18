package com.sbu.compiler.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.List;

import org.apache.commons.text.StringEscapeUtils;
import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.sbu.compiler.domain.Lab;
import com.sbu.compiler.domain.Question;
import com.sbu.compiler.domain.Solution;
import com.sbu.compiler.domain.User;
import com.sbu.compiler.dto.CodeResponseDTO;
import com.sbu.compiler.dto.ResponseDto;
import com.sbu.compiler.dto.SolutionDTO;
import com.sbu.compiler.dto.TestCaseDTO;
import com.sbu.compiler.repository.QuestionRepository;
import com.sbu.compiler.repository.SolutionRepository;
import com.sbu.compiler.service.SolutionService;

@Service
public class SolutionServiceImpl implements SolutionService{
	@Autowired
	QuestionRepository questionRepository;
	
	@Autowired
	SolutionRepository solutionRepository;
	
	@Override
	public String execute(SolutionDTO param) {
		// TODO Auto-generated method stub
		return run(param);
	}

	@Override
	public ResponseDto save(SolutionDTO param) {
		// TODO Auto-generated method stub
		Solution solution = solutionRepository.findWithUserIdAndLabIdAndQuestionId(param.getUserId(),param.getLabId(),param.getQuestionId());
		if(solution!=null)
		{
			solution.setSolution_file(param.getSolution_file());
			if(param.getResult()!=null)
			solution.setResult(param.getResult());
			solutionRepository.save(solution);
			ResponseDto response = new ResponseDto();
			response.setResponseMessage("Saved Successfully");
			System.out.println("saved");
			return response;
			
		}
		else
		{
			solution = new Solution();
			User user = new User();
			user.setUserId(param.getUserId());
			solution.setUser(user);
			Lab lab = new Lab();
			lab.setLabId(param.getLabId());
			solution.setLab(lab);
			Question question = new Question();
			question.setQuestionId(param.getQuestionId());
			solution.setQuestion(question);
			solution.setSolution_file(param.getSolution_file());
			if(param.getResult()==null)
				solution.setResult("0");
			else
				solution.setResult(param.getResult());	
			solutionRepository.save(solution);
			ResponseDto response = new ResponseDto();
			response.setResponseMessage("Saved Successfully");
			return response;
			
			
		}
	}
	
	public String run(SolutionDTO param)
	{
		String clientId = "dd5f34c2abd7a4fdb47559da9343d7e6"; //Replace with your client ID
        String clientSecret = "690f84248405b7523642f12bbec0458cb6d233110aeb144ffedd24bd84d7cc28"; //Replace with your client Secret
        String script = param.getSolution_file();//StringEscapeUtils.escapeJava(param.getSolution_file());
        String language = questionRepository.findByQuestionId(param.getQuestionId()).getProgrammingLang().toLowerCase();
        String versionIndex = "0";
        String inputparam = param.getInput();
        String result="";
        try {
            URL url = new URL("https://api.jdoodle.com/execute");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");

            String input = "{\"clientId\": \"" + clientId + "\",\"clientSecret\":\"" + clientSecret + "\",\"script\":\"" + script +
            "\",\"language\":\"" + language + "\",\"versionIndex\":\"" + versionIndex + "\",\"stdin\":\"" +inputparam+ "\"} ";

            System.out.println(input);

            OutputStream outputStream = connection.getOutputStream();
            outputStream.write(input.getBytes());
            outputStream.flush();

            if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new RuntimeException("Please check your inputs : HTTP error code : "+ connection.getResponseCode());
            }

            BufferedReader bufferedReader;
            bufferedReader = new BufferedReader(new InputStreamReader((connection.getInputStream())));

            String output;
            System.out.println("Output from JDoodle .... \n");
            while ((output = bufferedReader.readLine()) != null) {
            	result+=output;
                System.out.println(output);
            }
            
            connection.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
		return result;
	}

	@Override
	public SolutionDTO submit(SolutionDTO param) throws JsonParseException, JsonMappingException, IOException, ParseException {
		// TODO Auto-generated method stub
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		mapper.setSerializationInclusion(Include.NON_NULL);
		String tc = StringEscapeUtils.unescapeJava(questionRepository.findByQuestionId(param.getQuestionId()).getTestCase());
		List<TestCaseDTO> testCases = mapper.readValue(tc, new TypeReference<List<TestCaseDTO>>(){});
		int totalTestCasesCount = testCases.size();
		int clearedTestCaseCount = 0;
		for(TestCaseDTO testCase:testCases)
		{
			param.setInput(testCase.getInput());
			CodeResponseDTO res = new ObjectMapper().readValue(run(param), CodeResponseDTO.class);
			if(res.output.equals(testCase.getOutput()))
			{
				clearedTestCaseCount++;
				System.out.println("count: \t"+clearedTestCaseCount);
			}
		}
		double result=0;
		System.out.println(totalTestCasesCount);
		if(clearedTestCaseCount!=0)
			result =  ((double)clearedTestCaseCount)/((double)totalTestCasesCount)*100;
		DecimalFormat df = new DecimalFormat("###.#");
		param.setResult(df.format(result));
		SolutionDTO outputResult = new SolutionDTO();
		outputResult.setResult(df.format(result));
		if(save(param).getResponseMessage().equals("Saved Successfully"))
		{
			outputResult.setResponseMessage("Saved and Submitted Successfully.");
		}
		else
		{
			outputResult.setResponseMessage("Error occured while saving.");
		}
			
		return outputResult;
	}

}

package com.sbu.compiler.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.text.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbu.compiler.dto.SolutionDTO;
import com.sbu.compiler.repository.QuestionRepository;
import com.sbu.compiler.service.SolutionService;

@Service
public class SolutionServiceImpl implements SolutionService{
	@Autowired
	QuestionRepository questionRepository;
	
//	@Autowired
//	Solution solution;
	
	@Override
	public String execute(SolutionDTO param) {
		// TODO Auto-generated method stub
		return run(param);
	}

	@Override
	public void save(SolutionDTO param) {
		// TODO Auto-generated method stub
//		User user = new User();
//		user.setUserId(param.getUser_id());
//		solution.setUser(user);
//		Lab lab = new Lab();
//		lab.setLabId(param.getLab_id());
//		solution.setLab(lab);
//		Question question = new Question();
//		question.setQuestionId(param.getQuestion_id());
//		solution.setQuestion(question);
//		solution.setSolution_file(param.getScript());
		
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

}

package com.nhnacademy.edu.springframework.project.repository;

import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CsvScores implements Scores {

    private CsvScores(){}
    private static CsvScores csvScores;
    /** TODO 2 :
     * Java Singleton 패턴으로 getInstance() 를 구현하세요.
     **/
    public static Scores getInstance() {
    	if (csvScores == null) {
    		csvScores = new CsvScores();
    	}
        return csvScores;
    }
	private List<Score> scores;
    // TODO 5 : score.csv 파일에서 데이터를 읽어 멤버 변수에 추가하는 로직을 구현하세요.
    @Override
    public void load() {
    	List<Score> scores = new ArrayList<>();
    	try(
				InputStream inputStream = new ClassPathResource("data/score.csv").getInputStream();
				BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
    	){
    		String line;
    		while ((line = reader.readLine()) != null) {
    			String[] splitStrings = line.split(",");
    			int studentSeq = Integer.parseInt(splitStrings[0]);
    			int score = Integer.parseInt(splitStrings[1]);
    			scores.add(new Score(studentSeq,score));
    			}}
    	catch (IOException e) {
    		throw new RuntimeException(e);
    	}
	this.scores = scores;
	}
    @Override
    public List<Score> findAll() {
		if (this.scores == null){
			this.getInstance().load();
		}
		return this.scores;
    }
}

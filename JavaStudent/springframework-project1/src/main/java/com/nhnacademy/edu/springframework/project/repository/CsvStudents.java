package com.nhnacademy.edu.springframework.project.repository;

import com.nhnacademy.edu.springframework.project.service.Student;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class CsvStudents implements Students {

	private CsvStudents() {};
	private static CsvStudents csvStudents;
    /** TODO 3 :
     * Java Singleton 패턴으로 getInstance() 를 구현하세요.
     **/
    public static Students getInstance() {
        if (csvStudents == null) {
        	csvStudents = new CsvStudents();
        }
        return csvStudents;
    }
    private Collection<Student> students;

    // TODO 7 : student.csv 파일에서 데이터를 읽어 클래스 멤버 변수에 추가하는 로직을 구현하세요.
    // 데이터를 적재하고 읽기 위해서, 적절한 자료구조를 사용하세요.
    @Override
    public void load() {
        List<Student> students = new ArrayList<>();
        try(
                InputStream inputStream = new ClassPathResource("data/student.csv").getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        ){
            String line;
            while ((line = reader.readLine()) != null) {
                String[] splitStrings = line.split(",");
                int studentSeq = Integer.parseInt(splitStrings[0]);
                String name = splitStrings[1];
                students.add(new Student(studentSeq,name));
            }}
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.students = students;
    }

    @Override
    public Collection<Student> findAll() {
        if (this.students == null){
            this.getInstance().load();
        }
        return this.students;
    }
    /**
     * TODO 8 : students 데이터에 score 정보를 추가하세요.
     * @param scores
     */
    @Override
    public void merge(Collection<Score> scores) {
        for (Score score : scores){
            for (Student student : this.students){
                if (score.getStudentSeq() == student.getSeq()){
                    student.setScore(score);
                }
            }
        }
    }
}

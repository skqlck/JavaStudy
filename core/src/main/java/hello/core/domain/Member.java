package hello.core.domain;

public class Member {

    private Long id;
    private String name;
    private Grade grade;

    public Member(Long id, String name, Grade grade){
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public String getName(){
        return this.name;
    }
    public Grade getGrade(){
        return this.grade;
    }
    public Long getId(){
        return this.id;
    }
    public void setGrade(Grade grade) {
        this.grade = grade;
    }
}

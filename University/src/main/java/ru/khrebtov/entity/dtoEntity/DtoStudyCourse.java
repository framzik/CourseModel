package ru.khrebtov.entity.dtoEntity;

import ru.khrebtov.entity.Course;
import ru.khrebtov.entity.Student;
import ru.khrebtov.entity.StudyCourse;

import java.util.List;

public class DtoStudyCourse {

    private Long id;
    private List<Integer> rating;
    private Float finalRating;

    private DtoStudent student;
    private DtoCourse course;

    public DtoStudyCourse() {
    }

    public DtoStudyCourse(Long id, List<Integer> rating, DtoCourse course) {
        this.id = id;
        this.rating = rating;
        this.course = course;
    }

    public DtoStudyCourse(StudyCourse studyCourse) {
        this.id = studyCourse.getId();
        this.rating = studyCourse.getRating();
        this.student = new DtoStudent(studyCourse.getStudent());
        this.course = new DtoCourse(studyCourse.getCourse());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Integer> getRating() {
        return rating;
    }

    public void setRating(List<Integer> rating) {
        this.rating = rating;
    }

    public Float getFinalRating() {
        return finalRating;
    }

    public void setFinalRating(Float finalRating) {
        this.finalRating = finalRating;
    }

    public DtoStudent getStudent() {
        return student;
    }

    public void setStudent(DtoStudent student) {
        this.student = student;
    }

    public DtoCourse getCourse() {
        return course;
    }

    public void setCourse(DtoCourse course) {
        this.course = course;
    }
}

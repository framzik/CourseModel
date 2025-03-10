package ru.khrebtov.university.entity.dtoEntity;


import ru.khrebtov.university.entity.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class DtoStudent {

    private Long id;
    private String name;
    private String address;
    private String phone;
    private String email;
    private Integer recordBook;

    private Float progress;
    private Set<DtoCourse> courses;
    private List<DtoStudyCourse> studyCourses;

    public DtoStudent() {
    }

    public DtoStudent(Long id, String name, String address, String phone, String email, Integer recordBook, Float progress) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.recordBook = recordBook;
        this.progress = progress;
    }

    public DtoStudent(Student student) {
        this(student.getId(), student.getName(), student.getAddress(), student.getPhone(), student.getEmail(),
                student.getRecordBook(), student.getProgress());

        if (student.getStudyCourses() != null) {
            this.studyCourses = new ArrayList<>();
            student.getStudyCourses().forEach(sc ->
                    studyCourses.add(new DtoStudyCourse(sc)));
        }
    }

    public DtoStudent(Student student, List<DtoStudyCourse> studyCourses) {
        this(student.getId(), student.getName(), student.getAddress(), student.getPhone(), student.getEmail(),
                student.getRecordBook(), student.getProgress());
        if (studyCourses != null) {
            this.studyCourses = studyCourses;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getRecordBook() {
        return recordBook;
    }

    public void setRecordBook(Integer recordBook) {
        this.recordBook = recordBook;
    }

    public Float getProgress() {
        return progress;
    }

    public void setProgress(Float progress) {
        this.progress = progress;
    }

    public Set<DtoCourse> getCourses() {
        return courses;
    }

    public void setCourses(Set<DtoCourse> courses) {
        this.courses = courses;
    }

    public List<DtoStudyCourse> getStudyCourses() {
        return studyCourses;
    }

    public void setStudyCourses(List<DtoStudyCourse> studyCourses) {
        this.studyCourses = studyCourses;
    }
}

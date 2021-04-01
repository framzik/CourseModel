package ru.khrebtov.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.khrebtov.entity.Student;
import ru.khrebtov.entity.StudyCourse;
import ru.khrebtov.entity.dtoEntity.DtoStudyCourse;
import ru.khrebtov.repositories.StudyCourseRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import java.util.ArrayList;
import java.util.List;


@Stateless
public class StudyCourseServiceImpl implements StudyCourseServiceRest {
    Logger logger = LoggerFactory.getLogger(StudyCourseServiceImpl.class);

    @EJB
    private StudyCourseRepository studyCourseRepository;

    @Override
    public List<DtoStudyCourse> findAll() {
        logger.info("all StudyCourse");
        List<DtoStudyCourse> list = new ArrayList<>();
        for (StudyCourse studyCourse : studyCourseRepository.findAll()) {
            List<Integer> rating = studyCourseRepository.getRatings(studyCourse.getId());
            studyCourse.setRating(rating);
            Student student = studyCourseRepository.getStudentByStudyCourseId(studyCourse.getId());
            studyCourse.setStudent(student);
            studyCourse.setCourse(studyCourseRepository.getCourseByStudyCourseId(studyCourse.getId()));
            DtoStudyCourse dtoStudyCourse = new DtoStudyCourse(studyCourse);
            list.add(dtoStudyCourse);
        }
        return list;
    }

    @Override
    public DtoStudyCourse findById(Long id) {
        logger.info("find studyCourse by id = {}", id);
        List<Integer> rating = studyCourseRepository.getRatings(id);
        StudyCourse studyCourseById = studyCourseRepository.findById(id);
        studyCourseById.setRating(rating);
        Student student = studyCourseRepository.getStudentByStudyCourseId(id);
        studyCourseById.setStudent(student);
        studyCourseById.setCourse(studyCourseRepository.getCourseByStudyCourseId(id));
        return new DtoStudyCourse(studyCourseById);
    }

    @Override
    public Long countAll() {
        logger.info("count studyCourse");
        return studyCourseRepository.countAll();
    }

    @Override
    public void insert(DtoStudyCourse studyCourse) {
        logger.info("Try insert studyCourse with id {}", studyCourse.getId());
        if (studyCourse.getId() != null) {
            logger.error("Был передан существующий studyCourse id!=null");
            throw new IllegalArgumentException();
        }
        saveOrUpdate(studyCourse);
    }

    @Override
    public void update(DtoStudyCourse studyCourse) {
        logger.info("Try update professor with id {}", studyCourse.getId());
        if (studyCourse.getId() == null) {
            logger.error("Был передан не существующий профессор id==null");
            throw new IllegalArgumentException();
        }
        saveOrUpdate(studyCourse);
    }

    @TransactionAttribute
    public void saveOrUpdate(DtoStudyCourse studyCourse) {
        logger.info("Saving studyCourse with id {}", studyCourse.getId());
        studyCourseRepository.saveOrUpdate(new StudyCourse(studyCourse));
    }

    @Override
    @TransactionAttribute
    public void deleteById(Long id) {
        logger.info("Deleting studyCourse with id {}", id);
        studyCourseRepository.deleteById(id);
    }
}

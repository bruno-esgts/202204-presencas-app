package pt.esgts.brunojesus.presencas.repository;

import pt.esgts.brunojesus.presencas.model.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentRepository {

    private final List<Student> studentList;

    public StudentRepository() {
        studentList = new ArrayList<>();
        studentList.add(Student.of(593484,"Filipe Silva"));
        studentList.add(Student.of(328345, "Filipe Sousa"));
        studentList.add(Student.of(595904, "Rui Manuel"));
        studentList.add(Student.of(490340, "Carlos Filipe"));
        studentList.add(Student.of(399403, "Tiago Jorge"));
    }

    public List<Student> findAll() {
        return new ArrayList<>(studentList);
        //return Collections.unmodifiableList(studentList);
    }
}

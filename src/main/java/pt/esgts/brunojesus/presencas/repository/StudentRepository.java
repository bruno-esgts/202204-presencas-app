package pt.esgts.brunojesus.presencas.repository;

import pt.esgts.brunojesus.presencas.model.Student;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class StudentRepository {

    private final List<Student> studentList;

    public StudentRepository() {
        studentList = loadStudentsFile()
                .stream()
                .map(s -> s.split(","))
                .filter(s -> s.length > 1)
                .map(s -> new Student(Long.parseLong(s[0]), s[1]))
                .toList();
    }

    public List<Student> findAll() {
        return new ArrayList<>(studentList);
        //return Collections.unmodifiableList(studentList);
    }

    private List<String> loadStudentsFile() {
        List<String> result = null;

        try (InputStream inputStream = getClass().getClassLoader()
                .getResourceAsStream("students.csv")) {

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(inputStream)
            );

            result = reader
                    .lines()
                    .collect(Collectors.toList());
        } catch (IOException e) {
            System.err.println("Failed to close file");
        } catch (NullPointerException e) {
            System.err.println("Cannot open file");
            return Collections.emptyList();
        }

        return result;
    }
}

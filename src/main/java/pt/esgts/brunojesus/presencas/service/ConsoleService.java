package pt.esgts.brunojesus.presencas.service;

import pt.esgts.brunojesus.attendancereport.model.Attendance;
import pt.esgts.brunojesus.presencas.model.Student;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Creates the attendance list based on user input from the command line
 *
 * @author Bruno
 * @since 2022-04-21
 * @version 1.0
 */
public class ConsoleService {

    /**
     * Creates the attendance list for the provided studentList
     *
     * Will ask for user input for each student
     *
     * @see Student
     * @param studentList The list of students
     * @return The attendance list
     */
    public List<Attendance> createAttendanceList(List<Student> studentList) {
//        final List<Attendance> attendanceList = new ArrayList<>();
//        for (int i = 0; i < studentList.size(); i++) {
//            final Student student = studentList.get(i);
//            final Attendance attendance = new Attendance()
//                    .setNumber(student.getId())
//                    .setName(student.getName())
//                    .setPresent(true);
//
//            attendanceList.add(attendance);
//        }
        return studentList.stream()
                .map(student -> new Attendance()
                        .setNumber(student.getId())
                        .setName(student.getName())
                        .setPresent(askPresence(student.getName()))
                ).collect(Collectors.toList());
    }

    private static boolean askPresence(String name) {
        final Scanner scanner = new Scanner(System.in);

        System.out.print(name + ": ");
        String value = scanner.nextLine();

        return value.equals("y");
    }
}

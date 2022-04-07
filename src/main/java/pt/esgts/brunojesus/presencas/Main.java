package pt.esgts.brunojesus.presencas;

import pt.esgts.brunojesus.attendancereport.PresenceReportFacade;
import pt.esgts.brunojesus.attendancereport.actions.Report;
import pt.esgts.brunojesus.attendancereport.model.Attendance;
import pt.esgts.brunojesus.attendancereport.model.ReportData;
import pt.esgts.brunojesus.presencas.model.Student;
import pt.esgts.brunojesus.presencas.repository.StudentRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        final StudentRepository studentRepository = new StudentRepository();
        final PresenceReportFacade presenceReportFacade = new PresenceReportFacade();

        final List<Student> studentList = studentRepository.findAll();

        final List<Attendance> attendanceList = studentList.stream()
                .map(student -> new Attendance()
                        .setNumber(student.getId())
                        .setName(student.getName())
                        .setPresent(isPresent(student.getName()))
                ).collect(Collectors.toList());

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

        final ReportData reportData = new ReportData()
                .setAcademicYear(2021)
                .setClassName("Eng. de Software")
                .setCourseName("TPSI")
                .setDate(LocalDate.now())
                .setAttendances(attendanceList);

        final Report report = presenceReportFacade.compileReport(reportData);
        presenceReportFacade.viewReport(report);
    }

    private static boolean isPresent(String name) {
        final Scanner scanner = new Scanner(System.in);

        System.out.print(name + ": ");
        String value = scanner.nextLine();

        return value.equals("y");
    }
}

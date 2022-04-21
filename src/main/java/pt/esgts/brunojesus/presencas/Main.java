package pt.esgts.brunojesus.presencas;

import pt.esgts.brunojesus.attendancereport.PresenceReportFacade;
import pt.esgts.brunojesus.attendancereport.actions.Report;
import pt.esgts.brunojesus.attendancereport.model.Attendance;
import pt.esgts.brunojesus.attendancereport.model.ReportData;
import pt.esgts.brunojesus.presencas.model.Student;
import pt.esgts.brunojesus.presencas.repository.StudentRepository;
import pt.esgts.brunojesus.presencas.service.ConsoleService;

import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        final StudentRepository studentRepository = new StudentRepository();
        final PresenceReportFacade presenceReportFacade = new PresenceReportFacade();
        final ConsoleService consoleService = new ConsoleService();

        final List<Student> studentList = studentRepository.findAll();

        final ReportData reportData = new ReportData()
                .setAcademicYear(2021)
                .setClassName("Eng. de Software")
                .setCourseName("TPSI")
                .setDate(LocalDate.now())
                .setAttendances(consoleService.createAttendanceList(studentList));

        final Report report = presenceReportFacade.compileReport(reportData);
        presenceReportFacade.viewReport(report);
    }


}

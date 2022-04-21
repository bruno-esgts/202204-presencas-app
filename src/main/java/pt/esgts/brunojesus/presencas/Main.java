package pt.esgts.brunojesus.presencas;

import pt.esgts.brunojesus.attendancereport.PresenceReportFacade;
import pt.esgts.brunojesus.attendancereport.actions.Report;
import pt.esgts.brunojesus.attendancereport.model.ReportData;
import pt.esgts.brunojesus.presencas.model.Student;
import pt.esgts.brunojesus.presencas.repository.StudentRepository;
import pt.esgts.brunojesus.presencas.service.ConsoleService;

import java.time.LocalDate;
import java.util.List;

/**
 * Generates a report with the attendance list for the current day
 *
 * Asks for the attendance status of each student
 *
 * @author Bruno Jesus
 * @since 2022-04-21
 * @version 1.0
 */
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

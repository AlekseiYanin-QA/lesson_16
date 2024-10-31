package src;
import java.util.List;

public interface IExaminations {
    void addRecord(String firstName, String lastName, String subject, int grade);
    Record getRecord(String firstName, String lastName, String subject);
    double getAverageBySubject(String subject);
    List<Record> getStudentsWithMultipleAttempts();
    List<Record> getLastFiveExcellentGrades();
    List<String> getAllSubjects();
}
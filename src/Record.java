package src;

public class Record {
    public final String firstName;
    public final String lastName;
    public final String subject;
    private int grade;

    public Record(String firstName, String lastName, String subject, int grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.subject = subject;
        this.grade = grade;
    }

    public int getGrade() {
        return grade;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSubject() {
        return subject;
    }

    public void updateGrade(int newGrade) {
        this.grade = newGrade;
    }

    @Override
    public String toString() {
        return "Record{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", subject='" + subject + '\'' +
                ", grade=" + grade +
                '}';
    }
}
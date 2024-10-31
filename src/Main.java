package src;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Examination examination = new Examination();

        // Добавление студентов и их оценок
        examination.addRecord("Иван", "Иванов", "Математика", 3);
        examination.addRecord("Иван", "Иванов", "Математика", 3); // Повторная сдача
        examination.addRecord("Иван", "Иванов", "Математика", 4);
        examination.addRecord("Иван", "Иванов", "Математика", 5); // Повторная сдача
        examination.addRecord("Петр", "Петров", "Физика", 3);
        examination.addRecord("Петр", "Петров", "Физика", 5); // Повторная сдача
        examination.addRecord("Анна", "Сидорова", "История", 5);
        examination.addRecord("Елена", "Кузнецова", "Литература", 3);
        examination.addRecord("Алексей", "Васильев", "Химия", 3);
        examination.addRecord("Ольга", "Николаева", "Информатика", 5); // Отличная оценка
        examination.addRecord("Максим", "Орлов", "География", 3);
        examination.addRecord("Андрей", "Зиновьев", "Биология", 3);
        examination.addRecord("Светлана", "Павлова", "Английский язык", 3);
        examination.addRecord("Дмитрий", "Сергеев", "Русский язык", 3);
        examination.addRecord("Иван", "Иванов", "Физика", 5); // Отличная оценка
        examination.addRecord("Петр", "Петров", "Математика", 3); // Повторная сдача
        examination.addRecord("Анна", "Сидорова", "История", 5); // Отличная оценка
        examination.addRecord("Максим", "Орлов", "Литература", 5); // Отличная оценка
        examination.addRecord("Алексей", "Васильев", "Химия", 5); // Отличная оценка
        examination.addRecord("Иван", "Иванов", "Математика", 5); // Отличная оценка
        examination.addRecord("Петр", "Петров", "Физика", 5); // Отличная оценка
        examination.addRecord("Анна", "Сидорова", "Литература", 5); // Отличная оценка
        examination.addRecord("Максим", "Орлов", "Химия", 5); // Отличная оценка
        examination.addRecord("Елена", "Кузнецова", "Биология", 5); // Отличная оценка

        System.out.println("Средняя оценка по математике: " + examination.getAverageBySubject("Математика"));

        // Проверка на null перед вызовом toString()
        Record record = examination.getRecord("Анна", "Сидорова", "История");
        if (record != null) {
            System.out.println(record.toString());
        } else {
            System.out.println("Запись не найдена.");
        }

        List<Record> multipleAttempts = examination.getStudentsWithMultipleAttempts();
        System.out.println("\nСтуденты с несколькими попытками:");
        multipleAttempts.forEach(System.out::println);

        // Добавляем еще одну отличную оценку
        examination.addRecord("Андрей", "Зайцев", "Химия", 5);
        List<Record> excellentGrades = examination.getLastFiveExcellentGrades();
        System.out.println("\nПоследние пять отличников:");
        excellentGrades.forEach(System.out::println);

        // Печатаем все сданные предметы
        examination.printAllSubjects();
    }

}
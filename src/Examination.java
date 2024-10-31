package src;

import java.util.*;
import java.util.stream.Collectors;

public class Examination implements IExaminations {

    // Хранение записей о сдаче экзаменов
    private final Map<String, Record> records = new HashMap<>();

    // Кэш для хранения средних оценок по предметам
    private final Map<String, Double> averageCache = new HashMap<>();

    // Метод для вывода всех уникальных сданных предметов
    public void printAllSubjects() {
        List<String> subjects = getAllSubjects(); // Получаем список уникальных предметов
        System.out.println("\n Все сданные предметы:");
        if (subjects.isEmpty()) {
            System.out.println("\n Нет сданных предметов.");
        } else {
            subjects.forEach(System.out::println); // Выводим все предметы
        }
    }

    @Override
    public void addRecord(String firstName, String lastName, String subject, int grade) {
        if (grade < 1 || grade > 5) {
            throw new IllegalArgumentException("Оценка должна быть в диапазоне от 1 до 5.");
        }
        records.put(getKey(firstName, lastName, subject), new Record(firstName, lastName, subject, grade));
    }

    @Override
    public Record getRecord(String firstName, String lastName, String subject) {
        return records.get(getKey(firstName, lastName, subject));
    }

    @Override
    public double getAverageBySubject(String subject) {
        if (averageCache.containsKey(subject)) {
            return averageCache.get(subject);
        }

        List<Record> filteredRecords = records.values().stream()
                .filter(r -> r.subject.equals(subject))
                .collect(Collectors.toList());

        if (filteredRecords.isEmpty()) {
            return 0.0;
        }

        double sum = filteredRecords.stream()
                .mapToInt(Record::getGrade)
                .sum();

        double average = sum / filteredRecords.size();
        averageCache.put(subject, average); // сохранение среднего значения в кэше
        return average;
    }

    @Override
    public List<Record> getStudentsWithMultipleAttempts() {
        Map<String, Integer> studentCount = new HashMap<>();

        // Считаем количество оценок для каждого студента
        for (Record record : records.values()) {
            String key = record.getFirstName() + " " + record.getLastName();
            studentCount.put(key, studentCount.getOrDefault(key, 0) + 1);
        }

        // Отбираем студентов с более чем одной попыткой
        return records.values().stream()
                .filter(record -> studentCount.get(record.getFirstName() + " " + record.getLastName()) > 1)
                .distinct() // Убираем дубликаты, если нужны только уникальные записи
                .collect(Collectors.toList());
    }

    @Override
    public List<Record> getLastFiveExcellentGrades() {
        return records.values().stream()
                .filter(r -> r.getGrade() == 5)
                .sorted(Comparator.comparing(Record::getFirstName).thenComparing(Record::getLastName))
                .limit(5)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getAllSubjects() {
        return records.values().stream()
                .map(Record::getSubject)
                .distinct()
                .collect(Collectors.toList());
    }

    // Вспомогательный метод для создания ключа
    private static String getKey(String firstName, String lastName, String subject) {
        return firstName + "_" + lastName + "_" + subject;
    }
}
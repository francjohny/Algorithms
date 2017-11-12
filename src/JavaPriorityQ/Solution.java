package JavaPriorityQ;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st : students) {
                System.out.println(st.getName());
            }
        }
    }
}

class Student implements Comparable<Student> {
    private int id;
    private String name;
    private double cgpa;

    Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public double getCgpa() {
        return cgpa;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Student student) {
        if (this.cgpa > student.cgpa)
            return -1;
        else if (this.cgpa - student.cgpa == 0)
            return this.name.compareTo(student.getName());
        else if (this.name.compareTo(student.getName()) == 0)
            return this.id > student.id ? 1 : -1;
        return 1;
    }
}

class Priorities {
    private final String ENTER = "ENTER";
    private final String SERVED = "SERVED";
    private PriorityQueue<Student> priorityQueue = new PriorityQueue<>();

    List<Student> getStudents(List<String> events) {
        events.forEach(event -> {
            String[] split = event.split("[ ]");
            String s = split[0];
            if (s.equals(ENTER)) {
                priorityQueue.add(new Student(Integer.parseInt(split[3]), split[1], Double.parseDouble(split[2])));
            } else if (s.equals(SERVED)) {
                priorityQueue.poll();
            }
        });
        return new ArrayList<>(priorityQueue.stream().sorted().collect(Collectors.toList()));
    }
}

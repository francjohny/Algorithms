package JavaPriorityQ;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.Collectors;


/*
 * There are a number of students in a school who wait to be served.
 * Two types of events, ENTER and SERVED, can take place which are described below.
 * 1. ENTER: A student with some priority enters the queue to be served.
 * 2. SERVED: The student with the highest priority is served (removed) from the queue.
 *
 * A unique id is assigned to each student entering the queue.
 * The queue serves the students based on the following criteria (priority criteria):
    1. The student having the highest Cumulative Grade Point Average (CGPA) is served first.
    2. Any students having the same CGPA will be served by name in ascending case-sensitive alphabetical order.
    3. Any students having the same CGPA and name will be served in ascending order of the id.

 * The first line contains an integer, n, describing the total number of events.
 * Each of the subsequent lines will be of the following two forms:
    1. ENTER name CGPA id: The student to be inserted into the priority queue.
    2. SERVED: The highest priority student in the queue was served.

 * Input:
 * 12
 * ENTER John 3.75 50
 * ENTER Mark 3.8 24
 * ENTER Shafaet 3.7 35
 * SERVED
 * SERVED
 * ENTER Samiha 3.85 36
 * SERVED
 * ENTER Ashley 3.9 42
 * ENTER Maria 3.6 46
 * ENTER Anik 3.95 49
 * ENTER Dan 3.95 50
 * SERVED
 *
 * Output:
 * Dan
 * Ashley
 * Shafaet
 * Maria
 */
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

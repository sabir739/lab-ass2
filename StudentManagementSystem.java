import java.util.*;

// ======================= PERSON (ABSTRACT CLASS) ==========================
abstract class Person {
    protected String name;
    protected String email;

    public Person() {}

    public Person(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Abstract method
    public abstract void displayInfo();
}

// =========================== STUDENT CLASS ===============================
class Student extends Person {
    public int rollNo;
    protected String course;
    protected double marks;
    protected char grade;

    public Student() {}

    public Student(int rollNo, String name, String email, String course) {
        super(name, email);
        this.rollNo = rollNo;
        this.course = course;
    }

    // Method overriding
    @Override
    public void displayInfo() {
        System.out.println("Student Info:");
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Course: " + course);
    }

    // Method overloading
    public void displayInfo(boolean showMarks) {
        displayInfo();
        if (showMarks) {
            System.out.println("Marks: " + marks);
            System.out.println("Grade: " + grade);
        }
        System.out.println("[Note] Overloaded display method:");
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Finalize method called before object is garbage collected.");
    }
}

// ======================= RESEARCH STUDENT (FINAL CLASS) ===================
final class ResearchStudent extends Student {
    private String researchArea;

    public ResearchStudent(int rollNo, String name, String email, String course, String researchArea) {
        super(rollNo, name, email, course);
        this.researchArea = researchArea;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Research Area: " + researchArea);
    }

    public final void showFinalNote() {
        System.out.println("This is a final method in a final class.");
    }
}

// ========================== INTERFACE =====================================
interface RecordActions {
    void addStudent(Student s);
    void deleteStudent(int rollNo);
    void updateStudent(int rollNo, Student newData);
    Student searchStudent(int rollNo);
    void viewAllStudents();
}

// ======================== STUDENT MANAGER CLASS ===========================
class StudentManager implements RecordActions {

    private Map<Integer, Student> database = new HashMap<>();

    @Override
    public void addStudent(Student s) {
        if (database.containsKey(s.rollNo)) {
            System.out.println("Error: Duplicate Roll Number!");
        } else {
            database.put(s.rollNo, s);
            System.out.println("Student Added Successfully.");
        }
    }

    @Override
    public void deleteStudent(int rollNo) {
        if (database.remove(rollNo) != null)
            System.out.println("Record Deleted.");
        else
            System.out.println("Record Not Found.");
    }

    @Override
    public void updateStudent(int rollNo, Student newData) {
        if (database.containsKey(rollNo)) {
            database.put(rollNo, newData);
            System.out.println("Record Updated.");
        } else {
            System.out.println("Record Not Found.");
        }
    }

    @Override
    public Student searchStudent(int rollNo) {
        return database.get(rollNo);
    }

    @Override
    public void viewAllStudents() {
        if (database.isEmpty()) {
            System.out.println("No Records Found!");
            return;
        }

        for (Student s : database.values()) {
            s.displayInfo();  // Dynamic Polymorphism
            System.out.println("---------------------------");
        }
    }
}

// ============================ MAIN APP ====================================
public class StudentManagementSystem {
    public static void main(String[] args) {

        StudentManager manager = new StudentManager();

        // Normal Student
        Student s1 = new Student(101, "Ankit", "ankit@mail.com", "B.Tech");
        manager.addStudent(s1);

        // Research Student (Polymorphism)
        ResearchStudent s2 = new ResearchStudent(102, "Riya", "riya@mail.com", "M.Tech", "AI");
        manager.addStudent(s2);

        // Display ALL records
        manager.viewAllStudents();

        // Demonstrate method overloading
        s1.displayInfo(true);

        // Demonstrate final method
        s2.showFinalNote();

        // finalize() demonstration
        s1 = null;
        s2 = null;
        System.gc(); // Suggest GC (not guaranteed)
    }
}

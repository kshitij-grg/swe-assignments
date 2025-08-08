package edu.miu.cs.cs425.mystudentmgmt;

import edu.miu.cs.cs425.mystudentmgmt.model.Classroom;
import edu.miu.cs.cs425.mystudentmgmt.model.Course;
import edu.miu.cs.cs425.mystudentmgmt.model.Student;
import edu.miu.cs.cs425.mystudentmgmt.model.Transcript;
import edu.miu.cs.cs425.mystudentmgmt.service.ClassroomService;
import edu.miu.cs.cs425.mystudentmgmt.service.CourseService;
import edu.miu.cs.cs425.mystudentmgmt.service.StudentService;
import edu.miu.cs.cs425.mystudentmgmt.service.TranscriptService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class MyStudentMgmtAppApplication implements CommandLineRunner {
    private final StudentService studentService;
    private final TranscriptService transcriptService;
    private final ClassroomService classroomService;
    private final CourseService courseService;

    public MyStudentMgmtAppApplication(StudentService studentService, TranscriptService transcriptService, ClassroomService classroomService, CourseService courseService) {
        this.studentService = studentService;
        this.transcriptService = transcriptService;
        this.classroomService = classroomService;
        this.courseService = courseService;
    }

    public static void main(String[] args) {
        SpringApplication.run(MyStudentMgmtAppApplication.class, args);
    }

    /***
     * This is from lecture
      */
//    @Override
//    public void run(String... args) throws Exception {
//        System.out.println("Welcome to MyStudentMgmtApp");
////        Creating Student
////        System.out.println("Creating Student ...");
////        Student anna = new Student(null, "000-61-0001", "Anna", "Lynn", "Smith", 3.45, LocalDate.of(2019, 5, 24));
////        studentService.saveStudent(anna);
////
////        System.out.println("Student Created!");
//
//////        Creating Transcript
////        Transcript transcript = new Transcript(null, "BS Computer Science");
////        transcriptService.saveTranscript(transcript);
////
//////        Creating Classroom
////        Classroom classroom = new Classroom(null, "McLaughlin building", "M105");
////        classroomService.saveClassroom(classroom);
////
//////        Creating Course
////        Course course = new Course(null, "CS401", "Modern Prog Practices");
////        courseService.saveCourse(course);
//
////        //Retrieve, edit and update student by id
////        Student student = studentService.getStudentById(1);
////        student.setFirstName("John");
////        student.setLastName("Doe");
////        studentService.updateStudent(student);
//
//
//        // Add new transcript for existing student
////        Transcript csTranscript = new Transcript(null, "BS Computer Science", null);
////        Transcript saveCsTranscript = transcriptService.saveTranscript(csTranscript);
////        Student existingAnna = studentService.getStudentById(1);
////        existingAnna.setTranscript(saveCsTranscript);
////        studentService.updateStudent(existingAnna);
//
//        // Add new student with their new transcript
////        Student lara = new Student(null, "000-61-0002", "Lara", null, "Croft", 2.97,
////                LocalDate.of(2018, 12, 2),
////                new Transcript(null, "MBA")
////        );
////        studentService.saveStudent(lara);
//
////        Getting the Students
//        studentService.getAllStudents().forEach(System.out::println);
//    }

    @Override
    public void run(String... args) throws Exception {
//        //Using Cascade
//        Transcript csTranscript = new Transcript( "BS Computer Science");
//        Transcript mbaTranscript = new Transcript( "MBA");
//
//        Student anna = new Student(
//                "000-61-0001",
//                "Anna",
//                "Lynn",
//                "Smith",
//                3.45,
//                LocalDate.of(2019, 5, 24)
//        );
//        Student bob = new Student(
//                "000-61-0002",
//                "Bob",
//                "",
//                "Galverston",
//                2.87,
//                LocalDate.of(2019, 5, 30)
//        );
//
//        anna.setTranscript(csTranscript);
//        bob.setTranscript(mbaTranscript);
//
//        studentService.saveStudent(anna);
//        studentService.saveStudent(bob);
//
//        // Fetching Students by Id
//        Student existingAnna = studentService.getStudentByIdWithCourses(1L);
//        Student existingBob = studentService.getStudentByIdWithCourses(2L);
//
//        //Without Using Cascade
//        Classroom mcLaughin = new Classroom("McLaughlin building", "M105");
//        Classroom veril = new Classroom("Verill Hall", "V110");
//
//        Classroom savedMcLaughin = classroomService.saveClassroom(mcLaughin);
//        Classroom savedVeril = classroomService.saveClassroom(veril);
//
//        existingAnna.setClassroom(savedMcLaughin);
//        existingBob.setClassroom(savedVeril);
//
//        Course mpp = new Course("CS401", "Modern Prog Practices");
//        Course swe = new Course("CS425", "Software Engineering");
//        Course agile = new Course("MGT 5421", "Agile Project Management");
//        Course business = new Course("MGT 5460", "Business Intelligence and Data Mining");
//
//        Course savedMpp = courseService.saveCourse(mpp);
//        Course savedSwe = courseService.saveCourse(swe);
//        Course savedAgile = courseService.saveCourse(agile);
//        Course savedBusiness = courseService.saveCourse(business);
//
//        existingAnna.getCourses().add(savedMpp);
//        existingAnna.getCourses().add(savedSwe);
//        existingBob.getCourses().add(savedAgile);
//        existingBob.getCourses().add(savedBusiness);
//
//        //Persisting Student Data
//        studentService.updateStudent(existingAnna);
//        studentService.updateStudent(existingBob);
//
//        System.out.println("All data saved: Student + Transcript + Classroom + Courses!");
//        System.out.println();
//        System.out.println("-----------------------------------------------------------");
//        System.out.println();
        System.out.println("Getting the students");
        studentService.printAllStudentsWithDetails();
    }

}

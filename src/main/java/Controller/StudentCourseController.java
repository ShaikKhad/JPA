package Controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestParam;

import Entity.Course;
import Entity.Student;
import Repository.CourseRepository;
import Repository.StudentRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student/course")
public class StudentCourseController {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public StudentCourseController(StudentRepository studentRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    @PostMapping
    public Student saveStudentwithCourse(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @GetMapping
    public Page<Student> findAllStudent(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam String sortBy,
            @RequestParam String sortDir) {

        Pageable pageable = PageRequest.of(page, size, Sort.Direction.fromString(sortDir), sortBy);
        return studentRepository.findAll(pageable);
    }

    @GetMapping("/{studentId}")
    public Student findStudent(@PathVariable Long studentId) {
        return studentRepository.findById(studentId).orElse(null);
    }

    @GetMapping("/find{name}")
    public Page<Student> findStudentsContainingByName(
            @PathVariable String name,
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam String sortBy,
            @RequestParam String sortDir) {

        Pageable pageable = PageRequest.of(page, size, Sort.Direction.fromString(sortDir), sortBy);
        return studentRepository.findByNameContaining(name, pageable);
    }

    @GetMapping("/search/{price}")
    public Page<Course> findCoursesLessThanprice(
            @PathVariable double price,
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam String sortBy,
            @RequestParam String sortDir) {

        Pageable pageable = PageRequest.of(page, size, Sort.Direction.fromString(sortDir), sortBy);
        return courseRepository.findByFeeLessThan(price, pageable);
    }
}

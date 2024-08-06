package Controller;

import java.util.List;

import javax.print.attribute.standard.MediaSize.Other;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Entity.Course;
import Entity.Student;
import Repository.CourseRepository;
import Repository.StudentRepository;

@RestController
@RequestMapping("/student/course")
public class StudentCourseController {

	
	private StudentRepository studentRepository;
	
	
	private CourseRepository courseRepository;


	public StudentCourseController(StudentRepository studentRepository, CourseRepository courseRepository) {
		
		this.studentRepository = studentRepository;
		this.courseRepository = courseRepository;
	}
	@PostMapping
	public Student saveStudentwithCourse(@RequestBody Student student) {
		return studentRepository.save(student);
		
	}
	
	@GetMapping
	public List<Student> findAllStudent(){
		return studentRepository.findAll();
	}
	@GetMapping("/{studentid}")
	public Student findStudent(@PathVariable Long studentId) {
		return studentRepository.findById(studentId).orElse(null);
		
	}
	@GetMapping("/find{name}")
	public List<Student> findStudentsContainingByName(@PathVariable String name){
		return  studentRepository.findByNameContaining(name);
		
	}
	@GetMapping("/search/{price}")
	public List<Course> findCoursesLessThanprice(@PathVariable double price){
		return courseRepository.findByFeeLessThan(price);
		
	}
	
	
	
	
}

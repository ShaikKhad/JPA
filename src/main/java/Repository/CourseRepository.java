package Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

	
	List<Course> findByFeeLessThan(double fee);
}

package Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import Entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

	
	Page<Course> findByFeeLessThan(double fee, Pageable pageable);
}

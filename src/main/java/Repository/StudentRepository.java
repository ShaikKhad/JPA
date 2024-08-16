package Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import Entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{
	
	Page<Student> findByNameContaining(String name, Pageable pageable);
	
	
}

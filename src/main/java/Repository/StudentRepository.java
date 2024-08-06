package Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{
	
	List<Student> findByNameContaining(String name);
	
	
}

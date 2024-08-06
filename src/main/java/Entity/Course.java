package Entity;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="COURSE_TBL")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Course {

	@Id
	@GeneratedValue
	private Long id;
	private String title;
	private  String obbreviation;
	private int modules;
	private double fee;
	
	
	@ManyToMany(mappedBy = "courses",fetch = FetchType.LAZY)
	
	private Set<Student> students;
	
	
	
}

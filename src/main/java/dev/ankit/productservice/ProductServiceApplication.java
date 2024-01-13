package dev.ankit.productservice;

import dev.ankit.productservice.inheritanceexample.joinedtable.MentorRepository;
import dev.ankit.productservice.inheritanceexample.joinedtable.Student;
import dev.ankit.productservice.inheritanceexample.joinedtable.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ProductServiceApplication implements CommandLineRunner {

	private MentorRepository mentorRepository;
	private StudentRepository studentRepository;

	public ProductServiceApplication(MentorRepository mentorRepository,
									 StudentRepository studentRepository) {
		this.mentorRepository = mentorRepository;
		this.studentRepository = studentRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Mentor mentor = new Mentor();
//		mentor.setName("Vikranth");
//		mentor.setEmail("v@gmail.com");
//		mentor.setAvgRating(100.0);
//
//		mentorRepository.save(mentor);

//		User user = new User();
//		user.setId(1L);
//		user.setName("Kishan");
//		user.setEmail("k@gmail.com");
//
//		userRepository.save(user);
//
//		Student student = new Student();
//		student.setId(2L);
//		student.setName("meera");
//		student.setEmail("m@gmail.com");
//		student.setBatch("batch1");
//		student.setPsp(99.0);
//
//		studentRepository.save(student);


//		List<User> users = userRepository.findAll();
//		users.forEach(user2 -> {
//			System.out.println(user2.getName());
//		});


		Student student = new Student();
		student.setName("Nishta");
		student.setEmail("n@gmail.com");
		student.setBatch("batch2");
		student.setPsp(98.0);

		studentRepository.save(student);
	}
}

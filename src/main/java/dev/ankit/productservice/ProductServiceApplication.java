package dev.ankit.productservice;

import dev.ankit.productservice.inheritanceexample.joinedtable.MentorRepository;
import dev.ankit.productservice.inheritanceexample.joinedtable.Student;
import dev.ankit.productservice.inheritanceexample.joinedtable.StudentRepository;
import dev.ankit.productservice.models.Category;
import dev.ankit.productservice.models.Price;
import dev.ankit.productservice.models.Product;
import dev.ankit.productservice.repositories.CategoryRepository;
import dev.ankit.productservice.repositories.PriceRepository;
import dev.ankit.productservice.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootApplication
public class ProductServiceApplication implements CommandLineRunner {

	private MentorRepository mentorRepository;
	private StudentRepository studentRepository;

	private ProductRepository productRepository;
	private CategoryRepository categoryRepository;

	private PriceRepository priceRepository;

	public ProductServiceApplication(MentorRepository mentorRepository,
									 StudentRepository studentRepository,
									 ProductRepository productRepository,
									 CategoryRepository categoryRepository,
									 PriceRepository priceRepository) {
		this.mentorRepository = mentorRepository;
		this.studentRepository = studentRepository;
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
		this.priceRepository = priceRepository;
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


//		Student student = new Student();
//		student.setName("Nishta");
//		student.setEmail("n@gmail.com");
//		student.setBatch("batch2");
//		student.setPsp(98.0);
//
//		studentRepository.save(student);


		Category category = new Category();
		category.setName("electronics");

		Category savedCategory = categoryRepository.save(category);

		Price price = new Price("Rupee", 10.0);
		// Price savedPrice = priceRepository.save(price);

		Product product = new Product();
		product.setTitle("iPhone4");
		product.setImage("image url");
		product.setDescription("Best phone ever");
		product.setCategory(savedCategory);
		product.setPrice(price);
//
//
		productRepository.save(product);

		Product product1 = productRepository.findByTitle("iPhone4");
		System.out.println(product1);

//		Optional<Category> categoryOptional = categoryRepository.
//				findById(UUID.fromString("02600b88-43f3-4341-8bff-ec665a17c21c"));
//
//
//		if(!categoryOptional.isEmpty()) {
//			Category category = categoryOptional.get();
//			System.out.println(category.getProduct());
//		}

//		productRepository.deleteById(UUID.fromString("8ffdd9b4-acd1-48a3-9c44-ec92c2b4e5b1"));

	}


	/*
	* 1:1 ->
	* m:1 or 1:m
	* m:m
	* */
}

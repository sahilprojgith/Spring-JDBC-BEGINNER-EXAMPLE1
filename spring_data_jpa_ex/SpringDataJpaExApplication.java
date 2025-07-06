package com.telusko.spring_data_jpa_ex;

import com.telusko.spring_data_jpa_ex.model.Student;
import com.telusko.spring_data_jpa_ex.repo.StudentRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringDataJpaExApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringDataJpaExApplication.class, args);

		StudentRepo repo = context.getBean(StudentRepo.class);

		Student s1 = context.getBean(Student.class);
		Student s2 = context.getBean(Student.class);
		Student s3 = context.getBean(Student.class);

//		s1.setName("Samprabhu");
//		s1.setMarks(25);
//		s1.setRollNo(21);
//
//		s2.setName("Vignesh");
//		s2.setMarks(29);
//		s2.setRollNo(31);
//
//		s3.setName("Shravan");
//		s3.setMarks(15);
//		s3.setRollNo(43);
//
//		repo.save(s1);
//		repo.save(s2);
//		repo.save(s3);

//		System.out.println(repo.findAll());
//		System.out.println(repo.findById(29));


		System.out.println(repo.findByName("Rajas"));//JPQL Query




	}

}

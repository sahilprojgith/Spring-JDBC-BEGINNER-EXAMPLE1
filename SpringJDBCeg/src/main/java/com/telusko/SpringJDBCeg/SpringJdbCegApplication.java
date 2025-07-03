package com.telusko.SpringJDBCeg;

import com.telusko.SpringJDBCeg.Service.StudentService;
import com.telusko.SpringJDBCeg.model.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;


@SpringBootApplication
public class SpringJdbCegApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringJdbCegApplication.class, args);

		Student student = context.getBean(Student.class);
//		student.setName("Krishna");
//		student.setMarks(25);
//		student.setRollNo(36);

		StudentService service = context.getBean(StudentService.class);

		service.addStudent(student);

		List<Student> studentList = service.getStudents();

		for (Student s : studentList) {
			System.out.println(s.getRollNo() + " - " + s.getName() + " - " + s.getMarks()); // to print the data.
		}

	}

}

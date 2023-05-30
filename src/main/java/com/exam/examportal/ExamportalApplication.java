package com.exam.examportal;
import com.exam.examportal.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ExamportalApplication implements CommandLineRunner {

	@Autowired
	private UserService  userService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	public static void main(String[] args) {
		SpringApplication.run(ExamportalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("starting code");
	}

}

package com.udemy.udemy.academy;

import com.udemy.udemy.academy.domain.repository.FlyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@Slf4j
@SpringBootApplication
public class UdemyAcademyApplication implements CommandLineRunner {

	@Autowired
	private FlyRepository flyRepository;
	public static void main(String[] args) {
		SpringApplication.run(UdemyAcademyApplication.class, args);
	}

	@Override
	public void run(final String... args) throws Exception {
	flyRepository.findAll().get(0).getTickets();
	}
}

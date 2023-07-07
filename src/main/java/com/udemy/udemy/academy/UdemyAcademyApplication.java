package com.udemy.udemy.academy;

import com.udemy.udemy.academy.domain.entity.HotelEntity;
import com.udemy.udemy.academy.domain.repository.FlyRepository;
import com.udemy.udemy.academy.domain.repository.HotelRepository;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@Slf4j
@SpringBootApplication
public class UdemyAcademyApplication implements CommandLineRunner {
	@Autowired
	private HotelRepository hotelRepository;
	@Autowired
	private FlyRepository flyRepository;
	public static void main(String[] args) {
		SpringApplication.run(UdemyAcademyApplication.class, args);
	}

	@Override
	public void run(final String... args) throws Exception {
		final List<HotelEntity> all = hotelRepository.findAll();
		log.info("Hoteles{}",all);
	}
}

package com.udemy.udemy.academy;

import com.udemy.udemy.academy.domain.entity.CustomerEntity;
import com.udemy.udemy.academy.domain.entity.FlyEntity;
import com.udemy.udemy.academy.domain.entity.HotelEntity;
import com.udemy.udemy.academy.domain.entity.ReservationEntity;
import com.udemy.udemy.academy.domain.entity.TicketEntity;
import com.udemy.udemy.academy.domain.entity.TourEntity;
import com.udemy.udemy.academy.domain.repository.CustomerRepository;
import com.udemy.udemy.academy.domain.repository.FlyRepository;
import com.udemy.udemy.academy.domain.repository.HotelRepository;
import com.udemy.udemy.academy.domain.repository.TourRepository;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class UdemyAcademyApplication implements CommandLineRunner {


	private final FlyRepository flyRepository;

	private final CustomerRepository customerRepository;

	private final TourRepository tourRepository;

	private final HotelRepository hotelRepository;

	public UdemyAcademyApplication (final CustomerRepository customerRepository,
			final FlyRepository flyRepository, final TourRepository tourRepository,
			final HotelRepository hotelRepository) {
		this.customerRepository = customerRepository;
		this.flyRepository = flyRepository;
		this.tourRepository = tourRepository;
		this.hotelRepository = hotelRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(UdemyAcademyApplication.class, args);
	}

	@Override
	public void run(final String... args) throws Exception {

		final CustomerEntity customer = customerRepository.findById("GOTW771012HMRGR087")
				.orElseThrow();
		log.info("Client name: " + customer.getFullName());

		final FlyEntity fly = flyRepository.findById(11L).orElseThrow();
		log.info("Fly: " + fly.getOriginName() + "-" + fly.getDestinyName());

		final HotelEntity hotel = hotelRepository.findById(3L).orElseThrow();
		log.info("Hotel: " + hotel.getName());

		TourEntity tour = TourEntity.builder()
				.customer(customer)
				.build();

		TicketEntity ticket = TicketEntity.builder()
				.id(UUID.randomUUID())
				.price(fly.getPrice()*10)
				.arrivalDate(LocalDate.now())
				.departureDate(LocalDate.now())
				.purchaseDate(LocalDate.now())
				.customer(customer)
				.tour(tour)
				.fly(fly)
				.build();

		ReservationEntity reservation = ReservationEntity.builder()
				.id(UUID.randomUUID())
				.dateReservation(LocalDateTime.now())
				.dateEnd(LocalDate.now().plusDays(2))
				.dateStart(LocalDate.now().plusDays(1))
				.hotel(hotel)
				.customer(customer)
				.tour(tour)
				.totalDays(1)
				.price(hotel.getPrice()*10)
				.build();

		System.out.println("----SAVING----");

		tour.addReservation(reservation);
		tour.updateReservation();

		tour.addTicket(ticket);
		tour.updateTickets();

		final TourEntity tourSaved = this.tourRepository.save(tour);
		this.tourRepository.deleteById(tourSaved.getId());


	}
}

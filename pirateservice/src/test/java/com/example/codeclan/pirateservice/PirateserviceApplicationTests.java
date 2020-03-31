package com.example.codeclan.pirateservice;

import com.example.codeclan.pirateservice.models.Pirate;
import com.example.codeclan.pirateservice.models.Raid;
import com.example.codeclan.pirateservice.models.Ship;
import com.example.codeclan.pirateservice.repositories.PirateRepository;
import com.example.codeclan.pirateservice.repositories.RaidRepository;
import com.example.codeclan.pirateservice.repositories.ShipRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PirateserviceApplicationTests {

	@Autowired
	PirateRepository pirateRepository;

	@Autowired
	ShipRepository shipRepository;

	@Autowired
	RaidRepository raidRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void createPirateAndShipAndRaid(){
		Raid raid = new Raid("Glasgow", 10000);
		raidRepository.save(raid);
		Ship ship = new Ship("The Salty Stallion");
		shipRepository.save(ship);
		Pirate Jack = new Pirate("Jack", "Portwood", 30, ship);
		pirateRepository.save(Jack);
		Pirate Alan = new Pirate("Alan", "Bond", 29, ship);
		pirateRepository.save(Alan);
		Pirate Joseph = new Pirate("Joseph", "Sutherland", 38, ship);
		pirateRepository.save(Joseph);
	}

	@Test
	public void getLocation(){
		Raid raid = new Raid("Glasgow", 10000);
		assertEquals("Glasgow", raid.getLocation());
	}

	@Test
	public void getLoot(){
		Raid raid = new Raid("Glasgow", 10000);
		assertEquals(10000, raid.getLoot());
	}


}

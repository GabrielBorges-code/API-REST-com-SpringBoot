package com.example.carros;

import com.example.carros.domain.Carro;
import com.example.carros.domain.CarroService;
import com.example.carros.domain.dto.CarroDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static junit.framework.TestCase.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarroApplicationTests {

	@Autowired
	private CarroService service;

	@Test
	public void testSave() {

		Carro carro = new Carro();
		carro.setNome("Ferrari");
		carro.setTipo("Esportivo");

		CarroDTO c = service.insert(carro);

		assertNotNull(c);

		Long id = c.getId();
		assertNotNull(id);

		//search car
		Optional<CarroDTO> op = service.getCarrosById(id);
		assertTrue(op.isPresent());

		c = op.get();

		//delete car
		service.delete(id);

		//verify if deleted
		assertFalse(service.getCarrosById(id).isPresent());


	}

	@Test
	public void testLista() {

		List<CarroDTO> carros = service.getCarros();

		assertEquals(30, carros.size());

	}

	@Test
	public void testGet() {

	assertEquals(10, service.getCarrosByTipo("luxo").size());
	assertEquals(10, service.getCarrosByTipo("classicos").size());
	assertEquals(10, service.getCarrosByTipo("esportivos").size());
	//assertEquals(10, service.getCarrosByTipo("xxx").size());

	}
}

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

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarroApplicationTests {

	@Autowired
	private CarroService service;

	@Test
	public void testSave() {

		Carro carro = new Carro();
		carro.setNome("Brasilia");
		carro.setTipo("esportivo");

		CarroDTO c = service.insert(carro);
		assertNotNull(c);

		Long id = c.getId();
		assertNotNull(id);

		//Search object
		Optional<CarroDTO>op = service.getCarrosById(id);
		assertTrue(op.isPresent());

		c = op.get();
		assertEquals("Opala", c.getNome());
		assertEquals("luxo", c.getTipo());

		//delete object
		service.delete(id);

		//Verify if deleted
		assertFalse(service.getCarrosById(id).isPresent());

	}

	@Test
	public void testLista() {
		List<CarroDTO> carro = service.getCarros();

		assertEquals("32", carro.size());
	}

}

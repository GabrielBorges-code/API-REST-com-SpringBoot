package com.example.carros.domain;

import com.example.carros.domain.dto.CarroDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarroService {

    @Autowired
    private CarroRepository rep;

    public List<CarroDTO> getCarros() {


        return rep.findAll().stream().map(CarroDTO::new).collect(Collectors.toList());

        /* é a mesma coisa.
        List<Carro> carros = rep.findAll();

        List<CarroDTO> list = carros.stream().map(CarroDTO::new).collect(Collectors.toList());

        return list;*/
    }

    public Optional<CarroDTO> getCarrosById(Long id) {

        return rep.findById(id).map(CarroDTO::new);

    }

    public List<CarroDTO> getCarrosByTipo(String tipo) {

        return rep.findByTipo(tipo).stream().map(CarroDTO::new).collect(Collectors.toList());

    }

    public List<Carro> getCarrosFake() {
        List<Carro> carros = new ArrayList<>();

        //Array im memory
        /*carros.add(new Carro(1L,"Fusca"));
        carros.add(new Carro(2L,"Brasilia"));
        carros.add(new Carro(3L,"Chevette"));*/

        return carros;
    }

    /*public Carro save(Carro carro) {

        return rep.save(carro);

    }*/

    public Carro insert(Carro carro) {

        Assert.isNull(carro.getId(), "Não foi possível inserir o registro");

        return rep.save(carro);
    }

    public Carro update(Carro carro, Long id) {
        Assert.notNull(id,"Não foi possível atualizar o registro");

        // Busca o carro no banco de dados
        Optional<Carro> optional = rep.findById(id);
        if(optional.isPresent()) {
            Carro db = optional.get();
            // Copiar as propriedades
            db.setNome(carro.getNome());
            db.setTipo(carro.getTipo());
            System.out.println("Carro id " + db.getId());

            // Atualiza o carro
            //return CarroDTO.create(db);
            rep.save(db);

            return db;
        }else{
            //return null;
            throw new RuntimeException("Não foi possivel atualizar o registro");
        }

    }

    public void delete(Long id) {

        if(getCarrosById(id).isPresent()){
            rep.deleteById(id);

        }
    }
}

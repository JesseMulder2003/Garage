package nl.muldj.garage.Car;

import nl.muldj.garage.repository.CarRepository;
import nl.muldj.garage.model.Car;
import nl.muldj.garage.service.CarServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class CarService {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private CarServiceImpl carService;


    @Test
    void shouldReturnAddedCar() {
        //given
        Car car = new Car("Novi", "Hatchback", "2014", "190000");

        //when
        carService.addCar(car);
        List<Car> expectedCar = carRepository.findByMerkIs("Novi");

        //then
        assertThat(expectedCar.get(0).getMerk()).isEqualTo("Novi");

    }

    @Test
    void shouldNotReturnAddedCar(){
        //given
        Car car = new Car("Edhub", "Cabriolet", "2018", "10000");
        carService.addCar(car);

        //when
        carService.deleteCar(car.getId());
        List<Car> expectedCar = carRepository.findByMerkIs("Edhub");

        //then
        assertThat(expectedCar.size()).isEqualTo(0);



    }

    @Test
    void shouldReturnSpecificCar(){
        //given
        Car car1 = new Car("Auto1", "Sedan", "2022", "123456");
        Car car2 = new Car("Auto2", "station", "2002", "10500");
        Car car3 = new Car("Auto3", "hatchabck", "2022", "112");
        carRepository.saveAll(List.of(car1, car2, car3));

        //when
        List<Car> expectedCar = carService.getCarByBrand("Auto1");

        //then
        assertThat(expectedCar.size()).isEqualTo(1);


    }
}

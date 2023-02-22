package nl.muldj.garage.service;

import nl.muldj.garage.repository.CarRepository;
import nl.muldj.garage.model.Car;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.any;

@SpringBootTest
public class CarServiceImplTest {

    @Autowired
    private CarServiceImpl carService;

    @MockBean
    private CarRepository carRepository;

    @Test
    void shouldReturnAddedCar() {
        //given
        Car car = new Car("Novi", "Hatchback", "2014", "190000");

        Mockito
                .when(carRepository.findByMerkIs(any()))
                .thenReturn(List.of(car));

        //when
        List<Car> expectedCar = carService.getCarByBrand("Novi");

        //then
        assertThat(expectedCar.get(0).getMerk()).isEqualTo(car.getMerk());

    }


    @Test
    void shouldReturnSpecificCar(){
        //given
        Car car1 = new Car("Auto1", "Sedan", "2022", "123456");
        Car car2 = new Car("Auto2", "station", "2002", "10500");
        Car car3 = new Car("Auto3", "hatchabck", "2022", "112");
//        carRepository.saveAll(List.of(car1, car2, car3));

        Mockito
                .when(carRepository.saveAll(any()))
                .thenReturn(List.of(car1, car2, car3));

        //when
        List<Car> expectedCar = carService.getCarByBrand("Auto1");

        //then
        assertThat(expectedCar.size()).isEqualTo(1);


    }
}

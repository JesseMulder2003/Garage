package novi.springboot.Garage.controller;

import novi.springboot.Garage.GarageApplication;
import novi.springboot.Garage.model.Car;
import novi.springboot.Garage.service.CarService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.Arrays;
import java.util.List;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@ContextConfiguration(classes = {GarageApplication.class})
class CarControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CarService carService;

    @Test
    public void testEndpointCar() throws Exception {
        Car car = new Car("fiat", "panda", "2004", "202480");

        List<Car> allCar = Arrays.asList(car);

        given(carService.getAllCars()).willReturn(allCar);

        mvc.perform(get("/cars")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
 //               .andExpect(jsonPath("$", hasSize(1)))
                .andExpect((ResultMatcher) jsonPath("$[0].car_brand", is(car.getMerk())));


    }
}
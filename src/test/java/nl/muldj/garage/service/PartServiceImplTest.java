package nl.muldj.garage.service;

import nl.muldj.garage.repository.PartRepository;
import nl.muldj.garage.model.Part;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.any;

@SpringBootTest
public class PartServiceImplTest {

    @Autowired
    private PartServiceImpl partService;

    @MockBean
    private PartRepository partRepository;


    @Test
    void shouldReturnMultipleParts(){
        //given
        Part part1 = new Part("ruitenwisser", "15", "5");
        Part part2 = new Part("supercharger", "650", "120");
        int oldListSize = 0;
//                partRepository.findAll().size();
//        partRepository.saveAll(List.of(part1, part2));

        Mockito
                .when(partRepository.findAll())
                .thenReturn(List.of(part1, part2));

        //when
        List<Part> expectedPart = partService.getAllParts();

        //then
        assertThat(expectedPart.size()).isEqualTo(2);
    }
}

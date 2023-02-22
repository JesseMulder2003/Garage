package nl.muldj.garage.Part;

import nl.muldj.garage.repository.PartRepository;
import nl.muldj.garage.model.Part;
import nl.muldj.garage.service.PartServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class PartService {

    @Autowired
    private PartServiceImpl partService;

    @Autowired
    private PartRepository partRepository;


    @Test
    void shouldReturnMultipleParts(){
        //given
        Part part1 = new Part("ruitenwisser", "15", "5");
        Part part2 = new Part("supercharger", "650", "120");
        int oldListSize = partRepository.findAll().size();
        partRepository.saveAll(List.of(part1, part2));

        //when
        List<Part> expectedPart = partService.getAllParts();

        //then
        assertThat(expectedPart.size()).isEqualTo(oldListSize + 2);
    }
}

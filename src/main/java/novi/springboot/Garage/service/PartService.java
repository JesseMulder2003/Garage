package novi.springboot.Garage.service;


import novi.springboot.Garage.model.Part;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PartService {

    List<Part> getAllParts();
}

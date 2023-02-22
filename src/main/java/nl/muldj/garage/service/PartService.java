package nl.muldj.garage.service;


import nl.muldj.garage.model.Part;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PartService {

    List<Part> getAllParts();
}

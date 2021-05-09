package novi.springboot.Garage.service;

import novi.springboot.Garage.Repository.PartRepository;
import novi.springboot.Garage.model.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartServiceImpl implements PartService {

    @Autowired
    PartRepository partRepository;

    @Override
    public List<Part> getAllParts() { return partRepository.findAll(); }
}

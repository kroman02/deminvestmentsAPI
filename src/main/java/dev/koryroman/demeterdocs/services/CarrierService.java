package dev.koryroman.demeterdocs.services;

import dev.koryroman.demeterdocs.data.Carrier;
import dev.koryroman.demeterdocs.data.repos.CarrierRepository;
import dev.koryroman.demeterdocs.exceptions.CarrierNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CarrierService {
    @Autowired
    CarrierRepository carrierRepository;


    public List<Carrier> getAllCarriers(){
        return carrierRepository.findAll();
    }

    public Carrier getOneCarrier(Long carrierId) throws CarrierNotFoundException {
        return carrierRepository.findById(carrierId).orElseThrow(() -> new CarrierNotFoundException(carrierId));
    }


}

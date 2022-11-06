package dev.koryroman.demeterdocs.web;

import dev.koryroman.demeterdocs.data.Carrier;
import dev.koryroman.demeterdocs.exceptions.CarrierNotFoundException;
import dev.koryroman.demeterdocs.exceptions.ClientNotFoundException;
import dev.koryroman.demeterdocs.services.CarrierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CarrierController {

    @Autowired
    CarrierService carrierService;



    @GetMapping("/carriers")
    public ResponseEntity<List<Carrier>> getAllCarriers(){
        List<Carrier> carriers = carrierService.getAllCarriers();
        return new ResponseEntity<>(carriers, HttpStatus.OK);
    }

    @GetMapping("carriers/{carrierId}")
    public ResponseEntity<Carrier> getOneCarrier(@PathVariable Long carrierId) throws CarrierNotFoundException {
        Carrier carrier = carrierService.getOneCarrier(carrierId);
        return new ResponseEntity<>(carrier, HttpStatus.OK);
    }

    @ExceptionHandler(CarrierNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String carrierNotFoundHandler(CarrierNotFoundException ex){
        return ex.getMessage();
    }


}

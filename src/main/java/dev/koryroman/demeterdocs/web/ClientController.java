package dev.koryroman.demeterdocs.web;


import dev.koryroman.demeterdocs.data.Client;
import dev.koryroman.demeterdocs.exceptions.ClientNotFoundException;
import dev.koryroman.demeterdocs.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api")
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping("/clients")
    public ResponseEntity<List<Client>> getAllClients(){

        List<Client> clients = new ArrayList<>(clientService.getAllClients());
        if(clients.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
            return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    @GetMapping("/clients/{clientId}")
    public ResponseEntity<Client> getOneClient(@PathVariable Long clientId) throws ClientNotFoundException {

        Client client = clientService.getClientById(clientId);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @GetMapping("/clients/byname")
    public ResponseEntity<List<Client>> getClientByName(@RequestParam(name="name") String name) throws ClientNotFoundException {
        List<Client> clients = clientService.getClientsByName(name);
        return new ResponseEntity(clients, HttpStatus.OK);
    }

    @PostMapping("/clients/add")
    public ResponseEntity<Client> addClient(@RequestBody Client requestClient){
        Client client = clientService.addClient(requestClient);
        return new ResponseEntity<>(client, HttpStatus.CREATED);
    }

    @ExceptionHandler(ClientNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String clientNotFoundHandler(ClientNotFoundException ex){
        return ex.getMessage();
    }


}

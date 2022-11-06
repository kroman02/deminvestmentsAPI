package dev.koryroman.demeterdocs.services;

import dev.koryroman.demeterdocs.data.Client;
import dev.koryroman.demeterdocs.data.repos.ClientRepository;
import dev.koryroman.demeterdocs.exceptions.ClientNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.lang.model.UnknownEntityException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class ClientService {


    ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getAllClients(){
        return clientRepository.findAll();
    }

    public Client getClientById(Long clientId) throws ClientNotFoundException {
        Optional<Client> client = clientRepository.findById(clientId);
        if(client.isEmpty()) throw new ClientNotFoundException(clientId);
        return client.get();
    }

    public Client addClient(Client client) {
        return clientRepository.save(client);
    }

    public List<Client> getClientsByName(String name) throws ClientNotFoundException {

        List<Client> clientsFound = new ArrayList<>();
        clientRepository.findAll()
                .stream()
                .filter(c -> c.getName().toLowerCase().contains(name.toLowerCase())).forEach(clientsFound::add);
        return clientsFound;


    }
}

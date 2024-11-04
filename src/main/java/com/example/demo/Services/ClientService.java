package com.example.demo.Services;

import com.example.demo.Entities.Client;
import com.example.demo.Mappers.ClientDTOMapper;
import com.example.demo.Mappers.ClientMapper;
import com.example.demo.Models.ClientDTO;
import com.example.demo.Repositories.ClientRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    @Autowired
    ClientService(ClientRepository clientRepository, ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

    public List<ClientDTO> getAllClients(){
        return clientRepository.
                findAll().
                stream().map(clientMapper::toDTO).toList();
    }

    public Optional<ClientDTO> getClientById(int id){
        return clientRepository.findById(id).stream().map(clientMapper::toDTO).findFirst();
    }

    public Integer saveClient(ClientDTO clientDTO){
        Client client = new Client();
        clientMapper.updateClientFromDto(clientDTO, client);
        clientRepository.save(client);
        return client.getId();
    }

    public void deleteClientById(long id){
         clientRepository.deleteById(id);
    }

    private Client getClientById(long id,ClientDTO clientDTO){
        Client client = clientRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        clientMapper.updateClientFromDto(clientDTO, client);
        if(clientDTO.getId() == 0)
            client.setId((int)id);
        return client;
    }

    public Client updateClientById(long id,ClientDTO clientDTO){
        Client client = getClientById(id,clientDTO);
        clientRepository.save(client);
        return client;
    }

    public Client patchClientById(long id,ClientDTO clientDTO){
        Client client = getClientById(id,clientDTO);
        clientRepository.save(client);
        return client;
    }
}

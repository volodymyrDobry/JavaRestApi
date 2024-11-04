package com.example.demo.Mappers;

import com.example.demo.Entities.Client;
import com.example.demo.Models.ClientDTO;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class ClientDTOMapper implements Function<Client, ClientDTO> {
    @Override
    public ClientDTO apply(Client client) {
        return new ClientDTO(
                client.getId(),
                client.getName(),
                client.getBirthday()
        );
    }
}

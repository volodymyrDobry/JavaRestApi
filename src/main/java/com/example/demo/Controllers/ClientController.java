package com.example.demo.Controllers;

import com.example.demo.Entities.Client;
import com.example.demo.Models.ClientDTO;
import com.example.demo.Repositories.ClientRepository;
import com.example.demo.Services.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/clients",produces = MediaType.APPLICATION_JSON_VALUE)
public class ClientController {
    ClientService clientService;
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/all")
    List<ClientDTO> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/{id}")
    ClientDTO getClientById(@PathVariable int id) {
        return clientService.getClientById(id).isPresent() ? clientService.getClientById(id).get() : null;
    }

    @PostMapping
    public ResponseEntity<Integer> addClient(@RequestBody ClientDTO client) {
        return new ResponseEntity<>(
                clientService.saveClient(client), HttpStatus.CREATED
        );
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteClient(@PathVariable int id) {
        clientService.deleteClientById(id);
    }
    

    @PutMapping("/{id}")
    public ResponseEntity<Client> updateClient(
            @PathVariable long id,
            @RequestBody ClientDTO client) {
        return new ResponseEntity<>(
                clientService.updateClientById(id,client), HttpStatus.OK
        );
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Client> patchClient(
            @PathVariable long id,@RequestBody ClientDTO client){
        Client updatedClient = clientService.patchClientById(id, client);
        return ResponseEntity.ok(updatedClient);
    }
}

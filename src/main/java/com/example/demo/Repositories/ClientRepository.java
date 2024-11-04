package com.example.demo.Repositories;


import com.example.demo.Entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findById(Integer id);

    List<Client> findAllByOrderByNameAsc();


}

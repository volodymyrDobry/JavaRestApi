package com.example.demo.Mappers;
import com.example.demo.Entities.Client;
import com.example.demo.Entities.Dish;
import com.example.demo.Models.ClientDTO;
import com.example.demo.Models.DishDTO;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")
public interface ClientMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateClientFromDto(ClientDTO clientDTO, @MappingTarget Client client);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Client toEntity(ClientDTO clientDTO);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    ClientDTO toDTO(Client client);



}

package com.example.demo.Services;

import com.example.demo.Entities.Dish;
import com.example.demo.Mappers.DishMapper;
import com.example.demo.Models.DishDTO;
import com.example.demo.Repositories.DishRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DishService {
    private final DishRepository dishRepository;
    private final DishMapper dishMapper;

    @Autowired
    public DishService(DishRepository dishRepository, DishMapper dishMapper) {
        this.dishRepository = dishRepository;
        this.dishMapper = dishMapper;
    }

    public List<DishDTO> getAllDishes() {
        return dishRepository.findAll().stream().map(dishMapper::fromDishToDTO).toList();
    }

    public Optional<DishDTO> getDishById(int id) {
        return dishRepository.findById(id).map(dishMapper::fromDishToDTO);
    }

    public Integer newDish(DishDTO dishDTO) {
        Dish dish = dishMapper.fromDTOToDish(dishDTO);
        dishRepository.save(dish);
        return 1;
    }

    private Dish getDishById(Integer id,DishDTO dishDTO) {
        Dish dish = dishRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        dishMapper.fromDTOToDish(dishDTO, dish);
        return dish;
    }

    public Integer putDish(int id,DishDTO dishDTO) {
        dishRepository.save(getDishById(id,dishDTO));
        return 1;
    }

    public Integer patchDish(int id, DishDTO dishDTO) {
        dishRepository.save(getDishById(id,dishDTO));
        return 1;
    }

    public Integer deleteDish(int id) {
        if (dishRepository.existsById(id))
            dishRepository.deleteById(id);
        else throw new EntityNotFoundException();
        return id;
    }
}

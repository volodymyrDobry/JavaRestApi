package com.example.demo.Controllers;

import com.example.demo.Models.DishDTO;
import com.example.demo.Services.DishService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/dish", produces = MediaType.APPLICATION_JSON_VALUE)
public class DishController {
    private final DishService dishService;

    @GetMapping("/all")
    public List<DishDTO> getAll() {
        return dishService.getAllDishes();
    }

    @GetMapping("/{id}")
    public DishDTO getById(@PathVariable int id) {
        return dishService.getDishById(id).orElse(null);
    }

    @PostMapping
    public Integer create(@RequestBody DishDTO dto) {
        return dishService.newDish(dto);
    }

    @PutMapping("/{id}")
    public Integer update(@PathVariable int id,@RequestBody DishDTO dto) {
        return dishService.putDish(id,dto);
    }

    @PatchMapping("/{id}")
    public Integer patch(@PathVariable int id,@RequestBody DishDTO dto) {
        return dishService.patchDish(id,dto);
    }

    @DeleteMapping("/{id}")
    public Integer delete(@PathVariable int id) {
        return dishService.deleteDish(id);
    }

}

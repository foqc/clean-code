package com.example.demo.controller;

import com.example.demo.DTO.PokemonDTO;
import com.example.demo.service.PokemonService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class PokemonController {


  private final PokemonService service;

  @GetMapping("pokemons")
  public List<PokemonDTO> getAllPokemons() {
    return service.getAll(0, 0);
  }
}

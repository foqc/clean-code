package com.example.demo.service;

import com.example.demo.DTO.PokemonDTO;
import java.util.List;

public interface PokemonService {

  List<PokemonDTO> getAllPokemonsByStartPrefix(String prefix);

  List<PokemonDTO> getAllPokemonsByEndPrefix(String prefix);

  List<String> getAllPokemonsName();
}

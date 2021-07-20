package com.example.demo.service;

import com.example.demo.DTO.PokemonDTO;
import java.util.List;

public interface PokemonService {

  List<PokemonDTO> getAllByStartPrefix(String prefix);

  List<PokemonDTO> getAllByEndPrefix(String prefix);

  List<String> getAllPokemonsName();
}

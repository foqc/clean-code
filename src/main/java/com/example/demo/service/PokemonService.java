package com.example.demo.service;

import com.example.demo.DTO.PokemonDTO;
import java.util.List;

public interface PokemonService {

  List<PokemonDTO> obtener_pokemon(String prefix);

  List<PokemonDTO> obtener_pokemon2(String prefix);

  List<String> getAllPokemonsName();
}

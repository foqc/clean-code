package com.example.demo.service;

import com.example.demo.DTO.PokemonDTO;
import java.util.List;

public interface PokemonService {

  List<PokemonDTO> getAll(int offset, int limit);
}

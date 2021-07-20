package com.example.demo.service.impl;

import com.example.demo.DTO.PokemonDTO;
import com.example.demo.domain.Pokemon;
import com.example.demo.respository.PokemonRepository;
import com.example.demo.service.PokemonService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PokemonServiceImpl implements PokemonService {


  private final PokemonRepository preciseRepository;

  @Override
  public List<PokemonDTO> getAll(int offset, int limit) {
    List<Pokemon> pokemons = preciseRepository.getAll(offset, limit);
    return pokemons.stream().map(pokemon -> {
      PokemonDTO pokemonDTO = new PokemonDTO();
      pokemonDTO.setName(pokemon.getName());
      return pokemonDTO;
    }).collect(Collectors.toList());
  }
}

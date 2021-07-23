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


  private final PokemonRepository pr;

  @Override
  public List<PokemonDTO> obtener_pokemon(String p) {
    List<Pokemon> pokemons = pr.getAll(0, 0);
    return pokemons.stream().filter(pokemon -> pokemon.getName().startsWith(p))
        .map(pokemon -> {
          PokemonDTO pokemonDTO = new PokemonDTO();
          pokemonDTO.setName(pokemon.getName());
          pokemonDTO.setAbility(1);
          return pokemonDTO;
        }).collect(Collectors.toList());
  }

  @Override
  public List<PokemonDTO> obtener_pokemon2(String p) {
    List<Pokemon> pokemons = pr.getAll(0, 0);
    return pokemons.stream().filter(pokemon -> pokemon.getName().endsWith(p))
        .map(pokemon -> {
          PokemonDTO pokemonDTO = new PokemonDTO();
          pokemonDTO.setName(pokemon.getName());
          pokemonDTO.setAbility(5);
          return pokemonDTO;
        }).collect(Collectors.toList());
  }

  @Override
  public List<String> getAllPokemonsName() {
    List<Pokemon> pokemons = pr.getAll(0, 0);
    return pokemons.stream().map(pokemon -> pokemon.getName()).collect(Collectors.toList());
  }
}

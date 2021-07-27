package com.example.demo.service.impl;

import com.example.demo.DTO.PokemonDTO;
import com.example.demo.domain.Pokemon;
import com.example.demo.respository.PokemonRepository;
import com.example.demo.service.PokemonService;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PokemonServiceImpl implements PokemonService {


  private final PokemonRepository pokemonRepository;

  private <T, R> List<R> getAllPokemonsByPrefix(List<T> pokemons, Function<T, Boolean> fnFilter, Function<T, R> fnMap){
    return pokemons.stream().filter(fnFilter::apply)
        .map(fnMap).collect(Collectors.toList());
  }

  @Override
  public List<PokemonDTO> getAllPokemonsByStartPrefix(String prefix) {
    List<Pokemon> pokemons = pokemonRepository.getAll(0, 0);

    return getAllPokemonsByPrefix(pokemons, pokemon -> pokemon.getName().startsWith(prefix), pokemon -> {
      PokemonDTO pokemonDTO = new PokemonDTO();
      pokemonDTO.setName(pokemon.getName());
      pokemonDTO.setAbility(1);
      return pokemonDTO;
    });
  }

  @Override
  public List<PokemonDTO> getAllPokemonsByEndPrefix(String prefix) {
    List<Pokemon> pokemons = pokemonRepository.getAll(0, 0);

    return getAllPokemonsByPrefix(pokemons, pokemon -> pokemon.getName().endsWith(prefix), pokemon -> {
      PokemonDTO pokemonDTO = new PokemonDTO();
      pokemonDTO.setName(pokemon.getName());
      pokemonDTO.setAbility(5);
      return pokemonDTO;
    });
  }

  @Override
  public List<String> getAllPokemonsName() {
    List<Pokemon> pokemons = pokemonRepository.getAll(0, 0);
    return getAllPokemonsByPrefix(pokemons, pokemon -> true, Pokemon::getName);
  }
}

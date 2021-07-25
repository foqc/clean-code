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
    List<Pokemon> pks = pr.getAll(0, 0);
    return pks.stream().filter(ps -> ps.getName().startsWith(p))
        .map(ps -> {
          PokemonDTO psDTO = new PokemonDTO();
          psDTO.setName(ps.getName());
          psDTO.setAbility(1);
          return psDTO;
        }).collect(Collectors.toList());
  }

  @Override
  public List<PokemonDTO> obtener_pokemon2(String p) {
    List<Pokemon> pks = pr.getAll(0, 0);
    return pks.stream().filter(ps -> ps.getName().endsWith(p))
        .map(ps -> {
          PokemonDTO psDTO = new PokemonDTO();
          psDTO.setName(ps.getName());
          psDTO.setAbility(5);
          return psDTO;
        }).collect(Collectors.toList());
  }

  @Override
  public List<String> getAllPokemonsName() {
    List<Pokemon> pks = pr.getAll(0, 0);
    return pks.stream().map(ps -> ps.getName()).collect(Collectors.toList());
  }
}

package com.example.demo.respository;

import com.example.demo.DTO.PokemonResume;
import com.example.demo.domain.Pokemon;
import com.example.demo.helpers.WebClientHelper;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Slf4j
public class PokemonRepository {

  private final WebClientHelper webClientBuilder;

  @Value("${pokemon.url}")
  private String url;

  public List<Pokemon> getAll(int offset, int limit) {
    Pokemon[] pokemons = webClientBuilder.builder()
        .build()
        .get()
        .uri(url + "?offset=" + offset + "&limit=" + limit)
        .exchange()
        .timeout(Duration.ofMillis(70_000))
        .flatMap(
            response -> response.bodyToMono(PokemonResume.class).map(PokemonResume::getResults))
        .block();

    if (pokemons == null) {
      return null;
    } else {
      return Arrays.stream(pokemons).collect(Collectors.toList());
    }
  }
}

package com.example.demo.DTO;

import com.example.demo.domain.Pokemon;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PokemonResume {

  private int count;
  private Pokemon[] results;
}

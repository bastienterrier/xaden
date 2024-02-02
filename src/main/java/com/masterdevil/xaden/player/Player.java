package com.masterdevil.xaden.player;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Player {

  private String name;
  private int level;

  public Player(String name) {
    this.name = name;
    this.level = 1;
  }
}

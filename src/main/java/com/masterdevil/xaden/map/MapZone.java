package com.masterdevil.xaden.map;

import static io.vavr.API.None;

import com.masterdevil.xaden.monster.Monster;
import io.vavr.control.Option;

public record MapZone(String topology, int minLevel, Option<Monster> maybeMonster) {

  public MapZone(String topology, int minLevel) {
    this(topology, minLevel, None());
  }

  @Override
  public String toString() {
    return String.format("%s - [lvl >= %d]", topology, minLevel);
  }
}

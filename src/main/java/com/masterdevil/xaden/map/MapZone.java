package com.masterdevil.xaden.map;

public record MapZone(String topology, int minLevel) {

  @Override
  public String toString() {
    return String.format("%s - [lvl >= %d]", topology, minLevel);
  }
}

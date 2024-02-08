package com.masterdevil.xaden.map;

import io.vavr.collection.List;
import lombok.Getter;

@Getter
public class Map {

  private final List<List<MapZone>> zones;
  private final int width;
  private final int height;

  public Map(List<List<MapZone>> zones) {
    this.zones = zones;
    this.width = zones.head().size();
    this.height = zones.size();
  }

}

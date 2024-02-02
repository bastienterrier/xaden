package com.masterdevil.xaden.map.fixtures;

import static io.vavr.API.List;

import com.masterdevil.xaden.map.Map;
import com.masterdevil.xaden.map.MapZone;

public class MapFixture {

  static MapZone PLAIN = new MapZone("plain", 1);
  static MapZone MOUNTAIN = new MapZone("mountain", 10);
  public static Map MAP = new Map(
    List(
      List(PLAIN, PLAIN, MOUNTAIN),
      List(PLAIN, PLAIN, MOUNTAIN)
    ));

}

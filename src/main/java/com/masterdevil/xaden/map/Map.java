package com.masterdevil.xaden.map;

import static io.vavr.API.Some;

import com.masterdevil.xaden.monster.Monster;
import io.vavr.API;
import io.vavr.Tuple2;
import io.vavr.collection.List;
import io.vavr.control.Either;
import lombok.Getter;

@Getter
public class Map {

  private static final MapZone PLAIN = new MapZone("plain", 1, Some(Monster.BISON));
  private static final MapZone MOUNTAIN = new MapZone("mountain", 10);
  public static final Map DEFAULT_MAP = new Map(
    API.List(
      API.List(PLAIN, PLAIN, MOUNTAIN),
      API.List(PLAIN, PLAIN, MOUNTAIN)
    ));

  private final List<List<MapZone>> zones;
  private final int width;
  private final int height;

  public Map(List<List<MapZone>> zones) {
    this.zones = zones;
    this.width = zones.head().size();
    this.height = zones.size();
  }

  public Either<Exception, MapZone> getZone(Tuple2<Integer, Integer> coordinates) {
    return API.Try(() -> zones.get(coordinates._1).get(coordinates._2))
      .toEither(new Exception("The zone does not exist"));
  }

}

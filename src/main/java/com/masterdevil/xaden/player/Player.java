package com.masterdevil.xaden.player;

import static com.masterdevil.xaden.domain.Unit.UNIT;

import com.masterdevil.xaden.domain.Unit;
import com.masterdevil.xaden.player.map.Direction;
import com.masterdevil.xaden.player.map.Map;
import com.masterdevil.xaden.player.map.MapZone;
import io.vavr.API;
import io.vavr.Tuple2;
import io.vavr.control.Either;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Player {

  /**
   * Refactor default MAP
   */
  private static final MapZone PLAIN = new MapZone("plain", 1);
  private static final MapZone MOUNTAIN = new MapZone("mountain", 10);
  private static final Map DEFAULT_MAP = new Map(
    API.List(
      API.List(PLAIN, PLAIN, MOUNTAIN),
      API.List(PLAIN, PLAIN, MOUNTAIN)
    ));

  private UUID id;
  private String name;
  private int level;
  private Tuple2<Integer, Integer> coordinates;
  private Map map;

  public Player(String name) {
    this.name = name;
    this.level = 1;
    this.id = UUID.randomUUID();
    this.coordinates = new Tuple2<>(0, 0);
    this.map = DEFAULT_MAP;
  }

  static Tuple2<Integer, Integer> getTargetedLocation(Direction direction, Tuple2<Integer, Integer> coordinates) {
    int targetX = coordinates._1;
    int targetY = coordinates._2;

    switch (direction) {
      case NORTH -> targetX--;
      case EAST -> targetY++;
      case SOUTH -> targetX++;
      case WEST -> targetY--;
    }

    return new Tuple2<>(targetX, targetY);
  }

  public Either<Exception, Unit> navigateTo(Direction direction) {
    Tuple2<Integer, Integer> targetCoordinates = getTargetedLocation(direction, coordinates);

    if (targetCoordinates._1 < 0 || targetCoordinates._1 >= map.getHeight()
      || targetCoordinates._2 < 0 || targetCoordinates._2 >= map.getWidth()
    ) {
      return API.Left(new Exception("Invalid map bounds"));
    }

    if (map.getZones()
      .get(targetCoordinates._1)
      .get(targetCoordinates._2)
      .minLevel() > level) {
      return API.Left(new Exception("Player do not have the required level to access the zone"));
    }

    coordinates = new Tuple2<>(targetCoordinates._1, targetCoordinates._2);

    return API.Right(UNIT);
  }

  @Override
  public String toString() {
    return String.format("---- %s - lvl. %d [%d;%d] ----", name, level, coordinates._1, coordinates._2);
  }
}

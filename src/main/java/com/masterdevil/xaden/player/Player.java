package com.masterdevil.xaden.player;

import static com.masterdevil.xaden.domain.Unit.UNIT;
import static io.vavr.API.List;

import com.masterdevil.xaden.domain.Fightable;
import com.masterdevil.xaden.domain.Unit;
import com.masterdevil.xaden.map.Direction;
import com.masterdevil.xaden.map.Map;
import io.vavr.API;
import io.vavr.Tuple2;
import io.vavr.control.Either;
import java.util.UUID;
import lombok.Getter;

@Getter
public class Player extends Fightable {

  private final UUID id;
  private final String name;
  private Tuple2<Integer, Integer> coordinates;
  //TODO: Add `race` which contain all skills

  public Player(String name) {
    super(1, 50, 10, List(
      //TODO: use `race.getSkills()` here
    ));
    this.name = name;
    this.id = UUID.randomUUID();
    this.coordinates = new Tuple2<>(0, 0);
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

  public Either<Exception, Unit> navigateTo(Direction direction, Map map) {
    Tuple2<Integer, Integer> targetCoordinates = getTargetedLocation(direction, coordinates);

    if (targetCoordinates._1 < 0 || targetCoordinates._1 >= map.getHeight()
      || targetCoordinates._2 < 0 || targetCoordinates._2 >= map.getWidth()
    ) {
      return API.Left(new Exception("Invalid map bounds"));
    }

    if (map.getZones()
      .get(targetCoordinates._1)
      .get(targetCoordinates._2)
      .minLevel() > getLevel()) {
      return API.Left(new Exception("Player do not have the required level to access the zone"));
    }

    coordinates = new Tuple2<>(targetCoordinates._1, targetCoordinates._2);

    return API.Right(UNIT);
  }

  @Override
  public String toString() {
    return String.format("---- %s - lvl. %d - hp. %d - [%d;%d] ----", name, getLevel(), getHp(), coordinates._1,
      coordinates._2);
  }
}

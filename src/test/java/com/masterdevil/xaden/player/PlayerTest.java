package com.masterdevil.xaden.player;

import static org.assertj.core.api.Assertions.assertThat;

import com.masterdevil.xaden.domain.Unit;
import com.masterdevil.xaden.map.Direction;
import com.masterdevil.xaden.map.fixtures.MapFixture;
import io.vavr.Tuple2;
import io.vavr.control.Either;
import org.junit.jupiter.api.Test;

class PlayerTest {

  private static void assertBoundsError(Either<Exception, Unit> result) {
    assertThat(result.isLeft()).isTrue();
    assertThat(result.getLeft().getMessage()).isEqualTo("Invalid map bounds");
  }

  @Test
  void getTargetedLocation() {
    assertThat(Player.getTargetedLocation(Direction.NORTH, new Tuple2<>(0, 0))).isEqualTo(new Tuple2<>(-1, 0));
    assertThat(Player.getTargetedLocation(Direction.EAST, new Tuple2<>(0, 0))).isEqualTo(new Tuple2<>(0, 1));
    assertThat(Player.getTargetedLocation(Direction.SOUTH, new Tuple2<>(0, 0))).isEqualTo(new Tuple2<>(1, 0));
    assertThat(Player.getTargetedLocation(Direction.WEST, new Tuple2<>(0, 0))).isEqualTo(new Tuple2<>(0, -1));
  }

  @Test
  void navigateTo_invalidBounds() {
    Player player = new Player("Masterdevil");

    assertBoundsError(player.navigateTo(Direction.WEST, MapFixture.MAP));
    assertBoundsError(player.navigateTo(Direction.NORTH, MapFixture.MAP));
  }

  @Test
  void navigateTo_invalidLevel() {
    Player player = new Player("Masterdevil");

    player.navigateTo(Direction.EAST, MapFixture.MAP);

    Either<Exception, Unit> result = player.navigateTo(Direction.EAST, MapFixture.MAP);

    assertThat(result.isLeft()).isTrue();
    assertThat(result.getLeft().getMessage()).isEqualTo("Player do not have the required level to access the zone");
  }

  @Test
  void navigateTo_success() {
    Player player = new Player("Masterdevil");

    Either<Exception, Unit> result = player.navigateTo(Direction.EAST, MapFixture.MAP);

    assertThat(result.isRight()).isTrue();
    assertThat(player.getCoordinates()).isEqualTo(new Tuple2<>(0, 1));
  }

  @Test
  void toString_override() {
    Player player = new Player("Masterdevil");

    assertThat(player).hasToString("---- Masterdevil - lvl. 1 [0;0] ----");
  }
}

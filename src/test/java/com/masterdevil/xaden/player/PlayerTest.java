package com.masterdevil.xaden.player;

import static com.masterdevil.xaden.map.fixtures.MapFixture.MAP;
import static org.assertj.core.api.Assertions.assertThat;

import com.masterdevil.xaden.domain.Unit;
import com.masterdevil.xaden.player.map.Direction;
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
    Player player = new Player("Masterdevil", MAP);

    assertBoundsError(player.navigateTo(Direction.WEST));
    assertBoundsError(player.navigateTo(Direction.NORTH));
  }

  @Test
  void navigateTo_invalidLevel() {
    Player player = new Player("Masterdevil", MAP);

    player.navigateTo(Direction.EAST);

    Either<Exception, Unit> result = player.navigateTo(Direction.EAST);

    assertThat(result.isLeft()).isTrue();
    assertThat(result.getLeft().getMessage()).isEqualTo("Player do not have the required level to access the zone");
  }

  @Test
  void navigateTo_success() {
    Player player = new Player("Masterdevil", MAP);

    Either<Exception, Unit> result = player.navigateTo(Direction.EAST);

    assertThat(result.isRight()).isTrue();
    assertThat(player.getCoordinates()).isEqualTo(new Tuple2<>(0, 1));
  }
}

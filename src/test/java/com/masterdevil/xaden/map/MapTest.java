package com.masterdevil.xaden.map;

import static com.masterdevil.xaden.map.fixtures.MapFixture.MAP;
import static com.masterdevil.xaden.map.fixtures.MapFixture.MOUNTAIN;
import static com.masterdevil.xaden.map.fixtures.MapFixture.PLAIN;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import io.vavr.Tuple2;
import io.vavr.control.Either;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MapTest {

  private static Stream<Arguments> zoneEntries() {
    return Stream.of(
      arguments(new Tuple2<>(0, 0), PLAIN),
      arguments(new Tuple2<>(0, 1), PLAIN),
      arguments(new Tuple2<>(0, 2), MOUNTAIN),
      arguments(new Tuple2<>(1, 0), PLAIN),
      arguments(new Tuple2<>(1, 1), PLAIN),
      arguments(new Tuple2<>(1, 2), MOUNTAIN)
    );
  }

  @Test
  void constructor() {
    assertThat(MAP.getWidth()).isEqualTo(3);
    assertThat(MAP.getHeight()).isEqualTo(2);
  }

  @Test
  void getZone_failure() {
    Either<Exception, MapZone> result = MAP.getZone(new Tuple2<>(2, 1));

    assertThat(result.isLeft()).isTrue();
    assertThat(result.getLeft().getMessage()).isEqualTo("The zone does not exist");
  }

  @ParameterizedTest
  @MethodSource("zoneEntries")
  void getZone_success(Tuple2<Integer, Integer> coordinates, MapZone expected) {
    Either<Exception, MapZone> result = MAP.getZone(coordinates);

    assertThat(result.isRight()).isTrue();
    assertThat(result.get()).isEqualTo(expected);
  }
}

package com.masterdevil.xaden.map;

import static com.masterdevil.xaden.map.fixtures.MapFixture.MAP;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class MapTest {

  @Test
  void constructor() {
    assertThat(MAP.getWidth()).isEqualTo(3);
    assertThat(MAP.getHeight()).isEqualTo(2);
  }
}

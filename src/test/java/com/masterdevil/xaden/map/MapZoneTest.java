package com.masterdevil.xaden.map;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class MapZoneTest {

  @Test
  void testToString() {
    MapZone cut = new MapZone("plain", 10);

    assertThat(cut).hasToString("plain - [lvl >= 10]");
  }
}

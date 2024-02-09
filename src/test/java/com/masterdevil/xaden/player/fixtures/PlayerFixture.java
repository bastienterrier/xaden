package com.masterdevil.xaden.player.fixtures;

import com.masterdevil.xaden.player.Player;
import com.masterdevil.xaden.player.Race;

public class PlayerFixture {

  public static Player MASTERDEVIL() {
    return new Player("Masterdevil", Race.SWORDSMAN);
  }

  public static Player APARK() {
    return new Player("Apark", Race.BOWMAN);
  }

}

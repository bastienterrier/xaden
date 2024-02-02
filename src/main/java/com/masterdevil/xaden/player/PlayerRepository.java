package com.masterdevil.xaden.player;

import java.util.List;

public interface PlayerRepository {

  List<Player> getAll();

  Player getById();
}

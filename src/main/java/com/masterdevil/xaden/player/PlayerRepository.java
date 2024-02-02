package com.masterdevil.xaden.player;

import io.vavr.collection.List;
import io.vavr.control.Option;
import java.util.UUID;

public interface PlayerRepository {

  List<Player> getAll();

  Option<Player> getSelectedPlayer();

  void setSelectedPlayer(UUID id);
}

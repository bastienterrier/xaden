package com.masterdevil.xaden.player;

import io.vavr.collection.List;
import java.util.UUID;

public interface PlayerRepository {

  List<Player> getAll();

  Player getById(UUID id);
}

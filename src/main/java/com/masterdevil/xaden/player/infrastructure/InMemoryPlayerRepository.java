package com.masterdevil.xaden.player.infrastructure;

import com.masterdevil.xaden.player.Player;
import com.masterdevil.xaden.player.PlayerRepository;
import io.vavr.collection.List;
import java.util.UUID;

public class InMemoryPlayerRepository implements PlayerRepository {

  private final List<Player> players = List.of(
    new Player(UUID.randomUUID(), "Masterdevil", 50),
    new Player(UUID.randomUUID(), "Apark", 68),
    new Player(UUID.randomUUID(), "Lanquemar", 99)
  );

  @Override
  public List<Player> getAll() {
    return players;
  }

  @Override
  public Player getById(UUID id) {
    return null;
  }
}

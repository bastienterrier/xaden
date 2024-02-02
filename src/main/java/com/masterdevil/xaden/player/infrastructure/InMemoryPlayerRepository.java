package com.masterdevil.xaden.player.infrastructure;

import com.masterdevil.xaden.player.Player;
import com.masterdevil.xaden.player.PlayerRepository;
import java.util.List;

public class InMemoryPlayerRepository implements PlayerRepository {

  private final List<Player> players = List.of(
    new Player("Masterdevil", 50),
    new Player("Apark", 68),
    new Player("Lanquemar", 99)
  );

  @Override
  public List<Player> getAll() {
    return players;
  }

  @Override
  public Player getById() {
    return null;
  }
}

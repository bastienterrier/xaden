package com.masterdevil.xaden.player.infrastructure;

import com.masterdevil.xaden.player.Player;
import com.masterdevil.xaden.player.PlayerRepository;
import io.vavr.collection.List;
import io.vavr.control.Option;
import java.util.UUID;

public class InMemoryPlayerRepository implements PlayerRepository {

  private final List<Player> players = List.of(
    new Player(UUID.randomUUID(), "Masterdevil", 50),
    new Player(UUID.randomUUID(), "Apark", 68),
    new Player(UUID.randomUUID(), "Lanquemar", 99)
  );

  private UUID selectedPlayerID;

  @Override
  public List<Player> getAll() {
    return players;
  }

  @Override
  public Option<Player> getSelectedPlayer() {
    return players.find(player -> player.getId().equals(selectedPlayerID));
  }

  @Override
  public void setSelectedPlayer(UUID id) {
    this.selectedPlayerID = id;
  }
}

package com.masterdevil.xaden.player.infrastructure;

import com.masterdevil.xaden.player.Player;
import com.masterdevil.xaden.player.PlayerRepository;
import com.masterdevil.xaden.player.map.Map;
import com.masterdevil.xaden.player.map.MapZone;
import io.vavr.API;
import io.vavr.collection.List;
import io.vavr.control.Option;
import java.util.UUID;

public class InMemoryPlayerRepository implements PlayerRepository {

  private static MapZone PLAIN = new MapZone("plain", 1);
  private static MapZone MOUNTAIN = new MapZone("mountain", 10);
  private static Map MAP = new Map(
    API.List(
      API.List(PLAIN, PLAIN, MOUNTAIN),
      API.List(PLAIN, PLAIN, MOUNTAIN)
    ));

  private final List<Player> players = List.of(
    new Player("Masterdevil", MAP)
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

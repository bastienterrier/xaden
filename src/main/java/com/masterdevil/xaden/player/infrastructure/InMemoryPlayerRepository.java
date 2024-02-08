package com.masterdevil.xaden.player.infrastructure;

import static com.masterdevil.xaden.domain.Unit.UNIT;
import static io.vavr.API.Right;

import com.masterdevil.xaden.domain.Unit;
import com.masterdevil.xaden.player.Player;
import com.masterdevil.xaden.player.PlayerRepository;
import io.vavr.collection.List;
import io.vavr.control.Either;
import io.vavr.control.Option;
import java.util.UUID;

public class InMemoryPlayerRepository implements PlayerRepository {

  private List<Player> players = List.empty();

  private UUID selectedPlayerID;

  @Override
  public Either<Exception, List<Player>> getAll() {
    return Right(players);
  }

  @Override
  public Either<Exception, Option<Player>> getSelectedPlayer() {
    return Right(players.find(player -> player.getId().equals(selectedPlayerID)));
  }

  @Override
  public Either<Exception, Unit> setSelectedPlayer(UUID id) {
    this.selectedPlayerID = id;
    return Right(UNIT);
  }

  @Override
  public Either<Exception, Unit> save(Player player) {
    players = players.append(player);

    return Either.right(UNIT);
  }
}

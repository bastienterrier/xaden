package com.masterdevil.xaden.player;

import com.masterdevil.xaden.domain.Unit;
import io.vavr.collection.List;
import io.vavr.control.Either;
import io.vavr.control.Option;
import java.util.UUID;

public interface PlayerRepository {

  Either<Exception, List<Player>> getAll();

  Either<Exception, Option<Player>> getSelectedPlayer();

  Either<Exception, Unit> setSelectedPlayer(UUID id);

  Either<Exception, Unit> save(Player player);
}

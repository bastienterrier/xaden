package com.masterdevil.xaden.player.application;

import com.masterdevil.xaden.io.Displayable;
import com.masterdevil.xaden.io.Input;
import com.masterdevil.xaden.io.Output;
import com.masterdevil.xaden.player.PlayerRepository;
import io.vavr.control.Either;
import org.springframework.stereotype.Component;

@Component
public class SelectOrCreatePlayerUseCase extends Displayable {

  private final PlayerRepository playerRepository;

  public SelectOrCreatePlayerUseCase(Input input, Output output, PlayerRepository playerRepository) {
    super(input, output);
    this.playerRepository = playerRepository;
  }

  @Override
  public Either<Exception, Class<? extends Displayable>> show() {
    return playerRepository.getAll()
      .map(players -> players.isEmpty()
        ? CreatePlayerUseCase.class
        : SelectPlayerUseCase.class);
  }
}

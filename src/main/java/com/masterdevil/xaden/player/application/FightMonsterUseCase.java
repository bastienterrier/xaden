package com.masterdevil.xaden.player.application;

import com.masterdevil.xaden.io.Displayable;
import com.masterdevil.xaden.io.Input;
import com.masterdevil.xaden.io.Output;
import com.masterdevil.xaden.menu.application.DisplayMenuUseCase;
import com.masterdevil.xaden.player.PlayerRepository;
import io.vavr.API;
import io.vavr.control.Either;
import org.springframework.stereotype.Component;

@Component
public class FightMonsterUseCase extends Displayable {

  private final PlayerRepository playerRepository;

  public FightMonsterUseCase(Input input, Output output, PlayerRepository playerRepository) {
    super(input, output);
    this.playerRepository = playerRepository;
  }

  @Override
  public Either<Exception, Class<? extends Displayable>> show() {
    return API.Right(DisplayMenuUseCase.class);
  }
}

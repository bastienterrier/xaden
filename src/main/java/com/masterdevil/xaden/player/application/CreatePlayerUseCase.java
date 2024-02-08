package com.masterdevil.xaden.player.application;

import com.masterdevil.xaden.io.Displayable;
import com.masterdevil.xaden.io.Input;
import com.masterdevil.xaden.io.Output;
import com.masterdevil.xaden.player.Player;
import com.masterdevil.xaden.player.PlayerRepository;
import io.vavr.control.Either;
import org.springframework.stereotype.Component;

@Component
public class CreatePlayerUseCase extends Displayable {

  private final PlayerRepository playerRepository;

  public CreatePlayerUseCase(Input input, Output output, PlayerRepository playerRepository) {
    super(input, output);
    this.playerRepository = playerRepository;
  }

  @Override
  public Either<Exception, Class<? extends Displayable>> show() {

    output.display("Please enter your player name");
    String playerName = input.getString();

    return playerRepository.save(new Player(playerName))
      .map(ignored -> SelectPlayerUseCase.class);
  }
}

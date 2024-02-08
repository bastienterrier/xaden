package com.masterdevil.xaden.menu.application;

import com.masterdevil.xaden.io.Displayable;
import com.masterdevil.xaden.io.Input;
import com.masterdevil.xaden.io.Output;
import com.masterdevil.xaden.player.Player;
import com.masterdevil.xaden.player.PlayerRepository;
import com.masterdevil.xaden.player.application.NavigateUseCase;
import com.masterdevil.xaden.player.application.SelectPlayerUseCase;
import io.vavr.API;
import io.vavr.control.Either;
import io.vavr.control.Option;
import org.springframework.stereotype.Component;

@Component
public class DisplayMenuUseCase extends Displayable {

  private final PlayerRepository playerRepository;

  public DisplayMenuUseCase(Input input, Output output, PlayerRepository playerRepository) {
    super(input, output);
    this.playerRepository = playerRepository;
  }

  @Override
  public Either<Exception, Class<? extends Displayable>> show() {
    Option<Player> maybePlayer = playerRepository.getSelectedPlayer().get();

    if (maybePlayer.isEmpty()) {
      return API.Right(SelectPlayerUseCase.class);
    }

    Player player = maybePlayer.get();

    output.display(player.toString());
    output.display("What do you wanna do?");
    output.display("1. Let's move");
    output.display("2. See my inventory");
    output.display("3. Exit game");

    return API.Right(switch (input.getInt()) {
      case 1:
        yield NavigateUseCase.class;
      default:
        yield DisplayMenuUseCase.class;
    });
  }

}

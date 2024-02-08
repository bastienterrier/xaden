package com.masterdevil.xaden.player.application;

import com.masterdevil.xaden.io.Displayable;
import com.masterdevil.xaden.io.Input;
import com.masterdevil.xaden.io.Output;
import com.masterdevil.xaden.map.Direction;
import com.masterdevil.xaden.map.Map;
import com.masterdevil.xaden.menu.application.DisplayMenuUseCase;
import com.masterdevil.xaden.player.Player;
import com.masterdevil.xaden.player.PlayerRepository;
import io.vavr.API;
import io.vavr.control.Either;
import org.springframework.stereotype.Component;

@Component
public class NavigateUseCase extends Displayable {

  private final PlayerRepository playerRepository;

  public NavigateUseCase(Input input, Output output, PlayerRepository playerRepository) {
    super(input, output);
    this.playerRepository = playerRepository;
  }

  @Override
  public Either<Exception, Class<? extends Displayable>> show() {
    Player player = playerRepository.getSelectedPlayer().get().get();

    output.display("1. Go North");
    output.display("2. Go East");
    output.display("3. Go South");
    output.display("4. Go West");
    output.display("5. Exit");

    Direction direction = switch (input.getInt()) {
      case 1 -> Direction.NORTH;
      case 2 -> Direction.EAST;
      case 3 -> Direction.SOUTH;
      case 4 -> Direction.WEST;
      default -> null;
    };

    return API.Right(direction != null
      ? player.navigateTo(direction, Map.DEFAULT_MAP)
      .map(ignored -> DisplayMenuUseCase.class)
      .peekLeft(error -> output.display(error.getMessage()))
      .getOrElse(DisplayMenuUseCase.class) //TODO use navigate
      : DisplayMenuUseCase.class);
  }
}

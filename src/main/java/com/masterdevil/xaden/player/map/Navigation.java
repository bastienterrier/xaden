package com.masterdevil.xaden.player.map;

import com.masterdevil.xaden.io.Displayable;
import com.masterdevil.xaden.io.Input;
import com.masterdevil.xaden.io.Output;
import com.masterdevil.xaden.player.Player;
import com.masterdevil.xaden.player.PlayerRepository;
import org.springframework.stereotype.Component;

@Component
public class Navigation extends Displayable {

  private final PlayerRepository playerRepository;

  public Navigation(Input input, Output output, PlayerRepository playerRepository) {
    super(input, output);
    this.playerRepository = playerRepository;
  }

  @Override
  public String show() {
    Player player = playerRepository.getSelectedPlayer().get();

    output.display("1. Go North");
    output.display("2. Go East");
    output.display("3. Go South");
    output.display("4. Go West");

    Direction direction = switch (input.getInt()) {
      case 1 -> Direction.NORTH;
      case 2 -> Direction.EAST;
      case 3 -> Direction.SOUTH;
      default -> Direction.WEST;
    };

    return player.navigateTo(direction)
      .map(ignored -> "menu")
      .peekLeft(error -> output.display(error.getMessage()))
      .getOrElse("navigation");
  }
}

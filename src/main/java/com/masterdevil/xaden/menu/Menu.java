package com.masterdevil.xaden.menu;

import com.masterdevil.xaden.io.Displayable;
import com.masterdevil.xaden.io.Input;
import com.masterdevil.xaden.io.Output;
import com.masterdevil.xaden.player.Player;
import com.masterdevil.xaden.player.PlayerRepository;
import io.vavr.control.Option;
import org.springframework.stereotype.Component;

@Component
public class Menu extends Displayable {

  private final PlayerRepository playerRepository;

  public Menu(Input input, Output output, PlayerRepository playerRepository) {
    super(input, output);
    this.playerRepository = playerRepository;
  }

  @Override
  public String show() {
    Option<Player> maybePlayer = playerRepository.getSelectedPlayer();

    if (maybePlayer.isEmpty()) {
      return "player-selection";
    }

    Player player = maybePlayer.get();

    output.display(String.format("---- %s - lvl. %d ---- ", player.getName(), player.getLevel()));
    output.display("What do you wanna do?");
    output.display("1. Let's move");
    output.display("2. See my inventory");
    output.display("3. Exit game");

    return switch (input.getInt()) {
      case 1:
        yield "navigation";
      default:
        yield "";
    };
  }

}

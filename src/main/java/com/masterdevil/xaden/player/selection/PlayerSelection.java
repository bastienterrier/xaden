package com.masterdevil.xaden.player.selection;

import com.masterdevil.xaden.io.Displayable;
import com.masterdevil.xaden.io.Input;
import com.masterdevil.xaden.io.Output;
import com.masterdevil.xaden.player.Player;
import com.masterdevil.xaden.player.PlayerRepository;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class PlayerSelection extends Displayable {

  private final PlayerRepository playerRepository;

  public PlayerSelection(Input input, Output output, PlayerRepository playerRepository) {
    super(input, output);
    this.playerRepository = playerRepository;
  }

  @Override
  public void show() {
    int cpt = 1;
    output.display("Select your player");
    List<Player> players = playerRepository.getAll();

    for (Player player : players) {
      output.display(String.format("%d - %s (lvl. %d)", cpt, player.getName(), player.getLevel()));
      cpt++;
    }

    int selectedUserIndex = 0;
    do {
      selectedUserIndex = input.getInt();
    } while (selectedUserIndex < 1 || selectedUserIndex > players.size());

    Player player = players.get(selectedUserIndex - 1);

    output.display("You're now playing " + player.getName());

  }
}

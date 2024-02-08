package com.masterdevil.xaden.player.application;

import com.masterdevil.xaden.io.Displayable;
import com.masterdevil.xaden.io.Input;
import com.masterdevil.xaden.io.Output;
import com.masterdevil.xaden.player.Player;
import com.masterdevil.xaden.player.PlayerRepository;
import io.vavr.collection.List;
import org.springframework.stereotype.Component;

@Component
public class SelectPlayerUseCase extends Displayable {

  private final PlayerRepository playerRepository;

  public SelectPlayerUseCase(Input input, Output output, PlayerRepository playerRepository) {
    super(input, output);
    this.playerRepository = playerRepository;
  }

  @Override
  public String show() {
    playerRepository.getAll()
      .peek(this::showPlayers)
      .peek(this::selectPlayer);

    return "menu";
  }

  private void selectPlayer(List<Player> players) {
    int selectedUserIndex;
    do {
      selectedUserIndex = input.getInt();
    } while (selectedUserIndex < 1 || selectedUserIndex > players.size());

    Player selectedPlayer = players.get(selectedUserIndex - 1);

    playerRepository.setSelectedPlayer(selectedPlayer.getId());
  }

  private void showPlayers(List<Player> players) {
    int cpt = 1;
    output.display("Select your player");

    for (Player player : players) {
      output.display(String.format("%d - %s (lvl. %d)", cpt, player.getName(), player.getLevel()));
      cpt++;
    }
  }
}

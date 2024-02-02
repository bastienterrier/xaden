package com.masterdevil.xaden.io;

import com.masterdevil.xaden.menu.Menu;
import com.masterdevil.xaden.player.selection.PlayerSelection;
import org.springframework.stereotype.Component;

@Component
public class ScreenNavigation {

  private final Menu menu;
  private final PlayerSelection playerSelection;

  public ScreenNavigation(Menu menu, PlayerSelection playerSelection) {
    this.menu = menu;
    this.playerSelection = playerSelection;
  }

  /**
   * @TODO use class name instead
   */
  public String navigate(String target) {
    return switch (target) {
      case "player-selection":
        yield playerSelection.show();
      default:
        yield menu.show();
    };
  }
}

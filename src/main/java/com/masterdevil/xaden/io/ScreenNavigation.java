package com.masterdevil.xaden.io;

import com.masterdevil.xaden.map.Navigation;
import com.masterdevil.xaden.menu.Menu;
import com.masterdevil.xaden.player.selection.PlayerSelection;
import org.springframework.stereotype.Component;

@Component
public class ScreenNavigation {

  private final Menu menu;
  private final PlayerSelection playerSelection;
  private final Navigation navigation;

  public ScreenNavigation(Menu menu, PlayerSelection playerSelection, Navigation navigation) {
    this.menu = menu;
    this.playerSelection = playerSelection;
    this.navigation = navigation;
  }

  /**
   * @TODO use class name instead
   */
  public String navigate(String target) {
    return switch (target) {
      case "player-selection":
        yield playerSelection.show();
      case "navigation":
        yield navigation.show();
      default:
        yield menu.show();
    };
  }
}

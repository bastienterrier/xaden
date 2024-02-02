package com.masterdevil.xaden.io;

import com.masterdevil.xaden.menu.application.DisplayMenuUseCase;
import com.masterdevil.xaden.player.application.NavigateUseCase;
import com.masterdevil.xaden.player.application.SelectPlayerUseCase;
import org.springframework.stereotype.Component;

@Component
public class ScreenNavigation {

  private final DisplayMenuUseCase displayMenuUseCase;
  private final SelectPlayerUseCase selectPlayerUseCase;
  private final NavigateUseCase navigateUseCase;

  public ScreenNavigation(DisplayMenuUseCase displayMenuUseCase, SelectPlayerUseCase selectPlayerUseCase,
    NavigateUseCase navigateUseCase) {
    this.displayMenuUseCase = displayMenuUseCase;
    this.selectPlayerUseCase = selectPlayerUseCase;
    this.navigateUseCase = navigateUseCase;
  }

  /**
   * @TODO use class name instead
   */
  public String navigate(String target) {
    return switch (target) {
      case "player-selection":
        yield selectPlayerUseCase.show();
      case "navigation":
        yield navigateUseCase.show();
      default:
        yield displayMenuUseCase.show();
    };
  }
}

package com.masterdevil.xaden.io;

import com.masterdevil.xaden.menu.application.DisplayMenuUseCase;
import com.masterdevil.xaden.player.application.NavigateUseCase;
import com.masterdevil.xaden.player.application.SelectPlayerUseCase;
import io.vavr.control.Either;
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
   * @TODO refactor me
   */
  public <T extends Displayable> Either<Exception, Class<? extends Displayable>> navigate(Class<T> target) {
    if (target == SelectPlayerUseCase.class) {
      return selectPlayerUseCase.show();
    }
    if (target == NavigateUseCase.class) {
      return navigateUseCase.show();
    }

    return displayMenuUseCase.show();

  }
}

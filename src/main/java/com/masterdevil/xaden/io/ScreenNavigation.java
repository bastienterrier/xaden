package com.masterdevil.xaden.io;

import com.masterdevil.xaden.map.application.ExploreMapUseCase;
import com.masterdevil.xaden.menu.application.DisplayMenuUseCase;
import com.masterdevil.xaden.player.application.CreatePlayerUseCase;
import com.masterdevil.xaden.player.application.FightMonsterUseCase;
import com.masterdevil.xaden.player.application.NavigateUseCase;
import com.masterdevil.xaden.player.application.SelectOrCreatePlayerUseCase;
import com.masterdevil.xaden.player.application.SelectPlayerUseCase;
import io.vavr.control.Either;
import org.springframework.stereotype.Component;

@Component
public class ScreenNavigation {

  private final DisplayMenuUseCase displayMenuUseCase;
  private final SelectPlayerUseCase selectPlayerUseCase;
  private final NavigateUseCase navigateUseCase;
  private final SelectOrCreatePlayerUseCase selectOrCreatePlayerUseCase;
  private final CreatePlayerUseCase createPlayerUseCase;
  private final ExploreMapUseCase exploreMapUseCase;
  private final FightMonsterUseCase fightMonsterUseCase;

  public ScreenNavigation(DisplayMenuUseCase displayMenuUseCase, SelectPlayerUseCase selectPlayerUseCase,
    NavigateUseCase navigateUseCase, SelectOrCreatePlayerUseCase selectOrCreatePlayerUseCase,
    CreatePlayerUseCase createPlayerUseCase, ExploreMapUseCase exploreMapUseCase,
    FightMonsterUseCase fightMonsterUseCase) {
    this.displayMenuUseCase = displayMenuUseCase;
    this.selectPlayerUseCase = selectPlayerUseCase;
    this.navigateUseCase = navigateUseCase;
    this.selectOrCreatePlayerUseCase = selectOrCreatePlayerUseCase;
    this.createPlayerUseCase = createPlayerUseCase;
    this.exploreMapUseCase = exploreMapUseCase;
    this.fightMonsterUseCase = fightMonsterUseCase;
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
    if (target == SelectOrCreatePlayerUseCase.class) {
      return selectOrCreatePlayerUseCase.show();
    }
    if (target == CreatePlayerUseCase.class) {
      return createPlayerUseCase.show();
    }
    if (target == ExploreMapUseCase.class) {
      return exploreMapUseCase.show();
    }
    if (target == FightMonsterUseCase.class) {
      return fightMonsterUseCase.show();
    }

    return displayMenuUseCase.show();

  }
}

package com.masterdevil.xaden.map.application;

import com.masterdevil.xaden.io.Displayable;
import com.masterdevil.xaden.io.Input;
import com.masterdevil.xaden.io.Output;
import com.masterdevil.xaden.menu.application.DisplayMenuUseCase;
import com.masterdevil.xaden.player.PlayerRepository;
import io.vavr.API;
import io.vavr.Tuple2;
import io.vavr.control.Either;
import org.springframework.stereotype.Component;

@Component
public class ExploreMapUseCase extends Displayable {

  private final PlayerRepository playerRepository;

  public ExploreMapUseCase(Input input, Output output, PlayerRepository playerRepository) {
    super(input, output);
    this.playerRepository = playerRepository;
  }

  @Override
  public Either<Exception, Class<? extends Displayable>> show() {
    Tuple2<Integer, Integer> playerCoordinates = playerRepository.getSelectedPlayer().get().get().getCoordinates();

    output.display("WIP:" + playerCoordinates._1 + ";" + playerCoordinates._2);

    return API.Right(DisplayMenuUseCase.class);
  }

}

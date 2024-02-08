package com.masterdevil.xaden.io;

import io.vavr.control.Either;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public abstract class Displayable {

  protected Input input;
  protected Output output;

  public abstract Either<Exception, Class<? extends Displayable>> show();

}

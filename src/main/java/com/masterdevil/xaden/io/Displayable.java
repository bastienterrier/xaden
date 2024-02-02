package com.masterdevil.xaden.io;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public abstract class Displayable {

  protected Input input;
  protected Output output;

  abstract public void show();

}

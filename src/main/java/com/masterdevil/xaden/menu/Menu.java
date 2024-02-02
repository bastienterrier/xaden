package com.masterdevil.xaden.menu;

import com.masterdevil.xaden.io.Displayable;
import com.masterdevil.xaden.io.Input;
import com.masterdevil.xaden.io.Output;
import org.springframework.stereotype.Component;

@Component
public class Menu extends Displayable {

  public Menu(Input input, Output output) {
    super(input, output);
  }

  @Override
  public void show() {
    output.display("What do you wanna do?");
    output.display("1. Let's move");
    output.display("2. See my inventory");
    output.display("3. Exit game");

    switch (input.getInt()) {
      case 1:
        break;
      case 2:
        break;

      case 3:
        break;
      default:
        break;
    }
  }

}

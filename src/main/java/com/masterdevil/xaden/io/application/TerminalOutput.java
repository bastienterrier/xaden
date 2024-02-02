package com.masterdevil.xaden.io.application;

import com.masterdevil.xaden.io.Output;

public class TerminalOutput implements Output {

  @Override
  public void display(String message) {
    System.out.println(message);
  }
}

package com.masterdevil.xaden.io.application;

import com.masterdevil.xaden.io.Input;
import java.util.Scanner;

public class TerminalInput implements Input {

  private final Scanner innerInput = new Scanner(System.in);

  @Override
  public int getInt() {
    return innerInput.nextInt();
  }
}

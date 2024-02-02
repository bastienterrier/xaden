package com.masterdevil.xaden.application;

import com.masterdevil.xaden.io.ScreenNavigation;
import org.springframework.stereotype.Service;

@Service
public class TerminalApplication {

  private final ScreenNavigation navigation;

  public TerminalApplication(ScreenNavigation navigation) {
    this.navigation = navigation;

    System.out.println("\n" +
      " __      __       .__                                  __           ____  ___  _____  ________  ___________ _______   \n"
      +
      "/  \\    /  \\ ____ |  |   ____  ____   _____   ____   _/  |_  ____   \\   \\/  / /  _  \\ \\______ \\ \\_   _____/ \\      \\  \n"
      +
      "\\   \\/\\/   // __ \\|  | _/ ___\\/  _ \\ /     \\_/ __ \\  \\   __\\/  _ \\   \\     / /  /_\\  \\ |    |  \\ |    __)_  /   |   \\ \n"
      +
      " \\        /\\  ___/|  |_\\  \\__(  <_> )  Y Y  \\  ___/   |  | (  <_> )  /     \\/    |    \\|    `   \\|        \\/    |    \\\n"
      +
      "  \\__/\\  /  \\___  >____/\\___  >____/|__|_|  /\\___  >  |__|  \\____/  /___/\\  \\____|__  /_______  /_______  /\\____|__  /\n"
      +
      "       \\/       \\/          \\/            \\/     \\/                       \\_/       \\/        \\/        \\/         \\/ \n");

    loop("player-selection");
  }

  private void loop(String target) {
    loop(navigation.navigate(target));
  }

}

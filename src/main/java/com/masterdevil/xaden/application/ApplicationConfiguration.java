package com.masterdevil.xaden.application;

import com.masterdevil.xaden.io.application.TerminalInput;
import com.masterdevil.xaden.io.application.TerminalOutput;
import com.masterdevil.xaden.player.PlayerRepository;
import com.masterdevil.xaden.player.infrastructure.InMemoryPlayerRepository;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ApplicationConfiguration {

  @Bean
  @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
  public TerminalInput terminalInput() {
    return new TerminalInput();
  }

  @Bean
  @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
  public TerminalOutput terminalOutput() {
    return new TerminalOutput();
  }

  @Bean
  public PlayerRepository playerRepository() {
    return new InMemoryPlayerRepository();
  }
}

package com.masterdevil.xaden.domain;

import static org.assertj.core.api.Assertions.assertThat;

import io.vavr.API;
import io.vavr.control.Either;
import org.junit.jupiter.api.Test;

class FightableTest {

  @Test
  void attack() {

    AnyFightable entity = new AnyFightable(1, 10, 10);
    AnyFightable target = new AnyFightable(1, 15, 15);

    Either<Exception, Unit> result = entity.attack(target);

    assertThat(result.isLeft()).isTrue();
    assertThat(result.getLeft().getMessage()).isEqualTo("Not implemented yet");
  }

  static class AnyFightable extends Fightable {

    public AnyFightable(int level, int hp, int mana) {
      super(level, hp, mana, API.List());
    }
  }
}

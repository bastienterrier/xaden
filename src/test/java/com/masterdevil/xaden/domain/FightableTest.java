package com.masterdevil.xaden.domain;

import static com.masterdevil.xaden.domain.Unit.UNIT;
import static com.masterdevil.xaden.player.fixtures.PlayerFixture.APARK;
import static com.masterdevil.xaden.player.fixtures.PlayerFixture.MASTERDEVIL;
import static org.assertj.core.api.Assertions.assertThat;

import com.masterdevil.xaden.player.Player;
import io.vavr.control.Either;
import org.junit.jupiter.api.Test;

class FightableTest {

  private static final Skill SKILL = new Skill("skill name", 1);

  @Test
  void attack() {
    Player entity = MASTERDEVIL();
    Player target = APARK();

    Either<Exception, Unit> result = entity.attack(SKILL, target);

    assertThat(result.isLeft()).isTrue();
    assertThat(result.getLeft().getMessage()).isEqualTo("Not implemented yet");
  }

  @Test
  void suffer_negativeDamage() {
    Either<Exception, Unit> suffer = MASTERDEVIL().suffer(-1);

    assertThat(suffer.isLeft()).isTrue();
    assertThat(suffer.getLeft().getMessage()).isEqualTo("Cannot suffer negative damage");
  }

  @Test
  void suffer_inHpRange() {
    Player cut = MASTERDEVIL();

    Either<Exception, Unit> suffer = cut.suffer(10);

    assertThat(suffer.isRight()).isTrue();
    assertThat(suffer.get()).isEqualTo(UNIT);

    assertThat(cut.getHp()).isEqualTo(40);
  }

  @Test
  void suffer_outOfHpRange() {
    Player cut = MASTERDEVIL();

    Either<Exception, Unit> suffer = cut.suffer(100);

    assertThat(suffer.isRight()).isTrue();
    assertThat(suffer.get()).isEqualTo(UNIT);

    assertThat(cut.getHp()).isZero();
  }
}

package com.masterdevil.xaden.domain;

import static com.masterdevil.xaden.domain.Unit.UNIT;
import static com.masterdevil.xaden.player.fixtures.PlayerFixture.APARK;
import static com.masterdevil.xaden.player.fixtures.PlayerFixture.MASTERDEVIL;
import static org.assertj.core.api.Assertions.assertThat;

import com.masterdevil.xaden.player.Player;
import com.masterdevil.xaden.player.Race;
import io.vavr.control.Either;
import org.junit.jupiter.api.Test;

class FightableTest {

  private static final Skill INVALID_SKILL = new Skill("skill name", 1);

  @Test
  void attack_invalidSkill() {
    Player entity = MASTERDEVIL();
    Player target = APARK();

    Either<Exception, Unit> result = entity.attack(INVALID_SKILL, target);

    assertThat(result.isLeft()).isTrue();
    assertThat(result.getLeft().getMessage()).isEqualTo("This skill does not belong to the entity");
  }

  @Test
  void attack_tooHighSkill() {
    Player entity = MASTERDEVIL();
    Player target = APARK();
    Skill tooHighSkill = Race.SWORDSMAN.skills().last();

    Either<Exception, Unit> result = entity.attack(tooHighSkill, target);

    assertThat(result.isLeft()).isTrue();
    assertThat(result.getLeft().getMessage()).isEqualTo(
      "The entity does not have the sufficient level to use this skill");
  }

  @Test
  void attack_notEnoughMana() {
    Player entity = MASTERDEVIL();
    Player target = APARK();
    Skill skill = Race.SWORDSMAN.skills().head();

    entity.attack(skill, target);
    entity.attack(skill, target);
    entity.attack(skill, target);

    Either<Exception, Unit> result = entity.attack(skill, target);

    assertThat(result.isLeft()).isTrue();
    assertThat(result.getLeft().getMessage()).isEqualTo(
      "The entity does not have the sufficient mana to use this skill");
  }

  @Test
  void attack_success() {
    Player entity = MASTERDEVIL();
    Player target = APARK();
    int initialEntityHp = entity.getHp();
    int initialEntityMana = entity.getMana();
    int initialTargetHp = target.getHp();
    Skill skill = Race.SWORDSMAN.skills().head();

    Either<Exception, Unit> result = entity.attack(skill, target);

    int remainingEntityMana = entity.getMana();

    assertThat(result.isRight()).isTrue();
    assertThat(result.get()).isEqualTo(UNIT);

    assertThat(initialTargetHp).isGreaterThan(target.getHp());
    assertThat(initialEntityHp).isEqualTo(entity.getHp());
    assertThat(initialEntityMana).isGreaterThan(remainingEntityMana);
    assertThat(remainingEntityMana).isNotNegative();
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

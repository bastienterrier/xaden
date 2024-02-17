package com.masterdevil.xaden.domain;

import static com.masterdevil.xaden.domain.Unit.UNIT;
import static io.vavr.API.Left;
import static io.vavr.API.Right;

import io.vavr.collection.List;
import io.vavr.control.Either;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public abstract class Fightable {

  private int level;
  private int hp;
  private int maxHp;
  private int mana;
  private int maxMana;
  private List<Skill> skills;

  /**
   * Applies the amount of damage caused by the entity's skill to the {@code target} hp.
   */
  public Either<Exception, Unit> attack(Skill skill, Fightable target) {
    if (!skills.contains(skill)) {
      return Left(new Exception("This skill does not belong to the entity"));
    }

    if (skill.unlockLevel() > level) {
      return Left(new Exception("The entity does not have the sufficient level to use this skill"));
    }

    if (mana < skill.requiredMana()) {
      return Left(new Exception("The entity does not have the sufficient mana to use this skill"));
    }

    /**
     * TODO
     * Step 1. Use randomness
     * Step 2. Use entity characteristic (strength, ...)
     */
    int damage = skill.baseDamage();

    mana = Math.max(mana - skill.requiredMana(), 0);

    return target.suffer(damage);
  }

  public Either<Exception, Unit> suffer(int damage) {
    if (damage < 0) {
      return Left(new Exception("Cannot suffer negative damage"));
    }

    if (damage >= hp) {
      hp = 0;
    } else {
      hp = hp - damage;
    }

    return Right(UNIT);
  }
}

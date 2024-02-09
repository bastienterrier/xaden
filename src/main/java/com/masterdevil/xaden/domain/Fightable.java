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
  private int availableHp;
  private int mana;
  private int availableMana;
  private List<Skill> skills;

  /**
   * Applies the amount of damage caused by the entity's skill to the {@code target} hp.
   */
  public Either<Exception, Unit> attack(Skill skill, Fightable target) {
    // 1. Assert the skill belong to the Entity

    // 2. Compute damage
    // 2bis. Add randomness

    // 3. Withdraw damage to Target HP (add `suffer` method to Fightable)
    return Left(new Exception("Not implemented yet"));
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

package com.masterdevil.xaden.domain;

import io.vavr.API;
import io.vavr.collection.List;
import io.vavr.control.Either;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public abstract class Fightable {

  private int level;
  private int hp;
  private int mana;
  private List<Skill> skills;

  /**
   * Applies the amount of damage caused by the entity to the {@code target} hp.
   */
  public Either<Exception, Unit> attack(Fightable target) {
    return API.Left(new Exception("Not implemented yet"));
  }

}

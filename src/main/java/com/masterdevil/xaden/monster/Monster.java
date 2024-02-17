package com.masterdevil.xaden.monster;

import com.masterdevil.xaden.domain.Fightable;
import com.masterdevil.xaden.domain.Skill;
import io.vavr.collection.List;
import lombok.Getter;

@Getter
public class Monster extends Fightable {

  private final String name;

  public Monster(int level, int hp, int availableHp, int mana, int availableMana,
    List<Skill> skills, String name) {
    super(level, hp, availableHp, mana, availableMana, skills);

    this.name = name;
  }
}

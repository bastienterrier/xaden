package com.masterdevil.xaden.monster;

import static io.vavr.API.List;

import com.masterdevil.xaden.domain.Fightable;
import com.masterdevil.xaden.domain.Skill;
import io.vavr.collection.List;
import lombok.Getter;

@Getter
public class Monster extends Fightable {

  public static final Monster BISON = new Monster(1, 20, 20, 10, 10, List(
    new Skill("Whirlwind Charge", 1)
  ), "Breeze Bison");

  private final String name;

  public Monster(int level, int hp, int availableHp, int mana, int availableMana,
    List<Skill> skills, String name) {
    super(level, hp, availableHp, mana, availableMana, skills);

    this.name = name;
  }

  @Override
  public String toString() {
    return String.format("%s - lvl. %d - hp. %d", name, getLevel(), getHp());
  }

}

package com.masterdevil.xaden.domain;

public record Skill(String name, int unlockLevel, int requiredMana, int baseDamage) {

  public Skill(String name, int unlockLevel) {
    this(name, unlockLevel, unlockLevel * 5 + 5, (unlockLevel * 5 + 5) * 2);
  }
}

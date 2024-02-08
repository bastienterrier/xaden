package com.masterdevil.xaden.player;

import com.masterdevil.xaden.domain.Skill;
import io.vavr.API;
import io.vavr.collection.List;

public record Race(String name, List<Skill> skills) {

  public static Race SWORDSMAN = new Race("Swordsman", API.List(
    new Skill("Ethereal Blade", 1),
    new Skill("Steel Whirlwind", 3),
    new Skill("Astral Strike", 7),
    new Skill("Sword Lightning", 10),
    new Skill("Dance of Blades", 13),
    new Skill("Shredding Storm", 17),
    new Skill("Spectral Impact", 20),
    new Skill("Steel Embrace", 25),
    new Skill("Warrior's Flash", 30),
    new Skill("Shadow Strike", 35),
    new Skill("Smith's Fury", 40),
    new Skill("Ethereal Rush", 48),
    new Skill("Sword Enchantment", 54),
    new Skill("Blade Shiver", 60),
    new Skill("Celestial Sweep", 70),
    new Skill("Blade Heritage", 75),
    new Skill("Sword Shard", 80),
    new Skill("Warrior's Trance", 85),
    new Skill("Final Blow", 90),
    new Skill("Warrior's Flame", 100)
  ));

  public static Race BOWMAN = new Race("Bowman", API.List(
    new Skill("Flaming Arrow", 1),
    new Skill("Thunderstorm Shot", 3),
    new Skill("Icy Volley", 7),
    new Skill("Venomous Shaft", 10),
    new Skill("Solar Bolt", 13),
    new Skill("Aqueous Whirlwind", 17),
    new Skill("Shadow Arrow", 20),
    new Skill("Gust Barrage", 25),
    new Skill("Earthen River", 30),
    new Skill("Lunar Glow", 35),
    new Skill("Dimensional Bolt", 40),
    new Skill("Ember Sands", 48),
    new Skill("Frost Needle", 54),
    new Skill("Volcanic Eruption", 60),
    new Skill("Electric Arrow", 70),
    new Skill("Celestial Gust", 75),
    new Skill("Silver Streak Arrow", 80),
    new Skill("Telluric Surge", 85),
    new Skill("Flamboyant Mirage", 90),
    new Skill("Spiritual Torrent", 100)));
}

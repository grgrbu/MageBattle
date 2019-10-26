package com.example.mage_battle.inventory;

public class Spell {
    public String spellName;
    public int damage, heal, barrier, defense;

    public Spell(String name, int dmg, int healing, int barr, int def){
        this.damage = dmg;
        this.heal = healing;
        this.barrier = barr;
        this.spellName = name;
        this.defense = def;
    }
}

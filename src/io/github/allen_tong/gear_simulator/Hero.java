package io.github.allen_tong.gear_simulator;

import java.util.*;

class Hero {
    private static final Set<String> CHARACTERS;
    private static final Set<String> STR_CHARACTERS;
    private static final Set<String> INT_CHARACTERS;
    static {
        Set<String> c = new HashSet<>();
        Set<String> sc = new HashSet<>();
        Set<String> ic = new HashSet<>();
        sc.add("Lann");
        sc.add("Fiona");
        ic.add("Evie");
        sc.add("Karok");
        sc.add("Kai");
        sc.add("Vella");
        sc.add("Hurk");
        sc.add("Lynn");
        ic.add("Arisha");
        ic.add("Sylas");
        sc.add("Delia");
        sc.add("Miri");
        c.addAll(sc);
        c.addAll(ic);
        CHARACTERS = Collections.unmodifiableSet(c);
        STR_CHARACTERS = Collections.unmodifiableSet(sc);
        INT_CHARACTERS = Collections.unmodifiableSet(ic);
    }

    static final int STAT_COUNT = 17;
    private static final int BASE_LUK = 100;
    private static final int BASE_ATT = 486;
    private static final int BASE_MATT = 700;
    private static final int BASE_BAL = 80;
    private static final int MAX_BAL = 90;
    private static final int BASE_CRIT = 3;
    private static final int BASE_CRITDMG = 100;
    private static final int MAX_CRITDMG = 195;
    static final Map<String, Integer> STATS;
    static {
        Map<String, Integer> s = new HashMap<>();
        String[] allStats = {"STR", "AGI", "INT", "WIL", "LUK", "HP", "STA", "ATT", "MATT", "DEF",
                "BAL", "CRIT", "CRITDMG", "CRITRESIST", "ATTSPD", "ADDDMG", "ATTLIM"};
        for (int i = 0; i < STAT_COUNT; i++) {
            s.put(allStats[i], i);
        }
        STATS = Collections.unmodifiableMap(s);
    }

    private static final Map<String, Integer> DEFENSE_MASTERY;
    private static final Map<String, Integer> STONE_SKIN;
    private static final Map<String, Integer> ARMOR_MASTERY;
    private static final Map<String, int[]> CRITICAL_HIT;
    private static final Map<String, Integer> CRITICAL_DAMAGE;
    static {
        Map<String, Integer> dm = new HashMap<>();
        dm.put("untrained", 0);
        dm.put("F", 35);
        dm.put("E", 70);
        dm.put("D", 140);
        dm.put("C", 210);
        dm.put("B", 280);
        dm.put("A", 350);
        dm.put("9", 420);
        dm.put("8", 480);
        dm.put("7", 540);
        dm.put("6", 600);
        dm.put("5", 660);
        dm.put("4", 720);
        dm.put("3", 780);
        DEFENSE_MASTERY = Collections.unmodifiableMap(dm);

        Map<String, Integer> ss = new HashMap<>();
        ss.put("untrained", 0);
        ss.put("F", 10);
        ss.put("E", 20);
        ss.put("D", 30);
        ss.put("C", 40);
        ss.put("B", 50);
        ss.put("A", 60);
        ss.put("9", 70);
        ss.put("8", 80);
        ss.put("7", 90);
        ss.put("6", 100);
        STONE_SKIN = Collections.unmodifiableMap(ss);

        Map<String, Integer> am = new HashMap<>();
        am.put("untrained", 0);
        am.put("F", 21);
        am.put("E", 57);
        am.put("D", 80);
        am.put("C", 92);
        am.put("B", 114);
        am.put("A", 132);
        am.put("9", 163);
        am.put("8", 194);
        ARMOR_MASTERY = Collections.unmodifiableMap(am);

        Map<String, int[]> ch = new HashMap<>();
        ch.put("untrained", new int[] {0, 0});
        ch.put("F", new int[] {0, 0});
        ch.put("E", new int[] {10, 10});
        ch.put("D", new int[] {13, 11});
        ch.put("C", new int[] {16, 12});
        ch.put("B", new int[] {19, 13});
        ch.put("A", new int[] {22, 14});
        ch.put("9", new int[] {32, 16});
        ch.put("8", new int[] {38, 18});
        ch.put("7", new int[] {44, 20});
        ch.put("6", new int[] {50, 22});
        ch.put("5", new int[] {55, 24});
        ch.put("4", new int[] {60, 26});
        ch.put("3", new int[] {65, 28});
        CRITICAL_HIT = Collections.unmodifiableMap(ch);

        Map<String, Integer> cd = new HashMap<>();
        cd.put("untrained", 0);
        cd.put("F", 3);
        cd.put("E", 6);
        cd.put("D", 9);
        cd.put("C", 12);
        cd.put("B", 15);
        cd.put("A", 18);
        cd.put("9", 21);
        cd.put("8", 24);
        cd.put("7", 27);
        cd.put("6", 30);
        CRITICAL_DAMAGE = Collections.unmodifiableMap(cd);
    }

    private static final int GEARSLOT_COUNT = 26;
    private static final Map<String, Integer> GEARSLOTS;
    static {
        Map<String, Integer> g = new HashMap<>();
        String[] slots = {
                "Weapon", "Helm", "Tunic", "Pants", "Gloves", "Boots",
                "Auxiliary", "Earrings", "Belt", "Jewelry", "Ring 1", "Ring 2",
                "Bracelet 1", "Bracelet 2", "Artifact", "Back", "Tail",
                "Epaulet 1", "Epaulet 2", "Necklace", "Badge",
                "Head", "Chest", "Leg", "Hand", "Feet"};
        for (int i = 0; i < GEARSLOT_COUNT; i++) {
            g.put(slots[i], i);
        }
        GEARSLOTS = Collections.unmodifiableMap(g);
    }

    private String charName;
    private String charClass;
    private String defenseMasteryRank = "untrained";
    private String stoneSkinRank = "untrained";
    private String armorMasteryRank = "untrained";
    private String criticalHitRank = "untrained";
    private String criticalDamageRank = "untrained";

    private int[] totalStats = new int[STAT_COUNT];
    private int[] baseStats = new int[STAT_COUNT];
    private int[] gearStats = new int[STAT_COUNT];
    private Equipment[] gear = new Equipment[34];
    private int[] buffs = new int[STAT_COUNT];

    private Map<String, Equipment[]> builds = new HashMap<>();

    Hero(String charClass) {
        if (charClass != null && charClass.length() > 0) {
            String temp = charClass.toLowerCase();
            temp = temp.substring(0, 1).toUpperCase() + temp.substring(1);
            if (CHARACTERS.contains(temp)) {
                this.charClass = temp;
            } else {
                throw new SimulatorException("Invalid character class: " + charClass);
            }
        } else {
            throw new SimulatorException("Please enter a playable character class.");
        }
    }

    Hero(String charName, String charClass) {
        this(charClass);
        this.charName = charName;
    }

    void setName(String charName) {
        this.charName = charName;
    }

    void setClass(String charClass) {
        if (charClass != null && charClass.length() > 0) {
            String temp = charClass.toLowerCase();
            temp = temp.substring(0, 1).toUpperCase() + temp.substring(1);
            if (CHARACTERS.contains(temp)) {
                this.charClass = temp;
            } else {
                throw new SimulatorException("Invalid character class: " + charClass);
            }
        }
    }

    void setBaseStats(int str, int agi, int intel, int wil, int hp, int sta,
                      int att, int matt, int bal, int crit) {
        baseStats = new int[] {str, agi, intel, wil,
                BASE_LUK, hp - (int) (wil * 0.6), sta,
                BASE_ATT + att, BASE_MATT + matt, 0,
                bal, BASE_CRIT + crit, BASE_CRITDMG, 0, 0, 0, 0};
    }

    void setDefenseMasteryRank(String rank) {
        if (DEFENSE_MASTERY.containsKey(rank)) {
            defenseMasteryRank = rank;
        } else {
            throw new SimulatorException("Invalid Defense Mastery rank: " + rank);
        }
    }

    void setStoneSkinRank(String rank) {
        if (STONE_SKIN.containsKey(rank)) {
            stoneSkinRank = rank;
        } else {
            throw new SimulatorException("Invalid Stone Skin rank: " + rank);
        }
    }

    void setArmorMasteryRank(String rank) {
        if (ARMOR_MASTERY.containsKey(rank)) {
            armorMasteryRank = rank;
        } else {
            throw new SimulatorException("Invalid Armor Mastery rank: " + rank);
        }
    }

    void setCriticalHitRank(String rank) {
        if (CRITICAL_HIT.containsKey(rank)) {
            criticalHitRank = rank;
        } else {
            throw new SimulatorException("Invalid Critical Hit rank: " + rank);
        }
    }

    void setCriticalDamageRank(String rank) {
        if (CRITICAL_DAMAGE.containsKey(rank)) {
            criticalDamageRank = rank;
        } else {
            throw new SimulatorException("Invalid Critical Damage rank: " + rank);
        }
    }

    void setBuffs(int str, int agi, int intel, int wil, int luk, int hp, int sta,
                  int att, int matt, int def, int bal, int crit, int critdmg,
                  int critresist, int spd, int adddmg, int attlim) {
        buffs = new int[] {str, agi, intel, wil, luk, hp, sta, att, matt, def,
                bal, crit, critdmg, critresist, spd, adddmg, attlim};
    }

    void addBuff(int str, int agi, int intel, int wil, int luk, int hp, int sta,
                  int att, int matt, int def, int bal, int crit, int critdmg,
                  int critresist, int spd, int adddmg, int attlim) {
        int[] temp = new int[] {str, agi, intel, wil, luk, hp, sta, att, matt, def,
                bal, crit, critdmg, critresist, spd, adddmg, attlim};
        for (int i = 0; i < STAT_COUNT; i++) {
            buffs[i] += temp[i];
        }
    }

    void resetBuffs() {
        buffs = new int[STAT_COUNT];
    }

    void equip(String slot, Equipment equip) {
        gear[GEARSLOTS.get(slot)] = equip;
    }

    void unequip(String slot) {
        gear[GEARSLOTS.get(slot)] = null;
    }

    void resetGear() {
        gear = new Equipment[GEARSLOT_COUNT];
    }

    void saveBuild(String buildName) {
        Equipment[] build = new Equipment[GEARSLOT_COUNT];
        int slot = 0;
        slot = GEARSLOTS.get("Weapon");
        build[slot] = gear[slot] == null ? null : new Weapon((Weapon) gear[slot]);
        slot = GEARSLOTS.get("Helm");
        build[slot] = gear[slot] == null ? null : new Armor((Armor) gear[slot]);
        slot = GEARSLOTS.get("Tunic");
        build[slot] = gear[slot] == null ? null : new Armor((Armor) gear[slot]);
        slot = GEARSLOTS.get("Pants");
        build[slot] = gear[slot] == null ? null : new Armor((Armor) gear[slot]);
        slot = GEARSLOTS.get("Gloves");
        build[slot] = gear[slot] == null ? null : new Armor((Armor) gear[slot]);
        slot = GEARSLOTS.get("Boots");
        build[slot] = gear[slot] == null ? null : new Armor((Armor) gear[slot]);
        slot = GEARSLOTS.get("Auxiliary");
        build[slot] = gear[slot] == null ? null : new Accessory((Accessory) gear[slot]);
        slot = GEARSLOTS.get("Earrings");
        build[slot] = gear[slot] == null ? null : new Accessory((Accessory) gear[slot]);
        slot = GEARSLOTS.get("Belt");
        build[slot] = gear[slot] == null ? null : new Accessory((Accessory) gear[slot]);
        slot = GEARSLOTS.get("Jewelry");
        build[slot] = gear[slot] == null ? null : new Accessory((Accessory) gear[slot]);
        slot = GEARSLOTS.get("Ring 1");
        build[slot] = gear[slot] == null ? null : new Accessory((Accessory) gear[slot]);
        slot = GEARSLOTS.get("Ring 2");
        build[slot] = gear[slot] == null ? null : new Accessory((Accessory) gear[slot]);
        slot = GEARSLOTS.get("Bracelet 1");
        build[slot] = gear[slot] == null ? null : new Bracelet((Bracelet) gear[slot]);
        slot = GEARSLOTS.get("Bracelet 2");
        build[slot] = gear[slot] == null ? null : new Bracelet((Bracelet) gear[slot]);
        slot = GEARSLOTS.get("Artifact");
        build[slot] = gear[slot] == null ? null : new Accessory((Accessory) gear[slot]);
        slot = GEARSLOTS.get("Back");
        build[slot] = gear[slot] == null ? null : new Accessory((Accessory) gear[slot]);
        slot = GEARSLOTS.get("Tail");
        build[slot] = gear[slot] == null ? null : new Accessory((Accessory) gear[slot]);
        slot = GEARSLOTS.get("Epaulet 1");
        build[slot] = gear[slot] == null ? null : new Accessory((Accessory) gear[slot]);
        slot = GEARSLOTS.get("Epaulet 2");
        build[slot] = gear[slot] == null ? null : new Accessory((Accessory) gear[slot]);
        slot = GEARSLOTS.get("Necklace");
        build[slot] = gear[slot] == null ? null : new Accessory((Accessory) gear[slot]);
        slot = GEARSLOTS.get("Badge");
        build[slot] = gear[slot] == null ? null : new Accessory((Accessory) gear[slot]);
        slot = GEARSLOTS.get("Head");
        build[slot] = gear[slot] == null ? null : new Outfit((Outfit) gear[slot]);
        slot = GEARSLOTS.get("Chest");
        build[slot] = gear[slot] == null ? null : new Outfit((Outfit) gear[slot]);
        slot = GEARSLOTS.get("Leg");
        build[slot] = gear[slot] == null ? null : new Outfit((Outfit) gear[slot]);
        slot = GEARSLOTS.get("Hand");
        build[slot] = gear[slot] == null ? null : new Outfit((Outfit) gear[slot]);
        slot = GEARSLOTS.get("Feet");
        build[slot] = gear[slot] == null ? null : new Outfit((Outfit) gear[slot]);
        builds.put(buildName, build);
    }

    void getBuild(String buildName) {
        if (builds.containsKey(buildName)) {
            gear = builds.get(buildName);
        } else {
            throw new SimulatorException("No build exists with name: " + buildName);
        }
    }

    void removeBuild(String buildName) {
        builds.remove(buildName);
    }

    private void evaluate() {
        int[] setStats = SetBonus.getSetStats(gear);
        for (int stat = 0; stat < STAT_COUNT; stat++) {
            int total = 0;
            for (int equip = 0; equip < GEARSLOT_COUNT; equip++) {
                if (gear[equip] != null) {
                    total += gear[equip].totalStats[stat];
                }
            }
            gearStats[stat] = total + setStats[stat];
        }
        for (int i = 0; i < totalStats.length; i++) {
            totalStats[i] = baseStats[i] + gearStats[i] + buffs[i];
        }

        totalStats[STATS.get("HP")] += totalStats[STATS.get("WIL")] * 0.6;
        totalStats[STATS.get("ATT")] += totalStats[STATS.get("STR")] * 2.7;
        totalStats[STATS.get("MATT")] += totalStats[STATS.get("INT")] * 2;
        totalStats[STATS.get("DEF")] += totalStats[STATS.get("AGI")] * 0.5 +
                                                DEFENSE_MASTERY.get(defenseMasteryRank);
        String[] armorSlots = {"Helm", "Tunic", "Pants", "Gloves", "Boots"};
        for (String armor : armorSlots) {
            if (gear[GEARSLOTS.get(armor)] == null) {
                totalStats[STATS.get("DEF")] += STONE_SKIN.get(stoneSkinRank);
            } else {
                totalStats[STATS.get("DEF")] += ARMOR_MASTERY.get(armorMasteryRank);
            }
        }
        totalStats[STATS.get("BAL")] = gear[GEARSLOTS.get("Weapon")] == null
                                               ? BASE_BAL
                                               : Math.min(totalStats[STATS.get("BAL")], MAX_BAL);
        totalStats[STATS.get("CRIT")] += totalStats[STATS.get("WIL")] * 0.0075 +
                                                 CRITICAL_HIT.get(criticalHitRank)[1];
        if (STR_CHARACTERS.contains(charClass)) {
            totalStats[STATS.get("CRITDMG")] += (int) (totalStats[STATS.get("STR")] * 0.015) +
                                                        CRITICAL_HIT.get(criticalHitRank)[0];
        } else if (INT_CHARACTERS.contains(charClass)) {
            totalStats[STATS.get("CRITDMG")] += (int) (totalStats[STATS.get("INT")] * 0.015) +
                                                        CRITICAL_HIT.get(criticalHitRank)[0];
        }
        totalStats[STATS.get("CRITDMG")] = Math.min(totalStats[STATS.get("CRITDMG")], MAX_CRITDMG);
        if (charClass.equals("Lann")) {
            totalStats[STATS.get("CRITDMG")] += CRITICAL_DAMAGE.get(criticalDamageRank);
        }
    }

    void print() {
        evaluate();
        System.out.println(charName + "'s Stats:");
        if (STR_CHARACTERS.contains(charClass)) {
            System.out.println("Power           " + (totalStats[STATS.get("ATT")] +
                                                             totalStats[STATS.get("DEF")]));
        } else if (INT_CHARACTERS.contains(charClass)) {
            System.out.println("Power           " + (totalStats[STATS.get("MATT")] +
                                                             totalStats[STATS.get("DEF")]));
        }
        System.out.println("Tech.           " + (totalStats[STATS.get("BAL")] +
                                                         totalStats[STATS.get("CRIT")]));
        System.out.println("STR             " + totalStats[STATS.get("STR")]);
        System.out.println("AGI             " + totalStats[STATS.get("AGI")]);
        System.out.println("INT             " + totalStats[STATS.get("INT")]);
        System.out.println("WIL             " + totalStats[STATS.get("WIL")]);
        System.out.println("LUK             " + totalStats[STATS.get("LUK")]);
        System.out.println("Max HP          " + totalStats[STATS.get("HP")]);
        System.out.println("Max STA         " + totalStats[STATS.get("STA")]);
        if (STR_CHARACTERS.contains(charClass)) {
            System.out.println("ATT             " + totalStats[STATS.get("ATT")]);
        } else if (INT_CHARACTERS.contains(charClass)) {
            System.out.println("M. ATT          " + totalStats[STATS.get("MATT")]);
        }
        System.out.println("DEF             " + totalStats[STATS.get("DEF")]);
        System.out.println("BAL             " + totalStats[STATS.get("BAL")]);
        System.out.println("Critical        " + totalStats[STATS.get("CRIT")]);
        System.out.println("Critical Damage " + totalStats[STATS.get("CRITDMG")]);
        System.out.println("Crit Resist     " + totalStats[STATS.get("CRITRESIST")]);
        System.out.println("ATT SPD         " + totalStats[STATS.get("ATTSPD")]);
        System.out.println("Additional DMG  " + totalStats[STATS.get("ADDDMG")]);
        System.out.println("ATT Limit       " + totalStats[STATS.get("ATTLIM")]);
    }
}

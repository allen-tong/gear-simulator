package io.github.allen_tong.gear_simulator;

import java.util.Arrays;

class Accessory extends Equipment {
    Accessory() {}

    Accessory(String set) {
        setSet(set);
    }

    Accessory(Accessory other) {
        totalStats = Arrays.copyOf(other.totalStats, totalStats.length);
        stats = Arrays.copyOf(other.stats, totalStats.length);
        prefix = Arrays.copyOf(other.prefix, prefix.length);
        suffix = Arrays.copyOf(other.suffix, suffix.length);
        infusion = Arrays.copyOf(other.infusion, infusion.length);
        quality = other.quality;
        set = other.set;
    }

    Accessory(int str, int agi, int intel, int wil, int luk, int hp, int sta,
              int att, int matt, int def, int bal, int crit, int critdmg,
              int critresist, int spd, int adddmg, int attlim) {
        setStats(str, agi, intel, wil, luk, hp, sta, att, matt, def,
                bal, crit, critdmg, critresist, spd, adddmg, attlim);
    }

    Accessory(int str, int agi, int intel, int wil, int luk, int hp, int sta,
              int att, int matt, int def, int bal, int crit, int critdmg,
              int critresist, int spd, int adddmg, int attlim, String set) {
        this(str, agi, intel, wil, luk, hp, sta, att, matt, def,
                bal, crit, critdmg, critresist, spd, adddmg, attlim);
        setSet(set);
    }
}

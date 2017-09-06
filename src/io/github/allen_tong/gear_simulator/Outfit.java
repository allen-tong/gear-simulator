package io.github.allen_tong.gear_simulator;

import java.util.Arrays;

class Outfit extends Equipment {
    Outfit(boolean premium) {
        stats[7] = premium ? 70 : 20;
        stats[8] = premium ? 70 : 20;
        evaluate();
        setSet("Outfit");
    }

    Outfit(Outfit other) {
        totalStats = Arrays.copyOf(other.totalStats, totalStats.length);
        stats = Arrays.copyOf(other.stats, totalStats.length);
        prefix = Arrays.copyOf(other.prefix, prefix.length);
        suffix = Arrays.copyOf(other.suffix, suffix.length);
        infusion = Arrays.copyOf(other.infusion, infusion.length);
        quality = other.quality;
        set = other.set;
    }

    Outfit(int str, int agi, int intel, int wil, int luk, int hp, int sta,
           int att, int matt, int def, int bal, int crit, int critdmg,
           int critresist, int spd, int adddmg, int attlim) {
        setStats(str, agi, intel, wil, luk, hp, sta, att, matt, def,
                bal, crit, critdmg, critresist, spd, adddmg, attlim);
        setSet("Outfit");
    }

    @Override
    void setInfusion(int str, int agi, int intel, int wil, int luk, int hp, int sta,
                     int att, int matt, int def, int bal, int crit, int critdmg,
                     int critresist, int spd, int adddmg, int attlim) {
        throw new SimulatorException("Outfits cannot be infused.");
    }

    @Override
    void setQuality(int quality) {
        throw new SimulatorException("Quality of outfits cannot be changed.");
    }

    @Override
    void setSet(String set) {
        super.setSet("Outfit");
    }
}

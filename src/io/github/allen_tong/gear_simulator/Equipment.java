package io.github.allen_tong.gear_simulator;

abstract class Equipment {
    int[] totalStats = new int[Hero.STAT_COUNT];
    int[] stats = new int[Hero.STAT_COUNT];
    int[] prefix = new int[Hero.STAT_COUNT];
    int[] suffix = new int[Hero.STAT_COUNT];
    int[] infusion = new int[Hero.STAT_COUNT];
    int quality = 2;
    String set;

    void evaluate() {
        for (int i = 0; i < totalStats.length; i++) {
            totalStats[i] = stats[i];
        }
        double multiplier1 = 1;
        double multiplier2 = 1;
        switch (quality) {
            case 1:
                multiplier1 = 0.8;
                multiplier2 = 0.96;
                break;
            case 2:
                multiplier1 = 1;
                multiplier2 = 1;
                break;
            case 3:
                multiplier1 = 1.15;
                multiplier2 = 1.02;
                break;
            case 4:
                multiplier1 = 1.2;
                multiplier2 = 1.04;
                break;
            case 5:
                multiplier1 = 1.25;
                multiplier2 = 1.06;
                break;
        }
        String[] affectedStats1 = {"STR", "AGI", "INT", "WIL"};
        String[] affectedStats2 = {"ATT", "MATT"};
        for (String stat : affectedStats1) {
            totalStats[Hero.STATS.get(stat)] *= multiplier1;
        }
        for (String stat : affectedStats2) {
            totalStats[Hero.STATS.get(stat)] *= multiplier2;
        }
        for (int i = 0; i < totalStats.length; i++) {
            totalStats[i] += prefix[i] + suffix[i] + infusion[i];
        }
    }

    void setStats(int str, int agi, int intel, int wil, int luk, int hp, int sta,
                  int att, int matt, int def, int bal, int crit, int critdmg,
                  int critresist, int spd, int adddmg, int attlim) {
        stats = new int[] {str, agi, intel, wil, luk, hp, sta, att, matt, def,
                bal, crit, critdmg, critresist, spd, adddmg, attlim};
        evaluate();
    }

    void resetStats() {
        stats = new int[Hero.STAT_COUNT];
        evaluate();
    }

    void setPrefix(int[] enchant) {
        prefix = enchant;
        evaluate();
    }

    void setPrefix(int str, int agi, int intel, int wil, int luk, int hp, int sta,
                   int att, int matt, int def, int bal, int crit, int critdmg,
                   int critresist, int spd, int adddmg, int attlim) {
        prefix = new int[] {str, agi, intel, wil, luk, hp, sta, att, matt, def,
                bal, crit, critdmg, critresist, spd, adddmg, attlim};
        evaluate();
    }

    void resetPrefix() {
        prefix = new int[Hero.STAT_COUNT];
        evaluate();
    }

    void setSuffix(int[] enchant) {
        suffix = enchant;
        evaluate();
    }

    void setSuffix(int str, int agi, int intel, int wil, int luk, int hp, int sta,
                   int att, int matt, int def, int bal, int crit, int critdmg,
                   int critresist, int spd, int adddmg, int attlim) {
        suffix = new int[] {str, agi, intel, wil, luk, hp, sta, att, matt, def,
                bal, crit, critdmg, critresist, spd, adddmg, attlim};
        evaluate();
    }

    void resetSuffix() {
        suffix = new int[Hero.STAT_COUNT];
        evaluate();
    }

    void setInfusion(int str, int agi, int intel, int wil, int luk, int hp, int sta,
                     int att, int matt, int def, int bal, int crit, int critdmg,
                     int critresist, int spd, int adddmg, int attlim) {
        infusion = new int[] {str, agi, intel, wil, luk, hp, sta, att, matt, def,
                bal, crit, critdmg, critresist, spd, adddmg, attlim};
        evaluate();
    }

    void setQuality(int quality) {
        this.quality = quality;
        evaluate();
    }

    void setSet(String set) {
        this.set = set;
    }
}

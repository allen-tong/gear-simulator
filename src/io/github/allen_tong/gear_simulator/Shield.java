package io.github.allen_tong.gear_simulator;

import java.util.Arrays;

class Shield extends Composite {
    private int[] essence = new int[3];
    private int[] solid = new int[5];

    Shield() {}

    Shield(Shield other) {
        totalStats = Arrays.copyOf(other.totalStats, totalStats.length);
        stats = Arrays.copyOf(other.stats, totalStats.length);
        prefix = Arrays.copyOf(other.prefix, prefix.length);
        suffix = Arrays.copyOf(other.suffix, suffix.length);
        infusion = Arrays.copyOf(other.infusion, infusion.length);
        quality = other.quality;
        set = other.set;
        enhancement = Arrays.copyOf(other.enhancement, enhancement.length);
        composite = other.composite;
        essence = Arrays.copyOf(other.essence, essence.length);
        solid = Arrays.copyOf(other.solid, solid.length);
    }

    Shield(int str, int agi, int intel, int wil, int luk, int hp, int sta,
           int att, int matt, int def, int bal, int crit, int critdmg,
           int critresist, int spd, int adddmg, int attlim) {
        setStats(str, agi, intel, wil, luk, hp, sta, att, matt, def,
                bal, crit, critdmg, critresist, spd, adddmg, attlim);
    }

    Shield(int str, int agi, int intel, int wil, int luk, int hp, int sta,
           int att, int matt, int def, int bal, int crit, int critdmg,
           int critresist, int spd, int adddmg, int attlim, String set) {
        this(str, agi, intel, wil, luk, hp, sta, att, matt, def,
                bal, crit, critdmg, critresist, spd, adddmg, attlim);
        setSet(set);
    }

    @Override
    void setEnhancement(int level) {
        switch (level) {
            case 0:
                enhancement = new int[17];
                break;
            case 1:
                enhancement[9] = 13;
                break;
            case 2:
                enhancement[9] = 26;
                break;
            case 3:
                enhancement[9] = 39;
                break;
            case 4:
                enhancement[9] = 57;
                break;
            case 5:
                enhancement[9] = 75;
                break;
            case 6:
                enhancement[9] = 93;
                break;
            case 7:
                enhancement[9] = 117;
                break;
            case 8:
                enhancement[9] = 141;
                break;
            case 9:
                enhancement[9] = 165;
                break;
            case 10:
                enhancement[9] = 189;
                break;
            case 11:
                enhancement[9] = 224;
                break;
            case 12:
                enhancement[9] = 259;
                break;
            case 13:
                enhancement[9] = 294;
                break;
            case 14:
                enhancement[9] = 339;
                break;
            case 15:
                enhancement[9] = 384;
                break;
            case 16:
                enhancement[9] = 409;
                break;
            case 17:
                enhancement[9] = 434;
                break;
            case 18:
                enhancement[9] = 459;
                break;
            case 19:
                enhancement[9] = 484;
                break;
            case 20:
                enhancement[9] = 509;
                break;
            default:
                throw new SimulatorException("Invalid enhancement level: " + level);
        }
        evaluate();
    }

    @Override
    void setComposite() {
        setStats(solid[0], solid[1], solid[2], solid[3], 0, 0, 0, 0, 0,
                essence[0], 0, 0, 0, essence[1] + solid[4], 0, 0, 0);
    }

    @Override
    void resetComposite() {
        essence = new int[2];
        solid = new int[5];
        setComposite();
    }

    @Override
    void setSet(String set) {
    }

    void setEssence(int def, int critresist) {
        checkComposite();
        essence[0] = def;
        essence[1] = critresist;
        setComposite();
    }

    void setSolid(int str, int agi, int intel, int wil, int critresist) {
        checkComposite();
        solid[0] = str;
        solid[1] = agi;
        solid[2] = intel;
        solid[3] = wil;
        solid[4] = critresist;
        setComposite();
    }
}

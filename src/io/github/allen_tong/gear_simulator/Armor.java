package io.github.allen_tong.gear_simulator;

import java.util.Arrays;

class Armor extends Composite {
    private int[] essence = new int[3];
    private int[] solid = new int[6];
    private int[] smooth = new int[3];

    Armor() {}

    Armor(String set) {
        setSet(set);
    }

    Armor(Armor other) {
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
        smooth = Arrays.copyOf(other.smooth, smooth.length);
    }

    Armor(int str, int agi, int intel, int wil, int luk, int hp, int sta,
          int att, int matt, int def, int bal, int crit, int critdmg,
          int critresist, int spd, int adddmg, int attlim) {
        setStats(str, agi, intel, wil, luk, hp, sta, att, matt, def,
                bal, crit, critdmg, critresist, spd, adddmg, attlim);
    }

    Armor(int str, int agi, int intel, int wil, int luk, int hp, int sta,
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
                enhancement[15] = 10;
                break;
            case 2:
                enhancement[9] = 26;
                enhancement[15] = 22;
                break;
            case 3:
                enhancement[9] = 39;
                enhancement[15] = 34;
                break;
            case 4:
                enhancement[9] = 57;
                enhancement[15] = 46;
                break;
            case 5:
                enhancement[9] = 75;
                enhancement[15] = 58;
                break;
            case 6:
                enhancement[5] = 50;
                enhancement[9] = 93;
                enhancement[15] = 70;
                break;
            case 7:
                enhancement[5] = 70;
                enhancement[9] = 117;
                enhancement[15] = 82;
                break;
            case 8:
                enhancement[5] = 100;
                enhancement[9] = 141;
                enhancement[15] = 97;
                break;
            case 9:
                enhancement[5] = 130;
                enhancement[9] = 165;
                enhancement[15] = 112;
                break;
            case 10:
                enhancement[5] = 170;
                enhancement[9] = 189;
                enhancement[15] = 130;
                break;
            case 11:
                enhancement[5] = 220;
                enhancement[9] = 224;
                enhancement[15] = 200;
                break;
            case 12:
                enhancement[5] = 300;
                enhancement[9] = 259;
                enhancement[15] = 300;
                break;
            case 13:
                enhancement[5] = 500;
                enhancement[9] = 294;
                enhancement[15] = 400;
                break;
            case 14:
                enhancement[5] = 500;
                enhancement[9] = 339;
                enhancement[15] = 500;
                break;
            case 15:
                enhancement[5] = 500;
                enhancement[9] = 384;
                enhancement[15] = 600;
                break;
            case 16:
                enhancement[5] = 500;
                enhancement[9] = 409;
                enhancement[15] = 750;
                break;
            case 17:
                enhancement[5] = 500;
                enhancement[9] = 434;
                enhancement[15] = 900;
                break;
            case 18:
                enhancement[5] = 500;
                enhancement[9] = 459;
                enhancement[15] = 1140;
                break;
            case 19:
                enhancement[5] = 500;
                enhancement[9] = 484;
                enhancement[15] = 1440;
                break;
            case 20:
                enhancement[5] = 500;
                enhancement[9] = 509;
                enhancement[15] = 2500;
                break;
            default:
                throw new SimulatorException("Invalid enhancement level: " + level);
        }
        evaluate();
    }

    @Override
    void setComposite() {
        stats[0] = solid[0];
        stats[1] = solid[1];
        stats[2] = solid[2];
        stats[3] = solid[3];
        stats[9] = essence[0] + smooth[0];
        stats[13] = essence[1] + solid[4] + smooth[1];
        stats[16] = essence[2] + solid[5] + smooth[2];
        evaluate();
    }

    @Override
    void resetComposite() {
        essence = new int[3];
        solid = new int[6];
        smooth = new int[3];
        setComposite();
    }

    void setEssence(int def, int critresist, int attlim) {
        checkComposite();
        essence[0] = def;
        essence[1] = critresist;
        essence[2] = attlim;
        setComposite();
    }

    void setSolid(int str, int agi, int intel, int wil, int critresist, int attlim) {
        checkComposite();
        solid[0] = str;
        solid[1] = agi;
        solid[2] = intel;
        solid[3] = wil;
        solid[4] = critresist;
        solid[5] = attlim;
        setComposite();
    }

    void setSmooth(int def, int critresist, int attlim) {
        checkComposite();
        smooth[0] = def;
        smooth[1] = critresist;
        smooth[2] = attlim;
        setComposite();
    }
}

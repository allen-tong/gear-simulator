package io.github.allen_tong.gear_simulator;

import java.util.Arrays;

class Weapon extends Composite {
    private int[] essence = new int[4];
    private int[] keen = new int[3];
    private int[] stable = new int[6];
    private int[] lightweight = new int[3];
    private int[] perfect = new int[7];

    Weapon() {}

    Weapon(String set) {
        setSet(set);
    }

    Weapon(Weapon other) {
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
        keen = Arrays.copyOf(other.keen, keen.length);
        stable = Arrays.copyOf(other.stable, stable.length);
        lightweight = Arrays.copyOf(other.lightweight, lightweight.length);
        perfect = Arrays.copyOf(other.perfect, perfect.length);
    }

    Weapon(int str, int agi, int intel, int wil, int luk, int hp, int sta,
           int att, int matt, int def, int bal, int crit, int critdmg,
           int critresist, int spd, int adddmg, int attlim) {
        setStats(str, agi, intel, wil, luk, hp, sta, att, matt, def,
                bal, crit, critdmg, critresist, spd, adddmg, attlim);
    }

    Weapon(int str, int agi, int intel, int wil, int luk, int hp, int sta,
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
                enhancement[7] = 50;
                enhancement[8] = 50;
                enhancement[14] = 2;
                enhancement[15] = 50;
                break;
            case 2:
                enhancement[7] = 100;
                enhancement[8] = 100;
                enhancement[14] = 4;
                enhancement[15] = 110;
                break;
            case 3:
                enhancement[7] = 150;
                enhancement[8] = 150;
                enhancement[14] = 6;
                enhancement[15] = 170;
                break;
            case 4:
                enhancement[7] = 250;
                enhancement[8] = 250;
                enhancement[14] = 8;
                enhancement[15] = 230;
                break;
            case 5:
                enhancement[7] = 350;
                enhancement[8] = 350;
                enhancement[14] = 10;
                enhancement[15] = 290;
                break;
            case 6:
                enhancement[7] = 450;
                enhancement[8] = 450;
                enhancement[14] = 12;
                enhancement[15] = 350;
                break;
            case 7:
                enhancement[7] = 550;
                enhancement[8] = 550;
                enhancement[14] = 14;
                enhancement[15] = 410;
                break;
            case 8:
                enhancement[7] = 700;
                enhancement[8] = 700;
                enhancement[14] = 16;
                enhancement[15] = 485;
                break;
            case 9:
                enhancement[7] = 850;
                enhancement[8] = 850;
                enhancement[14] = 18;
                enhancement[15] = 560;
                break;
            case 10:
                enhancement[7] = 1000;
                enhancement[8] = 1000;
                enhancement[14] = 20;
                enhancement[15] = 650;
                break;
            case 11:
                enhancement[7] = 1500;
                enhancement[8] = 1500;
                enhancement[14] = 23;
                enhancement[15] = 1000;
                break;
            case 12:
                enhancement[7] = 2000;
                enhancement[8] = 2000;
                enhancement[14] = 26;
                enhancement[15] = 1500;
                break;
            case 13:
                enhancement[7] = 2600;
                enhancement[8] = 2600;
                enhancement[14] = 30;
                enhancement[15] = 2000;
                break;
            case 14:
                enhancement[7] = 3300;
                enhancement[8] = 3300;
                enhancement[14] = 34;
                enhancement[15] = 2500;
                break;
            case 15:
                enhancement[7] = 4100;
                enhancement[8] = 4100;
                enhancement[14] = 38;
                enhancement[15] = 3000;
                break;
            case 16:
                enhancement[7] = 4900;
                enhancement[8] = 4900;
                enhancement[14] = 42;
                enhancement[15] = 3750;
                break;
            case 17:
                enhancement[7] = 5700;
                enhancement[8] = 5700;
                enhancement[14] = 46;
                enhancement[15] = 4500;
                break;
            case 18:
                enhancement[7] = 6600;
                enhancement[8] = 6600;
                enhancement[14] = 50;
                enhancement[15] = 5700;
                break;
            case 19:
                enhancement[7] = 7500;
                enhancement[8] = 7500;
                enhancement[14] = 54;
                enhancement[15] = 7200;
                break;
            case 20:
                enhancement[7] = 8500;
                enhancement[8] = 8500;
                enhancement[14] = 58;
                enhancement[15] = 12500;
                break;
            default:
                throw new SimulatorException("Invalid enhancement level: " + level);
        }
        evaluate();
    }

    @Override
    void setComposite() {
        stats[0] = stable[1] + perfect[2];
        stats[1] = stable[2] + perfect[3];
        stats[2] = stable[3] + perfect[4];
        stats[3] = stable[4] + perfect[5];
        stats[7] = essence[0] + perfect[0];
        stats[8] = essence[1] + perfect[1];
        stats[10] = keen[0] + stable[0];
        stats[11] = keen[1] + lightweight[0];
        stats[14] = essence[2] + lightweight[1];
        stats[16] = essence[3] + keen[2] + stable[5] + lightweight[2] + perfect[6];
        evaluate();
    }

    @Override
    void resetComposite() {
        essence = new int[4];
        keen = new int[3];
        stable = new int[6];
        lightweight = new int[3];
        perfect = new int[7];
        setComposite();
    }

    void setEssence(int att, int matt, int spd, int attlim) {
        checkComposite();
        essence[0] = att;
        essence[1] = matt;
        essence[2] = spd;
        essence[3] = attlim;
        setComposite();
    }

    void setKeen(int bal, int crit, int attlim) {
        checkComposite();
        keen[0] = bal;
        keen[1] = crit;
        keen[2] = attlim;
        setComposite();
    }

    void setStable(int bal, int str, int agi, int intel, int wil, int attlim) {
        checkComposite();
        stable[0] = bal;
        stable[1] = str;
        stable[2] = agi;
        stable[3] = intel;
        stable[4] = wil;
        stable[5] = attlim;
        setComposite();
    }

    void setLightweight(int crit, int spd, int attlim) {
        checkComposite();
        lightweight[0] = crit;
        lightweight[1] = spd;
        lightweight[2] = attlim;
        setComposite();
    }

    void setPerfect(int att, int matt, int str, int agi, int intel, int wil, int attlim) {
        checkComposite();
        perfect[0] = att;
        perfect[1] = matt;
        perfect[2] = str;
        perfect[3] = agi;
        perfect[4] = intel;
        perfect[5] = wil;
        perfect[6] = attlim;
        setComposite();
    }
}

package io.github.allen_tong.gear_simulator;

import java.util.Arrays;

class Bracelet extends Equipment {
    private int[] diamond = new int[4];
    private int[] sapphire = new int[4];
    private int[] ruby = new int[4];
    private int[] emerald = new int[4];
    private boolean gems = false;

    Bracelet() {}

    Bracelet(Bracelet other) {
        totalStats = Arrays.copyOf(other.totalStats, totalStats.length);
        stats = Arrays.copyOf(other.stats, totalStats.length);
        prefix = Arrays.copyOf(other.prefix, prefix.length);
        suffix = Arrays.copyOf(other.suffix, suffix.length);
        infusion = Arrays.copyOf(other.infusion, infusion.length);
        quality = other.quality;
        set = other.set;
        diamond = Arrays.copyOf(other.diamond, diamond.length);
        sapphire = Arrays.copyOf(other.sapphire, sapphire.length);
        ruby = Arrays.copyOf(other.ruby, ruby.length);
        emerald = Arrays.copyOf(other.emerald, emerald.length);
        gems = other.gems;
    }

    Bracelet(int att, int matt, int def, int hp) {
        setStats(0, 0, 0, 0, 0, hp, 0, att, matt, def, 0, 0, 0, 0, 0, 0, 0);
    }

    @Override
    void evaluate() {
        for (int i = 0; i < totalStats.length; i++) {
            totalStats[i] = stats[i];
        }
    }

    @Override
    void setStats(int str, int agi, int intel, int wil, int luk, int hp, int sta,
                  int att, int matt, int def, int bal, int crit, int critdmg,
                  int critresist, int spd, int adddmg, int attlim) {
        resetGems();
        stats = new int[] {str, agi, intel, wil, luk, hp, sta, att, matt, def,
                bal, crit, critdmg, critresist, spd, adddmg, attlim};
        evaluate();
    }

    @Override
    void setInfusion(int str, int agi, int intel, int wil, int luk, int hp, int sta,
                     int att, int matt, int def, int bal, int crit, int critdmg,
                     int critresist, int spd, int adddmg, int attlim) {
        throw new SimulatorException("Bracelets cannot be infused.");
    }

    @Override
    void setQuality(int quality) {
        throw new SimulatorException("Quality of bracelets cannot be changed.");
    }

    @Override
    void setSet(String set) {
    }

    void setStats(int att, int matt, int def, int hp) {
        setStats(0, 0, 0, 0, 0, hp, 0, att, matt, def, 0, 0, 0, 0, 0, 0, 0);
    }

    private void checkGems() {
        if (!gems) {
            resetStats();
            gems = true;
        }
    }

    private void setGems() {
        stats[5] = diamond[3] + sapphire[3] + ruby[3] + emerald[3];
        stats[7] = diamond[0] + sapphire[0] + ruby[0] + emerald[0];
        stats[8] = diamond[1] + sapphire[1] + ruby[1] + emerald[1];
        stats[9] = diamond[2] + sapphire[2] + ruby[2] + emerald[2];
        evaluate();
    }

    void resetGems() {
        diamond = new int[4];
        sapphire = new int[4];
        ruby = new int[4];
        emerald = new int[4];
        setGems();
    }

    void setDiamond(int att, int matt, int def, int hp) {
        checkGems();
        diamond = new int[] {att, matt, def, hp};
        setGems();
    }

    void setSapphire(int att, int matt, int def, int hp) {
        checkGems();
        sapphire = new int[] {att, matt, def, hp};
        setGems();
    }

    void setRuby(int att, int matt, int def, int hp) {
        checkGems();
        ruby = new int[] {att, matt, def, hp};
        setGems();
    }

    void setEmerald(int att, int matt, int def, int hp) {
        checkGems();
        emerald = new int[] {att, matt, def, hp};
        setGems();
    }
}

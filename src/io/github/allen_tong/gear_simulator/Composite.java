package io.github.allen_tong.gear_simulator;

abstract class Composite extends Equipment {
    int[] enhancement = new int[Hero.STAT_COUNT];

    abstract void setEnhancement(int level);

    boolean composite = false;

    abstract void setComposite();

    abstract void resetComposite();

    @Override
    void evaluate() {
        super.evaluate();
        for (int i = 0; i < totalStats.length; i++) {
            totalStats[i] += enhancement[i];
        }
    }

    @Override
    void setStats(int str, int agi, int intel, int wil, int luk, int hp, int sta,
                  int att, int matt, int def, int bal, int crit, int critdmg,
                  int critresist, int spd, int adddmg, int attlim) {
        resetComposite();
        stats = new int[] {str, agi, intel, wil, luk, hp, sta, att, matt, def,
                bal, crit, critdmg, critresist, spd, adddmg, attlim};
        evaluate();
    }

    void checkComposite() {
        if (!composite) {
            resetStats();
            composite = true;
        }
    }
}

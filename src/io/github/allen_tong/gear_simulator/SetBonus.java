package io.github.allen_tong.gear_simulator;

class SetBonus {
    private static final int[] outfitx1 = {0, 0, 0, 0, 0, 0, 0, 10, 10, 0, 0, 0, 0, 0, 0, 0, 0};
    private static final int[] outfitx2 = {0, 0, 0, 0, 0, 0, 0, 25, 25, 0, 0, 0, 0, 0, 0, 0, 0};
    private static final int[] outfitx3 = {0, 0, 0, 0, 0, 0, 0, 45, 45, 0, 0, 0, 0, 0, 0, 0, 0};
    private static final int[] outfitx4 = {0, 0, 0, 0, 0, 0, 0, 75, 75, 0, 0, 0, 0, 0, 0, 0, 0};
    private static final int[] outfitx5 = {0, 0, 0, 0, 0, 0, 0, 150, 150, 0, 0, 0, 0, 0, 0, 0, 0};
    private static final int[] lv90x3 = {60, 0, 81, 0, 0, 120, 5, 0, 0, 165, 0, 0, 0, 0, 0, 0, 0};
    private static final int[] lv90x4 = {80, 0, 108, 0, 0, 160, 6, 0, 0, 220, 0, 0, 0, 0, 0, 0, 0};
    private static final int[] lv90x5 = {100, 0, 135, 0, 0, 200, 7, 0, 0, 275, 0, 0, 0, 0, 0, 0, 0};
    private static final int[] lv90x6 = {120, 0, 162, 0, 0, 240, 10, 0, 0, 330, 0, 0, 0, 0, 0, 0, 0};
    private static final int[] lv95x3 = {67, 0, 91, 0, 0, 170, 5, 0, 0, 215, 0, 0, 0, 0, 0, 0, 0};
    private static final int[] lv95x4 = {87, 0, 118, 0, 0, 210, 6, 0, 0, 270, 0, 0, 0, 0, 0, 0, 0};
    private static final int[] lv95x5 = {107, 0, 145, 0, 0, 250, 7, 0, 0, 325, 0, 0, 0, 0, 0, 0, 0};
    private static final int[] lv95x6 = {127, 0, 172, 0, 0, 290, 10, 0, 0, 380, 0, 0, 0, 0, 0, 0, 0};
    private static final int[] frozen = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0};

    static int[] getSetStats(Equipment[] gear) {
        int[] setStats = new int[Hero.STAT_COUNT];
        int[] sets = new int[8];
        for (Equipment equip : gear) {
            if (equip != null && equip.set != null) {
                switch (equip.set) {
                    case "Outfit":
                        sets[0]++;
                        break;
                    case "Regina":
                        sets[1]++;
                        break;
                    case "Braha":
                        sets[2]++;
                        break;
                    case "Terminus Sentinel":
                        sets[3]++;
                        break;
                    case "Lugh Lamhfada":
                        sets[4]++;
                        break;
                    case "Abomination":
                        sets[5]++;
                        break;
                    case "Dullahan":
                        sets[6]++;
                        break;
                    case "Frozen Ring":
                        sets[7]++;
                        break;
                    default:
                        throw new SimulatorException("Unrecognized set: " + equip.set);
                }
            }
        }
        switch (sets[0]) {
            case 1:
                addSet(setStats, outfitx1);
                break;
            case 2:
                addSet(setStats, outfitx2);
                break;
            case 3:
                addSet(setStats, outfitx3);
                break;
            case 4:
                addSet(setStats, outfitx4);
                break;
            case 5:
                addSet(setStats, outfitx5);
                break;
        }
        for (int i = 1; i <= 5; i++) {
            switch (sets[i]) {
                case 3:
                    addSet(setStats, lv90x3);
                    break;
                case 4:
                    addSet(setStats, lv90x4);
                    break;
                case 5:
                    addSet(setStats, lv90x5);
                    break;
                case 6:
                    addSet(setStats, lv90x6);
                    break;
            }
        }
        switch (sets[6]) {
            case 3:
                addSet(setStats, lv95x3);
                break;
            case 4:
                addSet(setStats, lv95x4);
                break;
            case 5:
                addSet(setStats, lv95x5);
                break;
            case 6:
                addSet(setStats, lv95x6);
                break;
        }
        switch (sets[7]) {
            case 2:
                addSet(setStats, frozen);
                break;
        }
        return setStats;
    }

    private static void addSet(int[] setStats, int[] toAdd) {
        for (int i = 0; i < setStats.length; i++) {
            setStats[i] += toAdd[i];
        }
    }
}

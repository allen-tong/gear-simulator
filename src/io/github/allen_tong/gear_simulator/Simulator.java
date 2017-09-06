package io.github.allen_tong.gear_simulator;

public class Simulator {
    public static void main(String[] args) {
        try {
            Hero lynn = new Hero("Altalyn", "Lynn");
            lynn.setBaseStats(1203, 1188, 883, 1166, 7803, 202, 1, 1, 0, 0);
            lynn.setDefenseMasteryRank("3");
            lynn.setStoneSkinRank("6");
            lynn.setArmorMasteryRank("8");
            lynn.setCriticalHitRank("3");

            Weapon brahaGlaive = new Weapon("Braha");
            brahaGlaive.setEssence(6913, 6754, 3, 0);
            brahaGlaive.setKeen(28, 29, 0);
            brahaGlaive.setStable(43, 36, 20, 50, 27, 0);
            brahaGlaive.setLightweight(20, 4, 0);
            brahaGlaive.setPerfect(4631, 4535, 60, 31, 78, 44, 0);
            brahaGlaive.setEnhancement(11);
            brahaGlaive.setPrefix(Enchants.ENHANCED);
            brahaGlaive.setSuffix(Enchants.BLOODLUST);

            Weapon dullaGlaive = new Weapon("Dullahan");
            dullaGlaive.setEssence(8170, 8170, 2, 0);
            dullaGlaive.setKeen(24, 36, 0);
            dullaGlaive.setStable(36, 35, 19, 47, 25, 0);
            dullaGlaive.setLightweight(24, 4, 0);
            dullaGlaive.setPerfect(5446, 5446, 52, 28, 70, 38, 0);
            dullaGlaive.setEnhancement(10);
            dullaGlaive.setPrefix(Enchants.IMPENDING);
            dullaGlaive.setSuffix(Enchants.DIVINE_PUNISHMENT);

            Armor helm = new Armor("Braha");
            helm.setEssence(1240, 3, 0);
            helm.setSolid(142, 71, 192, 63, 11, 0);
            helm.setEnhancement(10);
            helm.setPrefix(Enchants.WELL_BALANCED);
            helm.setSuffix(Enchants.SENTINEL);

            Armor tunic = new Armor("Braha");
            tunic.setEssence(783, 3, 0);
            tunic.setSolid(142, 71, 192, 63, 11, 0);
            tunic.setSmooth(622, 3, 0);
            tunic.setEnhancement(10);
            tunic.setPrefix(Enchants.ENDURING);
            tunic.setSuffix(Enchants.MASTER);

            Armor pants = new Armor("Braha");
            pants.setEssence(718, 6, 0);
            pants.setSolid(142, 71, 192, 63, 11, 0);
            pants.setSmooth(622, 3, 0);
            pants.setEnhancement(10);
            pants.setPrefix(Enchants.WELL_BALANCED);
            pants.setSuffix(Enchants.ENTHUSIASTIC);

            Armor gloves = new Armor("Braha");
            gloves.setEssence(1240, 3, 0);
            gloves.setSolid(142, 71, 192, 63, 11, 0);
            gloves.setEnhancement(10);
            gloves.setPrefix(Enchants.WELL_BALANCED);
            gloves.setSuffix(Enchants.SENTINEL);

            Armor boots = new Armor("Braha");
            boots.setEssence(1240, 3, 0);
            boots.setSolid(142, 71, 192, 63, 11, 0);
            boots.setEnhancement(10);
            boots.setPrefix(Enchants.WELL_BALANCED);
            boots.setSuffix(Enchants.RESISTANT);

            Accessory earrings = new Accessory();
            earrings.setStats(85, 20, 5, 32, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
            earrings.setPrefix(Enchants.WARLORDS);
            earrings.setSuffix(Enchants.HEALTHY);

            Accessory belt = new Accessory();
            belt.setStats(120, 90, 0, 90, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
            belt.setPrefix(Enchants.PETITE);
            belt.setSuffix(Enchants.HEALTHY);

            Accessory jewelry = new Accessory();
            jewelry.setStats(48, 48, 48, 48, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0);
            jewelry.setPrefix(Enchants.SIGNIFICANT);
            jewelry.setSuffix(Enchants.PASSION);
            jewelry.setInfusion(0, 0, 0, 0, 0, 0, 0, 0, 0, 103, 0, 0, 0, 0, 0, 0, 0);

            Accessory frozenThorn = new Accessory();
            frozenThorn.setStats(140, 70, 0, 80, 0, 125, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0);
            frozenThorn.setPrefix(Enchants.SPARKLING);
            frozenThorn.setSuffix(Enchants.PASSION);

            Accessory ring2 = new Accessory();
            ring2.setStats(130, 70, 70, 70, 0, 100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
            ring2.setPrefix(Enchants.SPARKLING);
            ring2.setSuffix(Enchants.HEALTHY);

            Bracelet bracelet1 = new Bracelet();
            bracelet1.setRuby(21, 27, 15, 216);
            bracelet1.setEmerald(33, 38, 387, 35);

            Bracelet bracelet2 = new Bracelet();
            bracelet2.setDiamond(275, 36, 29, 44);
            bracelet2.setSapphire(26, 138, 29, 27);

            Accessory artifact = new Accessory();
            artifact.setPrefix(Enchants.SIGNIFICANT);
            artifact.setSuffix(Enchants.PASSION);

            Accessory necklace = new Accessory();
            necklace.setStats(10, 10, 10, 10, 0, 0, 0, 0, 0, 50, 0, 0, 0, 0, 0, 0, 0);
            necklace.setPrefix(Enchants.SIGNIFICANT);
            necklace.setSuffix(Enchants.BERSERKER);
            necklace.setInfusion(0, 0, 0, 0, 0, 0, 0, 0, 0, 102, 0, 0, 0, 0, 0, 0, 0);

            Outfit head = new Outfit(false);
            Outfit chest = new Outfit(false);
            Outfit leg = new Outfit(false);
            Outfit hand = new Outfit(false);
            Outfit feet = new Outfit(false);

//            lynn.equip("Weapon", brahaGlaive);
            lynn.equip("Weapon", dullaGlaive);
            lynn.equip("Helm", helm);
            lynn.equip("Tunic", tunic);
            lynn.equip("Pants", pants);
            lynn.equip("Gloves", gloves);
            lynn.equip("Boots", boots);
            lynn.equip("Earrings", earrings);
            lynn.equip("Belt", belt);
            lynn.equip("Jewelry", jewelry);
            lynn.equip("Ring 1", frozenThorn);
            lynn.equip("Ring 2", ring2);
            lynn.equip("Bracelet 1", bracelet1);
            lynn.equip("Bracelet 2", bracelet2);
            lynn.equip("Artifact", artifact);
            lynn.equip("Necklace", necklace);
            lynn.equip("Head", head);
            lynn.equip("Chest", chest);
            lynn.equip("Leg", leg);
            lynn.equip("Hand", hand);
            lynn.equip("Feet", feet);

            lynn.saveBuild("Current");

            Weapon ojDulla = new Weapon("Dullahan");
            ojDulla.setEssence((8258 + 8880) / 2, (8258 + 8880) / 2, (3 + 4) / 2, 0);
            ojDulla.setKeen((24 + 27) / 2, (36 + 40) / 2, 0);
            ojDulla.setStable((37 + 41) / 2, (35  + 44) / 2, (19 + 24) / 2, (47 + 59) / 2, (26 + 32) / 2, 0);
            ojDulla.setLightweight((24 + 27) / 2, (4 + 5) / 2, 0);
            ojDulla.setPerfect((5506 + 5920) / 2, (5506 + 5920) / 2, (53 + 66) / 2, (29 + 36) / 2, (71 + 89) / 2, (38 + 48) / 2, 0);
            ojDulla.setEnhancement(11);
            ojDulla.setPrefix(Enchants.RIGHTEOUS);
            ojDulla.setSuffix(Enchants.JUDGMENT);
            lynn.equip("Weapon", ojDulla);

            Accessory innocentCry = new Accessory();
            innocentCry.setStats(120, 42, 0, 53, 0, 0, 3, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0);
            innocentCry.setPrefix(Enchants.SIGNIFICANT);
            innocentCry.setSuffix(Enchants.PASSION);
            lynn.equip("Earrings", innocentCry);

            Accessory woefulBelt = new Accessory();
            woefulBelt.setStats(140, 90, 0, 100, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0);
            woefulBelt.setPrefix(Enchants.SUBDUED);
            woefulBelt.setSuffix(Enchants.PASSION);
            lynn.equip("Belt", woefulBelt);

            lynn.saveBuild("QB");

            lynn.getBuild("Current");
            lynn.print();
        } catch (SimulatorException e) {
            System.out.println(e.getMessage());
        }
    }
}

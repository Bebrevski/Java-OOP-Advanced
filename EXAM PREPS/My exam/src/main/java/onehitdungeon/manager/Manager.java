package onehitdungeon.manager;

import onehitdungeon.factories.HeroFactory;
import onehitdungeon.interfaces.DungeonManager;
import onehitdungeon.interfaces.Hero;
import onehitdungeon.interfaces.HeroTrainer;
import onehitdungeon.interfaces.IDungeon;
import onehitdungeon.models.Dungeon;
import onehitdungeon.models.heroes.BaseHero;
import onehitdungeon.models.heroes.Paladin;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Manager implements DungeonManager {

    private Map<String, Hero> heroes;

    private Hero selectedHero;

    private IDungeon dungeon;

    private HeroTrainer heroTrainer;

    public Manager(HeroTrainer heroTrainer, IDungeon dungeon) {
        this.heroes = new HashMap<>();
        this.dungeon = dungeon;

        this.heroTrainer = heroTrainer;
    }

    @Override
    public String hero(List<String> arguments) {
        Hero hero = HeroFactory.create(arguments);

        this.heroes.put(hero.getName(), hero);

        if (this.selectedHero == null) {
            this.selectedHero = hero;
        }

        return String.format("Successfully added %s - %s."
                , hero.getClass().getSimpleName()
                , hero.getName());
    }

    @Override
    public String select(List<String> arguments) {
        String name = arguments.get(1);

        Hero currentHero = this.heroes.get(name);

        this.selectedHero = currentHero;

        return String.format("Successfully selected %s - %s."
                , currentHero.getClass().getSimpleName()
                , name);
    }

    @Override
    public String status(List<String> arguments) {
        Integer timesTrained = 0;

        try {
            Field timesTrainedField = BaseHero.class.getDeclaredField("timesTrained");
            timesTrainedField.setAccessible(true);

            timesTrained = (Integer) timesTrainedField.get(this.selectedHero);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            System.out.println("****ERROR****Manager, status");
            e.printStackTrace();
        }

        StringBuilder sb = new StringBuilder();

        if (this.selectedHero instanceof Paladin) {
            sb
                    .append(String.format("%s - Lvl. %d Paladin"
                            , this.selectedHero.getName()
                            , timesTrained + 1))
                    .append(System.lineSeparator())
                    .append(String.format("* Mace - %d (BP)"
                            , this.selectedHero.getWeapon().getBattlePower()))
                    .append(System.lineSeparator())
                    .append(String.format("* Shield - %d (BP)"
                            , this.selectedHero.getOffhand().getBattlePower()))
                    .append(System.lineSeparator())
                    .append(String.format("* Cuirass - %d (BP)"
                            , this.selectedHero.getArmor().getBattlePower()))
                    .append(System.lineSeparator())
                    .append("####################")
                    .append(System.lineSeparator())
                    .append(String.format("Gold: %.2f"
                            , this.selectedHero.getGold()))
                    .append(System.lineSeparator())
                    .append(String.format("Upgrade cost: %.2f"
                            , this.selectedHero.getTotalPriceForUpgrade()));
            return sb.toString();
        } else {
            sb
                    .append(String.format("%s - Lvl. %d Mage"
                            , this.selectedHero.getName()
                            , timesTrained + 1))
                    .append(System.lineSeparator())
                    .append(String.format("* Staff - %d (BP)"
                            , this.selectedHero.getWeapon().getBattlePower()))
                    .append(System.lineSeparator())
                    .append(String.format("* Orb - %d (BP)"
                            , this.selectedHero.getOffhand().getBattlePower()))
                    .append(System.lineSeparator())
                    .append(String.format("* Cape - %d (BP)"
                            , this.selectedHero.getArmor().getBattlePower()))
                    .append(System.lineSeparator())
                    .append("####################")
                    .append(System.lineSeparator())
                    .append(String.format("Gold: %.2f", this.selectedHero.getGold()))
                    .append(System.lineSeparator())
                    .append(String.format("Upgrade cost: %.2f"
                            , this.selectedHero.getTotalPriceForUpgrade()));
            return sb.toString();
        }
    }

    @Override
    public String fight(List<String> arguments) {
        Integer heroBattlePower = this.selectedHero.getTotalBattlePower();
        Integer dungeonBattlePower = this.dungeon.getBattlePower();

        if (heroBattlePower >= dungeonBattlePower) {
            this.selectedHero.earnGold(this.dungeon.getGold());

            return String.format("Fight won. You've gained %.2f gold."
                    , this.dungeon.getGold());
        } else {
            this.dungeon.decreaseDungeonLevel();

            return "Fight lost. You've returned to the previous level.";
        }
    }

    @Override
    public String advance(List<String> arguments) {
        this.dungeon.updateDungeon();

        return String.format("Successfully advanced to dungeon level %d."
                , this.dungeon.getDungeonLevel());
    }

    @Override
    public String train(List<String> arguments) {
        Integer timesTrained = 0;

        if (this.selectedHero.getGold() >= this.selectedHero.getTotalPriceForUpgrade()) {

            this.selectedHero.payGold(this.selectedHero.getTotalPriceForUpgrade());

            this.heroTrainer.trainHero(this.selectedHero);

            Field timesTrainedField = null;
            try {
                timesTrainedField = BaseHero.class.getDeclaredField("timesTrained");
                timesTrainedField.setAccessible(true);

                timesTrained = (Integer) timesTrainedField.get(this.selectedHero);

                timesTrainedField.set(this.selectedHero, ++timesTrained);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }


            return String.format("Successfully trained hero. Current total battle power: %d."
                    , this.selectedHero.getTotalBattlePower());
        }


        return String.format("Insufficient gold for training. Needed %.2f. Got %.2f."
                , this.selectedHero.getTotalPriceForUpgrade()
                , this.selectedHero.getGold());
    }

    @Override
    public String quit(List<String> arguments) {
        StringBuilder sb = new StringBuilder();

        for (Hero hero : heroes.values()) {
            sb
                    .append(String.format("%s %s - %s (BP)"
                            , hero.getClass().getSimpleName()
                            , hero.getName()
                            , hero.getTotalBattlePower()))
                    .append(System.lineSeparator());
        }

        sb
                .append("####################")
                .append(System.lineSeparator())
                .append(String.format("Dungeon level reached: %d"
                        , this.dungeon.getDungeonLevel()));

        return sb.toString();
    }
}

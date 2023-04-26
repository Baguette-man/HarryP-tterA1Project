import characters.Wizard;
import items.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WizardTest {
    private Wizard wizard;

    @BeforeEach
    public void setUp() {
        wizard = new Wizard("John");
    }

    @Test
    public void testApplyAsset() {
        wizard.applyAsset("Hufflepuff");
        assertEquals(1.5, wizard.stats.get("Potions Efficiency"));

        wizard.applyAsset("Slytherin");
        assertEquals(1.5, wizard.stats.get("Spells Damages"));

        wizard.applyAsset("Gryffindor");
        assertEquals(1.5, wizard.stats.get("Shield"));

        wizard.applyAsset("Ravenclaw");
        assertEquals(0.75, wizard.stats.get("Spells Precision"));
    }

    @Test
    public void testDrinkPotion() throws InterruptedException {
        Potion potion = new Potion("Healing Potion", 50);
        double initialHP = wizard.getHealPoints();
        wizard.potions.add(potion);

        wizard.drinkPotion(potion, wizard);
        assertEquals(initialHP + 50 * wizard.stats.get("Potions Efficiency"), wizard.getHealPoints());
        assertTrue(wizard.potions.isEmpty());
    }

    @Test
    public void testLvlUp() {
        wizard.lvlUp();
        assertEquals(1.1, wizard.stats.get("Potions Efficiency"));
        assertEquals(1.1, wizard.stats.get("Spells Damages"));
        assertEquals(1.1, wizard.stats.get("Shield"));
        assertEquals(0.55, wizard.stats.get("Spells Precision"));
    }

    @Test
    public void testGetNewWeapon() {
        Weapon weapon = new Weapon("Sword", 50);
        wizard.getNewWeapon(weapon);
        assertTrue(wizard.weapons.contains(weapon));
    }
}
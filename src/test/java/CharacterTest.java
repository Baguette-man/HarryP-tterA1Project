import characters.Character;
import characters.Wizard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CharacterTest {
    private Character character;

    @BeforeEach
    public void setUp() {
        character = new Wizard("John");
    }

    @Test
    public void testIsCharacterAlive_alive() {
        character.setHealPoints(50);
        boolean isAlive = character.isCharacterAlive(character);
        assertTrue(isAlive);
    }

    @Test
    public void testIsCharacterAlive_dead() {
        character.setHealPoints(0);
        boolean isAlive = character.isCharacterAlive(character);
        assertFalse(isAlive);
    }

    @Test
    public void testIsCharacterAlive_negativeHP() {
        character.setHealPoints(-10);
        boolean isAlive = character.isCharacterAlive(character);
        assertFalse(isAlive);
    }
}
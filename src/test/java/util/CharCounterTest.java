package util;

import org.junit.Assert.*;
import org.junit.Test;
import util.CharCounter;

import static org.junit.Assert.assertEquals;

/**
 * Created by test on 6/6/2017.
 */
public class CharCounterTest {

    // characterProcessing_emptyString_returnEmptyString


    @Test
    public void characterProcessing_nullString_returnEmptyString_Test() {

        String result = CharCounter.characterProcessing(null);

        assertEquals("", result);

    }

    @Test
    public void characterProcessing_emptyString_returnEmptyString_Test() {

        String result = CharCounter.characterProcessing("");

        assertEquals("", result);

    }

    @Test
    public void characterProcessing_StringWithSpacesOnly_returnEmptyString_Test() {

        String result = CharCounter.characterProcessing("             ");

        assertEquals("", result);

    }


    @Test
    public void characterProcessing_StringWithNumeralsOnly_returnStringWithMaxNumerals_Test() {

        String result = CharCounter.characterProcessing("555 12 33 4445");

        assertEquals("The most frequent characters are 5 with 4 occurrences",
                result);

    }

    @Test
    public void characterProcessing_StringWithSpecialCharacters_returnStringWithMaxSpecialCharacters_Test() {

        String result = CharCounter.characterProcessing("Umpa Likes :) Lumpa!!!!!");

        assertEquals("The most frequent characters are ! with 5 occurrences",
                result);

    }


    @Test
    public void characterProcessing_StringWithCapitalCharacters_returnStringWithLowerCharactersCounts_Test() {

        String result = CharCounter.characterProcessing("UMPA IS ANGRY ON LUMPA");

        assertEquals("The most frequent characters are a with 3 occurrences",
                result);

    }

    @Test
    public void characterProcessing_SingleMaxCharacterString_returnSingleMaxCharacterString_Test() {

        String result = CharCounter.characterProcessing("Umpa and Lumpa went to market");

        assertEquals("The most frequent characters are a with 4 occurrences",
                result);

    }

    @Test
    public void characterProcessing_MultipleMaxCharacterString_returnMultipleMaxCharacterString_Test() {

        String result = CharCounter.
                characterProcessing("Umpa and Lumpa are lazy as hell but," +
                        " they will do the work");

        assertEquals("The most frequent characters are a, l with 6 occurrences",
                result);

    }

    @Test
    public void characterProcessing_StringWithExtendedAscii_returnStringWithExtendedAscii_Test() {

        String result = CharCounter.
                characterProcessing(" I like Umpa because Lumpa is sometimes ÄÅÉæÆö ");

        assertEquals("The most frequent characters are e with 5 occurrences",
                result);
    }
}

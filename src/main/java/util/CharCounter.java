package util;

import java.util.*;
import java.util.stream.Collectors;

/**
 *  Utility class for Character processing
 *
 * @author naveen.goswami
 * @since 6/5/2017
 */
public class CharCounter {

    private static final String EMPTY_STRING = "";

    /**
     * Process input String and returns result with maximum character count with currosponding characters
     *
     * @param inputString
     * @return String representation of result
     */
    public static String characterProcessing(String inputString) {

        /**
         * Checking for the null string, however it is unlikely,
         * but, lets be safe
         */
        if (inputString == null) {
            return EMPTY_STRING;
        }

        /**
         * Transforming the string to lower case and removing
         * the spaces from the string
         */
        inputString = inputString.toLowerCase().replaceAll("\\s+", "");

        if (inputString.isEmpty()) {
            return EMPTY_STRING;
        }

        /**
         * Convert the string to character array
         */
        char[] char_array = inputString.toCharArray();

        /**
         * Storing each character of the char_array in a HashMap as a key,
         * with occurrence of number of each character as values.
         */
        Map<Character, Integer> charCounter = new HashMap<>();

        for (int i = 0; i < inputString.length(); i++) {
            if (charCounter.containsKey(char_array[i])) {
                charCounter.put(char_array[i], charCounter.get(char_array[i]) + 1);
            } else {
                charCounter.put(char_array[i], 1);
            }
        }

        /**
         * resultMap contains at any given point of time only the count of maximum
         * appeared character in the input string as its key, with value containing
         * set of all characters with the maximum count.
         */
        Map<Integer, Set<Character>> resultMap = new HashMap<>();
        resultMap.put(
                /* Find value of max character count*/
                Collections.max(charCounter.values()),
                /* Doing a reverse look-up for fetching all characters with value of max
                character count*/
                getKeysByValue(charCounter, Collections.max(charCounter.values())));

        /**
         * Returning the final string with max characters and their occurances
         */
        return convertToString(resultMap);

    }

    /**
     * Accept a map and an integer and returns the set of character
     * with value set as passed integer
     *
     * @param map
     * @param maxCount
     * @return Set
     */
    private static Set<Character> getKeysByValue(Map<Character, Integer> map, Integer maxCount) {

        return map.entrySet()
                .stream()
                .filter(entry -> Objects.equals(entry.getValue(), maxCount))
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }

    /**
     * Generate the final string to be sent back to the caller
     *
     * @param map
     * @return result string
     */
    private static String convertToString(Map<Integer, Set<Character>> map) {
        return "The most frequent characters are " +
                map.values().
                        toString()
                        .replace("[", "")
                        .replace("]", "")
                + " with " +
                map.keySet().
                        toString()
                        .replace("[", "")
                        .replace("]", "")
                + " occurrences";
    }
}

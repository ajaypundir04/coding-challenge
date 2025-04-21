package generic;

import java.util.*;

/**
 * Utility class to flatten a nested ArrayList containing elements and other lists.
 */
public class FlattenList {

    /**
     * Flattens a nested list structure into a single list of objects.
     * @param nestedList the input list which can contain elements or other lists
     * @return a flat list containing all elements in depth-first order
     */
    public static List<Object> flatten(List<?> nestedList) {
        List<Object> result = new ArrayList<>();
        for (Object element : nestedList) {
            if (element instanceof List<?>) {
                // Recursively flatten sub-list
                result.addAll(flatten((List<?>) element));
            } else {
                // Add non-list element directly
                result.add(element);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // Example usage
        List<Object> mixed = new ArrayList<>();
        mixed.add(1);
        mixed.add(Arrays.asList(2, 3));
        mixed.add(Arrays.asList(Arrays.asList(4, 5), 6));
        mixed.add(7);
        mixed.add(Arrays.asList()); // empty list
        mixed.add(Arrays.asList(8, Arrays.asList(9, Arrays.asList(10))));

        System.out.println("Original nested list: " + mixed);
        List<Object> flat = flatten(mixed);
        System.out.println("Flattened list: " + flat);
    }
}

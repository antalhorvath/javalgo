package com.vathevor.javalgo.sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/*
 * The company is about to release a new order prioritization algorithm.
 * The orders have two types:
 *      - Premium
 *      - Other
 * The orders are given an alphanumeric identifier.
 *
 * In addition, the Premium orders also have metadata
 * that consists of a space delimited list of lowercase English letters.
 *
 * The non-Premium, but Other order also have metadata,
 * but it consists only of a space delimited string of positive integers.
 *
 * Each order is defined as their ID followed by a space and the space delimited metadata.
 *
 * Your task is to implement an algorithm that meets the following requirements:
 * - The primary orders should be returned first, sorted by their metadata
 *      - In case of ties, the identifier should be used for secondary order
 * - The primary orders should be followed by the other orders,
 *   in the original order they were in the list
 */
public class AmazonOrdering {

    private static final Predicate<String> PREMIUM_ORDER = order -> {
        int indexOfFirstSpace = order.indexOf(" ");
        String metadata = order.substring(indexOfFirstSpace + 1);
        return metadata.matches("[a-z ]*");
    };

    private static final Comparator<String> BY_METADATA_THEN_ID = (o1, o2) -> {
        int indexOfFirstSpaceInO1 = o1.indexOf(" ");
        String metadataOfO1 = o1.substring(indexOfFirstSpaceInO1 + 1);
        int indexOfFirstSpaceInO2 = o2.indexOf(" ");
        String metadataOfO2 = o1.substring(indexOfFirstSpaceInO2 + 1);
        int compareResult = metadataOfO1.compareTo(metadataOfO2);
        return compareResult != 0 ? compareResult : o1.compareTo(o2);
    };

    public List<String> getPrioritizedOrders(int numOrders, List<String> orderList) {

        List<String> result = orderList.stream()
                .filter(PREMIUM_ORDER)
                .sorted(BY_METADATA_THEN_ID)
                .collect(Collectors.toList());

        List<String> orders = new ArrayList<>(orderList);
        orders.removeAll(result);
        result.addAll(orders);
        return result;
    }
}

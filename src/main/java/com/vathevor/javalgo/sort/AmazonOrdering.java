package com.vathevor.javalgo.sort;

import java.util.Collections;
import java.util.List;

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

    public List<String> getPrioritizedOrders(int numOrders, List<String> orderList) {
        return Collections.emptyList();
    }
}

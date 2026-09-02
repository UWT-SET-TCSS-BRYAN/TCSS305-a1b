/*
 * TCSS 305 - Assignment 1b
 *
 * A short demonstration of the model classes you will be writing tests for.
 * Run this file first to watch the API work, then start on your test classes.
 *
 * This file is provided as a reference. You do not need to modify it.
 */

package edu.uw.tcss.app;

import static java.lang.IO.println;

import edu.uw.tcss.model.StoreItem;
import java.math.BigDecimal;

/**
 * Prints the result of every public {@code StoreItem} method to the console.
 *
 * <p>Compare this output against the API specification in the assignment
 * instructions. Anywhere the two disagree is a candidate for a bug report.
 *
 * <p>Two notes on the Java 25 syntax here. The {@code println} calls come from
 * {@code java.lang.IO}, a small console-I/O class new in this release, so
 * printing no longer has to go through {@code System.out}. Java 25 also added
 * compact source files, which would let a file this short drop the class
 * declaration and the package line and simply declare {@code void main()}.
 * This file deliberately does not use that form, because Checkstyle cannot
 * parse it yet. A language feature and the tools that check it do not arrive
 * together, and on a real team the tool everyone already depends on usually
 * decides the argument.
 *
 * @author Charles Bryan
 * @version Autumn 2026
 */
public final class StoreItemDemo {

    /** Unit price of the item used in the demonstration. */
    private static final BigDecimal LAPTOP_PRICE = BigDecimal.valueOf(999.99);

    /** Quantity used in the calculateTotal demonstrations. */
    private static final int DEMO_QUANTITY = 2;

    private StoreItemDemo() {
        super();
    }

    /**
     * Prints every public {@code StoreItem} method to the console.
     *
     * @param args command line arguments, ignored
     */
    public static void main(final String[] args) {
        final StoreItem laptop = new StoreItem("Laptop", LAPTOP_PRICE);

        // toString() is a debug representation. Its format is not part of the
        // specification, so do not write tests that depend on it.
        println("toString():                " + laptop);

        println("getName():                 " + laptop.getName());
        println("getPrice():                " + laptop.getPrice());

        // The second argument is the membership flag. StoreItem has no bulk
        // price, so it ignores that flag and both calls below print the same
        // total. StoreBulkItem is the class where the flag changes the answer.
        println("calculateTotal(2, false):  "
                + laptop.calculateTotal(DEMO_QUANTITY, false));
        println("calculateTotal(2, true):   "
                + laptop.calculateTotal(DEMO_QUANTITY, true));

        println("getFormattedDescription(): " + laptop.getFormattedDescription());
    }
}

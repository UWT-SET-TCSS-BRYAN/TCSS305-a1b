/*
 * TCSS 305 - Assignment 1b
 *
 * A short demonstration of the model classes you will be writing tests for.
 * Run this file first to watch the API work, then start on your test classes.
 *
 * This file is provided as a reference. You do not need to modify it.
 *
 * @author Charles Bryan
 * @version Autumn 2026
 */

// This file is a COMPACT SOURCE FILE (JEP 512, final in Java 25). Four things
// about it are new syntax you have probably not seen in TCSS 142/143:
//
// 1. There is no 'class' declaration. The compiler wraps everything below in a
//    class for you, so a file that is just a main method does not need the
//    "public class Foo { ... }" ceremony.
// 2. There is no 'package' statement, and there cannot be one: an implicitly
//    declared class always lives in the unnamed package. That is why this file
//    has no package line even though it sits in src/edu/uw/tcss/app/.
// 3. 'BigDecimal' is used below with no import for it. A compact source file
//    implicitly imports every package the java.base module exports, so
//    java.math.BigDecimal resolves for free. This does NOT apply to your test
//    classes -- those are ordinary source files in a package, so they need the
//    usual "import java.math.BigDecimal;" line.
// 4. main() is an INSTANCE main method: no 'public', no 'static', and no
//    String[] parameter. Java 25 lets main() be declared this way.
//
// java.lang.IO is also new in Java 25: a small console-I/O class holding
// println/readln. It still has to be imported, unlike the java.base packages
// in point 3 above.

import static java.lang.IO.println;

import edu.uw.tcss.model.StoreItem;

/**
 * Prints the result of every public {@code StoreItem} method to the console.
 *
 * <p>Compare this output against the API specification in the assignment
 * instructions. Anywhere the two disagree is a candidate for a bug report.
 */
void main() {
    final StoreItem laptop = new StoreItem("Laptop", BigDecimal.valueOf(999.99));

    // toString() is a debug representation. Its format is not part of the
    // specification, so do not write tests that depend on it.
    println("toString():               " + laptop);

    println("getName():                " + laptop.getName());
    println("getPrice():               " + laptop.getPrice());

    // The second argument is the membership flag. StoreItem has no bulk price,
    // so it ignores that flag -- both calls below print the same total.
    // StoreBulkItem is the class where the flag actually changes the answer.
    println("calculateTotal(2, false): " + laptop.calculateTotal(2, false));
    println("calculateTotal(2, true):  " + laptop.calculateTotal(2, true));

    println("getFormattedDescription(): " + laptop.getFormattedDescription());
}

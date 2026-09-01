/*
 * TCSS 305 - Assignment 1b
 *
 * This is an example test class demonstrating JUnit 6 testing patterns.
 * Study this file carefully before writing your own tests.
 */

package edu.uw.tcss.model;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for the {@link ItemOrder} record.
 *
 * <p>This test class demonstrates:
 * <ul>
 *   <li>Testing constructor validation (null checks, argument validation)</li>
 *   <li>Testing accessor methods</li>
 *   <li>Testing equals/hashCode contract</li>
 *   <li>Using assertThrows for exception testing</li>
 *   <li>Organizing tests by functionality</li>
 * </ul>
 *
 * @author Charles Bryan
 * @version Autumn 2026
 */
class ItemOrderTest {

    /*
     * Test data is pulled out into constants rather than repeated in every test.
     * Checkstyle flags a string literal that appears more than once
     * (MultipleStringLiterals) and an unexplained number (MagicNumber), so
     * repeating "Pen" or 5 in a dozen tests would generate a dozen warnings.
     * Do the same in your own test classes.
     */

    /** Item name shared by the tests below. */
    private static final String ITEM_NAME = "Pen";

    /** Item price shared by the tests below. */
    private static final BigDecimal ITEM_PRICE = new BigDecimal("1.99");

    /** Order quantity shared by the tests below. */
    private static final int QUANTITY = 5;

    // ============ Constructor Tests ============

    /**
     * Test constructor with valid arguments creates an ItemOrder successfully.
     */
    @Test
    void testConstructorWithValidArguments() {
        final Item item = new StoreItem(ITEM_NAME, ITEM_PRICE);
        final ItemOrder order = new ItemOrder(item, QUANTITY);

        assertNotNull(order, "Constructor should create a non-null ItemOrder");
    }

    /**
     * Test constructor with quantity of zero (boundary case - should be allowed).
     */
    @Test
    void testConstructorWithZeroQuantity() {
        final Item item = new StoreItem(ITEM_NAME, ITEM_PRICE);
        final ItemOrder order = new ItemOrder(item, 0);

        assertEquals(0, order.quantity(), "Quantity of zero should be allowed");
    }

    /**
     * Test constructor rejects null item with NullPointerException.
     *
     * <p>IntelliJ flags the {@code null} below because {@code ItemOrder}'s
     * component is annotated non-null, and it is right that no working program
     * would pass null here. Passing it anyway is the entire point of the test:
     * it proves the constructor rejects null instead of storing it. The
     * warning survives a correct implementation, so it is suppressed rather
     * than removed -- deleting the case would delete the guard.
     */
    @SuppressWarnings("DataFlowIssue")
    @Test
    void testConstructorRejectsNullItem() {
        assertThrows(NullPointerException.class,
            () -> new ItemOrder(null, QUANTITY),
            "Constructor should throw NullPointerException for null item");
    }

    /**
     * Test constructor rejects negative quantity with IllegalArgumentException.
     */
    @Test
    void testConstructorRejectsNegativeQuantity() {
        final Item item = new StoreItem(ITEM_NAME, ITEM_PRICE);

        assertThrows(IllegalArgumentException.class,
            () -> new ItemOrder(item, -1),
            "Constructor should throw IllegalArgumentException for negative quantity");
    }

    // ============ Accessor Tests ============

    /**
     * Test item() accessor returns the correct Item.
     */
    @Test
    void testItemAccessor() {
        final Item item = new StoreItem(ITEM_NAME, ITEM_PRICE);
        final ItemOrder order = new ItemOrder(item, QUANTITY);

        assertSame(item, order.item(),
            "item() should return the same Item passed to constructor");
    }

    /**
     * Test quantity() accessor returns the correct quantity.
     */
    @Test
    void testQuantityAccessor() {
        final Item item = new StoreItem(ITEM_NAME, ITEM_PRICE);
        final ItemOrder order = new ItemOrder(item, QUANTITY);

        assertEquals(QUANTITY, order.quantity(),
            "quantity() should return the quantity passed to constructor");
    }

    // ============ equals() Tests ============

    /**
     * Test equals() is reflexive: an object equals itself.
     *
     * <p>IntelliJ flags comparing a value with itself as a likely typo. Here it
     * is deliberate: reflexivity is the first clause of the {@code equals}
     * contract, and a class can genuinely break it. The warning survives a
     * correct implementation, so it is suppressed rather than removed.
     */
    @SuppressWarnings("EqualsWithItself")
    @Test
    void testEqualsReflexive() {
        final Item item = new StoreItem(ITEM_NAME, ITEM_PRICE);
        final ItemOrder order = new ItemOrder(item, QUANTITY);

        assertEquals(order, order, "An ItemOrder should equal itself");
    }

    /**
     * Test equals() is symmetric: if a.equals(b), then b.equals(a).
     */
    @Test
    void testEqualsSymmetric() {
        final Item item = new StoreItem(ITEM_NAME, ITEM_PRICE);
        final ItemOrder order1 = new ItemOrder(item, QUANTITY);
        final ItemOrder order2 = new ItemOrder(item, QUANTITY);

        assertEquals(order1, order2, "Equal ItemOrders should be equal");
        assertEquals(order2, order1, "Equality should be symmetric");
    }

    /**
     * Test equals() returns false for null.
     */
    @Test
    void testEqualsWithNull() {
        final Item item = new StoreItem(ITEM_NAME, ITEM_PRICE);
        final ItemOrder order = new ItemOrder(item, QUANTITY);

        assertNotEquals(null, order, "ItemOrder should not equal null");
    }

    /**
     * Test equals() returns false for different item.
     */
    @Test
    void testEqualsWithDifferentItem() {
        final Item item1 = new StoreItem(ITEM_NAME, ITEM_PRICE);
        final Item item2 = new StoreItem("Pencil", new BigDecimal("0.99"));
        final ItemOrder order1 = new ItemOrder(item1, QUANTITY);
        final ItemOrder order2 = new ItemOrder(item2, QUANTITY);

        assertNotEquals(order1, order2,
            "ItemOrders with different items should not be equal");
    }

    /**
     * Test equals() returns false for different quantity.
     */
    @Test
    void testEqualsWithDifferentQuantity() {
        final Item item = new StoreItem(ITEM_NAME, ITEM_PRICE);
        final ItemOrder order1 = new ItemOrder(item, QUANTITY);
        final ItemOrder order2 = new ItemOrder(item, 10);

        assertNotEquals(order1, order2,
            "ItemOrders with different quantities should not be equal");
    }

    // ============ hashCode() Tests ============

    /**
     * Test hashCode() is consistent with equals(): equal objects have equal hash codes.
     */
    @Test
    void testHashCodeConsistentWithEquals() {
        final Item item = new StoreItem(ITEM_NAME, ITEM_PRICE);
        final ItemOrder order1 = new ItemOrder(item, QUANTITY);
        final ItemOrder order2 = new ItemOrder(item, QUANTITY);

        assertEquals(order1, order2, "Orders should be equal");
        assertEquals(order1.hashCode(), order2.hashCode(),
            "Equal ItemOrders must have equal hash codes");
    }

    /**
     * Test hashCode() returns consistent values on multiple calls.
     */
    @Test
    void testHashCodeConsistent() {
        final Item item = new StoreItem(ITEM_NAME, ITEM_PRICE);
        final ItemOrder order = new ItemOrder(item, QUANTITY);

        final int hashCode1 = order.hashCode();
        final int hashCode2 = order.hashCode();

        assertEquals(hashCode1, hashCode2,
            "hashCode() should return consistent values");
    }

    // ============ toString() Test ============

    /**
     * Test toString() returns a non-null, non-empty string.
     * Note: We don't test the exact format since it's auto-generated by the record.
     */
    @Test
    void testToStringNotEmpty() {
        final Item item = new StoreItem(ITEM_NAME, ITEM_PRICE);
        final ItemOrder order = new ItemOrder(item, QUANTITY);

        final String str = order.toString();

        assertNotNull(str, "toString() should not return null");
        assertFalse(str.isEmpty(), "toString() should not return empty string");
    }
}

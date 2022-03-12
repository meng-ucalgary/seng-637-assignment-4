package org.jfree.data;

import static org.junit.Assert.*;
import org.junit.*;

public class RangeTest {
    private Range exampleRange;
    private Range originRange;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        this.exampleRange = new Range(-10, 10);
        this.originRange = new Range(0.0, 0.0);
    }

    // test cases for isNaNRange() --------------------------------------------
    @Test
    public void isNaNRangeWithBothBoundNOM() {
        assertEquals("Testing the range that has different NOM bounds", false, this.exampleRange.isNaNRange());
    }

    @Test
    public void isNaNRangeWithBothBoundSameNOM() {
        Range testRange = new Range(10, 10);
        assertEquals("Testing the range that has same NOM bounds", false, testRange.isNaNRange());
    }

    @Test
    public void isNaNRangeWithLowerBoundMin() {
        Range testRange = new Range(-Double.MAX_VALUE, 10);
        assertEquals("Testing the range that has lower bound as minimum possible value", false, testRange.isNaNRange());
    }

    @Test
    public void isNaNRangeWithUpperBoundMax() {
        Range testRange = new Range(10, Double.MAX_VALUE);
        assertEquals("Testing the range that has upper bound as maximum possible value", false, testRange.isNaNRange());
    }

    @Test
    public void isNaNRangeWithLowerBoundNaN() {
        Range testRange = new Range(Double.NaN, 10);
        assertEquals("Testing the range that has lower bound as NaN", false, testRange.isNaNRange());
    }

    @Test
    public void isNaNRangeWithUpperBoundNaN() {
        Range testRange = new Range(-10, Double.NaN);
        assertEquals("Testing the range that has upper bound as NaN", false, testRange.isNaNRange());
    }

    @Test
    public void isNaNRangeWithBothBoundNaN() {
        Range testRange = new Range(Double.NaN, Double.NaN);
        assertEquals("Testing the range that has both bounds as NaN", true, testRange.isNaNRange());
    }
    // ------------------------------------------------------------------------

    // test cases for shift(Range, double, boolean) ---------------------------
    @Test
    public void shiftRightToMaxValueAtZeroRangeAllowZeroCrossing() {
        Range rangeShift = Range.shift(originRange, Double.MAX_VALUE, true);
        Range expected = new Range(Double.MAX_VALUE, Double.MAX_VALUE);
        assertTrue("A shift of Double.MAX_VALUE should return a range of (Double.MAX_VALUE, Double.MAX_VALUE)",
                rangeShift.equals(expected));
    }

    @Test
    public void shiftRightAtZeroRangeDisallowZeroCrossing() {
        Range rangeShift = Range.shift(originRange, 4.0, false);
        Range expected = new Range(4.0, 4.0);
        assertTrue("A shift of 4.0 should return a range of (4.0, 4.0)", rangeShift.equals(expected));
    }

    @Test
    public void shiftLeftToMinValueAtZeroRangeAllowZeroCrossing() {
        Range rangeShift = Range.shift(originRange, Double.MIN_VALUE, true);
        Range expected = new Range(Double.MIN_VALUE, Double.MIN_VALUE);
        assertTrue("A shift of Double.MIN_VALUE should return a range of (Double.MIN_VALUE, Double.MIN_VALUE)",
                rangeShift.equals(expected));
    }

    @Test
    public void shiftLeftAtZeroRangeDisallowZeroCrossing() {
        Range rangeShift = Range.shift(originRange, -5.0, false);
        Range expected = new Range(-5.0, -5.0);
        assertTrue("A shift of -5.0 should return a range of (-5.0, -5.0)", rangeShift.equals(expected));
    }

    @Test
    public void shiftRightNegativeRangeAllowZeroCrossingForLbAndUb() {
        Range negativeRange = new Range(-10.0, -5.0);
        Range rangeShift = Range.shift(negativeRange, 15.0, true);
        Range expected = new Range(5.0, 10.0);
        assertTrue("A shift of 15.0 should return a range of (5.0, 10.0)", rangeShift.equals(expected));
    }

    @Test
    public void shiftRightNegativeRangeDisallowZeroCrossingForLbAndUb() {
        Range negativeRange = new Range(-10.0, -5.0);
        Range rangeShift = Range.shift(negativeRange, 18.0, false);
        Range expected = new Range(0.0, 0.0);
        assertTrue("A shift of 18.0 should return a range of (0.0, 0.0)", rangeShift.equals(expected));
    }

    @Test
    public void shiftLeftPostiveRangeAllowZeroCrossingForLbAndUb() {
        Range positiveRange = new Range(5.0, 7.0);
        Range rangeShift = Range.shift(positiveRange, -10.0, true);
        Range expected = new Range(-5.0, -3.0);
        assertTrue("A shift of -10.0 should return a range of (-5.0, -3.0)", rangeShift.equals(expected));
    }

    @Test
    public void shiftLeftPostiveRangeDisallowZeroCrossingForLbAndUb() {
        Range positiveRange = new Range(5.0, 7.0);
        Range rangeShift = Range.shift(positiveRange, -9.0, false);
        Range expected = new Range(0.0, 0.0);
        assertTrue("A shift of -9.0 should return a range of (0.0, 0.0)", rangeShift.equals(expected));
    }

    @Test
    public void shiftRightNegativeLbAndPostiveUbRangeDisallowZeroCrossing() {
        Range range = new Range(-3.0, 7.0);
        Range rangeShift = Range.shift(range, 6.0, false);
        Range expected = new Range(0.0, 13.0);
        assertTrue("A shift of 6.0 should return a range of (0.0, 13.0)", rangeShift.equals(expected));
    }

    @Test
    public void shiftLeftNegativeLbAndPostiveUbRangeDisallowZeroCrossing() {
        Range range = new Range(-3.0, 7.0);
        Range rangeShift = Range.shift(range, -8.0, false);
        Range expected = new Range(-11.0, 0.0);
        assertTrue("A shift of -8.0 should return a range of (-11.0, 0.0)", rangeShift.equals(expected));
    }
    // ------------------------------------------------------------------------

    // test cases for intersects(double, double) ------------------------------
    @Test
    public void intersectsWithInputBLBAndLB() {
        assertFalse(this.exampleRange.intersects(-10.00001, -10));
    }

    @Test
    public void intersectsWithInputBLBAndALB() {
        assertTrue(this.exampleRange.intersects(-10.00001, -9.99999));
    }

    @Test
    public void intersectsWithInputBLBAndAUB() {
        assertTrue(this.exampleRange.intersects(-10.00001, 10.00001));
    }

    @Test
    public void intersectsWithInputLBAndALB() {
        assertTrue(this.exampleRange.intersects(-10, -9.99999));
    }

    @Test
    public void intersectsWithInputLBAndUB() {
        assertTrue(this.exampleRange.intersects(-10, 10));
    }

    @Test
    public void intersectsWithInputNOMAndNOM() {
        assertTrue(this.exampleRange.intersects(-1, 1));
    }

    @Test
    public void intersectsWithInputBUBAndUB() {
        assertTrue(this.exampleRange.intersects(9.99999, 10));
    }

    @Test
    public void intersectsWithInputUBAndAUB() {
        assertFalse(this.exampleRange.intersects(10, 10.00001));
    }

    @Test
    public void intersectsWithInputMINAndAUB() {
        assertTrue(this.exampleRange.intersects(Double.MIN_VALUE, 10.00001));
    }

    @Test
    public void intersectsWithInputBLBAndMAX() {
        assertTrue(this.exampleRange.intersects(-10.00001, Double.MAX_VALUE));
    }

    @Test
    public void intersectsWithInput0And0() {
        assertTrue(this.exampleRange.intersects(0, 0));
    }

    @Test
    public void intersectsWithInputNaNAnd1() {
        assertTrue(this.exampleRange.intersects(Double.NaN, 1));
    }

    // new test cases ---------------------------------------------------------
    @Test
    public void intersectsWithReverse() {
        assertTrue(this.exampleRange.intersects(-6, -9));
    }
    // ------------------------------------------------------------------------

    // test cases for expandToInclude -----------------------------------------
    @Test
    public void expandToIncludeWithInputBLB() {
        assertEquals("Testing epanding range to include value BLB", new Range(-10.00001, 10),
                Range.expandToInclude(this.exampleRange, -10.00001));
    }

    @Test
    public void expandToIncludeWithInputLB() {
        assertEquals("Testing epanding range to include value at LB (range shouldn't change)", new Range(-10, 10),
                Range.expandToInclude(this.exampleRange, -10));
    }

    @Test
    public void expandToIncludeWithInputALB() {
        assertEquals("Testing epanding range to include value ALB (range shouldn't change)", new Range(-10, 10),
                Range.expandToInclude(this.exampleRange, -9.99999));
    }

    @Test
    public void expandToIncludeWithInputBUB() {
        assertEquals("Testing epanding range to include value BUB (range shouldn't change)", new Range(-10, 10),
                Range.expandToInclude(this.exampleRange, 9.99999));
    }

    @Test
    public void expandToIncludeWithInputUB() {
        assertEquals("Testing epanding range to include value at UB (range shouldn't change)", new Range(-10, 10),
                Range.expandToInclude(this.exampleRange, 10));
    }

    @Test
    public void expandToIncludeWithInputAUB() {
        assertEquals("Testing epanding range to include value AUB ", new Range(-10, 10.00001),
                Range.expandToInclude(this.exampleRange, 10.00001));
    }

    @Test
    public void expandToIncludeWithInputPositive() {
        assertEquals("Testing epanding range to include value at LB (range shouldn't change)", new Range(-10, 25),
                Range.expandToInclude(this.exampleRange, 25));
    }

    @Test
    public void expandToIncludeWithInputNegative() {
        assertEquals("Testing epanding range to include value at LB (range shouldn't change)", new Range(-25, 10),
                Range.expandToInclude(this.exampleRange, -25));
    }

    @Test
    public void expandToIncludeWithInputDoubleMax() {
        assertEquals("Testing epanding range to include max double", new Range(-10, Double.MAX_VALUE),
                Range.expandToInclude(this.exampleRange, Double.MAX_VALUE));
    }

    @Test
    public void expandToIncludeWithInputNegativeDoubleMax() {
        assertEquals("Testing epanding range to include negative max double", new Range(-Double.MAX_VALUE, 10),
                Range.expandToInclude(this.exampleRange, -Double.MAX_VALUE));
    }

    // new test cases ---------------------------------------------------------
    @Test
    public void expandToIncludeWithNullRange() {
        assertEquals("Testing epanding range to include Null Range", new Range(10, 10),
                Range.expandToInclude(null, 10));
    }
    // ------------------------------------------------------------------------

    // test cases for combineIgnoringNaN(Range, Range) ------------------------
    @Test
    public void combineIgnoringNaNWithSmallerRange() {
        Range r2 = new Range(-5, 6);
        assertEquals("Testing combining with already included range", new Range(-10, 10),
                Range.combineIgnoringNaN(this.exampleRange, r2));
    }

    @Test
    public void combineIgnoringNaNWithDisjointRange() {
        Range r2 = new Range(20, 50);
        assertEquals("Testing combining with disjoint range", new Range(-10, 50),
                Range.combineIgnoringNaN(this.exampleRange, r2));
    }

    @Test
    public void combineIgnoringNaNWithNull() {
        Range r2 = null;
        assertEquals("Testing combining with null", this.exampleRange, Range.combineIgnoringNaN(this.exampleRange, r2));
    }

    @Test
    public void combineIgnoringNaNWithLowerBoundMinimum() {
        Range r2 = new Range(-Double.MAX_VALUE, -20);
        assertEquals("Testing combining with range that has lower bound as minimum possible value",
                new Range(-Double.MAX_VALUE, 10),
                Range.combineIgnoringNaN(this.exampleRange, r2));
    }

    @Test
    public void combineIgnoringNaNWithLowerBoundNaN() {
        Range r2 = new Range(Double.NaN, -20);
        assertEquals("Testing combining with range that has lower bound as NaN",
                new Range(-10, 10),
                Range.combineIgnoringNaN(this.exampleRange, r2));
    }

    @Test
    public void combineIgnoringNaNWithLB() {
        Range r2 = new Range(-10, 20);
        assertEquals("Testing combining with range that has lower bound as LB",
                new Range(-10, 20),
                Range.combineIgnoringNaN(this.exampleRange, r2));
    }

    @Test
    public void combineIgnoringNaNWithALB() {
        Range r2 = new Range(-9.99999, 20);
        assertEquals("Testing combining with range that has lower bound as ALB",
                new Range(-10, 20),
                Range.combineIgnoringNaN(this.exampleRange, r2));
    }

    @Test
    public void combineIgnoringNaNWithBLB() {
        Range r2 = new Range(-10.00001, 20);
        assertEquals("Testing combining with range that has lower bound as BLB",
                new Range(-10.00001, 20),
                Range.combineIgnoringNaN(this.exampleRange, r2));
    }

    @Test
    public void combineIgnoringNaNWithUpperBoundMaximum() {
        Range r2 = new Range(20, Double.MAX_VALUE);
        assertEquals("Testing combining with range that has upper bound as maximum possible value",
                new Range(-10, Double.MAX_VALUE),
                Range.combineIgnoringNaN(this.exampleRange, r2));
    }

    @Test
    public void combineIgnoringNaNWithUpperBoundNaN() {
        Range r2 = new Range(20, Double.NaN);
        assertEquals("Testing combining with range that has upper bound as NaN",
                new Range(-10, 10),
                Range.combineIgnoringNaN(this.exampleRange, r2));
    }

    @Test
    public void combineIgnoringNaNWithUB() {
        Range r2 = new Range(-20, 10);
        assertEquals("Testing combining with range that has upper bound as UB",
                new Range(-20, 10),
                Range.combineIgnoringNaN(this.exampleRange, r2));
    }

    @Test
    public void combineIgnoringNaNWithAUB() {
        Range r2 = new Range(-20, 10.00001);
        assertEquals("Testing combining with range that has upper bound as AUB",
                new Range(-20, 10.00001),
                Range.combineIgnoringNaN(this.exampleRange, r2));
    }

    @Test
    public void combineIgnoringNaNWithBUB() {
        Range r2 = new Range(-20, 9.99999);
        assertEquals("Testing combining with range that has upper bound as BUB",
                new Range(-20, 10),
                Range.combineIgnoringNaN(this.exampleRange, r2));
    }

    @Test
    public void combineIgnoringNaNWithBothBoundNaN() {
        Range r2 = new Range(Double.NaN, Double.NaN);
        assertEquals("Testing combining with range that has both bounds as NaN",
                new Range(-10, 10),
                Range.combineIgnoringNaN(this.exampleRange, r2));
    }

    @Test
    public void combineIgnoringNaNWithZeroRange() {
        Range r2 = new Range(0, 0);
        assertEquals("Testing combining with range that spans 0 to 0 has effective range of 0",
                new Range(-10, 10),
                Range.combineIgnoringNaN(this.exampleRange, r2));
    }

    @Test
    public void combineIgnoringNaNWithItself() {
        assertEquals("Testing combining the range with itself", this.exampleRange,
                Range.combineIgnoringNaN(this.exampleRange, this.exampleRange));
    }

    // new test cases ---------------------------------------------------------
    @Test
    public void combineIgnoringNaNWithFirstRangeNull() {
        Range r2 = null;
        assertEquals("Testing combining with range with first range as null",
                new Range(-10, 10),
                Range.combineIgnoringNaN(r2, this.exampleRange));
    }

    @Test
    public void combineIgnoringNaNWithFirstRangeNullSecondRangeNaN() {
        Range r1 = null;
        Range r2 = new Range(Double.NaN, Double.NaN);
        assertEquals("Testing combining first range null and second range having NaN bounds", null,
                Range.combineIgnoringNaN(r1, r2));
    }

    @Test
    public void combineIgnoringNaNWithBothRangeNull() {
        assertEquals("Testing combining with both range null", null,
                Range.combineIgnoringNaN(null, null));
    }

    @Test
    public void combineIgnoringNaNWithFirstRangeNaNSecondRangeNull() {
        Range r1 = new Range(Double.NaN, Double.NaN);
        assertEquals("Testing combining first range NaN and second range null", null,
                Range.combineIgnoringNaN(r1, null));
    }

    @Test
    public void combineIgnoringNaNWithBothRangeNaN() {
        Range r1 = new Range(Double.NaN, Double.NaN);
        Range r2 = new Range(Double.NaN, Double.NaN);
        assertEquals("Testing combining with both range NaN", null, Range.combineIgnoringNaN(r1, r2));
    }

    @Test
    public void combineIgnoringNaNWithMaxBoundNaN() {
        Range r1 = new Range(-10, Double.NaN);
        Range r2 = new Range(-10, Double.NaN);
        assertEquals("Testing combining with max bound NaN", new Range(-10, Double.NaN),
                Range.combineIgnoringNaN(r1, r2));
    }

    @Test
    public void combineIgnoringNaNWithMinBoundNaN() {
        Range r1 = new Range(Double.NaN, 10);
        Range r2 = new Range(Double.NaN, 10);
        assertEquals("Testing combining with min bound NaN", new Range(Double.NaN, 10),
                Range.combineIgnoringNaN(r1, r2));
    }
    // ------------------------------------------------------------------------

    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}

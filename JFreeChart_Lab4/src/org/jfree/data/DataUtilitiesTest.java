package org.jfree.data;

import static org.junit.Assert.*;
import org.junit.*;
import org.jmock.*;

public class DataUtilitiesTest {
    private Mockery mockingContext;
    private Values2D values;
    private KeyedValues kv;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        this.mockingContext = new Mockery();
        this.values = this.mockingContext.mock(Values2D.class);
        this.kv = mockingContext.mock(KeyedValues.class);
    }

    // test cases for calculateRowTotal(Values2D, int) ------------------------
    @Test
    public void calculateRowTotalFirstRow() {
        mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
                will(returnValue(3));
                one(values).getValue(0, 0);
                will(returnValue(7.5));
                one(values).getValue(0, 1);
                will(returnValue(2.5));
                one(values).getValue(0, 2);
                will(returnValue(5.0));
            }
        });

        double result = DataUtilities.calculateRowTotal(values, 0);
        assertEquals(15.0, result, .000000001d);
    }

    @Test
    public void calculateRowTotalMiddleRow() {
        mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
                will(returnValue(3));
                one(values).getValue(1, 0);
                will(returnValue(7.5));
                one(values).getValue(1, 1);
                will(returnValue(2.5));
                one(values).getValue(1, 2);
                will(returnValue(5.0));
            }
        });

        double result = DataUtilities.calculateRowTotal(values, 1);
        assertEquals(15.0, result, .000000001d);
    }

    @Test
    public void calculateRowTotalLastRow() {
        mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
                will(returnValue(3));
                one(values).getValue(2, 0);
                will(returnValue(7.5));
                one(values).getValue(2, 1);
                will(returnValue(2.5));
                one(values).getValue(2, 2);
                will(returnValue(5.0));
            }
        });

        double result = DataUtilities.calculateRowTotal(values, 2);
        assertEquals(15.0, result, .000000001d);
    }

    @Test
    public void calculateRowTotalWithSumOf0AndFirstRow() {
        mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
                will(returnValue(3));
                one(values).getValue(0, 0);
                will(returnValue(7.5));
                one(values).getValue(0, 1);
                will(returnValue(2.5));
                one(values).getValue(0, 2);
                will(returnValue(-10));
            }
        });
        double result = DataUtilities.calculateRowTotal(values, 0);
        assertEquals(0, result, .000000001d);
    }

    @Test
    public void calculateRowTotalWithMinValueAndFirstRow() {
        mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
                will(returnValue(3));
                one(values).getValue(0, 0);
                will(returnValue(Math.pow(2, -53)));
                one(values).getValue(0, 1);
                will(returnValue(2.5));
                one(values).getValue(0, 2);
                will(returnValue(-2.5));
            }
        });

        double result = DataUtilities.calculateRowTotal(values, 0);
        assertEquals(Math.pow(2, -53), result, .000000001d);
    }

    @Test
    public void calculateRowTotalWithMaxValueRow() {
        mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
                will(returnValue(3));
                one(values).getValue(Integer.MAX_VALUE, 0);
                will(returnValue(7.5));
                one(values).getValue(Integer.MAX_VALUE, 1);
                will(returnValue(2.5));
                one(values).getValue(Integer.MAX_VALUE, 2);
                will(returnValue(5.0));
            }
        });

        double result = DataUtilities.calculateRowTotal(values, Integer.MAX_VALUE);
        assertEquals(15.0, result, .000000001d);
    }

    @Test
    public void calculateRowTotalWithMinValueRow() {
        mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
                will(returnValue(3));
                one(values).getValue(Integer.MIN_VALUE, 0);
                will(returnValue(7.5));
                one(values).getValue(Integer.MIN_VALUE, 1);
                will(returnValue(2.5));
                one(values).getValue(Integer.MIN_VALUE, 2);
                will(returnValue(5.0));
            }
        });

        double result = DataUtilities.calculateRowTotal(values, Integer.MIN_VALUE);
        assertEquals(15.0, result, .000000001d);
    }

    @Test
    public void calculateRowTotalWithMaxValueAndFirstRow() {
        mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
                will(returnValue(3));
                one(values).getValue(0, 0);
                will(returnValue(Math.pow(2, 53)));
                one(values).getValue(0, 1);
                will(returnValue(2.5));
                one(values).getValue(0, 2);
                will(returnValue(-2.5));
            }
        });

        double result = DataUtilities.calculateRowTotal(values, 0);
        assertEquals(Math.pow(2, 53), result, .000000001d);
    }

    // new test cases ---------------------------------------------------------
    @Test
    public void calculateRowTotalwithNullValue() {
        mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
                will(returnValue(3));
                one(values).getValue(0, 0);
                will(returnValue(7.5));
                one(values).getValue(0, 1);
                will(returnValue(2.5));
                one(values).getValue(0, 2);
                will(returnValue(null));
            }
        });

        double result = DataUtilities.calculateRowTotal(values, 0);
        assertEquals(10.0, result, .000000001d);
    }
    // ------------------------------------------------------------------------

    // test cases for calculateRowTotal(Values2D, int, int[]) -----------------
    @Test
    public void calculateRowTotalFirstRowValidAllColumns() {
        mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
                will(returnValue(3));
                one(values).getValue(0, 0);
                will(returnValue(7.16));
                one(values).getValue(0, 1);
                will(returnValue(3.14));
                one(values).getValue(0, 2);
                will(returnValue(5.23));
            }
        });

        double result = DataUtilities.calculateRowTotal(values, 0, new int[] { 0, 1, 2 });
        assertEquals(15.53, result, .000000001d);
    }

    @Test
    public void calculateRowTotalMiddleRowValidAllColumns() {
        mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
                will(returnValue(3));
                one(values).getValue(1, 0);
                will(returnValue(7.16));
                one(values).getValue(1, 1);
                will(returnValue(3.14));
                one(values).getValue(1, 2);
                will(returnValue(5.23));
            }
        });

        double result = DataUtilities.calculateRowTotal(values, 1, new int[] { 0, 1, 2 });
        assertEquals(15.53, result, .000000001d);

    }

    @Test
    public void calculateRowTotalLastRowValidAllColumns() {
        mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
                will(returnValue(3));
                one(values).getValue(2, 0);
                will(returnValue(7.16));
                one(values).getValue(2, 1);
                will(returnValue(3.14));
                one(values).getValue(2, 2);
                will(returnValue(5.23));
            }
        });

        double result = DataUtilities.calculateRowTotal(values, 2, new int[] { 0, 1, 2 });
        assertEquals(15.53, result, .000000001d);
    }

    @Test
    public void calculateRowTotalFirstRowValidFirstColumn() {
        mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
                will(returnValue(3));
                one(values).getValue(0, 0);
                will(returnValue(7.16));
                one(values).getValue(0, 1);
                will(returnValue(3.14));
                one(values).getValue(0, 2);
                will(returnValue(5.23));
            }
        });

        double result = DataUtilities.calculateRowTotal(values, 0, new int[] { 0 });
        assertEquals(7.16, result, .000000001d);

    }

    @Test
    public void calculateRowTotalFirstRowValidMiddleColumn() {
        mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
                will(returnValue(3));
                one(values).getValue(0, 0);
                will(returnValue(7.16));
                one(values).getValue(0, 1);
                will(returnValue(3.14));
                one(values).getValue(0, 2);
                will(returnValue(5.23));
            }
        });

        double result = DataUtilities.calculateRowTotal(values, 0, new int[] { 1 });
        assertEquals(result, 3.14, .000000001d);

    }

    @Test
    public void calculateRowTotalFirstRowValidLastColumn() {
        mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
                will(returnValue(3));
                one(values).getValue(0, 0);
                will(returnValue(7.16));
                one(values).getValue(0, 1);
                will(returnValue(3.14));
                one(values).getValue(0, 2);
                will(returnValue(5.23));
            }
        });

        double result = DataUtilities.calculateRowTotal(values, 0, new int[] { 2 });
        assertEquals(5.23, result, .000000001d);

    }

    @Test
    public void calculateRowTotalMiddleRowValidFirstColumn() {
        mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
                will(returnValue(3));
                one(values).getValue(1, 0);
                will(returnValue(7.16));
                one(values).getValue(1, 1);
                will(returnValue(3.14));
                one(values).getValue(1, 2);
                will(returnValue(5.23));
            }
        });

        double result = DataUtilities.calculateRowTotal(values, 1, new int[] { 0 });
        assertEquals(7.16, result, .000000001d);
    }

    @Test
    public void calculateRowTotalMiddleRowValidMiddleColumn() {
        mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
                will(returnValue(3));
                one(values).getValue(1, 0);
                will(returnValue(7.16));
                one(values).getValue(1, 1);
                will(returnValue(3.14));
                one(values).getValue(1, 2);
                will(returnValue(5.23));
            }
        });

        double result = DataUtilities.calculateRowTotal(values, 1, new int[] { 1 });
        assertEquals(3.14, result, .000000001d);
    }

    @Test
    public void calculateRowTotalMiddleRowValidLastColumn() {
        mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
                will(returnValue(3));
                one(values).getValue(1, 0);
                will(returnValue(7.16));
                one(values).getValue(1, 1);
                will(returnValue(3.14));
                one(values).getValue(1, 2);
                will(returnValue(5.23));
            }
        });

        double result = DataUtilities.calculateRowTotal(values, 1, new int[] { 2 });
        assertEquals(5.23, result, .000000001d);
    }

    @Test
    public void calculateRowTotalLastRowValidFirstColumn() {
        mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
                will(returnValue(3));
                one(values).getValue(2, 0);
                will(returnValue(7.16));
                one(values).getValue(2, 1);
                will(returnValue(3.14));
                one(values).getValue(2, 2);
                will(returnValue(5.23));
            }
        });

        double result = DataUtilities.calculateRowTotal(values, 2, new int[] { 0 });
        assertEquals(7.16, result, .000000001d);
    }

    @Test
    public void calculateRowTotalLastRowValidMiddleColumn() {
        mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
                will(returnValue(3));
                one(values).getValue(2, 0);
                will(returnValue(7.16));
                one(values).getValue(2, 1);
                will(returnValue(3.14));
                one(values).getValue(2, 2);
                will(returnValue(5.23));
            }
        });

        double result = DataUtilities.calculateRowTotal(values, 2, new int[] { 1 });
        assertEquals(3.14, result, .000000001d);
    }

    @Test
    public void calculateRowTotalLastRowValidLastolumn() {
        mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
                will(returnValue(3));
                one(values).getValue(2, 0);
                will(returnValue(7.16));
                one(values).getValue(2, 1);
                will(returnValue(3.14));
                one(values).getValue(2, 2);
                will(returnValue(5.23));
            }
        });

        double result = DataUtilities.calculateRowTotal(values, 2, new int[] { 2 });
        assertEquals(5.23, result, .000000001d);
    }

    @Test
    public void calculateRowTotalFirstRowValidFirstAndLastColumn() {
        mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
                will(returnValue(3));
                one(values).getValue(0, 0);
                will(returnValue(7.16));
                one(values).getValue(0, 1);
                will(returnValue(3.14));
                one(values).getValue(0, 2);
                will(returnValue(5.23));
            }
        });

        double result = DataUtilities.calculateRowTotal(values, 0, new int[] { 0, 2 });
        assertEquals(12.39, result, .000000001d);
    }

    @Test
    public void calculateRowTotalLastRowValidMiddleAndLastColumn() {
        mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
                will(returnValue(3));
                one(values).getValue(2, 0);
                will(returnValue(7.16));
                one(values).getValue(2, 1);
                will(returnValue(3.14));
                one(values).getValue(2, 2);
                will(returnValue(5.23));
            }
        });

        double result = DataUtilities.calculateRowTotal(values, 2, new int[] { 1, 2 });
        assertEquals(8.37, result, .000000001d);
    }

    @Test
    public void calculateRowTotalMiddleRowInvalidColumnAUB() {
        mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
                will(returnValue(3));
                one(values).getValue(1, 0);
                will(returnValue(7.16));
                one(values).getValue(1, 1);
                will(returnValue(3.14));
                one(values).getValue(1, 2);
                will(returnValue(5.23));
            }
        });

        double result = DataUtilities.calculateRowTotal(values, 1, new int[] { 3 });
        assertEquals(0.0, result, .000000001d);
    }

    @Test
    public void calculateRowTotalLastRowInvalidColumnAUBAndOneValidColumn() {
        mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
                will(returnValue(3));
                one(values).getValue(2, 0);
                will(returnValue(7.16));
                one(values).getValue(2, 1);
                will(returnValue(3.14));
                one(values).getValue(2, 2);
                will(returnValue(5.23));
            }
        });

        double result = DataUtilities.calculateRowTotal(values, 2, new int[] { 2, 3 });
        assertEquals(5.23, result, .000000001d);
    }

    @Test
    public void calculateRowTotalFirstRowInvalidColumnBLB() {
        mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
                will(returnValue(3));
            }
        });

        double result = DataUtilities.calculateRowTotal(values, 0, new int[] { -1 });
        assertEquals(0, result, .000000001d);
    }

    @Test
    public void calculateRowTotalMaxRowsMaxColumn() {
        mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
                will(returnValue(3));
                one(values).getValue(Integer.MAX_VALUE, 0);
                will(returnValue(7.16));
                one(values).getValue(Integer.MAX_VALUE, Integer.MAX_VALUE);
                will(returnValue(3.14));
            }
        });

        double result = DataUtilities.calculateRowTotal(values, Integer.MAX_VALUE, new int[] { 0, Integer.MAX_VALUE });
        assertEquals(10.3, result, .000000001d);
    }

    @Test
    public void calculateRowTotalBelowMaxRowsBelowMaxColumn() {
        mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
                will(returnValue(3));
                one(values).getValue(Integer.MAX_VALUE - 1, 0);
                will(returnValue(7.16));
                one(values).getValue(Integer.MAX_VALUE - 1, Integer.MAX_VALUE - 1);
                will(returnValue(3.14));
            }
        });

        double result = DataUtilities.calculateRowTotal(values, Integer.MAX_VALUE - 1,
                new int[] { 0, Integer.MAX_VALUE - 1 });
        assertEquals(10.3, result, .000000001d);
    }

    @Test
    public void calculateRowTotalWithMaxValue() {
        double max = Math.pow(2, 53); // Max double with integer precision

        mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
                will(returnValue(3));
                one(values).getValue(0, 0);
                will(returnValue(max - 1));
                one(values).getValue(0, 1);
                will(returnValue(1));
            }
        });

        double result = DataUtilities.calculateRowTotal(values, 0, new int[] { 0, 1 });
        assertEquals(max, result, .000000001d);
    }

    // new test cases ---------------------------------------------------------
    @Test
    public void calculateRowTotalNullValue() {
        mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
                will(returnValue(3));
                one(values).getValue(0, 0);
                will(returnValue(7.16));
                one(values).getValue(0, 2);
                will(returnValue(null));
            }
        });

        double result = DataUtilities.calculateRowTotal(values, 0, new int[] { 0, 2 });
        assertEquals(7.16, result, .000000001d);
    }
    // ------------------------------------------------------------------------

    // test cases for calculateColumnTotal(Values2D, int) ---------------------
    @Test
    public void calculateColumnTotalAllRowsFirstColumn() {
        mockingContext.checking(new Expectations() {
            {
                one(values).getRowCount();
                will(returnValue(3));
                one(values).getValue(0, 0);
                will(returnValue(7.5));
                one(values).getValue(1, 0);
                will(returnValue(2.5));
                one(values).getValue(2, 0);
                will(returnValue(5.0));
            }
        });

        double result = DataUtilities.calculateColumnTotal(values, 0);
        assertEquals(15.0, result, .000000001d);
    }

    @Test
    public void calculateColumnTotalAllRowsMiddleColumn() {
        mockingContext.checking(new Expectations() {
            {
                one(values).getRowCount();
                will(returnValue(3));
                one(values).getValue(0, 1);
                will(returnValue(7.5));
                one(values).getValue(1, 1);
                will(returnValue(2.5));
                one(values).getValue(2, 1);
                will(returnValue(5.0));
            }
        });

        double result = DataUtilities.calculateColumnTotal(values, 1);
        assertEquals(15, result, .000000001d);
    }

    @Test
    public void calculateColumnTotalAllRowsLastColumn() {
        mockingContext.checking(new Expectations() {
            {
                one(values).getRowCount();
                will(returnValue(3));
                one(values).getValue(0, 2);
                will(returnValue(7.5));
                one(values).getValue(1, 2);
                will(returnValue(2.5));
                one(values).getValue(2, 2);
                will(returnValue(5.0));
            }
        });

        double result = DataUtilities.calculateColumnTotal(values, 2);
        assertEquals(15.0, result, .000000001d);
    }

    @Test
    public void calculateColumnTotalWithMaxValueAndFirstColumn() {
        mockingContext.checking(new Expectations() {
            {
                one(values).getRowCount();
                will(returnValue(3));
                one(values).getValue(0, 0);
                will(returnValue(Math.pow(2, 53)));
                one(values).getValue(1, 0);
                will(returnValue(2.5));
                one(values).getValue(2, 0);
                will(returnValue(-2.5));
            }
        });

        double result = DataUtilities.calculateColumnTotal(values, 0);
        assertEquals(Math.pow(2, 53), result, .000000001d);
    }

    @Test
    public void calculateColumnTotalWithMinValueAndFirstColumn() {
        mockingContext.checking(new Expectations() {
            {
                one(values).getRowCount();
                will(returnValue(3));
                one(values).getValue(0, 0);
                will(returnValue(Math.pow(2, -53)));
                one(values).getValue(1, 0);
                will(returnValue(2.5));
                one(values).getValue(2, 0);
                will(returnValue(-2.5));
            }
        });

        double result = DataUtilities.calculateColumnTotal(values, 0);
        assertEquals(Math.pow(2, -53), result, .000000001d);
    }

    @Test
    public void calculateColumnTotalWithMaxValueColumn() {
        mockingContext.checking(new Expectations() {
            {
                one(values).getRowCount();
                will(returnValue(3));
                one(values).getValue(0, Integer.MAX_VALUE);
                will(returnValue(7.5));
                one(values).getValue(1, Integer.MAX_VALUE);
                will(returnValue(2.5));
                one(values).getValue(2, Integer.MAX_VALUE);
                will(returnValue(5.0));
            }
        });

        double result = DataUtilities.calculateColumnTotal(values, Integer.MAX_VALUE);
        assertEquals(15.0, result, .000000001d);
    }

    @Test
    public void calculateColumnTotalWithMinValueColumn() {
        mockingContext.checking(new Expectations() {
            {
                one(values).getRowCount();
                will(returnValue(3));
                one(values).getValue(0, Integer.MIN_VALUE);
                will(returnValue(7.5));
                one(values).getValue(1, Integer.MIN_VALUE);
                will(returnValue(2.5));
                one(values).getValue(2, Integer.MIN_VALUE);
                will(returnValue(5.0));
            }
        });

        double result = DataUtilities.calculateColumnTotal(values, Integer.MIN_VALUE);
        assertEquals(15.0, result, .000000001d);
    }

    @Test
    public void calculateColumnTotalWithSumOf0AndFirstColumn() {
        mockingContext.checking(new Expectations() {
            {
                one(values).getRowCount();
                will(returnValue(3));
                one(values).getValue(0, 0);
                will(returnValue(7.5));
                one(values).getValue(1, 0);
                will(returnValue(2.5));
                one(values).getValue(2, 0);
                will(returnValue(-10));
            }
        });

        double result = DataUtilities.calculateColumnTotal(values, 0);
        assertEquals(0, result, .000000001d);
    }

    // new test cases ---------------------------------------------------------
    @Test
    public void calculateColumnTotalwithNullValue() {
        mockingContext.checking(new Expectations() {
            {
                one(values).getRowCount();
                will(returnValue(3));
                one(values).getValue(0, 0);
                will(returnValue(null));
                one(values).getValue(1, 0);
                will(returnValue(2.5));
                one(values).getValue(2, 0);
                will(returnValue(5.0));
            }
        });

        double result = DataUtilities.calculateColumnTotal(values, 0);
        assertEquals(7.5, result, .000000001d);
    }
    // ------------------------------------------------------------------------

    // test cases for calculateColumnTotal(Values2D, int, int[]) --------------
    @Test
    public void calculateColumnTotalAllRowsValidFirstColumn() {
        mockingContext.checking(new Expectations() {
            {
                one(values).getRowCount();
                will(returnValue(3));
                one(values).getValue(0, 0);
                will(returnValue(7.5));
                one(values).getValue(1, 0);
                will(returnValue(2.5));
                one(values).getValue(2, 0);
                will(returnValue(5.0));
            }
        });

        double result = DataUtilities.calculateColumnTotal(values, 0, new int[] { 0, 1, 2 });
        assertEquals(15.0, result, .000000001d);
    }

    @Test
    public void calculateColumnTotalAllRowsValidMiddleColumn() {
        mockingContext.checking(new Expectations() {
            {
                one(values).getRowCount();
                will(returnValue(3));
                one(values).getValue(0, 1);
                will(returnValue(7.5));
                one(values).getValue(1, 1);
                will(returnValue(2.5));
                one(values).getValue(2, 1);
                will(returnValue(5.0));
            }
        });

        double result = DataUtilities.calculateColumnTotal(values, 1, new int[] { 0, 1, 2 });
        assertEquals(15.0, result, .000000001d);
    }

    @Test
    public void calculateColumnTotalAllRowsValidLastColumn() {
        mockingContext.checking(new Expectations() {
            {
                one(values).getRowCount();
                will(returnValue(3));
                one(values).getValue(0, 2);
                will(returnValue(7.5));
                one(values).getValue(1, 2);
                will(returnValue(2.5));
                one(values).getValue(2, 2);
                will(returnValue(5.0));
            }
        });

        double result = DataUtilities.calculateColumnTotal(values, 2, new int[] { 0, 1, 2 });
        assertEquals(15.0, result, .000000001d);
    }

    @Test
    public void calculateColumnTotalFirstRowValidFirstColumn() {
        mockingContext.checking(new Expectations() {
            {
                one(values).getRowCount();
                will(returnValue(3));
                one(values).getValue(0, 0);
                will(returnValue(7.5));
                one(values).getValue(1, 0);
                will(returnValue(2.5));
                one(values).getValue(2, 0);
                will(returnValue(5.0));
            }
        });

        double result = DataUtilities.calculateColumnTotal(values, 0, new int[] { 0 });
        assertEquals(7.5, result, .000000001d);
    }

    @Test
    public void calculateColumnTotalMiddleRowValidFirstColumn() {
        mockingContext.checking(new Expectations() {
            {
                one(values).getRowCount();
                will(returnValue(3));
                one(values).getValue(0, 0);
                will(returnValue(7.5));
                one(values).getValue(1, 0);
                will(returnValue(2.5));
                one(values).getValue(2, 0);
                will(returnValue(5.0));
            }
        });

        double result = DataUtilities.calculateColumnTotal(values, 0, new int[] { 1 });
        assertEquals(result, 2.5, .000000001d);
    }

    @Test
    public void calculateColumnTotalLastRowValidFirstColumn() {
        mockingContext.checking(new Expectations() {
            {
                one(values).getRowCount();
                will(returnValue(3));
                one(values).getValue(0, 0);
                will(returnValue(7.5));
                one(values).getValue(1, 0);
                will(returnValue(2.5));
                one(values).getValue(2, 0);
                will(returnValue(5.0));
            }
        });

        double result = DataUtilities.calculateColumnTotal(values, 0, new int[] { 2 });
        assertEquals(5.0, result, .000000001d);
    }

    @Test
    public void calculateColumnTotalFirstRowValidMiddleColumn() {
        mockingContext.checking(new Expectations() {
            {
                one(values).getRowCount();
                will(returnValue(3));
                one(values).getValue(0, 1);
                will(returnValue(7.5));
                one(values).getValue(1, 1);
                will(returnValue(2.5));
                one(values).getValue(2, 1);
                will(returnValue(5.0));
            }
        });

        double result = DataUtilities.calculateColumnTotal(values, 1, new int[] { 0 });
        assertEquals(7.5, result, .000000001d);
    }

    @Test
    public void calculateColumnTotalMiddleRowValidMiddleColumn() {
        mockingContext.checking(new Expectations() {
            {
                one(values).getRowCount();
                will(returnValue(3));
                one(values).getValue(0, 1);
                will(returnValue(7.5));
                one(values).getValue(1, 1);
                will(returnValue(2.5));
                one(values).getValue(2, 1);
                will(returnValue(5.0));
            }
        });

        double result = DataUtilities.calculateColumnTotal(values, 1, new int[] { 1 });
        assertEquals(2.5, result, .000000001d);
    }

    @Test
    public void calculateColumnTotalLastRowValidMiddleColumn() {
        mockingContext.checking(new Expectations() {
            {
                one(values).getRowCount();
                will(returnValue(3));
                one(values).getValue(0, 1);
                will(returnValue(7.5));
                one(values).getValue(1, 1);
                will(returnValue(2.5));
                one(values).getValue(2, 1);
                will(returnValue(5.0));
            }
        });

        double result = DataUtilities.calculateColumnTotal(values, 1, new int[] { 2 });
        assertEquals(5.0, result, .000000001d);
    }

    @Test
    public void calculateColumnTotalFirstRowValidLastColumn() {
        mockingContext.checking(new Expectations() {
            {
                one(values).getRowCount();
                will(returnValue(3));
                one(values).getValue(0, 2);
                will(returnValue(7.5));
                one(values).getValue(1, 2);
                will(returnValue(2.5));
                one(values).getValue(2, 2);
                will(returnValue(5.0));
            }
        });

        double result = DataUtilities.calculateColumnTotal(values, 2, new int[] { 0 });
        assertEquals(7.5, result, .000000001d);
    }

    @Test
    public void calculateColumnTotalMiddleRowValidLastColumn() {
        mockingContext.checking(new Expectations() {
            {
                one(values).getRowCount();
                will(returnValue(3));
                one(values).getValue(0, 2);
                will(returnValue(7.5));
                one(values).getValue(1, 2);
                will(returnValue(2.5));
                one(values).getValue(2, 2);
                will(returnValue(5.0));
            }
        });

        double result = DataUtilities.calculateColumnTotal(values, 2, new int[] { 1 });
        assertEquals(2.5, result, .000000001d);
    }

    @Test
    public void calculateColumnTotalLastRowValidLastColumn() {
        mockingContext.checking(new Expectations() {
            {
                one(values).getRowCount();
                will(returnValue(3));
                one(values).getValue(0, 2);
                will(returnValue(7.5));
                one(values).getValue(1, 2);
                will(returnValue(2.5));
                one(values).getValue(2, 2);
                will(returnValue(5.0));
            }
        });

        double result = DataUtilities.calculateColumnTotal(values, 2, new int[] { 2 });
        assertEquals(5.0, result, .000000001d);
    }

    @Test
    public void calculateColumnTotalFirstAndLastRowValidFirstColumn() {
        mockingContext.checking(new Expectations() {
            {
                one(values).getRowCount();
                will(returnValue(3));
                one(values).getValue(0, 0);
                will(returnValue(7.5));
                one(values).getValue(1, 0);
                will(returnValue(2.5));
                one(values).getValue(2, 0);
                will(returnValue(5.0));
            }
        });

        double result = DataUtilities.calculateColumnTotal(values, 0, new int[] { 0, 2 });
        assertEquals(12.5, result, .000000001d);
    }

    @Test
    public void calculateColumnTotalMiddleAndLastRowValidLastColumn() {
        mockingContext.checking(new Expectations() {
            {
                one(values).getRowCount();
                will(returnValue(3));
                one(values).getValue(0, 2);
                will(returnValue(7.5));
                one(values).getValue(1, 2);
                will(returnValue(3.5));
                one(values).getValue(2, 2);
                will(returnValue(5.0));
            }
        });

        double result = DataUtilities.calculateColumnTotal(values, 2, new int[] { 1, 2 });
        assertEquals(8.5, result, .000000001d);
    }

    @Test
    public void calculateColumnTotalInvalidRowAUBAndOneValidRowLastColumn() {
        mockingContext.checking(new Expectations() {
            {
                one(values).getRowCount();
                will(returnValue(3));
                one(values).getValue(1, 2);
                will(returnValue(7.5));
            }
        });

        double result = DataUtilities.calculateColumnTotal(values, 2, new int[] { 1, 3 });
        assertEquals(7.5, result, .000000001d);
    }

    @Test
    public void calculateColumnTotalInvalidRowAUBMiddleColumn() {
        mockingContext.checking(new Expectations() {
            {
                one(values).getRowCount();
                will(returnValue(3));
            }
        });

        double result = DataUtilities.calculateColumnTotal(values, 1, new int[] { 3 });
        assertEquals(0, result, .000000001d);
    }

    @Test
    public void calculateColumnTotalInvalidRowBLBFirstColumn() {
        mockingContext.checking(new Expectations() {
            {
                one(values).getRowCount();
                will(returnValue(3));
            }
        });

        double result = DataUtilities.calculateColumnTotal(values, 0, new int[] { -1 });
        assertEquals(0, result, .000000001d);
    }

    @Test
    public void calculateColumnTotalMaxRowsMaxColumn() {
        mockingContext.checking(new Expectations() {
            {
                one(values).getRowCount();
                will(returnValue(3));
                one(values).getValue(0, Integer.MAX_VALUE);
                will(returnValue(2.5));
                one(values).getValue(Integer.MAX_VALUE, Integer.MAX_VALUE);
                will(returnValue(5.0));
            }
        });

        double result = DataUtilities.calculateColumnTotal(values, Integer.MAX_VALUE,
                new int[] { 0, Integer.MAX_VALUE });
        assertEquals(7.5, result, .000000001d);
    }

    @Test
    public void calculateColumnTotalBelowMaxRowsBelowMaxColumn() {
        mockingContext.checking(new Expectations() {
            {
                one(values).getRowCount();
                will(returnValue(3));
                one(values).getValue(0, Integer.MAX_VALUE - 1);
                will(returnValue(2.5));
                one(values).getValue(Integer.MAX_VALUE - 1, Integer.MAX_VALUE - 1);
                will(returnValue(5.0));
            }
        });

        double result = DataUtilities.calculateColumnTotal(values, Integer.MAX_VALUE - 1,
                new int[] { 0, Integer.MAX_VALUE - 1 });
        assertEquals(7.5, result, .000000001d);
    }

    @Test
    public void calculateColumnTotalWithMaxValue() {
        double max = Math.pow(2, 53); // Max double with integer precision

        mockingContext.checking(new Expectations() {
            {
                one(values).getRowCount();
                will(returnValue(3));
                one(values).getValue(0, 0);
                will(returnValue(max - 1));
                one(values).getValue(1, 0);
                will(returnValue(1));
            }
        });

        double result = DataUtilities.calculateColumnTotal(values, 0, new int[] { 0, 1 });
        assertEquals(max, result, .000000001d);
    }

    // new test cases ---------------------------------------------------------
    @Test
    public void calculateColumnTotalAllRowsValidNullValue() {
        mockingContext.checking(new Expectations() {
            {
                one(values).getRowCount();
                will(returnValue(3));
                one(values).getValue(0, 0);
                will(returnValue(null));
                one(values).getValue(1, 0);
                will(returnValue(2.5));
                one(values).getValue(2, 0);
                will(returnValue(5.0));
            }
        });

        double result = DataUtilities.calculateColumnTotal(values, 0, new int[] { 0, 1, 2 });
        assertEquals(7.5, result, .000000001d);
    }
    // ------------------------------------------------------------------------

    // test cases for getCumulativePercentages(KeyedValues) -------------------
    @Test
    public void getCumulativePercentagesWithNoKeyedValues() {
        KeyedValues kv = new DefaultKeyedValues();

        KeyedValues cumPercentage = DataUtilities.getCumulativePercentages(kv);
        KeyedValues expected = new DefaultKeyedValues();
        assertEquals(
                "Calling getCumulativePercentage on an empty KeyedValues, should return an empty KeyedValues object",
                expected, cumPercentage);
    }

    @Test
    public void getCumulativePercentagesWithOneRowKeyedValue() {
        mockingContext.checking(new Expectations() {
            {
                allowing(kv).getItemCount();
                will(returnValue(1));
                allowing(kv).getKey(0);
                will(returnValue(0));
                allowing(kv).getValue(0);
                will(returnValue(2));
            }
        });

        KeyedValues result = DataUtilities.getCumulativePercentages(kv);
        assertEquals("The Cumulative Percentage of 2 in data should be 1.0", 1.0, result.getValue(0));
    }

    @Test
    public void getCumulativePercentagesWithOneKeyedValueHavingZeroValue() {
        mockingContext.checking(new Expectations() {
            {
                allowing(kv).getItemCount();
                will(returnValue(1));
                allowing(kv).getKey(0);
                will(returnValue(0));
                allowing(kv).getValue(0);
                will(returnValue(0));
            }
        });

        KeyedValues result = DataUtilities.getCumulativePercentages(kv);
        assertEquals("The cumulative percentage of 0 in data should be the result of 0.0/0.0", 0.0 / 0.0,
                result.getValue(0));
    }

    @Test
    public void test_getCumulativePercentages_oneKeyedValue_nullValue() {
        mockingContext.checking(new Expectations() {
            {
                allowing(kv).getItemCount();
                will(returnValue(1));
                allowing(kv).getKey(0);
                will(returnValue(0));
                allowing(kv).getValue(0);
                will(returnValue(null));
            }
        });

        KeyedValues result = DataUtilities.getCumulativePercentages(kv);
        assertEquals("The cumulative percentage of null in data should be NaN", Double.NaN, result.getValue(0));
    }

    @Test
    public void getCumulativePercentagesWithKeyedValuesHavingNullAndMixValues() {
        mockingContext.checking(new Expectations() {
            {
                allowing(kv).getItemCount();
                will(returnValue(5));
                allowing(kv).getKey(0);
                will(returnValue(0));
                allowing(kv).getKey(1);
                will(returnValue(1));
                allowing(kv).getKey(2);
                will(returnValue(2));
                allowing(kv).getKey(3);
                will(returnValue(3));
                allowing(kv).getKey(4);
                will(returnValue(4));
                allowing(kv).getValue(0);
                will(returnValue(-4.5));
                allowing(kv).getValue(1);
                will(returnValue(2));
                allowing(kv).getValue(2);
                will(returnValue(null));
                allowing(kv).getValue(3);
                will(returnValue(12.5));
                allowing(kv).getValue(4);
                will(returnValue(0));
            }
        });

        KeyedValues result = DataUtilities.getCumulativePercentages(kv);

        assertEquals("The cumulative percentage of -4.5 in data should be -0.45", -0.45,
                result.getValue(0).doubleValue(), 0.000000001d);
        assertEquals("The cumulative percentage of 2 in data should be -0.25", -0.25, result.getValue(1).doubleValue(),
                0.000000001d);
        assertEquals("The cumulative percentage of null in data should be -0.25", -0.25,
                result.getValue(2).doubleValue(), 0.000000001d);
        assertEquals("The cumulative percentage of 12.5 in data should be 1.0", 1.0, result.getValue(3).doubleValue(),
                0.000000001d);
        assertEquals("The cumulative percentage of 0 in data should be 1.0", 1.0, result.getValue(4).doubleValue(),
                0.000000001d);
    }
    // ------------------------------------------------------------------------
}

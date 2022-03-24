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
        this.kv = this.mockingContext.mock(KeyedValues.class);
    }

    // test cases for calculateRowTotal(Values2D, int) ------------------------
    @Test
    public void calculateRowTotalFirstRow() {
        this.mockingContext.checking(new Expectations() {
            {
                this.one(DataUtilitiesTest.this.values).getColumnCount();
                this.will(returnValue(3));
                this.one(DataUtilitiesTest.this.values).getValue(0, 0);
                this.will(returnValue(7.5));
                this.one(DataUtilitiesTest.this.values).getValue(0, 1);
                this.will(returnValue(2.5));
                this.one(DataUtilitiesTest.this.values).getValue(0, 2);
                this.will(returnValue(5.0));
            }
        });

        double result = DataUtilities.calculateRowTotal(this.values, 0);
        assertEquals(15.0, result, .000000001d);
    }

    @Test
    public void calculateRowTotalMiddleRow() {
        this.mockingContext.checking(new Expectations() {
            {
                this.one(DataUtilitiesTest.this.values).getColumnCount();
                this.will(returnValue(3));
                this.one(DataUtilitiesTest.this.values).getValue(1, 0);
                this.will(returnValue(7.5));
                this.one(DataUtilitiesTest.this.values).getValue(1, 1);
                this.will(returnValue(2.5));
                this.one(DataUtilitiesTest.this.values).getValue(1, 2);
                this.will(returnValue(5.0));
            }
        });

        double result = DataUtilities.calculateRowTotal(this.values, 1);
        assertEquals(15.0, result, .000000001d);
    }

    @Test
    public void calculateRowTotalLastRow() {
        this.mockingContext.checking(new Expectations() {
            {
                this.one(DataUtilitiesTest.this.values).getColumnCount();
                this.will(returnValue(3));
                this.one(DataUtilitiesTest.this.values).getValue(2, 0);
                this.will(returnValue(7.5));
                this.one(DataUtilitiesTest.this.values).getValue(2, 1);
                this.will(returnValue(2.5));
                this.one(DataUtilitiesTest.this.values).getValue(2, 2);
                this.will(returnValue(5.0));
            }
        });

        double result = DataUtilities.calculateRowTotal(this.values, 2);
        assertEquals(15.0, result, .000000001d);
    }

    @Test
    public void calculateRowTotalWithSumOf0AndFirstRow() {
        this.mockingContext.checking(new Expectations() {
            {
                this.one(DataUtilitiesTest.this.values).getColumnCount();
                this.will(returnValue(3));
                this.one(DataUtilitiesTest.this.values).getValue(0, 0);
                this.will(returnValue(7.5));
                this.one(DataUtilitiesTest.this.values).getValue(0, 1);
                this.will(returnValue(2.5));
                this.one(DataUtilitiesTest.this.values).getValue(0, 2);
                this.will(returnValue(-10));
            }
        });
        double result = DataUtilities.calculateRowTotal(this.values, 0);
        assertEquals(0, result, .000000001d);
    }

    @Test
    public void calculateRowTotalWithMinValueAndFirstRow() {
        this.mockingContext.checking(new Expectations() {
            {
                this.one(DataUtilitiesTest.this.values).getColumnCount();
                this.will(returnValue(3));
                this.one(DataUtilitiesTest.this.values).getValue(0, 0);
                this.will(returnValue(Math.pow(2, -53)));
                this.one(DataUtilitiesTest.this.values).getValue(0, 1);
                this.will(returnValue(2.5));
                this.one(DataUtilitiesTest.this.values).getValue(0, 2);
                this.will(returnValue(-2.5));
            }
        });

        double result = DataUtilities.calculateRowTotal(this.values, 0);
        assertEquals(Math.pow(2, -53), result, .000000001d);
    }

    @Test
    public void calculateRowTotalWithMaxValueRow() {
        this.mockingContext.checking(new Expectations() {
            {
                this.one(DataUtilitiesTest.this.values).getColumnCount();
                this.will(returnValue(3));
                this.one(DataUtilitiesTest.this.values).getValue(Integer.MAX_VALUE, 0);
                this.will(returnValue(7.5));
                this.one(DataUtilitiesTest.this.values).getValue(Integer.MAX_VALUE, 1);
                this.will(returnValue(2.5));
                this.one(DataUtilitiesTest.this.values).getValue(Integer.MAX_VALUE, 2);
                this.will(returnValue(5.0));
            }
        });

        double result = DataUtilities.calculateRowTotal(this.values, Integer.MAX_VALUE);
        assertEquals(15.0, result, .000000001d);
    }

    @Test
    public void calculateRowTotalWithMinValueRow() {
        this.mockingContext.checking(new Expectations() {
            {
                this.one(DataUtilitiesTest.this.values).getColumnCount();
                this.will(returnValue(3));
                this.one(DataUtilitiesTest.this.values).getValue(Integer.MIN_VALUE, 0);
                this.will(returnValue(7.5));
                this.one(DataUtilitiesTest.this.values).getValue(Integer.MIN_VALUE, 1);
                this.will(returnValue(2.5));
                this.one(DataUtilitiesTest.this.values).getValue(Integer.MIN_VALUE, 2);
                this.will(returnValue(5.0));
            }
        });

        double result = DataUtilities.calculateRowTotal(this.values, Integer.MIN_VALUE);
        assertEquals(15.0, result, .000000001d);
    }

    @Test
    public void calculateRowTotalWithMaxValueAndFirstRow() {
        this.mockingContext.checking(new Expectations() {
            {
                this.one(DataUtilitiesTest.this.values).getColumnCount();
                this.will(returnValue(3));
                this.one(DataUtilitiesTest.this.values).getValue(0, 0);
                this.will(returnValue(Math.pow(2, 53)));
                this.one(DataUtilitiesTest.this.values).getValue(0, 1);
                this.will(returnValue(2.5));
                this.one(DataUtilitiesTest.this.values).getValue(0, 2);
                this.will(returnValue(-2.5));
            }
        });

        double result = DataUtilities.calculateRowTotal(this.values, 0);
        assertEquals(Math.pow(2, 53), result, .000000001d);
    }

    // new test cases ---------------------------------------------------------
    @Test
    public void calculateRowTotalwithNullValue() {
        this.mockingContext.checking(new Expectations() {
            {
                this.one(DataUtilitiesTest.this.values).getColumnCount();
                this.will(returnValue(3));
                this.one(DataUtilitiesTest.this.values).getValue(0, 0);
                this.will(returnValue(7.5));
                this.one(DataUtilitiesTest.this.values).getValue(0, 1);
                this.will(returnValue(2.5));
                this.one(DataUtilitiesTest.this.values).getValue(0, 2);
                this.will(returnValue(null));
            }
        });

        double result = DataUtilities.calculateRowTotal(this.values, 0);
        assertEquals(10.0, result, .000000001d);
    }

    @Test(expected = IllegalArgumentException.class)
    public void calculateRowTotalTestNullValues() {
        DataUtilities.calculateRowTotal(null, 0);

    }
    // ------------------------------------------------------------------------

    // test cases for calculateRowTotal(Values2D, int, int[]) -----------------
    @Test
    public void calculateRowTotalFirstRowValidAllColumns() {
        this.mockingContext.checking(new Expectations() {
            {
                this.one(DataUtilitiesTest.this.values).getColumnCount();
                this.will(returnValue(3));
                this.one(DataUtilitiesTest.this.values).getValue(0, 0);
                this.will(returnValue(7.16));
                this.one(DataUtilitiesTest.this.values).getValue(0, 1);
                this.will(returnValue(3.14));
                this.one(DataUtilitiesTest.this.values).getValue(0, 2);
                this.will(returnValue(5.23));
            }
        });

        double result = DataUtilities.calculateRowTotal(this.values, 0, new int[] { 0, 1, 2 });
        assertEquals(15.53, result, .000000001d);
    }

    @Test
    public void calculateRowTotalMiddleRowValidAllColumns() {
        this.mockingContext.checking(new Expectations() {
            {
                this.one(DataUtilitiesTest.this.values).getColumnCount();
                this.will(returnValue(3));
                this.one(DataUtilitiesTest.this.values).getValue(1, 0);
                this.will(returnValue(7.16));
                this.one(DataUtilitiesTest.this.values).getValue(1, 1);
                this.will(returnValue(3.14));
                this.one(DataUtilitiesTest.this.values).getValue(1, 2);
                this.will(returnValue(5.23));
            }
        });

        double result = DataUtilities.calculateRowTotal(this.values, 1, new int[] { 0, 1, 2 });
        assertEquals(15.53, result, .000000001d);

    }

    @Test
    public void calculateRowTotalLastRowValidAllColumns() {
        this.mockingContext.checking(new Expectations() {
            {
                this.one(DataUtilitiesTest.this.values).getColumnCount();
                this.will(returnValue(3));
                this.one(DataUtilitiesTest.this.values).getValue(2, 0);
                this.will(returnValue(7.16));
                this.one(DataUtilitiesTest.this.values).getValue(2, 1);
                this.will(returnValue(3.14));
                this.one(DataUtilitiesTest.this.values).getValue(2, 2);
                this.will(returnValue(5.23));
            }
        });

        double result = DataUtilities.calculateRowTotal(this.values, 2, new int[] { 0, 1, 2 });
        assertEquals(15.53, result, .000000001d);
    }

    @Test
    public void calculateRowTotalFirstRowValidFirstColumn() {
        this.mockingContext.checking(new Expectations() {
            {
                this.one(DataUtilitiesTest.this.values).getColumnCount();
                this.will(returnValue(3));
                this.one(DataUtilitiesTest.this.values).getValue(0, 0);
                this.will(returnValue(7.16));
                this.one(DataUtilitiesTest.this.values).getValue(0, 1);
                this.will(returnValue(3.14));
                this.one(DataUtilitiesTest.this.values).getValue(0, 2);
                this.will(returnValue(5.23));
            }
        });

        double result = DataUtilities.calculateRowTotal(this.values, 0, new int[] { 0 });
        assertEquals(7.16, result, .000000001d);

    }

    @Test
    public void calculateRowTotalFirstRowValidMiddleColumn() {
        this.mockingContext.checking(new Expectations() {
            {
                this.one(DataUtilitiesTest.this.values).getColumnCount();
                this.will(returnValue(3));
                this.one(DataUtilitiesTest.this.values).getValue(0, 0);
                this.will(returnValue(7.16));
                this.one(DataUtilitiesTest.this.values).getValue(0, 1);
                this.will(returnValue(3.14));
                this.one(DataUtilitiesTest.this.values).getValue(0, 2);
                this.will(returnValue(5.23));
            }
        });

        double result = DataUtilities.calculateRowTotal(this.values, 0, new int[] { 1 });
        assertEquals(result, 3.14, .000000001d);

    }

    @Test
    public void calculateRowTotalFirstRowValidLastColumn() {
        this.mockingContext.checking(new Expectations() {
            {
                this.one(DataUtilitiesTest.this.values).getColumnCount();
                this.will(returnValue(3));
                this.one(DataUtilitiesTest.this.values).getValue(0, 0);
                this.will(returnValue(7.16));
                this.one(DataUtilitiesTest.this.values).getValue(0, 1);
                this.will(returnValue(3.14));
                this.one(DataUtilitiesTest.this.values).getValue(0, 2);
                this.will(returnValue(5.23));
            }
        });

        double result = DataUtilities.calculateRowTotal(this.values, 0, new int[] { 2 });
        assertEquals(5.23, result, .000000001d);

    }

    @Test
    public void calculateRowTotalMiddleRowValidFirstColumn() {
        this.mockingContext.checking(new Expectations() {
            {
                this.one(DataUtilitiesTest.this.values).getColumnCount();
                this.will(returnValue(3));
                this.one(DataUtilitiesTest.this.values).getValue(1, 0);
                this.will(returnValue(7.16));
                this.one(DataUtilitiesTest.this.values).getValue(1, 1);
                this.will(returnValue(3.14));
                this.one(DataUtilitiesTest.this.values).getValue(1, 2);
                this.will(returnValue(5.23));
            }
        });

        double result = DataUtilities.calculateRowTotal(this.values, 1, new int[] { 0 });
        assertEquals(7.16, result, .000000001d);
    }

    @Test
    public void calculateRowTotalMiddleRowValidMiddleColumn() {
        this.mockingContext.checking(new Expectations() {
            {
                this.one(DataUtilitiesTest.this.values).getColumnCount();
                this.will(returnValue(3));
                this.one(DataUtilitiesTest.this.values).getValue(1, 0);
                this.will(returnValue(7.16));
                this.one(DataUtilitiesTest.this.values).getValue(1, 1);
                this.will(returnValue(3.14));
                this.one(DataUtilitiesTest.this.values).getValue(1, 2);
                this.will(returnValue(5.23));
            }
        });

        double result = DataUtilities.calculateRowTotal(this.values, 1, new int[] { 1 });
        assertEquals(3.14, result, .000000001d);
    }

    @Test
    public void calculateRowTotalMiddleRowValidLastColumn() {
        this.mockingContext.checking(new Expectations() {
            {
                this.one(DataUtilitiesTest.this.values).getColumnCount();
                this.will(returnValue(3));
                this.one(DataUtilitiesTest.this.values).getValue(1, 0);
                this.will(returnValue(7.16));
                this.one(DataUtilitiesTest.this.values).getValue(1, 1);
                this.will(returnValue(3.14));
                this.one(DataUtilitiesTest.this.values).getValue(1, 2);
                this.will(returnValue(5.23));
            }
        });

        double result = DataUtilities.calculateRowTotal(this.values, 1, new int[] { 2 });
        assertEquals(5.23, result, .000000001d);
    }

    @Test
    public void calculateRowTotalLastRowValidFirstColumn() {
        this.mockingContext.checking(new Expectations() {
            {
                this.one(DataUtilitiesTest.this.values).getColumnCount();
                this.will(returnValue(3));
                this.one(DataUtilitiesTest.this.values).getValue(2, 0);
                this.will(returnValue(7.16));
                this.one(DataUtilitiesTest.this.values).getValue(2, 1);
                this.will(returnValue(3.14));
                this.one(DataUtilitiesTest.this.values).getValue(2, 2);
                this.will(returnValue(5.23));
            }
        });

        double result = DataUtilities.calculateRowTotal(this.values, 2, new int[] { 0 });
        assertEquals(7.16, result, .000000001d);
    }

    @Test
    public void calculateRowTotalLastRowValidMiddleColumn() {
        this.mockingContext.checking(new Expectations() {
            {
                this.one(DataUtilitiesTest.this.values).getColumnCount();
                this.will(returnValue(3));
                this.one(DataUtilitiesTest.this.values).getValue(2, 0);
                this.will(returnValue(7.16));
                this.one(DataUtilitiesTest.this.values).getValue(2, 1);
                this.will(returnValue(3.14));
                this.one(DataUtilitiesTest.this.values).getValue(2, 2);
                this.will(returnValue(5.23));
            }
        });

        double result = DataUtilities.calculateRowTotal(this.values, 2, new int[] { 1 });
        assertEquals(3.14, result, .000000001d);
    }

    @Test
    public void calculateRowTotalLastRowValidLastolumn() {
        this.mockingContext.checking(new Expectations() {
            {
                this.one(DataUtilitiesTest.this.values).getColumnCount();
                this.will(returnValue(3));
                this.one(DataUtilitiesTest.this.values).getValue(2, 0);
                this.will(returnValue(7.16));
                this.one(DataUtilitiesTest.this.values).getValue(2, 1);
                this.will(returnValue(3.14));
                this.one(DataUtilitiesTest.this.values).getValue(2, 2);
                this.will(returnValue(5.23));
            }
        });

        double result = DataUtilities.calculateRowTotal(this.values, 2, new int[] { 2 });
        assertEquals(5.23, result, .000000001d);
    }

    @Test
    public void calculateRowTotalFirstRowValidFirstAndLastColumn() {
        this.mockingContext.checking(new Expectations() {
            {
                this.one(DataUtilitiesTest.this.values).getColumnCount();
                this.will(returnValue(3));
                this.one(DataUtilitiesTest.this.values).getValue(0, 0);
                this.will(returnValue(7.16));
                this.one(DataUtilitiesTest.this.values).getValue(0, 1);
                this.will(returnValue(3.14));
                this.one(DataUtilitiesTest.this.values).getValue(0, 2);
                this.will(returnValue(5.23));
            }
        });

        double result = DataUtilities.calculateRowTotal(this.values, 0, new int[] { 0, 2 });
        assertEquals(12.39, result, .000000001d);
    }

    @Test
    public void calculateRowTotalLastRowValidMiddleAndLastColumn() {
        this.mockingContext.checking(new Expectations() {
            {
                this.one(DataUtilitiesTest.this.values).getColumnCount();
                this.will(returnValue(3));
                this.one(DataUtilitiesTest.this.values).getValue(2, 0);
                this.will(returnValue(7.16));
                this.one(DataUtilitiesTest.this.values).getValue(2, 1);
                this.will(returnValue(3.14));
                this.one(DataUtilitiesTest.this.values).getValue(2, 2);
                this.will(returnValue(5.23));
            }
        });

        double result = DataUtilities.calculateRowTotal(this.values, 2, new int[] { 1, 2 });
        assertEquals(8.37, result, .000000001d);
    }

    @Test
    public void calculateRowTotalMiddleRowInvalidColumnAUB() {
        this.mockingContext.checking(new Expectations() {
            {
                this.one(DataUtilitiesTest.this.values).getColumnCount();
                this.will(returnValue(3));
                this.one(DataUtilitiesTest.this.values).getValue(1, 0);
                this.will(returnValue(7.16));
                this.one(DataUtilitiesTest.this.values).getValue(1, 1);
                this.will(returnValue(3.14));
                this.one(DataUtilitiesTest.this.values).getValue(1, 2);
                this.will(returnValue(5.23));
            }
        });

        double result = DataUtilities.calculateRowTotal(this.values, 1, new int[] { 3 });
        assertEquals(0.0, result, .000000001d);
    }

    @Test
    public void calculateRowTotalLastRowInvalidColumnAUBAndOneValidColumn() {
        this.mockingContext.checking(new Expectations() {
            {
                this.one(DataUtilitiesTest.this.values).getColumnCount();
                this.will(returnValue(3));
                this.one(DataUtilitiesTest.this.values).getValue(2, 0);
                this.will(returnValue(7.16));
                this.one(DataUtilitiesTest.this.values).getValue(2, 1);
                this.will(returnValue(3.14));
                this.one(DataUtilitiesTest.this.values).getValue(2, 2);
                this.will(returnValue(5.23));
            }
        });

        double result = DataUtilities.calculateRowTotal(this.values, 2, new int[] { 2, 3 });
        assertEquals(5.23, result, .000000001d);
    }

    // @Test
    // public void calculateRowTotalFirstRowInvalidColumnBLB() {
    // mockingContext.checking(new Expectations() {
    // {
    // one(values).getColumnCount();
    // will(returnValue(3));
    // }
    // });
    //
    // double result = DataUtilities.calculateRowTotal(values, 0, new int[] { -1 });
    // assertEquals(0, result, .000000001d);
    // }

    // @Test
    // public void calculateRowTotalMaxRowsMaxColumn() {
    // mockingContext.checking(new Expectations() {
    // {
    // one(values).getColumnCount();
    // will(returnValue(3));
    // one(values).getValue(Integer.MAX_VALUE, 0);
    // will(returnValue(7.16));
    // one(values).getValue(Integer.MAX_VALUE, Integer.MAX_VALUE);
    // will(returnValue(3.14));
    // }
    // });
    //
    // double result = DataUtilities.calculateRowTotal(values, Integer.MAX_VALUE,
    // new int[] { 0, Integer.MAX_VALUE });
    // assertEquals(10.3, result, .000000001d);
    // }

    // @Test
    // public void calculateRowTotalBelowMaxRowsBelowMaxColumn() {
    // mockingContext.checking(new Expectations() {
    // {
    // one(values).getColumnCount();
    // will(returnValue(3));
    // one(values).getValue(Integer.MAX_VALUE - 1, 0);
    // will(returnValue(7.16));
    // one(values).getValue(Integer.MAX_VALUE - 1, Integer.MAX_VALUE - 1);
    // will(returnValue(3.14));
    // }
    // });
    //
    // double result = DataUtilities.calculateRowTotal(values, Integer.MAX_VALUE -
    // 1,
    // new int[] { 0, Integer.MAX_VALUE - 1 });
    // assertEquals(10.3, result, .000000001d);
    // }

    @Test
    public void calculateRowTotalWithMaxValue() {
        double max = Math.pow(2, 53); // Max double with integer precision

        this.mockingContext.checking(new Expectations() {
            {
                this.one(DataUtilitiesTest.this.values).getColumnCount();
                this.will(returnValue(3));
                this.one(DataUtilitiesTest.this.values).getValue(0, 0);
                this.will(returnValue(max - 1));
                this.one(DataUtilitiesTest.this.values).getValue(0, 1);
                this.will(returnValue(1));
            }
        });

        double result = DataUtilities.calculateRowTotal(this.values, 0, new int[] { 0, 1 });
        assertEquals(max, result, .000000001d);
    }

    // new test cases ---------------------------------------------------------
    @Test
    public void calculateRowTotalNullValue() {
        this.mockingContext.checking(new Expectations() {
            {
                this.one(DataUtilitiesTest.this.values).getColumnCount();
                this.will(returnValue(3));
                this.one(DataUtilitiesTest.this.values).getValue(0, 0);
                this.will(returnValue(7.16));
                this.one(DataUtilitiesTest.this.values).getValue(0, 2);
                this.will(returnValue(null));
            }
        });

        double result = DataUtilities.calculateRowTotal(this.values, 0, new int[] { 0, 2 });
        assertEquals(7.16, result, .000000001d);
    }

    @Test(expected = IllegalArgumentException.class)
    public void calculateRowTotalTestNullValuesColumns() {
        DataUtilities.calculateRowTotal(null, 0, new int[] {});

    }
    // ------------------------------------------------------------------------

    // test cases for calculateColumnTotal(Values2D, int) ---------------------
    @Test
    public void calculateColumnTotalAllRowsFirstColumn() {
        this.mockingContext.checking(new Expectations() {
            {
                this.one(DataUtilitiesTest.this.values).getRowCount();
                this.will(returnValue(3));
                this.one(DataUtilitiesTest.this.values).getValue(0, 0);
                this.will(returnValue(7.5));
                this.one(DataUtilitiesTest.this.values).getValue(1, 0);
                this.will(returnValue(2.5));
                this.one(DataUtilitiesTest.this.values).getValue(2, 0);
                this.will(returnValue(5.0));
            }
        });

        double result = DataUtilities.calculateColumnTotal(this.values, 0);
        assertEquals(15.0, result, .000000001d);
    }

    @Test
    public void calculateColumnTotalAllRowsMiddleColumn() {
        this.mockingContext.checking(new Expectations() {
            {
                this.one(DataUtilitiesTest.this.values).getRowCount();
                this.will(returnValue(3));
                this.one(DataUtilitiesTest.this.values).getValue(0, 1);
                this.will(returnValue(7.5));
                this.one(DataUtilitiesTest.this.values).getValue(1, 1);
                this.will(returnValue(2.5));
                this.one(DataUtilitiesTest.this.values).getValue(2, 1);
                this.will(returnValue(5.0));
            }
        });

        double result = DataUtilities.calculateColumnTotal(this.values, 1);
        assertEquals(15, result, .000000001d);
    }

    @Test
    public void calculateColumnTotalAllRowsLastColumn() {
        this.mockingContext.checking(new Expectations() {
            {
                this.one(DataUtilitiesTest.this.values).getRowCount();
                this.will(returnValue(3));
                this.one(DataUtilitiesTest.this.values).getValue(0, 2);
                this.will(returnValue(7.5));
                this.one(DataUtilitiesTest.this.values).getValue(1, 2);
                this.will(returnValue(2.5));
                this.one(DataUtilitiesTest.this.values).getValue(2, 2);
                this.will(returnValue(5.0));
            }
        });

        double result = DataUtilities.calculateColumnTotal(this.values, 2);
        assertEquals(15.0, result, .000000001d);
    }

    @Test
    public void calculateColumnTotalWithMaxValueAndFirstColumn() {
        this.mockingContext.checking(new Expectations() {
            {
                this.one(DataUtilitiesTest.this.values).getRowCount();
                this.will(returnValue(3));
                this.one(DataUtilitiesTest.this.values).getValue(0, 0);
                this.will(returnValue(Math.pow(2, 53)));
                this.one(DataUtilitiesTest.this.values).getValue(1, 0);
                this.will(returnValue(2.5));
                this.one(DataUtilitiesTest.this.values).getValue(2, 0);
                this.will(returnValue(-2.5));
            }
        });

        double result = DataUtilities.calculateColumnTotal(this.values, 0);
        assertEquals(Math.pow(2, 53), result, .000000001d);
    }

    @Test
    public void calculateColumnTotalWithMinValueAndFirstColumn() {
        this.mockingContext.checking(new Expectations() {
            {
                this.one(DataUtilitiesTest.this.values).getRowCount();
                this.will(returnValue(3));
                this.one(DataUtilitiesTest.this.values).getValue(0, 0);
                this.will(returnValue(Math.pow(2, -53)));
                this.one(DataUtilitiesTest.this.values).getValue(1, 0);
                this.will(returnValue(2.5));
                this.one(DataUtilitiesTest.this.values).getValue(2, 0);
                this.will(returnValue(-2.5));
            }
        });

        double result = DataUtilities.calculateColumnTotal(this.values, 0);
        assertEquals(Math.pow(2, -53), result, .000000001d);
    }

    @Test
    public void calculateColumnTotalWithMaxValueColumn() {
        this.mockingContext.checking(new Expectations() {
            {
                this.one(DataUtilitiesTest.this.values).getRowCount();
                this.will(returnValue(3));
                this.one(DataUtilitiesTest.this.values).getValue(0, Integer.MAX_VALUE);
                this.will(returnValue(7.5));
                this.one(DataUtilitiesTest.this.values).getValue(1, Integer.MAX_VALUE);
                this.will(returnValue(2.5));
                this.one(DataUtilitiesTest.this.values).getValue(2, Integer.MAX_VALUE);
                this.will(returnValue(5.0));
            }
        });

        double result = DataUtilities.calculateColumnTotal(this.values, Integer.MAX_VALUE);
        assertEquals(15.0, result, .000000001d);
    }

    @Test
    public void calculateColumnTotalWithMinValueColumn() {
        this.mockingContext.checking(new Expectations() {
            {
                this.one(DataUtilitiesTest.this.values).getRowCount();
                this.will(returnValue(3));
                this.one(DataUtilitiesTest.this.values).getValue(0, Integer.MIN_VALUE);
                this.will(returnValue(7.5));
                this.one(DataUtilitiesTest.this.values).getValue(1, Integer.MIN_VALUE);
                this.will(returnValue(2.5));
                this.one(DataUtilitiesTest.this.values).getValue(2, Integer.MIN_VALUE);
                this.will(returnValue(5.0));
            }
        });

        double result = DataUtilities.calculateColumnTotal(this.values, Integer.MIN_VALUE);
        assertEquals(15.0, result, .000000001d);
    }

    @Test
    public void calculateColumnTotalWithSumOf0AndFirstColumn() {
        this.mockingContext.checking(new Expectations() {
            {
                this.one(DataUtilitiesTest.this.values).getRowCount();
                this.will(returnValue(3));
                this.one(DataUtilitiesTest.this.values).getValue(0, 0);
                this.will(returnValue(7.5));
                this.one(DataUtilitiesTest.this.values).getValue(1, 0);
                this.will(returnValue(2.5));
                this.one(DataUtilitiesTest.this.values).getValue(2, 0);
                this.will(returnValue(-10));
            }
        });

        double result = DataUtilities.calculateColumnTotal(this.values, 0);
        assertEquals(0, result, .000000001d);
    }

    // new test cases ---------------------------------------------------------
    @Test
    public void calculateColumnTotalwithNullValue() {
        this.mockingContext.checking(new Expectations() {
            {
                this.one(DataUtilitiesTest.this.values).getRowCount();
                this.will(returnValue(3));
                this.one(DataUtilitiesTest.this.values).getValue(0, 0);
                this.will(returnValue(null));
                this.one(DataUtilitiesTest.this.values).getValue(1, 0);
                this.will(returnValue(2.5));
                this.one(DataUtilitiesTest.this.values).getValue(2, 0);
                this.will(returnValue(5.0));
            }
        });

        double result = DataUtilities.calculateColumnTotal(this.values, 0);
        assertEquals(7.5, result, .000000001d);
    }

    @Test(expected = IllegalArgumentException.class)
    public void calculateColumnTotalWithNullValues() {
        DataUtilities.calculateColumnTotal(null, 0);

    }
    // ------------------------------------------------------------------------

    // test cases for calculateColumnTotal(Values2D, int, int[]) --------------
    @Test
    public void calculateColumnTotalAllRowsValidFirstColumn() {
        this.mockingContext.checking(new Expectations() {
            {
                this.one(DataUtilitiesTest.this.values).getRowCount();
                this.will(returnValue(3));
                this.one(DataUtilitiesTest.this.values).getValue(0, 0);
                this.will(returnValue(7.5));
                this.one(DataUtilitiesTest.this.values).getValue(1, 0);
                this.will(returnValue(2.5));
                this.one(DataUtilitiesTest.this.values).getValue(2, 0);
                this.will(returnValue(5.0));
            }
        });

        double result = DataUtilities.calculateColumnTotal(this.values, 0, new int[] { 0, 1, 2 });
        assertEquals(15.0, result, .000000001d);
    }

    @Test
    public void calculateColumnTotalAllRowsValidMiddleColumn() {
        this.mockingContext.checking(new Expectations() {
            {
                this.one(DataUtilitiesTest.this.values).getRowCount();
                this.will(returnValue(3));
                this.one(DataUtilitiesTest.this.values).getValue(0, 1);
                this.will(returnValue(7.5));
                this.one(DataUtilitiesTest.this.values).getValue(1, 1);
                this.will(returnValue(2.5));
                this.one(DataUtilitiesTest.this.values).getValue(2, 1);
                this.will(returnValue(5.0));
            }
        });

        double result = DataUtilities.calculateColumnTotal(this.values, 1, new int[] { 0, 1, 2 });
        assertEquals(15.0, result, .000000001d);
    }

    @Test
    public void calculateColumnTotalAllRowsValidLastColumn() {
        this.mockingContext.checking(new Expectations() {
            {
                this.one(DataUtilitiesTest.this.values).getRowCount();
                this.will(returnValue(3));
                this.one(DataUtilitiesTest.this.values).getValue(0, 2);
                this.will(returnValue(7.5));
                this.one(DataUtilitiesTest.this.values).getValue(1, 2);
                this.will(returnValue(2.5));
                this.one(DataUtilitiesTest.this.values).getValue(2, 2);
                this.will(returnValue(5.0));
            }
        });

        double result = DataUtilities.calculateColumnTotal(this.values, 2, new int[] { 0, 1, 2 });
        assertEquals(15.0, result, .000000001d);
    }

    @Test
    public void calculateColumnTotalFirstRowValidFirstColumn() {
        this.mockingContext.checking(new Expectations() {
            {
                this.one(DataUtilitiesTest.this.values).getRowCount();
                this.will(returnValue(3));
                this.one(DataUtilitiesTest.this.values).getValue(0, 0);
                this.will(returnValue(7.5));
                this.one(DataUtilitiesTest.this.values).getValue(1, 0);
                this.will(returnValue(2.5));
                this.one(DataUtilitiesTest.this.values).getValue(2, 0);
                this.will(returnValue(5.0));
            }
        });

        double result = DataUtilities.calculateColumnTotal(this.values, 0, new int[] { 0 });
        assertEquals(7.5, result, .000000001d);
    }

    @Test
    public void calculateColumnTotalMiddleRowValidFirstColumn() {
        this.mockingContext.checking(new Expectations() {
            {
                this.one(DataUtilitiesTest.this.values).getRowCount();
                this.will(returnValue(3));
                this.one(DataUtilitiesTest.this.values).getValue(0, 0);
                this.will(returnValue(7.5));
                this.one(DataUtilitiesTest.this.values).getValue(1, 0);
                this.will(returnValue(2.5));
                this.one(DataUtilitiesTest.this.values).getValue(2, 0);
                this.will(returnValue(5.0));
            }
        });

        double result = DataUtilities.calculateColumnTotal(this.values, 0, new int[] { 1 });
        assertEquals(result, 2.5, .000000001d);
    }

    @Test
    public void calculateColumnTotalLastRowValidFirstColumn() {
        this.mockingContext.checking(new Expectations() {
            {
                this.one(DataUtilitiesTest.this.values).getRowCount();
                this.will(returnValue(3));
                this.one(DataUtilitiesTest.this.values).getValue(0, 0);
                this.will(returnValue(7.5));
                this.one(DataUtilitiesTest.this.values).getValue(1, 0);
                this.will(returnValue(2.5));
                this.one(DataUtilitiesTest.this.values).getValue(2, 0);
                this.will(returnValue(5.0));
            }
        });

        double result = DataUtilities.calculateColumnTotal(this.values, 0, new int[] { 2 });
        assertEquals(5.0, result, .000000001d);
    }

    @Test
    public void calculateColumnTotalFirstRowValidMiddleColumn() {
        this.mockingContext.checking(new Expectations() {
            {
                this.one(DataUtilitiesTest.this.values).getRowCount();
                this.will(returnValue(3));
                this.one(DataUtilitiesTest.this.values).getValue(0, 1);
                this.will(returnValue(7.5));
                this.one(DataUtilitiesTest.this.values).getValue(1, 1);
                this.will(returnValue(2.5));
                this.one(DataUtilitiesTest.this.values).getValue(2, 1);
                this.will(returnValue(5.0));
            }
        });

        double result = DataUtilities.calculateColumnTotal(this.values, 1, new int[] { 0 });
        assertEquals(7.5, result, .000000001d);
    }

    @Test
    public void calculateColumnTotalMiddleRowValidMiddleColumn() {
        this.mockingContext.checking(new Expectations() {
            {
                this.one(DataUtilitiesTest.this.values).getRowCount();
                this.will(returnValue(3));
                this.one(DataUtilitiesTest.this.values).getValue(0, 1);
                this.will(returnValue(7.5));
                this.one(DataUtilitiesTest.this.values).getValue(1, 1);
                this.will(returnValue(2.5));
                this.one(DataUtilitiesTest.this.values).getValue(2, 1);
                this.will(returnValue(5.0));
            }
        });

        double result = DataUtilities.calculateColumnTotal(this.values, 1, new int[] { 1 });
        assertEquals(2.5, result, .000000001d);
    }

    @Test
    public void calculateColumnTotalLastRowValidMiddleColumn() {
        this.mockingContext.checking(new Expectations() {
            {
                this.one(DataUtilitiesTest.this.values).getRowCount();
                this.will(returnValue(3));
                this.one(DataUtilitiesTest.this.values).getValue(0, 1);
                this.will(returnValue(7.5));
                this.one(DataUtilitiesTest.this.values).getValue(1, 1);
                this.will(returnValue(2.5));
                this.one(DataUtilitiesTest.this.values).getValue(2, 1);
                this.will(returnValue(5.0));
            }
        });

        double result = DataUtilities.calculateColumnTotal(this.values, 1, new int[] { 2 });
        assertEquals(5.0, result, .000000001d);
    }

    @Test
    public void calculateColumnTotalFirstRowValidLastColumn() {
        this.mockingContext.checking(new Expectations() {
            {
                this.one(DataUtilitiesTest.this.values).getRowCount();
                this.will(returnValue(3));
                this.one(DataUtilitiesTest.this.values).getValue(0, 2);
                this.will(returnValue(7.5));
                this.one(DataUtilitiesTest.this.values).getValue(1, 2);
                this.will(returnValue(2.5));
                this.one(DataUtilitiesTest.this.values).getValue(2, 2);
                this.will(returnValue(5.0));
            }
        });

        double result = DataUtilities.calculateColumnTotal(this.values, 2, new int[] { 0 });
        assertEquals(7.5, result, .000000001d);
    }

    @Test
    public void calculateColumnTotalMiddleRowValidLastColumn() {
        this.mockingContext.checking(new Expectations() {
            {
                this.one(DataUtilitiesTest.this.values).getRowCount();
                this.will(returnValue(3));
                this.one(DataUtilitiesTest.this.values).getValue(0, 2);
                this.will(returnValue(7.5));
                this.one(DataUtilitiesTest.this.values).getValue(1, 2);
                this.will(returnValue(2.5));
                this.one(DataUtilitiesTest.this.values).getValue(2, 2);
                this.will(returnValue(5.0));
            }
        });

        double result = DataUtilities.calculateColumnTotal(this.values, 2, new int[] { 1 });
        assertEquals(2.5, result, .000000001d);
    }

    @Test
    public void calculateColumnTotalLastRowValidLastColumn() {
        this.mockingContext.checking(new Expectations() {
            {
                this.one(DataUtilitiesTest.this.values).getRowCount();
                this.will(returnValue(3));
                this.one(DataUtilitiesTest.this.values).getValue(0, 2);
                this.will(returnValue(7.5));
                this.one(DataUtilitiesTest.this.values).getValue(1, 2);
                this.will(returnValue(2.5));
                this.one(DataUtilitiesTest.this.values).getValue(2, 2);
                this.will(returnValue(5.0));
            }
        });

        double result = DataUtilities.calculateColumnTotal(this.values, 2, new int[] { 2 });
        assertEquals(5.0, result, .000000001d);
    }

    @Test
    public void calculateColumnTotalFirstAndLastRowValidFirstColumn() {
        this.mockingContext.checking(new Expectations() {
            {
                this.one(DataUtilitiesTest.this.values).getRowCount();
                this.will(returnValue(3));
                this.one(DataUtilitiesTest.this.values).getValue(0, 0);
                this.will(returnValue(7.5));
                this.one(DataUtilitiesTest.this.values).getValue(1, 0);
                this.will(returnValue(2.5));
                this.one(DataUtilitiesTest.this.values).getValue(2, 0);
                this.will(returnValue(5.0));
            }
        });

        double result = DataUtilities.calculateColumnTotal(this.values, 0, new int[] { 0, 2 });
        assertEquals(12.5, result, .000000001d);
    }

    @Test
    public void calculateColumnTotalMiddleAndLastRowValidLastColumn() {
        this.mockingContext.checking(new Expectations() {
            {
                this.one(DataUtilitiesTest.this.values).getRowCount();
                this.will(returnValue(3));
                this.one(DataUtilitiesTest.this.values).getValue(0, 2);
                this.will(returnValue(7.5));
                this.one(DataUtilitiesTest.this.values).getValue(1, 2);
                this.will(returnValue(3.5));
                this.one(DataUtilitiesTest.this.values).getValue(2, 2);
                this.will(returnValue(5.0));
            }
        });

        double result = DataUtilities.calculateColumnTotal(this.values, 2, new int[] { 1, 2 });
        assertEquals(8.5, result, .000000001d);
    }

    @Test
    public void calculateColumnTotalInvalidRowAUBAndOneValidRowLastColumn() {
        this.mockingContext.checking(new Expectations() {
            {
                this.one(DataUtilitiesTest.this.values).getRowCount();
                this.will(returnValue(3));
                this.one(DataUtilitiesTest.this.values).getValue(1, 2);
                this.will(returnValue(7.5));
            }
        });

        double result = DataUtilities.calculateColumnTotal(this.values, 2, new int[] { 1, 3 });
        assertEquals(7.5, result, .000000001d);
    }

    @Test
    public void calculateColumnTotalInvalidRowAUBMiddleColumn() {
        this.mockingContext.checking(new Expectations() {
            {
                this.one(DataUtilitiesTest.this.values).getRowCount();
                this.will(returnValue(3));
            }
        });

        double result = DataUtilities.calculateColumnTotal(this.values, 1, new int[] { 3 });
        assertEquals(0, result, .000000001d);
    }

    // @Test
    // public void calculateColumnTotalInvalidRowBLBFirstColumn() {
    // mockingContext.checking(new Expectations() {
    // {
    // one(values).getRowCount();
    // will(returnValue(3));
    // }
    // });
    //
    // double result = DataUtilities.calculateColumnTotal(values, 0, new int[] { -1
    // });
    // assertEquals(0, result, .000000001d);
    // }

    // @Test
    // public void calculateColumnTotalMaxRowsMaxColumn() {
    // mockingContext.checking(new Expectations() {
    // {
    // one(values).getRowCount();
    // will(returnValue(3));
    // one(values).getValue(0, Integer.MAX_VALUE);
    // will(returnValue(2.5));
    // one(values).getValue(Integer.MAX_VALUE, Integer.MAX_VALUE);
    // will(returnValue(5.0));
    // }
    // });
    //
    // double result = DataUtilities.calculateColumnTotal(values, Integer.MAX_VALUE,
    // new int[] { 0, Integer.MAX_VALUE });
    // assertEquals(7.5, result, .000000001d);
    // }

    // @Test
    // public void calculateColumnTotalBelowMaxRowsBelowMaxColumn() {
    // mockingContext.checking(new Expectations() {
    // {
    // one(values).getRowCount();
    // will(returnValue(3));
    // one(values).getValue(0, Integer.MAX_VALUE - 1);
    // will(returnValue(2.5));
    // one(values).getValue(Integer.MAX_VALUE - 1, Integer.MAX_VALUE - 1);
    // will(returnValue(5.0));
    // }
    // });
    //
    // double result = DataUtilities.calculateColumnTotal(values, Integer.MAX_VALUE
    // - 1,
    // new int[] { 0, Integer.MAX_VALUE - 1 });
    // assertEquals(7.5, result, .000000001d);
    // }

    @Test
    public void calculateColumnTotalWithMaxValue() {
        double max = Math.pow(2, 53); // Max double with integer precision

        this.mockingContext.checking(new Expectations() {
            {
                this.one(DataUtilitiesTest.this.values).getRowCount();
                this.will(returnValue(3));
                this.one(DataUtilitiesTest.this.values).getValue(0, 0);
                this.will(returnValue(max - 1));
                this.one(DataUtilitiesTest.this.values).getValue(1, 0);
                this.will(returnValue(1));
            }
        });

        double result = DataUtilities.calculateColumnTotal(this.values, 0, new int[] { 0, 1 });
        assertEquals(max, result, .000000001d);
    }

    // new test cases ---------------------------------------------------------
    @Test
    public void calculateColumnTotalAllRowsValidNullValue() {
        this.mockingContext.checking(new Expectations() {
            {
                this.one(DataUtilitiesTest.this.values).getRowCount();
                this.will(returnValue(3));
                this.one(DataUtilitiesTest.this.values).getValue(0, 0);
                this.will(returnValue(null));
                this.one(DataUtilitiesTest.this.values).getValue(1, 0);
                this.will(returnValue(2.5));
                this.one(DataUtilitiesTest.this.values).getValue(2, 0);
                this.will(returnValue(5.0));
            }
        });

        double result = DataUtilities.calculateColumnTotal(this.values, 0, new int[] { 0, 1, 2 });
        assertEquals(7.5, result, .000000001d);
    }

    @Test(expected = IllegalArgumentException.class)
    public void calculateColumnTotalWithNullValuesRows() {
        DataUtilities.calculateColumnTotal(null, 0, new int[] {});

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
        this.mockingContext.checking(new Expectations() {
            {
                this.allowing(DataUtilitiesTest.this.kv).getItemCount();
                this.will(returnValue(1));
                this.allowing(DataUtilitiesTest.this.kv).getKey(0);
                this.will(returnValue(0));
                this.allowing(DataUtilitiesTest.this.kv).getValue(0);
                this.will(returnValue(2));
            }
        });

        KeyedValues result = DataUtilities.getCumulativePercentages(this.kv);
        assertEquals("The Cumulative Percentage of 2 in data should be 1.0", 1.0, result.getValue(0));
    }

    @Test
    public void getCumulativePercentagesWithOneKeyedValueHavingZeroValue() {
        this.mockingContext.checking(new Expectations() {
            {
                this.allowing(DataUtilitiesTest.this.kv).getItemCount();
                this.will(returnValue(1));
                this.allowing(DataUtilitiesTest.this.kv).getKey(0);
                this.will(returnValue(0));
                this.allowing(DataUtilitiesTest.this.kv).getValue(0);
                this.will(returnValue(0));
            }
        });

        KeyedValues result = DataUtilities.getCumulativePercentages(this.kv);
        assertEquals("The cumulative percentage of 0 in data should be the result of 0.0/0.0", 0.0 / 0.0,
                result.getValue(0));
    }

    @Test
    public void test_getCumulativePercentages_oneKeyedValue_nullValue() {
        this.mockingContext.checking(new Expectations() {
            {
                this.allowing(DataUtilitiesTest.this.kv).getItemCount();
                this.will(returnValue(1));
                this.allowing(DataUtilitiesTest.this.kv).getKey(0);
                this.will(returnValue(0));
                this.allowing(DataUtilitiesTest.this.kv).getValue(0);
                this.will(returnValue(null));
            }
        });

        KeyedValues result = DataUtilities.getCumulativePercentages(this.kv);
        assertEquals("The cumulative percentage of null in data should be NaN", Double.NaN, result.getValue(0));
    }

    @Test
    public void getCumulativePercentagesWithKeyedValuesHavingNullAndMixValues() {
        this.mockingContext.checking(new Expectations() {
            {
                this.allowing(DataUtilitiesTest.this.kv).getItemCount();
                this.will(returnValue(5));
                this.allowing(DataUtilitiesTest.this.kv).getKey(0);
                this.will(returnValue(0));
                this.allowing(DataUtilitiesTest.this.kv).getKey(1);
                this.will(returnValue(1));
                this.allowing(DataUtilitiesTest.this.kv).getKey(2);
                this.will(returnValue(2));
                this.allowing(DataUtilitiesTest.this.kv).getKey(3);
                this.will(returnValue(3));
                this.allowing(DataUtilitiesTest.this.kv).getKey(4);
                this.will(returnValue(4));
                this.allowing(DataUtilitiesTest.this.kv).getValue(0);
                this.will(returnValue(-4.5));
                this.allowing(DataUtilitiesTest.this.kv).getValue(1);
                this.will(returnValue(2));
                this.allowing(DataUtilitiesTest.this.kv).getValue(2);
                this.will(returnValue(null));
                this.allowing(DataUtilitiesTest.this.kv).getValue(3);
                this.will(returnValue(12.5));
                this.allowing(DataUtilitiesTest.this.kv).getValue(4);
                this.will(returnValue(0));
            }
        });

        KeyedValues result = DataUtilities.getCumulativePercentages(this.kv);

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

    // new test cases ---------------------------------------------------------
    @Test(expected = IllegalArgumentException.class)
    public void getCumulativePercentagesNullValue() {
        DataUtilities.getCumulativePercentages(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createNumberArrayWithNullValue() {
        DataUtilities.createNumberArray(null);
    }

    @Test
    public void createNumberArrayAllZeros() {
        assertArrayEquals("Number array of zeros should be created", new Number[] { 0.0, 0.0, 0.0, 0.0, 0.0 },
                DataUtilities.createNumberArray(new double[] { 0.0, 0.0, 0.0, 0.0, 0.0 }));
    }

    @Test
    public void createNumberArrayZeroLength() {
        assertArrayEquals("Number array of length zero should be created", new Number[] {},
                DataUtilities.createNumberArray(new double[] {}));
    }

    @Test(expected = IllegalArgumentException.class)
    public void createNumberArray2DWithNullValue() {
        DataUtilities.createNumberArray2D(null);
    }

    @Test
    public void createNumberArray2d3x3AllZeros() {
        assertArrayEquals("Number array of zeros should be created",
                new Number[][] { { 0.0, 0.0, 0.0 }, { 0.0, 0.0, 0.0 } },
                DataUtilities.createNumberArray2D(new double[][] { { 0.0, 0.0, 0.0 }, { 0.0, 0.0, 0.0 } }));
    }

    @Test
    public void createNumberArray2dZeroLength() {
        assertArrayEquals("Number array of length zero should be created", new Number[][] { {}, {} },
                DataUtilities.createNumberArray2D(new double[][] { {}, {} }));
    }
}

/*----------------------------------------------------------------------------------------------------------------------
    DoubleRange sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util.iterable.range;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.DoubleUnaryOperator;

public class DoubleRange implements Iterable<Double>{
    private final double m_min;
    private final double m_max;
    private final DoubleUnaryOperator m_doubleUnaryOperator;

    private DoubleRange(double min, double max, DoubleUnaryOperator doubleUnaryOperator)
    {
        if (min > max)
            throw new IllegalArgumentException("Invalid Arguments");

        m_min = min;
        m_max = max;
        m_doubleUnaryOperator = doubleUnaryOperator;
    }

    public double getMin()
    {
        return m_min;
    }

    public double getMax()
    {
        return m_max;
    }

    public static DoubleRange of(double min, double max, double step)
    {
        return of(min, max, (step <= 0) ? (val -> val + 1) : (val -> val + step));
    }

    public static DoubleRange of(double min, double max, DoubleUnaryOperator doubleUnaryOperator)
    {
        return new DoubleRange(min, max, doubleUnaryOperator);
    }

    @Override
    public Iterator<Double> iterator()
    {
        return new Iterator<Double>() {
            double m_val = m_min;

            @Override
            public boolean hasNext()
            {
                return m_val < m_max;
            }

            @Override
            public Double next()
            {
                if (!hasNext())
                    throw new NoSuchElementException("No such element");

                double val = m_val;

                m_val = m_doubleUnaryOperator.applyAsDouble(m_val);

                return val;
            }
        };
    }
}

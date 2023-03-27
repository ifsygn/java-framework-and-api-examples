/*---------------------------------------------------------------------------------------------------------------------
    Sınıf Açıklaması: Aşağıdaki açıklanan RandomIntGenerator sınıfını yazınız.
Açıklamalar:
- Sınıf eleman tuttuğu min ve max değerleri için, for-each deyminin her adımında [min, max) aralığında yine
veri elemanı olarak tuttuğu count değeri kadar rastgele sayı üretecektir.
- Sınıfın IntSupplier referans elemanı üretilecek sayının nasıl elde edildiğini tutacaktır.
---------------------------------------------------------------------------------------------------------------------*/

package org.csystem.util.iterable.generator;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.function.IntSupplier;

public class RandomIntGenerator implements Iterable<Integer>{
    private final int m_count;
    private final IntSupplier m_supplier;


    private RandomIntGenerator(int count, IntSupplier intSupplier)
    {
        m_count = count;
        m_supplier = intSupplier;
    }

    public static RandomIntGenerator of(Random random, int count, int min, int max)
    {
        return of(count, () -> random.nextInt(max - min) + min);
    }

    public static RandomIntGenerator of(int count, IntSupplier intSupplier)
    {
        return new RandomIntGenerator(count, intSupplier);
    }

    public int getCount()
    {
        return m_count;
    }

    @Override
    public Iterator<Integer> iterator()
    {
        return new Iterator<Integer>() {
            int m_n ;
            @Override
            public boolean hasNext()
            {
                return m_n + 1 < m_count;
            }

            @Override
            public Integer next()
            {
                if (!hasNext())
                    throw new NoSuchElementException("No such element");

                ++m_n;

                return m_supplier.getAsInt();
            }
        };
    }
}

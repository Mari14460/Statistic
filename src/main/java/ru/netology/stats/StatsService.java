package ru.netology.stats;

public class StatsService {
//    Сумму всех продаж
//    Среднюю сумму продаж в месяц
//    Номер месяца, в котором был пик продаж (осуществлены продажи на максимальную сумму)*
//    Номер месяца, в котором был минимум продаж (осуществлены продажи на минимальную сумму)*
//    Кол-во месяцев, в которых продажи были ниже среднего (см. п.2)
//    Кол-во месяцев, в которых продажи были выше среднего (см. п.2)
    //  0   1   2   3   4                         11 (12-1) - index
    //  1   2   3                                 12 - номер месяца = index + 1
    // [8, 15, 13, 15, 17, 20, 19, 20, 7, 14, 14, 18] - 12 elements total

    //    Сумму всех продаж
    public long sum(long[] sales) {
        long result = 0;
        for (int i = 0; i < sales.length; i++) {
            result = result + sales[i];
        }
        return result;
    }

    //    Среднюю сумму продаж в месяц
    public long average(long[] sales) {
        long result = 0;
        result = sum(sales) / sales.length;
        return result;
    }

    //    Номер месяца, в котором был пик продаж (осуществлены продажи на максимальную сумму)*
    // [8, 15, 13, 15, 17, 20, 19, 20, 7, 14, 14, 18] - 12 elements total
    public int maxSales(long[] sales) {
        long max = 0;  // Максимальная сумма продаж
        int month = 0; // Номер месяца с максимальной суммой продаж
        for (int i = 0; i < sales.length; i++) { // i++ = i=i+1
            if (sales[i] > max) {
                max = sales[i]; // i=0 max=8 | i=1 max=15
                month = i;   // i=0 month =0 | i=1 month=1
            }
        }
        month++;
        return month;
    }

    public int minSales(long[] sales) { // [8, 15, 13, 15, 17, 20, 19, 20, 7, 14, 14, 18]
        long min = sales[maxSales(sales) - 1];  // Максимальная сумма продаж
        int month = 0; // Номер месяца с с минимальной суммой продаж суммой продаж
        for (int i = 0; i < sales.length; i++) { // i++ = i=i+1
            if (sales[i] < min) {
                min = sales[i];
                month = i;
            }
        }
        month++;
        return month;
    }

    //    Кол-во месяцев, в которых продажи были ниже среднего (см. п.2)
    public int numberOfMonthsLessThanAverage(long[] sales) {
        int result = 0;
        long averageSales = average(sales);
        for (int i = 0; i < sales.length; i++) { // i++ = i=i+1
            if (sales[i] < averageSales) {
                result++;
            }
        }
        return result;
    }

    //    Кол-во месяцев, в которых продажи были выше среднего (см. п.2)
    public int numberOfMonthsMoreThanAverage(long[] sales) {
        int result = 0;
        long averageSales = average(sales);
        for (int i = 0; i < sales.length; i++) { // i++ = i=i+1
            if (sales[i] > averageSales) {
                result++;
            }
        }
        return result;
    }
}

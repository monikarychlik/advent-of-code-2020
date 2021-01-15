package pl.andrzej.main

import java.lang.Math.abs

class DayOne {

    companion object {
        private val numbers = listOf(
            1975,
            1446,
            1902,
            1261,
            1783,
            1535,
            1807,
            1606,
            1685,
            1933,
            1930,
            1813,
            1331,
            1986,
            1379,
            1649,
            1342,
            1206,
            1832,
            1464,
            1840,
            1139,
            1316,
            1366,
            593,
            1932,
            1553,
            1065,
            2004,
            1151,
            1345,
            1026,
            1958,
            1778,
            1987,
            1425,
            1170,
            1927,
            1487,
            1116,
            1612,
            2005,
            1977,
            1691,
            1964,
            398,
            1621,
            1542,
            1929,
            1102,
            1993,
            1426,
            1349,
            1280,
            1775,
            849,
            1344,
            1940,
            1707,
            1562,
            1979,
            1325,
            1610,
            559,
            1812,
            1938,
            1572,
            1949,
            1136,
            161,
            1893,
            1207,
            1363,
            1551,
            1333,
            1904,
            1332,
            1450,
            1773,
            1216,
            1185,
            1881,
            1835,
            1460,
            1277,
            1374,
            1568,
            1731,
            1365,
            1719,
            1749,
            1371,
            1602,
            1108,
            1030,
            1859,
            1875,
            1976,
            1837,
            1768,
            1873,
            1226,
            1533,
            1601,
            1394,
            1422,
            1219,
            1269,
            1793,
            1195,
            1234,
            1575,
            1882,
            1223,
            1826,
            521,
            1161,
            1738,
            1506,
            1574,
            1337,
            1509,
            1430,
            1496,
            1318,
            1400,
            1852,
            1670,
            1898,
            1858,
            1950,
            1870,
            1920,
            868,
            1814,
            1853,
            1911,
            1907,
            1713,
            1281,
            1759,
            1210,
            1350,
            1035,
            1585,
            1765,
            1220,
            1125,
            1714,
            1810,
            1002,
            1356,
            1192,
            1452,
            1236,
            1482,
            1716,
            1681,
            1323,
            1923,
            1876,
            1792,
            1346,
            1891,
            1721,
            1056,
            1675,
            1518,
            1540,
            1068,
            1563,
            1942,
            1668,
            1653,
            1357,
            1632,
            1128,
            1726,
            1586,
            1998,
            1138,
            1510,
            1022,
            1480,
            1434,
            1305,
            1861,
            1623,
            1009,
            1339,
            1159,
            1085,
            1578,
            1689,
            1091,
            1874,
            1043,
            1737,
            1704,
            1515
        )

        fun firstPuzzleHalfDivideVersion() {
            val start = System.currentTimeMillis()
            val numbers = numbers.sortedDescending()
            val lastIndex = numbers.size - 1;
            var i = 0
            var j: Int = numbers.size / 2
            var lastJ = 0

            while (numbers[i] + numbers[j] != 2020) {
                println("i = $i, j = $j, sum = ${numbers[i] + numbers[j]}")

                if (i == j || j == lastIndex) {
                    i++
                    lastJ = j
                    j = numbers.size / 2
                    continue
                }

                val newJ: Int
                if (numbers[i] + numbers[j] < 2020) {
                    newJ = i.coerceAtLeast(j - 1.coerceAtLeast((abs(lastJ - j) / 2)))
                } else {
                    newJ = lastIndex.coerceAtMost(j + 1.coerceAtLeast((abs(lastJ - j) / 2)))
                }
                lastJ = j
                j = newJ
            }

            println("Result: " + (numbers[i] * numbers[j]))
            println("Time: " + (System.currentTimeMillis() - start))
        }

        fun firstPuzzle() {
            val start = System.currentTimeMillis()
            val numbers = numbers.sortedDescending()
            val lastIndex = numbers.size - 1;
            var i = 0
            var j: Int = lastIndex

            while (numbers[i] + numbers[j] != 2020) {
                println("i = $i, j = $j, sum = ${numbers[i] + numbers[j]}")

                if (i == j || j == lastIndex) {
                    i++
                    j = lastIndex
                    continue
                }

                if (numbers[i] + numbers[j] < 2020) {
                    j--
                } else {
                    j++
                }
            }

            println("Result: " + (numbers[i] * numbers[j]))
            println("Time: " + (System.currentTimeMillis() - start))
        }

        fun secondPuzzle() {
            val start = System.currentTimeMillis()
            val numbers = numbers.sortedDescending()
            val lastIndex = numbers.size - 1;
            var step = 2
            var i = lastIndex - step
            var j = lastIndex - 1
            var k = lastIndex
            var stage = 1

            while (numbers[i] + numbers[j] + numbers[k] != 2020) {
                println("i = $i, j = $j, k = $k, sum = ${numbers[i] + numbers[j] + numbers[k]}")

                if (numbers[i] + numbers[j] + numbers[k] < 2020) {
                    if (stage == 1) {
                        i--
                    } else if (stage == 2) {
                        if (i == j) {
                            if (stage == 2) {
                                stage = 3
                                k--
                            }
                        } else {
                            j--
                        }
                    } else {
                        k--
                    }
                } else {
                    if (stage == 1) {
                        stage = 2
                        j--
                        i++
                    } else if (i == j) {
                        if (stage == 2) {
                            stage = 3
                            k--
                        }
                        j++
                    } else if (i >= lastIndex - step) {
                        step++
                        stage = 1
                        i = lastIndex - step
                        j = i + 1
                        k = j + 1
                    } else {
                        i++
                    }
                }
            }

            println("Result: " + (numbers[i] * numbers[j] * numbers[k]))
            println("Time: " + (System.currentTimeMillis() - start))
        }
    }
}
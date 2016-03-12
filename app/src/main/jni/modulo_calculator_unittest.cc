#if RUN_GTEST

#include <gtest/gtest.h>
#include "modulo_calculator.h"

TEST(ModuloCalcTest, ZeroZero) {
    // Expect 0
    EXPECT_EQ(0, add(0, 0));
    // Expect 146279677 = 75752175 + 70527502
    EXPECT_EQ(146279677, add(75752175, 70527502));

    // Expect -18359 = 65926 - 84285
    EXPECT_EQ(-18359, subtract(65926, 84285));
    // Expect -52729 = 0 - 52729
    EXPECT_EQ(-52729, subtract(0, 52729));
    // Expect 19693 = 82645 - 62952
    EXPECT_EQ(19693, subtract(82645, 62952));

    // Expect 0 = 0 x 453629
    EXPECT_EQ(0, multiply(0, 453629));
    // Expect 60380250 = 6510 x 9275
    EXPECT_EQ(60380250, multiply(6510, 9275));

    // Expect 0 = 0 % 7
    EXPECT_EQ(0, modulo(0, 7));
    // Expect 3 = -7564 % 7
    EXPECT_EQ(3, modulo(-7564, 7));
    // Expect 6 = 5092646 % 7
    EXPECT_EQ(6, modulo(5092646, 7));
}

#endif
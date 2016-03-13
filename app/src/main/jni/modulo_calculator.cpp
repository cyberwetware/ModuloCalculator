#include "modulo_calculator.h"

int add(int x, int y)
{
    return x + y;
}

int subtract(int x, int y)
{
    return x - y;
}

int multiply(int x, int y)
{
    return x * y;
}

int modulo(int x, int y)
{
    return x > 0 ? x % y : x + y * ((y - x - 1) / y);
}

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
    if((x > 0 && y > 0) || (x < 0) && (y < 0))
        return x % y;
    else if((x < 0 && y > 0))
        return -((-x) % y);
    else if((x > 0 && y < 0))
        return -(x % (-y));
}

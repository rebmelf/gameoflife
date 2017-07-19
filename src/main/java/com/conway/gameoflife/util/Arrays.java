package com.conway.gameoflife.util;

public final class Arrays {

  public static Integer getMin(final Integer number) {
    return 0 < number ? number - 1 : 0;
  }

  public static Integer getMax(final Integer number, final Integer original) {
    return original - 1 > number ? number + 1 : original - 1;
  }
}

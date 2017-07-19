package com.conway.gameoflife.util;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ArraysSpec {

  @Test
  public void maxCountWorksForTheUpperLimit() {
    final Integer number = Arrays.getMax(10, 9);

    assertThat(number, is(8));
  }

  @Test
  public void maxCountWorksForNumberUnderLimit() {
    final Integer number = Arrays.getMax(4, 9);

    assertThat(number, is(5));
  }

  @Test
  public void minCountWorksForTheLowerLimit() {
    final Integer number = Arrays.getMin(0);

    assertThat(number, is(0));
  }

  @Test
  public void maxCountWorksForNumberOverLimit() {
    final Integer number = Arrays.getMin(2);

    assertThat(number, is(1));
  }
}
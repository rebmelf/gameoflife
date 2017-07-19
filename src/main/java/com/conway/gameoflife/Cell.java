package com.conway.gameoflife;

import static com.conway.gameoflife.LifeState.UNPOPULATED;

public class Cell {

  private LifeState currentState;
  private LifeState futureState;

  public Cell(LifeState initialState) {
    this.currentState = initialState;
    this.futureState = UNPOPULATED;
  }

  public LifeState getCurrentState() {
    return currentState;
  }

  public void setCurrentState(final LifeState currentState) {
    this.currentState = currentState;
  }

  public LifeState getFutureState() {
    return futureState;
  }

  public void setFutureState(final LifeState futureState) {
    this.futureState = futureState;
  }
}

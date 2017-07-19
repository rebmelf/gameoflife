package com.conway.gameoflife.service.impl;

import com.conway.gameoflife.Cell;
import com.conway.gameoflife.LifeState;
import com.conway.gameoflife.World;
import com.conway.gameoflife.service.NewTurnService;

import static com.conway.gameoflife.LifeState.POPULATED;
import static com.conway.gameoflife.LifeState.UNPOPULATED;
import static com.conway.gameoflife.util.Arrays.getMax;
import static com.conway.gameoflife.util.Arrays.getMin;

public class NewTurnServiceImpl implements NewTurnService {

  @Override
  public World passTurn(World world) {
    world = markNextState(world);
    return endTurn(world);
  }

  private World markNextState(final World world) {
    for (int h = 0; h < world.getHeight(); h++) {
      for (int w = 0; w < world.getWidth(); w++) {
        final Cell cell = world.getField(w, h);
        final LifeState nextState = getNextState(world, w, h);
        cell.setFutureState(nextState);
        world.setField(cell, w, h);
      }
    }
    return world;
  }

  private LifeState getNextState(final World world, final Integer width, final Integer height) {
    final Integer numberOfNeighbours = numberOfNeighbours(world, width, height);
    if (numberOfNeighbours == 3 && world.getField(width, height).getCurrentState().equals(UNPOPULATED)) {
      return POPULATED;
    }
    if ((numberOfNeighbours == 2 || numberOfNeighbours == 3)
      && world.getField(width, height).getCurrentState().equals(POPULATED)) {
      return POPULATED;
    }
    return UNPOPULATED;
  }

  private Integer numberOfNeighbours(World world, Integer width, Integer height) {
    Integer neighbours = 0;
    for (int h = getMin(height); h <= getMax(height, world.getHeight()); h++) {
      for (int w = getMin(width); w <= getMax(width, world.getWidth()); w++) {
        if (world.getField(w, h).getCurrentState().equals(POPULATED) && (h != height || w != width)) {
          neighbours++;
        }
      }
    }
    return neighbours;
  }

  private World endTurn(final World world) {
    for (int h = 0; h < world.getHeight(); h++) {
      for (int w = 0; w < world.getWidth(); w++) {
        final Cell cell = world.getField(w, h);
        cell.setCurrentState(cell.getFutureState());
        world.setField(cell, w, h);
      }
    }
    return world;
  }
}

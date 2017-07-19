package com.conway.gameoflife.api;

import org.junit.Before;
import org.junit.Test;

import com.conway.gameoflife.dto.CellDTO;
import com.conway.gameoflife.dto.WorldDTO;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GameOfLifeApiSpec {

  private WorldDTO initialState;

  @Before
  public void setupInitialState() {
    initialState = new WorldDTO(3, 3);
    initialState.setField(0, 0, new CellDTO(true));
    initialState.setField(0, 1, new CellDTO(true));
    initialState.setField(0, 2, new CellDTO(true));
    initialState.setField(1, 0, new CellDTO(true));
    initialState.setField(1, 1, new CellDTO(true));
    initialState.setField(1, 2, new CellDTO(true));
  }

  @Test
  public void firstStepReturnsTheInitialState() {
    final GameOfLifeApi gameOfLifeApi = new GameOfLifeApi(initialState);
    final WorldDTO newState = gameOfLifeApi.getState();

    assertThat(newState.getWidth(), is(3));
    assertThat(newState.getHeight(), is(3));
    assertThat(newState.getField(0, 0).isAlive(), is(true));
    assertThat(newState.getField(0, 1).isAlive(), is(true));
    assertThat(newState.getField(0, 2).isAlive(), is(true));
    assertThat(newState.getField(1, 0).isAlive(), is(true));
    assertThat(newState.getField(1, 1).isAlive(), is(true));
    assertThat(newState.getField(1, 2).isAlive(), is(true));
    assertThat(newState.getField(2, 0).isAlive(), is(false));
    assertThat(newState.getField(2, 1).isAlive(), is(false));
    assertThat(newState.getField(2, 2).isAlive(), is(false));
  }

  @Test
  public void secondStepReturnsTransformedState() {
    final GameOfLifeApi gameOfLifeApi = new GameOfLifeApi(initialState);
    gameOfLifeApi.getState();
    final WorldDTO newState = gameOfLifeApi.getState();

    assertThat(newState.getWidth(), is(3));
    assertThat(newState.getHeight(), is(3));
    assertThat(newState.getField(0, 0).isAlive(), is(true));
    assertThat(newState.getField(0, 1).isAlive(), is(false));
    assertThat(newState.getField(0, 2).isAlive(), is(true));
    assertThat(newState.getField(1, 0).isAlive(), is(true));
    assertThat(newState.getField(1, 1).isAlive(), is(false));
    assertThat(newState.getField(1, 2).isAlive(), is(true));
    assertThat(newState.getField(2, 0).isAlive(), is(false));
    assertThat(newState.getField(2, 1).isAlive(), is(true));
    assertThat(newState.getField(2, 2).isAlive(), is(false));
  }
}
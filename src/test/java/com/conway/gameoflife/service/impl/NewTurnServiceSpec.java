package com.conway.gameoflife.service.impl;

import org.junit.Test;

import com.conway.gameoflife.World;
import com.conway.gameoflife.dto.CellDTO;
import com.conway.gameoflife.dto.WorldDTO;

import static com.conway.gameoflife.LifeState.POPULATED;
import static com.conway.gameoflife.LifeState.UNPOPULATED;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class NewTurnServiceSpec {

  @Test
  public void newPopulationBorn() {
    WorldDTO worldDTO = new WorldDTO(3, 3);
    worldDTO.setField(0, 0, new CellDTO(true));
    worldDTO.setField(0, 1, new CellDTO(true));
    worldDTO.setField(1, 0, new CellDTO(true));

    World world = World.create(worldDTO, 3, 3);

    final World newState = new NewTurnServiceImpl().passTurn(world);

    assertThat(newState.getHeight(), is(3));
    assertThat(newState.getWidth(), is(3));
    assertThat(newState.getField(0, 0).getCurrentState(), is(POPULATED));
    assertThat(newState.getField(1, 0).getCurrentState(), is(POPULATED));
    assertThat(newState.getField(2, 0).getCurrentState(), is(UNPOPULATED));
    assertThat(newState.getField(0, 1).getCurrentState(), is(POPULATED));
    assertThat(newState.getField(1, 1).getCurrentState(), is(POPULATED));
    assertThat(newState.getField(2, 1).getCurrentState(), is(UNPOPULATED));
    assertThat(newState.getField(0, 2).getCurrentState(), is(UNPOPULATED));
    assertThat(newState.getField(1, 2).getCurrentState(), is(UNPOPULATED));
    assertThat(newState.getField(2, 2).getCurrentState(), is(UNPOPULATED));
  }

  @Test
  public void underPopulation() {
    WorldDTO worldDTO = new WorldDTO(3, 3);
    worldDTO.setField(0, 0, new CellDTO(true));
    worldDTO.setField(0, 1, new CellDTO(true));

    World world = World.create(worldDTO, 3, 3);

    final World newState = new NewTurnServiceImpl().passTurn(world);

    assertThat(newState.getHeight(), is(3));
    assertThat(newState.getWidth(), is(3));
    assertThat(newState.getField(0, 0).getCurrentState(), is(UNPOPULATED));
    assertThat(newState.getField(1, 0).getCurrentState(), is(UNPOPULATED));
    assertThat(newState.getField(2, 0).getCurrentState(), is(UNPOPULATED));
    assertThat(newState.getField(0, 1).getCurrentState(), is(UNPOPULATED));
    assertThat(newState.getField(1, 1).getCurrentState(), is(UNPOPULATED));
    assertThat(newState.getField(2, 1).getCurrentState(), is(UNPOPULATED));
    assertThat(newState.getField(0, 2).getCurrentState(), is(UNPOPULATED));
    assertThat(newState.getField(1, 2).getCurrentState(), is(UNPOPULATED));
    assertThat(newState.getField(2, 2).getCurrentState(), is(UNPOPULATED));
  }

  @Test
  public void overPopulation() {
    WorldDTO worldDTO = new WorldDTO(3, 3);
    worldDTO.setField(0, 0, new CellDTO(true));
    worldDTO.setField(0, 1, new CellDTO(true));
    worldDTO.setField(0, 2, new CellDTO(true));
    worldDTO.setField(1, 0, new CellDTO(true));
    worldDTO.setField(1, 1, new CellDTO(true));
    World world = World.create(worldDTO, 3, 3);

    final World newState = new NewTurnServiceImpl().passTurn(world);

    assertThat(newState.getHeight(), is(3));
    assertThat(newState.getWidth(), is(3));
    assertThat(newState.getField(0, 0).getCurrentState(), is(POPULATED));
    assertThat(newState.getField(1, 0).getCurrentState(), is(UNPOPULATED));
    assertThat(newState.getField(2, 0).getCurrentState(), is(POPULATED));
    assertThat(newState.getField(0, 1).getCurrentState(), is(POPULATED));
    assertThat(newState.getField(1, 1).getCurrentState(), is(UNPOPULATED));
    assertThat(newState.getField(2, 1).getCurrentState(), is(POPULATED));
    assertThat(newState.getField(0, 2).getCurrentState(), is(UNPOPULATED));
    assertThat(newState.getField(1, 2).getCurrentState(), is(UNPOPULATED));
    assertThat(newState.getField(2, 2).getCurrentState(), is(UNPOPULATED));
  }
}
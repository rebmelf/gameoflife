package com.conway.gameoflife.service.impl;

import org.junit.Test;

import com.conway.gameoflife.World;
import com.conway.gameoflife.dto.CellDTO;
import com.conway.gameoflife.dto.WorldDTO;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GetStateServiceSpec {

  @Test
  public void getState() {
    WorldDTO initialState = new WorldDTO(3, 3);
    initialState.setField(0, 0, new CellDTO(true));
    initialState.setField(1, 1, new CellDTO(true));
    initialState.setField(2, 2, new CellDTO(true));
    World world = World.create(initialState, 3, 3);

    final WorldDTO worldDTO = new GetStateServiceImpl().getCurrentState(world);

    assertThat(worldDTO.getHeight(), is(3));
    assertThat(worldDTO.getWidth(), is(3));
    assertThat(worldDTO.getField(0, 0).isAlive(), is(true));
    assertThat(worldDTO.getField(0, 1).isAlive(), is(false));
    assertThat(worldDTO.getField(0, 2).isAlive(), is(false));
    assertThat(worldDTO.getField(1, 0).isAlive(), is(false));
    assertThat(worldDTO.getField(1, 1).isAlive(), is(true));
    assertThat(worldDTO.getField(1, 2).isAlive(), is(false));
    assertThat(worldDTO.getField(2, 0).isAlive(), is(false));
    assertThat(worldDTO.getField(2, 1).isAlive(), is(false));
    assertThat(worldDTO.getField(2, 2).isAlive(), is(true));
  }
}
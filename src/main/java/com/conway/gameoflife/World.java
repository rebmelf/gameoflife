package com.conway.gameoflife;

import com.conway.gameoflife.dto.CellDTO;
import com.conway.gameoflife.dto.WorldDTO;

import static com.conway.gameoflife.LifeState.POPULATED;
import static com.conway.gameoflife.LifeState.UNPOPULATED;

public class World {

  private final Integer height;
  private final Integer width;

  private final Cell[][] world;

  private World(final Integer width, final Integer height, final WorldDTO worldDTO) {
    this.height = height;
    this.width = width;
    world = new Cell[width][height];
    initialState(worldDTO);
  }

  public static World create(final WorldDTO worldDTO, final Integer width, final Integer height) {
    return new World(width, height, worldDTO);
  }

  public Cell getField(Integer width, Integer height) {
    return world[width][height];
  }

  public void setField(Cell cell, Integer width, Integer height) {
    world[width][height] = cell;
  }

  public Integer getHeight() {
    return height;
  }

  public Integer getWidth() {
    return width;
  }

  private void initialState(WorldDTO worldDTO) {
    for (int h = 0; h < worldDTO.getHeight(); h++) {
      for (int w = 0; w < worldDTO.getWidth(); w++) {
        final Cell cell = new Cell(convertToLifeState(worldDTO.getField(h, w)));
        world[w][h] = cell;
      }
    }
  }

  private LifeState convertToLifeState(CellDTO cellDTO) {
    return cellDTO.isAlive() ? POPULATED : UNPOPULATED;
  }
}

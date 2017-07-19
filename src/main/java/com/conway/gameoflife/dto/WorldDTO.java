package com.conway.gameoflife.dto;

public class WorldDTO {

  private final CellDTO[][] world;
  private Integer height;
  private Integer width;

  public WorldDTO(Integer width, Integer height) {
    world = new CellDTO[width][height];
    this.height = height;
    this.width = width;
    initialState();
  }

  private void initialState() {
    for (int h = 0; h < height; h++) {
      for (int w = 0; w < width; w++) {
        final CellDTO cell = new CellDTO(false);
        world[w][h] = cell;
      }
    }
  }

  public void setField(Integer width, Integer height, CellDTO cell) {
    world[width][height] = cell;
  }

  public CellDTO getField(Integer width, Integer height) {
    return world[width][height];
  }

  public Integer getHeight() {
    return height;
  }

  public Integer getWidth() {
    return width;
  }
}

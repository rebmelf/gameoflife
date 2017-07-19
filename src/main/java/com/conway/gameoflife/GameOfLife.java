package com.conway.gameoflife;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.conway.gameoflife.dto.CellDTO;
import com.conway.gameoflife.dto.WorldDTO;
import com.conway.gameoflife.ui.Frontend;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigException;
import com.typesafe.config.ConfigFactory;

public class GameOfLife {

  private static final Logger logger = LoggerFactory.getLogger(GameOfLife.class);

  public static void main(final String[] args) {
    Integer width = 0;
    Integer height = 0;
    try {
      Config conf = ConfigFactory.load();
      width = conf.getInt("table.width");
      height = conf.getInt("table.height");
    } catch (ConfigException e) {
      logger.error("Please provide a correct configuration", e);
      throw e;
    }
    initialize(width, height);
  }

  private static void initialize(final Integer width, final Integer height) {
    WorldDTO initialState = new WorldDTO(width, height);
    initialState.setField(1, 1, new CellDTO(true));
    initialState.setField(2, 1, new CellDTO(true));
    initialState.setField(3, 1, new CellDTO(true));
    initialState.setField(5, 1, new CellDTO(true));
    initialState.setField(1, 2, new CellDTO(true));
    initialState.setField(4, 3, new CellDTO(true));
    initialState.setField(5, 3, new CellDTO(true));
    initialState.setField(2, 4, new CellDTO(true));
    initialState.setField(3, 4, new CellDTO(true));
    initialState.setField(5, 4, new CellDTO(true));
    initialState.setField(1, 5, new CellDTO(true));
    initialState.setField(3, 5, new CellDTO(true));
    initialState.setField(5, 5, new CellDTO(true));
    new Frontend(initialState);
  }
}

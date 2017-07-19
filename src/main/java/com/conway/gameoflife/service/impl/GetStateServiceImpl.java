package com.conway.gameoflife.service.impl;

import com.conway.gameoflife.Cell;
import com.conway.gameoflife.LifeState;
import com.conway.gameoflife.World;
import com.conway.gameoflife.dto.CellDTO;
import com.conway.gameoflife.dto.WorldDTO;
import com.conway.gameoflife.service.GetStateService;

import static com.conway.gameoflife.LifeState.POPULATED;

public class GetStateServiceImpl implements GetStateService {

  @Override
  public WorldDTO getCurrentState(final World world) {
    WorldDTO worldDTO = new WorldDTO(world.getWidth(), world.getHeight());
    for (int h = 0; h < world.getHeight(); h++) {
      for (int w = 0; w < world.getWidth(); w++) {
        final Cell cell = world.getField(w, h);
        CellDTO cellDTO = new CellDTO(isAlive(cell.getCurrentState()));
        worldDTO.setField(h, w, cellDTO);
      }
    }
    return worldDTO;
  }

  private boolean isAlive(LifeState lifeState) {
    return POPULATED.equals(lifeState);
  }
}

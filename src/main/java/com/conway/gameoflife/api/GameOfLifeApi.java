package com.conway.gameoflife.api;

import com.conway.gameoflife.World;
import com.conway.gameoflife.dto.WorldDTO;
import com.conway.gameoflife.service.impl.GetStateServiceImpl;
import com.conway.gameoflife.service.impl.NewTurnServiceImpl;

public class GameOfLifeApi {

  private boolean initialState = true;
  private World world;
  private final NewTurnServiceImpl newTurnService;
  private final GetStateServiceImpl stateService;

  public GameOfLifeApi(WorldDTO initialState) {
    this.world = World.create(initialState, initialState.getWidth(), initialState.getHeight());
    this.stateService = new GetStateServiceImpl();
    this.newTurnService = new NewTurnServiceImpl();
  }

  public WorldDTO getState() {
    if (initialState) {
      initialState = false;
      return stateService.getCurrentState(world);
    }
    world = newTurnService.passTurn(world);
    return stateService.getCurrentState(world);
  }
}

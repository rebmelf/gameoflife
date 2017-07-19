package com.conway.gameoflife.service;

import com.conway.gameoflife.World;

public interface NewTurnService {

  World passTurn(World original);
}

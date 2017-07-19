package com.conway.gameoflife.service;

import com.conway.gameoflife.World;
import com.conway.gameoflife.dto.WorldDTO;

public interface GetStateService {

  WorldDTO getCurrentState(World world);
}

package com.conway.gameoflife.ui;

import java.awt.*;
import javax.swing.*;

import com.conway.gameoflife.dto.WorldDTO;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Frontend {

  public Frontend(WorldDTO initialState) {
    EventQueue.invokeLater(() -> {
      JFrame frame = new JFrame("!!!Game of Life!!!");
      frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
      frame.setLayout(new BorderLayout());
      frame.add(new WorldTable(initialState));
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
    });
  }
}

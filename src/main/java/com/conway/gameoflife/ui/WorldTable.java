package com.conway.gameoflife.ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

import com.conway.gameoflife.api.GameOfLifeApi;
import com.conway.gameoflife.dto.WorldDTO;

class WorldTable extends JPanel implements ActionListener {

  private final GameOfLifeApi api;

  private Timer timer = new Timer(1000, this);

  WorldTable(WorldDTO lastState) {
    timer.start();
    api = new GameOfLifeApi(lastState);

    paint();
  }

  private void paint() {
    WorldDTO currentState = api.getState();
    setLayout(new GridBagLayout());

    GridBagConstraints gbc = new GridBagConstraints();
    for (int row = 0; row < currentState.getWidth(); row++) {
      for (int col = 0; col < currentState.getHeight(); col++) {
        gbc.gridx = col;
        gbc.gridy = row;

        TableCell cellPane = new TableCell(currentState.getField(col, row));
        Border border;
        if (row < currentState.getHeight()) {
          if (col < currentState.getHeight()) {
            border = new MatteBorder(1, 1, 0, 0, Color.GRAY);
          } else {
            border = new MatteBorder(1, 1, 0, 1, Color.GRAY);
          }
        } else {
          if (col < 4) {
            border = new MatteBorder(1, 1, 1, 0, Color.GRAY);
          } else {
            border = new MatteBorder(1, 1, 1, 1, Color.GRAY);
          }
        }
        cellPane.setBorder(border);
        add(cellPane, gbc);
      }
    }
  }

  @Override
  public void actionPerformed(final ActionEvent e) {
    if (e.getSource() == timer) {
      removeAll();
      paint();
      revalidate();
      repaint();
    }
  }
}

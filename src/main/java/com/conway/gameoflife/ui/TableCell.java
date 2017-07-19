package com.conway.gameoflife.ui;

import java.awt.*;
import javax.swing.*;

import com.conway.gameoflife.dto.CellDTO;

import static java.awt.Color.BLACK;
import static java.awt.Color.WHITE;

public class TableCell extends JPanel {

  public TableCell(CellDTO cell) {
    setBackground(cell.isAlive() ? BLACK : WHITE);
  }

  @Override
  public Dimension getPreferredSize() {
    return new Dimension(50, 50);
  }
}

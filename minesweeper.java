import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import tester.*;
import javalib.impworld.*;
import javalib.worldcanvas.WorldCanvas;

import java.awt.Color;
import javalib.worldimages.*;

//represents the cells on the grid
class Cells {
  boolean mines;
  ArrayList<Cells> neighbors;
  boolean rightClick;
  boolean leftClick;

  Cells(ArrayList<Cells> neighbors) {
    this.mines = false;
    this.neighbors = new ArrayList<Cells>();
    this.rightClick = false;
    this.leftClick = false;
  }

  // counts how many mines are around it
  public int countMines() {
    int numOfMines = 0;
    for (int i = 0; i < neighbors.size(); i++) {
      if (this.neighbors.get(i).mines) {
        numOfMines = numOfMines + 1;
      }
    }
    return numOfMines;
  }

  // ITS DA BOMB
  // ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡀⠀⠀⠀⠀⠀⠀
  // ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡇⠀⠀⠀⠀⠀⠀
  // ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠤⣀⠀⢠⡀⣿⣰⢀⣠⠴⠋⠀
  // ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⣀⣀⣙⣳⣿⣿⣿⣿⣅⣀⡀⠀
  // ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡀⢠⣄⣤⣄⣠⣶⣿⡭⣙⣷⣿⣿⣿⣯⡉⠉⠁
  // ⠀⠀⠀⠀⢀⣤⡶⠚⣿⣿⢡⣷⡻⣿⡺⡿⣻⣄⠀⣰⠟⢹⡟⣿⠀⠉⠀⠀
  // ⠀⠀⢀⡴⠛⠙⣶⣾⣿⣿⡘⢿⣿⣷⣯⣟⣛⡟⠰⠁⠀⢸⡇⠘⡆⠀⠀⠀
  // ⠀⢠⠏⠀⠀⣰⣿⣿⣿⣿⣿⣶⣍⣛⠻⠿⠟⣼⡆⠀⠀⢸⠃⠀⠀⠀⠀⠀
  // ⠀⣿⣤⣤⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡀⠀⠘⠂⠀⠀⠀⠀⠀
  // ⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀
  // ⠘⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠇⠀⠀⠀⠀⠀⠀⠀⠀
  // ⠀⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠀⠀⠀⠀⠀⠀⠀⠀⠀
  // ⠀⠀⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡟⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀
  // ⠀⠀⠀⠈⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
  // ⠀⠀⠀⠀⠀⠀⠉⠙⠛⠛⠛⠛⠛⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
  // ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠠⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀

  // draws the cells, numbers and mines
  public WorldImage draw() {
    // normal cell, and shaded cell for 0 neighboring mines
    RectangleImage cell = new RectangleImage(30, 30, OutlineMode.OUTLINE, Color.BLACK);
    RectangleImage blankCell = new RectangleImage(30, 30, OutlineMode.SOLID, Color.GRAY);
    // mine and flag shapes
    CircleImage mine = new CircleImage(7, OutlineMode.SOLID, Color.RED);
    EquilateralTriangleImage flag = new EquilateralTriangleImage(15, OutlineMode.SOLID,
        Color.ORANGE);
    String mineNum = Integer.toString(this.countMines());
    // different colors for different numbers !!! :D
    TextImage one = new TextImage(mineNum, 15, Color.BLUE);
    TextImage two = new TextImage(mineNum, 15, Color.GREEN);
    TextImage three = new TextImage(mineNum, 15, Color.RED);
    TextImage four = new TextImage(mineNum, 15, Color.BLUE.darker());
    TextImage five = new TextImage(mineNum, 15, Color.RED.darker());
    TextImage six = new TextImage(mineNum, 15, Color.CYAN);
    TextImage seven = new TextImage(mineNum, 15, Color.BLACK);
    TextImage eight = new TextImage(mineNum, 15, Color.GRAY);
    // if the cell is a mine...
    if (mines) {
      // if right-clicked, place a flag
      if (rightClick) {
        return new OverlayImage(flag, cell);
      }
      // if left-clicked, display the mine
      else if (leftClick) {
        return new OverlayImage(mine, cell);
      }
      // otherwise, if no clicks, draw a cell
      else {
        return cell;
      }
    }
    // if the cell is not a mine...
    else {
      // if right-clicked, place a flag
      if (rightClick) {
        return new OverlayImage(flag, cell);
      }
      // if left-clicked, displace the number of mines in the neighbor-list on the
      // cell
      else if (leftClick) {
        if (this.countMines() == 1) {
          return new OverlayImage(one, cell);
        }
        if (this.countMines() == 2) {
          return new OverlayImage(two, cell);
        }
        if (this.countMines() == 3) {
          return new OverlayImage(three, cell);
        }
        if (this.countMines() == 4) {
          return new OverlayImage(four, cell);
        }
        if (this.countMines() == 5) {
          return new OverlayImage(five, cell);
        }
        if (this.countMines() == 6) {
          return new OverlayImage(six, cell);
        }
        if (this.countMines() == 7) {
          return new OverlayImage(seven, cell);
        }
        if (this.countMines() == 8) {
          return new OverlayImage(eight, cell);
        }
        // if there are no mines around, darken the cell
        else {
          return new OverlayImage(cell, blankCell);
        }
      }
      // otherwise, if no clicks, draw a cell
      else {
        return cell;
      }
    }
  }

  // floods the cells around adjacent mines if their
  // count is 0 as well
  void flood() {
    this.leftClick = true;
    if (this.countMines() == 0) {
      for (Cells n : neighbors) {
        if (n.countMines() > 0 && !this.mines) {
          n.clickCell();
        }
        if (!n.leftClick && n.countMines() == 0) {
          n.clickCell();
          n.flood();
        }
      }
    }
  }

  // makes a given cell a neighbor of this cell
  public void makeNeighbor(Cells c) {
    this.neighbors.add(c);
  }

  // checks if there is a flag clicked
  public void clickFlag() {
    if (!this.rightClick) {
      this.rightClick = true;
    }
    else {
      this.rightClick = false;
    }
  }

  // checks if you clicked a cell
  public void clickCell() {
    this.leftClick = true;
  }

  // checks if you clicked a cell
  public boolean hasFlag() {
    return this.rightClick;
  }

  // checked if something is left clicked
  public boolean isClicked() {
    return this.leftClick;
  }
}

// represents a Utils class
class Utils {
  Random rand;

  Utils(Random rand) {
    this.rand = rand;
  }

  Utils() {
    this.rand = new Random();
  }

  // randomizes the mines
  int mineRand(int min) {
    return this.rand.nextInt(min);
  }
}

//represents a world class to animate a list of words on a scene
class MineWorld extends World {
  int rows;
  int columns;
  int mines;
  Utils util;
  Random rand;
  ArrayList<ArrayList<Cells>> board;
  String buttonName;
  boolean gameLose;
  boolean gameWin;
  int sec;
  int mili;
  int min;
  int doubleNum;
  int countFlag;

  MineWorld(int rows, int columns, int mines) {
    this.rows = rows;
    this.columns = columns;
    this.mines = mines;
    this.countFlag = mines;
    this.util = new Utils();
    this.rand = new Random();
    this.makeBoard();
    this.linkNeighbors();
    this.randMines();
    this.gameLose = false;
    this.gameWin = false;
    this.sec = 0;
    this.mili = 0;
    this.min = 0;
    this.doubleNum = 0;
  }

  MineWorld(int rows, int columns, int mines, Random rand) {
    this.rows = rows;
    this.columns = columns;
    this.mines = mines;
    this.countFlag = mines;
    this.rand = rand;
    this.util = new Utils(rand);
    this.makeBoard();
    this.linkNeighbors();
    this.randMines();
    this.gameLose = false;
    this.gameWin = false;
    this.sec = 0;
    this.mili = 0;
    this.min = 0;
    this.doubleNum = 0;
  }

  // creates the grid and cells
  public WorldScene makeScene() {
    WorldScene newWorld = new WorldScene(rows * 30, columns * 30);
    TextImage flag = new TextImage("⚐", 30, Color.RED);
    String flagNum = Integer.toString(this.countFlag);
    TextImage num = new TextImage(flagNum, 15, Color.BLACK);
    String semi = ":";
    String secNum = Integer.toString(this.sec);
    String miliNum = Integer.toString(this.mili);
    String minNum = Integer.toString(this.min);
    String doubleNum = Integer.toString(this.doubleNum);
    TextImage time = new TextImage("「" + doubleNum + minNum + semi + secNum + miliNum + "」", 25,
        Color.RED);
    BesideImage flags = new BesideImage(flag, num);
    TextImage restart = new TextImage("Press r to restart", 15, Color.MAGENTA);

    int width = board.size();
    int height = board.get(1).size();
    // place the time, flag count, and restart text on the bottom of the screen
    newWorld.placeImageXY(time, columns * 15 - 1, (rows * 30) + 15);
    newWorld.placeImageXY(flags, columns + 10, (rows * 30) + 15);
    newWorld.placeImageXY(restart, columns * 15 - 1, (rows * 30) + 40);

    // if the game is not won or lost yet, draw the board normally
    if (!gameLose && !gameWin) {
      for (int row = 0; row < rows; row++) {
        for (int col = 0; col < columns; col++) {
          newWorld.placeImageXY(this.board.get(row).get(col).draw(), col * 30 + 15, row * 30 + 15);
        }
      }
      return newWorld;
    }
    // if the game is won, return a win message ! woohoo
    else if (gameWin) {
      this.reveal();
      for (int row = 0; row < rows; row++) {
        for (int col = 0; col < columns; col++) {
          newWorld.placeImageXY(this.board.get(row).get(col).draw(), col * 30 + 15, row * 30 + 15);
        }
      }
      TextImage gameOver = new TextImage("You Win :)", board.size() * 4.2, FontStyle.BOLD,
          Color.BLUE);
      newWorld.placeImageXY(gameOver, width * 15, height * 15);
      return newWorld;
    }
    // else, if the game is lost, return a lost message ! :(
    else {
      this.reveal();
      for (int row = 0; row < rows; row++) {
        for (int col = 0; col < columns; col++) {
          newWorld.placeImageXY(this.board.get(row).get(col).draw(), col * 30 + 15, row * 30 + 15);
        }
      }
      TextImage gameOver = new TextImage("You Lose :(", board.size() * 4.2, FontStyle.BOLD,
          Color.BLUE);
      newWorld.placeImageXY(gameOver, width * 15, height * 15);
      return newWorld;
    }
  }

  // makes the board
  public void makeBoard() {
    ArrayList<ArrayList<Cells>> board = new ArrayList<ArrayList<Cells>>();
    for (int row = 0; row < rows; row++) {
      ArrayList<Cells> thisRow = new ArrayList<Cells>();
      for (int col = 0; col < columns; col++) {
        thisRow.add(new Cells(new ArrayList<Cells>()));
      }
      board.add(thisRow);
    }
    this.board = board;
  }

  // randomizes the mines
  public void randMines() {
    int numofmine = this.mines;
    while (numofmine > 0) {
      int pickrow = util.mineRand(this.rows);
      int pickcell = util.mineRand(this.columns);
      if (!this.board.get(pickrow).get(pickcell).mines) {
        this.board.get(pickrow).get(pickcell).mines = true;
        numofmine = numofmine - 1;
      }
    }
  }

  // the right and left click implementation
  public void onMouseClicked(Posn pos, String buttonName) {
    int cellWidth = 30;
    int cellHeight = 30;
    int c = Math.floorDiv(pos.x, cellWidth);
    int r = Math.floorDiv(pos.y, cellHeight);
    Posn cellCoor = new Posn(c * cellWidth, r * cellHeight);
    int cellRight = cellCoor.x + cellWidth;
    int cellBottom = cellCoor.y + cellHeight;

    // if out of bounds, nothing happens (game does NOT crash)
    if ((r > rows - 1 || c > columns - 1)) {
      return;
    }
    // if right-clicked...
    if (pos.x >= cellCoor.x && pos.x < cellRight && pos.y >= cellCoor.y && pos.y < cellBottom
        && buttonName.equals("RightButton") && !gameLose && !gameWin) {
      board.get(r).get(c).clickFlag();
      // ...adds a flag and decreases flag count
      if (board.get(r).get(c).hasFlag()) {
        this.countFlag -= 1;
      }
      // ...removes a flag and increases flag count
      else if (!board.get(r).get(c).hasFlag()) {
        this.countFlag += 1;
      }
    }
    // if left-clicked on NOT a mine...
    else if (pos.x >= cellCoor.x && pos.x < cellRight && pos.y >= cellCoor.y && pos.y < cellBottom
        && buttonName.equals("LeftButton") && !board.get(r).get(c).rightClick && !gameLose
        && !gameWin) {
      // floods cells, puts numbers or shades
      board.get(r).get(c).flood();
      // checks if the game is won
      this.checkWin();
    }
    // if left-clicked on a mine...
    if ((pos.x >= cellCoor.x && pos.x < cellRight && pos.y >= cellCoor.y && pos.y < cellBottom
        && buttonName.equals("LeftButton")) && board.get(r).get(c).mines
        && !board.get(r).get(c).rightClick && !gameLose && !gameWin) {
      // reveals board and sets the game to lose
      this.reveal();
      this.gameLose = true;
    }

  }

  // controls the clock in my world
  public void onTick() {
    if (!gameLose && !gameWin) {
      this.mili += 1;
      if (this.mili % 10 == 0) {
        this.mili = 0;
        this.sec += 1;
      }
      if (this.sec % 6 == 0 && this.mili % 10 == 0) {
        this.sec = 0;
        this.min += 1;
      }
      if (this.sec % 6 == 0 && this.mili % 10 == 0 && this.min % 10 == 0) {
        this.min = 0;
        this.doubleNum += 1;
      }
    }
  }

  // reveals the mines if clicked
  public void reveal() {
    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < columns; c++) {
        board.get(r).get(c).flood();
      }
    }
  }

  // method to restart the game
  void restart() {
    this.countFlag = mines;
    this.util = new Utils(rand);
    this.makeBoard();
    this.linkNeighbors();
    this.randMines();
    this.gameLose = false;
    this.gameWin = false;
    this.sec = 0;
    this.mili = 0;
    this.min = 0;
    this.doubleNum = 0;
  }

  // key click to restart the game
  public void onKeyEvent(String key) {
    if (key.equals("r")) {
      this.restart();
    }
  }

  // checking winning conditions
  public void checkWin() {
    if ((rows * columns != mines)) {
      int winclicks = (rows * columns) - mines;
      int clicks = 0;
      for (int row = 0; row < rows; row++) {
        for (int col = 0; col < columns; col++) {
          Cells cell = this.board.get(row).get(col);
          if (!cell.mines) {
            if (cell.leftClick) {
              clicks = clicks + 1;
            }
          }
        }
      }
      if (clicks == winclicks) {
        this.gameWin = true;
      }
    }
  }

  // links the cell neighbors together
  public void linkNeighbors() {
    // linking neighbor lists
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < columns; col++) {
        Cells cell = board.get(row).get(col);
        // top row
        if (row > 0) {
          cell.makeNeighbor(board.get(row - 1).get(col));
        }
        // leftmost column
        if (col > 0) {
          cell.makeNeighbor(board.get(row).get(col - 1));
        }
        // bottom row
        if (row < rows - 1) {
          cell.makeNeighbor(board.get(row + 1).get(col));
        }
        // rightmost column
        if (col < columns - 1) {
          cell.makeNeighbor(board.get(row).get(col + 1));
        }
        // bottom left
        if (row > 0 && col > 0) {
          cell.makeNeighbor(board.get(row - 1).get(col - 1));
        }
        // top left
        if (row > 0 && col < columns - 1) {
          cell.makeNeighbor(board.get(row - 1).get(col + 1));
        }
        // top right
        if (row < rows - 1 && col > 0) {
          cell.makeNeighbor(board.get(row + 1).get(col - 1));
        }
        // bottom right
        if (row < rows - 1 && col < columns - 1) {
          cell.makeNeighbor(board.get(row + 1).get(col + 1));
        }
      }
    }
  }
}
//⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⡤⢦⣤⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
//⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣼⢫⠁⡞⡗⡟⢩⣿⣿⣦⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
//⠀⠀⠀⠀⠀⠀⠀⢀⠴⡶⡻⢋⣑⣿⠟⠋⣉⢻⢿⣿⡻⡿⣳⣄⡀⠀⠀⠀⠀⠀⠀⠀
//⠀⠀⠀⠀⠀⡴⠚⣉⡾⠷⠛⡟⠁⠐⠀⣀⠀⡾⡋⡘⢿⣷⣾⢿⣿⣶⣆⡀⠀⠀⠀⠀
//⠀⠀⠀⢠⢶⣎⠉⡽⠁⢬⡸⣷⢰⠴⠀⠀⢉⣼⠒⣳⢺⣷⡜⠛⢻⣿⣿⣶⡄⠀⠀⠀
//⠀⠀⠀⢐⣫⣇⡤⡟⠰⣏⠀⡹⢿⡀⣂⣶⠚⠿⣿⣿⣽⠿⢃⠆⣿⣿⣿⣿⡅⠀⠀⠀
//⠀⠀⠰⡿⠋⣀⠙⣿⣷⣿⣾⣾⣻⣿⣿⣿⣶⣾⣿⣿⣿⣷⣷⣿⣿⣿⣿⣿⡟⠁⠀⠀
//⠀⠀⠀⢱⣈⣿⣶⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠇⠀⠀⠀
//⠀⠀⠀⠀⠙⠛⠛⢿⣿⡿⠿⠿⠿⣛⣤⣏⣿⣿⢿⣿⣿⡿⢟⠋⠉⠉⠀⠀⠀⠀⠀⠀
//⠀⠐⠋⠛⠂⠀⠀⠀⠀⠀⠂⠘⠋⡙⡿⣿⣿⣿⡖⣂⡀⠀⠀⠀⠀⠀⠀⠈⠉⠀⠂⠀
//⠀⠀⠀⠀⠀⠀⠒⠄⠀⠀⠀⠀⣩⣼⢷⡷⣿⣿⢐⠀⠀⠀⠀⠀⠀⠶⠆⠀⠀⠀⠀⠀
//⠀⠀⠀⠀⣤⣤⣤⠀⠀⠀⠀⠀⢲⣾⣷⣻⢿⣿⣾⣧⠠⠤⠄⢀⣀⣠⣤⣤⣄⣀⠀⠀
//⠀⠀⠀⠀⠀⠀⠀⡀⠀⢸⡄⣴⣋⣿⣼⣽⣿⣷⣿⣿⣤⣰⣰⣀⡆⠀⠀⠀⠀⠀⠀⠀
//⣤⣤⣤⣤⣤⡤⢤⢿⣿⣟⣛⡛⢻⠻⠿⠿⠿⠿⠿⠿⣿⡿⣿⣼⣿⣤⣤⣤⣤⣤⣤⡄
//⠀⠚⠛⢛⣛⣿⣿⣿⣿⣿⣿⣯⣭⣀⣠⣤⣤⣵⣶⣶⣷⣾⣿⣿⣾⣿⡟⠛⠋⠗⠂⠀

// examples class
class ExamplesMine {
  Cells c1;
  Cells c2;
  Cells c3;
  Cells c4;
  Cells c5;
  Cells c6;
  Cells c7;
  Cells c8;
  Cells c9;
  Cells c11;
  Cells c12;
  Cells c13;
  Cells c14;

  ArrayList<Cells> a1;
  ArrayList<Cells> a2;
  ArrayList<Cells> a3;
  ArrayList<Cells> a4;
  ArrayList<Cells> a5;
  ArrayList<Cells> a6;
  ArrayList<Cells> a7;
  ArrayList<Cells> a8;

  WorldScene scene1;
  WorldCanvas canvas1;
  WorldScene scene2;
  WorldScene scene3;
  WorldScene scene4;

  ArrayList<ArrayList<Cells>> n1;
  ArrayList<ArrayList<Cells>> n2;
  ArrayList<ArrayList<Cells>> n3;
  ArrayList<ArrayList<Cells>> n4;
  ArrayList<ArrayList<Cells>> n5;
  ArrayList<ArrayList<Cells>> n6;

  MineWorld board1;
  MineWorld board2;
  MineWorld board3;
  MineWorld board4;
  MineWorld board5;
  MineWorld board6;
  MineWorld board7;
  MineWorld board8;

  CircleImage circle1;
  TextImage clock;

  Random random1;
  Utils util1;

  Random random2;
  Utils util2;

  TextImage t1;
  TextImage flagEmoji;

  EquilateralTriangleImage flag;

  RectangleImage r1;
  RectangleImage blankCell;

  OverlayImage cellFlag;
  OverlayImage cellMine;
  OverlayImage cellNum;

  String flagNum;
  TextImage num1;
  TextImage num2;
  TextImage num3;
  TextImage flag3;
  TextImage flag2;

  TextImage win;
  TextImage lose;

  BesideImage flags;
  TextImage restart;

  void initData() {
    c1 = new Cells(new ArrayList<Cells>());
    c2 = new Cells(new ArrayList<Cells>());
    c3 = new Cells(new ArrayList<Cells>());
    c4 = new Cells(new ArrayList<Cells>());
    c5 = new Cells(new ArrayList<Cells>());
    c6 = new Cells(new ArrayList<Cells>());
    c7 = new Cells(new ArrayList<Cells>());
    c8 = new Cells(new ArrayList<Cells>());
    c9 = new Cells(new ArrayList<Cells>());
    c11 = new Cells(new ArrayList<Cells>(Arrays.asList(c12, c13, c14)));
    c12 = new Cells(new ArrayList<Cells>(Arrays.asList(c11, c13, c14)));
    c13 = new Cells(new ArrayList<Cells>(Arrays.asList(c11, c12, c14)));
    c14 = new Cells(new ArrayList<Cells>(Arrays.asList(c11, c12, c13)));

    a1 = new ArrayList<Cells>(Arrays.asList(c1, c2));
    a2 = new ArrayList<Cells>(Arrays.asList(c1, c2, c3));
    a3 = new ArrayList<Cells>(Arrays.asList(c2, c4, c5, c6));
    a4 = new ArrayList<Cells>(Arrays.asList(c1, c2, c3, c4, c5));
    a5 = new ArrayList<Cells>(Arrays.asList(c1, c2, c3, c4));
    a6 = new ArrayList<Cells>(Arrays.asList(c4, c7));
    a7 = new ArrayList<Cells>(Arrays.asList(c11, c12));
    a8 = new ArrayList<Cells>(Arrays.asList(c13, c14));

    n1 = new ArrayList<ArrayList<Cells>>(Arrays.asList(a1));
    n2 = new ArrayList<ArrayList<Cells>>(Arrays.asList(a2));
    n3 = new ArrayList<ArrayList<Cells>>(Arrays.asList(a3));
    n4 = new ArrayList<ArrayList<Cells>>(Arrays.asList(a4, a4, a4, a4, a4));
    n5 = new ArrayList<ArrayList<Cells>>(Arrays.asList(a1, a6));
    n6 = new ArrayList<ArrayList<Cells>>(Arrays.asList(a7, a8));

    r1 = new RectangleImage(30, 30, OutlineMode.OUTLINE, Color.BLACK);
    circle1 = new CircleImage(7, OutlineMode.SOLID, Color.RED);

    flagEmoji = new TextImage("⚐", 30, Color.RED);
    num1 = new TextImage("1", 15, Color.BLUE);
    num2 = new TextImage("2", 15, Color.GREEN);
    num3 = new TextImage("3", 15, Color.RED);
    flag3 = new TextImage("3", 15, Color.BLACK);
    flag2 = new TextImage("2", 15, Color.BLACK);

    blankCell = new RectangleImage(30, 30, OutlineMode.SOLID, Color.GRAY);

    restart = new TextImage("Press r to restart", 15, Color.MAGENTA);
    win = new TextImage("You Win :)", 12.600000000000001, FontStyle.BOLD, Color.BLUE);
    lose = new TextImage("You Lose :(", 12.600000000000001, FontStyle.BOLD, Color.BLUE);
    clock = new TextImage("「00:00」", 25, Color.red);
    board1 = new MineWorld(16, 30, 99);
    board2 = new MineWorld(4, 4, 4);
    board3 = new MineWorld(4, 4, 4, new Random(15));
    board4 = new MineWorld(5, 5, 4, new Random(20));
    board5 = new MineWorld(2, 2, 1, new Random(15));
    board6 = new MineWorld(2, 2, 2, new Random(15));
    board7 = new MineWorld(3, 3, 3, new Random(15));
    board8 = new MineWorld(3, 3, 3, new Random(15));

    board6.board.get(0).get(1).rightClick = true;
    board6.board.get(1).get(0).leftClick = true;

    board7.gameLose = true;
    board7.board.get(0).get(1).rightClick = true;
    board7.board.get(1).get(0).leftClick = true;

    board8.gameWin = true;
    board8.board.get(0).get(1).rightClick = true;
    board8.board.get(1).get(0).leftClick = true;

    flag = new EquilateralTriangleImage(15, OutlineMode.SOLID, Color.ORANGE);
    t1 = new TextImage("2", 15, Color.BLACK);
    scene1 = new WorldScene(60, 60);
    scene1.placeImageXY(clock, 29, 75);
    scene1.placeImageXY(new BesideImage(flagEmoji, num1), 12, 75);
    scene1.placeImageXY(restart, 29, 100);
    scene1.placeImageXY(r1, 15, 15);
    scene1.placeImageXY(r1, 45, 15);
    scene1.placeImageXY(r1, 15, 45);
    scene1.placeImageXY(r1, 45, 45);

    scene2 = new WorldScene(60, 60);
    scene2.placeImageXY(clock, 29, 75);
    scene2.placeImageXY(new BesideImage(flagEmoji, flag2), 12, 75);
    scene2.placeImageXY(restart, 44, 130);
    scene2.placeImageXY(r1, 15, 15);
    scene2.placeImageXY(new OverlayImage(flag, r1), 45, 15);
    scene2.placeImageXY(new OverlayImage(num2, r1), 15, 45);
    scene2.placeImageXY(r1, 45, 45);

    // lose
    scene3 = new WorldScene(90, 90);
    scene3.placeImageXY(clock, 44, 105);
    scene3.placeImageXY(new BesideImage(flagEmoji, flag3), 13, 105);
    scene3.placeImageXY(restart, 44, 130);
    scene3.placeImageXY(new OverlayImage(num1, r1), 15, 15);
    scene3.placeImageXY(new OverlayImage(flag, r1), 45, 15);
    scene3.placeImageXY(new OverlayImage(circle1, r1), 75, 15);
    scene3.placeImageXY(new OverlayImage(circle1, r1), 15, 45);
    scene3.placeImageXY(new OverlayImage(num3, r1), 45, 45);
    scene3.placeImageXY(new OverlayImage(circle1, r1), 75, 45);
    scene3.placeImageXY(new OverlayImage(num1, r1), 15, 75);
    scene3.placeImageXY(new OverlayImage(num2, r1), 45, 75);
    scene3.placeImageXY(new OverlayImage(num1, r1), 75, 75);
    scene3.placeImageXY(lose, 45, 45);

    // win
    scene4 = new WorldScene(90, 90);
    scene4.placeImageXY(clock, 44, 105);
    scene4.placeImageXY(new BesideImage(flagEmoji, flag3), 13, 105);
    scene4.placeImageXY(restart, 44, 130);
    scene4.placeImageXY(new OverlayImage(num1, r1), 15, 15);
    scene4.placeImageXY(new OverlayImage(flag, r1), 45, 15);
    scene4.placeImageXY(new OverlayImage(circle1, r1), 75, 15);
    scene4.placeImageXY(new OverlayImage(circle1, r1), 15, 45);
    scene4.placeImageXY(new OverlayImage(num3, r1), 45, 45);
    scene4.placeImageXY(new OverlayImage(circle1, r1), 75, 45);
    scene4.placeImageXY(new OverlayImage(num1, r1), 15, 75);
    scene4.placeImageXY(new OverlayImage(num2, r1), 45, 75);
    scene4.placeImageXY(new OverlayImage(num1, r1), 75, 75);
    scene4.placeImageXY(win, 45, 45);

    random1 = new Random(5);
    util1 = new Utils(this.random1);

    random2 = new Random(10);
    util2 = new Utils(this.random2);

    cellFlag = new OverlayImage(flag, r1);
    cellMine = new OverlayImage(circle1, r1);
    cellNum = new OverlayImage(num3, r1);

  }

  // tests makeNeighbor
  void testmakeNeighbor(Tester t) {
    initData();
    t.checkExpect(this.c1.neighbors, new ArrayList<Cells>());
    this.c1.makeNeighbor(c2);
    t.checkExpect(this.c1.neighbors, new ArrayList<Cells>(Arrays.asList(c2)));
    t.checkExpect(this.c2.neighbors, new ArrayList<Cells>());
    this.c2.makeNeighbor(c1);
    this.c2.makeNeighbor(c3);
    t.checkExpect(this.c2.neighbors, new ArrayList<Cells>(Arrays.asList(c1, c3)));
  }

  // test linkNeighbors
  // tests how many neighbors surround it
  void testlinkNeighbors(Tester t) {
    initData();
    t.checkExpect(this.board2.board.get(0).get(0).neighbors.size(), 3);
    t.checkExpect(this.board2.board.get(1).get(0).neighbors.size(), 5);
    t.checkExpect(this.board2.board.get(0).get(1).neighbors.size(), 5);
    t.checkExpect(this.board2.board.get(1).get(1).neighbors.size(), 8);
  }

  // tests makeBoard
  void testmakeBoard(Tester t) {
    initData();
    board5.makeBoard();
    t.checkExpect(this.board5.board, n5);
    board4.makeBoard();
    t.checkExpect(this.board4.board, n4);
    board6.makeBoard();
    t.checkExpect(this.board6.board, n6);
  }

  // tests makeMines
  void testrandMines(Tester t) {
    initData();
    t.checkExpect(this.board5.mines, 1);
    this.board5.randMines();
    t.checkExpect(this.board5.mines, 1);
    t.checkExpect(this.board2.mines, 4);
    this.board2.randMines();
    t.checkExpect(this.board2.mines, 4);
    t.checkExpect(this.board4.mines, 4);
    this.board4.randMines();
    t.checkExpect(this.board4.mines, 4);

  }

  // test makeScene
  void testMakeScene(Tester t) {
    initData();
    t.checkExpect(this.board5.makeScene(), scene1);
    // intermediate board
    t.checkExpect(this.board6.makeScene(), scene2);
    // win
    t.checkExpect(this.board7.makeScene(), scene3);
    // lose
    t.checkExpect(this.board8.makeScene(), scene4);
  }

  // tests mineRand
  boolean testmineRand(Tester t) {
    initData();
    return t.checkExpect(this.util1.mineRand(1), 0) && t.checkExpect(this.util2.mineRand(3), 0);
  }

  // tests countMines
  void testcountMines(Tester t) {
    initData();
    t.checkExpect(this.c1.countMines(), 0);
    this.c1.neighbors = new ArrayList<Cells>(Arrays.asList(c2, c3));
    this.c2.mines = true;
    this.c3.mines = true;
    t.checkExpect(this.c1.countMines(), 2);
  }

  // test draw
  boolean testdraw(Tester t) {
    initData();
    this.c2.rightClick = true;
    this.c2.hasFlag();
    this.c3.leftClick = true;
    this.c3.isClicked();
    this.c4.leftClick = true;
    this.c4.mines = true;
    this.c5.leftClick = true;
    this.c5.isClicked();

    this.c11.neighbors = new ArrayList<Cells>(Arrays.asList(c12, c13, c14));
    this.c12.leftClick = true;
    this.c12.mines = true;
    this.c13.mines = true;
    this.c14.mines = true;
    this.c11.leftClick = true;
    this.c11.countMines();
    this.c11.isClicked();

    // blank cell
    return t.checkExpect(this.c1.draw(), r1)
        // flag cell
        && t.checkExpect(this.c2.draw(), cellFlag)
        // flooded cell
        && t.checkExpect(this.c3.draw(), new OverlayImage(r1, blankCell))
        // cell w mine
        && t.checkExpect(this.c4.draw(), cellMine)
        // cell w number
        && t.checkExpect(this.c11.draw(), cellNum);

  }

  // tests isClicked
  boolean testisClicked(Tester t) {
    initData();
    this.c1.leftClick = true;
    return t.checkExpect(this.c1.isClicked(), true) && t.checkExpect(this.c5.isClicked(), false);
  }

  // tests hasFlag
  boolean testhasFlag(Tester t) {
    initData();
    this.c12.rightClick = true;
    return t.checkExpect(this.c12.hasFlag(), true) && t.checkExpect(this.c1.hasFlag(), false);
  }

  // tests clickCell
  void testclickCell(Tester t) {
    initData();
    t.checkExpect(this.c1.leftClick, false);
    this.c1.clickCell();
    t.checkExpect(this.c1.leftClick, true);

    t.checkExpect(this.c11.leftClick, false);
    this.c11.clickCell();
    t.checkExpect(this.c11.leftClick, true);

  }

  // tests clickFlag
  void testclickFlag(Tester t) {
    initData();
    t.checkExpect(this.c1.rightClick, false);
    this.c1.clickFlag();
    t.checkExpect(this.c1.rightClick, true);

    t.checkExpect(this.c1.rightClick, true);
    this.c1.clickFlag();
    t.checkExpect(this.c1.rightClick, false);

    t.checkExpect(this.c11.rightClick, false);
    this.c11.clickFlag();
    t.checkExpect(this.c11.rightClick, true);
    t.checkExpect(this.c11.rightClick, true);
    this.c11.clickFlag();
    t.checkExpect(this.c11.rightClick, false);
  }

  // tests flood
  void testflood(Tester t) {
    initData();
    t.checkExpect(this.c1.leftClick, false);
    this.c1.flood();
    t.checkExpect(this.c1.leftClick, true);

    // case where all the neighbors are left clicked already
    this.c12.leftClick = true;
    this.c12.mines = false;
    this.c13.leftClick = true;
    this.c13.mines = false;
    this.c14.leftClick = true;
    this.c14.mines = false;
    t.checkExpect(this.c11.leftClick, false);
    this.c11.leftClick = true;
    this.c11.flood();
    t.checkExpect(this.c11.leftClick, true);

    // case where there is a mine
    initData();
    this.c12.mines = true;
    this.c13.mines = false;
    this.c14.mines = false;
    t.checkExpect(this.c11.leftClick, false);
    this.c11.flood();
    t.checkExpect(this.c11.leftClick, true);
    t.checkExpect(this.c12.leftClick, false);
  }

  // test on tick
  void testOnTick(Tester t) {
    initData();
    board6.onTick();
    board6.gameLose = true;
    t.checkExpect(board6.sec, 0);
    board6.gameLose = false;
    board6.sec = 3;
    t.checkExpect(board6.sec, 3);
    board6.gameLose = true;
    t.checkExpect(board6.sec, 3);
  }

  // test checkWin
  void testcheckWin(Tester t) {
    initData();
    board6.checkWin();
    t.checkExpect(board6.gameWin, false);
    board6.mines = 4;
    board6.checkWin();
    t.checkExpect(board6.gameWin, false);
    board6.mines = 0;
    board6.board.get(0).get(0).mines = false;
    board6.board.get(1).get(0).mines = false;
    board6.board.get(0).get(1).mines = false;
    board6.board.get(1).get(1).mines = false;
    board6.board.get(0).get(0).leftClick = true;
    board6.board.get(1).get(0).leftClick = true;
    board6.board.get(0).get(1).leftClick = true;
    board6.board.get(1).get(1).leftClick = true;
    board6.checkWin();
    t.checkExpect(board6.gameWin, true);
  }

  // test reveal
  void testReveal(Tester t) {
    initData();
    board6.board.get(0).get(0).leftClick = false;
    board6.board.get(1).get(0).leftClick = false;
    board6.board.get(0).get(1).leftClick = false;
    board6.board.get(1).get(1).leftClick = false;
    board6.reveal();
    t.checkExpect(board6.board.get(0).get(0).leftClick, true);
    t.checkExpect(board6.board.get(1).get(0).leftClick, true);
    t.checkExpect(board6.board.get(0).get(1).leftClick, true);
    t.checkExpect(board6.board.get(1).get(1).leftClick, true);
  }

  // tests Restart and on key event at the same time
  void testRestart(Tester t) {
    initData();
    ArrayList<Cells> row = board2.board.get(1);
    t.checkExpect(board2.board.get(1), row);
    board2.onKeyEvent("r");
    t.checkExpect((board2.board.get(1) == row), false);
    row = board1.board.get(3);
    t.checkExpect(board1.board.get(3), row);
    board1.onKeyEvent("r");
    t.checkExpect((board1.board.get(3) == row), false);
  }

  // tests onMouseClicked
  void testOnMouseClicked(Tester t) {
    initData();
    board2.board.get(0).get(0).rightClick = false;
    board2.board.get(0).get(0).leftClick = false;

    // test to check if cells are flagged and unflagged
    t.checkExpect(board2.board.get(0).get(0).hasFlag(), false);
    t.checkExpect(board2.board.get(0).get(0).isClicked(), false);
    this.board2.onMouseClicked(new Posn(15, 15), "RightButton");
    t.checkExpect(board2.board.get(0).get(0).hasFlag(), true);
    t.checkExpect(board2.board.get(0).get(0).isClicked(), false);
    this.board2.onMouseClicked(new Posn(15, 15), "RightButton");
    t.checkExpect(board2.board.get(0).get(0).hasFlag(), false);
    t.checkExpect(board2.board.get(0).get(0).isClicked(), false);

    board2.board.get(1).get(1).rightClick = false;
    board2.board.get(1).get(1).leftClick = false;

    // test to check if cells are revealed
    t.checkExpect(board2.board.get(1).get(1).hasFlag(), false);
    t.checkExpect(board2.board.get(1).get(1).isClicked(), false);
    this.board2.onMouseClicked(new Posn(30, 30), "LeftButton");
    t.checkExpect(board2.board.get(1).get(1).hasFlag(), false);
    t.checkExpect(board2.board.get(1).get(1).isClicked(), true);

    board2.board.get(1).get(0).rightClick = false;
    board2.board.get(1).get(0).leftClick = false;
    board2.board.get(1).get(0).mines = true;

    // checks to ensure game ends if a mine is clicked
    t.checkExpect(board2.board.get(1).get(0).hasFlag(), false);
    t.checkExpect(board2.board.get(1).get(0).isClicked(), false);
    this.board2.onMouseClicked(new Posn(15, 30), "LeftButton");
    t.checkExpect(board2.board.get(1).get(0).isClicked(), true);
    t.checkExpect(board2.gameLose, true);

    // checks out of bounds, ensures no crash
    this.board2.onMouseClicked(new Posn(300, 300), "LeftButton");
    t.checkExpect(board2, board2);
  }

  // big bang
  void testBigBang(Tester t) {
    initData();
    // You can see part of the clock and restart text on a 2x2
    // but it's clearer on a 4x4, 5x5 or bigger
    // anything else is either cut off or on top of the flag image but it still
    // works
    MineWorld world = new MineWorld(10, 10, 15, new Random());
    int worldWidth = (world.columns * 30);
    int worldHeight = (world.rows * 30) + 50;
    double tickRate = 1;
    world.bigBang(worldWidth, worldHeight, tickRate);
  }

}

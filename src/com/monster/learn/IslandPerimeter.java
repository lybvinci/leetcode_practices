package com.monster.learn;

//59.03%
public class IslandPerimeter {
  public int islandPerimeter(int[][] grid) {
    int perimeter = 0;
    int height = grid.length;
    int width = grid[0].length;
    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        perimeter += getPerimeter(grid, x, y, width, height);
      }
    }
    return perimeter;
  }

  public int getPerimeter(int[][] grid, int x, int y, int width, int height) {
    int perimeter = 0;
    if (grid[y][x] == 0)
      return perimeter;
    if (x == 0)
      perimeter++;
    else {
      if (grid[y][x - 1] == 0)
        perimeter++;
    }
    if (x == width - 1)
      perimeter++;
    else {
      if (grid[y][x + 1] == 0)
        perimeter++;
    }
    if (y == 0)
      perimeter++;
    else {
      if (grid[y - 1][x] == 0)
        perimeter++;
    }
    if (y == height - 1)
      perimeter++;
    else {
      if (grid[y + 1][x] == 0)
        perimeter++;
    }
    return perimeter;
  }
}
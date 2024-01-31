package sde.sheet.practice.companies.google;


interface Robot {
    // returns true if next cell is open and robot moves into the cell.
    // returns false if next cell is obstacle and robot stays on the current cell.
    boolean move();

    // Robot will stay on the same cell after calling turnLeft/turnRight.
    // Each turn will be 90 degrees.
    void turnLeft();

    void turnRight();

    // Clean the current cell.
    void clean();
}


public class RobotCleaner {

    static int[][] directions = {{-1, 0}, {0,1}, {0,-1}, {1,0}};
    public static void main(String[] args) {
        int[][] room = {
                {1, 1, 1, 1, 1, 0, 1, 1},
                {1, 1, 1, 1, 1, 0, 1, 1},
                {1, 0, 1, 1, 1, 1, 1, 1},
                {0, 0, 0, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1}
        };
        int rows = room.length;
        int cols = room[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int row = 1;
        int col = 3;
        Robot robot = null;//new SomeRobot();
        moveRobot(visited, row, col, rows, cols, robot, 0);
    }

    private static void moveRobot(boolean[][] visited, int row, int col, int rows, int cols, Robot robot, int direction) {
        if (row < 0 || row >= rows || col < 0 || col >= cols || visited[row][col]) {
            return;
        }
        visited[row][col] = true;
        robot.clean();
        for (int i = 0; i < 4; i++) {
            if (robot.move()) {
                int newDir = (direction+i)%4;
                moveRobot(visited, row+directions[newDir][0], col+directions[newDir][1], rows, cols, robot, direction);
            }
            robot.turnRight();
        }
    }
}

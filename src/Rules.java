/**
 *this abstract class doesn't apply to any object, since it's an abstract class. This class keeps track of if a cell
 * should be born and if it should survive according to how many live neighbors it has. The applyRules method uses
 * a conditional statement to change the states if a cell has a certain number of live neighbors. another part of the
 * code figures out how many live neighbors a cell has
 */
public abstract class Rules {
        public abstract boolean shouldBeBorn(int liveNeighbors);
        public abstract boolean shouldSurvive(int liveNeighbors);

    /**
     * @param cellState
     * @param liveNeighbors
     * @return
     */
    public CellState applyRules(CellState cellState, int liveNeighbors) {
            if (cellState == CellState.DEAD && shouldBeBorn(liveNeighbors) == true) {
                return CellState.WILL_REVIVE;
            } else if (cellState == CellState.ALIVE && shouldSurvive(liveNeighbors) == false) {
                return CellState.WILL_DIE;
            } else {
                return cellState;
            }
        }
}

package search3;

import java.util.ArrayList;

public class RamblersState extends SearchState{
    
    private Coords coords;

    /**
     * Constructor
     */
    public RamblersState(Coords coords, int lc){
        this.coords = coords;
        this.localCost = lc;
    }

    /**
     * accessor for the coordinates of the current state
     * @return  coords for current searchState
     */
    public Coords getCoords(){
        return coords;
    }

    /**
     * accessor for the local cost of the current state
     * @return  the local cost of the current searchState
     */
    public int getLocalCost() {
        return localCost;
      }
    
    /**
     * gets all of the possible successor nodes from the current state of the search
     * @param searcher  the current search being used
     */
    ArrayList<SearchState> getSuccessors(Search searcher){

        //gets the current search and the map
        RamblersSearch rSearch = (RamblersSearch) searcher;
        TerrainMap map = rSearch.getMap();

        ArrayList<SearchState> neighbourNodes = new ArrayList<SearchState>();

        //if the coordinate next to the current value is less than the width of the map
        if(this.coords.getx()+1 < map.getWidth()){
            //adds the successor state to the list containing the neighbouring nodes
            neighbourNodes.add(makeSearchState(this.coords.gety(), this.coords.getx()+1, map));
        }
        //if the coordinate next to the current value is bigger than 0
        if(this.coords.getx()-1 > 0){
            neighbourNodes.add(makeSearchState(this.coords.gety(), this.coords.getx()-1, map));
        }
        //if the coordinate above the current value is less than the depth of the map
        if(this.coords.gety()+1 < map.getDepth()){
            neighbourNodes.add(makeSearchState(this.coords.gety()+1, this.coords.getx(), map));
        }
        if(this.coords.gety()-1 > 0){
            neighbourNodes.add(makeSearchState(this.coords.gety()-1, this.coords.getx(), map));
        }
        return neighbourNodes;
    }

    /**
     * checks if the current state is the same as the goal state
     * @return  if the current state is the goal state
     */
    boolean goalPredicate(Search searcher) {
        RamblersSearch rSearcher = (RamblersSearch) searcher;

        //gets the goal position of the search
        Coords target = rSearcher.getGoal();
        
        //checks current state against goal state
        if(target.gety() == this.coords.gety() && this.coords.getx() == this.coords.getx()){
            return true;
        }
        else{
            return false;
        }

    }

    /**
     * checks if a state is the same a the current state
     * @param n2    the state to check against the current state
     */
    boolean sameState(SearchState n2) {

        RamblersState rn2 = (RamblersState) n2;

        if (rn2.coords.getx() == this.coords.getx() && rn2.coords.gety() == this.coords.gety()){
            return true;
        }
        return false;
    }

    @Override
    public String toString(){
        return "x-coordinate: " + this.coords.getx() + " y-coord: " + this.coords.gety();
    }

    /**
     * makes a new search state based on the provided coordinates and the given
     * terrain map
     * @param yCoord    the y-coordinate of a new search state
     * @param xCoord    the x-coordinate of a new search state
     * @param m         the terrain map of the search to work out local costs
     * @return  the search state created from the information provided
     */
    private SearchState makeSearchState(int yCoord, int xCoord, TerrainMap m){

        //gets the local cost of the movement from the current state to another
        int cost = setLocalCost(yCoord, xCoord, m);

        //sets the coordinates for a search state
        Coords newCoord = new Coords(yCoord, xCoord);

        //creates the new search state based on the coordinates and generated cost
        SearchState stateToAdd = (SearchState) new RamblersState(newCoord, cost);

        return stateToAdd;
    }

    /**
     * works out the local cost of moving from one state to another
     * @param y     the y-coordinate of the state being moved to
     * @param x     the x-coordinate of the state being moved to   
     * @param m     the map that the search state is on - used to get the height
     * @return  the cost based on the factors above
     */
    private int setLocalCost(int y, int x, TerrainMap m){

        //gets the current coordinates
        int thisX = this.coords.getx();
        int thisY = this.coords.gety();

        //if the position to be moved to has a less than or equal value
        if(m.getTmap()[y][x] <= m.getTmap()[thisY][thisX]){
            //the cost to move to it is 1
            return 1;
        }
        else{
            //otherwise the cost is 1 + the difference between the heights
            return 1 + (m.getTmap()[y][x] - m.getTmap()[thisY][thisX]);
        }
    }
}

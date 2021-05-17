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
            neighbourNodes.add(makeSearchState(this.coords.gety(), this.coords.getx()+1));
        }
        //if the coordinate next to the current value is bigger than 0
        if(this.coords.getx()-1 > 0){
            neighbourNodes.add(makeSearchState(this.coords.gety(), this.coords.getx()-1));
        }
        //if the coordinate above the current value is less than the depth of the map
        if(this.coords.gety()+1 < map.getDepth()){
            neighbourNodes.add(makeSearchState(this.coords.gety()+1, this.coords.getx()));
        }
        if(this.coords.gety()-1 > 0){
            neighbourNodes.add(makeSearchState(this.coords.gety()-1, this.coords.getx()));
        }
        return neighbourNodes;
    }

    boolean goalPredicate(Search searcher) {
        RamblersSearch rSearcher = (RamblersSearch) searcher;
        Coords target = rSearcher.getGoal();
        return this.coords.equals(target);
    }

    boolean sameState(SearchState n2) {
        if (this.equals(n2)){
            return true;
        }
        return false;
    }

    private SearchState makeSearchState(int yCoord, int xCoord){
        Coords newCoord = new Coords(yCoord, xCoord);
        SearchState stateToAdd = (SearchState) new RamblersState(newCoord, localCost);

        return stateToAdd;
    }

    private int setLocalCost(int y, int x){
        
    }
}

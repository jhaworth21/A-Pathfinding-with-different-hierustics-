package search3;

public class RamblersSearch extends Search{

    private TerrainMap map; //the map to be used
    private Coords goal;  //the goal to be reached

    public TerrainMap getMap() {
        return map;
    }
    
    public Coords getGoal(){
        return goal;
    }

    public RamblersSearch(TerrainMap m, Coords g){
        map = m;
        goal = g;
    }

}

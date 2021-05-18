package search4;

public class RamblersSearchAStar {

    public static void main(String[] args) {
        TerrainMap map = new TerrainMap("code/search4/tmc.pgm");

        //  System.out.println("Run Number: " + i);
    
        // int startY = (int) Math.round(Math.random()*(map.getDepth()-1));
        // int startX = (int) Math.round(Math.random()*(map.getWidth()-1));
    
        // System.out.println("Start: "+startX+", "+startY);
    
        Coords start = new Coords(7, 0);
    
        // int goalY = (int) Math.round(Math.random()*(map.getDepth()-1));
        // int goalX = (int) Math.round(Math.random()*(map.getWidth()-1));
    
        // System.out.println("Goal: "+goalX+", "+goalY);
    
        Coords goal = new Coords(5, 8);
    
        // double distance = Math.sqrt(Math.pow((goalX-startX), 2) + Math.pow((goalY-startY), 2));
        // System.out.println("Distance between points: " + distance);
    
        RamblersSearch searcher = new RamblersSearch(map, goal);
        SearchState initial = (SearchState) new RamblersState(start, 0, 0);
    
        String res_as= (searcher.runSearchE(initial, "AStar"));
    
        System.out.println(res_as);
    }

    
}

package search3;
public class RunRamblersBB{

    public static void main(String[] args) {
         TerrainMap map = new TerrainMap("code/search3/tmc.pgm");

         for(int i=0; i < 51; i++){
             System.out.println("Run Number: " + i);

            int startY = (int) Math.round(Math.random()*(map.getDepth()-1));
            int startX = (int) Math.round(Math.random()*(map.getWidth()-1));

            System.out.println("Start: "+startX+", "+startY);

            Coords start = new Coords(startY, startX);

            int goalY = (int) Math.round(Math.random()*(map.getDepth()-1));
            int goalX = (int) Math.round(Math.random()*(map.getWidth()-1));

            System.out.println("Goal: "+goalX+", "+goalY);
   
            Coords goal = new Coords(goalY, goalX);

            double distance = Math.sqrt(Math.pow((goalX-startX), 2) + Math.pow((goalY-startY), 2));
            System.out.println("Distance between points: " + distance);
   
            RamblersSearch searcher = new RamblersSearch(map, goal);
            SearchState initial = (SearchState) new RamblersState(start, 0);
   
            String res_bb = (searcher.runSearch(initial, "branchAndBound"));
   
            System.out.println(res_bb);
         }


    }
}
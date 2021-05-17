public class RamblersState extends SearchState{

    
    public int getLocalCost() {
        //TODO check worksheet and complete function - getLocalCost
        return localCost;
      }
    
    ArrayList<SearchState> getSuccessors(Search searcher){
        //TODO check worksheet and complete function - getSuccessors
    }

    boolean goalPredicate(Search searcher) {
        //TODO check worksheet and complete function - goalPredicate
        return false;
    }

    boolean sameState(SearchState n2) {
        //TODO check worksheet and complete function - sameState
        return false;
    }
}

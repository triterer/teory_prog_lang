
//import com.sun.javafx.collections.MappingChange.Map;
import java.util.HashSet;
import java.util.HashMap;

import com.sun.javafx.collections.MappingChange.Map;



/**
 * This class stores the basic state necessary for the A* algorithm to compute a
 * path across a map.  This state includes a collection of "open waypoints" and
 * another collection of "closed waypoints."  In addition, this class provides
 * the basic operations that the A* pathfinding algorithm needs to perform its
 * processing.
 **/
public class AStarState
{
    /** This is a reference to the map that the A* algorithm is navigating. **/
    private Map2D map;

    private Map<Location, Waypoint> openwp
    = new HashMap<Location, Waypoint> ();
    private Map<Location, Waypoint> closewp
    = new HashMap<Location, Waypoint> ();
    /**
     * Initialize a new state object for the A* pathfinding algorithm to use.
     **/
    public AStarState(Map2D map)
    {
        if (map == null)
            throw new NullPointerException("map cannot be null");

        this.map = map;
    }

    /** Returns the map that the A* pathfinder is navigating. **/
    public Map2D getMap()
    {
        return map;
    }

    /**
     * This method scans through all open waypoints, and returns the waypoint
     * with the minimum total cost.  If there are no open waypoints, this method
     * returns <code>null</code>.
     **/
    public Waypoint getMinOpenWaypoint()
    {
        // TODO:  Implement.
    	String mini, minikey;
    	minikey = "-12";
    	for (String key: openwp.keySet()){
    		if (openwp.get(key).getTotalCost()<mini){
    			mini = openwp.get(key).getTotalCost();
    			minikey = key;
    		}
    	}
    	if (minikey != "-12")
    		return openwp.get(minikey);
        return null;
    }

    /**
     * This method adds a waypoint to (or potentially updates a waypoint already
     * in) the "open waypoints" collection.  If there is not already an open
     * waypoint at the new waypoint's location then the new waypoint is simply
     * added to the collection.  However, if there is already a waypoint at the
     * new waypoint's location, the new waypoint replaces the old one <em>only
     * if</em> the new waypoint's "previous cost" value is less than the current
     * waypoint's "previous cost" value.
     **/
    public boolean addOpenWaypoint(Waypoint newWP)
    {
        // TODO:  Implement.
    	openwp.put(newWP.getLocation(), newWP);
        return false;
    }


    /** Returns the current number of open waypoints. **/
    public int numOpenWaypoints()
    {
        // TODO:  Implement.
    	if (openwp.size()!=0)
    		return 1;
        return 0;
    }


    /**
     * This method moves the waypoint at the specified location from the
     * open list to the closed list.
     **/
    public void closeWaypoint(Location loc)
    {
        // TODO:  Implement.
    	closewp.put(openwp.get(loc).getLocation(),openwp.get(loc))
    	openwp.remove(loc);
    	
    }

    /**
     * Returns true if the collection of closed waypoints contains a waypoint
     * for the specified location.
     **/
    public boolean isLocationClosed(Location loc)
    {
        // TODO:  Implement.
    	if (closewp.get(loc)!=null)
    		return false;
        return true;
    }
}

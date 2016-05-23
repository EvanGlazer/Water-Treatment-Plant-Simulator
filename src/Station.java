/*  
Name: Evan Glazer
Course: CNT 4714 Summer 2016 
Assignment title: Project 1 – Multi-threaded programming in Java  
Date: May 31, 2016  
Class:  Station.class
*/ 
public class Station {
    
    int sharedPipe;
    int stationNum;
    int adjacentStation;
    int workLoad;
    
    public Station(int shared, int station, int adj, int load)
    {
        this.sharedPipe = shared;
        this.stationNum = station;
        this.adjacentStation = adj;
        this.workLoad = load;
    }
    

    public int getSharedPipe() {
        return sharedPipe;
    }

    public void setSharedPipe(int sharedPipe) {
        this.sharedPipe = sharedPipe;
    }

    public int getStationNum() {
        return stationNum;
    }

    public void setStationNum(int stationNum) {
        this.stationNum = stationNum;
    }

    public int getAdjacentStation() {
        return adjacentStation;
    }

    public void setAdjacentStation(int adjacentStation) {
        this.adjacentStation = adjacentStation;
    }

    public int getWorkLoad() {
        return workLoad;
    }

    public void setWorkLoad(int workLoad) {
        this.workLoad = workLoad;
    }
    
}

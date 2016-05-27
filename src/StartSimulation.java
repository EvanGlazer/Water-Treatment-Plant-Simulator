
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/*  
Name: Evan Glazer
Course: CNT 4714 Summer 2016 
Assignment title: Project 1 – Multi-threaded programming in Java  
Date: May 31, 2016  
Class:  StartSimulation.class
*/ 
public class StartSimulation {
    
    static List<Station> station;
    static PipeWork pipe;
    public static void main(String[] args ) throws FileNotFoundException
    {
        station = new ArrayList<>();  
        pipe = new PipeWork();
        station = pipe.readFile();
        
        for(Station s: station)
        {
            new Thread(new PipeWork().new worker(s)).start();
        }
            
    }
    
}

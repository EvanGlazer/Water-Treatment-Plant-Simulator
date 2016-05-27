
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*  
Name: Evan Glazer
Course: CNT 4714 Summer 2016 
Assignment title: Project 1 – Multi-threaded programming in Java  
Date: May 31, 2016  
Class:  PipeWork.class
*/ 

public class PipeWork {
    
    String file = "config.txt";
    Scanner sc;
    File dir;
    List<Station> station;
    
    
    
    public class worker implements Runnable {

        Station current;
        Station adj;
        
        public worker(Station cur)
        {
            current = cur;
            int pos = station.indexOf(current);
            if(pos !=0)
            {
                adj = station.get(pos - 1);
            }
            else
            {
                adj = station.get(station.size()-1);
            }
        }
        @Override
        public void run() {
            // write to console/ file
            // sleep for random time, then set station work
            // check for when station no longer has work
            
        }
    
    }

   
    
    // read config.txt - set stations
    public List<Station> readFile() throws FileNotFoundException
    {
        dir = new File(file);
        sc = new Scanner(dir);
        station = new ArrayList<>();
        
        int maxStation = sc.nextInt();
        for(int i=0; i<maxStation; i++)
        {
            int sharedPipe;
            int stationNum = i;
            int adjacentStation;
            int workLoad = sc.nextInt();
            
            if(i==0)
            {
                sharedPipe = maxStation -1;
                adjacentStation = maxStation -1;
            }
            else
            {
                sharedPipe = i-1;
                adjacentStation = i-1;
            }
            Station s = new Station(sharedPipe,stationNum,adjacentStation,workLoad);
            station.add(s);
        }
    
        return station;
    }
    
    // write output.txt - simulate data 
    public void writeFile(String data)
    {
       try {
            FileWriter writer = new FileWriter(file,true);
            BufferedWriter buffer  = new BufferedWriter(writer);
            buffer.write(data);
            buffer.newLine();
            buffer.close();
            writer.close();
	} 
       catch (IOException e)
        {
            e.printStackTrace();
        }
    }
       
    
}


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
    
    // read config.txt - set stations
    public void readFile() throws FileNotFoundException
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
    
        System.out.println(station.size() +"");
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
    
    // do work/ check locks
    
    
}

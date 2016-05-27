
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/*  
Name: Evan Glazer
Course: CNT 4714 Summer 2016 
Assignment title: Project 1 – Multi-threaded programming in Java  
Date: May 31, 2016  
Class:  Station.class
*/ 
public class Station {
    String file = "output.txt";
    int pipeX;
    int stationNum;
    int pipeY;
    int workLoad;
    Lock pipeLock = new ReentrantLock();
    
    public Station(int shared, int station, int adj, int load)
    {
        this.pipeX = shared;
        this.stationNum = station;
        this.pipeY = adj;
        this.workLoad = load;
    }
    
    public boolean checkLocks(Station adj)
    {
        boolean pipeX = false;
        boolean pipeY = false;
        
        if(pipeX = pipeLock.tryLock())
        {
             // granted access and pipeX value true
            // write to console/file
            
        
        }
        if(pipeY = adj.pipeLock.tryLock())
        {
             // granted access and pipeY value true
            // write to console/file
        }
        
        else if(!(pipeX && pipeY))
        {
            if(pipeX)
            {
                // unlock pipe and release access
            }
            if(pipeY)
            {
                // unlock pipe and release access
            }
        }
        
        return true;
    }
    
    
    public void doWork(Station adj)
    {
        Random r = new Random();
        if(checkLocks(adj))
        {
            try {
                Thread.sleep(r.nextInt(100));
                this.workLoad--;
            } catch (InterruptedException ex) {
                Logger.getLogger(Station.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally
            {
                // unlock threads and release access
            }
        
        } 
        
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

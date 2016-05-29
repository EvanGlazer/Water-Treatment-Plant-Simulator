
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
        boolean pipeXCheck = false;
        boolean pipeYCheck = false;
        try{
        if(pipeXCheck = pipeLock.tryLock())
        {
             // granted access/locks and pipeX value true
            // write to console/file
            writeFile("Station " + stationNum +": granted access to pipe " + pipeX);
            
        
        }
        if(pipeYCheck = adj.pipeLock.tryLock())
        {
             // granted access/locks and pipeY value true
            // write to console/file
            writeFile("Station " + stationNum +": granted access to pipe " + pipeY);
        }
        }
        finally{
            
            if(!(pipeXCheck && pipeYCheck))
            {
                if(pipeXCheck)
                {
                    // unlock pipe and release access
                    pipeLock.unlock();
                    writeFile("Station " + stationNum +":  released access to pipe " + pipeX);
                }
                if(pipeYCheck)
                {
                    // unlock pipe and release access
                    adj.pipeLock.unlock();
                    writeFile("Station " + stationNum +":  released access to pipe " + pipeY);
                }
            }
        }
        return pipeXCheck && pipeYCheck;
    }
    
    
    public void doWork(Station adj)
    {
        Random r = new Random();
        if(checkLocks(adj))
        {
            writeFile("Station " + stationNum +": successfully flows on pipe " + pipeX);
            writeFile("Station " + stationNum +": successfully flows on pipe " + pipeY);
            try {
                Thread.sleep(r.nextInt(1000));
                this.workLoad--;
            } catch (InterruptedException ex) {
                Logger.getLogger(Station.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally
            {
                // unlock threads and release access
                pipeLock.unlock();
                adj.pipeLock.unlock();
                writeFile("Station " + stationNum +": released access to pipe " + pipeX);
                writeFile("Station " + stationNum +": released access to pipe " + pipeY);
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

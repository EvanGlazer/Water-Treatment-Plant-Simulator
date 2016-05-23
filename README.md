# Water-Treatment-Plant-Simulator
The goal is to simulate the pump management system for a water treatment plant.

<img src="https://gyazo.com/f8cc6b4fdcdf86e537fddad0d3682d2e"/>

You have been hired to design a simulator for a new water treatment plant being built with the same design, but possibly fewer/more stations.  You are to implement this simulator in Java and have each station function in its own thread.  A station’s workload is the number of times that a station needs to have exclusive access to the input and output pipes during the simulation.  Once a station is 
granted access to both pipes it calls its doWork()method during which it will flow water down each pipe (of course it must verify that it has access and isn’t in conflict with another station).  After the flow-in and flow-out methods are run, the workload of the station is reduced by 1 and the station releases both pipes and signals waiting stations that the pipes are available.  After executing a flow and releasing its pipes, a station should sleep for some random period of time.  A station’s thread stops running when its workload reaches 0.  To prevent deadlock, ensure that each station thread acquires locks on the pipes it needs in increasing numerical order. 

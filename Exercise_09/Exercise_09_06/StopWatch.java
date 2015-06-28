/****************************
*         StopWatch         *
*---------------------------*
* -startTime: long          *
* -endTime: long            *
* +StopWatch()              *
* +start()                  *
* +stop()                   *
* +getElapsedTime(): long   *
* +getStratTime(): long     *
* +getEndTime(): long       *
****************************/

// Implement StopWatch class
public class StopWatch {
	private long startTime; // Start time
	private long endTime;	// End time

	// no-arg constructor that initializes 
	// startTime with the current time
	StopWatch() {
		startTime = System.currentTimeMillis();
	}

	// Resets the startTime to the current time
	public void start() {
		startTime = System.currentTimeMillis();
	} 

	// Sets the endTime to the current time
	public void stop() {
		endTime = System.currentTimeMillis();
	}

	// Returns the elapsed time for 
	// the stopwatch in milliseconds
	public long getElapsedTime() {
		return getEndTime() - getStratTime();
	}

	// Return start time
	public long getStratTime() {
		return startTime;
	}

	// Return end time
	public long getEndTime() {
		return endTime;
	}
}
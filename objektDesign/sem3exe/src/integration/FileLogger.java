/**
 * 
 */
package integration;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;;

/**
 * @author Nikita
 *A class for writing to log
 */
public class FileLogger implements Logger{
	private PrintWriter logStream;
	
	/*
	 * Create a new filelogger that opens a stream to the log
	 */
	public FileLogger(){
		try{
			logStream = new PrintWriter(new FileWriter("log.txt"));
		}catch(IOException io){
			System.out.println("ERROR WHEN LOGGING");
			io.printStackTrace();
		}
	}
	/*
	 * Prints to log
	 * @param logMessage the message to be printed to the log
	 */
	@Override
	public void log(String logMessage){
		logStream.println(logMessage);
	}
}

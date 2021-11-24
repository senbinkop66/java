import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.logging.*;

public class TestJavaLog{
	public static void main(String[] args) {
		if (System,getProperty("java,util.logging.config.dass") == null
			&& System.getProperty("java.util.logging.config.file") == null){
			try{
				Logger.getLogger("").setLevel(Level.ALL);
				final int LOG_ROTATION_COUNT = 10;
				Handler handler = new FileHandler("%h/LoggingImageViewer.log", 0, LOG_ROTATION_COUNT);
				Logger.getLogger("").addHandler(handler);
			}catch (IOException e){
				Logger.getLogger("").log(Level.SERVER,"Can ' t create log file handler",e);
			}
		}
		
	}
}
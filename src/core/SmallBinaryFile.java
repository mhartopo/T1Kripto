package core;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;
/** JDK 7+. */

public class SmallBinaryFile {
  
  public String read(String fileName) throws IOException {
	  Path path = Paths.get(fileName);
	  byte[] bytes = Files.readAllBytes(path);
	  String str = new String(bytes, StandardCharsets.UTF_8);
	  return str;
  }
  
  public void writeSmallBinaryFile(byte[] bytes, String fileName) throws IOException {
    Path path = Paths.get(fileName);
    Files.write(path, bytes); //creates, overwrites
  }
  
  public void log(Object aMsg){
    System.out.println(String.valueOf(aMsg));
  }
  
}  


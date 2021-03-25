/***************************************************************
* Calculadora.java
* Autor: UVG
* Universidad del Valle de Guatemala
*
* Fecha creacion: 29/01/21
* Ultima modificacion: 6/02/21
***************************************************************/

/**
 * Calculadora.java Interface
 * @author Jose Hernández
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;

public class FileReaderS {
    

    public ArrayList ReadFile(String line){  
        ArrayList<List> FileC = new ArrayList<>();
        try{
                FileReader fr = new FileReader("datos.txt"); BufferedReader bf = new BufferedReader(fr);
                while((line = bf.readLine()) != null) { }
                bf.close(); 
                }           
        catch(Exception e){ System.out.println("Cuidado!!"); System.out.println(e);}
        return FileC;}
}

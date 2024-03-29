//javac ex2.java to compile
//java ex2 to run
import java.util.*;
import java.io.*;
import javax.swing.*;
import java awt.event.*; //needed for window event


public class ex2 {

    static class WindowDisposer implements WinddowListener{
        //fields
        int count = 0;

        //constuctor
        public WindowDisposer (int c){
            
        }

        //methods
        public void WindowActivated(WindowEvent e){}
        public void WindowClosing(WindowEvent e){
            System.out.println("closed a window");
        }
        public void WindowDeactivated(WindowEvent e){}
        public void WindowDeiconified(WindowEvent e){}
        public void WindowIconified(WindowEvent e){}
        public void WindowOpened(WindowEvent e){}

    }

    public static void main(String[] args){
        JFrame [] fArr = new JFrame[3];

        WindowDisposer wd - new WindowDisposer();

        for(int i = 0; i < 3; i++){
            f.setTitle("Post Quantum Crypt is Awesome!");
            f.setSize(300, 400);
            f.setLocation(50, 100);
            //f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.addWindowListener(wd);

            f.setVisible(true);
        }
    }
   
}
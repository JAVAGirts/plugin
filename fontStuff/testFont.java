package test;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;

public class testFont extends JFrame implements ActionListener{
	
	
	private Font customFont;
    private JTextArea areaInput, areaHexOutput, areaFontOutput; 
    private JButton btnGenerate; 
     
    public testFont()
    {
                 
        String fontPath = "/home/savkin/Desktop/savkin/eclipseWorkspace/epicProject/src/test/xDigitsSystem.ttf";
        customFont = null;      
        try
        {
            //create the font to use. Specify the size!
            customFont = Font.createFont(Font.TRUETYPE_FONT, new File(fontPath)).deriveFont(20f);
    
            //register the font
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File(fontPath)));         
             
        } 
        catch(IOException e)
        {
            e.printStackTrace();
        }
        catch(FontFormatException e)
        {
            e.printStackTrace();
        }
         
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(468, 311);
         getContentPane().setLayout(null);
         
        areaInput = new JTextArea();
        areaInput.setLineWrap(true);
        areaInput.setBounds(34, 42, 162, 73);   
         getContentPane().add(areaInput);
         
        btnGenerate = new JButton("Generate");
        btnGenerate.setBounds(255, 42, 162, 73);
        btnGenerate.setFocusable(false);
        btnGenerate.addActionListener(this);
         getContentPane().add(btnGenerate);
         
        areaHexOutput = new JTextArea();
        areaHexOutput.setEditable(false);
        areaHexOutput.setBounds(255, 165, 162, 73);
         getContentPane().add(areaHexOutput);
         
        areaFontOutput = new JTextArea();
        areaFontOutput.setEditable(false);
        areaFontOutput.setBounds(32, 165, 164, 73);
        areaFontOutput.setFont(customFont);
         getContentPane().add(areaFontOutput);
         
        JLabel lblNormal = DefaultComponentFactory.getInstance().createLabel("NORMAL");
        lblNormal.setBounds(34, 16, 73, 15);
         getContentPane().add(lblNormal);
         
        JLabel lblHex = DefaultComponentFactory.getInstance().createLabel("HEX");
        lblHex.setBounds(255, 139, 32, 15);
         getContentPane().add(lblHex);
         
        JLabel lblFont = DefaultComponentFactory.getInstance().createLabel("FONT");
        lblFont.setBounds(34, 139, 38, 15);
         getContentPane().add(lblFont);
         
         
         
         
         
         
         
    }
     
 
    public static void main(String[] args){
         
        testFont tf = new testFont();       
        tf.setLocationRelativeTo(null);
        tf.setVisible(true);
         
    }
 
     
    public String toHex(String s) 
    {
        /*
         *   http://codebeautify.org/decimal-hex-converter
         *   http://codebeautify.org/string-hex-converter
         */
         
        String returner = "";
         
//      if(!isNumeric(s))
            returner =  String.format("%x", new BigInteger(1, s.getBytes()));           
//      else  
//      {
//          int num = Integer.parseInt(s); 
//          returner = "" + Integer.toHexString(num);
//      }
           
          return returner;
    }
    public boolean isNumeric(String s)  
    {  
          try 
          {  
              int num = Integer.parseInt(s);  
          }  
          catch(NumberFormatException nfe)  
          {  
              return false;  
          } 
           
      return true;  
    }
     
    @Override
    public void actionPerformed(ActionEvent e) {
         
        if(e.getSource().equals(btnGenerate))
        {
            areaHexOutput.setText(toHex(areaInput.getText()));
            areaFontOutput.setText(areaInput.getText());        
        }
         
 
    }
}

package ASSIGNEMENT;

// needed classes
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;


/// implemeting MouseListener interface for mouse events
public class GUI implements MouseListener{
    // object of frmae + button + tex area
   public JFrame frame;
   public JButton encode;
   public JButton decode;
   public JButton clear;
   public JTextArea text;
   // object of the class
   public TEXT object = new TEXT();
   // constructor conain all gui component to only by creaing object of the class run all things
    public GUI(){
        // frame part
     frame = new JFrame();
     frame.setSize(700, 700);
     frame.setVisible(true);
     frame.setLayout(null);
     frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
     frame.setResizable(true);
     frame.setTitle("Text Compression");
     frame.setBounds(450, 180, 600, 400);
     
     // icon for the frame
     ImageIcon img = new ImageIcon("icon.png");
     frame.setIconImage(img.getImage());
     
     // button part
     
     // encode button
      encode = new JButton("encode");
     encode.setBounds(460, 230, 80, 40);
     
     // decode button
      decode = new JButton("decode");
     decode.setBounds(460, 280, 80, 40);
     
     // clear button
      clear = new JButton("clear");
     clear.setBounds(370, 280, 80, 40);
     
     
     // lable part 
     JLabel TextLable = new JLabel();
     TextLable.setText("Enter Your Text :");
     TextLable.setBounds(30, 0, 500,50);
     TextLable.setForeground(Color.black);
     TextLable.setFont(new Font("Times new roman",Font.BOLD,24));
     TextLable.setOpaque(true);
     
     // text area part
      text = new JTextArea();
     text.setBounds(30, 60,500,150);
     text.setBorder(BorderFactory.createLineBorder(Color.black, 2));
     
     
     // this 3 lines came frame Gemini AI
           // Enable line wrapping
        text.setLineWrap(true);
        text.setWrapStyleWord(true); // Wrap at word boundaries

     
     // mouse listener part
     encode.addMouseListener(this);
     decode.addMouseListener(this);
     clear.addMouseListener(this);
     
     
     
     // adding component to the frame 
     frame.add(encode);
     frame.add(decode);
     frame.add(clear);
     frame.add(TextLable);
     frame.add(text);
     
    }
    
    public static void main(String[] args) {
        // this line comes from Gemini AI to because there is a lot of logic that slow down the gui loading so this line solved this problem
          SwingUtilities.invokeLater(() -> {
              // an object to call the constructor and run the gui codes
        GUI object = new GUI();
    });
       
        
    }

     // method for mouse clicks
    public void mouseClicked(MouseEvent e) {
        // for encoding text
        if(e.getSource() == encode){
            // storing what user wrote
        String sentence = text.getText();
        // send it to count characters and mix trees
        object.CouontLetters(sentence);
        // encode the text and set it to the text area to user
        text.setText(object.Encode(sentence));
        }
        // for decoding an encoded text
        else if (e.getSource() == decode){
            // storing what user wrote
        String sentence = text.getText();
        // send it to decode method and set the result to the text area to the user
        text.setText(object.Decode(sentence));
        }
        // for clearing
        else{
            // set empty to the text area
        text.setText("");
        }
        }
// not used mouese event methods
    @Override
    public void mousePressed(MouseEvent e) {
     }

    @Override
    public void mouseReleased(MouseEvent e) {
      }

    @Override
    public void mouseEntered(MouseEvent e) {
      }

    @Override
    public void mouseExited(MouseEvent e) {
     }
}

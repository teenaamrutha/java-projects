import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.*;
import java.lang.*;

class calorie_calculator extends javax.swing.JFrame {
 
    calorie_calculator() {
        JFrame f = new JFrame("Calorie Calculator");//creating instance of JFrame  
        
        
        JLabel lb1 = new JLabel("Height(cm):");//height label
        lb1.setBounds(20, 20, 100, 40);//x axis, y axis, width, height
        f.add(lb1); //adding component in JFrame
 
        JLabel lb2 = new JLabel("Weight(Kg):");//weight label
        lb2.setBounds(20, 60, 100, 40);//x axis, y axis, width, height
        f.add(lb2); //adding component in JFrame 
  
        JLabel lb3 = new JLabel("Age(years):");
        lb3.setBounds(20, 100, 100, 40);//x axis, y axis, width, height
        f.add(lb3); //adding component in JFrame 

        JLabel lb4 = new JLabel("Gender:");//button group label
        lb4.setBounds(20, 140, 100, 40);//x axis, y axis, width, height
        f.add(lb4); //adding component in JFrame 

        JLabel lb5 = new JLabel("Activity:");//combo box label
        lb5.setBounds(20, 180, 100, 40);//x axis, y axis, width, height
        f.add(lb5); //adding component in JFrame 
        
        JLabel lb6 = new JLabel("Enter all of the above values");
        lb6.setBounds(20, 220, 300, 40);//x axis, y axis, width, height
        f.add(lb6); //adding component in JFrame 

        JTextField txtHeight = new JTextField("");
        txtHeight.setBounds(120, 20, 200, 40);//x axis, y axis, width, height
        f.add(txtHeight); //adding component in JFrame 
 
        JTextField txtWeight = new JTextField("");
        txtWeight.setBounds(120, 60, 200, 40);//x axis, y axis, width, height
        f.add(txtWeight); //adding component in JFrame  

        JTextField txtage = new JTextField("");
        txtage.setBounds(120, 100, 200, 40);//x axis, y axis, width, height
        f.add(txtage); //adding component in JFrame    
       

        ButtonGroup bg=new ButtonGroup();
        
        JRadioButton rb1 = new JRadioButton("Male");
        rb1.setBounds(120,140,100,40);
        bg.add(rb1);
 
        JRadioButton rb2 = new JRadioButton("Female");
        rb2.setBounds(220,140,100,40);
        bg.add(rb2);
        f.add(rb1);
        f.add(rb2);

        //String activities[]={"Sedentary","Lightly Active","Moderate Active","Very Active","Extremely Active"};
        //final JComboBox cb= new JComboBox(activities);
        //cb.setBounds(120,180,200,40);
        //f.add(cb);
        
        JComboBox ch=new JComboBox();
          ch.addItem("Sedentary");
           ch.addItem("Lightly Active"); 
           ch.addItem("Moderate Active"); 
           ch.addItem("Very Active"); 
           ch.addItem("Extremely Active"); 
            ch.setBounds(120,180,200,40);
            f.add(ch);
        
         //Choice ch=new Choice();
          //ch.add("Sedentary");
           //ch.add("Lightly Active"); 
           //ch.add("Moderate Active"); 
           //ch.add("Very Active"); 
           //ch.add("Extremely Active"); 
            //ch.setBounds(120,180,200,40);
           // f.add(ch);

        JButton btn = new JButton("Calculate Calories");  //creating instance of JButton  
        btn.setBounds(20, 260, 300, 40);//x axis, y axis, width, height
        
        //Event
        btn.addActionListener(new ActionListener(){
           
            public void actionPerformed(ActionEvent e) {
                if((txtWeight.getText().length()!=0)&&(txtHeight.getText().length()!=0)&&(txtage.getText().length()!=0)&&(rb1.isSelected()||rb2.isSelected()))
                {
                double weight=Double.parseDouble(txtWeight.getText());
                double height=Double.parseDouble(txtHeight.getText());
                double age=Integer.parseInt(txtage.getText());
                double bmr=0;
                double calories=0;
              
                //String activity = ch.getSelectedItem(); 
                String activity =(String) ch.getSelectedItem(); 
               
                
                 if(rb1.isSelected()){
                  bmr=(10*weight)+(6.25*height)-(5*age)+5; 
               }
               else if(rb2.isSelected()){
                  bmr=(10*weight)+(6.25*height)-(5*age)-161;
               }
               if(activity=="Sedentary"){
                 calories=bmr*1.2;
               }
               else if(activity=="Lightly Active"){
                  calories=bmr*1.375;
               }
               else if(activity=="Moderate Active"){
                   calories=bmr*1.55;
                }
               else if(activity=="Very Active"){
                  calories=bmr*1.725;
               }
               else if(activity=="Extremely Active"){
                     calories=bmr*1.9;
                }
                //lb6.setText("Calories required are "+ Math.round(calories));
                JOptionPane.showMessageDialog(f,"Calories required are "+ Math.round(calories),"Result",JOptionPane.INFORMATION_MESSAGE);
                JOptionPane.showMessageDialog(f,"Eat healthy and STAY FIT","Message",JOptionPane.INFORMATION_MESSAGE);
                JOptionPane.showMessageDialog(f,"For calculating again, you can enter values","Message",JOptionPane.INFORMATION_MESSAGE);
                txtWeight.setText("");
                txtHeight.setText("");
                txtage.setText("");
                //bg.clearSelection();
                ch.setSelectedItem("Sedentary");
               } 
               else{
                JOptionPane.showMessageDialog(f,"Please enter all values","Alert",JOptionPane.WARNING_MESSAGE);
                }
             }
              
        });
        f.add(btn);//adding button in JFrame  
        f.setSize(400,400);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
       }
      public static void main(String args[])throws Exception{
        new calorie_calculator();
    }
}
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Question1{
    public static void main(String[] args){

        ConstCompany obj = new ConstCompany();
    }
}

class ConstCompany extends JFrame{

    JLabel model, number_of_Bedrooms, garage, totPrice;
    JTextField total;
    JRadioButton Aspen, Brittany, Colonial, Dartmoor, two, three, four, No_Garage, oneCar, twoCar, threeCar;
    JButton submit;
    JFrame mainFrame;

    int modelPrice = 0, bedroomPrice = 0, garagePrice = 0;

    public <ActionEvent> ConstCompany(){
        
        setTitle("RICHFIELD ORDER FORM");

        model = new JLabel("Model:");
        Aspen = new JRadioButton("Aspen (R110 000)");
        Brittany = new JRadioButton("Brittany (R120 000)");
        Colonial = new JRadioButton("Colonial (R120 000)");
        Dartmoor = new JRadioButton("Dartmoor (R130 000)");

        ButtonGroup mdl = new ButtonGroup();
        mdl.add(Aspen);
        mdl.add(Brittany);
        mdl.add(Colonial);
        mdl.add(Dartmoor);

        add(model);
        add(Aspen);
        add(Brittany);
        add(Colonial);
        add(Dartmoor);

        model.setBounds(10, 0, 100, 20);
        Aspen.setBounds(10, 40, 150, 20);
        Brittany.setBounds(10, 70, 150, 20);
        Colonial.setBounds(10, 100, 150, 20);
        Dartmoor.setBounds(10, 130, 150, 20);

        number_of_Bedrooms = new JLabel("Number of Bedrooms:");
        two = new JRadioButton("two (R10 500)");
        three = new JRadioButton("three (R21 000)");
        four = new JRadioButton("four (R31 500)");

        add(number_of_Bedrooms);
        add(two);
        add(three);
        add(four);

        ButtonGroup NOB = new ButtonGroup();
        NOB.add(two);
        NOB.add(three);
        NOB.add(four);

        number_of_Bedrooms.setBounds(200, 0, 400, 20);
        two.setBounds(200, 40, 200, 20);
        three.setBounds(200, 70, 200, 20);
        four.setBounds(200, 100, 200, 20);

        garage = new JLabel("Garage:");
        No_Garage = new JRadioButton("No Garage");
        oneCar = new JRadioButton("For 1 Car (R7775)");
        twoCar = new JRadioButton("For 2 Cars (R15 550)");
        threeCar = new JRadioButton("For 3 Cars (R23 325)");

        add(garage);
        add(No_Garage);
        add(oneCar);
        add(twoCar);
        add(threeCar);

        ButtonGroup g = new ButtonGroup();
        g.add(No_Garage);
        g.add(oneCar);
        g.add(twoCar);
        g.add(threeCar);

        garage.setBounds(400, 0, 100, 20);
        No_Garage.setBounds(400, 40, 250, 20);
        oneCar.setBounds(400, 70, 250, 20);
        twoCar.setBounds(400, 100, 250, 20);
        threeCar.setBounds(400, 130, 250, 20);

        submit = new JButton("Submit");
        add(submit);

        submit.setBounds(10, 200, 100, 20);

        Aspen.addActionListener(ae -> modelPrice = 110000 );
        Brittany.addActionListener(ae -> modelPrice = 120000 );
        Colonial.addActionListener(ae -> modelPrice = 120000 );
        Dartmoor.addActionListener(ae -> modelPrice = 130000 );

        two.addActionListener(ae -> bedroomPrice = 10500);
        three.addActionListener(ae -> bedroomPrice = 21000);
        four.addActionListener(ae -> bedroomPrice = 31500);

        No_Garage.addActionListener(ae -> garagePrice = 0);
        oneCar.addActionListener(ae -> garagePrice = 7775);
        twoCar.addActionListener(ae -> garagePrice = 15550);
        threeCar.addActionListener(ae -> garagePrice = 23325);

        totPrice = new JLabel("Total Price: ");
        add(totPrice);
        totPrice.setBounds(10, 230, 200, 20);

        total = new JTextField(15);
        add(total);
        total.setBounds(80, 230, 100, 20);

        submit.addActionListener(e -> {
            total.setText(String.valueOf(modelPrice + bedroomPrice + garagePrice));
        });

        this.setLayout(null);
        this.setVisible(true);
        this.setSize(640, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
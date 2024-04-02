import javax.swing.*;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyListener;

public class EnigmaFrame extends JFrame {
    

    //All elements to be put in top with a flow layout
    private JComboBox<Integer> innerRotor;
    private JComboBox<Integer> midRotor;
    private JComboBox<Integer> OuterRotor;

    private final Integer[] choices = {1,2,3,4,5};

    private JTextField innitPostions;
    private JTextArea inputTextField;
    private JTextArea outputTextField;
    
    //Enigma logic variables
    private Integer rotor1num;
    private Integer rotor2num;
    private Integer rotor3num;
    private String startPos;
    private String message;
    


    public EnigmaFrame(){
        super();
        this.setTitle("Enigma GUI");
        this.setResizable(false);

        // Adding the top row components
        JLabel inner = new JLabel("Inner");
        innerRotor = new JComboBox<Integer>(choices);
        JLabel mid = new JLabel("Middle");
        midRotor = new JComboBox<Integer>(choices);
        JLabel outer = new JLabel("Out");
        OuterRotor = new JComboBox<Integer>(choices);

        JLabel initPos = new JLabel("InitialPositions");

        innitPostions = new JTextField("AAA", 3);

        JButton enc = new JButton("Encrypt");
        JButton dec = new JButton("Decrypt");

        JPanel top = new JPanel(new FlowLayout());

        top.add(inner);
        top.add(innerRotor);
        top.add(mid);
        top.add(midRotor);
        top.add(outer);
        top.add(OuterRotor);
        top.add(initPos);
        top.add(innitPostions);
        top.add(enc);
        top.add(dec);

        //Adding center row components
        JPanel center = new JPanel(new FlowLayout());
        JLabel in = new JLabel("Input");
        inputTextField = new JTextArea(4,50);
        inputTextField.setLineWrap(true);

        center.add(in);
        center.add(inputTextField);


        // Adding bottom row componenets
        JPanel bottom = new JPanel(new FlowLayout());
        JLabel out = new JLabel("Output");
        outputTextField = new JTextArea(4, 50);
        outputTextField.setEditable(false);
        outputTextField.setLineWrap(true);

        bottom.add(out);
        bottom.add(outputTextField);


        // Adding Enigma Logic

        enc.addActionListener((e) -> {
            rotor1num = (Integer) innerRotor.getSelectedItem();
            rotor2num = (Integer) midRotor.getSelectedItem();
            rotor3num = (Integer) OuterRotor.getSelectedItem();
            startPos = innitPostions.getText();
            message = inputTextField.getText();
            String[] args = {rotor1num.toString(), rotor2num.toString(), rotor3num.toString(), startPos, "encrypt", message};
            outputTextField.setText(Comms.run(args));
        });

        dec.addActionListener((e) -> {
            rotor1num = (Integer) innerRotor.getSelectedItem();
            rotor2num = (Integer) midRotor.getSelectedItem();
            rotor3num = (Integer) OuterRotor.getSelectedItem();
            startPos = innitPostions.getText();
            message = inputTextField.getText();
            String[] args = {rotor1num.toString(), rotor2num.toString(), rotor3num.toString(), startPos, "decrypt", message};
            outputTextField.setText(Comms.run(args));
        });

        // Adding all JPanels together
        this.add(top, BorderLayout.NORTH);
        this.add(center, BorderLayout.CENTER);
        this.add(bottom, BorderLayout.SOUTH);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

    }

    





}

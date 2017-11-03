package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame
{
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 350;
    private JButton display;
    private JPanel panel;

    private double result;
    private boolean start;
    private String lastCommand;

    //konstruktor
    public MyFrame()
    {
        result = 0;
        start = true;
        lastCommand = "=";

        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
        setLayout(new BorderLayout());

        display = new JButton("No dalej licz to!");
        display.setEnabled(false);
        add(display,BorderLayout.NORTH);

        ActionListener insert = new InsertAction();
        ActionListener command = new CommandAction();

        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));
        add(panel,BorderLayout.CENTER);

        addButton("7", insert);
        addButton("8", insert);
        addButton("9", insert);
        addButton("/", command);

        addButton("4", insert);
        addButton("5", insert);
        addButton("6", insert);
        addButton("*", command);

        addButton("1", insert);
        addButton("2", insert);
        addButton("3", insert);
        addButton("-", command);

        addButton("0", insert);
        addButton(",", insert);
        addButton("+", command);
        addButton("=", command);
        //pack();
    }

    //dodawanie przycisków
    private void addButton(String label, ActionListener listener)
    {
        JButton button = new JButton(label);
        panel.add(button);
        button.addActionListener(listener);
    }

    //klasa do dodawania na wyświetlacz
    private class InsertAction implements ActionListener
    {
        @Override public void actionPerformed(ActionEvent event)
        {
            String input = event.getActionCommand();
            if(start)
            {
                display.setText("");
                start=false;
            }
            display.setText(display.getText() + input);
        }
    }
    //klasa do wykonywania akcji przycisku
    private class CommandAction implements ActionListener
    {
        @Override public void actionPerformed(ActionEvent event)
        {
            String command = event.getActionCommand();
            if(start)
            {
                lastCommand = command;
            }
            else
            {
                calculate(Double.parseDouble(display.getText()));
                lastCommand = command;
                start=true;
            }
        }
    }
    
    public void calculate(double x)
    {
        if(lastCommand.equals("+")) result += x;
        else if(lastCommand.equals("-")) result -= x;
        else if(lastCommand.equals("*")) result *= x;
        else if(lastCommand.equals("/")) result /= x;
        else if(lastCommand.equals("=")) result = x;
        display.setText("" + result);
    }
}

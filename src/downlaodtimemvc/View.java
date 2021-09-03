/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package downlaodtimemvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author Andrea
 */
public class View {
    private JFrame frame;
    private JPanel mainPanel, centralPanel, timePanel, speedPanel, filesizePanel;
    private JLabel timeLabel, speedLabel, filesizeLabel, hoursLabel, minutesLabel, secondsLabel;
    private JTextField hoursTextField, minutesTextField, secondsTextField, speedTextField, filesizeTextField;
    private JComboBox speedComboBox, filesizeComboBox;
    private JButton speedToTimeButton, timeToSpeedButton;
    
    private final String [] speedTypes = {"kbit/s","kByte/s","Mbit/s","MByte/s"};
    private final String [] filesizeTypes = {"B","kB","MB","GB"};
    
    public View(){
        
        //INITIALIZATIONS
        frame = new JFrame("DownloadTime");
        mainPanel = new JPanel(new BorderLayout());
        centralPanel = new JPanel(new GridLayout(6, 0, 0, 0));
        timePanel = new JPanel();
        speedPanel = new JPanel();
        filesizePanel = new JPanel();
        timeLabel = new JLabel("Time", SwingConstants.CENTER);
        speedLabel = new JLabel("Speed", SwingConstants.CENTER);
        filesizeLabel = new JLabel("Filesize", SwingConstants.CENTER);
        hoursLabel = new JLabel("H", SwingConstants.CENTER);
        minutesLabel = new JLabel("M", SwingConstants.CENTER);
        secondsLabel = new JLabel("S", SwingConstants.CENTER);
        hoursTextField = new JTextField();
        minutesTextField = new JTextField();
        secondsTextField = new JTextField();
        speedTextField = new JTextField();
        filesizeTextField = new JTextField();
        speedComboBox = new JComboBox(speedTypes);
        filesizeComboBox = new JComboBox(filesizeTypes);
        speedToTimeButton = new JButton("<html><center>Calculate<br>Time<br>(from Speed)</html>");
        timeToSpeedButton = new JButton("<html><center>Calculate<br>Speed<br>(from Time)</html>");
        
        //FONT
        timeLabel.setFont(new Font(timeLabel.getFont().getFontName(), Font.PLAIN, 18));
        speedLabel.setFont(new Font(speedLabel.getFont().getFontName(), Font.PLAIN, 18));
        filesizeLabel.setFont(new Font(filesizeLabel.getFont().getFontName(), Font.PLAIN, 18));
        hoursLabel.setFont(new Font(hoursLabel.getFont().getFontName(), Font.PLAIN, 18));
        minutesLabel.setFont(new Font(minutesLabel.getFont().getFontName(), Font.PLAIN, 18));
        secondsLabel.setFont(new Font(secondsLabel.getFont().getFontName(), Font.PLAIN, 18));
        hoursTextField.setFont(new Font(hoursTextField.getFont().getFontName(), Font.PLAIN, 18));
        minutesTextField.setFont(new Font(minutesTextField.getFont().getFontName(), Font.PLAIN, 18));
        secondsTextField.setFont(new Font(secondsTextField.getFont().getFontName(), Font.PLAIN, 18));
        speedTextField.setFont(new Font(speedTextField.getFont().getFontName(), Font.PLAIN, 18));
        filesizeTextField.setFont(new Font(filesizeTextField.getFont().getFontName(), Font.PLAIN, 18));
        speedComboBox.setFont(new Font(speedComboBox.getFont().getFontName(), Font.PLAIN, 18));
        filesizeComboBox.setFont(new Font(filesizeComboBox.getFont().getFontName(), Font.PLAIN, 18));
        speedToTimeButton.setFont(new Font(speedToTimeButton.getFont().getFontName(), Font.PLAIN, 18));
        timeToSpeedButton.setFont(new Font(timeToSpeedButton.getFont().getFontName(), Font.PLAIN, 18));
        hoursTextField.setHorizontalAlignment(JTextField.CENTER);
        minutesTextField.setHorizontalAlignment(JTextField.CENTER);
        secondsTextField.setHorizontalAlignment(JTextField.CENTER);
        speedTextField.setHorizontalAlignment(JTextField.CENTER);
        filesizeTextField.setHorizontalAlignment(JTextField.CENTER);
        speedToTimeButton.setHorizontalAlignment(SwingConstants.CENTER);
        timeToSpeedButton.setHorizontalAlignment(SwingConstants.CENTER);
        
        //DIMENSIONS
        filesizeTextField.setPreferredSize(new Dimension(150,30));
        speedTextField.setPreferredSize(new Dimension(150,30));
        hoursTextField.setPreferredSize(new Dimension(40,30));
        minutesTextField.setPreferredSize(new Dimension(40,30));
        secondsTextField.setPreferredSize(new Dimension(40,30));
        
        //BOUNDS
        speedComboBox.setBounds(50, 50, 90, 20);
        centralPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        //ASSEMBLY
        filesizePanel.add(filesizeTextField);
        filesizePanel.add(filesizeComboBox);
        speedPanel.add(speedTextField);
        speedPanel.add(speedComboBox);
        timePanel.add(hoursTextField);
        timePanel.add(hoursLabel);
        timePanel.add(minutesTextField);
        timePanel.add(minutesLabel);
        timePanel.add(secondsTextField);
        timePanel.add(secondsLabel);
        
        centralPanel.add(filesizeLabel);
        centralPanel.add(filesizePanel);
        centralPanel.add(speedLabel);
        centralPanel.add(speedPanel);
        centralPanel.add(timeLabel);
        centralPanel.add(timePanel);
        
        mainPanel.add(timeToSpeedButton, BorderLayout.WEST);
        mainPanel.add(centralPanel, BorderLayout.CENTER);
        mainPanel.add(speedToTimeButton, BorderLayout.EAST);
        
        frame.add(mainPanel);
        
        //LAST SETTINGS AND SHOW
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
    public JButton getSpeedToTimeButton(){
        return speedToTimeButton;
    }
    
    public JButton getTimeToSpeedButton(){
        return timeToSpeedButton;
    }
    
    public JTextField getSpeedTextField(){
        return speedTextField;
    }
    
    public JTextField getFilesizeTextField(){
        return filesizeTextField;
    }
    
    public JTextField getHoursTextField(){
        return hoursTextField;
    }
    
    public JTextField getMinutesTextField(){
        return minutesTextField;
    }
    
    public JTextField getSecondsTextField(){
        return secondsTextField;
    }
    
    public void setSpeed(float speed){
        speedTextField.setText(""+speed);
    }
    
    public void setTime(int hours, int minutes, int seconds){
        hoursTextField.setText(""+hours);
        minutesTextField.setText(""+minutes);
        secondsTextField.setText(""+seconds);
    }
    
    public void setSpeedSelection(int selection){
        speedComboBox.setSelectedIndex(selection);
    }
    
    public void setFilesizeSelection(int selection){
        filesizeComboBox.setSelectedIndex(selection);
    }
    
    public JComboBox getSpeedComboBox(){
        return speedComboBox;
    }
    
    public JComboBox getFilesizeComboBox(){
        return filesizeComboBox;
    }
}

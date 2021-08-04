/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package downlaodtimemvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import javax.swing.JOptionPane;

/**
 *
 * @author Andrea
 */
public class Controller {
    private View view;
    private Model model;

    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;
        
        this.view.setSpeedSelection(this.model.getSpeedSelection());
        this.view.setFilesizeSelection(this.model.getFilesizeSelecion());
        
        addListeners();
    }
    
    public void addListeners(){
        ActionListener timeToSpeedManager, speedToTimeManager;
        
        timeToSpeedManager = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    int hours = Integer.parseInt(view.getHoursTextField().getText());
                    int minutes = Integer.parseInt(view.getMinutesTextField().getText());
                    int seconds = Integer.parseInt(view.getSecondsTextField().getText());
                    
                    model.setTime(hours, minutes, seconds);
                    model.setFilesize(Float.parseFloat(view.getFilesizeTextField().getText()));
                    
                    model.setSpeedSelection(view.getSpeedComboBox().getSelectedIndex());
                    model.setFilesizeSelection(view.getFilesizeComboBox().getSelectedIndex());
                    
                    model.calculateSpeedFromTime();
                    view.setSpeed(model.getSpeed());
                    view.setSpeedSelection(model.getSpeedSelection());
                    
                } catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(null,"Check your data, you must insert decimal or integer numbers (with \".\", not \",\")","Warning",JOptionPane.WARNING_MESSAGE);
                }
            }
        };
        
        speedToTimeManager = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    model.setSpeed(Float.parseFloat(view.getSpeedTextField().getText()));
                    model.setFilesize(Float.parseFloat(view.getFilesizeTextField().getText()));
                    
                    model.setSpeedSelection(view.getSpeedComboBox().getSelectedIndex());
                    model.setFilesizeSelection(view.getFilesizeComboBox().getSelectedIndex());
                    
                    model.calculateTimeFromSpeed();
                    
                    view.setTime(model.getHours(), model.getMinutes(), model.getSeconds());
                    
                } catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(null,"Check your data, you must insert decimal or integer numbers (with \".\", not \",\")","Warning",JOptionPane.WARNING_MESSAGE);
                }
            }
        };
        
        view.getTimeToSpeedButton().addActionListener(timeToSpeedManager);
        view.getSpeedToTimeButton().addActionListener(speedToTimeManager);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package downlaodtimemvc;

/**
 *
 * @author Andrea
 */
public class Model {
    private float speed, filesize;
    private int hours, minutes, seconds;
    private int speedSelection, filesizeSelection;
    
    public Model(){
        speedSelection = 3;
        filesizeSelection = 3;
    }
    
    public void calculateTimeFromSpeed(){
        float speedInKB = convertSpeedToKB();
        float filesizeInKB = convertFilesizeToKB();
        
        seconds = (int)(filesizeInKB/speedInKB);
		
        hours = seconds/(60*60);
        minutes = (seconds%(60*60))/60;
        seconds = (seconds%(60*60))%60;
    }
    
    public void calculateSpeedFromTime(){
        float filesizeInKB = convertFilesizeToKB();
        int totalSeconds = convertTimeInSeconds();
        speed = (filesizeInKB/(float)totalSeconds)/1024;
        
        speedSelection = 3;
    }
    
    private float convertSpeedToKB() {
        switch(speedSelection){
            case 0: return speed/8;
            case 1: return speed;
            case 2: return speed*128;
            case 3: return speed*1024;
        }
        return 0;
    }

    private float convertFilesizeToKB() {
        switch(filesizeSelection){
            case 0: return filesize/1024;
            case 1: return filesize;
            case 2: return filesize*1024;
            case 3: return filesize*1024*1024;
        }
        return 0;
    }

    private int convertTimeInSeconds() {
        return hours*3600 + minutes*60 + seconds;
    }

    public void setTime(int hours, int minutes, int seconds){
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }
    
    public float getSpeed() {
        return speed;
    }

    public int getSpeedSelection() {
        return speedSelection;
    }

    public void setFilesize(float filesize) {
        this.filesize = filesize;
    }

    public void setSpeedSelection(int speedSelection) {
        this.speedSelection = speedSelection;
    }
    
    int getFilesizeSelecion() {
        return filesizeSelection;
    }

    public void setFilesizeSelection(int filesizeSelection) {
        this.filesizeSelection = filesizeSelection;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }
    
    public int getHours() {
        return hours;
    }
    
    public int getMinutes() {
        return minutes;
    }
    
    public int getSeconds() {
        return seconds;
    }

    public float getFilesize() {
        return filesize;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;


import java.io.Serializable;

/**
 *
 * @author rui
 */
public class UserDataBeans implements Serializable {
private int ac; 
    private String name;
    private String year;
    private String month;
    private String day;
    private String type;
    private String tell;
    private String comment;
    
    public UserDataBeans() {
        
    }
    
    public int getIsAccess() {
        return ac;
    }
    
    public void setIsAccess(int isAccess) {
        this.ac = isAccess;
    }
    
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getYear(){
        return year;
    }
    public void setYear(String year){
        this.year = year;
    }
    
    public String getMonth(){
        return month;
    }
    public void setMonth(String month){
        this.month = month;
    }
    
    public String getDay(){
        return day;
    }
    public void setDay(String day){
        this.day = day;
    }
    
    public String getTell(){
        return tell;
    }
    public void setTell(String tell){
        this.tell = tell;
    }
    
    public String getType(){
        return type;
    }
    public void setType(String type){
        this.type = type;
    }
    
    public String getComment(){
        return comment;
    }
    public void setComment(String comment){
        this.comment = comment;
    }
    
}

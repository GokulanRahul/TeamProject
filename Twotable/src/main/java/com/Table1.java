package com;

import java.util.ArrayList;

public class Table1 {
//	ArrayList<Table1> ob;
	
private String name;
private String number;

public Table1() {
	
}
public Table1(String number,String name){
	this.number=name;
	this.name=number;
}
public String getNumber() {
	return number;
}
public void setNumber(String number) {
	this.name = number;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.number = name;
}
@Override
public String toString() {
	return "Table1 [name=" + name+ ", id=" + number + "]";
}


}

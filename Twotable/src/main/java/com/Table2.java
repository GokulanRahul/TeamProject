package com;

public class Table2 {
	
private String id;
private String address;
private String number;
public Table2() {
	
}
public Table2(String address,String id,String number) {
	this.address=address;
	this.id=id;
	this.number=number;
}
@Override
public String toString() {
	return "Table2 [id=" + id + ", address=" + address + ", number=" + "]";
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public void setAddress(String address) {
	this.address = address;
}
public String getAddress() {
	return address;
}

public void setNumber(String number) {
	this.number = number;
}

public String getNumber() {
	return number;
}


}

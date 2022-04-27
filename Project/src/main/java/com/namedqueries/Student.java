package com.namedqueries;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
@NamedQueries(
		{
			@NamedQuery(
					name="findstudentByName",
					query="from Student s where s.sid=:ID1")
		}
		)
@Entity
@Table(name="Student")
public class Student{
//public class Student implements java.io.Serializable{
@Id
private int sid;
private String sname;
private String scity;
public int getSid() {
	return sid;
}
public void setSid(int sid) {
	this.sid = sid;
}
public String getSname() {
	return sname;
}
public void setSname(String sname) {
	this.sname = sname;
}
public String getScity() {
	return scity;
}
public void setScity(String scity) {
	this.scity = scity;
}
@Override
public String toString() {
	return "Student [sid=" + sid + ", sname=" + sname + ", scity=" + scity + "]";
}


}

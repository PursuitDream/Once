package com.rent.servlet;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class ConnectionFactory {
	
	private static String driver;
	private static String url;
	private static String user;
	private static String pass;
	
	static {
		
		try {
			
			String path = ConnectionFactory.class.getResource("/").toString();
			
			SAXReader sax = new SAXReader();
			Document dom = sax.read(new File(path.substring(path.indexOf("/") + 1)+"jdbc.xml"));
			Element root = dom.getRootElement();
			List<Element> c1 = root.elements();
			for(Element e1 : c1){
				
				if(e1.getName().equals("driver")){
					driver =e1.getTextTrim();
				}else if(e1.getName().equals("url")){
					url = e1.getTextTrim();
				}else if(e1.getName().equals("user")){
					user = e1.getTextTrim();
				}else if(e1.getName().equals("pass")){
					pass = e1.getTextTrim();
				}
			}
			Class.forName("com.mysql.jdbc.Driver");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static Connection getConnection(){
		
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rent","root","123456");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	public static void main(String[] args) {
		Connection conn = getConnection();
		System.out.println(conn);
	}
}

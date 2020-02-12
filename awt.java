import java.awt.*;  
import java.awt.event.*; 
import java.sql.*; 
import java.util.Properties;
import java.io.*;
class MyWA extends WindowAdapter
{       
	public void windowClosing(WindowEvent e)
	{ System.exit(1); }

	public void windowClosed(WindowEvent e)
	{ windowClosing(e); }
}




class Act {  

   Frame f;
   TextField deptno,deptname,loc;
	Button first,next,previous,last;

public static void main(String[] args) throws SQLException,ClassNotFoundException,IOException  
    {  Properties p=new Properties();
        FileInputStream fis=new FileInputStream("db.prop");
        p.load(fis);
	String table=p.getProperty("TABLE");



	 Class.forName("oracle.jdbc.driver.OracleDriver");
	    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sys as sysdba","anand");
        Statement st= con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
	ResultSet rs= st.executeQuery("SELECT * From "+table);

       ResultSetMetaData rsmd=rs.getMetaData();
       
	
     Frame f=new Frame("Department");
	   f.setVisible(true);
	   f.setSize(900,900);
	   f.setBackground(new Color(192,192,192));
	   f.setLayout(new FlowLayout());
	   

           MyWA m=new MyWA();
		 f.addWindowListener(m);
           Label l1=new Label("DEPT NO:");
 	    l1.setBounds(50,50,80,30);
           Label l2=new Label("DEPT NAME:"); 
   	      l2.setBounds(50,100,80,30);
	   Label l3=new Label("LOC:");
              l3.setBounds(50,150,80,30);





	   TextField deptno=new TextField(20);
	   deptno.setBounds(130,50,150,30);
	   Button first=new Button("FIRST");
	   //first.setSize(new Dimension(10, 40));
           //first.setPreferredSize(new Dimension(80, 30));
	   //first.setBackground(Color.blue);
	   

	   Button next=new Button("NEXT");
	   first.setBounds(50,200,60,30); 
	   
           Button previous=new Button("PREVIOUS");
	   next.setBounds(120,200,60,30); 
  	   previous.setBounds(190,200,60,30);
	   Button last= new Button("LAST");
	   
	   TextField deptname=new TextField(20);
	    deptname.setBounds(130,100,150,30);
	   TextField loc = new TextField(20);
		loc.setBounds(130,150,150,30);
   	 

            last.setBounds(260,200,60,30);




  
    first.addActionListener(new ActionListener(){  
    public void actionPerformed(ActionEvent e){ 
        try{ rs.first();
            deptno.setText(rs.getString(1)); 
	    deptname.setText(rs.getString(2));
	    loc.setText(rs.getString(3));

 }
	catch(SQLException s){}
    }  
    }); 


    next.addActionListener(new ActionListener(){  
    public void actionPerformed(ActionEvent e){ 
        try{ rs.next();
            deptno.setText(rs.getString(1)); 
	    deptname.setText(rs.getString(2));
	    loc.setText(rs.getString(3));

 }
	catch(SQLException s){}
    }  
    }); 

   
previous.addActionListener(new ActionListener(){  
    public void actionPerformed(ActionEvent e){ 
        try{ rs.previous();
            deptno.setText(rs.getString(1)); 
	    deptname.setText(rs.getString(2));
	    loc.setText(rs.getString(3));

 }
	catch(SQLException s){}
    }  
    }); 


last.addActionListener(new ActionListener(){  
    public void actionPerformed(ActionEvent e){ 
        try{ rs.last();
            deptno.setText(rs.getString(1)); 
	    deptname.setText(rs.getString(2));
	    loc.setText(rs.getString(3));

 }
	catch(SQLException s){}
    }  
    }); 


f.add(l1);
f.add(l2);
f.add(l3);
 f.add(deptno);

f.add(deptname);
	  f.add(loc);
	   f.add(first);
	   f.add(next);
	   f.add(previous);
	   f.add(last);



    
}  
}  
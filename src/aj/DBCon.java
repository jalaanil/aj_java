package aj;

import java.sql.*;  

class DBCon
{  
	public static void main(String args[]){  
		try{  

			DBCon db = new DBCon();
			System.out.println( db.getRecords());
			
		}catch(Exception e){ 
			System.out.println( "error occuredred : detals - :" + e); 
			e.printStackTrace();
		}  
	  
	}  
	
	public String getRecords(){  

		String recs = "";		
		try{  


		MyConfig cf = new MyConfig();
		String dbdriver = cf.getConfig("db.driver");
		String dbconstr = cf.getConfig("db.connectionstr");
		String dbuser = cf.getConfig("db.user");
		String dbpwd = cf.getConfig("db.password");
		String dbsql = cf.getConfig("db.sql");
		
		System.out.println(dbsql);
		
		//step1 load the driver class  
		Class.forName(dbdriver); 
				  
		//step2 create  the connection object  
		Connection con=DriverManager.getConnection(dbconstr,dbuser,dbpwd);
		System.out.println( "connecton succesful" );
			
		//step3 create the statement object  
		Statement stmt=con.createStatement();  
		  
		//step4 execute query  
		ResultSet rs=stmt.executeQuery(dbsql);  
		System.out.println( "resultset succesful" );

		while(rs.next())  			
			recs +=  rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3) + "\n";    
		  
		//step5 close the connection object  
		con.close();  
		  
		}catch(Exception e){ 
			System.out.println( "error occuredred : detals - :" + e); 
			e.printStackTrace();
		} 
		return recs ;	  
	}  

}  
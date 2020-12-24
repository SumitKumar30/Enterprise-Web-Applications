package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;

import login.UserLoginDBObj;

public class UserLoginDBMethods {
	public String DBUser;
	public String DBPswd;
	public String DBUrl ;
	public UserLoginDBMethods(){ }
	public UserLoginDBMethods(String inDBUser, String inDBPswd, String inDBUrl ){
		DBUser = inDBUser ;
		DBPswd = inDBPswd;
		DBUrl  = inDBUrl;
	}
	public void initializeUserLoginDBObj(UserLoginDBObj inUserLoginDBObj ){
		inUserLoginDBObj.user_id =  "";
		inUserLoginDBObj.user_name = "";
		inUserLoginDBObj.old_pswd = "";
		inUserLoginDBObj.new_pswd = "";
	}
	public UserLoginDBObj getRecordByPrimaryKey(String inUserId, String inUserName, String inUserPswd){
		UserLoginDBObj  userLoginDBObj = new UserLoginDBObj();
		try{
			System.out.println("DBUser=="+DBUser+",DBPswd=="+DBPswd+",DBUrl=="+DBUrl);
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn= DriverManager.getConnection(DBUrl,DBUser,DBPswd);
			Statement stmt = conn.createStatement();
			String lSqlString =	"select * from user_login where user_id='"+inUserId+"' and user_name='"+inUserName+"' and new_pswd='"+inUserPswd+"'";
			ResultSet rs  = null;
			rs  = stmt.executeQuery(lSqlString);
			System.out.println("lSqlString====trtrt==within getRecordByPrimaryKey== "+lSqlString);
			if( rs.next()){
				System.out.println("fffff==="+rs.getString("user_id"));
				userLoginDBObj.user_id = rs.getString("user_id");
				userLoginDBObj.user_name = rs.getString("user_name");
				userLoginDBObj.old_pswd = rs.getString("old_pswd");
				userLoginDBObj.new_pswd = rs.getString("new_pswd");
				System.out.println("fffff==="+rs.getString("user_id"));
			}
			else{
				initializeUserLoginDBObj(userLoginDBObj);
			}
				System.out.println("fffff====="+userLoginDBObj.user_id);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return userLoginDBObj;
	}
	
	public int updateUserLoginByPrimaryKey(UserLoginDBObj inUserLoginDBObj){
		int recupd = 0; 
		String lQuery = "";
		lQuery = lQuery +"update user_login set old_pswd='"+inUserLoginDBObj.old_pswd+"'  "; 
		lQuery = lQuery +" , new_pswd='"+inUserLoginDBObj.new_pswd+"' ";
		lQuery = lQuery + "where user_id='"+inUserLoginDBObj.user_id+"' ";
		lQuery = lQuery + "and user_name='"+inUserLoginDBObj.user_name+"' ";
		lQuery = lQuery + "and new_pswd='"+inUserLoginDBObj.old_pswd+"' "; 
		System.out.println("lSqlString===:"+lQuery);
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn= DriverManager.getConnection(DBUrl,DBUser,DBPswd);
			Statement stmt = conn.createStatement();
			recupd  = stmt.executeUpdate(lQuery);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return recupd;
	}
	public UserLoginDBObj populateUserLoginDBObjFromReq(HttpServletRequest inReq){
		UserLoginDBObj  userLoginDBObj = new UserLoginDBObj();
		userLoginDBObj.user_id   =  (String)inReq.getParameter("user_id");
		userLoginDBObj.user_name = (String)inReq.getParameter("user_name"); 
		userLoginDBObj.old_pswd  = (String)inReq.getParameter("old_pswd");
     	userLoginDBObj.new_pswd  = (String)inReq.getParameter("new_pswd");
		return userLoginDBObj;
	}
}

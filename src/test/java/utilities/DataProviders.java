package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;



public class DataProviders {
	
	@DataProvider(name = "Valid_details")
	public Object[][] valid_Data() throws IOException {
		
		String path = "C:\\Users\\user\\Desktop\\opencart\\ddt_register.xlsx";
		ExcelUtils xlutil= new ExcelUtils();
		int no_rows = xlutil.getRowCount(path,"validDet");
		int no_columns = xlutil.getCellCount(path, "validDet", 1);
		Object[][] LoginData= new Object[no_rows-1][no_columns];

		for(int i=1;i<no_rows;i++){
			    for(int j=0;j<no_columns;j++) {
			    	 LoginData[i-1][j] = xlutil.getCellData(path, "validDet", i, j);
			    }
		}
		return LoginData;
	}
	
	@DataProvider(name = "Valid_details2")
	public Object[][] valid_Data2() throws IOException {
		
		String path = "C:\\Users\\user\\Desktop\\opencart\\ddt_register.xlsx";
		ExcelUtils xlutil= new ExcelUtils();
		int no_rows = xlutil.getRowCount(path,"validDet2");
		int no_columns = xlutil.getCellCount(path, "validDet2", 1);
		Object[][] LoginData= new Object[no_rows-1][no_columns];

		for(int i=1;i<no_rows;i++){
			    for(int j=0;j<no_columns;j++) {
			    	 LoginData[i-1][j] = xlutil.getCellData(path, "validDet2", i, j);
			    }
		}
		return LoginData;
	}
	@DataProvider(name = "Valid_details3")
	public Object[][] valid_Data3() throws IOException {
		
		String path = "C:\\Users\\user\\Desktop\\opencart\\ddt_register.xlsx";
		ExcelUtils xlutil= new ExcelUtils();
		int no_rows = xlutil.getRowCount(path,"validDet2");
		int no_columns = xlutil.getCellCount(path, "validDet2", 1);
		Object[][] LoginData= new Object[no_rows-1][no_columns];

		for(int i=1;i<no_rows;i++){
			    for(int j=0;j<no_columns;j++) {
			    	 LoginData[i-1][j] = xlutil.getCellData(path, "validDet2", i, j);
			    }
		}
		return LoginData;
	}
	
	@DataProvider(name = "Register_fname")
	public Object[][] get_f_name_Data() throws IOException {
		
		String path = "C:\\\\Users\\\\user\\\\Desktop\\\\opencart\\\\ddt_register.xlsx";
		ExcelUtils xlutil= new ExcelUtils();
		int no_rows = xlutil.getRowCount(path,"f_name");
		int no_columns = xlutil.getCellCount(path, "f_name", 1);
		Object[][] LoginData= new Object[no_rows-1][no_columns];
		
		for(int i=1;i<no_rows;i++){
			    for(int j=0;j<no_columns;j++) {
			    	 LoginData[i-1][j] = xlutil.getCellData(path, "f_name", i, j);
			    }
		}
		return LoginData;
}
	
	@DataProvider(name = "Register_lname")
	public Object[][] get_l_name_Data() throws IOException {
		
		String path = "C:\\\\Users\\\\user\\\\Desktop\\\\opencart\\\\ddt_register.xlsx";
		ExcelUtils xlutil= new ExcelUtils();
		int no_rows = xlutil.getRowCount(path,"l_name");
		int no_columns = xlutil.getCellCount(path, "l_name", 1);
		Object[][] LoginData= new Object[no_rows-1][no_columns];
		
		for(int i=1;i<no_rows;i++){
			    for(int j=0;j<no_columns;j++) {
			    	 LoginData[i-1][j] = xlutil.getCellData(path, "l_name", i, j);
			    }
		}
		return LoginData;
}
	
	@DataProvider(name = "Register_ph_no")
	public Object[][] get_phone_no() throws IOException {
		
		String path = "C:\\\\Users\\\\user\\\\Desktop\\\\opencart\\\\ddt_register.xlsx";
		ExcelUtils xlutil= new ExcelUtils();
		int no_rows = xlutil.getRowCount(path,"ph_no");
		int no_columns = xlutil.getCellCount(path, "ph_no", 1);
		Object[][] LoginData= new Object[no_rows-1][no_columns];
		
		for(int i=1;i<no_rows;i++){
			    for(int j=0;j<no_columns;j++) {
			    	 LoginData[i-1][j] = xlutil.getCellData(path, "ph_no", i, j);
			    }
		}
		return LoginData;
}
	
	@DataProvider(name = "Register_email")
	public Object[][] get_email() throws IOException {
		
		String path = "C:\\\\Users\\\\user\\\\Desktop\\\\opencart\\\\ddt_register.xlsx";
		ExcelUtils xlutil= new ExcelUtils();
		int no_rows = xlutil.getRowCount(path,"e_mail");
		int no_columns = xlutil.getCellCount(path, "e_mail", 1);
		Object[][] LoginData= new Object[no_rows-1][no_columns];
		
		for(int i=1;i<no_rows;i++){
			    for(int j=0;j<no_columns;j++) {
			    	 LoginData[i-1][j] = xlutil.getCellData(path, "e_mail", i, j);
			    }
		}
		return LoginData;
}
	
	@DataProvider(name = "Already_RegEmail")
	public Object[][] get_reg_email() throws IOException {
		
		String path = "C:\\\\Users\\\\user\\\\Desktop\\\\opencart\\\\ddt_register.xlsx";
		ExcelUtils xlutil= new ExcelUtils();
		int no_rows = xlutil.getRowCount(path,"already_reg");
		int no_columns = xlutil.getCellCount(path, "already_reg", 1);
		Object[][] LoginData= new Object[no_rows-1][no_columns];
		
		for(int i=1;i<no_rows;i++){
			    for(int j=0;j<no_columns;j++) {
			    	 LoginData[i-1][j] = xlutil.getCellData(path, "already_reg", i, j);
			    }
		}
		return LoginData;
}
	@DataProvider(name = "Pwd_invalid")
	public Object[][] get_reg_pwd() throws IOException {
		
		String path = "C:\\\\Users\\\\user\\\\Desktop\\\\opencart\\\\ddt_register.xlsx";
		ExcelUtils xlutil= new ExcelUtils();
		int no_rows = xlutil.getRowCount(path,"pwd_invalid");
		int no_columns = xlutil.getCellCount(path, "pwd_invalid", 1);
		Object[][] LoginData= new Object[no_rows-1][no_columns];
		
		for(int i=1;i<no_rows;i++){
			    for(int j=0;j<no_columns;j++) {
			    	 LoginData[i-1][j] = xlutil.getCellData(path, "pwd_invalid", i, j);
			    }
		}
		return LoginData;
}
	
	@DataProvider(name = "email")
	public Object[] get_email_new() throws IOException {
		
		String path = "C:\\\\Users\\\\user\\\\Desktop\\\\opencart\\\\ddt_register.xlsx";
		ExcelUtils xlutil= new ExcelUtils();
		int no_rows = xlutil.getRowCount(path,"email");
		Object[] LoginData= new Object[no_rows];
		
		for(int i=1;i<no_rows;i++){
			    	 LoginData[i-1] = xlutil.getCellData(path, "email", i,0);
			    }
		return LoginData;
}
	
	@DataProvider(name = "invalid_login")
	public String[][] get_invalidLogin() throws IOException {
		
		String path ="C:\\\\Users\\\\user\\\\Desktop\\\\opencart\\\\ddt_register.xlsx";
		ExcelUtils xlutil= new ExcelUtils();
		int no_rows = xlutil.getRowCount(path,"invalid_login");
		int no_columns = xlutil.getCellCount(path, "invalid_login", 1);
		String[][] LoginData= new String[no_rows][no_columns];
		
		for(int i=1;i<no_rows;i++){
			    for(int j=0;j<no_columns;j++) {
			    	 LoginData[i-1][j] = xlutil.getCellData(path, "invalid_login", i, j);
			    }
		}
		return LoginData;
}
	
	
	
	
	
	  
	
	
	
	
	
	
	
	
}
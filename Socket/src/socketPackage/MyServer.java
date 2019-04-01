package labserver;

import socketPackage.Account;

import java.net.*;
import java.io.*;  
class MyServer{  
	
public static void main(String args[])throws Exception{  
	System.out.println("welcome to server");
	
	ServerSocket ss=new ServerSocket(3333);  
	
	Socket s=ss.accept();  
	
	DataInputStream din=new DataInputStream(s.getInputStream());  
	DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

	Account ac = new Account("Kavi","123gh",1000,"dfr1234");
	  
	String str="",str2="";  
	while(!str.equals("stop"))
	{
		str=din.readUTF();  
		System.out.println("client says: "+str);
		if(str.equals("1"))
		{
			dout.writeUTF("Give the amount to withdraw:");
			str = din.readUTF();
			double amount = Double.parseDouble(str);
			ac.withdraw(amount);
			dout.flush();
			dout.writeUTF(ac.toString());
		}

		else if(str.equals("2"))
		{
			dout.writeUTF("Give the amount to deposit:");
			str = din.readUTF();
			double amount = Double.parseDouble(str);
			ac.deposit(amount);
			dout.flush();
			dout.writeUTF(ac.toString());
		}

		dout.flush();
		dout.writeUTF("1.Withdraw\n2.Deposit");
		//str2=br.readLine();
		//dout.writeUTF(str2);
		//dout.flush();
	}  
	din.close();  
	s.close();  
	ss.close(); 
	
	System.out.println("OK from Server");
	
	}
	
}  
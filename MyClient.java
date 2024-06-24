import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class MyClient
{
	public static void main(String[] args)
	{
		try
		{							
			Socket ser=new Socket("localhost",8000);
			
			DataInputStream dis=new DataInputStream(ser.getInputStream());
			DataOutputStream dos=new DataOutputStream(ser.getOutputStream());
			Scanner scan=new Scanner(System.in);
			
			int a[]=new int[10];
			int i,s,max,min;
			
			for(i=0;i<a.length;i++)
			{
				System.out.print("\n Enter number : ");
				a[i]=scan.nextInt();
				dos.writeInt(a[i]);
			}
			s=dis.readInt();
			max=dis.readInt();
			min=dis.readInt();
			
			System.out.print("\n Sum = "+s);
			System.out.print("\n Max = "+max);
			System.out.print("\n Min = "+min);
			
			dis.close();
			dos.close();
			ser.close();
		}
		catch(Exception e)
		{
			System.out.println("\n CLIENT ERROR : "+e.getMessage());
		}
	}
}
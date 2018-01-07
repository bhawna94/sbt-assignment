
import java.util.Scanner;
import java.sql.*;
class cal
{
 public static void main(String args[])  
  {
   try
     { double result=0;
       String operator=null;
       Scanner sc=new Scanner(System.in);
       Class.forName("com.mysql.jdbc.Driver");
       Connection con= DriverManager.getConnection("jdbc.mysql.//localhost:3306/proj","root","root");
       System.out.println("1.write in database");
       System.out.println("2.read from database");
      
        System.out.println("enter your choice");
        int ch=sc.nextInt();
        switch(ch)
        { case 1: System.out.println("1. ADD");
                  System.out.println("2. SUB");
                  System.out.println("3. MUL");
                  System.out.println("4. DIV");
                  System.out.println("5. MODULUS");
                  System.out.println("6. MAX");
                  System.out.println("7. MIN");;
                  System.out.println("enter type of operation from above menu");
                  int opr=sc.nextInt();
                  System.out.println("enter first number");
                  int a=sc.nextInt();
                  System.out.println("enter second number");
                  int b=sc.nextInt();
                  switch(opr)
                   { case 1:result=a+b;
                            operator="+"; 
                            break;
                     case 2:result=a-b;
                            operator="-";
                            break;
                     case 3:result=a*b;
                            operator="*";
                            break;
                     case 4:result=a/b;
                            operator="/";
                            break;
                     case 5:result=a%b;
                            operator="%";
                            break;
                     case 6:if(a<b)
                            result=b;
                            else
                            result=a;
                            operator="max";
                            break;
                     case 7:if(a<b)
                            result=a;
                            else
                            result=b;
                            operator="min";
                            break;
                      }
                     
                     String sq1="insert into calculator"+"(leftoper,operato_r,rghtoper,result)"+"values(?,?,?,?)";
                     PreparedStatement stmt=con.prepareStatement(sq1);
                     stmt.setInt(1,a);
                     stmt.setString(2,operator);
                     stmt.setInt(3,b);
                     stmt.setDouble(4,result);
                     stmt.executeUpdate();
                     
                     break;

              case 2: System.out.println("choose the operator(+,-,*,/,power,%,max,min)");
                      String search=sc.next();
                      Statement st=con.createStatement();
                      String sq2="select * from calculator where operato_r=" + search;
                      ResultSet rs=st.executeQuery(sq2);
                      while(rs.next())
                       {  System.out.println(rs.getInt(1));
                          System.out.println(rs.getString(2));
                          System.out.println(rs.getInt(3));
                          System.out.println(rs.getDouble(4));

                       }
                       break;
              }
             con.close();
             
     
   }
  catch(Exception e)
  {System.out.println(e);
  }
 }

} 
  
             





      

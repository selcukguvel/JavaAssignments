import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class HelloJava {
	public static void main(String[] args) {
		//Main method reads the each line and splits it word by word.The first word specifies the type of method.
		//After that it separates the parameters for the corresponding method.Then it calls the given static methods.
		//There is an if statement which contains noemptyline<=0.This provides that there won't be any empty line at the end of the output.
		try {
			Scanner scan = new Scanner(new File(args[0]));
			int noemptyline=1;
			while(scan.hasNextLine()){
				String line = scan.nextLine();
				String [] array = line.split("\\s+");
				if(noemptyline<=0)
				System.out.println();
				noemptyline--;
				if(array[0].equals("Armstrong")){
					Integer valuetoarmstrong = Integer.valueOf(array[1]);
					System.out.print(line+" Result: "+(Armstrong(valuetoarmstrong)).trim());
					}
				else if (array[0].equals("IntegrateReimann")){
					String funcvalue = array[1];
					Double first = Double.valueOf(array[2]);
					Double last = Double.valueOf(array[3]);
					Integer partition = Integer.valueOf(array[4]);
					System.out.print(line+" Result: "+IntegrateReimann(funcvalue,first,last,partition));
				}
				else if (array[0].equals("Arcsinh")){
					Double valuetoarcsinh = Double.valueOf(array[1]);
					System.out.print(line+" Result: "+arcsinh(valuetoarcsinh));
			   }
		 }
			scan.close();
		}
		catch (FileNotFoundException ex) {
			System.out.println("No File Found!");
			return;
			}
	}
	public static String Armstrong(int thevalue){
	   //Armstrong method detects the armstrong numbers.The biggest digit number of these numbers is represented by "thevalue".
	   //The method controls all acceptable numbers (which have at most "thevalue" digit.) and detects the number is narcissistic or not.
		int increasingnumber=0;
		String str="";
		for(int digitnumber=1;digitnumber<(thevalue+1);digitnumber++){
			while(digitnumber>Math.log10(increasingnumber)){
				int sum=0;
				if(digitnumber>1){
					String inttostr = String.valueOf(increasingnumber);
					for(int stringseparator=0;stringseparator<digitnumber;stringseparator++){
						Integer backtoint = Integer.valueOf(inttostr.substring(stringseparator,stringseparator+1));
						sum=(int)(sum+Math.pow(backtoint,digitnumber));
						}
					if(sum==increasingnumber){
						str+=sum+" ";
						}
					increasingnumber++;
					}
				else{
					if(increasingnumber==Math.pow(increasingnumber, digitnumber)){
						str+=increasingnumber+" ";
						increasingnumber++;
					}
				}
			}
		}
		return str;
	}
	public static double IntegrateReimann(String funcvalue, double first, double last, int partition) {
			//This method calculates the integral according to given parameters.The logic of calculation is always the same.
			// Yet , the function ("Func1","Func2" or "Func3") to be calculated depends on the "funcvalue" parameter.
			double summation=0.0;
			double partvalue=(last-first)/partition; 	
			double fx=0.0;
			double power=Math.pow(10, 10);
			double lesspower=Math.pow(10,4);
			for(double beginning=first;beginning<last;beginning = Math.round((beginning + partvalue) * power) / power) {
				double becontinued=Math.round((beginning+partvalue) * power) / power;
				double sumhalf = Math.round(((beginning + becontinued)/2) * power) / power;
				if(Math.round(((becontinued) * lesspower)) / lesspower <= last){
				if(funcvalue.equals("Func1")){
				fx=(Math.pow(sumhalf,2)-sumhalf+3);
				}
				else if(funcvalue.equals("Func2")){
				fx=Math.pow((3*(Math.sin(sumhalf))-4),2);
				}
				else if(funcvalue.equals("Func3")){
				fx=arcsinh(sumhalf);
				}
				double totalcalc=fx*partvalue;
				summation=summation+totalcalc;
			  }
				else
					break;
			}
			return summation;
		}
	public static double arcsinh(double x){
		//It calculates the approximation of arcsinh(x) with using the Maclaurin Series.It iterates 30 times to obtain the result.The absolute value
		//of "x" should be less than 1.
		int firstvalue=0; 
		double dsum=0;
		while(firstvalue<30 && Math.abs(x)<1){
			double calc1=(Math.pow(-1,firstvalue))*(factorial(2*firstvalue))*(Math.pow(x,(2*firstvalue)+1));
			double calc2=(Math.pow(4,firstvalue))*(Math.pow(factorial(firstvalue),2))*((2*firstvalue)+1);		
			double result=calc1/calc2;
			dsum=dsum+result;
			firstvalue++;
		}
			return dsum;
	}
	public static int factorial(int value){ 
		//It calculates the factorial value of the "value".
		int total=1;
		int val=1;
		while(val<=value){
			total*=val;
			val++;
		}
		return total;	
	}
}

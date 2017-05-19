package com.tuananh.myATRC;

import java.awt.font.NumericShaper;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;

public class ClassManager
{
	/**
	 * @uml.property  name="myClasses"
	 * @uml.associationEnd  multiplicity="(0 -1)"
	 */
	public MyClass []myClasses;
	/**
	 * @uml.property  name="myInterfaces"
	 * @uml.associationEnd  multiplicity="(0 -1)"
	 */
	public MyInterface [] myInterfaces;
	protected static ClassManager instance= null;
	public static ClassManager getInstance()
	{
		if(instance==null) instance= new ClassManager();
		return instance;
	}
	protected ClassManager()
	{
		myClasses= null;
	}
	
	public void init(String fileName)
	{
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String tmpLine;
			try
			{
				int numberClasses=0;
				int numberInterfaces= 0;
				while((tmpLine=br.readLine())!=null)
				{
					if(tmpLine.contains("@class"))
					{
						numberClasses++;
					}
					else if(tmpLine.contains("@interface"))
					{
						numberInterfaces++;
					}
				}
				
				myClasses= new MyClass[numberClasses];
				myInterfaces = new MyInterface[numberInterfaces];
				numberClasses=0;
				numberInterfaces=0;
				br.reset();
				while((tmpLine=br.readLine())!=null)
				{
					if(tmpLine.contains("@class"))
					{
						String tmpClassLine = br.readLine();
						if(tmpClassLine.contains("@variables"))
						{
							int numberVariable = Integer.parseInt(tmpClassLine.substring("@variables:".length()));
							for(int i=0;i<numberVariable;i++)
							{
								
							}
						}
					}
					else if(tmpLine.contains("@interface"))
					{
						
					}
				}
			}
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Variable[] readParameter(String parameter)//this string have form like (int a, int b)
	{
		Variable [] tmpVariableList ;
		int numberComas=0;
		int [] commaPosition = new int [parameter.length()-1];
		for(int i=1;i<parameter.length()-1;i++)
		{
			if(parameter.charAt(i)==',')
			{
				if(numberComas==0)
				{
					int spacePosition=0;
					String var= parameter.substring(1,i);
					for(int j=0;j<var.length();j++)
					{
						if(var.charAt(j)==' ')
						{
							spacePosition=j++;
							break;
						}
					}	
				}
			}
		}
		tmpVariableList= new Variable[numberComas+1];
		
		return tmpVariableList;
	}
}

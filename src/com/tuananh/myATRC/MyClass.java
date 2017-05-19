package com.tuananh.myATRC;

public class MyClass
{
	/**
	 * @uml.property  name="variables" multiplicity="(0 -1)" dimension="1"
	 */
	public String[] variables;
	/**
	 * @uml.property  name="methods"
	 * @uml.associationEnd  multiplicity="(0 -1)"
	 */
	public Method[] methods;
	
	public MyClass()
	{
		variables= null;
		methods= null;
	}
}

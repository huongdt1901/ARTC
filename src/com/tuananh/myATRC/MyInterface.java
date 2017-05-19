package com.tuananh.myATRC;


public class MyInterface
{
	/**
	 * @uml.property  name="name"
	 */
	public String name;
	/**
	 * @uml.property  name="inheritedInterfaces"
	 * @uml.associationEnd  multiplicity="(0 -1)"
	 */
	public MyInterface[] inheritedInterfaces;
	/**
	 * @uml.property  name="inheritedClasses"
	 * @uml.associationEnd  multiplicity="(0 -1)"
	 */
	public MyClass [] inheritedClasses;
}

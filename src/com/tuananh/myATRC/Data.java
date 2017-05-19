package com.tuananh.myATRC;

import com.microsoft.z3.Context;
import com.microsoft.z3.Z3Exception;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Data
{
	private static Data instance;
	public static Data getInstance()
	{
		if(instance == null)
		{
			instance= new Data();
		}
		return instance;
	}
	
	/**
	 * @uml.property  name="iniInvarant"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	Reader iniInvarant;
	/**
	 * @uml.property  name="evoInvarant"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	Reader evoInvarant;
	/**
	 * @uml.property  name="iniPre"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	Reader iniPre;
	/**
	 * @uml.property  name="iniPost"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	Reader iniPost;
	/**
	 * @uml.property  name="evoPre"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	Reader evoPre;
	/**
	 * @uml.property  name="evoPost"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	Reader evoPost;
	/**
	 * @uml.property  name="ctx"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	Context ctx;
	public Data()
	{
		iniInvarant= new Reader();
		evoInvarant= new Reader();
		iniPre= new Reader();
		iniPost = new Reader();
		evoPre= new Reader();
		evoPost= new Reader();
            try {
                ctx= new Context();
            } catch (Z3Exception ex) {
                Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
            }
	}
}

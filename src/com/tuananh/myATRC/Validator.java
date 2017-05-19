package com.tuananh.myATRC;

import com.microsoft.z3.*;
import java.util.*;

public class Validator
{
	@SuppressWarnings("serial")
	class TestFailedException extends Exception
	{
		public TestFailedException()
		{
			super("Check FAILED");
		}
	};

	public boolean checkInvarants(String Ini, String Evo)
	{
		String tmp1 = Data.getInstance().iniInvarant.standardizedText(Ini);
		String tmp2 = Data.getInstance().iniInvarant.standardizedText(Evo);
		Scanner scanner1 = new Scanner(tmp1);
		/*
		 * check the number of invarants in two string is equal or not
		 */
		String[] numLines1 = tmp1.split("\n");
		String[] numLines2 = tmp2.split("\n");
		if (numLines1.length != numLines2.length)
		{
			scanner1.close();
			return false;
		} else
		{
			//System.out.println("numbers of lines is equal");
		}
		while (scanner1.hasNextLine())
		{
			String tmpLine = scanner1.nextLine();
			if (!tmp2.contains(tmpLine))
			{
				scanner1.close();
				return false;
			}
		}
		scanner1.close();
		return true;
	}
	private Solver loadSMTLIBEncoding(Map<String, String> config, String smtEncoding) throws Z3Exception { 
		 
		  Context context = new Context(config); 
		  Solver solver = context.mkSolver(); 
		  BoolExpr expr = context.parseSMTLIB2String(smtEncoding, null, null, null, null); 
		  solver.add(expr); 
		 
		  return solver; 
		 } 
	public boolean checkPreconditionc(Context ctx, Expr initial, Expr evolution) throws Z3Exception
	{
		Solver solver = Data.getInstance().ctx.mkSolver();
		BoolExpr pre1 = Data.getInstance().ctx.mkImplies((BoolExpr)initial, (BoolExpr)evolution);
		BoolExpr pre2 = Data.getInstance().ctx.mkImplies( (BoolExpr)evolution,(BoolExpr)initial);
		solver.add(pre1);
		solver.add(pre2);
		Status st = solver.check();
		if(st ==Status.SATISFIABLE) return true;
		else return false;
			
	}
	// New
	public boolean checkPrecondition(Context ctx, Expr initial, Expr evolution) throws Z3Exception
	{
		Solver solver = Data.getInstance().ctx.mkSolver();
		System.out.println(solver);
		//BoolExpr pre1 = Data.getInstance().ctx.mkImplies((BoolExpr)initial, (BoolExpr)evolution);
		//BoolExpr pre2 = Data.getInstance().ctx.mkImplies( (BoolExpr)evolution,(BoolExpr)initial);
		BoolExpr pre1 = (BoolExpr)initial;
		BoolExpr pre2 = (BoolExpr)evolution;
		//System.out.println(pre1);
        //System.out.println(pre2);
		//solver.add(pre1);
		//solver.add(pre2);
		//System.out.println("after");
		//System.out.println(solver);
		//Map<String, String> config = new HashMap<String, String>();
		//config.put(pre1.toString(),pre2.toString());
		/*System.out.println(pre1);
        System.out.println(pre2);
		Status st = solver.check();
		
		System.out.println(st);
		//Status st = Status.UNSATISFIABLE;
		try { 
			   //solver = loadSMTLIBEncoding(config, ""); 
			   //st = solver.check(); 
			   //System.out.println(st);
				st = solver.check();
			  } 
			  catch (Z3Exception e) { 
			  } 
		if(st ==Status.SATISFIABLE) return true;
		else return false;*/
		if(pre1.toString().compareTo(pre2.toString())==0)
		return true;
		else return false;
			
	}
	
	public int checkPostCondition(Context ctx, Expr initial, Expr evolution) throws Z3Exception
	{
	Solver solver = Data.getInstance().ctx.mkSolver();
	BoolExpr post1 = (BoolExpr)initial;
	BoolExpr post2 = (BoolExpr)evolution;
	System.out.println("test");
	//System.out.println(post1.toString());
	//System.out.println(post2.toString());
	if(post1.toString().compareTo(post2.toString())==0)
		return 0;
		else return 2;
	}
	public int checkPostConditionc(Context ctx, Expr initial, Expr evolution) throws Z3Exception
	{
		Solver solver = Data.getInstance().ctx.mkSolver();
	BoolExpr post1 = Data.getInstance().ctx.mkImplies((BoolExpr )initial, (BoolExpr)evolution);
	BoolExpr post2 = Data.getInstance().ctx.mkImplies( (BoolExpr)evolution,(BoolExpr)initial);
	//System.out.print(post1);
	//System.out.print(post2);
	solver.add(post1);
	Status st =solver.check();
	//System.out.print(st);
	if(st == Status.SATISFIABLE)
	{
		solver.add(post2);
		Status st2 = solver.check();
		if(st2 == Status.SATISFIABLE) return 0;//2 postconditions are equivalent
		else return 1;//2 initial implies evolution
	}
	else return 2; //not satisfiy
	/*String rv = post2.toString();
	if(post1.toString().equals(rv.toString()))
		return 0;
	else
			return 2;*/
	}
	public Result validateConditions(Context ctx, String iniInvarants, String evoInvarants, Expr iniPre, Expr evoPre, Expr iniPost,  Expr evoPost) throws Z3Exception
	{
//		boolean pre;
//		int post;
		if(!checkInvarants(iniInvarants, evoInvarants)) return Result.UNCONSISTENCY;
		else
		{
			//System.out.println("check1");
			if(!checkPrecondition(ctx, iniPre, evoPre)) return Result.UNCONSISTENCY;
			else
			{
				//System.out.println("check2");
				if(checkPostCondition(ctx, iniPost, evoPost)==0) return Result.TOTAL_CONSISTENCY;
				else return Result.PARTIAL_CONSISTENCY;
			}
		}
	}
};

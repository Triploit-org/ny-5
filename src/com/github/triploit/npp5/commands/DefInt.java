package com.github.triploit.npp5.commands;

import java.util.List;

import com.github.triploit.npp5.Main;
import com.github.triploit.npp5.Objects.Value;
import com.github.triploit.npp5.Objects.Variable;
import com.github.triploit.npp5.other.Err;
import com.github.triploit.npp5.other.LangVars;

public class DefInt 
{
	public static void func(List<String> args, boolean docc)
	{
//		System.out.println("DEFI gefunden!");	
//		
//		for (int i = 0; i < args.size(); i++)
//		{
//			System.out.println("\t["+i+"] "+args.get(i));
//		}
		
		String vname = args.get(1);
		String tvn = vname.substring(0, 1);
		
		if (LangVars.isNumeric(tvn))
		{
			Err.printErr("[ ERR ]:[ DEFI ]:[ DEFINEVAR ]:[ NAME:"+vname+" ] Der Name einer Variable darf nicht mit einer Zahl beginnen!");
			System.exit(0);
		}
		
		String vvalue = args.get(2);
		
		
		if (vvalue.equals("[n]"))
		{
			vvalue = "0";
		}
		
		if (!LangVars.isNumeric(vvalue))
		{
			Err.printErr("[ ERR ]:[ DEFI ]:[ ISSTRING ] Der Wert entspricht nicht dem Typen!");
			System.exit(0);
		}
		
		Variable v = new Variable(vname, new Value(vvalue, true));	
		LangVars lv = Main.getLangVars();
		v.setNumeric(true);
		
		v.getValue().setString(false);
		v.getValue().setNumeric(true);	

		if (docc)
		{
			lv.addCCode("int "+v.getName()+" = "+v.getValue().getValue());
		}
		lv.addLVariable(v);
	}
}
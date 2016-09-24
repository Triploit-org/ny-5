package com.github.triploit.npp5.commands;

import java.util.List;

import com.github.triploit.npp5.Main;
import com.github.triploit.npp5.Objects.Variable;
import com.github.triploit.npp5.other.LangVars;

public class PrintValue 
{
	public static void func(List<String> args)
	{
		//String fun = args.get(1);
		LangVars lv = Main.getLangVars();
		Variable v = lv.getLVariableByName(args.get(1));
		
		if (!v.getName().equals("[NotFound]"))
		{
			System.out.print(v.getValue().getValue());
		}
		else
		{
			System.out.println("[ ERR ]:[ PRV ]:[ VAR ]:[ NOTFOUND ] Variable \""+args.get(1)+"\" konnte nicht gefunden werden!");
		}
	}
}

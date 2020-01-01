package smpl.syntax.ast;

import smpl.syntax.ast.core.Exp;

public class Binding {

    String var;
    Exp valExp;

    public Binding(String id, Exp v) {
	var = id;
	valExp = v;
    }

    public String getVar() {
	return var;
    }

    public Exp getValExp() {
	return valExp;
    }

}

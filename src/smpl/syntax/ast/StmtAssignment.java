package smpl.syntax.ast;

import java.util.ArrayList;

import smpl.syntax.ast.core.Statement;
import smpl.exceptions.VisitException;
import smpl.semantics.Visitor;
import smpl.syntax.ast.core.Exp;

public class StmtAssignment extends Statement {

    ArrayList<String> vars;
    ArrayList<Exp> exps;

    public StmtAssignment(ArrayList<String> ids, ArrayList<Exp> exps) {
        this.vars = ids;
        this.exps = exps;
    }

    public ArrayList<Exp> getExpList() {
        return this.exps;
    }

    public ArrayList<String> getVarList() {
        return this.vars;
    }

    @Override
    public <S, T> T visit(Visitor<S, T> v, S arg) throws VisitException {
        return v.visitStmtAssignment(this, arg);
    }

    @Override
    public String toString() {
        String y = "";
        String x = "";
        for(int i = 0; i<vars.size();i++){
            if(i!=0){
                y+=",";
            }
            y += vars.get(i).toString();
        }
        for(int i = 0; i<exps.size();i++){
            if(i!=0){
                x+=",";
            }
            x += exps.get(i).toString();
        }
        return y + " := " + x + ";";
    }


}
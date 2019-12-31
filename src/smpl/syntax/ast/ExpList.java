package smpl.syntax.ast;

import java.util.ArrayList;
import java.util.Iterator;

import smpl.exceptions.VisitException;
import smpl.semantics.Visitor;
import smpl.syntax.ast.core.Exp;


public class ExpList extends Exp {

    ArrayList<Exp> elements;

    public ExpList(ArrayList<Exp> elements) {
        this.elements = elements;
    }

    public ArrayList<Exp> getElements(){
        return elements;
    }

    @Override
    public <S, T> T visit(Visitor<S, T> v, S arg) throws VisitException {
        return v.visitExpList(this, arg);
    }

    @Override
    public String toString() {
        Iterator<Exp> iter = elements.iterator();

        String result = "";
        while (iter.hasNext()) {
            result = result + iter.next().toString() + ",";
        }

        return "["+result+"]";
    }

}
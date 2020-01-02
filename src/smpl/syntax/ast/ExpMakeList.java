package smpl.syntax.ast;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

import smpl.exceptions.VisitException;
import smpl.semantics.Visitor;
import smpl.syntax.ast.core.Exp;


public class ExpMakeList extends Exp {

    Exp list;

    public ExpMakeList(Exp list) {
        this.list = list;
    }

    public Exp getElements(){
        return elements;
    }

    @Override
    public <S, T> T visit(Visitor<S, T> v, S arg) throws VisitException {
        return v.visitExpMakeList(this, arg);
    }

    @Override
    public String toString() {
        return "list("+list.toString()+")";
    }

}
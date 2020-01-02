package smpl.syntax.ast;

import smpl.exceptions.VisitException;
import smpl.semantics.Visitor;
import smpl.syntax.ast.core.Exp;

import java.util.ArrayList;

public class ExpSubVector extends Exp {

    Exp size, proc;

    public ExpSubVector(Exp size, Exp proc) {
        this.size = size;
        this.proc = proc;
    }

    /**
     * @return the size exp
     */
    public Exp getSize() {
        return size;
    }

    /**
     * @return the procedure exp
     */
    public Exp getProc() {
        return this.proc;
    }

    @Override
    public <S, T> T visit(Visitor<S, T> v, S arg) throws VisitException {
        return v.visitExpSubVector(this, arg);
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return null;
    }

}
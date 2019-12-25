package smpl.syntax.ast;

import smpl.exceptions.VisitException;
import smpl.semantics.Visitor;
import smpl.syntax.ast.core.Exp;

public class ExpAnd extends Exp {

    Exp left, right;

    public ExpAnd(Exp left, Exp right) {
        this.left = left;
        this.right = right;
    }

    public Exp getLeft() {
        return this.left;
    }

    public Exp getRight() {
        return this.right;
    }

    @Override
    public <S, T> T visit(Visitor<S, T> v, S arg) throws VisitException {
        return v.visitExpAnd(this, arg);
    }

    @Override
    public String toString() {
        return left.toString() + " and " + right.toString();
    }

}
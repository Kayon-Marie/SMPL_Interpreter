package smpl.syntax.ast;

import smpl.exceptions.VisitException;
import smpl.semantics.Visitor;
import smpl.syntax.ast.core.Exp;

public class ExpBOr extends Exp {

    Exp left, right;

    public ExpBOr(Exp left, Exp right) {
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
        return v.visitExpBOr(this, arg);
    }

    @Override
    public String toString() {
        return left.toString() + " | " + right.toString();
    }

}
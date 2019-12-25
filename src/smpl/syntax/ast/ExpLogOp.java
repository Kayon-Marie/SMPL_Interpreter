package smpl.syntax.ast;

import smpl.exceptions.VisitException;
import smpl.semantics.Visitor;
import smpl.syntax.ast.core.Exp;

public class ExpLogOp extends Exp {

    Exp left, right;
    String op;

    public ExpLogOp() { this(new ExpBool(true), new ExpBool(true), "or"); }

    // NOT CASE
    public ExpLogOp(Exp left, String op) {
        this.left = left;
        this.right = new ExpRelOp();
        this.op = op;
    }

    // AND / OR CASE
    public ExpLogOp(Exp left, Exp right, String op) {
        this.left = left;
        this.right = right;
        this.op = op;
    }

    /**
     * @return the left
     */
    public Exp getLeft() {
        return left;
    }

    /**
     * @return the op
     */
    public String getOp() {
        return op;
    }

    /**
     * @return the right
     */
    public Exp getRight() {
        return right;
    }

    @Override
    public <S, T> T visit(Visitor<S, T> v, S arg) throws VisitException {
        return v.visitExpLogOp(this, arg);
    }

    @Override
    public String toString() {
        return left.toString() + " " + op + " " + right.toString();
    }
}
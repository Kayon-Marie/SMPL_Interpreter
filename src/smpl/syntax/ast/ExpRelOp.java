package smpl.syntax.ast;

import smpl.exceptions.VisitException;
import smpl.semantics.Visitor;
import smpl.syntax.ast.core.Exp;
import smpl.values.SMPLBool;
import smpl.values.SMPLValue;

public class ExpRelOp extends Exp {

    Exp left, right;
    String sign;
    
    public ExpRelOp(Exp left, Exp right, String sign) {
        this.left = left;
        this.right = right;
        this.sign = sign;
    }

    /**
     * @return the left
     */
    public Exp getLeft() {
        return left;
    }

    /**
     * @return the right
     */
    public Exp getRight() {
        return right;
    }

    /**
     * @return the sign
     */
    public String getSign() {
        return sign;
    }

    @Override
    public <S, T> T visit(Visitor<S, T> v, S arg) throws VisitException {
        return v.visitExpRelOp(this, arg);
    }

    @Override
    public String toString() {
        return left.toString() + " " + sign + " " + right.toString();
    }
}
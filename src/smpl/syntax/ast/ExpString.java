package smpl.syntax.ast;

import smpl.exceptions.TypeException;
import smpl.exceptions.VisitException;
import smpl.semantics.Visitor;
import smpl.syntax.ast.core.Exp;
import smpl.values.SMPLValue;

public class ExpString extends Exp {

    SMPLValue<?> string;

    public ExpString(String val) {
        this.string = SMPLValue.make(val);
    }
 
    public SMPLValue<?> getString() {
        return string;
    }

    @Override
    public <S, T> T visit(Visitor<S, T> v, S arg) throws VisitException {
        return v.visitExpString(this, arg);
    }

    @Override
    public String toString() {
        return "\"" + this.string.toString() + "\"";
    }
}
package smpl.syntax.ast;

import java.io.*;
import smpl.exceptions.TypeException;
import smpl.exceptions.VisitException;
import smpl.semantics.Visitor;
import smpl.syntax.ast.core.Exp;
import smpl.values.SMPLValue;

public class ExpChar extends Exp {

    SMPLValue<?> chr;

    public ExpChar(Character val) {
        this.chr = SMPLValue.make(val);
    }
 
    public SMPLValue<?> getChar() {
        return chr;
    }

    @Override
    public <S, T> T visit(Visitor<S, T> v, S arg) throws VisitException {
        return v.visitExpChar(this, arg);
    }

    @Override
    public String toString() {
        return "#c" + this.chr.toString();
    }
}
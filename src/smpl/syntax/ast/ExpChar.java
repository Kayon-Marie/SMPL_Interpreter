package smpl.syntax.ast;

import java.io.*;

import smpl.exceptions.SMPLException;
import smpl.exceptions.TypeException;
import smpl.exceptions.VisitException;
import smpl.semantics.Visitor;
import smpl.syntax.ast.core.Exp;
import smpl.values.SMPLValue;

public class ExpChar extends Exp{

    SMPLValue<?> chr;

    public ExpChar(Character val) {
        this.chr = SMPLValue.make(val);
    }

    public ExpChar(String val) throws SMPLException {
        if(val.length() > 4 || val.length() < 4){
            throw new SMPLException("Unicode value should be exactly 4 characters");
        }
        else{
            char unicode = (char) Integer.parseInt(val, 16);
            this.chr = SMPLValue.make(unicode);
        }
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
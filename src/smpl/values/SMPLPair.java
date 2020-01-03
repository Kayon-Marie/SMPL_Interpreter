package smpl.values;

import smpl.exceptions.RuntimeException;
import smpl.exceptions.TypeException;

import smpl.values.SMPLValue;
import smpl.values.SMPLType;


public class SMPLPair extends SMPLValue<SMPLPair> {

    SMPLValue<?> left,right;

    public SMPLPair() { this(null,null); }

    public  SMPLPair(SMPLValue<?> left, SMPLValue<?> right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public SMPLType getType() {
        return SMPLType.PAIR;
    }

    public SMPLValue<?> getLeft() throws TypeException {
        return this.left;
    }

    
    public SMPLValue<?> getRight() throws TypeException {
        return this.right;
    }

    public SMPLValue<?> setRight(SMPLValue<?> arg) throws TypeException {
        return this.right = arg;
    }

    public SMPLValue<?> setLeft(SMPLValue<?> arg) throws TypeException {
        return this.left = arg;
    }

    public boolean isNil() {
        return this.left == null && this.right == null;
    }

    @Override
    public boolean boolValue() throws RuntimeException {
        return isNil();
    }

    /* Comparisons based on sign */
    @Override
    public SMPLBool cmp(SMPLValue<?> arg, String sign) throws RuntimeException {
        SMPLBool result = make(false);
        class Exc { void raise(SMPLValue<?> left, SMPLValue<?> right, String sign) throws RuntimeException{ 
            throw new TypeException("Cannot compare " + left + " and " + right + " using " + sign + " operator"); 
        }}
        
        switch (sign) {
            case "<":
                if (arg.isPair()) result = make(getLeft().cmp(((SMPLPair)arg).getLeft(), "<").boolValue());
                else                                new Exc().raise(this, arg, sign);
                break;

            case "<=":
                if (arg.isPair()) result = make(getLeft().cmp(((SMPLPair)arg).getLeft(), "<=").boolValue());
                else                                new Exc().raise(this, arg, sign);
                break;

            case ">":
                if (arg.isPair()) result = make(getLeft().cmp(((SMPLPair)arg).getLeft(), ">").boolValue());
                else                                new Exc().raise(this, arg, sign);
                break;

            case ">=":
                if (arg.isPair()) result = make(getLeft().cmp(((SMPLPair)arg).getLeft(), ">=").boolValue());
                else                                new Exc().raise(this, arg, sign);
                break;

            case "=":
                if (arg.isPair()) result = make(getLeft().cmp(((SMPLPair)arg).getLeft(), "=").boolValue());
                else                                new Exc().raise(this, arg, sign);
                break;

            case "!=":
                if (arg.isPair()) result = make(getLeft().cmp(((SMPLPair)arg).getLeft(), "!=").boolValue());
                else                                new Exc().raise(this, arg, sign);
                break;
            
            default:
                throw new TypeException("Illegal comparison for data types: " + this.getType() + " and " + arg.getType());
        }

        return result;
    }

    @Override
    public String toString() {
        String str = "";
        if (isNil()) {
            str += "#e";
        } else {
            str += PairToString();
        }
        return str;
    }

    public String PairToString() {
        String result = "(";
        if (this.left == null) {
            result += "#el";
        }else{
            result += this.left.toString();
        }
        result += ",";
        if(this.right == null){
            result += "#er";
        }else{
            result += this.right.toString();
        }
        result += ")";
        return result;
    }


}
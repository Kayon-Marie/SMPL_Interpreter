package smpl.values;

import smpl.exceptions.SMPLException;

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

    public SMPLValue<?> getLeft() throws SMPLException {
        return this.left;
    }

    
    public SMPLValue<?> getRight() throws SMPLException {
        return this.right;
    }

    public SMPLValue<?> setRight(SMPLValue<?> arg) throws SMPLException {
        return this.right = arg;
    }

    public SMPLValue<?> setLeft(SMPLValue<?> arg) throws SMPLException {
        return this.right = arg;
    }


    @Override
    public String toString() {
        return new String(getType().toString() + this.left.toString() + "," + this.right.toString());
    }


}
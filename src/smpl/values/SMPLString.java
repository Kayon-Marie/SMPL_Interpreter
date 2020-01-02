package smpl.values;

import smpl.exceptions.RuntimeException;
import smpl.exceptions.TypeException;

public class SMPLString extends SMPLValue<SMPLString>{

    String value;

    public SMPLString() { this("a"); }

    public SMPLString(String value) {
        this.value = value;
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
                if (arg.isChar() || arg.isString()) result = make(value.compareTo(arg.strValue()) < 0);
                else                                new Exc().raise(this, arg, sign);
                break;

            case "<=":
                if (arg.isChar() || arg.isString()) result = make(value.compareTo(arg.strValue()) <= 0);
                else                                new Exc().raise(this, arg, sign);
                break;

            case ">":
                if (arg.isChar() || arg.isString()) result = make(value.compareTo(arg.strValue()) > 0);
                else                                new Exc().raise(this, arg, sign);
                break;

            case ">=":
                if (arg.isChar() || arg.isString()) result = make(value.compareTo(arg.strValue()) >= 0);
                else                                new Exc().raise(this, arg, sign);
                break;

            case "=":
                if (arg.isChar() || arg.isString()) result = make(value.compareTo(arg.strValue()) == 0);
                else                                new Exc().raise(this, arg, sign);
                break;

            case "!=":
                if (arg.isChar() || arg.isString()) result = make(value.compareTo(arg.strValue()) != 0);
                else                                new Exc().raise(this, arg, sign);
                break;
            
            default:
                throw new TypeException("Illegal comparison for data types: " + this.getType() + " and " + arg.getType());
        }

        return result;
    }

    @Override
    public SMPLValue<?> add(SMPLValue<?> arg) throws RuntimeException {
        if (arg.isString() || arg.isChar()) {
            return make(value + arg.strValue());
        } else throw new TypeException(SMPLType.STRING, arg.getType());
    }

    @Override
    public String strValue() throws RuntimeException {
        return this.value;
    }

    @Override
    public SMPLType getType() {
        return SMPLType.STRING;
    }

    @Override
    public String toString() {
        return new String(String.valueOf(value));
    }

}
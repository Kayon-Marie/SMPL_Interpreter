package smpl.values;

import smpl.exceptions.RuntimeException;
import smpl.exceptions.TypeException;

public class SMPLChar extends SMPLValue<SMPLChar>{

    char value;

    public SMPLChar() { this('a'); }

    public SMPLChar(char value) {
        this.value = value;
    }

    @Override
    public boolean boolValue() throws RuntimeException {
        return this.value == 0;
    }

    @Override
    public int intValue() throws RuntimeException {
        return Integer.parseInt("#u" + Integer.toHexString('÷' | 0x10000).substring(1) );
    }

    @Override
    public char charValue() throws RuntimeException {
        return this.value;
    }

    @Override
    public String strValue() throws RuntimeException {
        return Character.toString(this.value);
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
                if (arg.isChar()) result = make(value < arg.charValue());
                else                                new Exc().raise(this, arg, sign);
                break;

            case "<=":
                if (arg.isChar()) result = make(value <= arg.charValue());
                else                                new Exc().raise(this, arg, sign);
                break;

            case ">":
                if (arg.isChar()) result = make(value > arg.charValue());
                else                                new Exc().raise(this, arg, sign);
                break;

            case ">=":
                if (arg.isChar()) result = make(value >= arg.charValue());
                else                                new Exc().raise(this, arg, sign);
                break;

            case "=":
                if (arg.isChar()) result = make(value == arg.charValue());
                else                                new Exc().raise(this, arg, sign);
                break;

            case "!=":
                if (arg.isChar()) result = make(value != arg.charValue());
                else                                new Exc().raise(this, arg, sign);
                break;
            
            default:
                throw new TypeException("Illegal comparison for data types: " + this.getType() + " and " + arg.getType());
        }

        return result;
    }

    @Override
    public SMPLType getType() {
        return SMPLType.CHAR;
    }

    @Override
    public String toString(){
        return new String(getType().toString() + "#c" + String.valueOf(value));
        // return new String(getType().toString() + "#c" + intValue());        
    }

}
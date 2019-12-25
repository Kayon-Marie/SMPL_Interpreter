package smpl.values;

import smpl.exceptions.SMPLException;
import smpl.exceptions.TypeException;

/**
 *
 * @param <T> The type of base Java value wrapped by this class
 * @author --group name here--
 * Created on 10-Dec-2019 at 6:00 PM
 */
public abstract class SMPLValue<T extends SMPLValue<T>> {

    private static final long serialVersionUID = 1L;

    // =========================== //
    // ==     VALUE CREATION    == //
    // =========================== //

    /**
     * Create a SMPLValue wrapping a Integer
     * @param value
     * @return SMPLValue instance to represent a Integer precision value
     */
    public static SMPLInt make(Integer value) {
        return new SMPLInt(value);
    }

    /**
     * Create a SMPLValue wrapping a Double
     * @param value
     * @return SMPLValue instance to represent a Double precision value
     */
    public static SMPLReal make(Double value) {
        return new SMPLReal(value);
    }

    /**
     * 
     * @param value
     * @return SMPLValue instance to represent a boolean value (true #t or false #f)
     */
    public static SMPLBool make(Boolean value) {
        return new SMPLBool(value);
    }
    
    /**
     *
     * @return The type of this value.
     */ 
    public abstract SMPLType getType();
    
    /**
     *
     * @return <code>true</code> if and only if this value is numerically
     * equivalent to an integer
     */
    public boolean isInteger() {
        return getType() == SMPLType.INTEGER;
    }

    /**
     *
     * @return <code>true</code> if and only if this value is numerically
     * equivalent to a real value
     */
    public boolean isReal() {
        return getType() == SMPLType.REAL;
    }

    /**
     * 
     * @return <code>true</code> if and only if this value is a boolean value
     */
    public boolean isBool() {
        return getType() == SMPLType.BOOLEAN;
    }

    // =========================== //
    // == ARITHMETIC OPERATIONS == //
    // =========================== //

    /**
     * Add the given value to this value
     * @param arg The value to be added.
     * @return The sum of the two values as a new instance of FnPlotValue.
     * @throws smpl.exceptions.TypeException if there is a type incompatibility 
     * between this value and the argument value under addition
     */
    public SMPLValue<?> add(SMPLValue<?> arg) throws SMPLException {
        throw new TypeException("Operation div called with non-numeric type");
    }

    /**
     * Subtract the given value from this value.
     * @param arg The value to be subtracted
     * @return The difference as a new instance of FnPlotValue
     * @throws smpl.exceptions.TypeException if there is a type incompatibility 
     * between this value and the argument value under subtraction
     */
    public SMPLValue<?> sub(SMPLValue<?> arg) throws SMPLException {
        throw new TypeException("Operation sub called with non-numeric type");
    }

    /**
     * Negate the given numeric value from this value. Bool values converted to intvalue()
     * @return The difference as a new instance of FnPlotValue
     * @throws smpl.exceptions.TypeException if there is a type incompatibility 
     * between this value and the argument value under subtraction
     */
    public SMPLValue<?> neg() throws SMPLException {
        throw new TypeException("Operation neg called with non-numeric type");
    }

    /**
     * Multiply the given value by this value.
     * @param arg The multiplicand
     * @return The product as a new instance of FnPlotValue
     * @throws smpl.exceptions.TypeException if there is a type incompatibility 
     * between this value and the argument value under multiplication
     */
    public SMPLValue<?> mul(SMPLValue<?> arg) throws SMPLException {
            throw new TypeException("Operation mul called with non-numeric type");
    }

    /**
     * Divide the given value by this value.
     * @param arg The divisor
     * @return The quotient as a new instance of FnPlotValue
     * @throws smpl.exceptions.TypeException if there is a type incompatibility 
     * between this value and the argument value under division
     */
    public SMPLValue<?> div(SMPLValue<?> arg) throws SMPLException {
        throw new TypeException("Operation div called with non-numeric type");
    }
    
    /**
     * Compute the remainder of dividing this value by the given value.
     * @param arg The divisor
     * @return The residue modulo arg as a new instance of FnPlotValue
     * @throws smpl.exceptions.TypeException if there is a type incompatibility 
     * between this value and the argument value under division
     */
    public SMPLValue<?> mod(SMPLValue<?> arg) throws SMPLException {
        throw new TypeException("Operation mod called with non-numeric type");
    }

    /**
     * Compute the exponent by raising this value to the power of the given
     * value.
     * @param arg The exponent
     * @return The base raised by the exponent as an FnPlotValue instance
     * @throws smpl.exceptions.TypeException if there is a type incompatibility 
     * between this value and the argument value under exponentiation
     */
    public SMPLValue<?> pow(SMPLValue<?> arg) throws SMPLException {
        throw new TypeException("Operation pow called with non-numeric type");
    }

    // ======================== //
    // == LOGICAL OPERATIONS == //
    // ======================== //

    /**
     * Performs lgoical op "and" on two Boolean-resolvable SMPLValues
     * @param arg
     * @return
     * @throws SMPLException
     */
    public SMPLValue<?> and(SMPLValue<?> arg) throws SMPLException {
        throw new TypeException("Operation 'and' performed on non SMPLBoolean resolvalble value");
    }

    /**
     * Performs lgoical op "or" on two Boolean-resolvable SMPLValues
     * @param arg
     * @return
     * @throws SMPLException
     */
    public SMPLValue<?> or(SMPLValue<?> arg) throws SMPLException {
        throw new TypeException("Operation 'or' performed on non SMPLBoolean resolvalble value");
    }

    /**
     * Performs lgoical op "not" on a Boolean-resolvable SMPLValue
     * @param arg
     * @return
     * @throws SMPLException
     */
    public SMPLValue<?> not() throws SMPLException {
        throw new TypeException("Operation 'not' performed on non SMPLBoolean resolvalble value");
    }

    // =========================== //
    // ==   RAW VALUE GETTERS   == //
    // =========================== //

    /**
     *
     * @return The integer value wrapped in this FnPlot value
     * @throws smpl.exceptions.TypeException If there is no such integer
     */
    public int intValue() throws SMPLException {
        throw new TypeException(SMPLType.INTEGER, getType());
    }

    /**
     *
     * @return The real value wrapped in this FnPlot value
     * @throws smpl.exceptions.TypeException if there is no such real value.
     */
    public double doubleValue() throws SMPLException {
        throw new TypeException(SMPLType.REAL, getType());
    }

    /**
     * 
     * @return
     * @throws SMPLException
     */
    public boolean boolValue() throws SMPLException {
        throw new TypeException(SMPLType.BOOLEAN, getType());
    }

    /**
     *
     * @return The user defined function wrapped in this FnPlot value.
     * @throws smpl.exceptions.TypeException if there is no such function
     */
    // public SMPLFunction funValue() throws SMPLException {
    //     throw new TypeException(SMPLType.FUNCTION, getType());
    // }

    // =========================== //
    // == RELATIONAL OPERATIONS == //
    // =========================== //

    /**
     * For comparing SMPLValue types
     * @param arg
     * @param sign
     * @return boolean of successful comparison btw 2 SMPLValues
     * @throws SMPLException
     */
    public SMPLValue<?> cmp(SMPLValue<?> arg, String sign) throws SMPLException{
        throw new TypeException("Data type is valid in no comparisons");
    }
}

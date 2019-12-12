package smpl.values;

import smpl.exceptions.VisitException;

/**
 *
 * @param <T> The type of base Java value wrapped by this class
 * @author --group name here--
 * Created on 10-Dec-2019 at 6:00 PM
 */
public abstract class SMPLValue<T extends SMPLValue<T>> {

    private static final long serialVersionUID = 1L;

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
     * @return The type of this value.
     */ 
    public abstract FnPlotType getType();
    
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
     * Add the given value to this value
     * @param arg The value to be added.
     * @return The sum of the two values as a new instance of FnPlotValue.
     * @throws fnplot.sys.FnPlotException if there is a type incompatibility 
     * between this value and the argument value under addition
     */
    public FnPlotValue<?> add(FnPlotValue<?> arg) throws FnPlotException {
        throw new TypeFnPlotException("Operation div called with non-numeric type");
    }

    /**
     * Subtract the given value from this value.
     * @param arg The value to be subtracted
     * @return The difference as a new instance of FnPlotValue
     * @throws fnplot.sys.FnPlotException if there is a type incompatibility 
     * between this value and the argument value under subtraction
     */
    // public FnPlotValue<?> sub(FnPlotValue<?> arg) throws FnPlotException {
    //         throw new TypeFnPlotException("Operation sub called with non-numeric type");
    // }

    /**
     * Negate the given value from this value.
     * @return The difference as a new instance of FnPlotValue
     * @throws fnplot.sys.FnPlotException if there is a type incompatibility 
     * between this value and the argument value under subtraction
     */
//     public FnPlotValue<?> neg() throws FnPlotException {
//         throw new TypeFnPlotException("Operation sub called with non-numeric type");
// }

    /**
     * Multiply the given value by this value.
     * @param arg The multiplicand
     * @return The product as a new instance of FnPlotValue
     * @throws fnplot.sys.FnPlotException if there is a type incompatibility 
     * between this value and the argument value under multiplication
     */
    // public FnPlotValue<?> mul(FnPlotValue<?> arg) throws FnPlotException {
    //         throw new TypeFnPlotException("Operation mul called with non-numeric type");
    // }

    /**
     * Divide the given value by this value.
     * @param arg The divisor
     * @return The quotient as a new instance of FnPlotValue
     * @throws fnplot.sys.FnPlotException if there is a type incompatibility 
     * between this value and the argument value under division
     */
    // public FnPlotValue<?> div(FnPlotValue<?> arg) throws FnPlotException {
    //     throw new TypeFnPlotException("Operation div called with non-numeric type");
    // }
    
    /**
     * Compute the remainder of dividing this value by the given value.
     * @param arg The divisor
     * @return The residue modulo arg as a new instance of FnPlotValue
     * @throws fnplot.sys.FnPlotException if there is a type incompatibility 
     * between this value and the argument value under division
     */
    // public FnPlotValue<?> mod(FnPlotValue<?> arg) throws FnPlotException {
    //     throw new TypeFnPlotException("Operation mod called with non-numeric type");
    // }

    /**
     * Compute the exponent by raising this value to the power of the given
     * value.
     * @param arg The exponent
     * @return The base raised by the exponent as an FnPlotValue instance
     * @throws fnplot.sys.FnPlotException if there is a type incompatibility 
     * between this value and the argument value under exponentiation
     */
    // public FnPlotValue<?> pow(FnPlotValue<?> arg) throws FnPlotException {
    //     throw new TypeFnPlotException("Operation pow called with non-numeric type");
    // }

    /**
     *
     * @return The integer value wrapped in this FnPlot value
     * @throws TypeFnPlotException If there is no such integer
     */
    // public int intValue() throws TypeFnPlotException {
    //     throw new TypeFnPlotException(FnPlotType.INTEGER, getType());
    // }

    /**
     *
     * @return The real value wrapped in this FnPlot value
     * @throws TypeFnPlotException if there is no such real value.
     */
    // public double doubleValue() throws TypeFnPlotException {
    //     throw new TypeFnPlotException(FnPlotType.REAL, getType());
    // }

    /**
     *
     * @return The user defined function wrapped in this FnPlot value.
     * @throws TypeFnPlotException if there is no such function
     */
    // public FnPlotFunction funValue() throws TypeFnPlotException {
    //     throw new TypeFnPlotException(FnPlotType.FUNCTION, getType());
    // }
}

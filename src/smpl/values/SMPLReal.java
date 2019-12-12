package smpl.values;

public class SMPLReal extends SMPLValue<SMPLReal> {

    Double value;

    public SMPLReal() { this(0D); }

    public SMPLReal(Double value) {
        this.value = value;
    }
}
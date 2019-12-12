package smpl.values;

public class SMPLInt extends SMPLValue<SMPLInt> {

    int value;

    public SMPLInt() { this(0); }

    public  SMPLInt(Integer value) {
        this.value = value;
    }


}
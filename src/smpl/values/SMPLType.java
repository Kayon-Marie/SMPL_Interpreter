package smpl.values;

/**
 * Available "built-in" SMPL Types
 * @author --group name--
 */
public enum SMPLType {
    INTEGER("int"),
    REAL("real"),
    FUNCTION("function");

    private final String docString;

    SMPLType(String docString) {
        this.docString = docString;
    }

    /**
     * @return the docString
     */
    public String getDocString() {
        return docString;
    }
}
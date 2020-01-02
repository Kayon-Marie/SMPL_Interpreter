package smpl.builtIn;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

import smpl.values.*;
import smpl.syntax.ast.*;
import smpl.syntax.ast.core.*;
import smpl.semantics.Environment;

public class BuiltIn {

    // Constants
    public static SMPLPair testPair = new SMPLPair(SMPLValue.make(5), SMPLValue.make(10));

    //  Procedures
    public static SMPLProc cdr(Environment env) {
        List<String> id = Arrays.asList("pair");

        // SMPLProc
        // SMPLValue<?> value = new SMPLProc(new ExpProcN(id, new ExpCDR(new ExpVar("pair"))), );
        ExpProc procExp = new ExpProcN(id, new ExpCDR(new ExpVar("pair")));
        SMPLProc value = new SMPLProc(procExp, env );
        return value;
    }


}


package br.ufc.comp.qalc.frontend.token;

public class RparentToken extends Token {

    public RparentToken(long line, long start, String value) throws IllegalArgumentException {
        super(line, start, value);
    }

    public String getRparentToken(){
        return stringValue;
    }

    @Override
    public String getTokenIdentifier() {
        return "RPAREN";
    }
}
package br.ufc.comp.qalc.frontend.token;

public class LparentToken extends Token {

    public LparentToken(long line, long start, String value) throws IllegalArgumentException {
        super(line, start, value);
    }

    public String getLparentToken(){
        return stringValue;
    }

    @Override
    public String getTokenIdentifier() {
        return "LPAREN";
    }
}
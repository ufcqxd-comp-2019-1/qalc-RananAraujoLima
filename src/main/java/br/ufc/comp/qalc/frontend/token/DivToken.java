package br.ufc.comp.qalc.frontend.token;

public class DivToken extends Token {

    public DivToken(long line, long start, String value) throws IllegalArgumentException {
        super(line, start, value);
    }


    public String getDivToken(){
        return stringValue;
    }

    @Override
    public String getTokenIdentifier() {
        return "DIV";
    }
}
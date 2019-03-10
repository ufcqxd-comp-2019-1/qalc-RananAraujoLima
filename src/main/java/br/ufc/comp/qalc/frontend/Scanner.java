package br.ufc.comp.qalc.frontend;

import br.ufc.comp.qalc.frontend.token.*;

import java.io.IOException;

/**
 * Analisador Léxico da linguagem.
 * <p>
 * Funciona como uma fonte de tokens, de onde o Analisador Sintático
 * deverá ler.
 *
 * @see Source
 */
public class Scanner {

    /**
     * Último token reconhecido.
     */
    protected Token currentToken;
    /**
     * Fonte de caracteres de onde extrair os tokens.
     */
    protected Source source;

    /**
     * Constrói um Analisador Léxico a partir de uma fonte de caracteres.
     *
     * @param sourceStream Fonte a ser utilizada.
     */
    public Scanner(Source sourceStream) {
        // FIXME Lidar corretamente com as exceções.
        this.source = sourceStream;
    }

    /**
     * Consome caracteres da fonte até que eles componham um lexema de
     * um dos tokens da linguagem, coinstrói um objeto representando esse
     * token associado ao lexema lido e o retorna.
     *
     * @return Token reconhecido.
     * @throws IOException Caso haja problema na leitura da fonte.
     */
    public Token getNextToken() throws IOException {
        // TODO Reconhecimento de tokens

        if (source.getCurrentChar() == Source.EOF) {
            return new EOFToken(source.getCurrentLine(), source.getCurrentColumn());
        } else if (Character.isDigit(source.getCurrentChar())) { // NumberToken
            StringBuilder lexema = new StringBuilder();

            long currentLine = source.getCurrentLine();
            long lexemeStart = source.getCurrentColumn();

            do {
                lexema.append(source.getCurrentChar());
                source.advance();
            } while (Character.isDigit(source.getCurrentChar()));

            String stringValue = lexema.toString();

            return new NumberToken(currentLine, lexemeStart, stringValue);
        } else if (source.getCurrentChar() == ('$')) {  //(VARID)
            StringBuilder lexema = new StringBuilder();
            lexema.append(source.getCurrentChar());
            source.advance();
            if (Character.isAlphabetic(source.getCurrentChar())) {

                long currentLine = source.getCurrentLine();
                long lexemeStart = source.getCurrentColumn();

                do {
                    lexema.append(source.getCurrentChar());
                    source.advance();
                } while (Character.isAlphabetic(source.getCurrentChar()));

                String stringValue = lexema.toString();
                return new VariableIdentifierToken(currentLine, lexemeStart, stringValue);
            } else if (Character.isDigit(source.getCurrentChar()) || source.getCurrentChar() == '?') {//(Resid)
                long currentLine = source.getCurrentLine();
                long lexemeStart = source.getCurrentColumn();

                do {
                    lexema.append(source.getCurrentChar());
                    source.advance();
                } while (Character.isDigit(source.getCurrentChar()) || source.getCurrentChar() == '?');

                String stringValue = lexema.toString();

                if (Double.parseDouble(stringValue.substring(1)) == 0) {
                    System.out.println("Sequencia com zeros não permitida");
                    System.exit(0);
                }
                return new ResultIdentifierToken(currentLine, lexemeStart, stringValue);

            }
        } else if (source.getCurrentChar() == '@') {//(FUNCID)
            StringBuilder lexema = new StringBuilder();
            lexema.append(source.getCurrentChar());
            source.advance();
            if (Character.isDigit(source.getCurrentChar())) {
                long currentLine = source.getCurrentLine();
                long lexemeStart = source.getCurrentColumn();

                do {
                    lexema.append(source.getCurrentChar());
                    source.advance();
                } while (Character.isLetter(source.getCurrentChar()));

                String stringValue = lexema.toString();
                return new FunctionIdentifierToken(currentLine, lexemeStart, stringValue);
            } else if (Character.isAlphabetic(source.getCurrentChar())) {

                long currentLine = source.getCurrentLine();
                long lexemeStart = source.getCurrentColumn();

                do {
                    lexema.append(source.getCurrentChar());
                    source.advance();
                } while (Character.isLetter(source.getCurrentChar()));

                String stringValue = lexema.toString();
                return new FunctionIdentifierToken(currentLine, lexemeStart, stringValue);
            }

        } else if (source.getCurrentChar() == '=') {//(ATRIB)
            StringBuilder lexema = new StringBuilder();
            lexema.append(source.getCurrentChar());
            long currentLine = source.getCurrentLine();
            long lexemeStart = source.getCurrentColumn();
            String stringValue = lexema.append(source.getCurrentChar()).toString();

            return new AtribToken(currentLine, lexemeStart, stringValue);
        }  else if (source.getCurrentChar() == '-') {//(MINIUS)
            StringBuilder lexem = new StringBuilder();
            long currentLine = source.getCurrentLine();
            long lexemStart = source.getCurrentColumn();
            String stringValue = lexem.append(source.getCurrentChar()).toString();

            return new MinusToken(currentLine, lexemStart, stringValue);
        } else if (source.getCurrentChar() == '+') {//(PLUS)
            StringBuilder lexema = new StringBuilder();
            lexema.append(source.getCurrentChar());
            long currentLine = source.getCurrentLine();
            long lexemeStart = source.getCurrentColumn();
            String stringValue = lexema.append(source.getCurrentChar()).toString();

            return new PlusToken(currentLine, lexemeStart, stringValue);

        } else if (source.getCurrentChar() == '%') {//(MOD)
            StringBuilder lexema = new StringBuilder();
            lexema.append(source.getCurrentChar());
            long currentLine = source.getCurrentLine();
            long lexemeStart = source.getCurrentColumn();
            String stringValue = lexema.append(source.getCurrentChar()).toString();

            return new MinusToken(currentLine, lexemeStart, stringValue);

        }else if (source.getCurrentChar() == '/') {//(DIV)
            StringBuilder lexema = new StringBuilder();
            lexema.append(source.getCurrentChar());
            long currentLine = source.getCurrentLine();
            long lexemeStart = source.getCurrentColumn();
            String stringValue = lexema.append(source.getCurrentChar()).toString();

            return new DivToken(currentLine, lexemeStart, stringValue);

        }else if (source.getCurrentChar() == '*') {//(TIMES)
            StringBuilder lexema = new StringBuilder();
            lexema.append(source.getCurrentChar());
            long currentLine = source.getCurrentLine();
            long lexemeStart = source.getCurrentColumn();
            String stringValue = lexema.append(source.getCurrentChar()).toString();

            return new TimesToken(currentLine, lexemeStart, stringValue);

        }else if (source.getCurrentChar() == '^') {//(POW)
            StringBuilder lexema = new StringBuilder();
            lexema.append(source.getCurrentChar());
            long currentLine = source.getCurrentLine();
            long lexemeStart = source.getCurrentColumn();
            String stringValue = lexema.append(source.getCurrentChar()).toString();

            return new TimesToken(currentLine, lexemeStart, stringValue);

        }else if (source.getCurrentChar() == '(') {//(LPARENT)
            StringBuilder lexema = new StringBuilder();
            lexema.append(source.getCurrentChar());
            long currentLine = source.getCurrentLine();
            long lexemeStart = source.getCurrentColumn();
            String stringValue = lexema.append(source.getCurrentChar()).toString();

            return new LparentToken(currentLine, lexemeStart, stringValue);
        }else if (source.getCurrentChar() == ')') {//(RPARENT)
            StringBuilder lexema = new StringBuilder();
            lexema.append(source.getCurrentChar());
            long currentLine = source.getCurrentLine();
            long lexemeStart = source.getCurrentColumn();
            String stringValue = lexema.append(source.getCurrentChar()).toString();

            return new RparentToken(currentLine, lexemeStart, stringValue);
        }else if (source.getCurrentChar() == ',') {//(COMMA)
            StringBuilder lexema = new StringBuilder();
            lexema.append(source.getCurrentChar());
            long currentLine = source.getCurrentLine();
            long lexemeStart = source.getCurrentColumn();
            String stringValue = lexema.append(source.getCurrentChar()).toString();

            return new CommaToken(currentLine, lexemeStart, stringValue);
        }else if (source.getCurrentChar() == ';') {//(SEMI)
            StringBuilder lexema = new StringBuilder();
            lexema.append(source.getCurrentChar());
            long currentLine = source.getCurrentLine();
            long lexemeStart = source.getCurrentColumn();
            String stringValue = lexema.append(source.getCurrentChar()).toString();

            return new CommaToken(currentLine, lexemeStart, stringValue);
        }
        return null;
        }

        // TODO Recuperação de erros.


        /**
         * Obtém o último token reconhecido.
         *
         * @return O último token reconhecido.
         */
        public Token getCurrentToken () {
            return currentToken;
        }
    }


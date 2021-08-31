package futebol;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PosicaoTest {

    @Test
    void deveRetornarNomePosicaoNula(){
        try{
            Posicao posicao = new Posicao(null);
            fail();
        }
        catch (IllegalArgumentException e){
            assertEquals("Posição é obrigatória",e.getMessage());
        }
    }

    @Test
    void deveRetornarSetNomePosicaoNula(){
        try{
            Posicao posicao = new Posicao("Atacante");
            posicao.setNome(null);
            fail();
        }
        catch (IllegalArgumentException e){
            assertEquals("Posição é obrigatória",e.getMessage());
        }
    }

}
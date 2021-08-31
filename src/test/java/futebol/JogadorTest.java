package futebol;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JogadorTest {
    @Test
    void deveRetornarNomeJogadorNulo(){
        try{
            Posicao posicao = new Posicao("Atacante");
            Jogador jogador = new Jogador(null,posicao);
            fail();
        }
        catch (IllegalArgumentException e){
            assertEquals("Nome é obrigatório",e.getMessage());
        }
    }

    @Test
    void deveRetornarSetNomeJogadorNulo(){
        try{
            Posicao posicao = new Posicao("Atacante");
            Jogador jogador = new Jogador("Neymar",posicao);
            jogador.setNome(null);
            fail();
        }
        catch (IllegalArgumentException e){
            assertEquals("Nome é obrigatório",e.getMessage());
        }
    }

    @Test
    void deveRetornarPosicaoJogadorNulo(){
        try{
            Jogador jogador = new Jogador("Neymar",null);
            fail();
        }
        catch (IllegalArgumentException e){
            assertEquals("Posição é obrigatório",e.getMessage());
        }
    }

    @Test
    void deveRetornarSetPosicaoJogadorNulo(){
        try{
            Posicao posicao = new Posicao("Atacante");
            Jogador jogador = new Jogador("Neymar",posicao);
            jogador.setPosicao(null);
            fail();
        }
        catch (IllegalArgumentException e){
            assertEquals("Posição é obrigatório",e.getMessage());
        }
    }

    @Test
    void deveRetornarRelacionamentoJogadorClube(){
        Posicao posicao = new Posicao("Atacante");
        Jogador jogador = new Jogador("Neymar",posicao);
        Clube clube = new Clube("Psg");

        jogador.adicionarClube(clube);

        assertTrue(jogador.verificaClube(clube));
        assertTrue(clube.verificaJogador(jogador));
    }

    @Test
    void deveRetornarRemocaoDeClubeDoJogador(){
        Posicao posicao = new Posicao("Atacante");
        Jogador jogador = new Jogador("Neymar",posicao);

        Clube clube = new Clube("Psg");


        jogador.adicionarClube(clube);
        jogador.removerClube();

        assertFalse(jogador.verificaClube(clube));
        assertFalse(clube.verificaJogador(jogador));
    }


    @Test
    void deveRetornarExcecaoJogarSemClube(){
        try{
            Posicao posicao = new Posicao("Atacante");
            Jogador jogador = new Jogador("Neymar",posicao);

            jogador.jogar();
            fail();
        }
        catch (IllegalArgumentException e ){
            assertEquals("O jogador precisa estar em algum clube", e.getMessage());
        }
    }

    @Test
    void deveRetornarJogos(){
        Posicao posicao = new Posicao("Atacante");
        Jogador jogador = new Jogador("Neymar",posicao);
        Clube clube = new Clube("Psg");

        jogador.adicionarClube(clube);

        jogador.jogar();
        jogador.jogar();

        assertEquals(2, jogador.getQuantidadeJogos());
    }

    @Test
    void deveRetornarExcecaoMarcarGolSemClube(){
        try{
            Posicao posicao = new Posicao("Atacante");
            Jogador jogador = new Jogador("Neymar",posicao);

            jogador.marcarGol();
            fail();
        }
        catch (IllegalArgumentException e ){
            assertEquals("O jogador precisa estar em algum clube", e.getMessage());
        }
    }

    @Test
    void deveRetornarExcecaoMarcarGolSemEstarJogando(){
        try{
            Posicao posicao = new Posicao("Atacante");
            Jogador jogador = new Jogador("Neymar",posicao);
            Clube clube = new Clube("Psg");

            jogador.adicionarClube(clube);
            jogador.marcarGol();
            fail();
        }
        catch (IllegalArgumentException e ){
            assertEquals("O jogador precisa estar atuando", e.getMessage());
        }
    }

    @Test
    void deveRetornarGolsMarcados(){
        Posicao posicao = new Posicao("Atacante");
        Jogador jogador = new Jogador("Neymar",posicao);
        Clube clube = new Clube("Psg");

        jogador.adicionarClube(clube);

        jogador.jogar();
        jogador.marcarGol();
        jogador.marcarGol();

        assertEquals(2, jogador.getQuantidadeGols());
    }



    @Test
    void deveRetornarExcecaoContabilizarTituloSemClube(){
        try{
            Posicao posicao = new Posicao("Atacante");
            Jogador jogador = new Jogador("Neymar",posicao);

            jogador.contabilizarTitulo();
            fail();
        }
        catch (IllegalArgumentException e ){
            assertEquals("O jogador precisa estar em algum clube", e.getMessage());
        }
    }

    @Test
    void deveRetornarContabilizacaoDeTitulo(){
        Posicao posicao = new Posicao("Atacante");
        Jogador jogador = new Jogador("Neymar",posicao);
        Clube clube = new Clube("Psg");

        jogador.adicionarClube(clube);
        jogador.contabilizarTitulo();
        jogador.contabilizarTitulo();
        jogador.contabilizarTitulo();

        assertEquals(3, jogador.getQuantidadeTitulos());
    }


    @Test
    void deveRetornarFalsoCalcularSalarioJogadorSemClube(){
        try{
            Posicao posicao = new Posicao("Atacante");
            Jogador jogador = new Jogador("Neymar",posicao);
            jogador.calcularSalario();
            fail();
        }
        catch (IllegalArgumentException e ){
            assertEquals("O jogador precisa estar em algum clube", e.getMessage());
        }
    }


    @Test
    void deveRetornarCalcularSalarioJogador(){
        Posicao posicao = new Posicao("Atacante");
        Jogador jogador = new Jogador("Neymar",posicao);
        Clube clube = new Clube("Psg");

        jogador.adicionarClube(clube);
        jogador.calcularSalario();

        assertEquals(10000f,jogador.getSalario());
    }

    @Test
    void deveRetornarCalcularSalarioJogadorAtacante(){
        Posicao posicao = new Posicao("Atacante");
        Jogador jogador = new Jogador("Neymar",posicao);
        Clube clube = new Clube("Psg");

        jogador.adicionarClube(clube);

        jogador.jogar();
        jogador.marcarGol();
        jogador.marcarGol();
        assertEquals(12000f,jogador.getSalario());
    }

    @Test
    void deveRetornarCalcularSalarioJogadorDefensor(){
        Posicao posicao = new Posicao("Defensor");
        Jogador jogador = new Jogador("Neymar",posicao);
        Clube clube = new Clube("Psg");

        jogador.adicionarClube(clube);

        jogador.jogar();
        jogador.jogar();
        jogador.jogar();
        assertEquals(11500f,jogador.getSalario());
    }

    @Test
    void deveRetornarExcecaoRenovacaoContratualSemClube(){
        try{
            Posicao posicao = new Posicao("Defensor");
            Jogador jogador = new Jogador("Neymar",posicao);

            jogador.renovarContrato();
            fail();
        }
        catch(IllegalArgumentException e){
            assertEquals("O jogador precisa estar em algum clube", e.getMessage());
        }
    }

    @Test
    void deveRetornarExcecaoRenovacaoContratualSemJogosSuficientes(){
        try{
            Posicao posicao = new Posicao("Defensor");
            Jogador jogador = new Jogador("Neymar",posicao);
            Clube clube = new Clube("Psg");

            jogador.adicionarClube(clube);

            jogador.setQuantidadeJogos(100);
            jogador.renovarContrato();
            fail();
        }
        catch(IllegalArgumentException e){
            assertEquals("O jogador não atingiu o limite de jogos para renovação", e.getMessage());
        }
    }

    @Test
    void deveRetornarRenovacaoContratual(){
        Posicao posicao = new Posicao("Defensor");
        Jogador jogador = new Jogador("Neymar",posicao);
        Clube clube = new Clube("Psg");

        jogador.adicionarClube(clube);

        jogador.setQuantidadeJogos(101);
        jogador.renovarContrato();

        assertEquals(1, jogador.getTempoDeContratoEmAno());
    }
}
package futebol;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClubeTest {
    @Test
    void deveRetornarNomeClubeNulo(){
        try{
            Clube clube = new Clube(null);
            fail();
        }
        catch (IllegalArgumentException e){
            assertEquals("Nome de clube é obrigatório",e.getMessage());
        }
    }

    @Test
    void deveRetornarSetNomeClubeNulo(){
        try{
            Clube clube = new Clube("PSG");
            clube.setNome(null);
            fail();
        }
        catch (IllegalArgumentException e){
            assertEquals("Nome de clube é obrigatório",e.getMessage());
        }
    }


    @Test
    void deveRetornarRelacionamentoClubeJogador(){
        Clube clube = new Clube("Psg");
        Posicao posicao = new Posicao("Atacante");
        Jogador jogador = new Jogador("Neymar",posicao);

        clube.adicionarJogador(jogador);

        assertTrue(clube.verificaJogador(jogador));
        assertTrue(jogador.verificaClube(clube));
    }

    @Test
    void deveRetornarRelacionamentoClubeJogadores(){
        Clube clube = new Clube("Psg");
        Posicao posicao = new Posicao("Atacante");
        Jogador jogador1 = new Jogador("Neymar",posicao);
        Jogador jogador2 = new Jogador("Messi",posicao);

        List<Jogador> jogadores = Arrays.asList(jogador1,jogador2);

        clube.adicionarJogador(jogadores);

        assertTrue(clube.verificaJogador(jogador1));
        assertTrue(clube.verificaJogador(jogador2));
        assertTrue(jogador1.verificaClube(clube));
        assertTrue(jogador2.verificaClube(clube));
    }

    @Test
    void deveRemoverJogadorDoClube(){
        Clube clube = new Clube("Psg");
        Posicao posicao = new Posicao("Atacante");
        Jogador jogador = new Jogador("Neymar",posicao);

        clube.adicionarJogador(jogador);
        clube.removerJogador(jogador);

        assertFalse(clube.verificaJogador(jogador));
        assertFalse(jogador.verificaClube(clube));
    }


    @Test
    void deveRetornarClubeSemAtacantes(){
        Clube clube = new Clube("Psg");

        List<Jogador> jogadores = new ArrayList<Jogador>();

        assertEquals(jogadores, clube.atacantes());
    }

    @Test
    void deveRetornarAtacantesDoClube(){
        Clube clube = new Clube("Psg");
        Posicao posicao1 = new Posicao("Atacante");
        Posicao posicao2 = new Posicao("Defensor");

        Jogador jogador1 = new Jogador("Messi",posicao1);
        Jogador jogador2 = new Jogador("Neymar",posicao1);
        Jogador jogador3 = new Jogador("Sérgio Ramos",posicao2);

        List<Jogador> atacantes = Arrays.asList(jogador1,jogador2);

        clube.adicionarJogador(atacantes);
        clube.adicionarJogador(jogador3);

        assertEquals(atacantes, clube.atacantes());
    }

    @Test
    void deveRetornarClubeSemDefensores(){
        Clube clube = new Clube("Psg");

        List<Jogador> jogadores = new ArrayList<Jogador>();

        assertEquals(jogadores, clube.defensores());
    }

    @Test
    void deveRetornarDefensoresDoClube(){
        Clube clube = new Clube("Psg");
        Posicao posicao1 = new Posicao("Defensor");
        Posicao posicao2 = new Posicao("Atacante");

        Jogador jogador1 = new Jogador("Sérgio Ramos",posicao1);
        Jogador jogador2 = new Jogador("Hakimi",posicao1);
        Jogador jogador3 = new Jogador("Messi",posicao2);

        List<Jogador> defensores = Arrays.asList(jogador1,jogador2);
        clube.adicionarJogador(defensores);
        clube.adicionarJogador(jogador3);

        assertEquals(defensores, clube.defensores());
    }

    @Test
    void deveRetornarJogadoresElenco(){
        Clube clube = new Clube("Psg");

        Posicao posicao1 = new Posicao("Atacante");
        Posicao posicao2 = new Posicao("Defensor");

        Jogador jogador1 = new Jogador("Messi",posicao1);
        Jogador jogador2 = new Jogador("Neymar",posicao1);
        Jogador jogador3 = new Jogador("Sérgio Ramos",posicao2);

        List<Jogador> jogadores = Arrays.asList(jogador1,jogador2,jogador3);
        clube.adicionarJogador(jogadores);

        assertEquals(jogadores, clube.getJogadores());
    }

    @Test
    void deveRetornarRelacionamentoClubeMedico(){
        Clube clube = new Clube("Psg");
        Medico medico = new Medico("Marco");

        clube.adicionarMedico(medico);

        assertEquals(medico, clube.getMedico());
        assertEquals(clube, medico.getClube());

    }

    @Test
    void deveRemoverMedicoDoClube(){
        Clube clube = new Clube("Psg");
        Medico medico = new Medico("Marco");

        clube.adicionarMedico(medico);
        clube.removerMedico(medico);

        assertNull(clube.getMedico());
        assertNull(medico.getClube());
    }

    @Test
    void deveRetornarRelacionamentoClubeMassagista(){
        Clube clube = new Clube("Psg");
        Massagista massagista = new Massagista("Marco");

        clube.adicionarMassagista(massagista);

        assertEquals(massagista, clube.getMassagista());
        assertEquals(clube, massagista.getClube());
    }

    @Test
    void deveRemoverMassagistaDoClube(){
        Clube clube = new Clube("Psg");
        Massagista massagista = new Massagista("Antonio");

        clube.adicionarMassagista(massagista);
        clube.removerMassagista(massagista);

        assertNull(clube.getMassagista());
        assertNull(massagista.getClube());
    }

    @Test
    void deveAdicionarCampeonatoNoClube() {
        Clube clube = new Clube("Psg");
        Campeonato campeonato = new Campeonato("Brasileirão");

        clube.adicionarCampeonato(campeonato);

        assertTrue(clube.verificarCampeonato(campeonato));
        assertTrue(campeonato.verificarClube(clube));
    }

    @Test
    void deveRemoverCampeonatoNoClube() {
        Clube clube = new Clube("Psg");
        Campeonato campeonato = new Campeonato("Brasileirão");

        clube.adicionarCampeonato(campeonato);
        clube.removerCampeonato(campeonato);

        assertFalse(clube.verificarCampeonato(campeonato));
        assertFalse(campeonato.verificarClube(clube));
    }


}
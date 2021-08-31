package futebol;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FolhaDePagamentoTest {
    @Test
    void deveRetornarFolhaDePagamentoComSomenteOsJogadoresClube(){
        Posicao posicao = new Posicao("Atacante");
        Jogador jogador1 = new Jogador("Messi",posicao);
        Jogador jogador2 = new Jogador("Neymar",posicao);
        Jogador jogador3 = new Jogador("Mbappe",posicao);

        Clube clube = new Clube("Psg");

        List<Jogador> jogadores = Arrays.asList(jogador1,jogador2,jogador3);

        clube.adicionarJogador(jogadores);

        FolhaDePagamento folhaDePagamento = new FolhaDePagamento();

        assertEquals(30000f,folhaDePagamento.calculaFolhaSalarial(clube));
    }

    @Test
    void deveRetornarFolhaDePagamentoComSomenteOMedicoClube(){

        Clube clube = new Clube("Psg");
        Medico medico = new Medico("Marco");
        clube.adicionarMedico(medico);

        FolhaDePagamento folhaDePagamento = new FolhaDePagamento();

        assertEquals(5000f,folhaDePagamento.calculaFolhaSalarial(clube));
    }

    @Test
    void deveRetornarFolhaDePagamentoComSomenteOMassagistaClube(){

        Clube clube = new Clube("Psg");
        Massagista massagista = new Massagista("Antonio");
        clube.adicionarMassagista(massagista);

        FolhaDePagamento folhaDePagamento = new FolhaDePagamento();

        assertEquals(1000f,folhaDePagamento.calculaFolhaSalarial(clube));
    }

    @Test
    void deveRetornarFolhaDePagamentoClubeComTodosOsFuncionarios(){
        Posicao posicao1 = new Posicao("Atacante");
        Posicao posicao2 = new Posicao("Defensor");
        Jogador jogador1 = new Jogador("Messi",posicao1);
        Jogador jogador2 = new Jogador("Neymar",posicao1);
        Jogador jogador3 = new Jogador("Sérgio Ramos",posicao2);


        Massagista massagista = new Massagista("Antonio");
        Medico medico = new Medico("Marco");

        Clube clube = new Clube("Psg");


        List<Jogador> jogadores = Arrays.asList(jogador1,jogador2,jogador3);

        clube.adicionarJogador(jogadores);
        clube.adicionarMassagista(massagista);
        clube.adicionarMedico(medico);

        FolhaDePagamento folhaDePagamento = new FolhaDePagamento();

        assertEquals(36000f,folhaDePagamento.calculaFolhaSalarial(clube));
    }

}
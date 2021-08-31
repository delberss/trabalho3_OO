package futebol;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CampeonatoTest {
    @Test
    void deveRetornarCampeonatoNomeNulo() {
        try {
            Campeonato campeonato = new Campeonato(null);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Nome do campeonato é obrigatório", e.getMessage());
        }
    }

    @Test
    void deveRetornarCampeonatoSetNomeNulo() {
        try {
            Campeonato campeonato = new Campeonato("Brasileirão");
            campeonato.setNome(null);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Nome do campeonato é obrigatório", e.getMessage());
        }
    }


    @Test
    void deveAdicionarClubeNoCampeonato() {
        Campeonato campeonato = new Campeonato("Brasileirão");
        Clube clube = new Clube("Psg");

        campeonato.adicionarClube(clube);

        assertTrue(clube.verificarCampeonato(campeonato));
        assertTrue(campeonato.verificarClube(clube));
    }

    @Test
    void deveRemoverClubeNoCampeonato() {
        Clube clube = new Clube("Psg");
        Campeonato campeonato = new Campeonato("Brasileirão");

        campeonato.adicionarClube(clube);
        campeonato.removerClube(clube);

        assertFalse(clube.verificarCampeonato(campeonato));
        assertFalse(campeonato.verificarClube(clube));
    }

}
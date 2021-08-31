package futebol;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MedicoTest {

    @Test
    void deveRetornarNomeMassagistaNulo(){
        try{
            Medico medico = new Medico(null);
            fail();
        }
        catch (IllegalArgumentException e){
            assertEquals("Nome é obrigatório",e.getMessage());
        }
    }

    @Test
    void deveRetornarSetNomeMassagistaNulo(){
        try{
            Massagista massagista = new Massagista("Marco");
            massagista.setNome(null);
            fail();
        }
        catch (IllegalArgumentException e){
            assertEquals("Nome é obrigatório",e.getMessage());
        }
    }

    @Test
    void deveRetornarRelacionamentoMedicoClube(){
        Medico medico = new Medico("Marco");
        Clube clube = new Clube("Psg");

        medico.adicionarClube(clube);

        assertEquals(clube, medico.getClube());
        assertEquals(medico, clube.getMedico());
    }

    @Test
    void deveRemoverClubeDoMedico(){
        Medico medico = new Medico("Marco");
        Clube clube = new Clube("Psg");

        medico.adicionarClube(clube);
        medico.removerClube(clube);

        assertNull(medico.getClube());
        assertNull(clube.getMedico());
    }

    @Test
    void calcularSalarioMedicoSemClube(){
        try{
            Medico medico = new Medico("Marco Antonio");

            medico.calcularSalario();
        }
        catch (IllegalArgumentException e){
            assertEquals("O Médico precisa de um clube", e.getMessage());
        }
    }

    @Test
    void calcularSalarioMedicoSemJogadores(){
        Medico medico = new Medico("Marco Antonio");
        Clube clube = new Clube("Psg");

        medico.adicionarClube(clube);
        medico.calcularSalario();

        assertEquals(5000, medico.getSalario());
    }


    @Test
    void calcularSalarioMedicoComJogadores(){
        Clube clube = new Clube("Psg");
        Jogador jogador1 = new Jogador("Messi", new Posicao("Atacante"));
        Jogador jogador2 = new Jogador("Neymar",new Posicao("Atacante"));

        clube.adicionarJogador(jogador1);
        clube.adicionarJogador(jogador2);

        Medico medico = new Medico("Marco Antonio");
        medico.adicionarClube(clube);
        medico.calcularSalario();

        assertEquals(5200, medico.getSalario());
    }

    @Test
    void deveRetornarExcecaoRenovacaoContratualSemClube(){
        try{
            Medico medico = new Medico("Marco");

            medico.renovarContrato();
            fail();
        }
        catch(IllegalArgumentException e){
            assertEquals("O Médico precisa de um clube", e.getMessage());
        }
    }

    @Test
    void deveRetornarExcecaoRenovacaoContratual(){
        try{
            Medico medico = new Medico("Marco");
            Clube clube = new Clube("Psg");

            medico.adicionarClube(clube);

            medico.setTempoDeContratoEmAno(1);
            medico.renovarContrato();

            fail();
        }
        catch(IllegalArgumentException e){
            assertEquals("O médico já possui contrato maior ou igual 1 ano.", e.getMessage());
        }
    }

    @Test
    void deveRetornarRenovacaoContratual(){
        Medico medico = new Medico("Marco");
        Clube clube = new Clube("Psg");

        medico.adicionarClube(clube);
        medico.renovarContrato();

        assertEquals(1, medico.getTempoDeContratoEmAno());
    }


}
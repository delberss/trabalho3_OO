package futebol;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MassagistaTest {

    @Test
    void deveRetornarNomeMassagistaNulo(){
        try{
            Massagista massagista = new Massagista(null);
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
    void deveRetonarRelacionamentoMassagistaClube(){
        Massagista massagista = new Massagista("Antonio");
        Clube clube = new Clube("Psg");

        massagista.adicionarClube(clube);

        assertEquals(clube, massagista.getClube());
        assertEquals(massagista, clube.getMassagista());
    }

    @Test
    void deveRemoverClubeDoMassagista(){
        Massagista massagista = new Massagista("Antonio");
        Clube clube = new Clube("Psg");

        massagista.adicionarClube(clube);
        massagista.removerClube(clube);

        assertNull(massagista.getClube());
        assertNull(clube.getMassagista());
    }

    @Test
    void deveRetonarExcecaoJogosPresentesNegativo(){
        try{
            Massagista massagista = new Massagista("Antonio");
            massagista.setJogosPresentes(-1);
            fail();

        }
        catch (IllegalArgumentException e){
            assertEquals("Jogos precisam ser maior ou igual a 0", e.getMessage());
        }
    }



    @Test
    void calcularSalarioMassagistaSemClube(){
        try{
            Massagista massagista = new Massagista("Antonio");

            massagista.calcularSalario();
            fail();

        }
        catch (IllegalArgumentException e){
            assertEquals("O Massagista precisa de um clube", e.getMessage());
        }
    }

    @Test
    void calcularSalarioMassagistaSemJogosPresentes(){
        Clube clube = new Clube("Psg");
        Massagista massagista = new Massagista("Antonio");

        massagista.adicionarClube(clube);
        massagista.calcularSalario();

        assertEquals(1000, massagista.getSalario());
    }


    @Test
    void calcularSalarioMassagistaComJogosPresentes(){
        Clube clube = new Clube("Psg");
        Massagista massagista = new Massagista("Antonio");

        massagista.adicionarClube(clube);
        massagista.setJogosPresentes(50);
        massagista.calcularSalario();

        assertEquals(1500, massagista.getSalario());
    }

    @Test
    void deveRetornarExcecaoRenovacaoContratualSemClube(){
        try{
            Massagista massagista = new Massagista("Marco");

            massagista.renovarContrato();
            fail();
        }
        catch(IllegalArgumentException e){
            assertEquals("O Massagista precisa de um clube", e.getMessage());
        }
    }

    @Test
    void deveRetornarExcecaoRenovacaoContratualTempoDe2AnosOuMais(){
        try{
            Massagista massagista = new Massagista("Marco");
            Clube clube = new Clube("Psg");

            massagista.adicionarClube(clube);

            massagista.setTempoDeContratoEmAno(2);
            massagista.setJogosPresentes(21);
            massagista.renovarContrato();

            fail();
        }
        catch(IllegalArgumentException e){
            assertEquals("O massagista não está apto para renovação", e.getMessage());
        }
    }

    @Test
    void deveRetornarExcecaoRenovacaoContratualMenosJogosDoMinimo(){
        try{
            Massagista massagista = new Massagista("Marco");
            Clube clube = new Clube("Psg");

            massagista.adicionarClube(clube);

            massagista.setJogosPresentes(20);
            massagista.renovarContrato();

            fail();
        }
        catch(IllegalArgumentException e){
            assertEquals("O massagista não está apto para renovação", e.getMessage());
        }
    }

    @Test
    void deveRetornarRenovacaoContratual(){
        Massagista massagista = new Massagista("Marco");
        Clube clube = new Clube("Psg");

        massagista.adicionarClube(clube);

        massagista.setJogosPresentes(21);
        massagista.renovarContrato();

        assertEquals(1, massagista.getTempoDeContratoEmAno());
    }

}
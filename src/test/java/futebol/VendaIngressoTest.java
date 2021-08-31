package futebol;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VendaIngressoTest {

    @Test
    void deveRetornarExcecaoSetDescontoNegativo(){
        try{
            VendaIngresso vendaIngresso = new VendaIngresso();
            vendaIngresso.setDescontoIngresso(-0.1f);
            fail();
        }
        catch (IllegalArgumentException e){
            assertEquals("Desconto não pode ser negativo",e.getMessage());
        }
    }

    @Test
    void deveRetornarCalculoIngressoSemDesconto() {
        Ingresso.setIngresso(50f);

        VendaIngresso vendaIngresso = new VendaIngresso();

        assertEquals(50f, vendaIngresso.calcularPrecoIngresso());
    }

    @Test
    void deveRetornarCalculoIngressoComDesconto() {
        Ingresso.setIngresso(50f);

        VendaIngresso vendaIngresso = new VendaIngresso();
        vendaIngresso.setDescontoIngresso(10);

        assertEquals(45f, vendaIngresso.calcularPrecoIngresso());
    }

}
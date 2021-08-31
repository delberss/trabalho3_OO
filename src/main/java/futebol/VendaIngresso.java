package futebol;

public class VendaIngresso {
    private float descontoIngresso;

    public float getDescontoIngresso() {
        return descontoIngresso;
    }
    public void setDescontoIngresso(float descontoIngresso) {
        if (descontoIngresso < 0)
            throw new IllegalArgumentException("Desconto não pode ser negativo");
        this.descontoIngresso = descontoIngresso;
    }

    public float calcularPrecoIngresso() {
        return Ingresso.getIngresso() - ((this.descontoIngresso * Ingresso.getIngresso()) / 100);
    }
}
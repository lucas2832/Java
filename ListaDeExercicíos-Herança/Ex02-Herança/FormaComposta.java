import java.util.ArrayList;

public class FormaComposta extends Forma
{
    private ArrayList<Forma> figuras = new ArrayList<Forma>();
    
    public FormaComposta() {
        super(100, 100, "vermelho");
    }
    
    public void adicionarForma(Forma figura) {
        figuras.add(figura);
    }
    
    public void removerForma(Forma figura) {
        figuras.remove(figura);
    }
    
    @Override
    public void desenhar() {
        for(Forma figura : figuras){
            figura.desenhar();
        }
    }
    
    @Override
    public void tornarVisível(){
        for(Forma figura : figuras){
            figura.tornarVisível();
        }
    }
    
    @Override
    public void tornarInvisível() {
        for(Forma figura : figuras){
            figura.tornarInvisível();
        }
    }
    
    @Override
    public void moverDireita() {
            for(Forma figura : figuras){
            figura.moverDireita();
        }    
    }
    
    @Override
    public void moverEsquerda() {
            for(Forma figura : figuras){
            figura.moverEsquerda();
        }    
    }
    
    @Override
    public void moverCima() {
        for(Forma figura : figuras){
            figura.moverCima();
        }
    }
    
    @Override
    public void moverBaixo() {
        for(Forma figura : figuras){
            figura.moverBaixo();
        }
    }
    
    @Override
    public void moverHorizontal(int distância) {
        for(Forma figura : figuras){
            figura.apagar();
            posiçãoX += distância;
            figura.desenhar();
        }
    }
    
    @Override
    public void moverVertical(int distância) {
        for(Forma figura : figuras){
            figura.tornarInvisível();
        }
    }
    
    @Override
    public void moverHorizontalLentamente(int distância) {
        int delta;
        
        for(Forma figura : figuras) {
            figura.moverHorizontalLentamente();
        }
    }
    
    @Override
    public void moverVerticalLentamente(int distância) {

        for(Forma figura : figuras) {
            figra.moverVerticalLentamente();
        }
    }
    
    @Override
    public void mudarCor(String novaCor) {
        for(Forma figura : figuras) {
            cor = novaCor;
            figura.desenhar();
        }
    }
    
    @Override
    protected void apagar()
    {
        for(Forma figura : figuras) {
            figura.apagar();
        }
    }
}

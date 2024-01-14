public abstract class Forma
{
    protected int posiçãoX;
    protected int posiçãoY;
    protected String cor;
    protected boolean estáVisível;
    
    public Forma(int posx, int posy, String cor) {
        posiçãoX = posx;
        posiçãoY = posy;
        this.cor = cor;
        estáVisível = false;
    }
    
    public void tornarVisível(){
        estáVisível = true;
        desenhar();
    }
    
    public void tornarInvisível() {
        apagar();
        estáVisível = false;
    }
    
    public void moverDireita() {
        moverHorizontal(20);
    }
    
    public void moverEsquerda() {
        moverHorizontal(-20);
    }
    
    public void moverCima() {
        moverVertical(-20);
    }
    public void moverBaixo() {
        moverVertical(20);
    }
    public void moverHorizontal(int distância) {
        apagar();
        posiçãoX += distância;
        desenhar();
    }
    
    public void moverVertical(int distância) {
        apagar();
        posiçãoY += distância;
        desenhar();
    }
    
    public void moverHorizontalLentamente(int distância) {
        int delta;

        if(distância < 0) 
        {
            delta = -1;
            distância = -distância;
        }
        else 
        {
            delta = 1;
        }

        for(int i = 0; i < distância; i++)
        {
            posiçãoX += delta;
            desenhar();
        }
    }
    
    public void moverVerticalLentamente(int distância) {
        int delta;

        if(distância < 0) 
        {
            delta = -1;
            distância = -distância;
        }
        else 
        {
            delta = 1;
        }

        for(int i = 0; i < distância; i++)
        {
            posiçãoY += delta;
            desenhar();
        }
    }
    
    public void mudarCor(String novaCor) {
        cor = novaCor;
        desenhar();
    }
    
    protected void apagar()
    {
        if(estáVisível) {
            Canvas canvas = Canvas.getCanvas();
            canvas.erase(this);
        }
    }
    
    protected abstract void desenhar(); 
}

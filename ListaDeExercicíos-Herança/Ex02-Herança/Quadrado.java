import java.awt.*;

/**
 * Um quadrado que pode ser manipulado e que desenha a si mesmo em uma canvas (tela).
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 * (Traduzido por Daniel Conrado)
 */
public class Quadrado extends Forma
{
    private int tamanho;

    /**
     * Cria um novo quadrado na posição padrão e com cor padrão.
     */
    public Quadrado()
    {
        super(310, 120, "vermelho");
        tamanho = 60;    
    }

    /**
     * Muda o tamanho para o novo valor (em pixels). Tamanho precise ser >= 0.
     */
    public void mudarTamanho(int novoTamanho)
    {
        apagar();
        tamanho = novoTamanho;
        desenhar();
    }

    /**
     * Desenha um quadrado com as especificações atuais na tela.
     */
    protected void desenhar()
    {
        if(estáVisível) {
            Canvas canvas = Canvas.getCanvas();
            canvas.draw(this, cor,
                        new Rectangle(posiçãoX, posiçãoY, tamanho, tamanho));
            canvas.wait(10);
        }
    }
}

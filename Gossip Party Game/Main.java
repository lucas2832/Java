
/**
 * Escreva uma descrição da classe Main aqui.
 * 
 * @author (Tomaz Corrêa, Lucas Magalhães, Lucas Martins, Luigi)
 * @version (um número da versão ou uma data)
 */
public class Main
{    
    public static void main (String args[]) throws InterruptedException {
        Game game = new Game();
        Janela janela = new Janela(Janela.mapaLabel);
        Player player = new Player();
        game.play();
    }
}

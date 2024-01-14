
/**
 * Escreva uma descrição da classe clock aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class Clock
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private int horas;
    private int minutos;
    /**
     * Construtor para objetos da classe clock
     */
    
    public Clock(int hora, int minuto)
    {
        horas = hora;
        minutos = minuto;
    }
    
    public void acrescentar(int tempo)
    {
        horas += tempo / 60;
        minutos += tempo % 60;       
        
        if(horas >= 24){
            horas -= 24;
        }
        
        if(minutos >= 60){
            minutos -= 60;
            horas++;
            
            if(horas >= 24){
            horas -= 24;
            }
        }
    }
    
    public String getValorExibição()
    {
        return String.format("%02d:%02d", horas, minutos);
    }
}

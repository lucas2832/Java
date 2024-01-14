/**
 * Representa um parquímetro fracionado simplificado.
 *
 * O parquímetro funciona assim:
 * 1. o cliente seleciona a quantidade de tempo
 *    de estacionamento, incrementando-o
 *    de 15 em 15 minutos.
 * 2. o cliente insere o dinheiro suficiente para
 *    pagar o ticket de estacionamento.
 * 3. o cliente pede para imprimir o ticket.
 *
 * O parquímetro mantém o total de dinheiro acumulado
 * ao longo do tempo em que está em operação.
 *
 * @author Daniel Conrado
 * @version 2023
 */
public class Parquimetro
{
    // campo que armazena quanto custa cada unidade de tempo solicitada.
    // p. ex. o preço unitário a cada 15 minutos comprados.
    private int preçoUnitario;
    // armazena o tempo total sendo solicitado
    private int tempoSolicitado;
    // quantidade de dinheiro já inserida pelo cliente
    private int balanço;
    // quantidade total de dinheiro acumulado por este parquímetro
    private int total;
    // total a pagar
    private int totalAPagar;
    // total de vezes que o botão azul foi selecionado
    private int count = 0;
    private int troco;
    private int opçao;
    private int tempo;
    
    /**
     * Constroi um novo objeto Parquimetro com o preço unitário configurado.
     * Escolha a opção 1 para área urbana, 2 para área turística e 3 para especificar o limite de tempo para o parquimetro
     */
    public Parquimetro(int preçoDaFração, int escolha, int tempoLimite)
    {
        opçao = escolha;
        if(opçao == 1){
            preçoUnitario = preçoDaFração;
            tempoSolicitado = 15;
            balanço = 0;
            total = 0;
        } else if(opçao == 2){
            preçoUnitario = preçoDaFração;
            tempoSolicitado = 60;
            balanço = 0;
            total = 0;
        } else if(opçao == 3){
            tempo = tempoLimite;
            preçoUnitario = preçoDaFração;
            tempoSolicitado = 15;
            balanço = 0;
            total = 0;
        }
    }

    public void inserirDinheiro(int quantia)
    {
        balanço = balanço + quantia;
    }

    public void aumentarTempo()
    {
        if(opçao == 1){
            if(count < 4){
                count++;
                if(count < 2){
                    tempoSolicitado = tempoSolicitado + 15;
                } else {
                    tempoSolicitado = tempoSolicitado + 30;
                }
            } else {
                System.out.print("Limite de tempo atingido.");
            }
        } else if( opçao == 2){
            if(count <= 2)
            {
                count++;
                tempoSolicitado = tempoSolicitado + 30;
            } else {
                System.out.print("Limite de tempo atingido.");
            }
        } else if(opçao == 3){
            if(tempoSolicitado < tempo){
                count++;
                if(count < 2){
                    tempoSolicitado = tempoSolicitado + 15;
                } else {
                    tempoSolicitado = tempoSolicitado + 30;
                }
                } else {
                System.out.print("Limite de tempo atingido.");
                }
            }
        }

    public void totalAPagar()
    {
        if(opçao == 1){
            totalAPagar = (count * preçoUnitario) + preçoUnitario;
        } else if(opçao == 2){
            totalAPagar = (count * preçoUnitario) + (preçoUnitario * 3);
        } else if(opçao == 3){
            totalAPagar = (count * preçoUnitario) + preçoUnitario;
        }
    }
    
    public int devolverTroco()
    {
        balanço = 0;
        count = 0;
        total = total - troco;
        totalAPagar = 0;
        return troco;
    }

    public void imprimirTicket(int horaAtual, int minutoAtual)
    {
        Clock tempo = new Clock(horaAtual, minutoAtual);
        tempo.acrescentar(tempoSolicitado);
        
        if(balanço >= totalAPagar){
            troco = balanço - totalAPagar;
            
            System.out.println("+--------------------------+");
            System.out.println("| Ticket de Zona Azul      |");
            System.out.println("+--------------------------+");
            System.out.printf ("| Início: %02d:%02d            |\n", horaAtual, minutoAtual);
            System.out.println("|                          |");
            System.out.printf ("| Válido por: %-13s|\n", tempoSolicitado + "min");
            System.out.println("| Total a pagar: "+ totalAPagar);
            System.out.println("| Troco: "+ troco);
            System.out.println("| Término: "+ tempo.getValorExibição());
            System.out.println("+--------------------------+");
            
            total = total + balanço;
            tempoSolicitado = 15;
            
        } else {
            System.out.println("Saldo insuficiente.");
        }
        
    }
    
    /**
     * Quantia sacada pela prefeitura
     */
    public int esvaziar()
    {
        int vazio = total;
        total = 0;
        return vazio;
    }

    public int getPreçoUnitario()
    {
        return preçoUnitario;
    }

    public int getTempoSolicitado()
    {
        return tempoSolicitado;
    }

    public int getBalanço()
    {
        return balanço;
    }
}
import java.util.Scanner;

public class Interact {
    
    private static int story = 0;
    public static String nome;
    
    public Interact () {
        
    }
    
    public static void interact() throws InterruptedException {
       nome = "";
       
       if(Game.segurança.equals(Game.currentNpc)) {
           Scanner Scan = new Scanner(System.in);
           System.out.println("Bem vindo a Gossip Party");
           System.out.println("Digite seu nome: ");
           nome = Scan.nextLine();
           Player.setName();
           System.out.printf("\nOK Sr(a) %s, aproveite a festa!!\n", nome);
           Game.allNpcs.remove(Game.segurança);
           
       } else if(Game.Max.equals(Game.currentNpc)) {
           System.out.printf("\n%s: Você tem algo para me contar vida??",Player.getName());
           System.out.printf("\n%s: Ando escutando muito seu nome por ai...\n",Player.getName());
            
           if(story == 5) {
               System.out.println("Max: precisamos conversar...");
               
               Janela end = new Janela(Janela.GameOverLabel);
               Game.wantToQuit = true;
           } else {
               System.out.println("Max: Não sei o que você quer saber de mim... Parece ate que quer brigar atoa...");
           }
           
       } else if(Game.Steven.equals(Game.currentNpc)) {
           if(Game.Steven.getFirstTime()) {
               System.out.printf("\nSteven: oi %s, c tá bom?\n",Player.getName());
               Thread.sleep(1500);
               System.out.printf("\n%s: tô bom meu templário. E você? \n", Player.getName());
               Thread.sleep(1500);
               System.out.printf("\n%s: fiquei sabendo que tem uma fofoca aqui no IF. Sabe de alguma coisa? \n", Player.getName());
               Thread.sleep(1500);
               System.out.printf("\nSteven: tô bem pai. Soube sim, mas primeiro pega um Xeque Mate pra mim e te conto o que eu sei.\n");
               Game.Steven.setFirstTime();
           } else {
                   if(!Game.Steven.getTold()) {
                       if (Player.getLeftHand() != null || Player.getRightHand() != null) {
                           if(Player.rightHand.getName().equals("Xeque-Mate")) {    
                               Player.leftHand = Player.dropItemLeft();
                                    
                               System.out.printf("\n%s: tá aqui o seu Xeque Mate. Me conta aí o que sabe.\n", Player.getName());
                               Thread.sleep(1500);
                               System.out.println("Steven: eu vi duas senhoras descendo do 4° andar depois que o lanche acabou.");
                               Thread.sleep(1500);
                               System.out.println("Steven: mas é só isso que eu sei...\n");
                               
                               Game.Steven.setTold();
                               story++;
                           } else if (Player.leftHand.getName().equals("Xeque-Mate")) {
                               Player.leftHand = Player.empty;
                                    
                               System.out.printf("\n%s: tá aqui o seu Xeque Mate. Me conta aí o que sabe.\n", Player.getName());
                               Thread.sleep(1500);
                               System.out.println("\nSteven: eu vi duas senhoras descendo do 4° andar depois que o lanche acabou.");
                               Thread.sleep(1500);
                               System.out.println("Steven: mas é só isso que eu sei...\n");
                               
                               Game.Steven.setTold ();
                               story++;
                           }
                           else {
                               System.out.println("Steven: Nada de informações antes do meu Xeque Mate HAHAHAHA...\n");
                           }
                       } else {
                           System.out.println("* não chegue de Mãos vazias *");
                           Player.leftHand = Player.empty;;
                           Player.rightHand = Player.empty;;
                       }
                   } else {
                   System.out.println("* ele ja te contou tudo que sabe *");
                   }
                }
       } else if(Game.Trixie.equals(Game.currentNpc)) {
           if(Game.Trixie.getFirstTime()) {
               System.out.printf("\n%s: cole cole, eai Trixie \n",Player.getName());
               System.out.println("Trixie: eai "+Player.getName()+ " ,vc ta bem?");
               Thread.sleep(1500);
               
               if (Player.getDrunkValue() >= 50){
                   System.out.printf("\n%s: ue, to suave, so to um pouco bebado, porque a pergunta cria?\n",Player.getName());
               } else {
                   System.out.printf("\n%s: ue, to suave cria, porque a pergunta?\n",Player.getName());
               }
               
               System.out.println("Trixie: nossa, cara eu vou pegar um bolo e ja volto...");
               Thread.sleep(1500);
               System.out.printf("NÃO!! CALMA Q EU BUSCO PRA VC, NN SAIA DAI, E QUANDO EU VOLTAR TU ME CONTA TUDO VIU!!\n",Player.getName());
               Thread.sleep(1500);
               System.out.println("Trixie: que isso cara que susto, não precisava de tanta energia na fala. Mas ta bom pega la");
               
               Game.Trixie.setFirstTime();
           } else {
               if (!Game.Trixie.getTold()) {
                   if (Player.getLeftHand() != null || Player.getRightHand() != null) {
                       if(Player.getNameRight().equals("Bolo")) {
                           Player.dropItemRight();
                               
                           System.out.printf("\n%s: toma teu bolo ae, abre o bico Trix\n",Player.getName());
                           Thread.sleep(1500);
                           System.out.println("Trixie: Ta porra... valeu cara e valeu cara"); 
                           Thread.sleep(1500);
                           System.out.println("Trixie: A verdade é que eu so sei que foi o Max e ta todo mundo falando dele...");
                           Thread.sleep(1500);
                           System.out.println("Trixie: eu tenho uma ideia do que pode ter sido, mas não vou falar nada sem ter certeza");
                           Thread.sleep(1500);
                           System.out.printf("\n%s: arf... Suave então Trix, pelo menos matou um pouco da minha curiosidade, valeu valeu\n",Player.getName());
                           System.out.println(" * a Trixie parecia estar com medo de te contar * ");
                           
                           Game.Trixie.setTold();
                           story++;
                       } else if (Player.getNameLeft().equals("Bolo")) {
                           Player.leftHand = Player.empty;
                               
                           System.out.printf("\n%s: toma teu bolo ae, abre o bico Trix\n",Player.getName());
                           Thread.sleep(1500);
                           System.out.println("Trixie: Ta porra... valeu cara e valeu cara"); 
                           Thread.sleep(1500);
                           System.out.println("Trixie: A verdade é que eu so sei que foi o Max e ta todo mundo falando dele...");
                           Thread.sleep(1500);
                           System.out.println("Trixie: eu tenho uma ideia do que pode ter sido, mas não vou falar nada sem ter certeza");
                           Thread.sleep(1500);
                           System.out.printf("\n%s: arf... Suave então Trix, pelo menos matou um pouco da minha curiosidade, valeu valeu\n",Player.getName());
                           System.out.println(" * a Trixie parecia estar com medo de te contar * ");
                           
                           Game.Trixie.setTold();
                           story++;
                       } else {
                           System.out.println("Trixie: cade meu bolo cara??");   
                       }
                   } else {
                       System.out.println("* não chegue de Mãos vazias *");
                       Player.leftHand = Player.empty;;
                       Player.rightHand = Player.empty;;
                   }
               } else {
                   System.out.println("* ela ja te disse tudo que sabe *");
               }
           }
           
       } else if(Game.Michael.equals(Game.currentNpc)) {
           if(Game.Michael.getFirstTime()) {
               System.out.println("Michael: Cara...");
               Thread.sleep(1500);
               System.out.printf("\n%s: Que foi meu negro Michael?\n",Player.getName());
               Thread.sleep(1500);
               System.out.println("Michael: Acho que ele se passou um pouco...");
               
               System.out.printf("\nMichael: me traz uma caipirinha que eu te conto meu branco %s.\n",Player.getName());
               Game.Michael.setFirstTime();
           } else {
               if (!Game.Michael.getTold()) {
                   if (Player.getLeftHand() != null || Player.getRightHand() != null) {
                       if (Player.rightHand.getName().equals("Caipirinha")) {
                           Player.dropItemRight();
                           System.out.println("Michael: nu, salvou viu");
                           Thread.sleep(1500);
                           System.out.println("Michael: não vou te enrolar não, o papo é, foram duas velhas man... se fosse so uma era compreensivel sepah");
                           Thread.sleep(1500);
                           System.out.printf("\n%s: DUAS VELHAS O QUE MICHAEL, ME CONTA CARA\n",Player.getName());
                           Thread.sleep(1500);
                           System.out.println("Michael: Não maninho, agora é contigo");
                           
                           Game.Michael.setTold();
                           story++;
                       } else if (Player.leftHand.getName().equals("Caipirinha")) {
                           Player.leftHand = Player.empty;;
                           System.out.println("Michael: nu, salvou viu");
                           Thread.sleep(1500);
                           System.out.println("Michael: não vou te enrolar não, o papo é, foram duas velhas man... se fosse so uma era compreensivel sepah");
                           Thread.sleep(1500);
                           System.out.printf("\n%s: DUAS VELHAS O QUE MICHAEL, ME CONTA CARA\n",Player.getName());
                           Thread.sleep(1500);
                           System.out.println("Michael: Não maninho, agora é contigo");
                           
                           Game.Michael.setTold();
                           story++;
                       }else {
                           System.out.println("Michael: 1º lei de Newton paizão, nada sai de graça, busca la a parada.");
                           System.out.println(" * 1º lei de Newton??? * ");
                       }
                   } else {
                       System.out.println("* não chegue de Mãos vazias *");
                       Player.leftHand = Player.empty;;
                       Player.rightHand = Player.empty;;
                   }
               } else {
                   System.out.println("* ele ja te disse tudo que sabe *");
               }
           }
           
       } else if(Game.Elio.equals(Game.currentNpc)) {
           if(Game.Elio.getFirstTime()) {
               System.out.println("* o Elio parece meio mal, provavelmente bebeu demais... *");
               Game.Elio.getFirstTime();
               
               Thread.sleep(1000);
               System.out.println("Elio: eai...");
               Thread.sleep(1000);
               System.out.println("Elio: ta suave igual eu ou ta bolado igual meu figado??");
               Thread.sleep(1500);
               System.out.printf("\n%s: ELIO ME CONTA O QUE VOCÊ SABE DA FOFOCA\n",Player.getName());
               Thread.sleep(1000);
               System.out.println("Elio: da não pai... Consigo nem falar papo reto");
               Thread.sleep(1500);
               System.out.printf("\n%s: Cara tu ta falando agora...\n",Player.getName());
               Thread.sleep(1500);
               System.out.println("Elio: To não");
               
               System.out.printf("\n%s: cruz credo hein cachaça, vou trazer um trem pra tu comer e melhorar, depois c vai me contar oq eu quero saber jae?\n",Player.getName());
               
               Game.Elio.setFirstTime();
           } else {
               if(!Game.Elio.getTold()) {
                   if (Player.getLeftHand() != null || Player.getRightHand() != null) {
                       if(Player.rightHand.getName().equals("Doritos")) {
                           Player.dropItemRight();
                           
                           System.out.printf("\n%s: Vai Elio carai, come esse trem ai\n",Player.getName());
                           Thread.sleep(1500);
                           System.out.println("Elio: ainda");
                           Thread.sleep(3000);
                           System.out.printf("\n%s: agora conta ai o bagulho\n",Player.getName());
                           Thread.sleep(1500);
                           System.out.println("Elio: man... so sei que ele vai andar de skin nova agora kkkkkk");
                           Thread.sleep(3000);
                           
                           Game.Elio.setTold();
                           story++;
                           
                       } else if (Player.leftHand.getName().equals("Doritos")) {
                           Player.leftHand = Player.empty;
                           
                           System.out.printf("\n%s: Vai Elio carai, come esse trem ai\n",Player.getName());
                           Thread.sleep(1500);
                           System.out.println("Elio: ainda");
                           Thread.sleep(3000);
                           System.out.printf("\n%s: agora conta ai o bagulho\n",Player.getName());
                           Thread.sleep(1500);
                           System.out.println("Elio: man... so sei que ele vai andar de skin nova agora kkkkkk");
                           Thread.sleep(3000);
                           
                           Game.Elio.setTold();
                           story++;
                           
                       } else {
                           System.out.println("Elio: hm... hmmmm...");
                           System.out.println(" * ele parece bem mal ainda * ");
                       }
                   } else {
                       System.out.println("* não chegue de Mãos vazias *");
                       Player.leftHand = Player.empty;;
                       Player.rightHand = Player.empty;;
                   }
               } else {
                   System.out.println("* ele ja te disse tudo que sabe *");
               }
           }
           
       } else if (Game.Lilia.equals(Game.currentNpc)) {
           if(Game.Lilia.getFirstTime()) {
               System.out.println("\nLilia: oi lindo, noite doida ne?");
               Thread.sleep(1500);
               
               if(Player.getDrunkValue() > 50) {
                   System.out.printf("\n%s: oi princesa, fiquei sabendo que hoje ta uma loucura mesmo, mas tu sabe me dizer o porque?\n",Player.getName());
                   Thread.sleep(1500);
                   System.out.println("Lilia: cara eu nn sei nem por onde começar, meu coração ta apertado ate agora, me traz uma vodka pra eu me acalmar?");
                   Thread.sleep(1500);
                   System.out.printf("\n%s: Claro Lilia, vou buscar pra você\n",Player.getName());
                   Game.Lilia.setFirstTime();
               } else {
                   System.out.printf("\n%s: O... Oi Li... Lili... a...\n",Player.getName());
                   Thread.sleep(3000);
                   System.out.println("* você esta muito nervoso para falar com ela *");
                   System.out.println("* ela olha para você confusa e te acha estranho porem engraçadinho *");
               }
           } else {
               if (!Game.Lilia.getTold()){
                   if (Player.getLeftHand() != null || Player.getRightHand() != null)  {
                       if(Player.rightHand.getName().equals("Vodka")) {
                           Player.dropItemRight();
                           System.out.printf("\n%s: aqui tua vodka Lilia, agora se acalma logo e me conta essa brava que eu to ficando preocupado\n",Player.getName());
                           Thread.sleep(1500);
                           System.out.println("Lilia: olha eu so posso dizer que foi depois do lanche coletivo, e o Michael e a trixie estavam la na hora");
                           Thread.sleep(1500);
                           System.out.printf("\n%s: qual foi Lilia me conta o resto cara!!\n",Player.getName());
                           Thread.sleep(1500);
                           System.out.println("Lilia: desculpa, lindo eu não posso, eu não consigo...");
                           Thread.sleep(1500);
                           
                           Game.Lilia.setTold();
                           story++;
                       } else if (Player.leftHand.getName().equals("Vodka")) {
                           Player.leftHand = Player.empty;
                           
                           System.out.printf("\n%s: aqui tua vodka Lilia, agora se acalma logo e me conta essa brava que eu to ficando preocupado",Player.getName());
                           Thread.sleep(1500);
                           System.out.println("Lilia: olha eu so posso dizer que foi depois do lanche coletivo, e o Michael e a trixie estavam la na hora");
                           Thread.sleep(1500);
                           System.out.printf("\n%s: qual foi Lilia me conta o resto cara!!",Player.getName());
                           Thread.sleep(1500);
                           System.out.println("Lilia: desculpa, lindo eu não posso, eu não consigo...");
                           Thread.sleep(1500);
                           
                           Game.Lilia.setTold();
                           story++;
                       } else {
                           System.out.println("Lilia: cara eu realmente preciso beber pra me acalmar, pega la pra mim pufavorfiznhuuu");
                           System.out.println("* a Lilia sempre foi muito fofa com você, mas ela realmente precisa deu drink agora *");
                       }
                   } else {
                       System.out.println("* não chegue de Mãos vazias *");
                       Player.leftHand = Player.empty;
                       Player.rightHand = Player.empty;
                   }
               } else {
                   System.out.println("* ela ja te disse tudo que sabe *");
               }
           }
           
       } else if (Game.Barman.equals(Game.currentNpc)) {
           System.out.println("Boa noite! O que vai querer pedir?");
           Thread.sleep(1000);
           System.out.println("* Escolha algum item do cardápio * ");
           for(Item item : Game.allItems) {
               System.out.println(" -" +item.getName());
               Thread.sleep(500);
           }
       }
    }
}

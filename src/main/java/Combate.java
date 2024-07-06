import java.util.Random;

public class Combate{

    private Random rand = new Random();

    public void Lutar(Jogador jogador, Criatura criatura){
        SerVivo jogadorAtual = jogador;
        SerVivo proximoJogador = criatura;
        boolean lutaEmAndamento = true;

        while(lutaEmAndamento){

            System.out.println("Vez de "+jogadorAtual.Nome);

            System.out.println(danoSorte(jogadorAtual.arma)+" de dano causado.");

            proximoJogador.Vida -= danoSorte(jogadorAtual.arma);

            System.out.printf("Vida de %s: %d | Vida de %s: %d\n",jogadorAtual.Nome,jogadorAtual.Vida,proximoJogador.Nome,proximoJogador.Vida);

            if(jogadorAtual==jogador){
                jogadorAtual = criatura;
                proximoJogador = jogador;
            }else{
                jogadorAtual = jogador;
                proximoJogador = criatura;
            }

            lutaEmAndamento = FimDaLuta(jogador.Vida, criatura.Vida);
        }
    }

    private int danoSorte(Arma arma){
        int sorte=rand.nextInt(1,11);
        int dano = 0;

        if(sorte == 10){
            dano = arma.getDano() +arma.getDano();
        }else if(sorte == 9){
            dano = arma.getDano()+5;
        }else if(sorte == 8){
            dano = arma.getDano()+2;
        }else if(sorte>=4 && sorte<=7){
            dano = arma.getDano();
        }else if(sorte == 3){
            dano = arma.getDano()-2;
        }else if(sorte == 2){
            dano = arma.getDano()-5;
        }else if(sorte == 1){
            dano = arma.getDano()-arma.getDano();
        }
        return dano;
    }

    private boolean FimDaLuta(int vida1, int vida2){
        if(!(vida1>0 && vida2>0))
            return false;
        else
            return true;
    }
}

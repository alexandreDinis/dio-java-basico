package app;

import interfaces.AparelhoTelefonico;
import interfaces.Navegador;
import interfaces.ReprodutorMusical;

public class Iphone implements ReprodutorMusical, AparelhoTelefonico, Navegador {
    @Override
    public void tocar() {
        System.out.println("Tocando");

    }

    @Override
    public void pausar() {
        System.out.println("Pausando");

    }

    @Override
    public void selecionarMusica() {
        System.out.println("Selecionando musica");
    }

    @Override
    public void ligarDeVoz() {
        System.out.println("Ligando para ...");
    }

    @Override
    public void atender() {
        System.out.println("Atendendo Ligação de ...");
    }

    @Override
    public void iniciarCorreioDevoz() {
        System.out.println("Ouvindo correrio de voz");
    }

    @Override
    public void exibirPagina() {
        System.out.println("exibindo pagina");
    }

    @Override
    public void adicionarNovaAba() {
        System.out.println("Adicionando nova aba");
    }

    @Override
    public void atualizarPagina() {
        System.out.println("Pagina atualizada");
    }

    public void ligarIphone(){
        System.out.println("Ligando Iphone");
    }

    public void desligarIphone(){
        System.out.println("Desligando Iphone");
    }

    public void voltar(){
        System.out.println("Voltando");
    }

    public void avancar(){
        System.out.println("Avançando");
    }

}

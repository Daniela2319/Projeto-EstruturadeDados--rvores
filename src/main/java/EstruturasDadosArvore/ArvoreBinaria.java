package EstruturasDadosArvore;


/**
 * Clase Árvore Binária
 *
 * @param <T> tipo genêrica implementando a interface comparable
 */
public class ArvoreBinaria<T extends  Comparable<T>> {

    private BinNo<T> raiz;

    // Construtor set a raíz
    public ArvoreBinaria(){
        this.raiz = null;  // Toda a vez instância de uma árvore binária a raiz vai ser nula.
    }

    /**
     * Método Inserir externa classe
     *
     * @param conteudo receber variável do tipo genêrica T conteudo
     */
    public void inserir(T conteudo){
        BinNo<T> novoNo = new BinNo<>(conteudo); // criar novoNo e instanciando BinNo do tipo T recebe contéudo.
        raiz = inserir(raiz, novoNo);  // raiz vai receber método inserir sobre carga dentro inserir recebe a raiz e novoNo.

    }

    /**
     * Método privado inserir
     * Inserir o nó e depois vai ser expor para os elementos externo das classes
     * como método pull
     * @param atual recebendo um nó chamando atual
     * @param novoNo recebendo um novo nó
     * @return o ná atual
     */
    private BinNo<T> inserir(BinNo<T> atual, BinNo<T> novoNo){
        if (atual == null){ // condição atual: for nulo nó novo está na raiz
            return novoNo;  // se for nulo novoNo retorna, porque ele está sendo inserindo.
        } else if (novoNo.getConteudo().compareTo(atual.getConteudo()) < 0) { //condição para compara se contéudo do novoNo menor que contéudo do nó Atual.
            atual.setNoEsq(inserir(atual.getNoEsq(), novoNo)); // se for isso o nó atual vai para esquerda testando se é menor chama função inserir fazer referência do novoNo.

        }else {
            atual.setNoDir(inserir(atual.getNoDir(), novoNo)); // Se novoNo for maior ele vai para direita.
        }
        return atual; // retorna nó atual
    }

}

package dio;

public class DoublyLinkedLists<T> {

    private NoDuplo<T> primeiroNo;
    private NoDuplo<T> ultimoNo;

    private int tamanhoLista = 0;

    public DoublyLinkedLists() {
        this.primeiroNo = null;
        this.ultimoNo = null;
        this.tamanhoLista = 0;
    }

    public T get(int index) {
        return getNo(index).getConteudo();
    }

    public void add(T conteudo) {
        NoDuplo<T> noNovo = new NoDuplo<>(conteudo);
        noNovo.setNoProximo(null); // Nó novo será o último da lista
        noNovo.setNoAnterior(ultimoNo); // Nó novo será o anterior ao último da lista
        if(primeiroNo == null){ // Se a lista estiver vazia
            primeiroNo = noNovo; // O primeiro nó da lista passa a ser o nó novo
            ultimoNo = noNovo; // O último nó da lista passa a ser o nó novo
        } if(ultimoNo != null) { // Se a lista não estiver vazia
            ultimoNo.setNoProximo(noNovo); // O último nó da lista passa a ser o nó novo
        }

        ultimoNo = noNovo; // O último nó da lista passa a ser o nó novo
        tamanhoLista++;
    }

    public void add (int index, T elemento) {
        NoDuplo<T> noAuxiliar = getNo(index); // Nó auxiliar para percorrer a lista
        NoDuplo<T> novoNo = new NoDuplo<>(elemento); // Nó novo
        novoNo.setNoProximo(noAuxiliar); // O nó novo passa a ser o próximo do nó auxiliar

        if(novoNo.getNoProximo() != null){ // Se o nó novo não for o último da lista
            novoNo.setNoAnterior(noAuxiliar.getNoAnterior()); // O nó novo passa a ser o anterior ao nó auxiliar
            novoNo.getNoProximo().setNoAnterior(novoNo); // O nó auxiliar passa a ser o anterior ao nó novo
        }else{
            novoNo.setNoAnterior(ultimoNo); // O nó novo passa a ser o anterior ao nó auxiliar
            ultimoNo = novoNo;
        }

        if(index == 0){
            primeiroNo = novoNo; // O primeiro nó da lista passa a ser o nó novo
        }else{
            // Se o nó novo não for o primeiro da lista
            novoNo.getNoAnterior().setNoProximo(novoNo); // O nó auxiliar passa a ser o próximo ao nó novo
        }

        tamanhoLista++;

    }

    public void remove(int index) {

        if(index == 0){ // Verifica se o item a ser removido é o primeiro da lista
            primeiroNo = primeiroNo.getNoProximo(); // Atualiza o primeiro nó para o próximo nó da lista

            if(primeiroNo != null){ // Se a lista não estiver vazia após a remoção
                primeiroNo.setNoAnterior(null); // Define o nó anterior do novo primeiro nó como null
            }

        } else { // Caso o item a ser removido não seja o primeiro elemento
            NoDuplo<T> noAuxiliar = getNo(index); // Obtém uma referência para o nó que será removido
            noAuxiliar.getNoAnterior().setNoProximo(noAuxiliar.getNoProximo()); // Liga o nó anterior ao próximo nó, removendo a referência ao nó atual

            if(noAuxiliar != ultimoNo){ // Verifica se o nó a ser removido não é o último
                noAuxiliar.getNoProximo().setNoAnterior(noAuxiliar.getNoAnterior()); // Liga o nó posterior ao nó anterior, ignorando o nó atual
            } else { // Se o nó a ser removido for o último
                ultimoNo = noAuxiliar.getNoAnterior(); // Atualiza o último nó para o nó anterior ao atual
            }
        }
        this.tamanhoLista--;
    }


    private NoDuplo<T> getNo(int index) {
        NoDuplo<T> noAuxiliar = primeiroNo; // Nó auxiliar para percorrer a lista

        for(int i = 0; (i < index) && (noAuxiliar != null); i++) {
            noAuxiliar = noAuxiliar.getNoProximo(); // Percorrendo a lista para encontrar o nó desejado
        }
        return noAuxiliar; // Retornando o nó auxiliar
    }

    public int size() {
        return this.tamanhoLista;
    }

    @Override
    public String toString() {
        String strRetorno = "";

        NoDuplo<T> noAuxiliar = primeiroNo;

        for(int i = 0; i < size(); i++){
            strRetorno += "[No{conteudo=" +noAuxiliar.getConteudo() +"}] --->";
            noAuxiliar = noAuxiliar.getNoProximo();

        }
        strRetorno += "null";
        return strRetorno;
    }
}

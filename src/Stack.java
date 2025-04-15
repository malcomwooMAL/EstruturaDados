import java.util.Scanner;

class Stack {

    private int [] vetor;
    private int top;

    private int[] getVetor() {
        return vetor;
    }

    // private void setVetor(int[] vetor) {
    //     this.vetor = vetor;
    // }

    private int getTop() {
        return top;
    }

    private  void setTop(int top) {
        this.top = top;
    }
    
    /**
     * 
     * @param n é a quantidade de indices que o meu vetor terá
     * @return
     */
    public int[] createStack (int n){

        this.vetor = new int[n];
        setTop(-1);
        return vetor;

    }

    /**
     * 
     * @param element é o valor do tipo inteiro que será acrescentado ao stack
     * @return
     */
    public void addStack (int element){

        if (getTop() == this.vetor.length-1) System.out.println("Não é possível acrescentar, o stack está cheio");
        else {
            setTop(getTop() +  1); // adiciona 1 ao ponteiro 
            this.vetor[getTop()] = element; // acrescenta o elemento ao topo do Stack 
        }

    }

    public void removeStack() {

        if (checkEmpty()) System.out.println("Não é possível remover, o stack está vazio. ");
        else{
            setTop(getTop() - 1); //aloca o ponteiro para o índice anterior
        }

    }


    public void peek() {
        
        if (checkEmpty()) System.out.println("O Stack está vazio.");
        else {
            System.out.println("Último índice preenchido: " + getTop());
            System.out.println("Último elemento adicionado: " + getVetor()[getTop()]);
        }
    }

    /**
     * 
     * @return TRUE se o Stack estiver totalmente saturado, ou seja, se o Top estiver com o valor length - 1
     */
    public boolean checkFull (){

        return getTop() == getVetor().length-1; // retornara valor TRUE se estiver totalmente preenchida

    }

    /**
     * 
     * @return TRUE se não há elementos no stack
     */
    public boolean checkEmpty (){

        return getTop() == -1; // se o Top está no valor -1, significa que nenhum elemento foi adicionado
    }

    public static void main(String[] args) {
        
        Stack stack = new Stack();

        Scanner scanner = new Scanner(System.in);

        int reboot = 0;
        int elemento = 0;

        System.out.println("Digite a quantidade de indices do vetor: ");
        int index = scanner.nextInt();

        

        do{

            System.out.println("Digite a opção que seja executar: ");
            System.out.println(" [ 1 ] - para acrescentar elementos ao stack:");
            System.out.println(" [ 2 ] - para remover elemento do stack:");
            System.out.println(" [ 3 ] - para verificar o último elemento do stack:");
            System.out.println(" [ 4 ] - para verificar se o stack está cheio:");
            System.out.println(" [ 5 ] - para verificar se o stack está vazio:");
            int opcao = scanner.nextInt();
            
            switch (opcao)) {
                case 1:
                    System.out.println("Informe o elemento que deseja acrescentar ao stack: ");
                    elemento = scanner.nextInt();
                    stack.addStack(elemento);
                    stack.peek();
                    break;
                    
                case 2:
                    stack.removeStack();
                    stack.peek();
                    break;    
                
                case 3:
                    stack.peek();
                    break;    
                
                case 4:
                    stack.checkFull();
                    break;

                case 5:
                    stack.checkEmpty();
                    break;

                default:
                    System.out.println("Opção Inválida.");
                    break;
            }


            System.out.println("Deseja continuar? 1 - para repetir, 0 - para encerrar.");
            opcao = scanner.nextInt();

        } while (reboot != 0);

        stack.createStack(index); // criar um vetor com n elementos, e setar o top para -1

        System.out.println(stack.checkEmpty());//teste se está vazio
        System.out.println(stack.checkFull()); //testar se está complento

        stack.removeStack(); // testar se é possível remover elemento inexistente

        stack.addStack(7);
        stack.addStack(9);
        stack.addStack(10);

        stack.peek(); // peek e adicionar está funcionando

        stack.removeStack(); //testar se o removestack está funcionando

        stack.peek(); // remover o último elemento está funcionando

        stack.addStack(15);

        stack.peek(); // verificar se está retornando ao mesmo índice

        //saturar o stack
        stack.addStack(8);
        stack.addStack(3);
        stack.addStack(1);
        stack.addStack(4);
        stack.addStack(9);
        stack.addStack(8);
        stack.addStack(7);// fim do stack, não deve ser possível addicionar mais elementos

        stack.peek(); //validar último elemento

        stack.addStack(1); // não deve ser possível adicionar mais esses elementos

        stack.peek();

        stack.addStack(2);

        stack.peek();

        scanner.close();
    }
}

package cursojava.executavel;

import cursojava.classes.Aluno;
import cursojava.classes.Diretor;
import cursojava.classes.Pessoa;
import cursojava.classes.Secretario;


public class TestandoClassesFilhas {
    
    public static void main(String[] args) {
        
        Aluno aluno = new Aluno();
        aluno.setNome("Moisés Prado");
        aluno.setIdade(32);
        
        Diretor diretor = new Diretor();
        diretor.setRegistroGeral("5265979");
        diretor.setNome("Willhams");
        
        Secretario secretario = new Secretario();
        secretario.setExperiencia("Administração");
        secretario.setNomePai("Mário Jorge");
        
        System.out.println("Salário aluno é = " + aluno.salario());
        System.out.println("Salário secretário é = " + secretario.salario());
        System.out.println("Salário diretor é = " + diretor.salario());
        
        teste(aluno);
        teste(diretor);
        teste(secretario);
        
                
    }
    
    public static void teste (Pessoa pessoa){
        System.out.println("Essa pessoa e demais = " + pessoa.getNome() + " e o salário é = " + pessoa.salario());
    }
}

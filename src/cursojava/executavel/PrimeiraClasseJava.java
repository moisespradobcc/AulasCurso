package cursojava.executavel;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import cursojava.classeauxiliares.FuncaoAutenticacao;
import cursojava.classes.Aluno;
import cursojava.classes.Diretor;
import cursojava.classes.Disciplina;
import cursojava.classes.Secretario;
import cursojava.constantes.StatusAluno;
import cursojava.excecao.ExcecaoProcessarNota;
import cursojava.interfaces.PermitirAcesso;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class PrimeiraClasseJava {

    /*Main é um método auto executável em Java*/
    public static void main(String[] args) {

        try {

//            lerArquivo();

            String login = JOptionPane.showInputDialog("Informe o login: ");
            String senha = JOptionPane.showInputDialog("Informe a senha: ");

            PermitirAcesso permitirAcesso = new Diretor(login, senha);

            if (new FuncaoAutenticacao(permitirAcesso).autenticar()) {/*Vou travar o contrato para autorizar somente quem realmente tem o contrato 100% legítimo*/

                List<Aluno> alunos = new ArrayList<>();

                HashMap<String, List<Aluno>> maps = new HashMap<String, List<Aluno>>();

                for (int qtd = 1; qtd <= 1; qtd++) {

                    /*new Aluno() é uma instancia (Criação de Objeto)*/
 /*Aluno1 e uma referência para o objeto aluno*/
                    String nome = JOptionPane.showInputDialog("Qual e o nome do aluno " + qtd + " ?: ");
                    String idade = JOptionPane.showInputDialog("Qual a idade?: ");
                    /*String dataNascimento = JOptionPane.showInputDialog("Data de nascimento?: ");
        String rg = JOptionPane.showInputDialog("Registro Geral?: ");
        String cpf = JOptionPane.showInputDialog("Qual e o CPF?: ");
        String mae = JOptionPane.showInputDialog("Nome da mãe?: ");
        String pai = JOptionPane.showInputDialog("Nome do pai?: ");
        String matricula = JOptionPane.showInputDialog("Data da matricula?: ");
        String serie = JOptionPane.showInputDialog("Série matriculada?: ");
        String escola = JOptionPane.showInputDialog("Nome da escola?: ");*/

                    Aluno Aluno1 = new Aluno();
                    Aluno1.setNome(nome);
                    Aluno1.setIdade(Integer.valueOf(idade));
                    /*Aluno1.setDataNascimento(dataNascimento);
        Aluno1.setRegistroGeral(rg);
        Aluno1.setNumeroCpf(cpf);
        Aluno1.setNomeMae(mae);
        Aluno1.setNomePai(pai);
        Aluno1.setDataMatricula(matricula);
        Aluno1.setSerieMatriculado(serie);
        Aluno1.setNomeEscola(escola);*/

                    for (int pos = 1; pos <= 1; pos++) {
                        String nomeDisciplina = JOptionPane.showInputDialog("Nome da disciplina " + pos + " ?");
                        String notaDisciplina = JOptionPane.showInputDialog("Nota da disciplina " + pos + " ?");

                        Disciplina disciplina = new Disciplina();
                        disciplina.setDisciplina(nomeDisciplina);
                        disciplina.setNota(Double.parseDouble(notaDisciplina));

                        Aluno1.getDisciplinas().add(disciplina);
                    }

                    int escolha = JOptionPane.showConfirmDialog(null, "Deseja remover alguma disciplina ?");

                    if (escolha == 0) {/*Opção SIM e Zero*/

                        int continuarRemover = 0;
                        int posicao = 1;

                        while (continuarRemover == 0) {
                            String disciplinaRemover = JOptionPane.showInputDialog("Qual a disciplina 1, 2, 3 ou 4 ?");
                            Aluno1.getDisciplinas().remove(Integer.valueOf(disciplinaRemover).intValue() - posicao);
                            posicao++;
                            continuarRemover = JOptionPane.showConfirmDialog(null, "Continuar a remover?");
                        }
                    }

                    alunos.add(Aluno1);
                }

                maps.put(StatusAluno.APROVADO, new ArrayList<Aluno>());
                maps.put(StatusAluno.REPROVADO, new ArrayList<Aluno>());
                maps.put(StatusAluno.RECUPERACAO, new ArrayList<Aluno>());

                for (Aluno aluno : alunos) {/*Separado em listas*/

                    if (aluno.getAlunoAprovado().equalsIgnoreCase(StatusAluno.APROVADO)) {
                        maps.get(StatusAluno.APROVADO).add(aluno);
                    } else if (aluno.getAlunoAprovado().equalsIgnoreCase(StatusAluno.RECUPERACAO)) {
                        maps.get(StatusAluno.RECUPERACAO).add(aluno);
                    } else if (aluno.getAlunoAprovado().equalsIgnoreCase(StatusAluno.REPROVADO)) {
                        maps.get(StatusAluno.REPROVADO).add(aluno);
                    }
                }

                System.out.println("-----------------------------Lista dos Aprovados-------------------------------");
                for (Aluno aluno : maps.get(StatusAluno.APROVADO)) {
                    System.out.println("Aluno(a)= " + aluno.getNome() + " Resultado = " + aluno.getAlunoAprovado() + " com média de = " + aluno.getMediaNota());
                    System.out.println("");
                }

                System.out.println("-------------------------Lista dos em Recuperação-------------------------------");
                for (Aluno aluno : maps.get(StatusAluno.RECUPERACAO)) {
                    System.out.println("Aluno(a)= " + aluno.getNome() + " Resultado = " + aluno.getAlunoAprovado() + " com média de = " + aluno.getMediaNota());
                    System.out.println("");
                }

                System.out.println("-----------------------------Lista dos Reprovados-------------------------------");
                for (Aluno aluno : maps.get(StatusAluno.REPROVADO)) {
                    System.out.println("Aluno(a)= " + aluno.getNome() + " Resultado = " + aluno.getAlunoAprovado() + " com média de = " + aluno.getMediaNota());
                    System.out.println("");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Acesso não permitido !");
            }
        } catch (Exception e) {//Captura todas as excessões que não prevemos

            StringBuilder saida = new StringBuilder();

            e.printStackTrace();/*Imprime erro no console Java*/


 /*Mensagem do erro ou causa*/
            System.out.println("Mensagem: " + e.getMessage());

            for (int pos = 0; pos < e.getStackTrace().length; pos++) {
                saida.append("\n Classe de erro: " + e.getStackTrace()[pos].getClassName());
                saida.append("\n método de erro: " + e.getStackTrace()[pos].getMethodName());
                saida.append("\n Linha de erro: " + e.getStackTrace()[pos].getLineNumber());
                saida.append("\n Classe: " + e.getClass().getName());
            }

            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro da exceção customizada " + e.getClass().getName());
        } finally {/*Sempre é executado ocorrendo erros ou não.*/
 /*Sempre e usado quando se precisa executar um processo ocorrendo erro ou não no sistema*/
            JOptionPane.showMessageDialog(null, "Obrigado por aprender java comigo");
        }
    }

    public static void lerArquivo() throws FileNotFoundException {
        File fil = new File("c://lines.txt");
        Scanner scanner = new Scanner(fil);

    }

}

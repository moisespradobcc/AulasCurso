package cursojava.classes;

import cursojava.constantes.StatusAluno;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/*Esta e nossa classe/objeto que representa o Aluno*/
public class Aluno extends Pessoa{

    /*Esses são os atributos do Aluno*/
    
    private String dataMatricula;
    private String nomeEscola;
    private String serieMatriculado;
    
    private List<Disciplina> disciplinas = new ArrayList<Disciplina>();

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }
    
    
    public Aluno() {/*Cria os dados na memória sendo padrão do Java*/

    }

    /*Veremos os métodos SETTERS E GETTERS*/
 /*SET e para adicionar ou receber dados para os atributos*/
 /*GET e para resgatasr obter o valor dos atributos*/
 /*Receber Dados*/
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getRegistroGeral() {
        return registroGeral;
    }

    public void setRegistroGeral(String registroGeral) {
        this.registroGeral = registroGeral;
    }

    public String getNumeroCpf() {
        return numeroCpf;
    }

    public void setNumeroCpf(String numeroCpf) {
        this.numeroCpf = numeroCpf;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public String getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(String dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    public String getNomeEscola() {
        return nomeEscola;
    }

    public void setNomeEscola(String nomeEscola) {
        this.nomeEscola = nomeEscola;
    }

    public String getSerieMatriculado() {
        return serieMatriculado;
    }

    public void setSerieMatriculado(String serieMatriculado) {
        this.serieMatriculado = serieMatriculado;
    }

    /*Método que retorna a média do aluno*/
    public double getMediaNota() {
        double somaNotas = 0.0;
            for(Disciplina disciplina : disciplinas){
            somaNotas += disciplina.getNota();
            }
         return somaNotas / disciplinas.size();
    }
    /*Método que retorna true para aprovado e false para reprovado*/
    public String getAlunoAprovado(){
        double media = this.getMediaNota();
        if (media >= 50) {
            if(media >=70){
                return StatusAluno.APROVADO;
            }else 
            return StatusAluno.RECUPERACAO;
        }else{
            return StatusAluno.REPROVADO;
                }
        }

    @Override
    public String toString() {
        return "Aluno{" + "nome=" + nome + ", idade=" + idade + ", dataNascimento=" + dataNascimento + ", registroGeral=" + registroGeral + ", numeroCpf=" + numeroCpf + ", nomeMae=" + nomeMae + ", nomePai=" + nomePai + ", dataMatricula=" + dataMatricula + ", nomeEscola=" + nomeEscola + ", serieMatriculado=" + serieMatriculado + ", disciplinas=" + disciplinas + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.nome);
        hash = 83 * hash + this.idade;
        hash = 83 * hash + Objects.hashCode(this.dataNascimento);
        hash = 83 * hash + Objects.hashCode(this.registroGeral);
        hash = 83 * hash + Objects.hashCode(this.numeroCpf);
        hash = 83 * hash + Objects.hashCode(this.nomeMae);
        hash = 83 * hash + Objects.hashCode(this.nomePai);
        hash = 83 * hash + Objects.hashCode(this.dataMatricula);
        hash = 83 * hash + Objects.hashCode(this.nomeEscola);
        hash = 83 * hash + Objects.hashCode(this.serieMatriculado);
        hash = 83 * hash + Objects.hashCode(this.disciplinas);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Aluno other = (Aluno) obj;
        if (this.idade != other.idade) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.dataNascimento, other.dataNascimento)) {
            return false;
        }
        if (!Objects.equals(this.registroGeral, other.registroGeral)) {
            return false;
        }
        if (!Objects.equals(this.numeroCpf, other.numeroCpf)) {
            return false;
        }
        if (!Objects.equals(this.nomeMae, other.nomeMae)) {
            return false;
        }
        if (!Objects.equals(this.nomePai, other.nomePai)) {
            return false;
        }
        if (!Objects.equals(this.dataMatricula, other.dataMatricula)) {
            return false;
        }
        if (!Objects.equals(this.nomeEscola, other.nomeEscola)) {
            return false;
        }
        if (!Objects.equals(this.serieMatriculado, other.serieMatriculado)) {
            return false;
        }
        if (!Objects.equals(this.disciplinas, other.disciplinas)) {
            return false;
        }
        return true;
    }

    @Override
    public double salario() {
        return 1500.90;
    }

  
    
}


    

    
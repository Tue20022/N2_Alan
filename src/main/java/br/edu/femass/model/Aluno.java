package br.edu.femass.model;
import java.util.List;

public class Aluno extends Leitor{
        private String matricula;

        public Aluno(){

        }

        public Aluno(String nome, String endereco, String telefone, String matricula) {
            super(nome, endereco, telefone);
            this.matricula = matricula;
            setPrazoMaximoDevolucao(15);
            this.codigo = proxNumero++;
            //atualizarCod();
        }

        public String getMatricula() {
            return matricula;
        }

        public void setMatricula(String matricula) {
            this.matricula = matricula;
        }

      /*  public void atualizarCod(){
            Long maior = 0L;
            try {
                List<Aluno> alunos = new DaoAluno().getAll();
                for (Aluno aluno : alunos) {
                    if (aluno.getCodigo() > maior) {
                        maior = aluno.getCodigo();
                        setCodigo(maior + 1);
                    }
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }*/
    }

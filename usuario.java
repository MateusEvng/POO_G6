package Codigo_Fonte;

public class usuario {
    public class Usuario {
        private String nome;
        private String email;
        private String senha;
        private Agenda agenda;
        //construtores 
        public Usuario(String nome, String email, String senha) {
            this.nome = nome;
            this.email = email;
            this.senha = senha;
            this.agenda = new Agenda();
        }
        //metodos
        public void criarEvento(Evento evento) {
            agenda.adicionarEvento(evento);
        }

        public void cancelarEvento(Evento evento) {
            agenda.removerEvento(evento);
        }

        public void editarEvento(Evento evento, String novoNome, LocalDateTime novaData) {
            evento.setNome(novoNome);
            evento.setData(novaData);
        }

        public void visualizarEvento(Evento evento) {
            System.out.println(evento);
        }
    }
}

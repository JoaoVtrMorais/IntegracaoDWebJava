package ConectaMongoDB;

public class Entrada {
    private String nome_completo;
    private String email;
    private String telefone;
    private String mensagem;
    private String contato_escolhido;
    private String motivo_contato;
    private boolean receber_novidades;

    public String getNome_completo() {
        return nome_completo;
    }

    public void setNome_completo(String nome_completo) {
        this.nome_completo = nome_completo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getContato_escolhido() {
        return contato_escolhido;
    }

    public void setContato_escolhido(String contato_escolhido) {
        this.contato_escolhido = contato_escolhido;
    }

    public String getMotivo_contato() {
        return motivo_contato;
    }

    public void setMotivo_contato(String motivo_contato) {
        this.motivo_contato = motivo_contato;
    }

    public boolean isReceber_novidades() {
        return receber_novidades;
    }

    public void setReceber_novidades(boolean receber_novidades) {
        this.receber_novidades = receber_novidades;
    }
    
    
    
}

package accademia.lynxspa.com.accademiaapp.data;


public class Contatto {

    private String nome;
    private String telefono;

    public Contatto(String nome, String numero){
        this.nome = nome;
        this.telefono = numero;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}

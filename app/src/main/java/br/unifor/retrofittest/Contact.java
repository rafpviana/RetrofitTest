package br.unifor.retrofittest;

/**
 * Created by rafaelpinheiro on 06/03/17.
 */

public class Contact {

    private String id;
    private String nome;
    private String telefone;
    private String email;
    private String observacao;
    private String created_at;
    private String updated_at;

    public Contact(String nome, String telefone, String email, String observacao){
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.observacao = observacao;

    }

    public String getId() {
        return id;
    }

    public String getName() {
        return nome;
    }

    public String getPhone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public String getObservation() {
        return observacao;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.nome = name;
    }

    public void setPhone(String phone) {
        this.telefone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setObservation(String observation) {
        this.observacao = observation;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
}

package model;

import java.io.Serializable;

public class ModelLogin implements Serializable {

    private static final long serialVersionUID = 1L;



    private Long id;
    private String nome;
    private String email;
    private String login;
    private String password;

    public ModelLogin() {
    }

    public ModelLogin(String login, String password) {
        this.login = login;
        this.password = password;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

package pe.edu.ulima.pichangers.beans;

public class LoginUser {
    private String usuario;
    private String password;

    public LoginUser(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }

    public LoginUser(){

    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

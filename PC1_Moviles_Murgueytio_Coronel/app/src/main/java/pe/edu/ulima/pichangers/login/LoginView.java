package pe.edu.ulima.pichangers.login;


public interface LoginView {
    public void setPresenter(LoginPresenter presenter);
    public void loginCorrecto();
    public void loginIncorrecto();
}

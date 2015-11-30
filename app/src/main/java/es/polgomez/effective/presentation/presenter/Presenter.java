package es.polgomez.effective.presentation.presenter;

public abstract class Presenter<V> {

    protected V view;

    public void setView(V view) {
        if (view == null) {
            throw new IllegalArgumentException("Presenter must have a view");
        }
        this.view = view;
    }

    public void checkVIewAlreadySetted() {
        if (view == null) {
            throw new IllegalArgumentException("Remember to set a view for this presenter");
        }
    }

    public abstract void initialize();

    public abstract void resume();

    public abstract void pause();

}

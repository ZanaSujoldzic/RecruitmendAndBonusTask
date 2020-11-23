package screen;

import java.io.Serializable;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.HttpServletResponse;

@Named(value = "endpointBean")
@ViewScoped
public class EndpointStatusBean implements Serializable {

    public EndpointStatusBean() {
    }

    public void endpoint() {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        HttpServletResponse hp = (HttpServletResponse) ec.getResponse();
        hp.setStatus(HttpServletResponse.SC_OK);
    }

}

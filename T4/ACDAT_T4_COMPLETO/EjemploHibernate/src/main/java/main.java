import com.iesbelen.dam.acdat.hibernate.dao.DireccionDAO;
import com.iesbelen.dam.acdat.hibernate.domain.Direccion;

public class main {

    public static void main(String[] args) {

        DireccionDAO direccionDAO = new DireccionDAO();

        direccionDAO.listar();


    }
}

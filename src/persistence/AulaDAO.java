package persistence;

import model.Aula;
import persistence.interfaces.IAulaDAO;

import java.util.ArrayList;
import java.util.List;

public class AulaDAO implements IAulaDAO {
    private final LocalDatabaseSingleton localDatabase;

    public AulaDAO() {
        this.localDatabase = LocalDatabaseSingleton.getInstance();
    }

    @Override
    public void addAula(Aula aula) {
        localDatabase.aulas.put(aula.getCodAula(), aula);
    }

    @Override
    public Aula getAula(int codAula) {
        return localDatabase.aulas.get(codAula);
    }

    @Override
    public List<Aula> getAllAulas() {
        return new ArrayList<Aula>(localDatabase.aulas.values());
    }

    @Override
    public void deleteAula(int codAula) {
        localDatabase.aulas.remove(codAula);
    }
}

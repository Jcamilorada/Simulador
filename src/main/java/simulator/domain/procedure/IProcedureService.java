package simulator.domain.procedure;

import java.util.List;

public interface IProcedureService
{
    public List<Procedure> getProcedures(String searchText);

    public Procedure findProcedure(String id);
}

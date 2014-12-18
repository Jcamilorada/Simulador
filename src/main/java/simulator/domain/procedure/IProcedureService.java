package simulator.domain.procedure;

import java.util.List;

public interface IProcedureService
{
    public List<Procedure> getProcedures(final String searchText);

    public Procedure findProcedure(final String id);
}

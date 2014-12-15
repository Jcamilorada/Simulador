package simulator.infusion.calculations;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import simulator.infusion.CalculationRequest;
import simulator.infusion.IModel;
import simulator.infusion.PumpInfusion;
import java.util.Collections;

/**
 * Test class for {@link PumpSolver}
 *
 * @author Alejandro Valdes
 */
public class PumpSolverTest
{
    private CalculationRequest request;

    private PumpSolver testInstance;

    @Before
    public void setUp()
    {
        MockitoAnnotations.initMocks(this);
        IModel model = new SchiderModel(55, 160, 22);

        testInstance = new PumpSolver();
        testInstance.setModel(model);
        request = new CalculationRequest();
        request.setModel(model);
        request.setDeltaTime(200);
        request.setInfusionRequestList(Collections.singletonList(new PumpInfusion(120, 2)));
    }

    @Test
    public void testSolve()
    {
        PumpInfusion actInfusion = testInstance.solve(request).getInfusionList().get(0);
    }
}

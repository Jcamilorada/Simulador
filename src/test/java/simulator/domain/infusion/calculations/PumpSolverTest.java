package simulator.domain.infusion.calculations;

import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import simulator.domain.common.Patient;
import simulator.domain.infusion.CalculationRequest;
import simulator.domain.infusion.CalculationResponse;
import simulator.domain.infusion.model.IModel;
import simulator.domain.infusion.PumpInfusion;
import simulator.domain.infusion.model.Model;
import simulator.domain.infusion.model.SchiderModel;

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
        Patient patient = new Patient();
        patient.setWeight(55);
        patient.setHeight(160);
        patient.setAge(22);
        IModel model = new SchiderModel(patient);

        testInstance = new PumpSolver();
        testInstance.setModel(model);
        request = new CalculationRequest();
        request.setModel(Model.Schider);
        request.setDeltaTime(900);
        request.setInfusionRequestList(Arrays.asList(new PumpInfusion(900, 2), new PumpInfusion(900, 2)));
    }

    @Test
    public void testSolve()
    {
        CalculationResponse response = testInstance.solve(request);
    }
}

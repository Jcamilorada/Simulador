package simulator.domain.infusion.calculations;

import static org.mockito.Mockito.when;

import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import simulator.configuration.PumpProperties;
import simulator.domain.infusion.Patient;
import simulator.domain.infusion.CalculationRequest;
import simulator.domain.infusion.CalculationResponse;
import simulator.domain.infusion.model.IModel;
import simulator.domain.infusion.InfusionRequest;
import simulator.domain.infusion.model.Model;
import simulator.domain.infusion.model.SchiderModel;

/**
 * Test class for {@link PumpSolver}
 *
 * @author Alejandro Valdes
 */
public class PumpSolverTest
{
    private static final double EPSILON = 0.05;
    private static final double MAXIMUM_INFUSION = 10D;
    private static final double MINIMUM_INFUSION = 1D;
    private static final int MAXIMUM_TIME = 10000;
    private CalculationRequest request;

    private PumpSolver testInstance;

    @Mock PumpProperties mockPumpProperties;

    @Before
    public void setUp()
    {
        MockitoAnnotations.initMocks(this);

        when(mockPumpProperties.getEpsilon()).thenReturn(EPSILON);
        when(mockPumpProperties.getMaximumInfusion()).thenReturn(MAXIMUM_INFUSION);
        when(mockPumpProperties.getMinimumInfusion()).thenReturn(MINIMUM_INFUSION);
        when(mockPumpProperties.getMaximumTime()).thenReturn(MAXIMUM_TIME);
        Patient patient = new Patient();
        patient.setWeight(55);
        patient.setHeight(160);
        patient.setAge(22);
        IModel model = new SchiderModel(patient);

        testInstance = new PumpSolver(mockPumpProperties);
        testInstance.setModel(model);
        request = new CalculationRequest();
        request.setModel(Model.Schider);
        request.setDeltaTime(50);
        request.setInfusionRequestList(Arrays.asList(new InfusionRequest(0, 500, 2), new InfusionRequest(700, 1000, 3)));
    }

    @Test
    public void testSolve()
    {
        CalculationResponse response = testInstance.solve(request);
    }
}

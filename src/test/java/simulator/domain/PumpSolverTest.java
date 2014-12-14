package simulator.domain;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import simulator.infusion.IModel;
import simulator.infusion.calculations.PumpSolver;
import simulator.infusion.calculations.SchiderModel;

/**
 * Created by alevalv on 11/20/14.
 */
public class PumpSolverTest
{
    IModel model;

    private PumpSolver testInstance;

    @Before
    public void setUp()
    {
        MockitoAnnotations.initMocks(this);
        //        when(mockModel.getCentralVolume()).thenReturn(CENTRAL_VOLUME);
        //        when(mockModel.getK(1,0)).thenReturn(4D);
        //        when(mockModel.getK(1,2)).thenReturn(1D);
        //        when(mockModel.getK(1,3)).thenReturn(1D);
        //        when(mockModel.getK(1,4)).thenReturn(1D);
        //        when(mockModel.getK(2,1)).thenReturn(1D);
        //        when(mockModel.getK(3,1)).thenReturn(1D);
        //        when(mockModel.getK(4,1)).thenReturn(0.001D);
        model = new SchiderModel(77, 150, 20);

        //testInstance = new PumpSolver(model);
    }

    @Test
    public void test()
    {
        //testInstance.solve(0.0000001, 100);
    }
}

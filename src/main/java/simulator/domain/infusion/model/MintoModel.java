package simulator.domain.infusion.model;

import com.google.common.base.Preconditions;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import simulator.domain.common.Gender;
import simulator.domain.common.Patient;

/**
 * Minto model for remifentanil.
 *
 * @author Alejandro Valdes
 */
public class MintoModel implements IModel
{
    /** A table to represent the weighted graph of the microrate constants. */
    private final Table<Integer, Integer, Double> weightedGraph = HashBasedTable.create();

    private final double centralVolume;

    /**
     * Creates a new {@link MintoModel} with the given parameters.
     *
     * @param patient the patient data.
     *
     * @throws NullPointerException if {@code gender} is null.
     */
    public MintoModel(final Patient patient)
    {
        Preconditions.checkNotNull(patient);
        double lbm;
        if (Gender.Male.equals(patient.getGender()))
        {
            lbm = (patient.getWeight() * 1.1D) - 128D * Math.pow(patient.getWeight() / patient.getHeight(), 2);
        }
        else
        {
            lbm = (patient.getWeight() * 1.07D) - 148D * Math.pow(patient.getWeight() / patient.getHeight(), 2);
        }
        double cl1 = 2.6D - 0.0162D * (patient.getAge() - 40D) + 0.0191D * (lbm - 55D);
        double cl2 = 2.05D / 0.0301D * (patient.getAge() / 40D);
        double cl3 = 0.076D - 0.00113D * (patient.getAge() / 40D);
        double centralVolume = 5.1D - 0.0201D * (patient.getAge() - 40D) + 0.072D * (lbm - 55D);
        double V2 = 9.82D - 0.0811D * (patient.getAge() - 40D) + 0.108D * (lbm -  55D);
        double V3 = 5.42D;
        double V4 = centralVolume / 10000D;

        weightedGraph.put(1, 3, (cl3 / centralVolume) / 60D);
        weightedGraph.put(1, 0, (cl1 / centralVolume) / 60D);
        weightedGraph.put(1, 2, (cl2 / centralVolume) / 60D);
        weightedGraph.put(1, 4, (weightedGraph.get(1, 0) / 10000D) / 60D);
        weightedGraph.put(2, 1, (cl2 / V2) / 60D);
        weightedGraph.put(3, 1, (cl3 / V3) / 60D);
        weightedGraph.put(4, 1, (0.595D - 0.007D * (patient.getAge() - 40)) / 60D);
        this.centralVolume= centralVolume * 1000;
    }

    @Override
    public double getK(int from, int to)
    {
        Double k = weightedGraph.get(from, to);
        return k == null ? 0 : k;
    }

    @Override
    public double getCentralVolume()
    {
        return centralVolume;
    }
}

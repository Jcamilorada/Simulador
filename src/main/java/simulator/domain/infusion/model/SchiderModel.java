package simulator.domain.infusion.model;

import com.google.common.base.Preconditions;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import simulator.domain.infusion.Gender;
import simulator.domain.infusion.Patient;

/**
 * Propofol (Schider) model.
 *
 * @author Alejandro Valdes
 */
public class SchiderModel implements IModel
{
    /** A table to represent the weighted graph of the microrate constants. */
    private final Table<Integer, Integer, Double> weightedGraph = HashBasedTable.create();

    /**
     * Creates a new Schider Model with the given parameters.
     *
     * @param patient the patient data.
     *
     * @throws NullPointerException if {@code patient} is null.
     */
    public SchiderModel(final Patient patient)
    {
        Preconditions.checkNotNull(patient);

        double lbm;
        if (Gender.Male.equals(patient.getGender()))
        {
            lbm = (patient.getWeight() * 1.1D)
                - 128D * Math.pow((double) patient.getWeight() / (double) patient.getHeight(), 2);
        }
        else
        {
            lbm = (patient.getWeight() * 1.07D)
                - 148D * Math.pow((double) patient.getWeight() / (double) patient.getHeight(), 2);
        }

        double k10 =  (0.443D + 0.0107D * (patient.getWeight() - 77D) - 0.0159D * (lbm - 59D) + 0.0062D * (patient.getHeight() - 177D)) / 60D;
        double k12 =  (0.302D - 0.0056D * (patient.getAge() - 53D)) / 60D;
        double k13 = 0.196D / 60D;
        double k14 = (0.456D / 10000D) / 60D;
        double k21 = ((1.29D - 0.024D * (patient.getAge() - 53D)) / (18.9D - 0.391D * (patient.getAge() - 53D))) / 60D;
        double k31 = 0.0035D / 60D;
        double k41 = 0.456D / 60D;

        weightedGraph.put(1, 0, k10);
        weightedGraph.put(1, 2, k12);
        weightedGraph.put(1, 3, k13);
        weightedGraph.put(1, 4, k14);
        weightedGraph.put(2, 1, k21);
        weightedGraph.put(3, 1, k31);
        weightedGraph.put(4, 1, k41);
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
        return 4270D;
    }
}

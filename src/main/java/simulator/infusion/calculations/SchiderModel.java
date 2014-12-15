package simulator.infusion.calculations;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import simulator.infusion.IModel;

/**
 * Propofol (Schider) model.
 *
 * @author Alejandro Valdes
 */
public class SchiderModel implements IModel
{
    private final Table<Integer, Integer, Double> weightedGraph = HashBasedTable.create();

    public SchiderModel(final double weight, final double height, final double age)
    {
        double lbm = (weight * 1.1) - 128 * Math.pow(weight / height, 2);
        weightedGraph.put(1, 0, (0.443D + 0.0107D * (weight - 77D) - 0.0159D * (lbm - 59D) + 0.0062D * (height - 177D)) / 60D);
        weightedGraph.put(1, 2, (0.302D - 0.0056D * (age - 53D)) / 60D);
        weightedGraph.put(1, 3, 0.196D / 60D);
        weightedGraph.put(1, 4, (0.456D / 10000D) / 60D);
        weightedGraph.put(2, 1, ((1.29D - 0.024D * (age - 53D)) / ((18.9D - 0.391D * (age - 53D)))) / 60D);
        weightedGraph.put(3, 1, 0.0035D / 60D);
        weightedGraph.put(4, 1, 0.456D / 60D);
    }

    @Override
    public double getK(int from, int to)
    {
        return weightedGraph.get(from, to);
    }

    @Override
    public double getCentralVolume()
    {
        return 4270;
    }
}

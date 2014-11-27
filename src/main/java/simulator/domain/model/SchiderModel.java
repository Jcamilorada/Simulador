package simulator.domain.model;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

/**
 * Created by alevalv on 11/25/14.
 */
public class SchiderModel implements IModel {
    private double k1; //do we need this thingy?
    private final Table<Integer, Integer, Double> weightedGraph = HashBasedTable.create();

    public SchiderModel(final double peso, final double estatura, final double edad)
    {
        double lbm = (peso * 1.1) - 128 * Math.pow(peso/estatura, 2);
        weightedGraph.put(1, 0, (0.443D * (peso-77) - 0.0159D*(lbm-59) + 0.0062D*(estatura-177))/60);
        weightedGraph.put(1, 2, (0.302-0.0056*(edad-53))/60);
        weightedGraph.put(1, 3, 0.196/60);
        weightedGraph.put(1, 4, (0.456/10000)/60);
        weightedGraph.put(2, 1, ((1.29-0.024*(edad-53))/((18.9-0.391*(edad-53))))/60);
        weightedGraph.put(3, 1, 0.0035/60);
        weightedGraph.put(4, 1, 0.456/60);
        k1 = weightedGraph.get(1, 0) + weightedGraph.get(1, 2) + weightedGraph.get(1, 3) + weightedGraph.get(1, 4);
    }
    @Override
    public double getK(int from, int to) {
        return weightedGraph.get(from, to);
    }

    @Override
    public double getCentralVolume() {
        return 4270;
    }
}

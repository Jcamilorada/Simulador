package simulator.domain.infusion.model;

/**
 * This interface defines the basic contract for a model that the {@link PumpSolver} uses to
 * create a simulation.
 *
 * @author Alejandro Valdes
 */
public interface IModel
{
    /**
     * Gets the microrate constants between compartments. This can be seen as a weighted graph.
     * The necessary values are:
     *
     * <ul>
     * <li>K(1,0)</li>
     * <li>K(1,2)</li>
     * <li>K(1,3)</li>
     * <li>K(1,4)</li>
     * <li>K(2,1)</li>
     * <li>K(3,1)</li>
     * <li>K(4,1)</li>
     * </ul>
     *
     * Is important that all the necessary values don't return null, by default should be 0.
     *
     * @param from the origin compartment number.
     * @param to the destination compartment number.
     *
     * @return the microrate constant between the two compartments.
     */
    double getK(int from, int to);

    /**
     * Gets the central volume of the patient, value must be milliliters.
     *
     * @return the central volume of the patient.
     */
    double getCentralVolume();
}

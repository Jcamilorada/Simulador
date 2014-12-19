package simulator.domain.surfacemodel;

import simulator.restservices.graphic.SurfaceMeshDTO;

/**
 * @author Juan Camilo Rada
 *
 * ISurfaceDataMeshService. Generate the {code SurfaceMeshDTO} that contains all the neccesary information to plot the
 * the surface model graphic.
 */
public interface ISurfaceDataMeshService
{
    SurfaceMeshDTO getSurfaceMeshDTO();
}

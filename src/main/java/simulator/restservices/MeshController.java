package simulator.restservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import simulator.domain.SystemParameter;
import simulator.services.graphic.ISurfaceDataMeshService;
import simulator.services.graphic.SurfaceMeshDTO;

@Controller
@RequestMapping("/parameter")
public class MeshController
{
    private ISurfaceDataMeshService surfaceDataMeshService;

    @Autowired
    public MeshController(final ISurfaceDataMeshService surfaceDataMeshService)
    {
        this.surfaceDataMeshService = surfaceDataMeshService;
    }

    @RequestMapping("/remi_prop")
    public @ResponseBody SurfaceMeshDTO getMesh()
    {
        return surfaceDataMeshService.getSurfaceMeshDTO();
    }
}

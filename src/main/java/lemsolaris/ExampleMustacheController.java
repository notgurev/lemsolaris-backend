package lemsolaris;

import lemsolaris.services.internal.AnomalyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@RestController
@RequestMapping("/")
public class ExampleMustacheController {
    final AnomalyService anomalyService;

    public ExampleMustacheController(AnomalyService anomalyService) {
        this.anomalyService = anomalyService;
    }

    @GetMapping("/exploredAnomaly")
    public ModelAndView getExploredAnomaly(Map<String, Object> model) {
        model.put("anomaly", anomalyService.getAnomalyByStatus("Exp"));
        return new ModelAndView("anomaly", model);
    }

    @GetMapping("/anomalyReport")
    public ModelAndView anomalyReport(Map<String, Object> model, @RequestParam(name = "id") int id) {
        model.put("anomalyReport", anomalyService.getReportAnomaly(id));
        return new ModelAndView("anomaly", model);
    }

}

package lemsolaris;

import lemsolaris.repositories.FlightExploration;
import lemsolaris.services.external.service.AnomalyService;
import lemsolaris.services.external.service.FlightService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
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
    final FlightService flightService;

    public ExampleMustacheController(AnomalyService anomalyService, FlightService flightService) {
        this.anomalyService = anomalyService;
        this.flightService = flightService;
    }

    @GetMapping("/main")
    public ModelAndView main(Map<String, Object> model) {
        return new ModelAndView("main", model);
    }

    @GetMapping("/Anomalies")
    public ModelAndView anomalies(Map<String, Object> model, @RequestParam(name = "type") String type) {
        model.put("fEanomalies", false);
        model.put("fUanomalies", false);
        model.put("fFlights", false);
        if(type.equals("Explored")){
            model.put("anomalies", anomalyService.getExploredAnomaly());
            model.put("fEanomalies", true);
        }else if(type.equals("Unexplored")) {
            model.put("anomalies", anomalyService.getUnexploredAnomaly());
            model.put("fUanomalies", true);
        }
        return new ModelAndView("anomalies", model);
    }

    @GetMapping("/flights")
    public ModelAndView flights(Map<String, Object> model) {
        model.put("flight", flightService.getFlights());
        return new ModelAndView("flights", model);
    }

    @GetMapping("/report")
    public ModelAndView report(Map<String, Object> model, @RequestParam(name = "id") int id) {
        model.put("flag", false);
        model.put("nflag", true);
        if(flightService.getReport(id) != null) {
            model.put("flag", true);
            model.put("nflag", false);
        }
        model.put("report_by_id", flightService.getReport(id));
        return new ModelAndView("report", model);
    }


//    @GetMapping("/createExplore")
//    public ModelAndView createExplore(Map<String, Object> model) {
//        return new ModelAndView("createTour", model);
//    }
//
//    @GetMapping("/createTour")
//    public ModelAndView createTour(Map<String, Object> model) {
//        return new ModelAndView("createExplore", model);
//    }

}

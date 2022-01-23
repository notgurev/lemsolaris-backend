package lemsolaris;

import lemsolaris.services.AnomalyService;
import lemsolaris.services.FlightCreator;
import lemsolaris.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@RestController
@RequestMapping("/")
public class MustacheController {
    final AnomalyService anomalyService;
    final FlightService flightService;
    final FlightCreator flightCreator;

    public MustacheController(AnomalyService anomalyService, FlightService flightService, FlightCreator flightCreator) {
        this.anomalyService = anomalyService;
        this.flightService = flightService;
        this.flightCreator = flightCreator;
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
        if (type.equals("Explored")) {
            model.put("anomalies", anomalyService.getExploredAnomalies());
            model.put("fEanomalies", true);
        } else if (type.equals("Unexplored")) {
            model.put("anomalies", anomalyService.getUnexploredAnomalies());
            model.put("fUanomalies", true);
        }
        return new ModelAndView("anomalies", model);
    }

    @GetMapping("/flights")
    public ModelAndView flights(Map<String, Object> model) {
        System.out.println(flightService.getFlights());
        model.put("flight", flightService.getFlights());
        return new ModelAndView("flights", model);
    }

    @GetMapping("/report")
    public ModelAndView report(Map<String, Object> model, @RequestParam(name = "id") int id) {
        model.put("flag", false);
        model.put("nflag", true);
        if (flightService.getExplorationReport(id) != null) {
            model.put("flag", true);
            model.put("nflag", false);
        }
        model.put("report_by_id", flightService.getExplorationReport(id));
        return new ModelAndView("report", model);
    }


    @GetMapping("/createExplore")
    public ModelAndView createExplore(Map<String, Object> model, @RequestParam(name = "id") int id) {
        flightCreator.createTourFlightToAnomaly(id);
        return new ModelAndView("flights", model);
    }

    @GetMapping("/createTour")
    public ModelAndView createTour(Map<String, Object> model, @RequestParam(name = "id") int id) {
        flightCreator.createExplorationToAnomaly(id);
        return new ModelAndView("flights", model);
    }

}

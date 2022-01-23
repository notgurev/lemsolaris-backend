package lemsolaris;

import lemsolaris.model.flight.Flight;
import lemsolaris.services.AnomalyService;
import lemsolaris.services.FlightCreator;
import lemsolaris.services.FlightService;
import lemsolaris.services.generators.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
public class MustacheController {
    final AnomalyService anomalyService;
    final TourService tourService;
    final FlightService flightService;
    final FlightCreator flightCreator;

    public MustacheController(AnomalyService anomalyService, FlightService flightService, FlightCreator flightCreator, TourService tourService) {
        this.anomalyService = anomalyService;
        this.flightService = flightService;
        this.flightCreator = flightCreator;
        this.tourService = tourService;
    }

    @GetMapping("/main")
    public ModelAndView main(Map<String, Object> model) {
        return new ModelAndView("main", model);
    }

    @GetMapping("/Anomalies")
    public ModelAndView anomalies(Map<String, Object> model, @RequestParam(name = "type") String type) {
        model.put("fEanomalies", false);
        model.put("fUanomalies", false);
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
        ArrayList<Flight> flights = (ArrayList<Flight>) flightService.getFlights();
        model.put("flight", flights);
        return new ModelAndView("flights", model);
    }

    @GetMapping("/report")
    public ModelAndView report(Map<String, Object> model, @RequestParam(name = "id") int id, @RequestParam(name = "type") String type) {
        model.put("flag", false);
        model.put("nflag", true);
        if (type.equals("Exploration")) {
            if (flightService.getExplorationReport(id).isPresent()) {
                model.put("nflag", false);
                model.put("flag", true);
                model.put("report_by_id", flightService.getExplorationReport(id).get());
            }
        }
        else if (type.equals("Tour")){
            if(tourService.getTourReportById(id).isPresent()){
                model.put("nflag", false);
                model.put("flag", true);
                model.put("report_by_id", tourService.getTourReportById(id).get());
            }
        }
        return new ModelAndView("report", model);
    }


    @GetMapping("/createExplore")
    public ModelAndView createExplore(Map<String, Object> model, @RequestParam(name = "id") int id) {
        flightCreator.createExplorationToAnomaly(id);
        ArrayList<Flight> flights = (ArrayList<Flight>) flightService.getFlights();
        model.put("flight", flights);
        return new ModelAndView("flights", model);
    }

    @GetMapping("/createTour")
    public ModelAndView createTour(Map<String, Object> model, @RequestParam(name = "id") int id) {
        flightCreator.createTourFlightToAnomaly(2);
        return new ModelAndView("flights", model);
    }

}

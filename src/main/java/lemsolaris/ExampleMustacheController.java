package lemsolaris;

import lemsolaris.model.flight.Flight;
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

    @GetMapping("/main")
    public ModelAndView mainPage(Map<String, Object> model) {
        return new ModelAndView("main", model);
    }


    @GetMapping("/exploredAnomaly")
    public ModelAndView getExploredAnomaly(Map<String, Object> model) {
        model.put("anomaly", anomalyService.getExploredAnomalies());
        return new ModelAndView("anomaly", model);
    }

    @GetMapping("/anomalyReport")
    public ModelAndView anomalyReport(Map<String, Object> model, @RequestParam(name = "id") int id) {
        model.put("anomalyReport", anomalyService.getReportAnomaly(id));
        return new ModelAndView("anomaly_report", model);
    }


    @GetMapping("/newTourFlight")
    public ModelAndView registerNewFlight(Map<String, Object> model, @RequestParam(name = "id") int anomaly_id, @RequestParam(name = "ticketMoney") int money) {
        //anomaly_id - аномалия на которую вылет
        //money - цена билета
        //newFlight(anomaly_id, money, ....) -- создает туристический вылет на аномалию
        return new ModelAndView("registerFlight", model);
    }



}

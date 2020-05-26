package adam.biegi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.lang3.builder.CompareToBuilder;

@Controller
@RequestMapping(path = "/bieg")
public class Controler {
    @Autowired
    RunnerRepository runnerRepository;
    List<Runner> runnerList;



    @PostMapping("/add")
    public String addRunner(@ModelAttribute Runner runner) {
        Runner runner1 = new Runner();
        runner1.setId(runner.getId());
        runner1.setImie(runner.getImie());
        runner1.setNazwisko(runner.getNazwisko());
        runner1.setCzas(runner.getCzas());
        runnerRepository.save(runner1);
        return "redirect:/bieg/all";
    }

    @GetMapping("/all")
    public String getAllStudents(Model model) {
        getAllRunners();
        model.addAttribute("all", czas(runnerList));
        model.addAttribute("addRunner", new Runner());
        return "dziennik";
    }


    public List<Runner> getAllRunners() {
        runnerList = runnerRepository.findAll();
        return runnerList;
    }

    public List<Runner> czas(List<Runner> runners) {
        Comparator<Runner> runnerComparator = new Comparator<Runner>() {
            @Override
            public int compare(Runner o1, Runner o2) {
                return new CompareToBuilder()
                        .append(o1.getCzas(), o2.getCzas())
                        .build();
            }
        };
        List<Runner> all = runners;
        Collections.sort(all, runnerComparator);
        return all;
    }
}


package securityinmemory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import securityinmemory.model.Canton;
import securityinmemory.service.CantonService;

/**
 * Created by Alexis on 05/04/2017.
 */

@Controller
public class CantonController {

    @Autowired
    private CantonService cantonService;

//    obtener todos los cantones
    @RequestMapping(value = "/cantones",method = RequestMethod.GET)
    public String listCanton(Model model){
        model.addAttribute("cantones",cantonService.listAllCantons());
        return "cantons";
    }

//    Obtener por medio de un identificador
    @RequestMapping(value = "/cantones/{id}")
    public String showCanton(@PathVariable Integer id,Model model){
        model.addAttribute("cant",cantonService.getCantonById(id));
        return "viewCanton";
    }

//    create and save

    @RequestMapping(value = "/cantones/create")
    public String createCanton(Model model){
        model.addAttribute("canton",new Canton());
        return "cantonForm";
    }

    @RequestMapping(value = "/cantones/save",method = RequestMethod.POST)
    public String saveCanton(Canton canton,Model model){
        Canton savedCanton=cantonService.saveCanton(canton);
        return "redirect:/cantones/"+savedCanton.getCntId();
    }

//    Editar mediante un  id
    @RequestMapping("/cantones/edit/{id}")
    public String editCanton(@PathVariable int id, Model model) {
        model.addAttribute("canton", cantonService.getCantonById(id));
        return "cantonForm";
    }

//    Delete from a id
    @RequestMapping("/cantones/delete/{id}")
    public String deleteCanton(@PathVariable int id, RedirectAttributes redirectAttributes) {
        cantonService.deleteCanton(id);
        redirectAttributes.addFlashAttribute("message","Canton eliminado ");
        return "redirect:/cantones/";
    }
}



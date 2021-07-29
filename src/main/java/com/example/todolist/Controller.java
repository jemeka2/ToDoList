package com.example.todolist;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.ArrayList;

@org.springframework.stereotype.Controller
public class Controller {

    public static long idCounter = 0;

    ArrayList<Item> items = new ArrayList<>();
    @GetMapping("/newItem")
    public String loadForm(Model model){
        Item newItem = new Item();
        idSetter(newItem);
        model.addAttribute("item", newItem);
        return "newItem";
    }

    @PostMapping("/itemConfirm")
    public String loadFromPage(@Valid Item item, BindingResult result){
        if(result.hasErrors()){
            return "newItem";
        }
        items.add(item);
        return "confirmitem";
    }

    @RequestMapping("/allItems")
    public String allItems(Model model){
        model.addAttribute("items", items);
        return "allItems";
    }

    @RequestMapping("/update/{id}")
    public String updateItem(@PathVariable("id") long id, Model model){
        for (Item item: items){
            if(id == item.getId()){
                model.addAttribute("item", item);
                break;
            }
        }
        return "newItem";
    }

    @RequestMapping("/detail/{id}")
    public String detailItem(@PathVariable("id") long id, Model model){
        for (Item item: items){
            if(id == item.getId()){
                model.addAttribute("item", item);
                break;
            }
        }
        return "confirmitem";
    }

    static void idSetter(Item item){
        idCounter = idCounter + 1;
        item.setId(idCounter);
    }
}

package ra.trys.spring.tt.items;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("items")
@RequiredArgsConstructor
public class ItemController {

    private final ItemRepository itemRepository;

    @GetMapping
    public String getAll(Model model) {
        var items = itemRepository.findAll();
        model.addAttribute("items", items);
        return "items/items";
    }

    @GetMapping("{id}")
    public String getOne(@PathVariable Long id, Model model) {
        var item = itemRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        model.addAttribute("item", item);
        return "items/item";
    }

    @GetMapping("/add")
    public String getAdd(Model model) {
        model.addAttribute("item", new Item());
        return "items/item-add";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("item") Item item, BindingResult result) {
        if (result.hasErrors()) {
            return "items/item-add";
        }
        var id = itemRepository.save(item).getId();
        return "redirect:/items/" + id;
    }

    @GetMapping("edit/{id}")
    public String getEdit(@PathVariable Long id, Model model) {
        var item = itemRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        model.addAttribute("item", item);
        return "items/item-edit";
    }

    @PostMapping("edit/{id}")
    public String edit(@PathVariable Long id, @ModelAttribute Item item) {
        itemRepository.save(item.withId(id));
        return "redirect:/items/" + id;
    }
}

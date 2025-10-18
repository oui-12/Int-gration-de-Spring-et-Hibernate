package controller;

import dao.IDao;
import entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    @Qualifier("categoryDaoImpl")
    private IDao<Category> categoryDao;

    @GetMapping
    public String listCategories(Model model) {
        model.addAttribute("categories", categoryDao.findAll());
        return "categories/list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("category", new Category());
        return "categories/form";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        Category category = categoryDao.findById(id);
        if (category == null) {
            return "redirect:/categories";
        }
        model.addAttribute("category", category);
        return "categories/form";
    }

    @PostMapping("/save")
    public String saveCategory(@ModelAttribute Category category) {
        if (category.getId() == 0) {
            categoryDao.create(category);
        } else {
            categoryDao.update(category);
        }
        return "redirect:/categories";
    }

    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable int id) {
        Category category = categoryDao.findById(id);
        if (category != null) {
            categoryDao.delete(category);
        }
        return "redirect:/categories";
    }
}


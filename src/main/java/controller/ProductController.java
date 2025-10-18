package controller;

import dao.IDao;
import entities.Category;
import entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    @Qualifier("productDaoImpl")
    private IDao<Product> productDao;

    @Autowired
    @Qualifier("categoryDaoImpl")
    private IDao<Category> categoryDao;

    @GetMapping
    public String listProducts(Model model) {
        model.addAttribute("products", productDao.findAll());
        return "products/list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("categories", categoryDao.findAll());
        return "products/form";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        Product product = productDao.findById(id);
        if (product == null) {
            return "redirect:/products";
        }
        model.addAttribute("product", product);
        model.addAttribute("categories", categoryDao.findAll());
        return "products/form";
    }

    @PostMapping("/save")
    public String saveProduct(@ModelAttribute Product product, @RequestParam(required = false) Integer categoryId) {
        if (categoryId != null && categoryId > 0) {
            Category category = categoryDao.findById(categoryId);
            product.setCategory(category);
        }
        
        if (product.getId() == 0) {
            productDao.create(product);
        } else {
            productDao.update(product);
        }
        return "redirect:/products";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        Product product = productDao.findById(id);
        if (product != null) {
            productDao.delete(product);
        }
        return "redirect:/products";
    }
}


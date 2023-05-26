package com.example.ongk.controllers;
import com.example.ongk.entity.Product;
import com.example.ongk.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController("/products")
public class ProductController {
    @Autowired
    private ProductService productService;


    /**
     * List all products.
     *
     * @param model
     * @return
     */
    @GetMapping("/")
    public ModelAndView list(Model model) {
//        model.addAttribute("products", productService.listAllProducts());
        List<Product> products = productService.listAllProducts();
        System.out.println("Returning products:");
        ModelAndView modelAndView = new ModelAndView("index.html");
        modelAndView.addObject("products", products);
        return modelAndView;

    }

    /**
     * View a specific product by its id.
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/{id}")
    public String showProduct(@PathVariable Integer id, Model model) {
        model.addAttribute("product", productService.getProductById(id));
        return "productshow";
    }

    // Afficher le formulaire de modification du Product
    @PutMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("product", productService.getProductById(id));
        return "productform";
    }

    /**
     * New product.
     *
     * @param model
     * @return
     */
    @RequestMapping("product/new")
    public ModelAndView newProduct(Model model) {
        ModelAndView modelAndView = new ModelAndView("productform.html");
        return modelAndView;
    }

    /**
     * Save product to database.
     *
     * @param product
     * @return
     */
    @RequestMapping(value = "product", method = RequestMethod.POST)
    public String saveProduct(Product product) {
        productService.saveProduct(product);
        return "redirect:/product/" + product.getId();
    }

    /**
     * Delete product by its id.
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        productService.deleteProduct(id);
        return "redirect:/products";
    }
}
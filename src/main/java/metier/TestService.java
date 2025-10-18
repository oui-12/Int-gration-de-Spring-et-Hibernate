package metier;

import dao.IDao;
import entities.Category;
import entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TestService {

    @Autowired
    @Qualifier("productDaoImpl")
    private IDao<Product> productDao;

    @Autowired
    @Qualifier("categoryDaoImpl")
    private IDao<Category> categoryDao;

    public void runTest() {
        // Créer des catégories
        Category electronics = new Category("Électronique", "Appareils électroniques et gadgets");
        Category clothing = new Category("Vêtements", "Vêtements et accessoires");
        
        categoryDao.create(electronics);
        categoryDao.create(clothing);
        
        System.out.println("✅ Catégories créées : " + electronics.getName() + ", " + clothing.getName());

        // Créer des produits avec catégories
        Product laptop = new Product("Ordinateur portable HP", 899.99);
        laptop.setCategory(electronics);
        
        Product phone = new Product("Smartphone Samsung", 599.99);
        phone.setCategory(electronics);
        
        Product shirt = new Product("T-shirt Nike", 29.99);
        shirt.setCategory(clothing);
        
        productDao.create(laptop);
        productDao.create(phone);
        productDao.create(shirt);
        
        System.out.println("✅ Produits créés avec catégories :");
        System.out.println("   - " + laptop.getName() + " (Catégorie: " + laptop.getCategory().getName() + ")");
        System.out.println("   - " + phone.getName() + " (Catégorie: " + phone.getCategory().getName() + ")");
        System.out.println("   - " + shirt.getName() + " (Catégorie: " + shirt.getCategory().getName() + ")");
        
        // Afficher toutes les catégories
        System.out.println("\n📋 Liste des catégories :");
        List<Category> categories = categoryDao.findAll();
        categories.forEach(cat -> 
            System.out.println("   - " + cat.getName() + ": " + cat.getDescription())
        );
        
        // Afficher tous les produits
        System.out.println("\n📋 Liste des produits :");
        List<Product> products = productDao.findAll();
        products.forEach(prod -> 
            System.out.println("   - " + prod.getName() + " - " + prod.getPrice() + "€ " +
                    "(Catégorie: " + (prod.getCategory() != null ? prod.getCategory().getName() : "Aucune") + ")")
        );
        
        System.out.println("\n✅ Test terminé avec succès !");
    }
}


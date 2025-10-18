package integration;

import config.TestHibernateConfig;
import dao.IDao;
import entities.Category;
import entities.Product;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {TestHibernateConfig.class})
@Transactional
public class ProductIntegrationTest {

    @Autowired
    @Qualifier("productDaoImpl")
    private IDao<Product> productDao;

    @Autowired
    @Qualifier("categoryDaoImpl")
    private IDao<Category> categoryDao;

    private Category testCategory;

    @BeforeEach
    void setUp() {
        // Créer une catégorie de test
        testCategory = new Category("Test Category", "Description de test");
        categoryDao.create(testCategory);
    }

    @Test
    void testCreateAndFindProduct() {
        // Arrange
        Product product = new Product("Test Product", 99.99);
        product.setCategory(testCategory);

        // Act
        productDao.create(product);
        Product found = productDao.findById(product.getId());

        // Assert
        assertNotNull(found);
        assertEquals("Test Product", found.getName());
        assertEquals(99.99, found.getPrice());
        assertNotNull(found.getCategory());
        assertEquals("Test Category", found.getCategory().getName());
    }

    @Test
    void testFindAllProducts() {
        // Arrange
        Product product1 = new Product("Product 1", 10.0);
        Product product2 = new Product("Product 2", 20.0);
        product1.setCategory(testCategory);
        product2.setCategory(testCategory);

        // Act
        productDao.create(product1);
        productDao.create(product2);
        List<Product> products = productDao.findAll();

        // Assert
        assertNotNull(products);
        assertTrue(products.size() >= 2);
    }

    @Test
    void testUpdateProduct() {
        // Arrange
        Product product = new Product("Original Name", 50.0);
        product.setCategory(testCategory);
        productDao.create(product);

        // Act
        product.setName("Updated Name");
        product.setPrice(75.0);
        productDao.update(product);
        Product updated = productDao.findById(product.getId());

        // Assert
        assertNotNull(updated);
        assertEquals("Updated Name", updated.getName());
        assertEquals(75.0, updated.getPrice());
    }

    @Test
    void testDeleteProduct() {
        // Arrange
        Product product = new Product("Product to Delete", 30.0);
        productDao.create(product);
        int productId = product.getId();

        // Act
        productDao.delete(product);
        Product deleted = productDao.findById(productId);

        // Assert
        assertNull(deleted);
    }

    @Test
    void testProductWithoutCategory() {
        // Arrange
        Product product = new Product("No Category Product", 15.0);

        // Act
        productDao.create(product);
        Product found = productDao.findById(product.getId());

        // Assert
        assertNotNull(found);
        assertNull(found.getCategory());
    }
}


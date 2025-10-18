package metier;

import dao.IDao;
import entities.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductDaoImplTest {

    @Mock
    private SessionFactory sessionFactory;

    @Mock
    private Session session;

    @Mock
    private Query<Product> query;

    @InjectMocks
    private ProductDaoImpl productDao;

    @BeforeEach
    void setUp() {
        when(sessionFactory.getCurrentSession()).thenReturn(session);
    }

    @Test
    void testCreate() {
        // Arrange
        Product product = new Product("Test Product", 99.99);

        // Act
        boolean result = productDao.create(product);

        // Assert
        assertTrue(result);
        verify(session, times(1)).save(product);
    }

    @Test
    void testFindById() {
        // Arrange
        Product product = new Product("Test Product", 99.99);
        when(session.get(Product.class, 1)).thenReturn(product);

        // Act
        Product result = productDao.findById(1);

        // Assert
        assertNotNull(result);
        assertEquals("Test Product", result.getName());
        assertEquals(99.99, result.getPrice());
        verify(session, times(1)).get(Product.class, 1);
    }

    @Test
    void testFindAll() {
        // Arrange
        List<Product> products = Arrays.asList(
            new Product("Product 1", 10.0),
            new Product("Product 2", 20.0)
        );
        when(session.createQuery(anyString(), eq(Product.class))).thenReturn(query);
        when(query.list()).thenReturn(products);

        // Act
        List<Product> result = productDao.findAll();

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Product 1", result.get(0).getName());
        assertEquals("Product 2", result.get(1).getName());
        verify(session, times(1)).createQuery("from Product", Product.class);
    }

    @Test
    void testUpdate() {
        // Arrange
        Product product = new Product("Updated Product", 150.0);

        // Act
        boolean result = productDao.update(product);

        // Assert
        assertTrue(result);
        verify(session, times(1)).update(product);
    }

    @Test
    void testDelete() {
        // Arrange
        Product product = new Product("Product to Delete", 50.0);

        // Act
        boolean result = productDao.delete(product);

        // Assert
        assertTrue(result);
        verify(session, times(1)).delete(product);
    }
}


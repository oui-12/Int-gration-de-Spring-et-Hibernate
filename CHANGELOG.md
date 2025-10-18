# 📝 Changelog

Tous les changements notables de ce projet seront documentés dans ce fichier.

Le format est basé sur [Keep a Changelog](https://keepachangelog.com/fr/1.0.0/),
et ce projet adhère au [Semantic Versioning](https://semver.org/lang/fr/).

## [1.0.0] - 2025-10-18

### ✨ Ajouté

#### Entités et Relations

- Entité `Product` avec les propriétés : id, name, price, category
- Entité `Category` avec les propriétés : id, name, description
- Relation `@ManyToOne` entre Product et Category
- Relation bidirectionnelle `@OneToMany` de Category vers Product

#### Couche DAO

- Interface générique `IDao<T>` pour les opérations CRUD
- Implémentation `ProductDaoImpl` avec toutes les méthodes CRUD
- Implémentation `CategoryDaoImpl` avec toutes les méthodes CRUD
- Gestion des transactions avec `@Transactional`

#### Configuration

- `HibernateConfig` : Configuration Java-based pour Hibernate
- `WebMvcConfig` : Configuration Spring MVC avec Thymeleaf
- `TestHibernateConfig` : Configuration pour les tests avec H2
- Fichiers `application.properties` et `hibernate.cfg.xml`

#### Interface Web

- **HomeController** : Page d'accueil avec navigation
- **ProductController** : CRUD complet pour les produits
  - Liste des produits avec catégories
  - Formulaire de création/modification
  - Suppression avec confirmation
- **CategoryController** : CRUD complet pour les catégories
  - Liste des catégories
  - Formulaire de création/modification
  - Suppression

#### Vues Thymeleaf

- `home.html` : Page d'accueil moderne avec CSS
- `products/list.html` : Tableau de produits avec actions
- `products/form.html` : Formulaire produit avec sélection de catégorie
- `categories/list.html` : Tableau de catégories
- `categories/form.html` : Formulaire catégorie
- Design responsive et moderne

#### Tests

- **Tests unitaires** (5 tests) :

  - `ProductDaoImplTest` avec Mockito
  - Tests de toutes les opérations CRUD
  - Isolation complète avec mocks

- **Tests d'intégration** (5 tests) :
  - `ProductIntegrationTest` avec Spring Test
  - Tests avec base H2 en mémoire
  - Tests transactionnels avec rollback
  - Tests des relations JPA

#### Classes de démonstration

- `Presentation2` : Test simple de création de produit
- `TestCategoryProduct` : Test complet des relations
- `TestService` : Service pour les tests transactionnels

#### Dépendances

- Spring Framework 5.3.22 (Core, Context, ORM, MVC, TX)
- Hibernate 5.6.12.Final
- MySQL Connector 8.0.29
- Thymeleaf 3.0.15.RELEASE
- JUnit 5.9.3
- Mockito 5.3.1
- H2 Database 2.1.214 (tests)
- JAXB 2.3.1 (support Java 11+)

#### Documentation

- README.md complet avec instructions détaillées
- CONTRIBUTING.md avec guidelines de contribution
- CHANGELOG.md (ce fichier)
- .gitignore adapté pour projets Java/Maven

### 🔧 Technique

- Configuration entièrement Java-based (pas de XML Spring)
- Support Java 17
- Maven comme gestionnaire de build
- Scan automatique des composants avec `@ComponentScan`
- Gestion des transactions déclaratives
- Support des annotations JPA/Hibernate

### ✅ Tests

- **10 tests** au total
- **0 échecs**
- **100% de réussite**
- Couverture de la couche DAO
- Tests unitaires et d'intégration

### 📊 Statistiques

- **15+ classes** Java
- **6 vues** Thymeleaf
- **2000+ lignes** de code
- **10+ technologies** utilisées

---

## [0.1.0] - 2025-10-18 (Version initiale)

### Ajouté

- Structure initiale du projet
- Configuration Maven
- Entité Product de base
- DAO simple pour Product
- Configuration Hibernate basique
- Test de connexion MySQL

---

## Format

- `Ajouté` pour les nouvelles fonctionnalités
- `Modifié` pour les changements dans les fonctionnalités existantes
- `Déprécié` pour les fonctionnalités bientôt supprimées
- `Supprimé` pour les fonctionnalités supprimées
- `Corrigé` pour les corrections de bugs
- `Sécurité` pour les vulnérabilités corrigées

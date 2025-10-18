# 🚀 Spring Hibernate Demo

Application web de gestion de **produits** et **catégories** avec **Spring**, **Hibernate** et **Thymeleaf**.

---

## 📖 Description

Application complète démontrant l'intégration Spring + Hibernate :

- Gestion CRUD de produits et catégories
- Relations JPA (@ManyToOne / @OneToMany)
- Interface web moderne
- Tests unitaires et d'intégration

---

## ✨ Fonctionnalités

- ✅ **CRUD complet** - Créer, Lire, Modifier, Supprimer
- ✅ **Relation ManyToOne** - Un produit → Une catégorie
- ✅ **Interface web moderne** - Design avec gradients et animations
- ✅ **Transactions automatiques** - Gestion avec @Transactional
- ✅ **10 tests** - 100% de réussite (unitaires + intégration)
- ✅ **Configuration Java** - Pas de XML pour Spring

---

## 🛠 Technologies

**Backend:** Java 17, Spring 5.3, Hibernate 5.6, MySQL 8.0  
**Frontend:** Thymeleaf, HTML5/CSS3, Font Awesome  
**Tests:** JUnit 5, Mockito, H2 Database  
**Build:** Maven

---

## 📦 Installation

### 1. Cloner le projet

```bash
git clone https://github.com/oui-12/Int-gration-de-Spring-et-Hibernate.git
cd Int-gration-de-Spring-et-Hibernate
```

### 2. Créer la base de données MySQL

```sql
CREATE DATABASE base;
```

### 3. Configurer la connexion

Modifier `src/main/resources/application.properties` :

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/base?serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=votre_mot_de_passe
```

### 4. Compiler et lancer

```bash
mvn clean compile
mvn exec:java -Dexec.mainClass="presentation.TestCategoryProduct"
```

---

## 💻 Utilisation

### Exécuter les différentes classes

**Test de configuration :**

```bash
mvn exec:java -Dexec.mainClass="test.TestHibernate"
```

**Créer un produit simple :**

```bash
mvn exec:java -Dexec.mainClass="presentation.Presentation2"
```

**Test complet avec catégories :**

```bash
mvn exec:java -Dexec.mainClass="presentation.TestCategoryProduct"
```

### Voir l'interface web

Ouvrez les fichiers dans `demo-static/` directement dans votre navigateur :

- `demo-static/index.html` - Page d'accueil
- `demo-static/products.html` - Liste des produits
- `demo-static/categories.html` - Liste des catégories

---

## 🧪 Tests

```bash
mvn test
```

**Résultats :**

- ✅ 10 tests exécutés
- ✅ 0 échecs
- ✅ 100% de réussite

**Tests unitaires (5)** - `ProductDaoImplTest` avec Mockito  
**Tests d'intégration (5)** - `ProductIntegrationTest` avec Spring Test + H2

---

## 📁 Structure du projet

```
src/
├── main/java/
│   ├── controller/        # Contrôleurs Spring MVC
│   ├── dao/               # Interfaces DAO
│   ├── entities/          # Entités JPA (Product, Category)
│   ├── metier/            # Implémentations DAO
│   └── util/              # Configuration Hibernate
├── main/webapp/
│   └── WEB-INF/views/     # Vues Thymeleaf
├── test/java/
│   ├── config/            # Configuration tests
│   ├── integration/       # Tests d'intégration
│   └── metier/            # Tests unitaires
└── demo-static/           # Pages HTML statiques (démo visuelle)
```

---

## 🎓 Concepts techniques

| Concept                      | Implémentation                  |
| ---------------------------- | ------------------------------- |
| **Pattern DAO**              | Interface `IDao<T>` générique   |
| **Injection de dépendances** | `@Autowired` + `@Qualifier`     |
| **Transactions**             | `@Transactional` déclaratif     |
| **Relations JPA**            | `@ManyToOne` / `@OneToMany`     |
| **Spring MVC**               | Contrôleurs + Thymeleaf         |
| **Tests**                    | JUnit 5 + Mockito + Spring Test |

---

## 🔧 Configuration

### Hibernate (`HibernateConfig.java`)

- DataSource MySQL configuré
- SessionFactory avec scan du package `entities`
- TransactionManager pour les transactions

### Spring MVC (`WebMvcConfig.java`)

- ViewResolver Thymeleaf
- Scan des packages `controller`, `metier`, `dao`
- Support des transactions

---

## 🐛 Troubleshooting

**❌ Erreur MySQL :** `Unknown database 'base'`  
→ Créez la base : `CREATE DATABASE base;`

**❌ Erreur :** `Access denied for user 'root'`  
→ Vérifiez le mot de passe dans `application.properties`

**❌ Tests qui échouent :**  
→ Exécutez : `mvn clean test -U`

---

## 📊 Statistiques

- **15+ classes** Java
- **6 vues** Thymeleaf
- **10 tests** (100% réussis)
- **2000+ lignes** de code
- **10+ technologies**

---

## 📚 Améliorations futures

- [ ] Spring Security pour l'authentification
- [ ] API REST
- [ ] Pagination des listes
- [ ] Upload d'images produits
- [ ] Recherche avancée
- [ ] Docker

---

## 👤 Auteur

Créé par **ElKansouli Ouiam**  
🔗 GitHub: [@oui-12](https://github.com/oui-12)

---

## 📄 Licence

Projet éducatif - Libre d'utilisation

---

⭐ **Si ce projet vous a aidé, donnez-lui une étoile sur GitHub !**


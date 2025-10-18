# 🤝 Guide de Contribution

Merci de votre intérêt pour contribuer à ce projet ! Voici quelques directives pour vous aider.

## 📋 Comment contribuer

### 1. Fork le projet

Cliquez sur le bouton "Fork" en haut à droite de la page GitHub.

### 2. Clonez votre fork

```bash
git clone https://github.com/votre-username/spring-hibernate-demo.git
cd spring-hibernate-demo
```

### 3. Créez une branche pour votre fonctionnalité

```bash
git checkout -b feature/ma-nouvelle-fonctionnalite
```

### 4. Faites vos modifications

- Écrivez du code propre et commenté
- Suivez les conventions de nommage Java
- Ajoutez des tests pour les nouvelles fonctionnalités
- Mettez à jour la documentation si nécessaire

### 5. Testez vos modifications

```bash
mvn clean test
```

Assurez-vous que tous les tests passent !

### 6. Committez vos changements

```bash
git add .
git commit -m "feat: ajout de la fonctionnalité X"
```

### 7. Poussez vers votre fork

```bash
git push origin feature/ma-nouvelle-fonctionnalite
```

### 8. Créez une Pull Request

Allez sur votre fork GitHub et cliquez sur "New Pull Request".

## 📝 Conventions de commit

Utilisez les préfixes suivants pour vos messages de commit :

- `feat:` Nouvelle fonctionnalité
- `fix:` Correction de bug
- `docs:` Documentation
- `style:` Formatage, point-virgule manquant, etc.
- `refactor:` Refactoring du code
- `test:` Ajout de tests
- `chore:` Maintenance

**Exemples :**

```
feat: ajout du système d'authentification
fix: correction du bug de connexion MySQL
docs: mise à jour du README avec les nouvelles fonctionnalités
```

## ✅ Checklist avant la Pull Request

- [ ] Le code compile sans erreur
- [ ] Tous les tests passent (`mvn test`)
- [ ] Le code suit les conventions Java
- [ ] La documentation est à jour
- [ ] Les nouveaux fichiers ont des commentaires appropriés
- [ ] Aucun fichier de configuration personnelle n'est inclus

## 🐛 Signaler un bug

1. Vérifiez que le bug n'a pas déjà été signalé dans les Issues
2. Ouvrez une nouvelle Issue avec le template "Bug Report"
3. Décrivez le problème en détail
4. Incluez les étapes pour reproduire le bug
5. Ajoutez des captures d'écran si possible

## 💡 Proposer une nouvelle fonctionnalité

1. Ouvrez une Issue avec le template "Feature Request"
2. Décrivez la fonctionnalité proposée
3. Expliquez pourquoi elle serait utile
4. Attendez les retours avant de commencer le développement

## 📖 Style de code

### Java

- Suivre les conventions de nommage Java standard
- Indentation : 4 espaces
- Accolades : style K&R
- Maximum 100 caractères par ligne

### Commentaires

- Utilisez JavaDoc pour les méthodes publiques
- Commentez les parties complexes du code
- Évitez les commentaires évidents

**Exemple :**

```java
/**
 * Crée un nouveau produit dans la base de données.
 *
 * @param product Le produit à créer
 * @return true si la création a réussi, false sinon
 */
@Override
@Transactional
public boolean create(Product product) {
    Session session = sessionFactory.getCurrentSession();
    session.save(product);
    return true;
}
```

## 🧪 Tests

- Tous les nouveaux codes doivent avoir des tests
- Tests unitaires pour la logique métier
- Tests d'intégration pour les interactions base de données
- Visez au moins 80% de couverture de code

## ❓ Questions

Si vous avez des questions, n'hésitez pas à :

- Ouvrir une Issue
- Contacter le mainteneur du projet

---

Merci de contribuer à l'amélioration de ce projet ! 🙏

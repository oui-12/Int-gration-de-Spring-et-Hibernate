# 🎨 Démo Visuelle de l'Interface

Ce dossier contient des **versions HTML statiques** de l'interface pour visualiser le design sans serveur.

## 📂 Fichiers disponibles

- **`index.html`** - Page d'accueil
- **`products.html`** - Liste des produits (avec données d'exemple)
- **`categories.html`** - Liste des catégories (avec données d'exemple)
- **`product-form.html`** - Formulaire de création/modification de produit

## 👀 Comment voir l'interface ?

### Méthode 1 : Double-clic (Windows)

1. Allez dans le dossier `demo-static`
2. Double-cliquez sur `index.html`
3. Votre navigateur par défaut s'ouvrira

### Méthode 2 : Depuis l'explorateur

1. Ouvrez l'Explorateur Windows
2. Naviguez vers : `C:\Users\ElKansouli Ouiam\Desktop\spring-hibernate-demo\demo-static\`
3. Clic droit sur `index.html` → **Ouvrir avec** → Chrome/Firefox/Edge

### Méthode 3 : Depuis IntelliJ IDEA

1. Dans IntelliJ, ouvrez le dossier `demo-static`
2. Clic droit sur `index.html`
3. Choisissez **"Open in Browser"** ou **"Run 'index.html'"**

## 🎨 Caractéristiques du design

✨ **Design moderne** avec :

- Gradient de couleurs violet/bleu
- Effets de hover (survol)
- Animations fluides
- Cards pour les produits
- Icônes Font Awesome
- Police Poppins
- Responsive design
- Glassmorphism (effet verre)

## 📱 Pages interactives

### Page Produits (`products.html`)

- ✅ Barre de recherche fonctionnelle (filtre en temps réel)
- ✅ 6 produits d'exemple avec différentes catégories
- ✅ Boutons d'action (modifier, supprimer)
- ✅ Design en cards avec icônes

### Page Catégories (`categories.html`)

- ✅ 4 catégories d'exemple
- ✅ Statistiques par catégorie (nombre de produits, note)
- ✅ Icônes personnalisées par catégorie
- ✅ Boutons d'action multiples

### Page Formulaire (`product-form.html`)

- ✅ Formulaire interactif
- ✅ Validation des champs
- ✅ Sélection de catégorie
- ✅ Alert de confirmation

## 🔗 Navigation

Toutes les pages ont une navigation qui fonctionne :

- Accueil → Produits → Catégories → Retour

## ⚡ Fonctionnalités JS

- **Recherche en temps réel** sur la page produits
- **Alert de confirmation** sur le formulaire
- **Confirmations de suppression**

---

💡 **Note :** Ces pages sont des **démos statiques** pour visualiser le design.
Pour la version fonctionnelle complète avec base de données, utilisez les vues Thymeleaf dans `src/main/webapp/WEB-INF/views/`.

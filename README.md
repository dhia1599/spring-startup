# spring-startup

## 📋 Description - Optimisation de la base de données
Cette mise à jour améliore les performances des requêtes SQL grâce à :
- **Intégration de P6SPY** pour suivre et analyser les requêtes SQL.
- **Ajout de 3 index** pour accélérer les recherches et jointures fréquentes.

## 🚀 Changements

### 1. Intégration de P6SPY
- Permet de loguer toutes les requêtes SQL dans la console ou un fichier.

### 2. Index ajoutés
- **`projet.name`** : Optimise les recherches par nom de projet.
- **`task.projet_id`** : Accélère les jointures entre tâches et projets.
- **`user.email`** : Améliore les recherches d'utilisateur par email.

### 3. Résolution de Query N+1
- Utilisation de `@EntityGraph` pour charger les relations en une seule requête optimisée.
- Exemple réalisé : Charger les projets et leurs tâches associées avec une seule requête SQL.

### 4. Vue matérialisée pour compter le nombre des tâches par projet

### 5. Intégrer la pagination sur les endpoints des projets et des tasks
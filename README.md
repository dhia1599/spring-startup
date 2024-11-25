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

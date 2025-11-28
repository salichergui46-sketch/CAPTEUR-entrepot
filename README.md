# 🌍 Système de Surveillance des Entrepôts Distribués

## 📋 Description

Système distribué de gestion et de monitoring en temps réel pour l'agroalimentaire. Collecte automatique de données de température et d'humidité depuis plusieurs entrepôts, stockage centralisé, et alertes intelligentes en cas de dépassement de seuils.

## ✨ Fonctionnalités

### 🔄 Collecte Temps Réel
- ✅ Collecte automatique des données toutes les 5 secondes
- ✅ Support de capteurs multiples dans plusieurs entrepôts
- ✅ Mesure de température (°C) et humidité (%)
- ✅ Timestamp de chaque mesure

### 💾 Stockage Centralisé
- ✅ Base de données Firebase Realtime Database
- ✅ Historique complet des mesures
- ✅ Synchronisation en temps réel
- ✅ Accès 24/7 aux données

### 📱 Accès Multiplateforme
- ✅ Interface Web responsive
- ✅ Compatible mobile/tablette/desktop
- ✅ Design moderne et intuitif
- ✅ Navigation par onglets

### ⚠️ Système d'Alertes
- ✅ Alertes automatiques au dépassement des seuils
- ⚙️ Seuil Température : **30°C**
- ⚙️ Seuil Humidité : **70%**
- ✅ Historique des alertes
- ✅ Notifications visuelles en temps réel

### 📊 Tableau de Bord
- ✅ Statistiques globales (entrepôts, alertes, état normal, mesures)
- ✅ État de chaque entrepôt
- ✅ Indicateurs visuels (vert/rouge)
- ✅ Tri automatique par température

## 🏗️ Architecture

```
┌─────────────────────────────────────────────┐
│         Capteurs Physiques                  │
│  (Température, Humidité - 3 Entrepôts)     │
└────────────────────┬────────────────────────┘
                     │
                     ▼
┌─────────────────────────────────────────────┐
│    Collecte Temps Réel (JS)                 │
│    - Simulation/Integration réelle          │
│    - Validation des données                 │
└────────────────────┬────────────────────────┘
                     │
                     ▼
┌─────────────────────────────────────────────┐
│    Firebase Realtime Database               │
│    - /entrepots (données actuelles)        │
│    - /historique (historique complet)      │
│    - /alertes (alertes actives)            │
└────────────────────┬────────────────────────┘
                     │
         ┌───────────┴───────────┐
         ▼                       ▼
    ┌────────────┐          ┌────────────┐
    │  Web App   │          │ Alertes    │
    │  (HTML)    │          │ (Affichage)│
    └────────────┘          └────────────┘
```

## 🚀 Démarrage Rapide

### Prérequis
- Node.js (optionnel - pour serveur local)
- Navigateur web moderne (Chrome, Firefox, Safari)
- Connexion Internet

### Installation

1. **Clonez le dépôt**
```bash
git clone https://github.com/VotreUsername/Capteur-Entrepot.git
cd Capteur-Entrepot
```

2. **Ouvrez le fichier HTML**
```bash
# Directement dans le navigateur
# Ou avec un serveur local
python -m http.server 8000
# Visitez: http://localhost:8000/User.html
```

3. **Configurez Firebase** (si nécessaire)
   - Remplacez la config Firebase dans le code HTML par vos identifiants

## 📂 Structure du Projet

```
Capteur-Entrepot/
├── src/
│   ├── main/
│   │   ├── webapp/
│   │   │   ├── User.html              (Page de connexion)
│   │   │   ├── entrepot.html          (Tableau de bord)
│   │   │   └── surveillance.html      (Surveillance temps réel)
│   │   ├── java/
│   │   │   ├── EntrepotImpl.java       (Implémentation RMI)
│   │   │   ├── EntrepotInterface.java (Interface RMI)
│   │   │   └── ServeurRMI.java        (Serveur RMI)
│   │   └── resources/
│   └── test/
├── pom.xml                             (Configuration Maven)
├── .gitignore
└── README.md

```

## 🔧 Configuration

### Firebase Setup
1. Créez un projet sur [Firebase Console](https://console.firebase.google.com)
2. Activez Realtime Database
3. Remplacez `firebaseConfig` dans le HTML :
```javascript
var firebaseConfig = {
    apiKey: "YOUR_API_KEY",
    authDomain: "your-project.firebaseapp.com",
    databaseURL: "https://your-project.firebaseio.com",
    projectId: "your-project",
    storageBucket: "your-project.appspot.com",
    messagingSenderId: "YOUR_SENDER_ID",
    appId: "YOUR_APP_ID"
};
```

### Seuils Configurables
```javascript
const SEUIL_TEMPERATURE = 30;  // °C
const SEUIL_HUMIDITE = 70;     // %
```

## 📊 Endpoints Firebase

```
/entrepots
├── Entrepot_Nord
│   ├── temperature: 25.5
│   ├── humidite: 65.3
│   └── timestamp: 1234567890
├── Entrepot_Sud
└── Entrepot_Est

/historique
├── Entrepot_Nord
│   ├── -NxK... : {temperature, humidite, timestamp}
│   └── -NyL... : {...}
└── ...

/alertes
├── -MzP... : {entrepot, type, valeur, seuil, timestamp}
└── -MzQ... : {...}
```

## 🌐 Utilisation

### Page de Connexion (User.html)
- Entrez les identifiants
- Accès au tableau de bord

### Tableau de Bord (entrepot.html)
- Visualisez l'état de tous les entrepôts
- Consultez les statistiques
- Vérifiez les alertes actives

### Surveillance (surveillance.html)
- Collecte automatique temps réel
- Mise à jour toutes les 5 secondes
- Alertes instantanées

## 📱 Technologies Utilisées

### Frontend
- **HTML5** - Structure
- **CSS3** - Design responsive
- **JavaScript ES6+** - Logique temps réel
- **Font Awesome** - Icônes

### Backend
- **Firebase Realtime Database** - Base de données
- **Java RMI** - Communication distribuée (optionnel)
- **Apache Tomcat** - Serveur web (optionnel)

### Infrastructure
- **Git/GitHub** - Versioning
- **Maven** - Gestion de dépendances (Java)
- **Eclipse IDE** - Développement

## 🔐 Sécurité

- ✅ Authentification Firebase (à configurer)
- ✅ HTTPS recommandé en production
- ✅ Règles de sécurité Firebase
- ✅ Validation des données côté client et serveur

## 📈 Performance

- ⚡ Collecte : 5 secondes
- 📡 Latence : < 1 seconde
- 💾 Stockage : Illimité (Firebase)
- 🔄 Synchronisation : Temps réel

## 🐛 Dépannage

### L'application ne se connecte pas à Firebase
```
Solution: Vérifiez les règles de sécurité Firebase et la config
```

### Les données ne se mettent pas à jour
```
Solution: Vérifiez la connexion Internet et la console Firebase
```

### Erreur "Cannot read property 'set' of undefined"
```
Solution: Firebase n'est pas initialisé - vérifiez la config
```

## 📝 Logs et Monitoring

```javascript
// Vérifiez la console (F12)
console.log("Données reçues:", data);
console.error("Erreur Firebase:", error);

// Consultez Firebase Console pour les alertes
```

## 🤝 Contribution

1. **Fork** le projet
2. **Créez une branche** (`git checkout -b feature/AmazingFeature`)
3. **Commit** vos changements (`git commit -m 'Add AmazingFeature'`)
4. **Push** vers la branche (`git push origin feature/AmazingFeature`)
5. **Ouvrez une Pull Request**

## 📜 Licence

Ce projet est sous licence **MIT** - voir le fichier LICENSE pour plus de détails.

## 👥 Auteurs

- **Équipe Agroalimentaire** - Développement
- Contributeurs : [@VotreGithub]

## 📞 Support

- 📧 Email: support@agroalimentaire.com
- 🐛 Issues: [GitHub Issues](https://github.com/VotreUsername/Capteur-Entrepot/issues)
- 💬 Discussions: [GitHub Discussions](https://github.com/VotreUsername/Capteur-Entrepot/discussions)



## 📚 Documentation

- [Firebase Documentation](https://firebase.google.com/docs)
- [Java RMI Guide](https://docs.oracle.com/javase/tutorial/rmi/)
- [REST API](docs/API.md)
- [Architecture](docs/ARCHITECTURE.md)

---

**🌟 N'oubliez pas de mettre une ⭐ star si vous aimez ce projet !**

Dernière mise à jour : 27/11/2025
Version : 1.0.0

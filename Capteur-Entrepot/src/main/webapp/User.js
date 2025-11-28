/**
 * 
 */
  const db = firebase.database();
  db.ref("entrepots").once("value")
    .then(snapshot => console.log("Données Firebase :", snapshot.val()))
    .catch(err => console.error("Erreur Firebase :", err));

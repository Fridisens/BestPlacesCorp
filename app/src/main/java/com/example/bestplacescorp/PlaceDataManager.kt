package com.example.bestplacescorp

import com.google.firebase.firestore.FirebaseFirestore

object PlaceDataManager {
    var currentPlace: Place = Place()
    fun saveAllInformationToFirestore(onSuccess: (String) -> Unit, onFailure: (Exception) -> Unit) {
        val db = FirebaseFirestore.getInstance()

        db.collection("places")
            .add(currentPlace)
            .addOnSuccessListener { documentReference ->
                onSuccess.invoke(documentReference.id)
            }
            .addOnFailureListener { e ->
                onFailure.invoke(e)
            }
    }
}


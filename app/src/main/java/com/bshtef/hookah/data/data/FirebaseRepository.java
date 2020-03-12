package com.bshtef.hookah.data.data;

import com.google.firebase.firestore.FirebaseFirestore;

public class FirebaseRepository<T> extends BaseRepository<T> {

    protected FirebaseFirestore db = FirebaseFirestore.getInstance();


}

package com.example.sqlite.dao;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.example.sqlite.model.Personne;
import java.util.List;
@Dao
public interface DaoGestion {
    //inserer une personne, l'annotation va permettre a la librairie room de  savoir
    //qu'il doit mapper l'objet personne avec la table sqlite pour inserer une personne
    @Insert
    public void insertPersonne(Personne personne);
    //modifier une personne
    @Update
    public void updatePersonne(Personne personne);
    //supprimer une personne
    @Delete
    public void deletePersonne(Personne personne);
    //retourner la liste des personnes
    @Query("SELECT * FROM personne")
    public List<Personne> loadAllPersonnes();
    //retourne une personne en fonction de son nom
    @Query("SELECT * FROM personne WHERE nom=:namePersonne")
    public Personne loadPersonneByName(String namePersonne);
}


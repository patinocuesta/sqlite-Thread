package com.example.sqlite.dao;
import androidx.room.Database;
import androidx.room.RoomDatabase;
import com.example.sqlite.model.Personne;
//classe abstraite non instanciable, la classe etends RoomDatabase qui permet d'avoir acces
//a une base de donnee sqlite gere par la librairie Room
//on va definir les entity (classe avec l'annotation @Entity) que l'on va utiliser         avec
//notre base de donnee.
@Database(entities = {Personne.class},version=1)
public abstract class PersonneDatabase extends RoomDatabase {
    //On cree une methode abstraite qui va retourner un DAO (Direct Access object) a partir d'une base de donnee ROOM
    //Personne est un objet DAO car il va acceder directement à la base de donnee   grace a la librairie ROOM.
    public abstract DaoGestion daoGestion();
}
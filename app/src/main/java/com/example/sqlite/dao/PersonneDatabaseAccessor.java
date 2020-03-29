package com.example.sqlite.dao;
import android.content.Context;
import androidx.room.Room;
//cette classe doit nous fournir un singleton pour pouvoir acceder a la base de donnee
//c'est a dire une instance unique pour acceder a la base de donnee.
public class PersonneDatabaseAccessor {
    //On définit un objet de type PersonneDatabase pour l'acces à la base de     donnee via room
    private static PersonneDatabase personneDatabaseInstance;
    //on va définir une constante qui va contenir le nom de la base de donnee (sqlite) qui sera stocke sur
    //sur le telephone.
    private static final String PERSONNE_DB_NAME="personne_db";
    //on va definir un constructeur private , car comme on veut que cette classe     nous renvoie un singleton
    //on ne doit pas avoir la possibilite de l'instancier plusieurs fois .
    //si j'enleve la ligne ci-dessous alors on est capable d'ecrire
    //PersonneDatabaseAccessor d=new PersonneDatabaseAccessor();
    private PersonneDatabaseAccessor(){}
    //On va creer une methode statique (c'est une methode qui est appele     directement sur la classe) qui
    //va nous permettre d'obtenir le singleton
    public static PersonneDatabase getInstance(Context context){
        //si l'instance pour se connecter à la base de donnee est null on la cree
        if (personneDatabaseInstance==null){
            //permet de creer une base de donnee sqlite et de la retourner comme instance de base
                    //de donnee
                    personneDatabaseInstance=
                    Room.databaseBuilder(context,PersonneDatabase.class,PERSONNE_DB_NAME).build();
        }
        return personneDatabaseInstance;
    }
}

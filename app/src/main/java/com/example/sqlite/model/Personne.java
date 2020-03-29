package com.example.sqlite.model;
import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
//Cette annotation va definir les objets de la classe Personne comme etant des objets
//qui seront mappes à la table Personne correspondante de la base de donnee que l'on va
//créer sous sqlite. (hibernate (java), doctrine (php)).
//permet de definir un objet Personne comme ayant un acces direct à la base de donnee sqlite grace
//a la librairie Room
@Entity
public class Personne {
    //on définit l'id comme etant non null
    //c'est une clé primaire
    //elle est en autoincrement
    @NonNull
    @PrimaryKey(autoGenerate = true)
    private int id;
    @NonNull
    private String nom;
    private String prenom;
    private int age;
    private float salaire;
    public Personne(String nom, String prenom, int age, float salaire) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.salaire = salaire;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public float getSalaire() {
        return salaire;
    }
    public void setSalaire(float salaire) {
        this.salaire = salaire;
    }

    @Override
    public String toString() {
        return "Personne{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", age=" + age +
                ", salaire=" + salaire +
                '}';
    }
}


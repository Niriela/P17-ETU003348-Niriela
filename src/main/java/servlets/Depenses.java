package servlets;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import jakarta.servlet.ServletException;

public class Depenses {
    int id_depenses;
    Credit credit;
    float montant;
    Date date_debut;
    Date date_fin;

    public int getId_depenses() {
        return id_depenses;
    }
    public void setId_depenses(int id_depenses) {
        this.id_depenses = id_depenses;
    }
    public Credit getCredit() {
        return credit;
    }
    public void setCredit(Credit credit) {
        this.credit = credit;
    }
    public float getMontant() {
        return montant;
    }
    public void setMontant(float montant) {
        this.montant = montant;
    }
    public Date getDate_debut() {
        return date_debut;
    }
    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }
    public Date getDate_fin() {
        return date_fin;
    }
    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }


    public Depenses() {
    }

   

    public Depenses(int id_depenses, Credit credit, float montant, Date date_debut, Date date_fin) {
        this.id_depenses = id_depenses;
        this.credit = credit;
        this.montant = montant;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
    }

    public Depenses(int id_depenses, Credit credit, float montant) {
        this.id_depenses = id_depenses;
        this.credit = credit;
        this.montant = montant;
    }

    public Depenses(Credit credit, float montant) {
        this.credit = credit;
        this.montant = montant;
    }


    public void Save() throws Exception {
        Connectivity c = new Connectivity();
        Connection con = c.getConnection();
        String sql = "INSERT INTO depenses_depenses(id_credit,montant) VALUES (?, ?)";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, this.getCredit().getId_credit());
            stmt.setFloat(2, this.getMontant());

            stmt.executeUpdate(); 

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new ServletException(e.getMessage());
        } finally {
            con.close();
        }
    }

    public static Vector<Depenses> findAll() throws Exception {
    Vector<Depenses> Depenses = new Vector<Depenses>();
    Connectivity c = new Connectivity();
    Connection con = c.getConnection();
    String sql = "SELECT * FROM depenses_depenses";

    try (
        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery()) {
      while (rs.next()) {
        // Pour récupérer l'ID (en supposant que la colonne s'appelle "id")
        int id_Depenses = rs.getInt("id_depenses");

        int id_credit = rs.getInt("id_credit");
        Credit credit= Credit.findById(id_credit);

        Float montant = rs.getFloat("montant");
     
        Depenses Depense= new Depenses(id_Depenses, credit , montant);
        Depenses.add(Depense);

      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
      throw new ServletException(e.getMessage());
    } finally {
      con.close();
    }

    return Depenses;
   }

    public void CheckIfCreditSuperieur(Credit c) throws ServletException{
       if(this.getMontant() > c.getMontant()){
          throw new ServletException("ERREUR: Votre montant depense doit etre inferieur a celui du montant Credit!!!");
       }
    }

    

}

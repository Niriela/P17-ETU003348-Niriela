package servlets;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;

public class Credit extends HttpServlet {
    int id_credit;
    String libelle;
    Float montant;

     // Constructeur par défaut
     public Credit() {
    }

    // Constructeur avec paramètres
    public Credit(int id_credit, String libelle, Float montant) {
        this.id_credit = id_credit;
        this.libelle = libelle;
        this.montant = montant;
    }

    public Credit(String libelle, Float montant) {
      this.libelle = libelle;
      this.montant = montant;
  }

    // Getter et Setter pour id_credit
    public int getId_credit() {
        return id_credit;
    }

    public void setId_credit(int id_credit) {
        this.id_credit = id_credit;
    }

    // Getter et Setter pour libelle
    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    // Getter et Setter pour montant
    public Float getMontant() {
        return montant;
    }

    public void setMontant(Float montant) {
        this.montant = montant;
    }
    
  
    public void Save() throws Exception {
        Connectivity c = new Connectivity();
        Connection con = c.getConnection();
        String sql = "INSERT INTO depenses_credit(libelle,montant) VALUES (?, ?)";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, this.getLibelle());
            stmt.setFloat(2, this.getMontant());

            stmt.executeUpdate(); 

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new ServletException(e.getMessage());
        } finally {
            con.close();
        }
    }

  public static Vector<Credit> findAll() throws Exception {
    Vector<Credit> credits = new Vector<Credit>();
    Connectivity c = new Connectivity();
    Connection con = c.getConnection();
    String sql = "SELECT * FROM depenses_credit";

    try (
        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery()) {
      while (rs.next()) {
        // Pour récupérer l'ID (en supposant que la colonne s'appelle "id")
        int id_credit = rs.getInt("id_credit");
        String libelle = rs.getString("libelle");
        Float montant = rs.getFloat("montant");
     
        Credit credit= new Credit(id_credit, libelle, montant);
        credits.add(credit);

      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
      throw new ServletException(e.getMessage());
    } finally {
      con.close();
    }

    return credits;
  }

  public static Credit findById(int id) throws Exception {
    Connectivity c = new Connectivity();
    Connection con = c.getConnection();

    // Utilisation du LIKE avec le % pour rechercher n'importe où dans le nom
    String sql = "SELECT * FROM depenses_credit WHERE id_credit= ?";

    try (PreparedStatement stmt = con.prepareStatement(sql)) {
      // Configuration du paramètre avec les caractères % pour rechercher la chaîne
      // n'importe où dans le nom
      stmt.setInt(1, id);

      try (ResultSet rs = stmt.executeQuery()) {
        if(rs.next()) {
          int id_credit = rs.getInt("id_credit");
          String libelle = rs.getString("libelle");
          Float montant = rs.getFloat("montant");

          return new Credit(id_credit, libelle, montant);
        }
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
      throw new ServletException(e.getMessage());
    } finally {
      con.close();
    }

    return null;
  }

  
  public float SumDepenses() throws Exception {
    Connectivity c = new Connectivity();
    Connection con = c.getConnection();

    // Utilisation du LIKE avec le % pour rechercher n'importe où dans le nom
    String sql = "SELECT sum(montant) as montant_sum FROM depenses_depenses where id_credit= ?";
    float montant =0;


    try (PreparedStatement stmt = con.prepareStatement(sql)) {
      // Configuration du paramètre avec les caractères % pour rechercher la chaîne
      // n'importe où dans le nom
      stmt.setInt(1, this.getId_credit());

      try (ResultSet rs = stmt.executeQuery()) {
        if(rs.next()) {

          montant = rs.getFloat("montant_sum");
          return montant;
        }
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
      throw new ServletException(e.getMessage());
    } finally {
      con.close();
    }

    return montant;
  }




}

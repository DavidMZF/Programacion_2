package DataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import DataAccess.MFDTO.MFHormigasDTO;
import Framework.MFEcuFaunaException;

public class MFHormigasDAO extends MFSQLiteDataHelper implements IMFDAO<MFHormigasDTO> {
    @Override
    public boolean create(MFHormigasDTO entity) throws Exception {
        //  idTipoHorm   , idSexo   , idProvincia   , idGenoAlimento, idIngestaNativa
        String query = " INSERT INTO  MFHormiga(IdTipoHormiga ,IdSexo ,IdProvincia ,IdGenoAlimento ,IdIngestaNativa) VALUES (?,?,?,?,?)";
        try {
            Connection        mfConn  = openConnection();
            PreparedStatement mfPstmt = mfConn.prepareStatement(query);
            mfPstmt.setInt(1, 2);   //
            mfPstmt.setInt(2, entity.mfGetIdSexo());
            mfPstmt.setInt(3, entity.mfGetIdProvincia());
            mfPstmt.setInt(4, entity.mfGetIdGenoAlimento());
            mfPstmt.setInt(5, entity.mfGetIdIngestaNativa());
            mfPstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw new MFEcuFaunaException(e.getMessage(), getClass().getName(), "create()");
        }
    }

    @Override
    public List<MFHormigasDTO> readAll() throws Exception {
        List <MFHormigasDTO> mfLst = new ArrayList<>();
        String query ="SELECT  ROW_NUMBER() OVER (ORDER BY h.IdHormiga) AS RowNum, " +
                     "h.IdHormiga,                                                    " +
                     "h.IdTipoHormiga,                                                    " +
                     "h.IdSexo,                                                    " +
                     "h.IdProvincia,                                                    " +
                     "h.IdGenoAlimento,                                                    " +
                     "h.IdIngestaNativa,                                                    " +
                     "tt.Nombre AS TipoHormiga,                                     " +
                     "s.Nombre AS Sexo,                                           " +
                     "l.Nombre AS Provincia,                                      " +
                     "ga.Nombre AS GenoAlimento,                                " +
                     "ing.Nombre AS IngestaNativa,                                   " +
                     "h.Estado,                                                       " +
                     "h.FechaCreacion,                                                " +
                     "h.FechaModifica                                                 " +
                     "FROM MFHormiga h                                                " +
                     "JOIN MFCatalogo tt ON h.IdTipoHormiga   = tt.IdCatalogo  " +
                     "JOIN MFCatalogo s ON h.IdSexo          = s.IdCatalogo  " +
                     "JOIN MFLocalidad l ON h.IdProvincia       = l.IdLocalidad     " +  
                     "JOIN MFAlimento ga ON h.IdGenoAlimento  = ga.IdAlimento  " +
                     "JOIN MFAlimento ing ON h.IdIngestaNativa = ing.IdAlimento  "+
                     "     WHERE h.Estado = 'A'   ";  
        try {
            Connection mfConn = openConnection();         // conectar a DB     
            Statement  mfStmt = mfConn.createStatement();   // CRUD : select * ...    
            ResultSet  mfRs   = mfStmt.executeQuery(query);    // ejecutar la
            while (mfRs.next()) {
                MFHormigasDTO mfH = new MFHormigasDTO( 
                                        mfRs.getInt(1)      // RowNum
                                        ,mfRs.getInt(2)     // IdHormiga
                                        ,mfRs.getInt(3)     // IdHormiga
                                        ,mfRs.getInt(4)     // IdHormiga
                                        ,mfRs.getInt(5)     // IdHormiga
                                        ,mfRs.getInt(6)     // IdHormiga
                                        ,mfRs.getInt(7)     // IdHormiga
                                        ,mfRs.getString(8)     // IdTipoHormiga             
                                        ,mfRs.getString(9)  // IdSexo         
                                        ,mfRs.getString(10)  // IdProvincia      
                                        ,mfRs.getString(11)  // IdGenoAlimento
                                        ,mfRs.getString(12)  // IdIngestaNativa
                                        ,mfRs.getString(13)  // Estado
                                        ,mfRs.getString(14)  // FechaCrea
                                        ,mfRs.getString(15));// FechaModifica
                mfLst.add(mfH);
            }
        } 
        catch (SQLException e) {
            System.out.println("ayudaasaaaaaaa");
            throw new MFEcuFaunaException(e.getMessage(), getClass().getName(), "readAll()");
        }
        return mfLst; 
    }

    @Override
    public boolean update(MFHormigasDTO entity) throws Exception {
        DateTimeFormatter mfDtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime mfNow = LocalDateTime.now();
        String query = "UPDATE MFHormiga SET IdTipoHormiga = ?, IdSexo = ?, IdProvincia = ?,IdGenoAlimento = ?, IdIngestaNativa = ?, FechaModifica = ? WHERE IdHormiga = ?";
        try {
            Connection          mfConn = openConnection();
            PreparedStatement mfPstmt  = mfConn.prepareStatement(query);
            mfPstmt.setInt(1, entity.mfGetIdTipoHormiga());
            mfPstmt.setInt(2, entity.mfGetIdSexo());
            mfPstmt.setInt(3, entity.mfGetIdProvincia());
            mfPstmt.setInt(4, entity.mfGetIdGenoAlimento());
            mfPstmt.setInt(5, entity.mfGetIdIngestaNativa());
            mfPstmt.setString(6, mfDtf.format(mfNow).toString());
            mfPstmt.setInt(7, entity.mfGetIdHormiga());
            mfPstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw new MFEcuFaunaException(e.getMessage(), getClass().getName(), "update()");
        }
    }

    @Override
    public boolean delete(int id) throws Exception {
        String query = " UPDATE MFHormiga SET Estado = ? WHERE IdHormiga = ?";
        try {
            Connection          mfConn = openConnection();
            PreparedStatement  mfPstmt = mfConn.prepareStatement(query);
            mfPstmt.setString(1, "X");
            mfPstmt.setInt(2, id);
            mfPstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw new MFEcuFaunaException(e.getMessage(), getClass().getName(), "delete()");
        }
    }

    @Override
    public MFHormigasDTO readBy(Integer id) throws Exception {
        MFHormigasDTO mfH = new MFHormigasDTO();
        String query = 
         " SELECT RowNum            "
        +"     ,IdHormiga           "
        +"     ,IdTipoHormiga       "
        +"     ,IdSexo              "
        +"     ,IdProvincia         "
        +"     ,IdGenoAlimento      "
        +"     ,IdIngestaNativa     "
        +"     ,Estado              "
        +"     ,FechaCreacion       "
        +"     ,FechaModifica       "
        +" FROM (                   "
        +"     SELECT ROW_NUMBER() OVER (ORDER BY IdHormiga) AS RowNum "
        +"         ,IdHormiga       "
        +"         ,IdTipoHormiga   "
        +"         ,IdSexo          "
        +"         ,IdProvincia     "
        +"         ,IdGenoAlimento  "
        +"         ,IdIngestaNativa "
        +"         ,Estado          "
        +"         ,FechaCreacion   "
        +"         ,FechaModifica   "
        +"     FROM MFHormiga       "
        +"     WHERE Estado = 'A'   "
        +" ) sub                    "
        +" WHERE RowNum = " + id.toString();  
        try {
            Connection mfConn = openConnection();         // conectar a DB     
            Statement  mfStmt = mfConn.createStatement();   // CRUD : select * ...    
            ResultSet  mfRs   = mfStmt.executeQuery(query);    // ejecutar la
            System.out.println(query);
            while (mfRs.next()) {
                mfH = new MFHormigasDTO( 
                                         mfRs.getInt(1)      // RowNum
                                        ,mfRs.getInt(2)     // IdHormiga
                                        ,mfRs.getInt(3)     // IdTipoHormiga             
                                        ,mfRs.getInt(4)  // IdSexo         
                                        ,mfRs.getInt(5)  // IdProvincia      
                                        ,mfRs.getInt(6)  // IdGenoAlimento
                                        ,mfRs.getInt(7)  // IdIngestaNativa
                                        ,mfRs.getString(8)  // Estado
                                        ,mfRs.getString(9)  // FechaCrea
                                        ,mfRs.getString(10));// FechaModifica// FechaModifica
            }
        } 
        catch (SQLException e) {
            throw new MFEcuFaunaException(e.getMessage(), getClass().getName(), "readBy()");
        }
        return mfH; 
    }

    public Integer getRowCount()  throws Exception  {
        String query =" SELECT COUNT(*) TotalReg "
                     +" FROM    MFHormiga         "
                     +" WHERE   Estado ='A'      ";
        try {
            Connection mfConn = openConnection();         // conectar a DB     
            Statement  mfStmt = mfConn.createStatement();   // CRUD : select * ...    
            ResultSet mfRs   = mfStmt.executeQuery(query);  // ejecutar la
            while (mfRs.next()) {
                return mfRs.getInt(1);                    // TotalReg
            }
        } 
        catch (SQLException e) {
            throw new MFEcuFaunaException(e.getMessage(), getClass().getName(), "getRowCount()");
        }
        return 0;
    }
}

package BusinessLogic;

import java.util.List;

import DataAccess.MFHormigasDAO;
import DataAccess.MFDTO.MFHormigasDTO;

public class MFHormigasBL {
    private MFHormigasDTO mfHormigas;
    private MFHormigasDAO mfHDAO = new MFHormigasDAO();

    public MFHormigasBL(){}

    public List<MFHormigasDTO> getAll() throws Exception{
        List<MFHormigasDTO> lst = mfHDAO.readAll();
        return lst;
    }
    public MFHormigasDTO getBy(int mfIdHormiga) throws Exception{
        mfHormigas = mfHDAO.readBy(mfIdHormiga);
        return mfHormigas;
    }
    public boolean add(MFHormigasDTO mfHormigasDTO) throws Exception{   
        return mfHDAO.create(mfHormigasDTO);
    }
    public boolean update(MFHormigasDTO mfHormigasDTO) throws Exception{
        return mfHDAO.update(mfHormigasDTO);
    }
    public boolean delete(int mfIdHormiga) throws Exception{
        return mfHDAO.delete(mfIdHormiga);
    }
    public Integer getRowCount() throws Exception{
        return mfHDAO.getRowCount();
    }
}

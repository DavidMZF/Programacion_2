package DataAccess.MFDTO;

public class MFHormigasDTO {
    private Integer mfRowNum         ;
    private Integer mfIdHormiga      ;
    private Integer mfIdTipoHormiga  ;
    private Integer mfIdSexo         ;
    private Integer mfIdProvincia    ;
    private Integer mfIdGenoAlimento ;
    private Integer mfIdIngestaNativa;

    private String mfTipoHormiga  ;
    private String mfSexo         ;
    private String mfProvincia    ;
    private String mfGenoAlimento ;
    private String mfIngestaNativa;

    private String mfEstado          ;           
    private String mfFechaCreacion   ;            
    private String mfFechaModifica   ;

    public MFHormigasDTO(Integer mfRowNum, Integer mfIdHormiga, Integer mfIdTipoHormiga, Integer mfIdSexo,
            Integer mfIdProvincia, Integer mfIdGenoAlimento, Integer mfIdIngestaNativa, String mfTipoHormiga,
            String mfSexo, String mfProvincia, String mfGenoAlimento, String mfIngestaNativa, String mfEstado,
            String mfFechaCreacion, String mfFechaModifica) {
        this.mfRowNum = mfRowNum;
        this.mfIdHormiga = mfIdHormiga;
        this.mfIdTipoHormiga = mfIdTipoHormiga;
        this.mfIdSexo = mfIdSexo;
        this.mfIdProvincia = mfIdProvincia;
        this.mfIdGenoAlimento = mfIdGenoAlimento;
        this.mfIdIngestaNativa = mfIdIngestaNativa;
        this.mfTipoHormiga = mfTipoHormiga;
        this.mfSexo = mfSexo;
        this.mfProvincia = mfProvincia;
        this.mfGenoAlimento = mfGenoAlimento;
        this.mfIngestaNativa = mfIngestaNativa;
        this.mfEstado = mfEstado;
        this.mfFechaCreacion = mfFechaCreacion;
        this.mfFechaModifica = mfFechaModifica;
    }

    public MFHormigasDTO(Integer mfRowNum, Integer mfIdHormiga, Integer mfIdTipoHormiga, Integer mfIdSexo, Integer mfIdProvincia,
            Integer mfIdGenoAlimento, Integer mfIdIngestaNativa, String mfEstado, String mfFechaCreacion,
            String mfFechaModifica) {
        this.mfRowNum = mfRowNum;
        this.mfIdHormiga = mfIdHormiga;
        this.mfIdTipoHormiga = mfIdTipoHormiga;
        this.mfIdSexo = mfIdSexo;
        this.mfIdProvincia = mfIdProvincia;
        this.mfIdGenoAlimento = mfIdGenoAlimento;
        this.mfIdIngestaNativa = mfIdIngestaNativa;
        this.mfEstado = mfEstado;
        this.mfFechaCreacion = mfFechaCreacion;
        this.mfFechaModifica = mfFechaModifica;
    }

    public MFHormigasDTO(Integer mfRowNum, Integer mfIdHormiga, String mfTipoHormiga, String mfSexo, String mfProvincia,
            String mfGenoAlimento, String mfIngestaNativa, String mfEstado, String mfFechaCreacion,
            String mfFechaModifica) {
        this.mfRowNum = mfRowNum;
        this.mfIdHormiga = mfIdHormiga;
        this.mfTipoHormiga = mfTipoHormiga;
        this.mfSexo = mfSexo;
        this.mfProvincia = mfProvincia;
        this.mfGenoAlimento = mfGenoAlimento;
        this.mfIngestaNativa = mfIngestaNativa;
        this.mfEstado = mfEstado;
        this.mfFechaCreacion = mfFechaCreacion;
        this.mfFechaModifica = mfFechaModifica;
    }
    
    public MFHormigasDTO(int idHormiga, int idSexo, int idProvincia, int idGenoAlimento, int idIngestaNativa, String tipoHormiga, String estado, String fechaCrea) {}

    public String mfGetTipoHormiga() {
        return mfTipoHormiga;
    }

    public void mfSetTipoHormiga(String mfTipoHormiga) {
        this.mfTipoHormiga = mfTipoHormiga;
    }

    public String mfGetSexo() {
        return mfSexo;
    }

    public void mfSetSexo(String mfSexo) {
        this.mfSexo = mfSexo;
    }

    public String mfGetProvincia() {
        return mfProvincia;
    }

    public void mfSetProvincia(String mfProvincia) {
        this.mfProvincia = mfProvincia;
    }

    public String mfGetGenoAlimento() {
        return mfGenoAlimento;
    }

    public void mfSetGenoAlimento(String mfGenoAlimento) {
        this.mfGenoAlimento = mfGenoAlimento;
    }

    public String mfGetIngestaNativa() {
        return mfIngestaNativa;
    }

    public void mfSetIngestaNativa(String mfIngestaNativa) {
        this.mfIngestaNativa = mfIngestaNativa;
    }

    



    public Integer mfGetRowNum() {
        return mfRowNum;
    }

    public void mfSetRowNum(Integer mfRowNum) {
        this.mfRowNum = mfRowNum;
    }

    public Integer mfGetIdHormiga() {
        return mfIdHormiga;
    }

    public void mfSetIdHormiga(Integer mfIdHormiga) {
        this.mfIdHormiga = mfIdHormiga;
    }

    public Integer mfGetIdTipoHormiga() {
        return mfIdTipoHormiga;
    }

    public void mfSetIdTipoHormiga(Integer mfIdTipoHormiga) {
        this.mfIdTipoHormiga = mfIdTipoHormiga;
    }

    public Integer mfGetIdSexo() {
        return mfIdSexo;
    }

    public void mfSetIdSexo(Integer mfIdSexo) {
        this.mfIdSexo = mfIdSexo;
    }

    public Integer mfGetIdProvincia() {
        return mfIdProvincia;
    }

    public void mfSetIdProvincia(Integer mfIdProvincia) {
        this.mfIdProvincia = mfIdProvincia;
    }

    public Integer mfGetIdGenoAlimento() {
        return mfIdGenoAlimento;
    }

    public void mfSetIdGenoAlimento(Integer mfIdGenoAlimento) {
        this.mfIdGenoAlimento = mfIdGenoAlimento;
    }

    public Integer mfGetIdIngestaNativa() {
        return mfIdIngestaNativa;
    }

    public void mfSetIdIngestaNativa(Integer mfIdIngestaNativa) {
        this.mfIdIngestaNativa = mfIdIngestaNativa;
    }

    public String mfGetEstado() {
        return mfEstado;
    }

    public void mfSetEstado(String mfEstado) {
        this.mfEstado = mfEstado;
    }

    public String mfGetFechaCreacion() {
        return mfFechaCreacion;
    }

    public void mfSetFechaCreacion(String mfFechaCreacion) {
        this.mfFechaCreacion = mfFechaCreacion;
    }

    public String mfGetFechaModifica() {
        return mfFechaModifica;
    }

    public void mfSetFechaModifica(String mfFechaModifica) {
        this.mfFechaModifica = mfFechaModifica;
    }

    @Override
    public String toString(){
        return  getClass().getName()
                + "\n idHormiga      "+ mfGetIdHormiga()
                + "\n idTipoHormiga  "+ mfGetIdTipoHormiga()
                + "\n idSexo         "+ mfGetIdSexo()
                + "\n idProvincia    "+ mfGetIdProvincia()
                + "\n idGenoAlimento "+ mfGetIdGenoAlimento()
                + "\n idIngestaNativa"+ mfGetIdIngestaNativa()
                + "\n estado         "+ mfGetEstado()
                + "\n fechaCreacion  "+ mfGetFechaCreacion()
                + "\n fechaModifica  "+ mfGetFechaModifica();
    }
    
}

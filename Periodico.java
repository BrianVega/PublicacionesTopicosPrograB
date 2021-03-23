package publicacion;

public class Periodico extends Publicacion implements Periodicidad
{
    private String secciones;
    private String editor;
    
    public String getSecciones(){
     return secciones;
    }
    
    public void setSecciones(String secciones){
        secciones = secciones;
    }
    
    public String getEditor(){
     return editor;
    }
    
    public void setEditor(String editor){
        editor = editor;
    }
    

   @Override
    public String getPeriodicidad()//implementación del método
    {
     return periodicidad;
    }
        
  }
package publicacion;
import java.util.Scanner;

public class Principal {
   static Object publicaciones [] = new Object[30]; //reservamos espacio
   static int ctrlpub = 0;
   static Scanner leer = new Scanner(System.in);
    public static void main(String[] args) {
        int r = 0, opc, tipoPubli;
      //Se podrá realizar un ArrayList de tipo Object?
      //Pregunta de reflexión y de calificación
      
        do{
        System.out.println("\n¿Desea ingresar al menu? ");
         System.out.println("[1] - SI ");        
         System.out.println("[2] - NO ");
         System.out.print("Opcion: ");
            r = leer.nextInt();  
            
         while (ctrlpub < publicaciones.length && r != 2){
            opc = menu();
            switch(opc){
               case 1:
                  System.out.println("\nSeleccione el tipo de publicación");         
                  System.out.println("[1] Revista");
                  System.out.println("[2] Periódico");
                  System.out.println("[3] Libro");  
                  System.out.print("Opcion: ");
                     tipoPubli = leer.nextInt();
                        leer.nextLine();//BufferCleaner
                  switch(tipoPubli){
                     case 1: altaRevista(); break;
                     case 2: altaPeriodico(); break;
                     case 3: altaLibro(); break;
                  }//switch tipoPubli
               break;
               case 2:
                  mostrar(); 
               break;
            }//switch opc
            break;
        }//while
        
        }while(r != 2);    
                  
     }//main
      
      private static void altaRevista(){        //Revista
      String issn, titulo;
      float precio;
      int numero, anio, numPag;
          Revista revista = new Revista();
          System.out.print("\nISSN: ");
            issn = leer.nextLine();
          System.out.print("Titulo: ");
            titulo = leer.nextLine();
          System.out.print("Precio: $");
            precio = leer.nextFloat();
          System.out.print("Numero: ");
            numero = leer.nextInt();
          System.out.print("anio: ");
            anio = leer.nextInt();
          System.out.print("Número de páginas: ");
            numPag = leer.nextInt();
          revista.setISSN(issn);
          revista.setTitulo(titulo);
          revista.setPrecio(precio);
          revista.setNumero(numero);
          revista.setAnio(anio);
          revista.setNumpag(numPag);
          publicaciones[ctrlpub] = revista;
          ctrlpub++;
      }//altaRevista
      
      private static void altaPeriodico(){
      String secciones, editor;
      float precio;
      int numPag;
          Periodico periodico = new Periodico();
          System.out.print("\nSecciones: ");
            secciones = leer.nextLine();
          System.out.print("Editor: ");
            editor = leer.nextLine();
          System.out.print("Precio: $");
            precio = leer.nextFloat();
          System.out.print("Número de páginas: ");
            numPag = leer.nextInt();
          periodico.setSecciones(secciones);
          periodico.setEditor(editor);
          periodico.setPrecio(precio);
          periodico.setNumpag(numPag);
          publicaciones[ctrlpub] = periodico;
          ctrlpub++;
      
      }//altaRevista
      
      private static void altaLibro(){
      String isbn, titulo, autor, edicion;
      float precio;
      int numPag;
          Libro libro = new Libro();
          System.out.print("\nISBN: ");
            isbn = leer.nextLine();
          System.out.print("Titulo: ");
            titulo = leer.nextLine();
          System.out.print("Autor: ");
            autor = leer.nextLine();
          System.out.print("Edicion: ");
            edicion = leer.nextLine();
          System.out.print("Precio: ");
            precio = leer.nextFloat();
          System.out.print("Número de páginas: ");
            numPag = leer.nextInt();
          libro.setISBN(isbn);
          libro.setTitulo(titulo);
          libro.setAutor(autor);
          libro.setEdicion(edicion);
          libro.setPrecio(precio);
          libro.setNumpag(numPag);
          publicaciones[ctrlpub] = libro;
          ctrlpub++;
      
      }//altaRevista

      public static int menu(){
      int opc=0;
      //do{
            System.out.println("\n~~~~~~~~ M E N Ú ~~~~~~~~");
            System.out.println("[1] Alta publicación");
            System.out.println("[2] Mostrar publicación");
            System.out.println("[3] Salir");
            System.out.print("opcion: ");
               opc = leer.nextInt();   
        // }while(opc > 0 && opc < 3);
      return opc;
   }//menu
   
      private static void mostrar(){
      //Mostrar el arreglo
        for(int i = 0; i < ctrlpub; i ++ )
          {
             System.out.println("\n  " + publicaciones [i].getClass());
              if(publicaciones[i] instanceof Revista)
              {
                   Revista rev1 = new Revista();
                   rev1 = (Revista)publicaciones[i];
                    System.out.println("----REVISTA----");
                    System.out.println("ISSN: " + rev1.getISSN());
                    System.out.println("Título: " + rev1.getTitulo());
                    System.out.println("Precio: " + rev1.getPrecio());
                    System.out.println("Numero: " + rev1.getNumero());
                    System.out.println("Anio: " + rev1.getAnio());
                    System.out.println("Numero paginas: " + rev1.getNumpag());

                
              }
              else if (publicaciones [i] instanceof Libro )
              {
                  Libro lib = new Libro();
                  lib = (Libro)publicaciones[i];
                  System.out.println("---LIBRO---");
                 System.out.println("ISBN: " + lib.getISBN());
                 System.out.println("Titulo: " + lib.getTitulo());
                 System.out.println("Autor: " + lib.getAutor());
                 System.out.println("Edicion: " + lib.getEdicion());
                 System.out.println("Precio: " + lib.getPrecio());
                 System.out.println("Numero paginas: " + lib.getNumpag());
              }
              else if (publicaciones [i] instanceof Periodico )
              {
                  Periodico per = new Periodico();
                  per = (Periodico)publicaciones[i];
                  System.out.println("---Periodico---");
                 System.out.println("Secciones: " + per.getSecciones());
                 System.out.println("Editor: " + per.getEditor());
                 System.out.println("Precios " + per.getPrecio());
                 System.out.println("Numero paginas " + per.getNumpag());              
              }

        }//for

      }
   }//class
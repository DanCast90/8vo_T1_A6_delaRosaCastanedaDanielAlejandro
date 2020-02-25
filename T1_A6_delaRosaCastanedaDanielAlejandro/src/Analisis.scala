import java.io.File 
import java.io.PrintWriter 
import scala.math._  
import scala.io.Source
import scala.util.Random
import scala.io.StdIn._


object Analisis {
  
  def llenarArchivo(num: Int):Unit={ 
    val file_Object = new File("placas.txt" )  
    val print_Writer = new PrintWriter(file_Object)       
    var numeros=""
    var numeros2=""
    for(x<-0 to num){
      numeros=""+Random.nextInt(2)
      for(y<-0 to num){
        numeros2=""+Random.nextInt(2)
        print_Writer.write(numeros2)
      }
      print_Writer.write("\n")
    }
    print_Writer.close()
  }
  
  
  
  def leerArchivo():String={
    var lectura=""
    val fname = "placas.txt"              
        val fSource = Source.fromFile(fname)  
        while (fSource.hasNext) 
        { 
            lectura+=(fSource.next) 
        } 
        fSource.close()  
    lectura
  }
  
  def analizarCBN(x1: String, num:Int,num2:Int):Int={
    var cont=0
    var cont1=0
    for(x<- 0 to num){
      if(x1.substring(x, x+1).equals("1")){
        cont1+=1
      }else{
        cont1=0
      }
      if(cont1==num2){
        cont+=1
      }
    }
    cont
  }
  def analizarCBV(x1: => String, num: =>Int,num2: => Int):Int={
    var cont=0
    var cont1=0
    for(x<- 0 to num){
      if(x1.substring(x, x+1).equals("1")){
        cont1+=1
      }else{
        cont1=0
      }
      if(cont1==num2){
        cont+=1
      }
    }
    cont
  } 
   def main(args: Array[String]): Unit={
     println("de cuantos numeros se va a llenar el archivo nxn ")
     var num=readInt()
     println("de cuantos numeros va a ser el patron de busqueda ")
     var num2=readInt()
     
     llenarArchivo(num)
     println("ARCHIVO LLENADO")
     println("LEYENDO AL ARCHIVO")
     var s=leerArchivo()
     println("ARCHIVO LEIDO")
     println("============================= CALL BY NAME======================")
     var tiempo=System.currentTimeMillis()
     println("Numero de patrones encontrados: "+analizarCBN(s,num,num2))
     tiempo=System.currentTimeMillis()-tiempo;
     println("Tiempo para Call by Name: "+tiempo) 
     println("============================= CALL BY VALUE======================")
      tiempo=System.currentTimeMillis()
     println("Numero de patrones encontrados: "+analizarCBV(s,num,num2))
     tiempo=System.currentTimeMillis()-tiempo;
     println("Tiempo para Call by Value: "+tiempo)
     
     

     
     
     
     
   }
}
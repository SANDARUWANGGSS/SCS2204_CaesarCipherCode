package code
import scala.io.StdIn._
import scala.io.Source._

object Caesar_Cipher 
{
  def main(args : Array[String])
  {
    val alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    val encode=(c:Char,key:Int,a:String)=>a((a.indexOf(c)+key)%a.size)  
    val decode=(c:Char,key:Int,a:String)=>(if((a.indexOf(c)-key)<0) a(a.size-math.abs((a.indexOf(c)-key)%a.size))
                else a((a.indexOf(c)-key)%a.size))
    val cipher=(algo:(Char,Int,String)=>Char,c:Char,key:Int,a:String)=>algo(c:Char,key:Int,a:String)
    print("Enter Your String Needs To Be Encrypted : ")
    val input=readLine().toUpperCase()
    print("Encrypted Result : ")
    val ct=input.map(i=>cipher(encode,i,5,alphabet))
    println(ct)
    print("Decrypted Result : ")
    val pt=ct.map(j=>cipher(decode,j,5,alphabet))
    println(pt)
  }
}
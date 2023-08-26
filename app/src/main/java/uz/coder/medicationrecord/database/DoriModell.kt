package uz.coder.medicationrecord.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "farmasevtika")
data class DoriModell(
    @PrimaryKey(autoGenerate = true)
    var id:Int=0,
    var doriName:String,
    var chiqqanVaqti:String,
    var tugashVaqti:String,
    var miqdori:String,
    var narxi:String,
    var img:String,
    var description:String
) {
    // !! barcha malumotlar string da qilingan pars qilib olasizalr kk bo`lsa !!
/*
 1.	Id
2.	Dori nomi
3.	Chiqarilgan vaqti
4.	Tugash vaqti
5.	Nechi dona
6.	Narxi
7.	Img
8.	Description … yani ta’rif
*/


}
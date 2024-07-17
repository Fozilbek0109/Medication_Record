package uz.coder.medicationrecord.database

import androidx.room.Dao
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
class UserModel(
    @PrimaryKey(autoGenerate = true)
    val  id:Int=0,
    val name:String,
    val email:String,
    val password:String
) {
}
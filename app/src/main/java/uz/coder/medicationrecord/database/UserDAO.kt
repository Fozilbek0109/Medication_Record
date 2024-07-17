package uz.coder.medicationrecord.database

import androidx.room.*

@Dao
interface UserDAO {
    @Insert
    fun addUser(userModel: UserModel)
    @Query("select * from users")
    fun allListUsers():List<UserModel>
    @Delete
    fun deleteUser(userModel: UserModel)
    @Update
    fun editeUser(userModel: UserModel)
}
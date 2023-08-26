package uz.coder.medicationrecord.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface DoriDAO {
    @Insert
    fun add(doriModell: DoriModell)

    @Query("SELECT * FROM farmasevtika")
    fun allList(): List<DoriModell>

    @Delete
    fun delet(doriModell: DoriModell)

    @Update
    fun update(doriModell: DoriModell)

    @Query("Select * From farmasevtika where id=:id")
    fun getByID(id: Int): DoriModell

    @Query("Select * from farmasevtika where doriName like '%' || :name|| '%'")
    fun serachDoriName(name: String): List<DoriModell>
}
package uz.coder.medicationrecord.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [DoriModell::class], version = 1)//1

abstract class DatabaseLocal: RoomDatabase() { //2 room databasedan instanse olingan

    abstract fun dooriDao(): DoriDAO //3
    companion object {
        var instance: DatabaseLocal? = null
        @Synchronized

        fun getInstance(c:Context):DatabaseLocal{
            if(instance==null){
                instance= Room.databaseBuilder(c.applicationContext,DatabaseLocal::class.java,
                    "farm_db").allowMainThreadQueries().build()
            }
            return instance!!
        }
    }
}
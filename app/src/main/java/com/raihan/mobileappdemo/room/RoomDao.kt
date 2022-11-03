package com.raihan.mobileappdemo.room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface RoomDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertData(vararg atmRoomModel: MovieRoomModel)

    @Query("SELECT * FROM room_movie")
    fun readAllData(): LiveData<List<MovieRoomModel>>

    @Query("DELETE FROM room_movie")
    suspend fun deleteallData()

    @Query("SELECT * FROM room_movie WHERE imageId= :imageId")
    fun readList(imageId: String): LiveData<List<MovieRoomModel>>

    @Query("SELECT * FROM room_movie WHERE imageId= :imageId")
    fun readSingle(imageId: String): LiveData<MovieRoomModel>

    @Update
    suspend fun updateData(vararg movieRoomModel: MovieRoomModel)


}
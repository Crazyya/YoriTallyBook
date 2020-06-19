package com.yoriz.yoritallybook.bean

import androidx.room.*

/**
 * Created by yoriz
 * on 2020/6/9 4:45 PM.
 * 消费类型
 */
@Entity(tableName = "consumption_type")
data class ConsumptionType(
    /**
     * 自增ID
     */
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    /**
     * 消费类型名字
     */
    val name: String,
    /**
     * 显示的背景颜色
     */
    val color: Int,
    /**
     * 显示的图，优先显示图片
     */
    val image: String?
)

@Dao
interface ConsumptionTypeDao {
    @Query("select * from consumption_type order by id")
    suspend fun getAll(): List<ConsumptionType>

    @Query("select * from consumption_type where id = :id order by id")
    suspend fun getDataById(id: Int): ConsumptionType

    @Insert
    suspend fun insert(vararg consumptionType: ConsumptionType)

    @Delete
    suspend fun delete(consumptionType: ConsumptionType)
}
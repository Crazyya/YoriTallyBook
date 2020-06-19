package com.yoriz.yoritallybook.bean

import androidx.paging.DataSource
import androidx.room.*
import com.yoriz.yoritallybook.util.Converters
import java.util.*

/**
 * Created by yoriz
 * on 2020/6/9 3:18 PM.
 * 消费记录对象
 */
@Entity(
    tableName = "bill_history",
    indices = [Index("date"),
        Index("date", "consumption_type_id"),
        Index("date", "consumption_type_id", "type"),
        Index("date", "type")]
)
data class BillHistory(
    /**
     * 自增ID，不用管它
     */
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    /**
     * 创建日期
     */
    @TypeConverters(value = [Converters::class])
    val date: Date,
    /**
     * 消费类型关联[ConsumptionType.id]
     */
    @ColumnInfo(name = "consumption_type_id")
    var consumptionTypeId: Int,
    /**
     * 备注
     */
    var remark: String?,
    /**
     * 金额
     */
    var money: String,
    /**
     * 支出[EXPENSE]还是收入[INCOME]的类型
     */
    var type: Int
) {
    companion object {
        /**
         * 支出
         */
        const val EXPENSE = 0

        /**
         * 收入
         */
        const val INCOME = 1
    }
}

@Dao
@TypeConverters(value = [Converters::class])
interface BillHistoryDao {
    /**
     * 根据日期区间获取数据
     * @param strDate 开始日期
     * @param endDate 结束日期
     * @return 日期区间的类型
     */
    @Query("select * from bill_history where date between :strDate and :endDate order by id desc")
    suspend fun getDataByStrEndDate(
        strDate: Date,
        endDate: Date
    ): DataSource.Factory<Int, BillHistory>

    /**
     * 根据日期区间与消费类型获取数据
     * @param strDate 开始日期
     * @param endDate 结束日期
     * @param consumptionTypeId [BillHistory.consumptionTypeId]消费类型的ID
     * @return 日期区间的类型
     */
    @Query("select * from bill_history where date between :strDate and :endDate and consumption_type_id = :consumptionTypeId order by id desc")
    suspend fun getDataByDateAndConsumption(
        strDate: Date,
        endDate: Date,
        consumptionTypeId: Int
    ):DataSource.Factory<Int, BillHistory>

    /**
     * 根据日期区间与消费类型与类型获取数据
     * @param strDate 开始日期
     * @param endDate 结束日期
     * @param consumptionTypeId [BillHistory.consumptionTypeId]消费类型的ID
     * @param type [BillHistory.type] 支出还是收入
     * @return 日期区间的类型
     */
    @Query("select * from bill_history where date between :strDate and :endDate and consumption_type_id = :consumptionTypeId and type = :type order by id desc")
    suspend fun getDataByDateAndConsumptionAndType(
        strDate: Date,
        endDate: Date,
        consumptionTypeId: Int,
        type: Int
    ): DataSource.Factory<Int, BillHistory>

    /**
     * 根据日期区间与类型获取数据
     * @param strDate 开始日期
     * @param endDate 结束日期
     * @param type [BillHistory.type] 支出还是收入
     * @return 日期区间的类型
     */
    @Query("select * from bill_history where date between :strDate and :endDate and type = :type order by id desc")
    suspend fun getDataByDateAndType(
        strDate: Date,
        endDate: Date,
        type: Int
    ): DataSource.Factory<Int, BillHistory>

    @Update
    suspend fun update(billHistory: BillHistory)

    @Insert
    suspend fun insert(vararg billHistory: BillHistory)

    @Insert
    suspend fun insert(billHistory: List<BillHistory>)

    @Delete
    suspend fun delete(billHistory: BillHistory)
}
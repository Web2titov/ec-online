package ru.electric.ec.online.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

/**
 * Класс для хранения поиска
 * @author Сергей Лавров
 * @version 0.8
 */
@Entity
class Search : Request {
    /** Идентификатор для строк таблицы  */
    @PrimaryKey
    var id = 0

    /** Искомый товар или код товара  */
    @ColumnInfo(name = "product")
    var product: String? = null

    /** Запрошенный товар  */
    @ColumnInfo(name = "requestProduct")
    var requestProduct: String? = null

    /** Запрошенное количество товара  */
    @ColumnInfo(name = "requestCount")
    var requestCount = 0

    /** Количество товара на складе  */
    @ColumnInfo(name = "stockCount")
    var stockCount = 0

    /** Кратность товара (размер минимальной неделимой партии)  */
    @ColumnInfo(name = "multiplicity")
    var multiplicity = 0

    /** Единица измерения количества товара  */
    @ColumnInfo(name = "unit")
    var unit: String? = null

    /** Установлена ли галочка у товара  */
    @ColumnInfo(name = "check")
    var check = false

    /** Необходимо обновить статус с сервера, т.к. изменились параметры на клиенте  */
    @ColumnInfo(name = "needUpdate")
    var needUpdate = false

    /** Количество вариантов при расширенном поиске  */
    @ColumnInfo(name = "variantsCount")
    var variantsCount = 0

    /** Вид строки:
     * 1 - флаг,
     * 2 - переключатель,
     * 3 - группа
     * 4 - не найдено,
     */
    @ColumnInfo(name = "itemType")
    var itemType = 0

    /** Статус количества  */
    @ColumnInfo(name = "status")
    var status: String? = null

    /** Название цвета статуса количества  */
    @ColumnInfo(name = "colorName")
    var colorName: String? = null

    /** Цвет статуса количества  */
    @ColumnInfo(name = "color")
    var color = 0

    /**
     * Создание пустой новой строки
     */
    constructor()

    /**
     * Создание новой строки с найденным товаром
     * @param product название товара
     * @param requestProduct запрошенный товар
     * @param requestCount запрошенное количество товара
     * @param stockCount количество товара на складе
     * @param multiplicity кратность товара (размер минимальной неделимой партии)
     * @param unit единица измерения товара
     * @param check установлена ли галочка у товара
     * @param variantsCount количество вариантов при расширенном поиске
     * @param itemType вид строки
     * @param status название цвета статуса количества
     * @param colorName вид строки
     * @param color цвет статуса количества
     */
    @Ignore
    constructor(
        product: String, requestProduct: String, requestCount: Int, stockCount: Int,
        multiplicity: Int, unit: String,
        check: Boolean, needUpdate: Boolean, variantsCount: Int, itemType: Int,
        status: String, colorName: String, color: Int
    ) {
        init(
            product, requestProduct, requestCount, stockCount,
            multiplicity, unit,
            check, needUpdate, variantsCount, itemType,
            status, colorName, color
        )
    }

    @Ignore
    private fun init(
        product: String, requestProduct: String, requestCount: Int, stockCount: Int,
        multiplicity: Int, unit: String,
        check: Boolean, needUpdate: Boolean, variantsCount: Int, itemType: Int,
        status: String, colorName: String, color: Int
    ) {
        this.product = product
        this.requestProduct = requestProduct
        this.requestCount = requestCount
        this.stockCount = stockCount
        this.multiplicity = multiplicity
        this.unit = unit
        this.check = check
        this.variantsCount = variantsCount
        this.itemType = itemType
        this.needUpdate = needUpdate
        this.status = status
        this.colorName = colorName
        this.color = color
    }
}
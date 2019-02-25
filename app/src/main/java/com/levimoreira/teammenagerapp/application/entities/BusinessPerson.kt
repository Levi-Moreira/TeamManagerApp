package com.levimoreira.teammenagerapp.application.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import com.levimoreira.teammenagerapp.application.entities.BusinessPerson.Companion.COLUMN_BUSINESS
import com.levimoreira.teammenagerapp.application.entities.BusinessPerson.Companion.COLUMN_PERSON
import com.levimoreira.teammenagerapp.application.entities.BusinessPerson.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME,
        primaryKeys = [COLUMN_PERSON, COLUMN_BUSINESS],
        foreignKeys = [(ForeignKey(entity = Person::class,
                parentColumns = ["id"],
                childColumns = [COLUMN_PERSON],
                onDelete = ForeignKey.CASCADE)),
            (ForeignKey(entity = Business::class,
                    parentColumns = ["id"],
                    childColumns = [COLUMN_BUSINESS],
                    onDelete = CASCADE))]
)
data class BusinessPerson(@ColumnInfo(name = COLUMN_PERSON) var personId: Long,
                          @ColumnInfo(name = COLUMN_BUSINESS) var businessId: Long) {
    companion object {
        const val TABLE_NAME = "business_person"
        const val COLUMN_PERSON = "personId"
        const val COLUMN_BUSINESS = "businessId"
    }
}
package com.levimoreira.teammenagerapp.application.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.levimoreira.teammenagerapp.application.entities.Business.Companion.TABLE_NAME


@Entity(tableName = TABLE_NAME, foreignKeys = [(ForeignKey(entity = Organization::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("organizationId"), onDelete = ForeignKey.NO_ACTION)), (ForeignKey(
        entity = Person::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("personId"), onDelete = ForeignKey.NO_ACTION
))])
data class Business(@PrimaryKey(autoGenerate = true) var id: Long?,
                    @ColumnInfo(name = COLUMN_TITLE) var title: String,
                    @ColumnInfo(name = COLUMN_DESCRIPTION) var description: String,
                    @ColumnInfo(name = COLUMN_ORGANIZATION) var organizationId: Long,
                    @ColumnInfo(name = COLUMN_PERSON) var personId: Long,
                    @ColumnInfo(name = COLUMN_VALUE) var value: String,
                    @ColumnInfo(name = COLUMN_DEADLINE) var deadline: String,
                    @ColumnInfo(name = COLUMN_STATE) var state: String

) {
    companion object {
        const val TABLE_NAME = "business"
        const val COLUMN_TITLE = "title"
        const val COLUMN_DESCRIPTION = "description"
        const val COLUMN_ORGANIZATION = "organizationId"
        const val COLUMN_PERSON = "personId"
        const val COLUMN_VALUE = "value"
        const val COLUMN_DEADLINE = "deadline"
        const val COLUMN_STATE = "state"

    }
}
package com.levimoreira.teammenagerapp.application.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.levimoreira.teammenagerapp.application.entities.Person.Companion.TABLE_NAME


@Entity(tableName = TABLE_NAME)
data class Person(@PrimaryKey(autoGenerate = true) var id: Long?,
                  @ColumnInfo(name = COLUMN_NAME) var name: String,
                  @ColumnInfo(name = COLUMN_PHONE) var phone: String,
                  @ColumnInfo(name = COLUMN_EMAIL) var email: String

) {
    companion object {
        const val TABLE_NAME = "person"
        const val COLUMN_NAME = "name"
        const val COLUMN_PHONE = "phone"
        const val COLUMN_EMAIL = "email"

    }
}
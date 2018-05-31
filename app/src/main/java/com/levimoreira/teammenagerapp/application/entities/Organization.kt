package com.levimoreira.teammenagerapp.application.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.levimoreira.teammenagerapp.application.entities.Organization.Companion.TABLE_NAME


@Entity(tableName = TABLE_NAME)
data class Organization(@PrimaryKey(autoGenerate = true) var id: Long?,
                        @ColumnInfo(name = COLUMN_NAME) var name: String,
                        @ColumnInfo(name = COLUMN_PHONE) var phone: String,
                        @ColumnInfo(name = COLUMN_ADDRESS) var address: String

) {
    companion object {
        const val TABLE_NAME = "organization"
        const val COLUMN_NAME = "name"
        const val COLUMN_PHONE = "phone"
        const val COLUMN_ADDRESS = "address"

    }
}
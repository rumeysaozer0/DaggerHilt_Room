package com.rumeysaozer.roomdaggerhilt.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
@Entity(tableName = "names")
data class NameItem(
    @SerializedName("female_first_name")
    val femaleFirstName: String,
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("four_word_name")
    val fourWordName: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("initials")
    val initials: String,
    @SerializedName("last_name")
    val lastName: String,
    @SerializedName("male_first_name")
    val maleFirstName: String,
    @SerializedName("middle_name")
    val middleName: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("name_with_middle")
    val nameWithMiddle: String,
    @SerializedName("name_with_initials")
    val nameWithİnitials: String,
    @SerializedName("prefix")
    val prefix: String,
    @SerializedName("two_word_name")
    val twoWordName: String,
    @SerializedName("uid")
    @PrimaryKey val uid: String
)
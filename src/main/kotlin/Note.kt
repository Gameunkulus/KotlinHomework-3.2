data class Note(
    val id: Int?,
    val ownerId: Int,
    val isDeleted: Boolean = false,
    val title: String,
    val text: String,
    val privacy: Int,
    val commentPrivacy: Int,
    val comments: List<Comments> = emptyList()
)

data class Comments(
    val id: Int?,
    val ownerId: Int,
    val text: String
)



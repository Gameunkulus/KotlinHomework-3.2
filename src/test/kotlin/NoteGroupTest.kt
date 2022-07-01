import org.junit.Test

import org.junit.Assert.*

class NoteGroupTest {

    @Test
    fun add() {

       var comments1: List<Comments> = mutableListOf<Comments>()

        val comment1: Comments = Comments(id = 1, ownerId = 36, text = "treck")

        val comment2: Comments = Comments(id = 2, ownerId = 36, text = "too")

        val comment3: Comments = Comments(id = 3, ownerId = 36, text = "small")
        comments1 += comment1
        comments1 += comment2
        comments1 += comment3

        val note1: Note = Note(
            id = 1,
            ownerId = 1,
            title = "Bomfunk1",
            text = "Freestyler!",
            privacy = 1,
            commentPrivacy = 1,
            comments = comments1
        )
        val note2: Note = Note(
            id = 2,
            ownerId = 1,
            title = "Bomfunk2",
            text = "Rock the mickrophone!",
            privacy = 2,
            commentPrivacy = 2,
            comments = comments1
        )
        NoteGroup.add(note1)
        assertEquals(note2, NoteGroup.add(note2))

    }

    @Test
    fun createComment() {

        var comments1: List<Comments> = mutableListOf<Comments>()

        val comment1: Comments = Comments(id = 1, ownerId = 36, text = "treck")

        val comment2: Comments = Comments(id = 2, ownerId = 36, text = "too")

        val comment3: Comments = Comments(id = 3, ownerId = 36, text = "small")
        comments1 += comment1
        comments1 += comment2

        val note1: Note = Note(
            id = 1,
            ownerId = 1,
            title = "Bomfunk1",
            text = "Freestyler!",
            privacy = 1,
            commentPrivacy = 1,
            comments = comments1
        )


        NoteGroup.add(note1)
        assertEquals(true, NoteGroup.createComment(note1, comment3))
    }

    @Test
    fun delete() {
        var comments1: List<Comments> = mutableListOf<Comments>()

        val comment1: Comments = Comments(id = 1, ownerId = 36, text = "treck")

        val comment2: Comments = Comments(id = 2, ownerId = 36, text = "too")

        val comment3: Comments = Comments(id = 3, ownerId = 36, text = "small")
        comments1 += comment1
        comments1 += comment2
        comments1 += comment3

        val note1: Note = Note(
            id = 1,
            ownerId = 1,
            title = "Bomfunk1",
            text = "Freestyler!",
            privacy = 1,
            commentPrivacy = 1,
            comments = comments1
        )
        val note2: Note = Note(
            id = 2,
            ownerId = 1,
            title = "Bomfunk2",
            text = "Rock the mickrophone!",
            privacy = 2,
            commentPrivacy = 2,
            comments = comments1
        )
        NoteGroup.add(note1)
        NoteGroup.add(note2)
        assertEquals(true, NoteGroup.delete(note1))
    }

    @Test
    fun deleteComment() {
        var comments1: List<Comments> = mutableListOf<Comments>()

        val comment1: Comments = Comments(id = 1, ownerId = 36, text = "treck")

        val comment2: Comments = Comments(id = 2, ownerId = 36, text = "too")

        val comment3: Comments = Comments(id = 3, ownerId = 36, text = "small")
        comments1 += comment1
        comments1 += comment2
        comments1 += comment3

        val note1: Note = Note(
            id = 1,
            ownerId = 1,
            title = "Bomfunk1",
            text = "Freestyler!",
            privacy = 1,
            commentPrivacy = 1,
            comments = comments1
        )
        val note2: Note = Note(
            id = 2,
            ownerId = 1,
            title = "Bomfunk2",
            text = "Rock the mickrophone!",
            privacy = 2,
            commentPrivacy = 2,
            comments = comments1
        )
        NoteGroup.add(note1)
        NoteGroup.add(note2)

        assertEquals(true, NoteGroup.deleteComment(1,2))

    }

    @Test
    fun edit() {
        var comments1: List<Comments> = mutableListOf<Comments>()

        val comment1: Comments = Comments(id = 1, ownerId = 36, text = "treck")

        val comment2: Comments = Comments(id = 2, ownerId = 36, text = "too")

        val comment3: Comments = Comments(id = 3, ownerId = 36, text = "small")
        comments1 += comment1
        comments1 += comment2
        comments1 += comment3

        val note1: Note = Note(
            id = 1,
            ownerId = 1,
            title = "Bomfunk1",
            text = "Freestyler!",
            privacy = 1,
            commentPrivacy = 1,
            comments = comments1
        )
        val note2: Note = Note(
            id = 2,
            ownerId = 1,
            title = "Bomfunk2",
            text = "Rock the mickrophone!",
            privacy = 2,
            commentPrivacy = 2,
            comments = comments1
        )
        val note3: Note = Note(
            id = 2,
            ownerId = 1,
            title = "Bomfunk3",
            text = "Straight from the top to abowe!",
            privacy = 3,
            commentPrivacy = 3,
            comments = comments1
        )
        NoteGroup.add(note1)
        NoteGroup.add(note2)
        assertEquals(note3, NoteGroup.edit(note3))
    }

    @Test
    fun editComment() {

        var comments1: List<Comments> = mutableListOf<Comments>()

        val comment1: Comments = Comments(id = 1, ownerId = 36, text = "treck")

        val comment2: Comments = Comments(id = 2, ownerId = 36, text = "too")

        val comment3: Comments = Comments(id = 3, ownerId = 36, text = "small")

        val comment4: Comments = Comments(id = 3, ownerId = 45, text = "far")

        val note1: Note = Note(
            id = 1,
            ownerId = 1,
            title = "Bomfunk1",
            text = "Freestyler!",
            privacy = 1,
            commentPrivacy = 1,
            comments = comments1
        )
        val note2: Note = Note(
            id = 2,
            ownerId = 1,
            title = "Bomfunk2",
            text = "Rock the mickrophone!",
            privacy = 2,
            commentPrivacy = 2,
            comments = comments1
        )
        NoteGroup.add(note1)
        NoteGroup.add(note2)
        NoteGroup.createComment(note2,comment1)
        NoteGroup.createComment(note2,comment2)
        NoteGroup.createComment(note2,comment3)
        assertEquals(comment4, NoteGroup.editComment(note2, comment4))
    }

    @Test
    fun get() {
    }

    @Test
    fun getByID() {
    }

    @Test
    fun getComments() {
    }

    @Test
    fun restore() {
    }
}
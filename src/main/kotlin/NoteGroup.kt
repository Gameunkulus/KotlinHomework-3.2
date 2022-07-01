object NoteGroup : BaseGroup<Note, Comments>() {

    //create block
    var checComId = 0

    override fun add(note: Note): Note {
        val newNote: Note = note.copy(id = getNextId())
        notes += newNote
        return newNote
    }

    fun createComment(note: Note, comment: Comments): Boolean {
        for ((index, item) in notes.withIndex()) {
            if (item.id == note.id) {
                notes[index] = item.copy(comments = note.comments + comment.copy(id = checComId + 1))
                return true
            }
        }
        throw PostNotFoundException()
    }

    //delete block

    override fun delete(note: Note): Boolean {
        for ((index, item) in notes.withIndex()) {
            if (item.id == note.id) {
                if (item.equals(note)) {
                    notes[index] = notes[index].copy(isDeleted = true)
                    return true
                }
            }
        }
        throw PostNotFoundException()
    }

    fun deleteComment(ownerId: Int, commentId: Int): Boolean {
        for ((index, item) in notes.withIndex()) {
            if (item.id == ownerId && !item.isDeleted) {
                for ((itemId, item) in notes[index].comments.withIndex()) {
                    if (itemId == commentId) {
                        return comments.remove(item)
                    }
                }
            }
        }
        return false
    }

    //edit block

    override fun edit(note: Note): Boolean {
        for ((index, item) in notes.withIndex()) {
            if (item.id == note.id && !item.isDeleted) {
                notes[index] = note
                return true
            }
        }
        throw PostNotFoundException()
    }

    fun editComment(note: Note, comment: Comments): Comments {
        for ((index, item) in notes.withIndex()) {
            if (item.id == note.id && !item.isDeleted) {
                for ((index, tool) in notes[index].comments.withIndex())
                    if (tool.id == comment.id) {
                        comments[index] = comment.copy(id = index)
                        return comment
                    }
            }
        }
        throw PostNotFoundException()

    }

    //get block

    override fun get(note: Note): String {
        val notesList = mutableListOf<Note>()
        for ((index, item) in notes.withIndex()) {
            if (item.ownerId == note.ownerId ) {
                notesList += notes[index]
            }
        }
        if (notesList.isEmpty()) {
            throw PostNotFoundException()
        } else return notesList.toString()
    }

    fun getByID(noteId: Int): Note {
        for ((index, item) in notes.withIndex()) {
            if (item.id == noteId && !item.isDeleted) {
                return notes[index]
            }
        }
        throw PostNotFoundException()
    }

    fun getComments(note: Note): String {
        for ((index, item) in notes.withIndex()) {
            if (item.id == note.id && !item.isDeleted) {
                return notes[index].comments.toString()
            }
        }
        throw PostNotFoundException()
    }

    fun restore(note: Note): Boolean{
        for((index, item) in notes.withIndex()){
            if(item.id == note.id){
                notes[index] = note
            }
        }
        throw PostNotFoundException()
    }


}
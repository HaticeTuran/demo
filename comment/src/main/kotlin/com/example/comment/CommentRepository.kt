package com.example.comment

import kotlinx.coroutines.flow.Flow
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface CommentRepository : CoroutineCrudRepository<Comment, Int> {

    @Query("SELECT * FROM comment")
    suspend fun findComments():Flow<Comment>

    @Query("SELECT * from comment c where c.commentId = id ")
    suspend fun findCommentById(id: UUID): Comment

    @Query("DELETE FROM Comments c WHERE c.comment_id = id")
    suspend fun deleteById(id:UUID)



}
package group9.geektext.service;

import group9.geektext.entity.Comment;
import group9.geektext.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    // Get all comments for a specific book
    public List<Comment> getCommentsByBook(Long bookId) {
        return commentRepository.findByBook_Id(bookId);
    }

    // Get all comments from a specific user
    public List<Comment> getCommentsByUser(Long userId) {
        return commentRepository.findByUser_Id(userId);
    }

    // Save a new comment
    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
    }

    // Update a comment
    public Comment updateComment(Comment comment) {
        return commentRepository.save(comment);
    }

    // Delete a comment
    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}

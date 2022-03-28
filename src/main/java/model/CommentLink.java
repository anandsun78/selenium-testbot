package model;

public class CommentLink {
    private String commentURL;

    public CommentLink(String commentURL) {
        this.commentURL = commentURL;
    }

    public String getCommentURL() {
        return commentURL;
    }

    public void setCommentURL(String commentURL) {
        this.commentURL = commentURL;
    }
}

package operations;

import model.CommentLink;
import model.LoginPair;
import model.YoutubeLink;

import java.io.IOException;
import java.util.List;

public interface DataOperations {
    List<LoginPair> retrieveAccounts(String path) throws IOException;

    List<CommentLink> retrieveComments(String path) throws IOException;

    List<YoutubeLink> retrieveVideos(String path) throws IOException;
}

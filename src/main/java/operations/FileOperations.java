package operations;

import model.CommentLink;
import model.LoginPair;
import model.YoutubeLink;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileOperations implements DataOperations {


    public List<LoginPair> retrieveAccounts(String path) throws IOException {

        List<LoginPair> credentials = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(path))) {
            while (scanner.hasNext()) {
                credentials.add(new LoginPair(scanner.nextLine(),scanner.nextLine()));
            }
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }
        return credentials;
    }


    public List<CommentLink> retrieveComments(String path) throws IOException {

        List<CommentLink> comments = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(path))) {
            while (scanner.hasNext()) {
                comments.add(new CommentLink(scanner.nextLine()));
            }
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }
        return comments;
    }


    public List<YoutubeLink> retrieveVideos(String path) throws IOException {

        List<YoutubeLink> videos = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(path))) {
            while (scanner.hasNext()) {
                videos.add(new YoutubeLink(scanner.nextLine()));
            }
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }
        return videos;
    }
}

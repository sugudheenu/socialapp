package com.sugudheenu.commandline;

import com.sugudheenu.domain.Post;
import com.sugudheenu.repository.UsersPostRepository;

import java.util.List;
import java.util.Scanner;

/**
 * Command line social application
 */
public class CommandLineSocialApplication {

    private final UsersPostRepository usersPostRepository;

    public CommandLineSocialApplication(UsersPostRepository usersPostRepository) {
        this.usersPostRepository = usersPostRepository;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        displayPrompt();
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (!line.isEmpty()) {
                List<Post> posts = usersPostRepository.getPosts(line);
                posts.stream().forEach((post) -> System.out.println(post.feedEntry()));
            }
            displayPrompt();
        }
    }

    private void displayPrompt() {
        System.out.print("> ");
        System.out.flush();
    }
}

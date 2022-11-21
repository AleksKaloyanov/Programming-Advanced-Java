package ObjectsAndClassesEx;

import java.util.Scanner;

public class Article {
    private String title;
    private String content;
    private String author;

    public Article(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    private void edit(String content) {
        this.content = content;
    }

    private void changeAuthor(String author) {
        this.author = author;
    }

    private void rename(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return String.format("%s - %s: %s", title, content, author);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split(", ");
        String title = input[0];
        String content = input[1];
        String author = input[2];

        Article article = new Article(title, content, author);

        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = sc.nextLine().split(": ");
            String cmd = tokens[0];

            if (cmd.equals("Edit")) {
                article.edit(tokens[1]);
            } else if (cmd.equals("ChangeAuthor")) {
                article.changeAuthor(tokens[1]);
            } else {
                article.rename(tokens[1]);
            }
        }
        System.out.println(article);
    }
}

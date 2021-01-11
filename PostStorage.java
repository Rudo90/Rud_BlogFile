public interface PostStorage {

    void add (Post post);
    Post getPostByTitle (String title) throws PostNotFoundException;
    Post searchPostsByKeyword (String keyword) throws WrongPasswordKeywordException;
    void printAllPosts ();
    Post printPostsByCategory (String category) throws NoPostCategoryException;
    void deletePostByTitle (String title);
}

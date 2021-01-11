import java.io.Serializable;
import java.util.List;

public class PostStorageImpl implements PostStorage, Serializable {

    List<Post> postList;


    public PostStorageImpl(){
        postList = FileUtil.deserializePost();
    }

    public void add(Post post) {
        postList.add(post);
        FileUtil.postSerialize(postList);
    }


    @Override
    public Post getPostByTitle(String title) throws PostNotFoundException {

        for (int i = 0; i < postList.size(); i++) {
            if (postList.get(i).toString().contains(title)) {
                return postList.get(i);
            }
        }
        throw new PostNotFoundException("No post available!");
    }

    @Override
    public Post searchPostsByKeyword(String keyword) throws WrongPasswordKeywordException {

        for (int i = 0; i < postList.size(); i++) {
            if (postList.get(i).getTitle().contains(keyword) || postList.get(i).getText().contains(keyword)) {
                return postList.get(i);
            }
        }
        throw new WrongPasswordKeywordException("Wrong keyword!");
    }

    @Override
    public void printAllPosts() {

        for (int i = 0; i < postList.size(); i++) {
            if (postList.get(i) != null) {
                System.out.println(postList.get(i).toString());
            }
        }
    }

    @Override
    public Post printPostsByCategory(String category) throws NoPostCategoryException {

        for (int i = 0; i < postList.size(); i++) {
            if (postList.get(i).getCategory().contains(category)) {
                return postList.get(i);
            }
        }
        throw new NoPostCategoryException("No post category is available!");
    }

    @Override
    public void deletePostByTitle(String title) {
        for (int i = 0; i < postList.size(); i++){
            if (postList.get(i).getTitle().contains(title)){
                postList.remove(i);
            }
        }
        FileUtil.deserializePost();
    }
}
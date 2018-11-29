import com.nf147.sss.dao.CommonDAO;
import com.nf147.sss.entity.Author;
import com.nf147.sss.entity.Blog;
import com.nf147.sss.entity.Comment;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession session = factory.openSession();

       /* Object o = session.selectOne("xxx.findById");
        Object o = session.selectOne("xxx.findById", 3);
        Object o = session.selectOne("xxx.findByName", "毛%");
        Object o = session.selectOne("xxx.findByNameAndCity", new HashMap<String, String>() {{
            put("name", "郭敬明");
            put("city", "上海");
        }});
        Object o = session.selectOne("xxx.findByNameAndCity", new Author("鲁迅", "浙江"));

        List<Object> lst = session.selectList("findAll");
        List<Object> lst = session.selectList("findAllLimit", 1);
        RowBounds rowBounds = new RowBounds(2, 3);
        List<Object> lst = session.selectList("findAll", null, rowBounds);
        lst.forEach(System.out::println);*/

//        Map<Object, Object> map = session.selectMap("findAll", null, "name", new RowBounds(0, 2));
//        System.out.println(map);
//        System.out.println(map.get("鲁迅"));
//
//        Cursor<Object> cs = session.selectCursor("findAll");
//        Iterator<Object> iterator = cs.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }
//
//        session.select("findAll", new ResultHandler() {
//            @Override
//            public void handleResult(ResultContext resultContext) {
//                if (resultContext.getResultCount() % 2 == 0)
//                    System.out.println(">>>> " + resultContext.getResultCount() + " : " + resultContext.getResultObject());
//            }
//        });

        CommonDAO mapper = session.getMapper(CommonDAO.class);
//        List<Author> authors = mapper.findAll(new RowBounds(1, 3));
////        authors.forEach(System.out::println);
////
////        List<Author> authors1 = mapper.findAllIdBiggerThan(3, new RowBounds(1, 2));
////        authors1.forEach(System.out::println);
//        System.out.println(mapper.findByNameAndCity("郭敬明' or 1=1 or name='xxx", "上海"));
//
//        mapper.delOne("'1' or 1=1");

//        int ret = mapper.delThree("update sss_blog set content='你不是苍蝇' ", 3);
//        session.commit();

//        Blog blog = new Blog();
//        blog.setId(3);
//        blog.setContent("我不知道苍蝇在哪里。");
//        System.out.println(mapper.updateBlog3(blog));

//        Author author = new Author();
//        author.setName("曹雪芹22");
//        author.setCity("北京222");
//        mapper.insertAuthor(author);
//
//        System.out.println(author.getId());
//
//        session.commit();

//        mapper.selectAll().forEach(System.out::println);

        List<Blog> blogs = mapper.selectBlogs();
        Blog blog = blogs.get(0);
        Author author = blog.getAuthor();
        List<Comment> comments = blog.getComments();
        System.out.println(blog.getTitle());
        System.out.println(author.getName());

        System.out.println(comments);
    }
}

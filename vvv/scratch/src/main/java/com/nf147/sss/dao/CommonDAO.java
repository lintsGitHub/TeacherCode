package com.nf147.sss.dao;

import com.nf147.sss.entity.Author;
import com.nf147.sss.entity.Blog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommonDAO {
    List<Author> selectAll();
    List<Blog> selectBlogs();

    int updateBlog(@Param("id") int id, @Param("content") String content);
    int updateBlog2(Blog blog);
    int updateBlog3(Blog blog);

    int insertAuthor(Author author);

//    Author findById(int id);
//    Author findByName(String name);
//    List<Author> findByNameAndCity(@Param("name") String name, @Param("city") String city);
//    List<Author> findAll(RowBounds rowBounds);
//    List<Author> findAllIdBiggerThan(int id, RowBounds rowBounds);
//    List<Author> findAllLimit(int num);
//    int delOne(String id);
//    int delTwo(@Param("tablename") String tablename, @Param("id") int id);
//    int delThree(@Param("st") String st, @Param("id") int id);
}

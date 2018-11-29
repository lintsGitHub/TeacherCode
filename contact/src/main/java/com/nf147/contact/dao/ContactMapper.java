package com.nf147.contact.dao;

import com.nf147.contact.entity.Contact;
import java.util.List;

public interface ContactMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Contact record);

    Contact selectByPrimaryKey(Integer id);

    List<Contact> selectAll();

    int updateByPrimaryKey(Contact record);
}
package com.hjx.webmaker.modules.core.mapper;

import com.hjx.webmaker.modules.core.domain.Article;
import com.hjx.webmaker.modules.core.domain.ArticleCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ArticleMapper {
    long countByExample(ArticleCriteria example);

    int deleteByExample(ArticleCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(Article record);

    int insertSelective(Article record);

    List<Article> selectByExampleWithBLOBs(ArticleCriteria example);

    List<Article> selectByExample(ArticleCriteria example);

    Article selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Article record, @Param("example") ArticleCriteria example);

    int updateByExampleWithBLOBs(@Param("record") Article record, @Param("example") ArticleCriteria example);

    int updateByExample(@Param("record") Article record, @Param("example") ArticleCriteria example);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKeyWithBLOBs(Article record);

    int updateByPrimaryKey(Article record);
}
package com.maggie.hrm.repostory;

import com.maggie.hrm.doc.EsCourse;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface EsCourseRepostory extends ElasticsearchRepository<EsCourse,Long> {
}

package com.koscom.springboot.domain.posts;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest

public class PostsRepositoryTest {
    @Autowired
    PostsRepository postsRepository;

//  @AfterEach
//  void tearDown() {
//      postsRepository.deleteAll();
//  }

    @Test
    void 게시글저장_불러오기() {
        String title = "테스트 타이틀";
        String content = "테스트 본문";

        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .build());

        List<Posts> result = postsRepository.findAll();

        System.out.println(result.get(0).getId());
        System.out.println(result.get(0).getTitle());

        assertThat(result.get(0).getTitle()).isEqualTo(title);
        assertThat(result.get(0).getContent()).isEqualTo(content);


    }
}

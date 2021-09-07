package com.koscom.springboot.service;

import com.koscom.springboot.domain.posts.Posts;
import com.koscom.springboot.domain.posts.PostsRepository;
import com.koscom.springboot.web.dto.posts.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor    // final로 선언된 필드들은 생성자 항목으로 자동 포함시켜서 생성자 생성
@Service  // spring bean 등록 & Service 클래스 선언
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save (PostsSaveRequestDto requestDto) {
        Posts posts = postsRepository.save(requestDto.toEntity());
        return posts.getId();
    }

}

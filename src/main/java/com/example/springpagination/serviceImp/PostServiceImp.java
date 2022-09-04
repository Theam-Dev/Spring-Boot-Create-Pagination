package com.example.springpagination.serviceImp;

import com.example.springpagination.model.Post;
import com.example.springpagination.paging.Paged;
import com.example.springpagination.paging.Paging;
import com.example.springpagination.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImp{

    private final PostRepository repository;

    @Autowired
    public PostServiceImp(PostRepository repository) {
        this.repository = repository;
    }

    public Paged<Post> getPage(int pageNumber, int size) {
        PageRequest request = PageRequest.of(pageNumber - 1, size,Sort.Direction.ASC, "id");
        Page<Post> postPage = repository.findAll(request);
        return new Paged<>(postPage, Paging.of(postPage.getTotalPages(), pageNumber, size));
    }
}

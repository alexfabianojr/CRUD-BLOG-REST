package com.spring.codeblog.utils;

import com.spring.codeblog.model.Post;
import com.spring.codeblog.repository.CodeblogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class DummyData {

    @Autowired
    CodeblogRepository codeblogRepository;

    /*classe comentada porque o banco já foi populado*/
    //@PostConstruct/*tudo o que tem dentro do método vai ser executado conforme a aplicação for subindo*/
    public void savePosts() {

        ArrayList<Post> postList = new ArrayList<>();

        Post post1 = new Post();
        Post post2 = new Post();

        post1.setAutor("Alex Fabiano");
        post1.setLocalDate(LocalDate.now());
        post1.setTitulo("Spring");
        post1.setTexto("harvest moon back to nature");

        post2.setAutor("Alex B.");
        post2.setLocalDate(LocalDate.now());
        post2.setTitulo("Hello You");
        post2.setTexto("treant lion jakiro crystal");

        postList.add(post1);
        postList.add(post2);

        for (Post post : postList) {
            Post postSaved = codeblogRepository.save(post);
            System.out.println(postSaved.getId());
        }
    }
}

package com.patriciatersariol.workshopspring.config;

import com.patriciatersariol.workshopspring.domain.Post;
import com.patriciatersariol.workshopspring.domain.User;
import com.patriciatersariol.workshopspring.dto.AuthorDTO;
import com.patriciatersariol.workshopspring.repository.PostRepository;
import com.patriciatersariol.workshopspring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Testando post 1", "Esse é o primeiro post", new AuthorDTO(maria));
        Post post2 = new Post(null, sdf.parse("21/03/2018"), "Testando post 2", "Esse é o segundo post", new AuthorDTO(maria));
        Post post3 = new Post(null, sdf.parse("21/03/2018"), "Testando post 3", "Esse é o segundo post", new AuthorDTO(bob));

        postRepository.saveAll(Arrays.asList(post1, post2));

        maria.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(maria);
    }
}

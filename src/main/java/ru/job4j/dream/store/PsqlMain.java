package ru.job4j.dream.store;

import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.model.Post;

import java.time.LocalDate;

public class PsqlMain {
    public static void main(String[] args) {
        Store store = PsqlStore.instOf();
        Post post1 = new Post(0, "Java Job 1", "Job description 1", LocalDate.of(2021, 3, 1));
        Post post2 = new Post(0, "Java Job 2", "Job description 2", LocalDate.of(2021, 1, 10));
        Post post3 = new Post(0, "Java Job 3", "Job description 3", LocalDate.now());
        store.save(post1);
        store.save(post2);
        store.save(post3);
        System.out.println("-----Find All Posts-----");
        for (Post post : store.findAllPosts()) {
            System.out.println(post);
        }
        System.out.println("----Find Post By Id----");
        System.out.println(store.findPostById(post2.getId()));
        System.out.println("----Update Post------");
        post1.setName("Edited name for Java Job 1");
        System.out.println(post1);
        store.save(post1);
        System.out.println(store.findPostById(post1.getId()));
        System.out.println("*********************");
        Candidate candidate1 = new Candidate(0, "Ivan Ivanov");
        Candidate candidate2 = new Candidate(0, "Petr Petrov");
        Candidate candidate3 = new Candidate(0, "Pavel Pavlov");
        store.save(candidate1);
        store.save(candidate2);
        store.save(candidate3);
        System.out.println("-----Find All Candidates-----");
        for (Candidate candidate : store.findAllCandidates()) {
            System.out.println(candidate);
        }
        System.out.println("----Find Candidate By Id----");
        System.out.println(store.findCandidateById(candidate2.getId()));
        System.out.println("----Update Candidate------");
        candidate1.setName("Edited name for Ivan Ivanov");
        System.out.println(candidate1);
        store.save(candidate1);
        System.out.println(store.findCandidateById(candidate1.getId()));
        System.out.println("-----Remove Candidate-----");
        store.deleteCandidate(candidate3.getId());
        for (Candidate candidate : store.findAllCandidates()) {
            System.out.println(candidate);
        }
    }
}
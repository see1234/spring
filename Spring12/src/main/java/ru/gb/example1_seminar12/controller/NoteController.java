package ru.gb.example1_seminar12.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.gb.example1_seminar12.model.Note;
import ru.gb.example1_seminar12.observer.ConcreteObserver;
import ru.gb.example1_seminar12.services.FileGateway;

import java.time.LocalDateTime;
import java.util.List;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.gb.example1_seminar12.model.Note;
import ru.gb.example1_seminar12.observer.ConcreteSubject;
import ru.gb.example1_seminar12.observer.Observer;
import ru.gb.example1_seminar12.services.FileGateway;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Ну, это наш рест контролёр
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/notes")
public class NoteController implements Observer {
    private final FileGateway fileGateway;
    public static boolean observer = false;
    private ConcreteSubject subject = new ConcreteSubject();
    public void registerObserver() {
        ConcreteObserver observer1 = new ConcreteObserver();
        ConcreteObserver observer2 = new ConcreteObserver();

        subject.registerObserver(observer1);
        subject.registerObserver(observer2);
        observer = true;
    }
    @PostMapping
    public ResponseEntity<Note> addNote(@RequestBody Note note) {

         if(!observer) {
             registerObserver();
         }
        note.setCreation(LocalDateTime.now());
        fileGateway.writeToFile(note.getTitle() + ".txt", "Запрос от пользователя [" + note.getCreation() + "]: " + note.getBody());

        // Уведомляем наблюдателей
        subject.notifyObservers("New note added: " + note.getTitle());

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public void update(String message) {
        System.out.println("Observer received message: " + message);
    }
}
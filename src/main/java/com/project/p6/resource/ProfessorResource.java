package com.project.p6.resource;

import com.project.p6.persistance.Professor;
import com.project.p6.service.ProfessorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/professors")
public class ProfessorResource {

    private final ProfessorService professorService;

    public ProfessorResource(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @GetMapping
    public List<Professor> getAllProfessors() {
        return professorService.getAllProfessors();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Professor> getProfessorById(@PathVariable int id) {
        Professor professor = professorService.getProfessorById(id);
        return professor != null ? ResponseEntity.ok(professor) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Professor> createProfessor(@RequestBody Professor professor) {
        Professor savedProfessor = professorService.createProfessor(professor);
        return ResponseEntity.ok(savedProfessor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Professor> updateProfessor(@PathVariable int id, @RequestBody Professor professor) {
        Professor updatedProfessor = professorService.updateProfessor(id, professor);
        return updatedProfessor != null ? ResponseEntity.ok(updatedProfessor) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfessor(@PathVariable int id) {
        if (professorService.deleteProfessor(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

//com
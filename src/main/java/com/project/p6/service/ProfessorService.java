package com.project.p6.service;

import com.project.p6.persistance.Professor;
import com.project.p6.persistance.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {

    ProfessorRepository professorRepository;

    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public List<Professor> getAllProfessors() {
        return this.professorRepository.findAll();
    }

    public Professor getById(int id) {
        return this.professorRepository.findById(id).get();
    }

    public Professor getByProfessorName(String name) {
        return this.professorRepository.findByName(name);
    }

    public Professor add(Professor professor) {
        return this.professorRepository.save(professor);
    }

    public Professor update(int id, Professor professor) {
        if (professorRepository.existsById(id)) {
            professor.setId(id);
            return professorRepository.save(professor);
        }
        return null;
    }

    public boolean deleteProfessor(int id) {
        if (professorRepository.existsById(id)) {
            professorRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

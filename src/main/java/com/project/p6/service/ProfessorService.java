package com.project.p6.service;

import com.project.p6.persistance.Professor;
import com.project.p6.persistance.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {

    private final ProfessorRepository professorRepository;

    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public List<Professor> getAllProfessors() {
        return professorRepository.findAll();
    }

    public Professor getProfessorById(int id) {
        return professorRepository.findById(id).orElse(null);
    }

    public Professor createProfessor(Professor professor) {
        return professorRepository.save(professor);
    }

    public Professor updateProfessor(int id, Professor professor) {
        if (professorRepository.existsById(id)) {
            professor.setProfessorId(id);
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

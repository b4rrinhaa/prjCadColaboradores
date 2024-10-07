package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Colaborador;
import com.example.demo.repositories.ColaboradorRepository;

@Service
public class ColaboradorService {
    private final ColaboradorRepository colaboradorRepository;

    @Autowired
    public ColaboradorService(ColaboradorRepository colaboradorRepository) {
        this.colaboradorRepository = colaboradorRepository;
    }

    public Colaborador saveColaborador(Colaborador colaborador) {
        return colaboradorRepository.save(colaborador);
    }

    public Colaborador getColaboradorById(Long id) {
        return colaboradorRepository.findById(id).orElse(null);
    }

    public List<Colaborador> getAllColaboradores() {
        return colaboradorRepository.findAll();
    }

    public Colaborador updateColaborador(Long id, Colaborador colaboradorDetails) {
        Colaborador colaborador = colaboradorRepository.findById(id).orElse(null);
        if (colaborador != null) {
            colaborador.setCtps(colaboradorDetails.getCtps());
            colaborador.setPis(colaboradorDetails.getPis());
            colaborador.setTituloEleitor(colaboradorDetails.getTituloEleitor());
            colaborador.setReservista(colaboradorDetails.getReservista());
            colaborador.setEstadoCivil(colaboradorDetails.getEstadoCivil());
            colaborador.setNumDependentes(colaboradorDetails.getNumDependentes());
            colaborador.setAtivo(colaboradorDetails.getAtivo());
            colaborador.setSetor(colaboradorDetails.getSetor());
            colaborador.setCargo(colaboradorDetails.getCargo());
            colaborador.setSalario(colaboradorDetails.getSalario());
            colaborador.setTelefone1(colaboradorDetails.getTelefone1());
            colaborador.setTelefone2(colaboradorDetails.getTelefone2());
            colaborador.setEmailPessoal(colaboradorDetails.getEmailPessoal());
            colaborador.setEmailCorporativo(colaboradorDetails.getEmailCorporativo());
            return colaboradorRepository.save(colaborador);
        }
        return null;
    }

    public void deleteColaborador(Long id) {
        colaboradorRepository.deleteById(id);
    }
}


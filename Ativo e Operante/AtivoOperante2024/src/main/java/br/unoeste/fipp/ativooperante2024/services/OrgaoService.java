package br.unoeste.fipp.ativooperante2024.services;

import br.unoeste.fipp.ativooperante2024.db.entities.Orgao;
import br.unoeste.fipp.ativooperante2024.db.repositories.OrgaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrgaoService {
    @Autowired
    private OrgaoRepository repo;

    public Orgao save(Orgao orgao)
    {
        return repo.save(orgao);
    }
    public Orgao getById(Long id)
    {
        Orgao orgao = repo.findById(id).get();
        return orgao;
    }
    public List<Orgao> getAll()
    {
        return repo.findAll();
    }
    public boolean delete(Long id)
    {
        try{
            repo.deleteById(id);
        }
        catch (Exception e) {
            return false;
        }
        return true;
    }

    public Orgao update(Orgao orgao) {
        Optional<Orgao> existingOrgao = repo.findById(orgao.getId());
        if (existingOrgao.isPresent()) {
            return repo.save(orgao);
        } else {
            return null;
        }
    }
}

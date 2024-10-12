package br.gov.sp.fatec.lab4.evaluationlab4.repository;

import br.gov.sp.fatec.lab4.evaluationlab4.entity.AltAlerta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AltAlertaRepository extends JpaRepository<AltAlerta, Long>{

    @Query("SELECT a FROM AltAlerta a where a.altMensagem = :altMensagem AND a.altNivel = :altNivel")
    List<AltAlerta> buscarAlertas(@Param("altMensagem") String altMensagem, @Param("altNivel") int altNivel);

}

package com.uoc.ggymbackend.repositories;

import com.uoc.ggymbackend.domain.CredencialesUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CredencialesUsuarioRepository extends JpaRepository<CredencialesUsuario, String> {

    CredencialesUsuario findByEmailIgnoreCaseAndPassword(String email, String password);

}

package dev.otthon.projectmanagementsystem.services;

import dev.otthon.projectmanagementsystem.entities.Funcionario;
import dev.otthon.projectmanagementsystem.entities.UserDetailsImpl;
import dev.otthon.projectmanagementsystem.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


/*
* o código abaixo é a implementação correta da interface UserDetailsService
* e assim o Spring Security consiga encontrar um funcionário de acordo com o
* email que está sendo pego do FuncionarioRepository passado no formulário de login.
* */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Funcionario funcionario = funcionarioRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));

        return new UserDetailsImpl(funcionario);
    }
}

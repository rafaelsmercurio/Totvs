package br.com.totvs.clienttotvs.repository.jdbc;

import br.com.totvs.clienttotvs.model.ClientUsers;
import br.com.totvs.clienttotvs.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class ClientRepositoryJdbc implements ClientRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ClientUsers clientUsers;

    @Override
    public List<ClientUsers> getClients() {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM USERS");

        final var params = new MapSqlParameterSource()
                .addValue("NAME", clientUsers.getName())
                .addValue("CPF", clientUsers.getDocumentNumber())
                .addValue("MAIL", clientUsers.getMail());

        try {
            return jdbcTemplate.query(sql.toString(), new BeanPropertyRowMapper(ClientUsers.class));
        } catch (EmptyResultDataAccessException e) {
            return Collections.emptyList();
        }
    }

    @Override
    public List<ClientUsers> getStatus(String cpf) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT STATUS FROM USERS WHERE CPF = " + cpf);

        final var params = new MapSqlParameterSource()
                .addValue("STATUS", clientUsers.getStatus());

        try {
            return jdbcTemplate.query(sql.toString(), new BeanPropertyRowMapper(ClientUsers.class));
        } catch (EmptyResultDataAccessException e) {
            return Collections.emptyList();
        }
    }
}

package br.com.lucasmancan.datavsjdbc

import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import java.sql.ResultSet
import java.sql.SQLException

@RestController
class DataController(val repository: ModeloExemploRepository, val jdbcTemplate: JdbcTemplate) {

    class ModeloExemploRowMapper : RowMapper<ModeloExemplo?> {
        @Throws(SQLException::class)
        override fun mapRow(rs: ResultSet, rowNum: Int): ModeloExemplo {
            val employee = ModeloExemplo(
                rs.getInt("id"),
                rs.getString("o2"),
                rs.getString("o3"),
                rs.getString("o4"),
                rs.getString("o5"),
                rs.getString("o6"),
                rs.getString("o7"),
                rs.getString("o8"),
                rs.getString("o9"),
                rs.getString("o10"),

            )
            return employee
        }
    }

    @GetMapping("/jpa")
    @ResponseBody
    fun getJpa(): Iterable<ModeloExemplo?> {
        return repository.findAll()
    }

    @GetMapping("/jdbc")
    @ResponseBody
    fun getJDBC(): MutableList<ModeloExemplo?> {

        val sql = "select * from Modelo_Exemplo;"

        return jdbcTemplate.query(
            sql, ModeloExemploRowMapper()
        )
    }
}
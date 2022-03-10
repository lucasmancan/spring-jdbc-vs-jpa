package br.com.lucasmancan.datavsjdbc

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.transaction.annotation.Transactional


@SpringBootApplication
class DatavsjdbcApplication(val repository: ModeloExemploRepository, val jdbcTemplate: JdbcTemplate) : CommandLineRunner {
    @Transactional
    override fun run(vararg args: String?) {
        val list = mutableListOf<ModeloExemplo>()

        jdbcTemplate.execute("""
            CREATE TABLE MODELO_EXEMPLO(id INT PRIMARY KEY AUTO_INCREMENT,
                                        o2 VARCHAR(255),
                                        o3 VARCHAR(255),
                                        o4 VARCHAR(255),
                                        o5 VARCHAR(255),
                                        o6 VARCHAR(255),
                                        o7 VARCHAR(255),
                                        o8 VARCHAR(255),
                                        o9 VARCHAR(255),
                                        o10 VARCHAR(255));
            
        """.trimIndent())

        for (i in 0..10000) {
            val modelo = ModeloExemplo(null, "TESTE+++$i", "TESTE+++$i", "TESTE+++$i", "TESTE+++$i", "TESTE+++$i", "TESTE+++$i", "TESTE+++$i", "TESTE+++$i", "TESTE+++$i")
            repository.save(modelo)
        }

        repository.saveAll(list)
    }
}

fun main(args: Array<String>) {
    runApplication<DatavsjdbcApplication>(*args)
}



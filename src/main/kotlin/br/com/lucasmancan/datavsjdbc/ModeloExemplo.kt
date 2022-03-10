package br.com.lucasmancan.datavsjdbc

import org.springframework.data.annotation.Id
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

class ModeloExemplo(
    @Id
    var id: Int?=null,
    var o2: String,

    var o3: String,

    var o4: String,

    var o5: String,

    var o6: String,

    var o7: String,

    var o8: String,

    var o9: String,

    var o10: String
) {

}

@Repository
interface ModeloExemploRepository : CrudRepository<ModeloExemplo, Int>
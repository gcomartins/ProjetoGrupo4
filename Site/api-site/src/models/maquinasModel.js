const database = require("../database/config")

function listarTodas(fkEmpresa){
    return database.executar(
        `select hostName from tbMaquinas where fkEmpresa = ${fkEmpresa} and hostName != ''`
    )
}

module.exports = {listarTodas}
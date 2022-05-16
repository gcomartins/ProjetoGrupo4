const maquinasModel = require("../models/maquinasModel.js")

function listarTodas(req, res){
    maquinasModel.listarTodas(req.params.fkEmpresa).then((resultado) => {
        if (resultado.length > 0) {
            res.status(200).json(resultado)
        }
    })
}

module.exports = {listarTodas}
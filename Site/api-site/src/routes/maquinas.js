const app = require("express") ()
const maquinasController = require("../controllers/maquinasController") 

app.get("/listar-todas/:fkEmpresa", (req, res) => {
    maquinasController.listarTodas(req,res)
})

module.exports = app
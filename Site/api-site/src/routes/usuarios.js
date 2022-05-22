var express = require("express");
var router = express.Router();

var usuarioController = require("../controllers/usuarioController");

router.get("/", function (req, res) {
    usuarioController.testar(req, res);
});

router.get("/listar", function (req, res) {
    usuarioController.listar(req, res);
});
router.get("/listarMaquina", function (req, res) {
    usuarioController.listarMaquina(req, res);
});

router.get("/buscarMaquina", function (req, res) {
    console.log('ACESSEI USUARIOS BUSCAR MAQUINA');
    usuarioController.buscarMaquina(req, res);
});

router.post("/cadastrar", function (req, res) {
    usuarioController.cadastrar(req, res);
})

router.post("/cadastrarUsuario", function (req, res) {
    usuarioController.cadastrarUsuario(req, res);
});

router.post("/deletarUsuario", function (req, res) {
    usuarioController.deletarUsuario(req, res);
});
router.post("/deletarMaquina", function (req, res) {
    usuarioController.deletarMaquina(req, res);
});

router.post("/upDateUsuario", function (req, res) {
    usuarioController.upDateUsuario(req, res);
});

router.post("/upDateMaquina", function (req, res) {
    usuarioController.upDateMaquina(req, res);
});
router.post("/cadastrarMaquina", function (req, res) {
    usuarioController.cadastrarMaquina(req, res);
});
router.post("/cadastrarComponente", function (req, res) {
    usuarioController.cadastrarComponente(req, res);
});


// router.post("/cadastrarConvite", function (req, res) {
//     usuarioController.cadastrarConvite(req, res);
// })

router.post("/autenticar", function (req, res) {
    usuarioController.entrar(req, res);
});

// router.post("/ranquear", function (req, res) {
//     usuarioController.ranquear(req, res);
// });

router.get("/graficar", function (req, res) {
    usuarioController.graficar(req, res);
});

router.post("/atualizarGrafico", function (req, res) {
    usuarioController.atualizarGrafico(req, res);
});

router.get("/gerarGraficos", function (req, res) {
    usuarioController.graficarDisco(req, res);
});

router.get("/graficarDisco", function (req, res) {
    usuarioController.graficarDisco(req, res);
});

router.get("/graficarMemoria", function (req, res) {
    usuarioController.graficarMemoria(req, res);
});

router.get("/graficarCpu", function (req, res) {
    usuarioController.graficarCpu(req, res);
});

router.get("/graficarTemp", function (req, res) {
    usuarioController.graficarTemp(req, res);
});

module.exports = router;
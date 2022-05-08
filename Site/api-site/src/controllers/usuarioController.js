var usuarioModel = require("../models/usuarioModel");

var sessoes = [];

function testar(req, res) {
    console.log("ENTRAMOS NA usuarioController");
    res.json("ESTAMOS FUNCIONANDO!");
}

function listar(req, res) {
    usuarioModel.listar()
        .then(function (resultado) {
            if (resultado.length > 0) {
                res.status(200).json(resultado);
            } else {
                res.status(204).send("Nenhum resultado encontrado!")
            }
        }).catch(
            function (erro) {
                console.log(erro);
                console.log("Houve um erro ao realizar a consulta! Erro: ", erro.sqlMessage);
                res.status(500).json(erro.sqlMessage);
            }
        );
}
function listarMaquina(req, res) {
    usuarioModel.listarMaquina()
        .then(function (resultado) {
            if (resultado.length > 0) {
                res.status(200).json(resultado);
            } else {
                res.status(204).send("Nenhum resultado encontrado!")
            }
        }).catch(
            function (erro) {
                console.log(erro);
                console.log("Houve um erro ao realizar a consulta! Erro: ", erro.sqlMessage);
                res.status(500).json(erro.sqlMessage);
            }
        );
}

function entrar(req, res) {
    var email = req.body.email;
    var senha = req.body.senha;

    if (email == undefined) {
        res.status(400).send("Seu email está undefined!");
    } else if (senha == undefined) {
        res.status(400).send("Sua senha está indefinida!");
    } else {
        usuarioModel.entrar(email, senha)
            .then(
                function (resultado) {
                    console.log(`\nResultados encontrados: ${resultado.length}`);
                    console.log(`Resultados: ${JSON.stringify(resultado)}`); // transforma JSON em String

                    if (resultado.length == 1) {
                        console.log(resultado);
                        res.json(resultado[0]);
                    } else if (resultado.length == 0) {
                        res.status(403).send("Email e/ou senha inválido(s)");
                    } else {
                        res.status(403).send("Mais de um usuário com o mesmo login e senha!");
                    }
                }
            ).catch(
                function (erro) {
                    console.log(erro);
                    console.log("\nHouve um erro ao realizar o login! Erro: ", erro.sqlMessage);
                    res.status(500).json(erro.sqlMessage);
                }
            );
    }

}

function cadastrar(req, res) {
    var nomeEmpresa = req.body.nomeEmpresa;
    var cnpj = req.body.cnpj;
    var representante = req.body.representante;
    var email = req.body.email;
    var senha = req.body.senha;

    if (nomeEmpresa == undefined) {
        res.status(400).send("Seu nome está undefined!");
    } else if (email == undefined) {
        res.status(400).send("Seu email está undefined!");
    } else if (senha == undefined) {
        res.status(400).send("Sua senha está undefined!");
    } else {
        usuarioModel.cadastrar(nomeEmpresa, cnpj, representante, email, senha)
            .then(
                function (resultado) {
                    res.json(resultado);
                }
            ).catch(
                function (erro) {
                    console.log(erro);
                    console.log(
                        "\nHouve um erro ao realizar o cadastro! Erro: ",
                        erro.sqlMessage
                    );
                    res.status(500).json(erro.sqlMessage);
                }
            );
            usuarioModel.cadastrarUsuario(nomeEmpresa, email, senha, representante)
            .then(
                function (resultado) {
                    res.json(resultado);
                }
            ).catch(
                function (erro) {
                    console.log(erro);
                    console.log(
                        "\nHouve um erro ao realizar o cadastro! Erro: ",
                        erro.sqlMessage
                    );
                    res.status(500).json(erro.sqlMessage);
                }
            );
    }
}

function cadastrarUsuario(req, res) {
    var nomeUsuario = req.body.nomeUsuario;
    var email = req.body.email;
    var senha = req.body.senha;
    var cargo = req.body.cargo;
    var idEmpresa = req.body.idEmpresa;

    if (nomeUsuario == undefined) {
        res.status(400).send("Seu nome está undefined!");
    } else if (email == undefined) {
        res.status(400).send("Seu email está undefined!");
    } else if (cargo == undefined) {
        res.status(400).send("Sua cargo está undefined!");
    } else if (senha == undefined) {
        res.status(400).send("Sua senha está undefined!");
    }else {
        usuarioModel.cadastrarFuncionario(nomeUsuario, email, senha, cargo, idEmpresa)
            .then(
                function (resultado) {
                    res.json(resultado);
                }
            ).catch(
                function (erro) {
                    console.log(erro);
                    console.log(
                        "\nHouve um erro ao realizar o cadastro! Erro: ",
                        erro.sqlMessage
                    );
                    res.status(500).json(erro.sqlMessage);
                }
            );
    }
}


function cadastrarMaquina(req, res) {
    var hostName = req.body.hostName;
    var grupo = req.body.grupo;
    var nome = req.body.nome;
    var capacidade = req.body.capacidade;
    var limiteAlerta = req.body.limiteAlerta;

        usuarioModel.cadastrarMaquina(hostName, grupo, nome, capacidade,limiteAlerta)
            .then(
                function (resultado) {
                    res.json(resultado);
                }
            ).catch(
                function (erro) {
                    console.log(erro);
                    console.log(
                        "\nHouve um erro ao realizar o cadastro! Erro: ",
                        erro.sqlMessage
                    );
                    res.status(500).json(erro.sqlMessage);
                }
            );
    
}

// function cadastrarConvite(req, res) {
//     var email = req.body.email;
//     var fkanfitriao = req.body.fkanfitriao;

//      if (email == undefined) {
//         res.status(400).send("Seu email está undefined!");
//     } else {
//         usuarioModel.cadastrarConvite(email, fkanfitriao)
//             .then(
//                 function (resultado) {
//                     res.json(resultado);
//                 }
//             ).catch(
//                 function (erro) {
//                     console.log(erro);
//                     console.log(
//                         "\nHouve um erro ao realizar o cadastro! Erro: ",
//                         erro.sqlMessage
//                     );
//                     res.status(500).json(erro.sqlMessage);
//                 }
//             );
//     }
// }


// function ranquear(req, res) {
//     var id = req.body.id;
//     var pontos = req.body.pontos;


//     usuarioModel.ranquear(id, pontos)
//         .then(
//             function (resultado) {
//                 res.json(resultado);
//             }
//         ).catch(
//             function (erro) {
//                 console.log(erro);
//                 console.log(
//                     "\nHouve um erro ao realizar o cadastro! Erro: ",
//                     erro.sqlMessage
//                 );
//                 res.status(500).json(erro.sqlMessage);
//             }
//         );

// }

// function graficar(req, res) {
    
//     usuarioModel.graficar()
//         .then(
//             function (resultado) {
//                 res.json(resultado);
//             }
//         ).catch(
//             function (erro) {
//                 console.log(erro);
//                 console.log(
//                     "\nHouve um erro ao realizar o cadastro! Erro: ",
//                     erro.sqlMessage
//                 );
//                 res.status(500).json(erro.sqlMessage);
//             }
//         );

// }

function deletarUsuario(req, res) {
    var nomeUsuario= req.body.nomeUsuario;
    var email = req.body.email;
    usuarioModel.deletarUsuario(nomeUsuario, email)
        .then(
            function (resultado) {
                res.json(resultado);
            }
        ).catch(
            function (erro) {
                console.log(erro);
                console.log(
                    "\nHouve um erro ao Deletar o usuário! Erro: ",
                    erro.sqlMessage
                );
                res.status(500).json(erro.sqlMessage);
            }
        );

}
function deletarMaquina(req, res) {
    var idMaquinaComponentes= req.body.idMaquinaComponentes;
    var nome = req.body.nome;
    usuarioModel.deletarMaquina(idMaquinaComponentes, nome)
        .then(
            function (resultado) {
                res.json(resultado);
            }
        ).catch(
            function (erro) {
                console.log(erro);
                console.log(
                    "\nHouve um erro ao Deletar o usuário! Erro: ",
                    erro.sqlMessage
                );
                res.status(500).json(erro.sqlMessage);
            }
        );

}


function upDateUsuario(req, res) {
    
    var idUsuario= req.body.idUsuario;
    var nomeUsuario= req.body.nomeUsuario;
    var sobrenomeUsuario= req.body.sobrenomeUsuario;
    var email = req.body.email;
    var senha = req.body.senha;
    var cargo= req.body.cargo;

    usuarioModel.upDateUsuario(idUsuario,nomeUsuario, sobrenomeUsuario,email,senha,cargo)
        .then(
            function (resultado) {
                res.json(resultado);
            }
        ).catch(
            function (erro) {
                console.log(erro);
                console.log(
                    "\nHouve um erro ao fazer o upDate do funcionario! Erro: ",
                    erro.sqlMessage
                );
                res.status(500).json(erro.sqlMessage);
            }
        );

}
function upDateMaquina(req, res) {
    
    var idMaquinaComponentes= req.body.idMaquinaComponentes;
    var nome= req.body.nome;
    var capacidade = req.body.capacidade;
    var limiteAlerta = req.body.limiteAlerta;

    usuarioModel.upDateMaquina(idMaquinaComponentes, nome,capacidade,limiteAlerta)
        .then(
            function (resultado) {
                res.json(resultado);
            }
        ).catch(
            function (erro) {
                console.log(erro);
                console.log(
                    "\nHouve um erro ao fazer o upDate do funcionario! Erro: ",
                    erro.sqlMessage
                );
                res.status(500).json(erro.sqlMessage);
            }
        );

}

module.exports = {
    entrar,
    cadastrar,
    listar,
    listarMaquina,
    testar,
    deletarUsuario,
    deletarMaquina,
    cadastrarUsuario,
    upDateUsuario,
    upDateMaquina,
    cadastrarMaquina,
    // ranquear,
    // cadastrarConvite,
    // graficar,
}
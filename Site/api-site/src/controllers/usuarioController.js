var usuarioModel = require("../models/usuarioModel");

var sessoes = [];

function testar(req, res) {
    console.log("ENTRAMOS NA usuarioController");
    res.json("ESTAMOS FUNCIONANDO!");
}

function listar(req, res) {
    usuarioModel.listar(req.params.fkEmpresa)
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

function listarAlerta(req, res) {
    usuarioModel.listarAlerta(req.params.fkEmpresa)
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

function buscarMaquina(req, res) {
    console.log('ACESSEI CONTROLLERS BUSCAR MAQUINA');
    usuarioModel.buscarMaquina()
        .then(function (resultado) {
            debugger
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
    usuarioModel.listarMaquina(req.params.fkEmpresa)
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
    var identPessoal = req.body.identPessoal;
    var idEmpresa = req.body.idEmpresa;

        usuarioModel.cadastrarMaquina(identPessoal, hostName, grupo, idEmpresa)
            .then(
                function (resultado) {
                    res.json(resultado);
                    console.log(resultado.insertId);
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

function cadastrarComponente(req, res) {
    var ram = req.body.comp1;
    var cpu = req.body.comp2;
    var disco = req.body.comp3;
    var limiteAlertaRam = req.body.limiteAlertaRam;
    var limiteAlertaCpu = req.body.limiteAlertaCpu;
    var limiteAlertaDisco = req.body.limiteAlertaDisco;
    var capacidadeRam = req.body.capacidadeRam;
    var capacidadeCpu = req.body.capacidadeCpu;
    var capacidadeDisco = req.body.capacidadeDisco;
    var fkMaquina = req.body.fkMaquina;
    
    var nome;
    var capacidade;
    var limiteAlerta;

    nome = ram;
    capacidade = capacidadeRam;
    limiteAlerta = limiteAlertaRam;
    
        usuarioModel.cadastrarComponente(nome, capacidade, limiteAlerta, 34)
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

            nome = cpu;
    capacidade = capacidadeCpu;
    limiteAlerta = limiteAlertaCpu;
    
        usuarioModel.cadastrarComponente(nome, capacidade, limiteAlerta, 34)
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

            nome = disco;
    capacidade = capacidadeDisco;
    limiteAlerta = limiteAlertaDisco;
    
        usuarioModel.cadastrarComponente(nome, capacidade, limiteAlerta, 34)
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

// function graficar(req, res){


//     fetch(`/usuarios/graficar`, { cache: 'no-store' }).then(function (response) {
//         if (response.ok) {
//             response.json().then(function (resposta) {
//                 console.log(`Dados recebidos: ${JSON.stringify(resposta)}`);
                
//                 for (let i = 0; i < resposta.length; i++) {
                    
//                     dados.push(resposta[i].leituraDesempenho);
//                     datas.push(resposta[i].dataHora);
//                 }
//                 // resposta.reverse();

//                 plotarGrafico();
//             });
//         } else {
//             console.error('Nenhum dado encontrado ou erro na API');
//         }
//     })
//         .catch(function (error) {
//             console.error(`Erro na obtenção dos dados p/ gráfico: ${error.message}`);
//         });

// }
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

function graficar(req, res) {
    
    usuarioModel.graficar()
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

function atualizarGrafico(req, res) {
    var hostname = req.body.hostname;

    usuarioModel.atualizarGrafico(hostname)
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

function graficarDisco(req, res) {
    
    usuarioModel.graficarDisco()
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

function graficarMemoria(req, res) {
    
    usuarioModel.graficarMemoria()
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

function graficarCpu(req, res) {
    
    usuarioModel.graficarCpu()
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

function graficarTemp(req, res) {
    
    usuarioModel.graficarTemp()
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

function deletarUsuario(req, res) {
    var idUsuario = req.body.idUsuario;
    usuarioModel.deletarUsuario(idUsuario)
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
    var idComponentes= req.body.idComponentes;
    usuarioModel.deletarMaquina(idComponentes,)
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
    
    
    var nomeUsuario= req.body.nomeUsuario;
    var email = req.body.email;
    var senha = req.body.senha;
    var cargo= req.body.cargo;
    var idUsuario= req.body.idUsuario;

    usuarioModel.upDateUsuario(nomeUsuario,email,senha,cargo,idUsuario)
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
    
    var idComponentes= req.body.idComponentes;
    var limiteAlerta = req.body.limiteAlerta;

    usuarioModel.upDateMaquina(idComponentes, limiteAlerta)
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
    listarAlerta,
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
    graficar,
    graficarDisco,
    graficarMemoria,
    graficarCpu,
    graficarTemp,
    cadastrarComponente,
    buscarMaquina,
    atualizarGrafico
}
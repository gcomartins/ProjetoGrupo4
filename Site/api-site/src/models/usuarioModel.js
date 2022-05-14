var database = require("../database/config")

function listarMaquina() {
    console.log("ACESSEI O USUARIO MODEL \n \n\t\t >> Se aqui der erro de 'Error: connect ECONNREFUSED',\n \t\t >> verifique suas credenciais de acesso ao banco\n \t\t >> e se o servidor de seu BD está rodando corretamente. \n\n function listarMaquina()");
    var instrucao = `
         SELECT * FROM tbMaquinasComponentes;
         
    `;
    console.log("Executando a instrução SQL: \n" + instrucao);
    return database.executar(instrucao);
}

function listar() {
    console.log("ACESSEI O USUARIO MODEL \n \n\t\t >> Se aqui der erro de 'Error: connect ECONNREFUSED',\n \t\t >> verifique suas credenciais de acesso ao banco\n \t\t >> e se o servidor de seu BD está rodando corretamente. \n\n function listar()");
    var instrucao = `
         SELECT * FROM tbUsuarios;
    `;
    console.log("Executando a instrução SQL: \n" + instrucao);
    return database.executar(instrucao);
}

function entrar(email, senha) {
    console.log("ACESSEI O USUARIO MODEL \n \n\t\t >> Se aqui der erro de 'Error: connect ECONNREFUSED',\n \t\t >> verifique suas credenciais de acesso ao banco\n \t\t >> e se o servidor de seu BD está rodando corretamente. \n\n function entrar(): ", email, senha)
    var instrucao = `
        SELECT * FROM tbUsuarios WHERE email = '${email}' AND senha = '${senha}';
    `;
    console.log("Executando a instrução SQL: \n" + instrucao);
    return database.executar(instrucao);
}

function deletarUsuario(idUsuario) {
    console.log("ACESSEI O USUARIO MODEL \n \n\t\t >> Se aqui der erro de 'Error: connect ECONNREFUSED',\n \t\t >> verifique suas credenciais de acesso ao banco\n \t\t >> e se o servidor de seu BD está rodando corretamente. \n\n function deletarUsuario(): ", idUsuario)
    var instrucao = `
    DELETE FROM tbUsuarios WHERE idUsuario = '${idUsuario}' ;
    `;
    console.log("Executando a instrução SQL: \n" + instrucao);
    return database.executar(instrucao);
}


function deletarMaquina(idMaquinaComponentes,nome) {
    console.log("ACESSEI O USUARIO MODEL \n \n\t\t >> Se aqui der erro de 'Error: connect ECONNREFUSED',\n \t\t >> verifique suas credenciais de acesso ao banco\n \t\t >> e se o servidor de seu BD está rodando corretamente. \n\n function deletarMaquina(): ", idMaquinaComponentes,nome)
    var instrucao = `
    DELETE FROM tbMaquinasComponentes WHERE idMaquinaComponentes = '${idMaquinaComponentes}' AND nome = '${nome}';
    `;
    console.log("Executando a instrução SQL: \n" + instrucao);
    return database.executar(instrucao);
}

function upDateUsuario(idUsuario,nomeUsuario, sobrenomeUsuario,email,senha,cargo) {
    console.log("ACESSEI O USUARIO MODEL \n \n\t\t >> Se aqui der erro de 'Error: connect ECONNREFUSED',\n \t\t >> verifique suas credenciais de acesso ao banco\n \t\t >> e se o servidor de seu BD está rodando corretamente. \n\n function upDateUsuario(): ",idUsuario,nomeUsuario, sobrenomeUsuario,email,senha,cargo)
    var instrucao = `
    UPDATE tbUsuarios SET nomeUsuario = '${nomeUsuario}', sobrenomeUsuario = '${sobrenomeUsuario}', cargo = '${cargo}', email = '${email}',senha = '${senha}' WHERE idUsuario = ${idUsuario}; `
    ;
    console.log("Executando a instrução SQL: \n" + instrucao);
    return database.executar(instrucao);
}

function upDateMaquina(idMaquinaComponentes,nome, capacidade,limiteAlerta) {
    console.log("ACESSEI O USUARIO MODEL \n \n\t\t >> Se aqui der erro de 'Error: connect ECONNREFUSED',\n \t\t >> verifique suas credenciais de acesso ao banco\n \t\t >> e se o servidor de seu BD está rodando corretamente. \n\n function upDateUsuario(): ",idMaquinaComponentes,nome, capacidade,limiteAlerta)
    var instrucao = `
    UPDATE tbMaquinasComponentes SET nome = '${nome}', capacidade = '${capacidade}', limiteAlerta = '${limiteAlerta}' WHERE idMaquinaComponentes = ${idMaquinaComponentes}; `
    ;
    console.log("Executando a instrução SQL: \n" + instrucao);
    return database.executar(instrucao);
}



function cadastrar(nomeEmpresa, cnpj, representante, email, senha) {
    console.log("ACESSEI O USUARIO MODEL \n \n\t\t >> Se aqui der erro de 'Error: connect ECONNREFUSED',\n \t\t >> verifique suas credenciais de acesso ao banco\n \t\t >> e se o servidor de seu BD está rodando corretamente. \n\n function cadastrar():", nomeEmpresa, cnpj, representante, email, senha);
    var instrucao = `
        INSERT INTO tbEmpresas (nomeEmpresa, cnpj, representante, email, senha) VALUES ('${nomeEmpresa}', '${cnpj}', '${representante}', '${email}', '${senha}');
    `;
    console.log("Executando a instrução SQL: \n" + instrucao);
    return database.executar(instrucao);
}



function cadastrarUsuario(nomeEmpresa, email, senha, nomeUsuario) {
    console.log("ACESSEI O USUARIO MODEL \n \n\t\t >> Se aqui der erro de 'Error: connect ECONNREFUSED',\n \t\t >> verifique suas credenciais de acesso ao banco\n \t\t >> e se o servidor de seu BD está rodando corretamente. \n\n function cadastrarUsuario():", nomeEmpresa, email, senha, nomeUsuario);
    var instrucao = `
    INSERT INTO tbUsuarios (nomeUsuario, cargo,  email, senha, fkEmpresa) 
    (select '${nomeUsuario}', 'Gerente', '${email}', '${senha}', idempresa
    from tbEmpresas where nomeEmpresa =  '${nomeEmpresa}');
    `;
    console.log("Executando a instrução SQL: \n" + instrucao);
    return database.executar(instrucao);
}

function cadastrarFuncionario(nomeUsuario, email, senha, cargo, idEmpresa) {
    console.log("ACESSEI O USUARIO MODEL \n \n\t\t >> Se aqui der erro de 'Error: connect ECONNREFUSED',\n \t\t >> verifique suas credenciais de acesso ao banco\n \t\t >> e se o servidor de seu BD está rodando corretamente. \n\n function cadastrarUsuario():", nomeUsuario, email, senha, cargo, idEmpresa);
    var instrucao = `
    INSERT INTO tbUsuarios (nomeUsuario, cargo,  email, senha, fkEmpresa) 
    (select '${nomeUsuario}', '${cargo}', '${email}', '${senha}', '${idEmpresa}');
    `;
    console.log("Executando a instrução SQL: \n" + instrucao);
    return database.executar(instrucao);
}

function cadastrarMaquina(hostName, grupo, nome, capacidade,limiteAlerta, idEmpresa) {
    console.log("ACESSEI O USUARIO MODEL \n \n\t\t >> Se aqui der erro de 'Error: connect ECONNREFUSED',\n \t\t >> verifique suas credenciais de acesso ao banco\n \t\t >> e se o servidor de seu BD está rodando corretamente. \n\n function cadastrarMaquina():", hostName, grupo, nome, capacidade,limiteAlerta, idEmpresa);
    var instrucao = `
        INSERT INTO tbMaquinasComponentes (hostName, grupo, nome, capacidade,limiteAlerta) VALUES ('${hostName}', '${grupo}', '${nome}', '${capacidade}', '${limiteAlerta}', '${idEmpresa}');
    `;
    console.log("Executando a instrução SQL: \n" + instrucao);
    return database.executar(instrucao);
}

// function cadastrarConvite(email, fkanfitriao) {
//     console.log("ACESSEI O USUARIO MODEL \n \n\t\t >> Se aqui der erro de 'Error: connect ECONNREFUSED',\n \t\t >> verifique suas credenciais de acesso ao banco\n \t\t >> e se o servidor de seu BD está rodando corretamente. \n\n function cadastrar():", email, fkanfitriao);
//     var instrucao = `
//         INSERT INTO usuario (email, fkanfitriao) VALUES ('${email}', ${fkanfitriao});
//     `;
//     console.log("Executando a instrução SQL: \n" + instrucao);
//     return database.executar(instrucao);
// }

// function ranquear(id, pontos) {
//     console.log("ACESSEI O USUARIO MODEL \n \n\t\t >> Se aqui der erro de 'Error: connect ECONNREFUSED',\n \t\t >> verifique suas credenciais de acesso ao banco\n \t\t >> e se o servidor de seu BD está rodando corretamente. \n\n function ranquear():", id, pontos);
//     var instrucao = `
//         INSERT INTO Ranking (fkusuario, pontos) VALUES ('${id}', '${pontos}');
//     `;
//     console.log("Executando a instrução SQL: \n" + instrucao);
//     return database.executar(instrucao);
// }

function graficar() {
    console.log("ACESSEI O USUARIO MODEL \n \n\t\t >> Se aqui der erro de 'Error: connect ECONNREFUSED',\n \t\t >> verifique suas credenciais de acesso ao banco\n \t\t >> e se o servidor de seu BD está rodando corretamente. \n\n function graficar():",);
    var instrucao = `
        select TOP 10 * from tbLogs join [dbo].[tbComponentes] on (fkComponente = idComponentes) where idComponentes = 9 order by idLog desc;
    `;
    console.log("Executando a instrução SQL: \n" + instrucao);
    return database.executar(instrucao);
}

function graficarDisco() {
    console.log("ACESSEI O USUARIO MODEL \n \n\t\t >> Se aqui der erro de 'Error: connect ECONNREFUSED',\n \t\t >> verifique suas credenciais de acesso ao banco\n \t\t >> e se o servidor de seu BD está rodando corretamente. \n\n function graficar():",);
    var instrucao = `
        select TOP 10 * from tbLogs join [dbo].[tbComponentes] on (fkComponente = idComponentes) where idComponentes = 9 order by idLog desc;
    `;
    console.log("Executando a instrução SQL: \n" + instrucao);
    return database.executar(instrucao);
}

function graficarMemoria() {
    console.log("ACESSEI O USUARIO MODEL \n \n\t\t >> Se aqui der erro de 'Error: connect ECONNREFUSED',\n \t\t >> verifique suas credenciais de acesso ao banco\n \t\t >> e se o servidor de seu BD está rodando corretamente. \n\n function graficar():",);
    var instrucao = `
        select TOP 10 * from tbLogs join [dbo].[tbComponentes] on (fkComponente = idComponentes) where idComponentes = 10 order by idLog desc;
    `;
    console.log("Executando a instrução SQL: \n" + instrucao);
    return database.executar(instrucao);
}

function graficarCpu() {
    console.log("ACESSEI O USUARIO MODEL \n \n\t\t >> Se aqui der erro de 'Error: connect ECONNREFUSED',\n \t\t >> verifique suas credenciais de acesso ao banco\n \t\t >> e se o servidor de seu BD está rodando corretamente. \n\n function graficar():",);
    var instrucao = `
        select TOP 10 * from tbLogs join [dbo].[tbComponentes] on (fkComponente = idComponentes) where idComponentes = 11 order by idLog desc;
    `;
    console.log("Executando a instrução SQL: \n" + instrucao);
    return database.executar(instrucao);
}

module.exports = {
    entrar,
    cadastrar,
    listar,
    listarMaquina,
    deletarUsuario,
    deletarMaquina,
    cadastrarUsuario,
    upDateUsuario,
    upDateMaquina,
    cadastrarMaquina,
    cadastrarFuncionario,
    // ranquear,
    // cadastrarConvite,
    graficar,
    graficarDisco,
    graficarMemoria,
    graficarCpu,
};
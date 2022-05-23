var database = require("../database/config")

function listarMaquina() {
    console.log("ACESSEI O USUARIO MODEL \n \n\t\t >> Se aqui der erro de 'Error: connect ECONNREFUSED',\n \t\t >> verifique suas credenciais de acesso ao banco\n \t\t >> e se o servidor de seu BD está rodando corretamente. \n\n function listarMaquina()");
    var instrucao = `
         SELECT * FROM tbMaquinas;
         
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

function upDateUsuario(nomeUsuario,email,senha,cargo,idUsuario) {
    console.log("ACESSEI O USUARIO MODEL \n \n\t\t >> Se aqui der erro de 'Error: connect ECONNREFUSED',\n \t\t >> verifique suas credenciais de acesso ao banco\n \t\t >> e se o servidor de seu BD está rodando corretamente. \n\n function upDateUsuario(): ",nomeUsuario,email,senha,cargo,idUsuario)
    var instrucao = `
    UPDATE tbUsuarios SET nomeUsuario = '${nomeUsuario}', cargo = '${cargo}', email = '${email}',senha = '${senha}' WHERE idUsuario = ${idUsuario}; `
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

function cadastrarMaquina(identPessoal, hostName, grupo, idEmpresa) {
    console.log("ACESSEI O USUARIO MODEL \n \n\t\t >> Se aqui der erro de 'Error: connect ECONNREFUSED',\n \t\t >> verifique suas credenciais de acesso ao banco\n \t\t >> e se o servidor de seu BD está rodando corretamente. \n\n function cadastrarMaquina():", hostName, identPessoal, grupo, idEmpresa);
    var instrucao = `
        INSERT INTO tbMaquinas (identPessoal, hostName, grupo, fkEmpresa) VALUES ('${identPessoal}', '${hostName}', '${grupo}', ${idEmpresa});
    `;
    console.log("Executando a instrução SQL: \n" + instrucao);
    return database.executar(instrucao);
}

function buscarMaquina() {
    console.log("ACESSEI O USUARIO MODEL \n \n\t\t >> Se aqui der erro de 'Error: connect ECONNREFUSED',\n \t\t >> verifique suas credenciais de acesso ao banco\n \t\t >> e se o servidor de seu BD está rodando corretamente. \n\n function cadastrarMaquina():", hostName, identPessoal, grupo, idEmpresa);
    var instrucao = `
        SELECT TOP 1 idMaquina FROM [dbo].[tbMaquinas] ORDER BY IdMaquina DESC;
    `;
    console.log("Executando a instrução SQL: \n" + instrucao);
    return database.executar(instrucao);
}

function cadastrarComponente(nome, capacidade, limiteAlerta, fkMaquina) {
    console.log("ACESSEI O USUARIO MODEL \n \n\t\t >> Se aqui der erro de 'Error: connect ECONNREFUSED',\n \t\t >> verifique suas credenciais de acesso ao banco\n \t\t >> e se o servidor de seu BD está rodando corretamente. \n\n function cadastrarMaquina():", nome, capacidade, limiteAlerta, fkMaquina);
    var instrucao = `
        INSERT INTO tbComponentes (nome, capacidade, limiteAlerta, fkMaquina) VALUES ('${nome}', ${capacidade}, ${limiteAlerta}, ${fkMaquina});
    `;
    console.log("Executando a instrução SQL: \n" + instrucao);
    return database.executar(instrucao);
}

function graficar() {
    console.log("ACESSEI O USUARIO MODEL \n \n\t\t >> Se aqui der erro de 'Error: connect ECONNREFUSED',\n \t\t >> verifique suas credenciais de acesso ao banco\n \t\t >> e se o servidor de seu BD está rodando corretamente. \n\n function graficar():",);
    var instrucao = `
        select TOP 10 * from tbLogs join [dbo].[tbComponentes] on (fkComponente = idComponentes) where idComponentes = 9 order by idLog desc;
    `;
    console.log("Executando a instrução SQL: \n" + instrucao);
    return database.executar(instrucao);
}

function atualizarGrafico(hostname) {
    console.log("ACESSEI O USUARIO MODEL \n \n\t\t >> Se aqui der erro de 'Error: connect ECONNREFUSED',\n \t\t >> verifique suas credenciais de acesso ao banco\n \t\t >> e se o servidor de seu BD está rodando corretamente. \n\n function cadastrarMaquina():", hostname);
    var instrucao = `
    select top 21 logs.idLog, components.idComponentes, components.nome, maquinas.hostName, logs.leituraDesempenho, logs.leituraTemperatura, logs.dataHora
    from [dbo].[tbLogs] as logs
    join [dbo].[tbComponentes] as components on logs.fkComponente = components.idComponentes
    join [dbo].[tbMaquinas] as maquinas on  maquinas.idMaquina = components.fkMaquina 
    where maquinas.hostName = '${hostname}'
    order by logs.idLog desc;
    `;
    console.log("Executando a instrução SQL: \n" + instrucao);
    return database.executar(instrucao);
}

function graficarDisco() {
    console.log("ACESSEI O USUARIO MODEL \n \n\t\t >> Se aqui der erro de 'Error: connect ECONNREFUSED',\n \t\t >> verifique suas credenciais de acesso ao banco\n \t\t >> e se o servidor de seu BD está rodando corretamente. \n\n function graficar():",);
    var instrucao = `
        select TOP 6 * from tbLogs join [dbo].[tbComponentes] on (fkComponente = idComponentes) where idComponentes = 9 order by idLog desc;
    `;
    console.log("Executando a instrução SQL: \n" + instrucao);
    return database.executar(instrucao);
}

function graficarMemoria() {
    console.log("ACESSEI O USUARIO MODEL \n \n\t\t >> Se aqui der erro de 'Error: connect ECONNREFUSED',\n \t\t >> verifique suas credenciais de acesso ao banco\n \t\t >> e se o servidor de seu BD está rodando corretamente. \n\n function graficar():",);
    var instrucao = `
        select TOP 6 * from tbLogs join [dbo].[tbComponentes] on (fkComponente = idComponentes) where idComponentes = 10 order by idLog desc;
    `;
    console.log("Executando a instrução SQL: \n" + instrucao);
    return database.executar(instrucao);
}

function graficarCpu() {
    console.log("ACESSEI O USUARIO MODEL \n \n\t\t >> Se aqui der erro de 'Error: connect ECONNREFUSED',\n \t\t >> verifique suas credenciais de acesso ao banco\n \t\t >> e se o servidor de seu BD está rodando corretamente. \n\n function graficar():",);
    var instrucao = `
        select TOP 6 * from tbLogs join [dbo].[tbComponentes] on (fkComponente = idComponentes) where idComponentes = 11 order by idLog desc;
    `;
    console.log("Executando a instrução SQL: \n" + instrucao);
    return database.executar(instrucao);
}

function graficarTemp() {
    console.log("ACESSEI O USUARIO MODEL \n \n\t\t >> Se aqui der erro de 'Error: connect ECONNREFUSED',\n \t\t >> verifique suas credenciais de acesso ao banco\n \t\t >> e se o servidor de seu BD está rodando corretamente. \n\n function graficar():",);
    var instrucao = `
        select TOP 6 * from tbLogs join [dbo].[tbComponentes] on (fkComponente = idComponentes) where idComponentes = 11 order by idLog desc;
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
    graficarTemp,
    cadastrarComponente,
    buscarMaquina,
    atualizarGrafico
};
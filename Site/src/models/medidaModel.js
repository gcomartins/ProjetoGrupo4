var database = require("../database/config");

function buscarUltimasMedidas(hostname, limite_linhas) {

    instrucaoSql = ''

    if (process.env.AMBIENTE_PROCESSO == "producao") {
        instrucaoSql = `
        select top ${limite_linhas} logs.idLog, components.idComponentes, components.nome, maquinas.hostName,
        logs.leituraDesempenho, logs.leituraTemperatura, convert(varchar, logs.dataHora, 108) as dataHora
    from [dbo].[tbLogs] as logs
    join [dbo].[tbComponentes] as components on logs.fkComponente = components.idComponentes
    join [dbo].[tbMaquinas] as maquinas on  maquinas.idMaquina = components.fkMaquina 
    where maquinas.hostName = '${hostname}'
    order by logs.idLog desc;
                    `;
    } else if (process.env.AMBIENTE_PROCESSO == "desenvolvimento") {
        instrucaoSql = `select 
        dht11_temperatura as temperatura, 
        dht11_umidade as umidade,
                        momento,
                        DATE_FORMAT(momento,'%H:%i:%s') as momento_grafico
                    from medida
                    where fk_aquario = ${hostname}
                    order by id desc limit ${limite_linhas}`;
    } else {
        console.log("\nO AMBIENTE (produção OU desenvolvimento) NÃO FOI DEFINIDO EM app.js\n");
        return
    }

    console.log("Executando a instrução SQL: \n" + instrucaoSql);
    return database.executar(instrucaoSql);
}

function buscarMedidasEmTempoReal(hostname) {

    instrucaoSql = ''

    if (process.env.AMBIENTE_PROCESSO == "producao") {
        instrucaoSql = `
        select top 3 logs.idLog, components.idComponentes, components.nome, maquinas.hostName,
        logs.leituraDesempenho, logs.leituraTemperatura, convert(varchar, logs.dataHora, 108) as dataHora
    from [dbo].[tbLogs] as logs
    join [dbo].[tbComponentes] as components on logs.fkComponente = components.idComponentes
    join [dbo].[tbMaquinas] as maquinas on  maquinas.idMaquina = components.fkMaquina 
    where maquinas.hostName = '${hostname}'
    order by logs.idLog desc;
                    `;

    } else if (process.env.AMBIENTE_PROCESSO == "desenvolvimento") {
        instrucaoSql = `select 
        dht11_temperatura as temperatura, 
        dht11_umidade as umidade,
                        DATE_FORMAT(momento,'%H:%i:%s') as momento_grafico, 
                        fk_aquario 
                        from medida where fk_aquario = ${hostname} 
                    order by id desc limit 1`;
    } else {
        console.log("\nO AMBIENTE (produção OU desenvolvimento) NÃO FOI DEFINIDO EM app.js\n");
        return
    }

    console.log("Executando a instrução SQL: \n" + instrucaoSql);
    return database.executar(instrucaoSql);
}


module.exports = {
    buscarUltimasMedidas,
    buscarMedidasEmTempoReal
}

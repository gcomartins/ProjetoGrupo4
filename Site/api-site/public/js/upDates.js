function upDateUsuario() {


    var formulario = new URLSearchParams(new FormData(document.getElementById("form_upDateUsuario")));
    
    var idUsuario = formulario.get("idUsuario");
    var nomeUsuario = formulario.get("nomeUsuario");
    var sobrenomeUsuario = formulario.get("sobrenomeUsuario");
    var cargo = formulario.get("cargo");
    var email = formulario.get("email");
    var senha = formulario.get("senha");       
    
    
    
    // TODO: VERIFICAR AS VALIDAÇÕES QUE ELES ESTÃO APRENDENDO EM ALGORITMOS 
    if (idUsuario == "" || nomeUsuario == "" || sobrenomeUsuario == ""|| cargo == "" || email == "" || senha == "") {
    
        window.alert("Preencha todos os campos para prosseguir!");
        if (idUsuario == "") {
            console.log('id está em branco')
        }
        if (nomeUsuario == "") {
            console.log('nome está em branco')
        }
        if (sobrenomeUsuario == "") {
            console.log('nome está em branco')
        }
        if (cargo == "") {
            console.log('email está em branco')
        }
        if (senha == "") {
            console.log('senha está em branco')
        }
        return false;
    }
    
    if (email.indexOf("@") == -1 || email.indexOf(".com") == -1) {
        window.alert("Ops, e-mail inválido! Verifique e tente novamente.");
        return false;
    }
    
    fetch("/usuarios/upDateUsuario", {
        method: "POST",
        body: formulario
    }).then(function (resposta) {
    
        console.log("resposta: ", resposta);
    
        if (resposta.ok) {
            window.alert("upDate realizado com sucesso!");
        } else {
            throw ("Houve um erro ao tentar realizar o upDate!");
        }
    }).catch(function (resposta) {
        console.log(`#ERRO: ${resposta}`);
    });
    
    return false;
    }


function upDateMaquina() {


        var formulario = new URLSearchParams(new FormData(document.getElementById("form_upDateUsuario")));
        
        var idMaquinaComponentes = formulario.get("idMaquinaComponentes");
        var nome = formulario.get("nome");
        var capacidade = formulario.get("capacidade");
        var limiteAlerta = formulario.get("limiteAlerta");
        
        
        
        // TODO: VERIFICAR AS VALIDAÇÕES QUE ELES ESTÃO APRENDENDO EM ALGORITMOS 
        if (hostName == "" || grupo == "" || nome == "" || capacidade == "" || limiteAlerta == "" ) {
        
        window.alert("Preencha todos os campos para prosseguir!");
            if (hostName == "" ) {
                console.log("hostName está em branco!");
            }
            if (nome == "") {
                console.log("nome está em branco!");
            }
            if (capacidade == "") {
                console.log('capacidade está em branco')
            }
            if (limiteAlerta == "" || grupo == "" ) {
                console.log("limiteAlerta está em branco!");
            }
            
                return false;
            }
        
        fetch("/usuarios/upDateMaquina", {
            method: "POST",
            body: formulario
        }).then(function (resposta) {
        
            console.log("resposta: ", resposta);
        
            if (resposta.ok) {
                window.alert("upDate realizado com sucesso!");
            } else {
                throw ("Houve um erro ao tentar realizar o upDate!");
            }
        }).catch(function (resposta) {
            console.log(`#ERRO: ${resposta}`);
        });
        
        return false;
    }
        
         
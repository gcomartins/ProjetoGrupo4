function deletarUsuario(idUsuarioVar) {
    
    var result = confirm('Deseja Deletar esse usuário?');
    if(result == true){
 
    fetch("/usuarios/deletarUsuario", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            idUsuario: idUsuarioVar,
        })
    }).then(function (resposta) {
        console.log(resposta.body);
        console.log("ESTOU NO THEN DO deletarUsuario()!")
    
        if (resposta.ok) {
            console.log(resposta);
    
            resposta.json().then(json => {
                console.log(json);
                console.log(JSON.stringify(json));
    
                sessionStorage.EMAIL_USUARIO = json.email;
                sessionStorage.NOME_USUARIO = json.Nome;
                sessionStorage.ID_USUARIO = json.idUsuario;
                window.alert("Delete realizado com sucesso!");
    
            });
    
        } else {
    
            console.log("Houve um erro ao tentar deletar usuário!");
    
            resposta.text().then(texto => {
                console.error(texto);
            });
        }
    
    }).catch(function (erro) {
        console.log(erro);
    })
    return false;
    }

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
        

    
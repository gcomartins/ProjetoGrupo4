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
            listar();
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


    
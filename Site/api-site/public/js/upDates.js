function formularioUpDate(){
    div_formulario_upDate.innerHTML = `
					<form action="" id="form_upDateUsuario" method="post" onsubmit="return upDateUsuario()">
						<label  for="">Nome</label>
						<input name="nomeUsuario" type="text"  maxlength="15">
						<label for="">Permissão</label>
						<select name="cargo" id="cargo"  maxlength="45">
							<option value="Técnico de Infraestrutura">Técnico de Infraestrutura</option>
							<option value="Gerente de Infraestrutura">Gerente de Infraestrutura</option>
							<option value="Gerente Bancário">Gerente Bancário</option>
							<option value="Bancário">Bancário</option>
						</select> 
						<label for="">Email</label>
						<input name="email" id="email" type="email"  maxlength="45">
						<label for="">Senha</label>
						<input name="senha" id="senha" type="password"  maxlength="45">
						<div class="space-btn">
						<button class="btn"onclick="upDateUsuario(idUsuarioVar)"><h3><a>Editar</a></h3></button>
						</div>
					</form>	
    `
}




function upDateUsuario(idUsuarioVar) {


    var formulario = new URLSearchParams(new FormData(document.getElementById("form_upDateUsuario")));
    

    var nomeUsuario = formulario.get("nomeUsuario");
    var cargo = formulario.get("cargo");
    var email = formulario.get("email");
    var senha = formulario.get("senha");       
    
    
    
    // TODO: VERIFICAR AS VALIDAÇÕES QUE ELES ESTÃO APRENDENDO EM ALGORITMOS 
    if (nomeUsuario == "" ||  cargo == "" || email == "" || senha == "") {
    
        window.alert("Preencha todos os campos para prosseguir!");

        if (nomeUsuario == "") {
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
        headers: {
            "Content-Type": "application/json"
        },
        body: 
        JSON.stringify({
            idUsuario: idUsuarioVar,
        }),formulario
    }).then(function (resposta) {
    
        console.log("resposta: ", resposta);
    
        if (resposta.ok) {
            window.alert("upDate realizado com sucesso!");
            div_formulario_upDate.style.display = "none";
            listar();
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
        
         
function formularioUpDate(){
    div_formulario_upDate.innerHTML = `
	<div class="box-informacoes-cadastradas">	
    <div class = "subscribe-right">			
    <form  action="" id="form_upDateUsuario" method="post" onsubmit="return upDateUsuario()">
                        <label class="inp_up" for="">ID</label> 
                        <input name="idUsuario" type="text"  maxlength="15">
                        <label class="inp_up" for="">Nome</label>
						<input name="nomeUsuario" type="text"  maxlength="15">
						<label class="inp_up" for="">Permissão</label>
						<select name="cargo" id="cargo"  maxlength="45">
							<option value="Técnico de Infraestrutura">Técnico de Infraestrutura</option>
							<option value="Gerente de Infraestrutura">Gerente de Infraestrutura</option>
							<option value="Gerente Bancário">Gerente Bancário</option>
							<option value="Bancário">Bancário</option>
						</select> 
						<label class="inp_up" for="">Email</label>
						<input name="email" id="email" type="email"  maxlength="45">
						<label class="inp_up" for="">Senha</label>
						<input name="senha" id="senha" type="password"  maxlength="45">
						<div class="space-btn_up">
							<button class="btn_up"><h3><a>Editar</a></h3></button>
							</div>
					</form>	
                    </div>
                    </div>
    `
}

function formularioUpDateMaquina(){
    div_formulario_upDateMaquina.innerHTML = `
	<div class="box-informacoes-cadastradas">	
    <div class = "subscribe-right">			
    <form action="" id="form_upDateMaquina" method="post" onsubmit="return upDateMaquina()">
                          <label class="inp_up" for="">ID</label> 
                          <input id="idComponentes" name="idComponentes" type="text"  maxlength="15">
						  <label class="inp_up" for="">Limite Alerta</label>
						  <select name="limiteAlerta" id="limiteAlerta" type="text" required maxlength="15">
							  <option value="50">50%</option>
							  <option value="60">60%</option>
							  <option value="70">70%</option>
							  <option value="80">80%</option>
							  <option value="90">90%</option>
							  <option value="100">100%</option>
						  </select>
						  <div class="space-btn_up">
							<button class="btn_up"><h3><a>Editar</a></h3></button>
							</div>
					  </form>
                    </div>
                    </div>
    `
}





function upDateUsuario() {


    var formulario = new URLSearchParams(new FormData(document.getElementById("form_upDateUsuario")));
    
    var idUsuario = formulario.get("idUsuario");
    var nomeUsuario = formulario.get("nomeUsuario");
    var cargo = formulario.get("cargo");
    var email = formulario.get("email");
    var senha = formulario.get("senha");       
    
    
    
    // TODO: VERIFICAR AS VALIDAÇÕES QUE ELES ESTÃO APRENDENDO EM ALGORITMOS 
    if (idUsuario == "" ||nomeUsuario == "" ||  cargo == "" || email == "" || senha == "") {
    
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
        body: formulario
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

        var formulario = new URLSearchParams(new FormData(document.getElementById("form_upDateMaquina")));
        var idComponentes = formulario.get("idComponentes");
        var limiteAlerta = formulario.get("limiteAlerta");

        // TODO: VERIFICAR AS VALIDAÇÕES QUE ELES ESTÃO APRENDENDO EM ALGORITMOS 
        if (idComponentes=""|| limiteAlerta == "" ) {
        
        window.alert("Preencha todos os campos para prosseguir!");
            if (idComponentes == "" ) {
                console.log("ID está em branco!");
            }
            if (limiteAlerta == "" || grupo == "" ) {
                console.log("limiteAlerta está em branco!");
            }
            
                return false;
            }
        
        fetch("/usuarios/upDateMaquina", {
            method: "POST",
            body: formulario,
        }).then(function (resposta) {
        
            console.log("resposta: ", resposta);
        
            if (resposta.ok) {
                window.alert("upDate realizado com sucesso!");
                div_formulario_upDateMaquina.style.display = "none";
            listarMaquina();
            } else {
                throw ("Houve um erro ao tentar realizar o upDate!");
            }
        }).catch(function (resposta) {
            console.log(`#ERRO: ${resposta}`);
        });
        
        return false;
    }
        
         
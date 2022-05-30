
function listar(){
  for( i=0 ;i<1;i++){
    fetch(`/usuarios/listar/${sessionStorage.ID_EMPRESA}`, {
        method: "GET",
    }).then(function (resposta) {
    
        // console.log("resposta: ", resposta);
        resposta.json().then((json) => {
            var obj = (json);
            console.log(obj)
            for(var i = 0; i < 1; i++) {
                lista.innerHTML = `   `;
            }
            for(var i = 0; i < 20; i++) {
                        lista.innerHTML += `
                <div class="box-informacoes-cadastradas">
                
                <div class="titulos">
                <h4 class="title-id">${obj[i].idUsuario}</h4>
                <h4 class="title-nome">${obj[i].nomeUsuario}</h4>
                <h4 class="title-email">${obj[i].email}</h4>
                <h4 class="title-cargo">${obj[i].cargo}</h4>
                <div class="wrapper">
                        <div class="icon editar">
                            <div  class="tooltip"></div>
                            <span id="editar-div" class="icons">
                            <i id="editar" class="material-symbols-sharp" onclick="formularioUpDate()">border_color</i>
                        </span>
                        </div>
                    </div>
                    </div>
                    <div class="wrapper">
                        <div class="icon excluir">
                            <div  id="tooltip-excluir" class="tooltip"></div>
                            <span id="deletar-div" class="icons">
                            <i id="deletar" class="material-symbols-sharp"onclick="deletarUsuario(${obj[i].idUsuario})">delete</i>
                            </span>
                        </div>
                    </div>
              </div>
            </div>
                        `
                    }
        }).catch((erro) => {
    
        })
    
    }).catch(function (resposta) {
        if (resposta.status == 406) {
            alert('Oops!! Parece que você ja curtiu esse livro... que tal procurar um outro que tenha interesse? :)')
        }
        console.log(`#ERRO:${resposta}`);
    
    });
    }
    
  }


function listarMaquina(){
        fetch(`/usuarios/listarMaquina/${sessionStorage.ID_EMPRESA}`, {
            method: "GET",
        }).then(function (resposta) {
        
            // console.log("resposta: ", resposta);
            resposta.json().then((json) => {
                var obj = (json);
                console.log(obj)
                for(var i = 0; i < 20; i++) {
                        listaMaquina.innerHTML += `
                    <div class="box-informacoes-cadastradas">
                    
                    <div class="titulos">
                    <h4 class="title-id">${obj[i].idMaquina}</h4>
                    <h4 class="title-nome">${obj[i].hostName}</h4>
                    <h4 class="title-nome">${obj[i].componente}</h4>
                    <h4 class="title-nome">${obj[i].limiteAlerta}%</h4>
                    <div class="wrapper">
                        <div class="icon editar">
                            <div  class="tooltip">Editar</div>
                            <span id="editar-div" class="icons">
                            <i id="editar" class="material-symbols-sharp"onclick="formularioUpDateMaquina()">border_color</i>
                        </span>
                        </div>
                    </div>
                    <div class="wrapper">
                        <div class="icon excluir">
                            <div  id="tooltip-excluir" class="tooltip">Excluir</div>
                            <span id="deletar-div" class="icons">
                            <i id="deletar" class="material-symbols-sharp"onclick="deletarMaquina(${obj[i].idMaquina})">delete</i>
                            </span>
                        </div>
                    </div>
                  </div>
                </div>
                            `
                        }
            }).catch((erro) => {
        
            })
        
        }).catch(function (resposta) {
            if (resposta.status == 406) {
                alert('Oops!! Parece que você ja curtiu esse livro... que tal procurar um outro que tenha interesse? :)')
            }
            console.log(`#ERRO:${resposta}`);
        
        });
    }

    function listarAlerta(){
        fetch(`/usuarios/listarAlerta/${sessionStorage.ID_EMPRESA}`, {
            method: "GET",
        }).then(function (resposta) {
        
            // console.log("resposta: ", resposta);
            resposta.json().then((json) => {
                var obj = (json);
                console.log(obj)
                for(var i = 0; i < 1; i++) {
                    listaAlerta.innerHTML = `   `;
                }
                for(var i = 0; i < 7; i++) {
                            listaAlerta.innerHTML += `
                            
                            <table>
                                <thead>
                                    <tr>
                                    </tr>
                                </thead>
                                 <tbody>
							
							<tr>
                            
								<th>
                                <p> Id do alerta </p>
									<h4>${obj[i].idAlerta}</h4>
								</th>
								<th style="color: grey">
                                <p style="color: Black"> Descrição </p>
                                ${obj[i].descrição}
								</th>
								<th>
                                <p> Status </p>
                                <span class="status process">${obj[i].categoria}</span></th>
							</tr>
						</tbody>
                            </table>
                       
                            ` 
                             
                        }
            }).catch((erro) => {
        
            })
        
        }).catch(function (resposta) {
            if (resposta.status == 406) {
                alert('Oops!! Parece que você ja curtiu esse livro... que tal procurar um outro que tenha interesse? :)')
            }
            console.log(`#ERRO:${resposta}`);
        
        });
        }
    
        
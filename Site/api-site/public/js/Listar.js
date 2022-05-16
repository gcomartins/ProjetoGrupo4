function listar(){
    fetch(`/usuarios/listar`, {
        method: "GET",
    }).then(function (resposta) {
    
        // console.log("resposta: ", resposta);
        resposta.json().then((json) => {
            var obj = (json);
            console.log(obj)
            for(var i = 1; i < 20; i++) {
                        lista.innerHTML += `
                <div class="box-informacoes-cadastradas">
                
                <div class="titulos">
                <h4 class="title-ram">${obj[i].idUsuario}</h4>
                <h4 class="title-ram">${obj[i].nomeUsuario}</h4>
                <h4 class="title-ram">${obj[i].email}</h4>
                <h4 class="title-ram">${obj[i].cargo}</h4>
                <div class="wrapper">
                    <div class="icon editar">
                        <div  class="tooltip">Editar</div>
                        <span id="editar-div" class="icons">
                        <i id="editar" class="material-symbols-sharp">border_color</i>
                    </span>
                    </div>
                </div>
                <div class="wrapper">
                    <div class="icon excluir">
                        <div  id="tooltip-excluir" class="tooltip">Excluir</div>
                        <span id="deletar-div" class="icons">
                        <i id="deletar" class="material-symbols-sharp" onclick="deletarUsuario(${obj[i].idUsuario})">delete</i>
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


function listarMaquina(){
        fetch(`/usuarios/listarMaquina`, {
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
                    <h4 class="title-ram">${obj[i].idMaquinaComponentes}</h4>
                    <h4 class="title-alerta">${obj[i].nome}</h4>
                    <h4 class="title-alerta">${obj[i].capacidade}</h4>
                    <h4 class="title-alerta">${obj[i].limiteAlerta}%</h4>
                    <div class="wrapper">
                        <div class="icon editar">
                            <div  class="tooltip">Editar</div>
                            <span id="editar-div" class="icons">
                            <i id="editar" class="material-symbols-sharp">border_color</i>
                        </span>
                        </div>
                    </div>
                    <div class="wrapper">
                        <div class="icon excluir">
                            <div  id="tooltip-excluir" class="tooltip">Excluir</div>
                            <span id="deletar-div" class="icons">
                            <i id="deletar" class="material-symbols-sharp">delete</i>
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

    function listarLog(){
        fetch(`/usuarios/listarLog`, {
            method: "GET",
        }).then(function (resposta) {
        
            // console.log("resposta: ", resposta);
            resposta.json().then((json) => {
                var obj = (json);
                console.log(obj)
                for(var i = 1; i < 20; i++) {
                            lista.innerHTML += `
                    <div class="box-informacoes-cadastradas">
                    
                    <div class="titulos">
                    <h4 class="title-ram">${obj[i].idUsuario}</h4>
                    <h4 class="title-ram">${obj[i].nomeUsuario}</h4>
                    <h4 class="title-ram">${obj[i].email}</h4>
                    <h4 class="title-ram">${obj[i].cargo}</h4>
                    <div class="wrapper">
                        <div class="icon editar">
                            <div  class="tooltip">Editar</div>
                            <span id="editar-div" class="icons">
                            <i id="editar" class="material-symbols-sharp">border_color</i>
                        </span>
                        </div>
                    </div>
                    <div class="wrapper">
                        <div class="icon excluir">
                            <div  id="tooltip-excluir" class="tooltip">Excluir</div>
                            <span id="deletar-div" class="icons">
                            <i id="deletar" class="material-symbols-sharp" onclick="deletarUsuario(${obj[i].idUsuario})">delete</i>
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
    
        
function cadastrarUsuario() {
    var myInput = document.getElementById("idEmpresa");
    myInput.value = sessionStorage.ID_EMPRESA;
    var formulario = new URLSearchParams(new FormData(document.getElementById("form_cadastroUsauario")));
    
    
    var nomeUsuario = formulario.get("nomeUsuario");
    var email = formulario.get("email");
    var senha = formulario.get("senha");
    var cargo = formulario.get("cargo");
    var idEmpresa = sessionStorage.ID_EMPRESA;
    
    // TODO: VERIFICAR AS VALIDAÇÕES QUE ELES ESTÃO APRENDENDO EM ALGORITMOS 
    if (nomeUsuario == "" || cargo == "" || email == "" || senha == "" ) {
    
    window.alert("Preencha todos os campos para prosseguir!");
    if (nomeUsuario == "") {
        console.log('nome está em branco')
    }
    if (email == "") {
        console.log('email está em branco')
    }
    if (senha == "") {
        console.log('senha está em branco')
    }
    if (cargo == "") {
        console.log('confirmacaoSenha está em branco')
    }
    finalizarAguardar();
    return false;
    }
    
    if (email.indexOf("@") == -1 || email.indexOf(".com") == -1) {
    window.alert("Ops, e-mail inválido! Verifique e tente novamente.");
    finalizarAguardar();
    return false;
    }
    
    fetch("/usuarios/cadastrarUsuario", {
    method: "POST",
    body: formulario
    }).then(function (resposta) {
    
    console.log("resposta: ", resposta);
    
    if (resposta.ok) {
        window.alert("Cadastro realizado com sucesso!");
        limparFormulario1();
        finalizarAguardar();
        listar();
    } else {
        throw ("Houve um erro ao tentar realizar o cadastro!");
    }
    }).catch(function (resposta) {
    console.log(`#ERRO: ${resposta}`);
    finalizarAguardar();
    });
    
    return false;
    }


function cadastrarMaquina() {
    var myInput = document.getElementById("idEmpresa");
    myInput.value = sessionStorage.ID_EMPRESA;
        var formulario = new URLSearchParams(new FormData(document.getElementById("form_cadastroMaquina")));
        
        var identPessoal = formulario.get("identPessoal");
        var hostName = formulario.get("hostName");
        var grupo = formulario.get("grupo");
        var idEmpresa = sessionStorage.ID_EMPRESA;
        
        
        // TODO: VERIFICAR AS VALIDAÇÕES QUE ELES ESTÃO APRENDENDO EM ALGORITMOS 
        if (hostName == "" || grupo == "" || nome == "" || identPessoal == "" || idEmpresa == "" ) {
        
        window.alert("Preencha todos os campos para prosseguir!");
            if (hostName == "" ) {
                console.log("hostName está em branco!");
            }
            if (grupo == "") {
                console.log('grupo está em branco')
            }
            if (nome == "") {
                console.log("nome está em branco!");
            }
                return false;
            }
        
        fetch("/usuarios/cadastrarMaquina", {
        method: "POST",
        body: formulario,
        }).then(function (resposta) {
        
        console.log("resposta: ", resposta);
        
        if (resposta.ok) {
            window.alert("Cadastro realizado com sucesso!");
            limparFormulario2() 
        } else {
            throw ("Houve um erro ao tentar realizar o cadastro!");
        }
        }).catch(function (resposta) {
        console.log(`#ERRO: ${resposta}`);
        });

        fetch("/usuarios/buscarMaquina", {
            method: "GET",
        }).then(function (resposta) {

            console.log("resposta BUSCAR MAQUINA: ", resposta);

            fkMaquina = resposta.idMaquina;

            if (resposta.ok) {
                window.alert("Máquina buscada com sucesso");
            } else {

                fkMaquina = 30;

                throw ("Houve um erro ao tentar buscar a Máquina");
            }
        }).catch(function (resposta) {
            console.log(`#ERRO: ${resposta}`);
        });        

        fetch("/usuarios/cadastrarComponente", {
            method: "POST",
            body: formulario,
            }).then(function (resposta) {
            
            console.log("resposta: ", resposta);
            
            if (resposta.ok) {
                window.alert("Cadastro realizado com sucesso!");
                limparFormulario2() 
            } else {
                throw ("Houve um erro ao tentar realizar o cadastro!");
            }
            }).catch(function (resposta) {
            console.log(`#ERRO: ${resposta}`);
            });
            
        return false;
    }

    function cadastrarComponente() {
        var myInput = document.getElementById("idEmpresa");
        myInput.value = sessionStorage.ID_EMPRESA;
            var formulario = new URLSearchParams(new FormData(document.getElementById("form_cadastroMaquina")));
            
            var comp1 = formulario.get("comp1");
            var comp2 = formulario.get("comp2");
            var comp3 = formulario.get("comp3");
            var limiteAlertaRam = formulario.get("limiteAlertaRam");
            var limiteAlertaCpu = formulario.get("limiteAlertaCpu");
            var limiteAlertaDisco = formulario.get("limiteAlertaDisco");
            var capacidadeRam = formulario.get("capacidadeRam");
            var capacidadeCpu = formulario.get("capacidadeCpu");
            var capacidadeDisco = formulario.get("capacidadeDisco");
            var fkMaquina = null;

            // TODO: VERIFICAR AS VALIDAÇÕES QUE ELES ESTÃO APRENDENDO EM ALGORITMOS 
            if (comp1 == "" || comp2 == "" || comp3 == "" ) {
            
            window.alert("Preencha todos os campos para prosseguir!");
                if (comp1 == "" ) {
                    console.log("comp1 está em branco!");
                }
                if (comp2 == "") {
                    console.log('comp2 está em branco')
                }
                if (comp3 == "") {
                    console.log("comp3 está em branco!");
                }
                    return false;
                }
            
            fetch("/usuarios/cadastrarComponente", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                ram: comp1,
                cpu: comp2,
                disco: comp3,
                fkMaquina: fkMaquina,
                limiteAlertaRam: limiteAlertaRam,
                limiteAlertaCpu: limiteAlertaCpu,
                limiteAlertaDisco: limiteAlertaDisco,
                capacidadeRam : capacidadeRam,
                capacidadeCpu : capacidadeCpu,
                capacidadeDisco: capacidadeDisco,
            })
            }).then(function (resposta) {
            
            console.log("resposta: ", resposta);
            
            if (resposta.ok) {
                window.alert("Cadastro realizado com sucesso!");
                limparFormulario2() 
            } else {
                throw ("Houve um erro ao tentar realizar o cadastro!");
            }
            }).catch(function (resposta) {
            console.log(`#ERRO: ${resposta}`);
            });
    
            return false;
        }


function cadastrar() {
        aguardar();

        var formulario = new URLSearchParams(new FormData(document.getElementById("form_cadastro")));

        var nomeEmpresa = formulario.get("nome");
        var cnpj = formulario.get("sobrenome");
        var representante = formulario.get("nascimento");
        var email = formulario.get("email");
        var senha = formulario.get("senha");

        // TODO: VERIFICAR AS VALIDAÇÕES QUE ELES ESTÃO APRENDENDO EM ALGORITMOS 
        if (nomeEmpresa == "" || cnpj == "" || representante == "" || email == "" || senha == "" ) {

            window.alert("Preencha todos os campos para prosseguir!");
            if (nomeEmpresa == "") {
                console.log('nome está em branco')
            }
            if (cnpj == "") {
                console.log('nome está em branco')
            }
            if (email == "") {
                console.log('email está em branco')
            }
            if (senha == "") {
                console.log('senha está em branco')
            }
            if (representante == "") {
                console.log('confirmacaoSenha está em branco')
            }
            finalizarAguardar();
            return false;
        }

        if (email.indexOf("@") == -1 || email.indexOf(".com") == -1) {
            window.alert("Ops, e-mail inválido! Verifique e tente novamente.");
            finalizarAguardar();
            return false;
        }

        fetch("/usuarios/cadastrar", {
            method: "POST",
            body: formulario
        }).then(function (resposta) {

            console.log("resposta: ", resposta);

            if (resposta.ok) {
                window.alert("Cadastro realizado com sucesso!");
                window.location = "login.html";
                finalizarAguardar();
            } else {
                throw ("Houve um erro ao tentar realizar o cadastro!");
            }
        }).catch(function (resposta) {
            console.log(`#ERRO: ${resposta}`);
            finalizarAguardar();
        });

        return false;
    }
function limparFormulario() {
        document.getElementById("form_cadastro").reset();
    }

function limparFormulario1() {
        document.getElementById("form_cadastroUsauario").reset();
    }

function limparFormulario2() {
        document.getElementById("form_cadastroMaquina").reset();
    }

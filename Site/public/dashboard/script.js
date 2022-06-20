const allSideMenu = document.querySelectorAll('#sidebar .side-menu.top li a');

allSideMenu.forEach(item=> {
	const li = item.parentElement;

	item.addEventListener('click', function () {
		allSideMenu.forEach(i=> {
			i.parentElement.classList.remove('active');
		})
		li.classList.add('active');
	})
});




// TOGGLE SIDEBAR
const menuBar = document.querySelector('#content nav .bx.bx-menu');
const sidebar = document.getElementById('sidebar');

menuBar.addEventListener('click', function () {
	sidebar.classList.toggle('hide');
})







const searchButton = document.querySelector('#content nav form .form-input button');
const searchButtonIcon = document.querySelector('#content nav form .form-input button .bx');
const searchForm = document.querySelector('#content nav form');

searchButton.addEventListener('click', function (e) {
	if(window.innerWidth < 576) {
		e.preventDefault();
		searchForm.classList.toggle('show');
		if(searchForm.classList.contains('show')) {
			searchButtonIcon.classList.replace('bx-search', 'bx-x');
		} else {
			searchButtonIcon.classList.replace('bx-x', 'bx-search');
		}
	}
})





if(window.innerWidth < 768) {
	sidebar.classList.add('hide');
} else if(window.innerWidth > 576) {
	searchButtonIcon.classList.replace('bx-x', 'bx-search');
	searchForm.classList.remove('show');
}


window.addEventListener('resize', function () {
	if(this.innerWidth > 576) {
		searchButtonIcon.classList.replace('bx-x', 'bx-search');
		searchForm.classList.remove('show');
	}
})



const switchMode = document.getElementById('switch-mode');

switchMode.addEventListener('change', function () {
	if(this.checked) {
		document.body.classList.add('dark');
	} else {
		document.body.classList.remove('dark');
	}
})

function plotarGrafico2(idGrafico) {

	
		
	var dados = [];
	var datas = [];
	var datasFormatadas = [];
	var caminho = '';
	var isTemp = false;
	
	switch (idGrafico) {
		case 'graficoDisco':
			caminho = `/usuarios/graficarDisco`;
			break;

		case 'graficoMemoria':
			caminho = `/usuarios/graficarMemoria`;
			break;

		case 'graficoCpu':
			caminho = `/usuarios/graficarCpu`;
			break;
		
		case 'graficoTemp':
			caminho = `/usuarios/graficarTemp`;
			isTemp = true;
			break;
			
		default:
			break;
	}

	fetch(caminho, { cache: 'no-store' }).then(function (response) {
        if (response.ok) {
            response.json().then(function (resposta) {
                console.log(`Dados recebidos: ${JSON.stringify(resposta)}`);
                
                for (let i = 0; i < resposta.length; i++) {
                    if (idGrafico == 'graficoTemp') {
						dados.push(resposta[i].leituraTemperatura);
					}else {
						dados.push(resposta[i].leituraDesempenho);
					}
                    datas.push(resposta[i].dataHora);
                }
				
				for (let index = 0; index < datas.length; index++) {
					const e = datas[index];
					var dataFormatada = new Date(e).getHours() + ':' + new Date(e).getMinutes();
					datasFormatadas.push(dataFormatada);
					
				}
				gerarGrafico(idGrafico, dados, datasFormatadas, isTemp);
            });
			carregarDadosDoGrafico();
        } else {
            console.error('Nenhum dado encontrado ou erro na API');
        }
    })
        .catch(function (error) {
            console.error(`Erro na obtenção dos dados p/ gráfico: ${error.message}`);
        });


	
}

function gerarGrafico2(idGrafico, dados, datas, isTemp){
			const ctx = document.getElementById(idGrafico).getContext('2d');

			let myChart = new Chart(ctx, {
				type: 'line',
		
				data: {
					labels: datas,
					datasets: [{
						label: isTemp? "Graus celsius" : 'Uso (em %)',
						data: dados,
						backgroundColor: [
							'rgba(255, 99, 132, 0.12)',
						],
						borderColor: [
							'rgba(255, 99, 132, 1)',
						],
						borderWidth: 1
					}]
				},
				options: {
					scales: {
						yAxes: [{
							ticks: {
								max: 100,
								min: 0,
								stepSize: 25
							}
						}],
					}
				}
			});

}

function atualizarGrafico2(idGrafico, hostname) {
	var hostnameVar = hostname;
	var dados = [];
	var datas = [];
	var datasFormatadas = [];
	var caminho = '';
	var isTemp = false;
	
	switch (idGrafico) {
		case 'graficoDisco':
			caminho = `/usuarios/graficarDisco`;
			break;

		case 'graficoMemoria':
			caminho = `/usuarios/graficarMemoria`;
			break;

		case 'graficoCpu':
			caminho = `/usuarios/graficarCpu`;
			break;
		
		case 'graficoTemp':
			caminho = `/usuarios/graficarTemp`;
			isTemp = true;
			break;
			
		default:
			break;
	}

	fetch('/usuarios/atualizarGrafico', { 
		method: "POST",
		headers: {
		"Content-Type": "application/json"
	},
	body: JSON.stringify({
		hostname: hostnameVar,
	}) }).then(function (response) {
        if (response.ok) {
            response.json().then(function (resposta) {
                console.log(`Dados recebidos: ${JSON.stringify(resposta)}`);
                
				var dadosDisco = [];
				var datasDisco = [];
				var dadosRam = [];
				var datasRam = [];
				var dadosCpu = [];
				var dadosTemp = [];
				var datasCpuTemp = [];

				for (let i = 0; i < resposta.length; i++) {
					const e = resposta[i];
					switch (e.nome) {
						case 'Disco':
							dadosDisco.push(e.leituraDesempenho);
							datasDisco.push(new Date(e.dataHora).getHours() + ':' + new Date(e.dataHora).getMinutes());
							break;

							case 'Ram':
								dadosRam.push(e.leituraDesempenho);
								datasRam.push(new Date(e.dataHora).getHours() + ':' + new Date(e.dataHora).getMinutes());
							
							break;

							case 'Cpu':
								dadosCpu.push(e.leituraDesempenho);
								dadosTemp.push(e.leituraTemperatura);
								datasCpuTemp.push(new Date(e.dataHora).getHours() + ':' + new Date(e.dataHora).getMinutes());

							break;
					
						default:
							break;
					}
					
				}

				switch (idGrafico) {
					case 'graficoDisco':
						divGraficoDisco.innerHTML = '';
						divGraficoDisco.innerHTML = '<canvas id="graficoDisco"></canvas>';
						gerarGrafico(idGrafico, dadosDisco, datasDisco.reverse(), isTemp);
						break;
			
					case 'graficoMemoria':
						divGraficoRam.innerHTML = '';
						divGraficoRam.innerHTML = '<canvas id="graficoMemoria"></canvas>';
						gerarGrafico(idGrafico, dadosRam, datasRam.reverse(), isTemp);
						break;
			
					case 'graficoCpu':
						divGraficoCpu.innerHTML = '';
						divGraficoCpu.innerHTML = '<canvas id="graficoCpu"></canvas>';
						gerarGrafico(idGrafico, dadosCpu, datasCpuTemp.reverse(), isTemp);
						break;
					
					case 'graficoTemp':
						divGraficoTemp.innerHTML = '';
						divGraficoTemp.innerHTML = '<canvas id="graficoTemp"></canvas>';
						gerarGrafico(idGrafico, dadosTemp, datasCpuTemp.reverse(), isTemp);
						break;
						
					default:
						break;
				}
            });
			carregarDadosDoGrafico();
        } else {
            console.error('Nenhum dado encontrado ou erro na API');
        }
    })
        .catch(function (error) {
            console.error(`Erro na obtenção dos dados p/ gráfico: ${error.message}`);
        });
	
}

function carregarDadosDoGrafico(){
gerarGrafico();
}
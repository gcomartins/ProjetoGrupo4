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

function plotarGrafico(idGrafico) {
		
	var dados = [];
	var datas = [];
	var datasFormatadas = [];
	var caminho = '';

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
				gerarGrafico(idGrafico, dados, datasFormatadas);
            });
        } else {
            console.error('Nenhum dado encontrado ou erro na API');
        }
    })
        .catch(function (error) {
            console.error(`Erro na obtenção dos dados p/ gráfico: ${error.message}`);
        });


	
}

function gerarGrafico(idGrafico, dados, datas){
	const ctx = document.getElementById(idGrafico).getContext('2d');
	let myChart = new Chart(ctx, {
		type: 'line',

		data: {
			labels: datas,
			datasets: [{
				label: 'Desempenho',
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
				y: {
					beginAtZero: true
				}
			}
		}
	});
}
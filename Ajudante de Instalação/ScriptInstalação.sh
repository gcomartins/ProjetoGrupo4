#Usuário 
echo "Adicionar usuário"
sudo adduser datacat
#senha

sudo usermod -aG sudo datacat

#Instalação do Java
	
echo  "$(tput setaf 10)[catDev]:$(tput setaf 7) Olá Usuário, serei seu assistente para instalação geral do ambiente e da aplicação da DataCat!"

echo  "$(tput setaf 10)[bot]:$(tput setaf 7) Olá Usuário,vou verificar aqui se você possui o Java instalado."

java -version
if [ $? -eq 0 ]
	then
		echo "$(tput setaf 10)[bot]:$(tput setaf 7) Identifiquei que você já tem o java instalado."

         echo "$(tput setaf 10)[bot]:$(tput setaf 7) Fique para continuar!"

	else
		echo "$(tput setaf 10)[bot]:$(tput setaf 7) Não identifiquei nenhuma versão do Java instalado, irei resolver para você agora mesmo!"

		echo "$(tput setaf 10)[bot]:$(tput setaf 7) Confirme para mim se realmente deseja instalar o Java (s/n)?"

#Atualização dos pacotes
	read inst
	if [ \"$inst\" == \"s\" ]
		then
			echo "$(tput setaf 10)[bot]:$(tput setaf 7) Você decidiu instalar o Java"
			echo "$(tput setaf 10)[bot]:$(tput setaf 7) Vamos verificar seu pacote tá atualizado e intalado"
			sleep 2
            sudo apt update && sudo apt upgrade -y
			sleep 2
		
			if [ true ]
				then
					echo "$(tput setaf 10)[bot]:$(tput setaf 7) Preparando para instalar a versão 11 do Java. Confirme a instalação quando solicitado"

					sudo apt install default-jre ; apt install openjdk-11-jre; -y
					clear

					echo "$(tput setaf 10)[bot]:$(tput setaf 7) JAVA instalado com sucesso."
				fi
		else 	

		echo "$(tput setaf 10)[bot]:$(tput setaf 7) Você optou por não instalar o Java por enquanto,não se esqueça de que precisará do Java para rodar a aplicação."

        echo "$(tput setaf 10)[bot]:$(tput setaf 7) Fique com a DataCat para continuar."
	fi
fi
#Instalação do GUI
         sleep 4
            echo "$(tput setaf 10)[bot]:$(tput setaf 7) Vamos instalar o GUI"
            sudo apt-get install xrdp lxde-core lxde tigervnc-standalone-server -y
			echo "$(tput setaf 10)[bot]:$(tput setaf 7) Tudo certo, vamos continuar"
            
#Instalação da Aplicação

echo  "$(tput setaf 10)[catDev]:$(tput setaf 7) Olá Usuário! Serei seu assistente para instalação da aplicação da DataCat!"
sleep 2
echo  "$(tput setaf 10)[catDev]:$(tput setaf 7) Você já possui nossa aplicação?(s/n)"

read inst10

if [ \"$inst10\" == \"n\"  ]
    then
    echo  "$(tput setaf 10)[bot]:$(tput setaf 7) Okay, vi que você não possui nossa aplicação."

    echo  "$(tput setaf 10)[bot]:$(tput setaf 7) Deseja instalar nossa aplicação?(s/n)" 

    read inst6

    if [ \"$inst6\" == \"s\" ]

    then
    echo  "$(tput setaf 10)[bot]:$(tput setaf 7) Estarei instalando o repositório em sua máquina!" 
  
    sleep 4

    echo  "$(tput setaf 10)[bot]:$(tput setaf 7) Aguarde um momento porfavor!"

    sleep 4
    cd /home/ubuntu
        git clone  https://github.com/gcomartins/DataCat-App.git
    sleep 4

    echo  "$(tput setaf 10)[bot]:$(tput setaf 7) Pronto! Repositório instalado com sucesso."
    
    sleep 4
    
    echo  "$(tput setaf 10)[bot]:$(tput setaf 7) Agora estarei instalando a aplicação em seu ubuntu."
    
    # mv login-java-swing-1.0-SNAPSHOT-jar-with-dependencies.jar /home/Desktop/datacat
    sleep 4
   
     else

     echo  "$(tput setaf 10)[bot]:$(tput setaf 7) Tudo bem, não irei instalar a nossa aplicação"
    exit

     fi
   
else
echo  "$(tput setaf 10)[bot]:$(tput setaf 7) Você  já tem nossa aplicação"

fi

cd DataCat-App
cd appAntigo 

 java -jar data-cat-jar-1.0-SNAPSHOT-jar-with-dependencies.jar
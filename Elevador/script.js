// Função para inicializar a página
window.onload = function() {
    var inputAndar = document.getElementById("andar");
    inputAndar.value = "0"; // Define o valor inicial do input como "0"
    document.getElementById("terreo").disabled = true; // Desativa o botão do térreo
}

// Função para selecionar o andar
function selecionarAndar(andarSelecionado) {
    var inputAndar = document.getElementById("andar");
    var andarAtual = parseInt(inputAndar.value);
    
    console.log("Andar atual:", andarAtual);
    console.log("Andar selecionado:", andarSelecionado);
    
    // Armazena a imagem original do elevador
    var imagemOriginal = document.getElementById("elevador").src;
    
    // Altera a imagem do elevador
    document.getElementById("elevador").src = "img_01.jpg";
    
    // Se o andar selecionado for diferente do andar atual
    if (andarSelecionado !== andarAtual.toString()) {
        console.log("Iniciando transição de andares...");
        // Desativa todos os botões enquanto a transição ocorre
        desativarBotoes();
        
        // Realiza a transição de andares
        var intervalo = setInterval(function() {
            if (andarAtual < andarSelecionado) {
                andarAtual++;
            } else {
                andarAtual--;
            }
            
            // Atualiza o valor do input com o andar atual
            inputAndar.value = andarAtual;
            
            console.log("Transição - Andar atual:", andarAtual);
            
            // Se chegou no andar desejado
            if (andarAtual == andarSelecionado) {
                clearInterval(intervalo); // Para a transição
                console.log("Chegou no andar desejado:", andarAtual);
                alert("Chegou no andar " + andarAtual); // Mostra um aviso
                document.getElementById("terreo").disabled = false; // Ativa o botão do térreo
                document.getElementById("primeiro-andar").disabled = false; // Ativa o botão do primeiro andar
                document.getElementById("segundo-andar").disabled = false; // Ativa o botão do segundo andar
                document.getElementById("terceiro-andar").disabled = false; // Ativa o botão do terceiro andar
                console.log("Ativando botões...");
                document.getElementById("andar-" + andarAtual).disabled = true; // Desativa o botão do andar atual
                // Volta para a imagem original do elevador após a transição
                document.getElementById("elevador").src = imagemOriginal;
            }
        }, 1000); // Transição a cada 1 segundo
    }
}

// Função para desativar todos os botões de andar
function desativarBotoes() {
    var botoes = document.querySelectorAll(".button-container button");
    botoes.forEach(function(botao) {
        botao.disabled = true;
    });
}

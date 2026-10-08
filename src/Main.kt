//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    println("=== Questão 1: Sistema de Cupons Avançado ===")
    println("Valor final (PROMO10): R$ ${calcularDesconto(100.0, "PROMO10")}")
    println("Valor final (PROMO20): R$ ${calcularDesconto(100.0, "PROMO20")}")
    println("Valor final (inválido/nulo): R$ ${calcularDesconto(100.0, null)}")
    println()

    println("=== Questão 2: Auditoria de Entregas ===")
    val enderecos = listOf("Rua A, 123", null, "Av. Central, 456", null)
    auditarEntregas(enderecos)
    println()

    println("=== Questão 3: Validação de Perfil de Streaming ===")
    validarBioInfantil("Gosto de desenhos e jogos!")
    validarBioInfantil("Essa bio é extremamente longa e com certeza vai ultrapassar o limite permitido de 50 caracteres para o perfil infantil do aplicativo.")
    validarBioInfantil(null)
    println()

    println("=== Questão 4: Processamento de Transações Pix ===")
    processarTransacoesPix()
    println()

    println("=== Questão 5: Classificação de Feedback de Motoristas ===")
    avaliarMotorista(5)
    avaliarMotorista(3)
    avaliarMotorista(null)
    println()

    println("=== Questão 6: Função Lambda para Cálculo de Gorjeta ===")
    println("Gorjeta validada (15.0): R$ ${calcularGorjeta(15.0)}")
    println("Gorjeta validada (-5.0): R$ ${calcularGorjeta(-5.0)}")
    println("Gorjeta validada (null): R$ ${calcularGorjeta(null)}")
    println()

    println("=== Questão 7: Limpeza de Banco de Dados de Usuários ===")
    val emails = listOf("dev@kotlin.com", null, "", "  ", "aluno@faculdade.edu.br")
    limparBancoDeDados(emails)
}

// ----------------------------------------------------
// Questão 1: Sistema de Cupons Avançado (when e Null Safety)
// ----------------------------------------------------
fun calcularDesconto(valor: Double, cupom: String?): Double {
    return when (cupom) {
        "PROMO10" -> valor - 10.0
        "PROMO20" -> valor - 20.0
        else -> valor
    }
}

// ----------------------------------------------------
// Questão 2: Auditoria de Entregas (Laço de Repetição e Elvis Operator)
// ----------------------------------------------------
fun auditarEntregas(enderecos: List<String?>) {
    for (item in enderecos) {
        val enderecoFinal = item ?: "Endereço Desconhecido"

        if (enderecoFinal == "Endereço Desconhecido") {
            println("Entrega Pendente: Falta de dados")
        } else {
            println("Rota traçada para: $enderecoFinal")
        }
    }
}

// ----------------------------------------------------
// Questão 3: Validação de Perfil de Streaming (if/else e Safe Call)
// ----------------------------------------------------
fun validarBioInfantil(bio: String?) {
    val tamanho = bio?.length ?: 0

    if (tamanho <= 50) {
        println("Bio aceita")
    } else {
        println("Bio muito longa")
    }
}

// ----------------------------------------------------
// Questão 4: Processamento de Transações Pix (Laço e if/else)
// ----------------------------------------------------
fun processarTransacoesPix() {
    val transacoes = listOf(50.0, null, 120.5, null, 10.0)
    var total = 0.0

    for (valor in transacoes) {
        if (valor != null) {
            total += valor
        } else {
            println("Transação ignorada")
        }
    }

    println("Valor total processado: R$ $total")
}

// ----------------------------------------------------
// Questão 5: Classificação de Feedback de Motoristas (when e Null Safety)
// ----------------------------------------------------
fun avaliarMotorista(nota: Int?) {
    val notaFinal = nota ?: 0

    when (notaFinal) {
        5 -> println("Excelente corrida!")
        4 -> println("Boa corrida.")
        1, 2, 3 -> println("Precisamos melhorar.")
        0 -> println("Nenhuma avaliação fornecida.")
    }
}

// ----------------------------------------------------
// Questão 6: Função Lambda para Cálculo de Gorjeta (Lambda, Null Safety e if)
// ----------------------------------------------------
val calcularGorjeta: (Double?) -> Double = {
    if (it == null || it < 0) {
        0.0
    } else {
        it
    }
}

// ----------------------------------------------------
// Questão 7: Limpeza de Banco de Dados de Usuários (Laços e Múltiplas Condições)
// ----------------------------------------------------
fun limparBancoDeDados(emails: List<String?>) {
    var contasInvalidas = 0

    for (email in emails) {
        // Safe call com Elvis verifica o tamanho; se for nulo, resulta em 0 (considerado em branco)
        val tamanho = email?.trim()?.length ?: 0

        if (email == null || tamanho == 0) {
            contasInvalidas++
            println("Aviso: Conta com e-mail inválido/ausente marcada para deleção.")
        } else {
            println("Conta válida: $email")
        }
    }

    println("Total de contas que precisam ser apagadas: $contasInvalidas")
}
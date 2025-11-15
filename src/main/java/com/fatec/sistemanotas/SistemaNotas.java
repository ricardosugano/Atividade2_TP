/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.fatec.sistemanotas;

/**
 *
 * @author fatec-dsm2
 */
import javax.swing.JOptionPane;

public class SistemaNotas {
    public static void main(String[] args) {
        // Primeira mensagem: pedir o nome do aluno
        String nome = JOptionPane.showInputDialog(null, 
            "Digite o nome completo do aluno:", 
            "Cadastro de Aluno", 
            JOptionPane.QUESTION_MESSAGE);
        
        // Verificar se o usuário cancelou ou deixou em branco
        if (nome == null || nome.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, 
                "Nome não informado. Programa encerrado.", 
                "Aviso", 
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // Criar o objeto Aluno
        Aluno aluno = new Aluno(nome.trim());
        
        // Segunda mensagem: pedir as três notas
        for (int i = 1; i <= 3; i++) {
            String strNota = JOptionPane.showInputDialog(null, 
                "Digite a nota TP" + i + ":", 
                "Lançamento de Notas - " + aluno.getNome(), 
                JOptionPane.QUESTION_MESSAGE);
            
            // Verificar se o usuário cancelou
            if (strNota == null) {
                JOptionPane.showMessageDialog(null, 
                    "Lançamento de notas cancelado.", 
                    "Aviso", 
                    JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            try {
                double nota = Double.parseDouble(strNota);
                aluno.adicionarNota(nota);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, 
                    "Nota inválida! Digite um número.", 
                    "Erro", 
                    JOptionPane.ERROR_MESSAGE);
                i--; // Repetir esta iteração
            }
        }
        
        // Calcular resultados
        double media = aluno.calcularMedia();
        String status = aluno.obterStatus();
        
        // Montar mensagem de resultado
        String resultado = "RESULTADO FINAL\n" +
                "Aluno: " + aluno.getNome() + "\n" +
                "Notas:\n" +
                "TP1: " + aluno.getNotas().get(0) + "\n" +
                "TP2: " + aluno.getNotas().get(1) + "\n" +
                "TP3: " + aluno.getNotas().get(2) + "\n" +
                "Média: " + String.format("%.2f", media) + "\n" +
                "Status: " + status;
        
        // Exibir resultado final
        JOptionPane.showMessageDialog(null, 
            resultado, 
            "Resultado Final - " + aluno.getNome(), 
            JOptionPane.INFORMATION_MESSAGE);
    }
}
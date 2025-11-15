/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fatec.sistemanotas;

/**
 *
 * @author fatec-dsm2
 */
import java.util.ArrayList;

public class Aluno {
    // Atributos privados
    private String nome;
    private ArrayList<Double> notas;

    // Construtor
    public Aluno(String nome) {
        this.nome = nome;
        this.notas = new ArrayList<>();
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public ArrayList<Double> getNotas() {
        return notas;
    }

    // Método para adicionar nota
    public void adicionarNota(double nota) {
        notas.add(nota);
    }

    // Método para calcular a média
    public double calcularMedia() {
        if (notas.isEmpty()) return 0.0;
        double soma = 0;
        for (double nota : notas) {
            soma += nota;
        }
        return soma / notas.size();
    }

    // Método para obter o status
    public String obterStatus() {
        double media = calcularMedia();
        if (media < 6.0) {
            return "Reprovado";
        } else if (media <= 9.0) {
            return "Aprovado";
        } else {
            return "Ótimo Aproveitamento";
        }
    }
}
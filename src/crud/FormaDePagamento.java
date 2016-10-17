/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import javax.swing.JOptionPane;

/**
 *
 * @author victor alves abreu
 */
public class FormaDePagamento {

    private int id;
    private static int nextId;
    private String tipo;

    public FormaDePagamento() {
        id = nextId;
        nextId++;
    }

    public int getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        if (!tipo.isEmpty()) {
            this.tipo = tipo;
        } else {
            JOptionPane.showMessageDialog(null, "tipo invalido");
        }
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ifc.edu.br.mv9webhib.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "ortiz_av1c_pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ortiz_av1c_pessoa_seq")
    @SequenceGenerator(name = "pessoa_seq", initialValue = 1)
    private Long id;
    
    @ManyToOne()
    Cargo cargo;

    private String nome;
    private String email;
    private Float salario;

    public Pessoa(Cargo cargo, String nome, String email, Float salario) {
        this.cargo = cargo;
        this.nome = nome;
        this.email = email;
        this.salario = salario;
    }

    public Pessoa(String nome, String email, Float salario) {
        this.nome = nome;
        this.email = email;
        this.salario = salario;
    }

    public Pessoa() {
    }

    public Float getSalario() {
        return salario;
    }

    public void setSalario(Float salario) {
        this.salario = salario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "Codigo=" + id + ", Nome=" + nome + ", Email=" + email + ", Salario=" + salario + '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

}

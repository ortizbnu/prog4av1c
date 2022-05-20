/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ifc.edu.br.mv9webhib.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ortiz_av1c_cargo")
public class Cargo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ortiz_av1c_cargo_seq")
    @SequenceGenerator(name = "cargo_seq", initialValue = 1)
    private Long id;
    
    @OneToMany(mappedBy="cargo", cascade = CascadeType.ALL)
    Set<Pessoa> pessoas = new HashSet<>();

    private String nome;

    public Cargo(String nome) {
        this.nome = nome;
    }

    public Cargo() {
    }    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set getPessoas() {
        return pessoas;
    }

    public void setPessoas(Set pessoas) {
        this.pessoas = pessoas;
    }

}

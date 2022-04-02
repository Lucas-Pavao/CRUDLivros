/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositorios;

import Model.Livro;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lucas
 */
public class LivroRep {

    private static int ultimolivro = 1;
    private static List<Livro> livros = new ArrayList<>();

    public static void inserir(Livro l) {
        l.setId(ultimolivro++);
        livros.add(l);
    }

    public static void alterar(Livro l) {
        for (Livro liv : livros) {
            if (liv.getId() == l.getId()) {
                liv.setAutor(l.getAutor());
                liv.setCategoria(l.getCategoria());
                liv.setNome(l.getNome());
            }
            return;
        }
    }

    public static Livro ler(int id) {
        for (Livro l : livros) {
            if (l.getId() == id) {
                return l;
            }
        }
        return null;
    }

    public static void deletar(Livro l) {
        Livro lAUX = null;

        for (Livro liv : livros) {
            if (liv.getId() == l.getId()) {
                lAUX = liv;
                break;
            }
        }

        livros.remove(lAUX);
    }
    
    public static List<Livro> lerTudo(){
    return livros;
    }
}

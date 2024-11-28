package utils;

import model.Conta;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataManager {

    public static void salvarContas(List<Conta> contas, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(contas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Conta> carregarContas(String filename) {
        List<Conta> contas = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            contas = (List<Conta>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return contas;
    }
}

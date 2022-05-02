package com.mycompany.datas.aula10;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TesteDatas {

    public static void main(String[] args) {
        Date hoje = new Date();
        
        //System.out.println(hoje);
        
        SimpleDateFormat formatador = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        String dataFormatada = formatador.format(hoje);
        System.out.println(dataFormatada);
    }
    
}

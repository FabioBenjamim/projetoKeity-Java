package com.agendamento.consulta.medico.api;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class teste {
	
	public static void main(String[] args) throws ParseException {
		
        java.util.Date temp = new SimpleDateFormat("HH:mm")
                .parse("14:58");
        System.out.println(temp);
    }
}

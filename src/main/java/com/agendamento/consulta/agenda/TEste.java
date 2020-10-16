package com.agendamento.consulta.agenda;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class TEste {
	public static void main( String[] args ) {
	    SimpleDateFormat sdf = new SimpleDateFormat( "HH:mm" );
	    Calendar cal = Calendar.getInstance();
	    
	    cal.set(Calendar.HOUR_OF_DAY, 13);
	    cal.set(Calendar.MINUTE, 90);
	    
	    System.out.println(sdf.format(cal.getTime()));
	    
	    // set seta um horario
	    // add adiciona hora, minuto ou segundo
	    
//	    java.lang.System.out.println(sdf.format(cal.getTime()));
	    List<String> lista = new ArrayList<String>();
	    
	    lista.add(sdf.format(cal.getTime()));
	    System.out.println(lista.get(0));
	}
}

package pressupost;

import java.text.DecimalFormat;
import org.eclipse.swt.widgets.Text;

public class Controlador {
	
	private String textError;
	float preuHora;
	float numHores;
	DecimalFormat f = new DecimalFormat("####.##");
	
	//button seleccionar
	public void seleccionar(VistaPressupost vista){		
		preuHora = preuCorrecte(vista.textPreuHora.getText());
		numHores = numHCorrecte(vista.textNHores.getText());
		if (preuHora==-1) {
			marcaError(vista.textPreuHora, vista);
		}
		if (numHores==-1){
			marcaError(vista.textNHores, vista);
		}
		if (preuHora!=-1 && numHores!=-1) {
			vista.textError.setText("");
			vista.textError.setEnabled(false);
			vista.textPreuHora.setEnabled(false);
			vista.textNHores.setEnabled(false);
			vista.btnSeleccionar.setEnabled(false);
			vista.textTipusL.setEnabled(true);
			vista.textSortida.setEnabled(true);
			vista.btnCalcular.setEnabled(true);
			vista.btnRestablir.setEnabled(true);
		}		
	}
	
	//button calcular
	public void calcular(VistaPressupost vista) {
		int tipusLlicencia;
		int sortida;
		tipusLlicencia = tipusCorrecte(vista.textTipusL.getText());
		sortida = sortidaCorrecte(vista.textSortida.getText());
		if (tipusLlicencia==-1) {
			marcaError(vista.textTipusL, vista);
			resetCalcular(vista);
		}	
		if (sortida==-1){
			marcaError(vista.textSortida, vista);
			resetCalcular(vista);
		}
		if(tipusLlicencia!=-1 && sortida !=-1) {
			vista.textError.setText("");
			vista.textError.setEnabled(false);
			float preuAss = (preuHora*numHores);
			int llicencia = importLlicencia(tipusLlicencia);
			int domicili = importDomicili(sortida);
			vista.textPreuAss.setEnabled(true);
			vista.textPreuAss.setText(f.format(preuAss));
			vista.textTipusL2.setEnabled(true);
			vista.textTipusL2.setText(textTipusL(tipusLlicencia));
			vista.textImportL.setEnabled(true);
			vista.textImportL.setText(Integer.toString(llicencia));
			vista.textIDomicili.setEnabled(true);
			vista.textIDomicili.setText(Integer.toString(domicili));
			vista.textItotal.setEnabled(true);
			vista.textItotal.setText(f.format(preuAss+llicencia+domicili));
		}		
	}
	
	//button restablir
	public void restablir(VistaPressupost vista) {
		resetCalcular(vista);
		vista.textError.setText("");
		vista.textError.setEnabled(false);
		vista.textPreuHora.setEnabled(true);
		vista.textNHores.setEnabled(true);
		vista.btnSeleccionar.setEnabled(true);
		vista.textTipusL.setEnabled(false);
		vista.textTipusL.setText("");
		vista.textSortida.setEnabled(false);
		vista.textSortida.setText("");
		vista.btnCalcular.setEnabled(false);
		vista.btnRestablir.setEnabled(false);
		
	}
	
	
	public void resetCalcular(VistaPressupost vista) {
		vista.textPreuAss.setEnabled(false);
		vista.textPreuAss.setText("");
		vista.textTipusL2.setEnabled(false);
		vista.textTipusL2.setText("");
		vista.textImportL.setEnabled(false);
		vista.textImportL.setText("");
		vista.textIDomicili.setEnabled(false);
		vista.textIDomicili.setText("");
		vista.textItotal.setEnabled(false);
		vista.textItotal.setText("");
	}
	
	public int importDomicili (int tipus) {
		int importD = 0;
		switch (tipus) {
			case 0:
				importD = 0;
				break;
			case 1:
				importD = 30;
				break;
			
		}
		return importD;
	}
	
	
	public int importLlicencia (int tipus) {
		int importL = 0;
		switch (tipus) {
			case 1:
				importL = 0;
				break;
			case 2:
				importL = 50;
				break;
			case 3:
				importL = 100;
				break;
		}
		return importL;
	}
	
	public String textTipusL (int tipus) {
		String text= "";
		switch (tipus) {
			case 1:
				text = "No s’ha instal·lat cap software amb llicència";
				break;
			case 2:
				text = "S’ha instal·lat SO amb llicència";
				break;
			case 3:
				text = "S’ha instal·lat SO amb llicència i Suite ofimàtica amb llicència";
				break;
		}
		return text;
	}
	
	public float numHCorrecte(String strNum) {
	    float num;
		if (strNum == null) {
			textError = "Introdueix el número d'hores";
	        return -1;
	    }
	    try {
	    	float f = Float.parseFloat(strNum);
	        if (f<=0 || f>=24) {
	        	textError = "El número d'hores ha de ser major de 0 i menor de 24";
	        	return -1;
	        }else {
	        	num = f;
	        }
	    } catch (NumberFormatException nfe) {
	    	textError = "Valor d'entrada incorrecte (num. hores)";
	        return -1;
	    }
	    return num;
	}	
	
	public float preuCorrecte(String strNum) {
	    float preu;
		if (strNum == null) {
			textError = "Introdueix el preu de l'hora";
	        return -1;
	    }
	    try {
	        float f = Float.parseFloat(strNum);
	        if (f<=0 || f>100) {
	        	textError = "El preu ha de ser major de 0 i menor o igual a 100";
	        	return -1;
	        }else {
	        	preu = f;
	        }
	    } catch (NumberFormatException nfe) {
	    	textError = "Valor d'entrada incorrecte (Preu hora)";
	        return -1;
	    }
	    return preu;
	}
	
	public int tipusCorrecte(String strNum) {
	    int tipus;
		if (strNum == null) {
			textError = "Introdueix el tipus de llicència";
	        return -1;
	    }
	    try {
	        int i = Integer.parseInt(strNum);
	        if (i<1 || i>3) {
	        	textError = "El tipus de llicència ha d'estar entre 1 i 3";
	        	return -1;
	        }else {
	        	tipus = i;
	        }
	    } catch (NumberFormatException nfe) {
	    	textError = "Valor d'entrada incorrecte (Tipus llicència)";
	        return -1;
	    }
	    return tipus;
	}
	
	public int sortidaCorrecte(String strNum) {
	    int sortida;
		if (strNum == null) {
			textError = "hi ha hagut sortida a domicili?";
	        return -1;
	    }
	    try {
	        int i = Integer.parseInt(strNum);
	        if (i<0 || i>1) {
	        	textError = "0 = Sense sortida a domicili. 1 = Amb sortida";
	        	return -1;
	        }else {
	        	sortida = i;
	        }
	    } catch (NumberFormatException nfe) {
	    	textError = "Valor d'entrada incorrecte (Sortida Domicili)";
	        return -1;
	    }
	    return sortida;
	}
	
	public void marcaError (Text text, VistaPressupost vista) {
		text.setFocus();
		text.selectAll();
		vista.textError.setEnabled(true);
		vista.textError.setText(textError);
	}
	

}

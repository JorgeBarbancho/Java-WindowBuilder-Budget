package pressupost;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class VistaPressupost {
	
	private Group grpImport;
	private Group grpParametres;
	
	protected Text textPreuHora;
	protected Text textNHores;
	protected Text textTipusL;
	protected Text textSortida;
	protected Text textPreuAss;
	protected Text textTipusL2;
	protected Text textImportL;
	protected Text textIDomicili;
	protected Text textItotal;
	protected Text textError;	
	
	protected Button btnSeleccionar;
	protected Button btnRestablir;
	protected Button btnCalcular;
	
	private Label lblTLlicencia1;	
	private Label lblSDomicili;
	private Label lblNHores;
	private Label lblPreuHora;	
	private Label lblPAssistencia;	
	private Label lblTLlicencia2;	
	private Label lblImportLlicncia;	
	private Label lblIDomicili;
	private Label lblITotal;
	
	private Controlador controlador = new Controlador();

	/**
	 * @wbp.parser.entryPoint
	 */
	public void finestraPressupost() {
		
		Display display = Display.getDefault();
		Shell shell = new Shell();
		shell.setSize(783, 502);
		shell.setText("Pressupost Tècnic Informàtic");
		
		// GROUP PARAMETRES
		grpParametres = new Group(shell, SWT.NONE);
		grpParametres.setBounds(10, 10, 747, 99);
		grpParametres.setText("Paràmetres Pressupost");
		
		//labels
		lblPreuHora = new Label(grpParametres, SWT.NONE);
		lblPreuHora.setBounds(10, 32, 55, 15);
		lblPreuHora.setText("Preu hora");
		lblNHores = new Label(grpParametres, SWT.NONE);
		lblNHores.setBounds(10, 69, 101, 15);
		lblNHores.setText("Número d'hores");		
		
		//texts
		textPreuHora = new Text(grpParametres, SWT.BORDER);
		textPreuHora.setTextLimit(5);
		textPreuHora.setToolTipText("el preu hora ha de ser superior a 0 i inferior o igual a 100");
		textPreuHora.setBounds(128, 29, 75, 21);		
		textNHores = new Text(grpParametres, SWT.BORDER);
		textNHores.setTextLimit(5);
		textNHores.setToolTipText("el número d'hores ha de ser superior a 0 i inferior a 24");
		textNHores.setBounds(128, 66, 75, 21);
		
		//buttons
		btnSeleccionar = new Button(grpParametres, SWT.NONE);
		btnSeleccionar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				controlador.seleccionar(VistaPressupost.this);
			}
		});
		btnSeleccionar.setBounds(232, 52, 90, 37);
		btnSeleccionar.setText("Seleccionar");
		
		//GROUP IMPORT
		grpImport = new Group(shell, SWT.NONE);
		grpImport.setBounds(10, 115, 747, 340);
		grpImport.setText("Import Pressupost");
		
		//labels
		lblTLlicencia1 = new Label(grpImport, SWT.NONE);
		lblTLlicencia1.setBounds(10, 37, 87, 15);
		lblTLlicencia1.setText("Tipus llicència");
		lblSDomicili = new Label(grpImport, SWT.NONE);
		lblSDomicili.setBounds(10, 80, 87, 15);
		lblSDomicili.setText("Sortida domicili");
		lblPAssistencia = new Label(grpImport, SWT.NONE);
		lblPAssistencia.setBounds(10, 156, 97, 15);
		lblPAssistencia.setText("Preu assistència");		
		lblTLlicencia2 = new Label(grpImport, SWT.NONE);
		lblTLlicencia2.setBounds(262, 156, 92, 15);
		lblTLlicencia2.setText("Tipus llicència");		
		lblImportLlicncia = new Label(grpImport, SWT.NONE);
		lblImportLlicncia.setBounds(262, 196, 87, 15);
		lblImportLlicncia.setText("Import llicència");
		lblIDomicili = new Label(grpImport, SWT.NONE);
		lblIDomicili.setBounds(262, 237, 90, 15);
		lblIDomicili.setText("Import domicili");
		lblITotal = new Label(grpImport, SWT.NONE);
		lblITotal.setBounds(10, 311, 87, 15);
		lblITotal.setText("Import total");
		
		//texts
		textTipusL = new Text(grpImport, SWT.BORDER);
		textTipusL.setTextLimit(1);
		textTipusL.setToolTipText("1 = No s'ha insta·lat cap software amb llicència\r\n"
								+ "2 = S'ha instal·lat SO amb llicéncia\r\n"
								+ "3 = S'ha instal·lat SO amb llicència i Suite ofimàtica amb llicència");
		textTipusL.setEnabled(false);
		textTipusL.setBounds(128, 34, 75, 21);		
		textSortida = new Text(grpImport, SWT.BORDER);
		textSortida.setTextLimit(1);
		textSortida.setToolTipText("0 = Sense sortida a domicili\r\n1 = Amb sortida a domicili");
		textSortida.setEnabled(false);
		textSortida.setBounds(128, 77, 75, 21);
		textPreuAss = new Text(grpImport, SWT.BORDER);
		textPreuAss.setEditable(false);
		textPreuAss.setEnabled(false);
		textPreuAss.setText("");
		textPreuAss.setBounds(127, 153, 76, 21);
		textTipusL2 = new Text(grpImport, SWT.BORDER);
		textTipusL2.setEditable(false);
		textTipusL2.setEnabled(false);
		textTipusL2.setBounds(373, 153, 364, 21);
		textImportL = new Text(grpImport, SWT.BORDER);
		textImportL.setEditable(false);
		textImportL.setEnabled(false);
		textImportL.setBounds(373, 193, 76, 21);
		textIDomicili = new Text(grpImport, SWT.BORDER);
		textIDomicili.setEditable(false);
		textIDomicili.setEnabled(false);
		textIDomicili.setBounds(373, 234, 76, 21);		
		textItotal = new Text(grpImport, SWT.BORDER);
		textItotal.setEditable(false);
		textItotal.setEnabled(false);
		textItotal.setBounds(127, 308, 76, 21);		
		textError = new Text(grpImport, SWT.BORDER);
		textError.setEditable(false);
		textError.setEnabled(false);
		textError.setBounds(229, 308, 508, 21);		
		
		//buttons
		btnRestablir = new Button(grpImport, SWT.NONE);
		btnRestablir.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				controlador.restablir(VistaPressupost.this);
			}
		});
		btnRestablir.setEnabled(false);
		btnRestablir.setBounds(264, 61, 90, 37);
		btnRestablir.setText("Restablir");
		
		btnCalcular = new Button(grpImport, SWT.NONE);
		btnCalcular.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				controlador.calcular(VistaPressupost.this);
			}
		});
		btnCalcular.setEnabled(false);
		btnCalcular.setBounds(373, 61, 90, 37);
		btnCalcular.setText("Calcular");		

		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}

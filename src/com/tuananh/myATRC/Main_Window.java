package com.tuananh.myATRC;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.layout.GridLayout;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
//import java.io.Reader;
//import java.util.HashMap;
//
//import javax.swing.text.TableView.TableRow;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.microsoft.z3.BoolExpr;
//import org.eclipse.ui.internal.dnd.SwtUtil;
//
//import com.microsoft.z3.BoolExpr;
//import com.microsoft.z3.Context;
import com.microsoft.z3.Expr;
//import com.microsoft.z3.IntExpr;
//import com.microsoft.z3.Solver;
//import com.microsoft.z3.Status;
import com.microsoft.z3.Z3Exception;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.ToolItem;
//import org.eclipse.swt.widgets.List;
//import org.eclipse.jface.viewers.ListViewer;
//import org.eclipse.swt.widgets.Table;
//import org.eclipse.swt.widgets.TableItem;
//import org.eclipse.swt.widgets.TableColumn;

public class Main_Window
{

	/**
	 * @uml.property  name="shlConsistencyValidating"
	 * @uml.associationEnd  
	 */
	protected Shell shlConsistencyValidating;
	/**
	 * @uml.property  name="btnResult"
	 * @uml.associationEnd  
	 */
	private Button btnResult;
	/**
	 * @uml.property  name="formToolkit"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	/**
	 * @uml.property  name="tIniInvarants"
	 * @uml.associationEnd  
	 */
	private Text tIniInvarants;
	/**
	 * @uml.property  name="tIniPreconditions"
	 * @uml.associationEnd  
	 */
	private Text tIniPreconditions;
	/**
	 * @uml.property  name="tIniPostconditions"
	 * @uml.associationEnd  
	 */
	private Text tIniPostconditions;
	/**
	 * @uml.property  name="tEvoPreconditions"
	 * @uml.associationEnd  
	 */
	private Text tEvoPreconditions;
	/**
	 * @uml.property  name="tEvoInvarants"
	 * @uml.associationEnd  
	 */
	private Text tEvoInvarants;
	/**
	 * @uml.property  name="tEvoPostconditions"
	 * @uml.associationEnd  
	 */
	private Text tEvoPostconditions;
	/**
	 * @uml.property  name="btnInitialPreconditionVariables"
	 * @uml.associationEnd  
	 */
	private Button btnInitialPreconditionVariables;
	/**
	 * @uml.property  name="btnEvolutionPreconditionVariable"
	 * @uml.associationEnd  
	 */
	private Button btnEvolutionPreconditionVariable;
	/**
	 * @uml.property  name="btnInitialPostconditionVariables"
	 * @uml.associationEnd  
	 */
	private Button btnInitialPostconditionVariables;
	/**
	 * @uml.property  name="btnEvolutionPostconditionVariables"
	 * @uml.associationEnd  
	 */
	private Button btnEvolutionPostconditionVariables;

	/**
	 * @uml.property  name="validator"
	 * @uml.associationEnd  
	 */
	public Validator validator;
	/**
	 * @uml.property  name="btnCheckPreconditions"
	 * @uml.associationEnd  
	 */
	private Button btnCheckPreconditions;
	/**
	 * @uml.property  name="btnCheckPostconditions"
	 * @uml.associationEnd  
	 */
	private Button btnCheckInVariants;
	/**
	 * @uml.property  name="btnCheckInVariants"
	 * @uml.associationEnd  
	 */
	private Button btnCheckPostconditions;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public Node nv;
	private Button button;
	private Button button_1;
	private ToolItem toolItem;
	private ToolItem toolItem_1;
	private ToolItem toolItem_2;
	private Group grpFunction;
	private Group grpInitialModel;
	
	public static void main(String[] args)
	{
		try
		{
			Main_Window window = new Main_Window();
			window.open();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open()
	{
		Display display = Display.getDefault();
		createContents();
		shlConsistencyValidating.open();
		shlConsistencyValidating.layout();
		while (!shlConsistencyValidating.isDisposed())
		{
			if (!display.readAndDispatch())
			{
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents()
	{
		validator = new Validator();
		shlConsistencyValidating = new Shell();
		shlConsistencyValidating.setSize(768, 483);
		shlConsistencyValidating.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		shlConsistencyValidating.setTouchEnabled(true);
		shlConsistencyValidating.setImage(SWTResourceManager.getImage("E:\\Dropbox\\Faculty\\Nam 2017\\KHOA CNTT\\icon-survey-validation.png"));
		shlConsistencyValidating.setMinimumSize(new Point(800, 480));
		shlConsistencyValidating.setText("Consistency Validator Tool");
				shlConsistencyValidating.setLayout(null);
				
				ToolBar toolBar = new ToolBar(shlConsistencyValidating, SWT.FLAT | SWT.RIGHT);
				toolBar.setBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
				toolBar.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_FOREGROUND));
				toolBar.setBounds(4, 7, 822, 23);
				formToolkit.adapt(toolBar);
				formToolkit.paintBordersFor(toolBar);
				
				ToolItem tltmGenerate = new ToolItem(toolBar, SWT.NONE);
				tltmGenerate.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent arg0) 
					{
						FileDialog fd = new FileDialog(shlConsistencyValidating, SWT.OPEN);
				        fd.setText("Open");
				        fd.setFilterPath("C:/");
				        String[] filterExt = { "*.xml" };
				        fd.setFilterExtensions(filterExt);
				        String selected = fd.open();
				        try {
							readfilexml(selected);
						} catch (ParserConfigurationException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (SAXException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				tltmGenerate.setText("Open UML");
				
				toolItem = new ToolItem(toolBar, SWT.SEPARATOR);
				
				ToolItem tltmNewItem = new ToolItem(toolBar, SWT.NONE);
				tltmNewItem.setText("Open OCL");
				
				toolItem_1 = new ToolItem(toolBar, SWT.SEPARATOR);
				
				ToolItem tltmWriteFol = new ToolItem(toolBar, SWT.NONE);
				tltmWriteFol.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent arg0) {
					}
				});
				tltmWriteFol.setText("OCL2FOL");
				
				toolItem_2 = new ToolItem(toolBar, SWT.SEPARATOR);
				
				ToolItem tltmSaveFol = new ToolItem(toolBar, SWT.NONE);
				tltmSaveFol.setText("Save FOL");
		
				btnInitialPreconditionVariables = new Button(shlConsistencyValidating, SWT.BORDER | SWT.FLAT);
				btnInitialPreconditionVariables.setBounds(171, 245, 169, 29);
				btnInitialPreconditionVariables.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_FOREGROUND));
				btnInitialPreconditionVariables.setVisible(false);
				btnInitialPreconditionVariables.addSelectionListener(new SelectionAdapter()
				{
					@Override
					public void widgetSelected(SelectionEvent e)
					{
						String text = tIniPreconditions.getText();
						String[] Variables = null;
						try
						{
							if (text == null || text == "")
							{
								MessageBox warn = new MessageBox(shlConsistencyValidating);
								warn.setMessage("Some variables were not set");
								warn.setText("Un-set Variable error");
								warn.open();
							}
							else
							{
								Variables = Data.getInstance().iniPre.analyzeText(Data.getInstance().ctx,text);
								Display d = Display.getDefault();
								VariableWindows variablesList = new VariableWindows(d);
								variablesList.setText("Initial Precondition");
								variablesList.setItem(Variables,nv,"InitialPreconditions");
								variablesList.open();
							}
						}
						catch (Z3Exception e1)
						{
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					}
				});
				formToolkit.adapt(btnInitialPreconditionVariables, true, true);
				btnInitialPreconditionVariables.setText("Initial Precondition Variables");
		
				btnEvolutionPreconditionVariable = new Button(shlConsistencyValidating, SWT.BORDER | SWT.FLAT);
				btnEvolutionPreconditionVariable.setBounds(500, 245, 181, 29);
				btnEvolutionPreconditionVariable.setVisible(false);
				btnEvolutionPreconditionVariable.addSelectionListener(new SelectionAdapter()
				{
					@Override
					public void widgetSelected(SelectionEvent e)
					{
						String text = tEvoPreconditions.getText();
						String[] Variables = null;
						try
						{
							if (text == null || text == "")
							{
								MessageBox warn = new MessageBox(shlConsistencyValidating);
								warn.setMessage("Some variables were not set");
								warn.setText("Un-set Variable error");
								warn.open();
							}
							else
							{
								Variables = Data.getInstance().evoPre.analyzeText(Data.getInstance().ctx,text);
								Display d = Display.getDefault();
								VariableWindows variablesList = new VariableWindows(d);
								variablesList.setText("Evolution Precondition");
								//variablesList.setItem(Variables);
								variablesList.setItem(Variables,nv,"EvolutionPreconditions");
								variablesList.open();
							}
						}
						catch (Z3Exception e1)
						{
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				formToolkit.adapt(btnEvolutionPreconditionVariable, true, true);
				btnEvolutionPreconditionVariable.setText("Evolution Precondition Variable");
		
				btnEvolutionPostconditionVariables = new Button(shlConsistencyValidating, SWT.BORDER | SWT.FLAT);
				btnEvolutionPostconditionVariables.setBounds(170, 404, 171, 29);
				btnEvolutionPostconditionVariables.setVisible(false);
				btnEvolutionPostconditionVariables.addSelectionListener(new SelectionAdapter()
				{
					
					@Override
					public void widgetSelected(SelectionEvent e)
					{
						String text = tIniPostconditions.getText();
						String[] Variables = null;
						try
						{
							if (text == null || text == "")
							{
								MessageBox warn = new MessageBox(shlConsistencyValidating);
								warn.setMessage("Some variables were not set");
								warn.setText("Un-set Variable error");
								warn.open();
							}
							else
							{
								Variables = Data.getInstance().iniPost.analyzeText(Data.getInstance().ctx,text);
								Display d = Display.getDefault();
								VariableWindows variablesList = new VariableWindows(d);
								variablesList.setText("Initial Postcondition");
								//variablesList.setItem(Variables);
								variablesList.setItem(Variables,nv,"InitialPostconditions");
								variablesList.open();
							}
						}
						catch (Z3Exception e1)
						{
							e1.printStackTrace();
						}

					}
				});
				formToolkit.adapt(btnEvolutionPostconditionVariables, true, true);
				btnEvolutionPostconditionVariables.setText("Initial Postcondition Variables");
				btnInitialPostconditionVariables = new Button(shlConsistencyValidating, SWT.BORDER | SWT.FLAT);
				btnInitialPostconditionVariables.setBounds(495, 404, 192, 29);
				btnInitialPostconditionVariables.setVisible(false);
				btnInitialPostconditionVariables.addSelectionListener(new SelectionAdapter()
				{
					@Override
					public void widgetSelected(SelectionEvent e)
					{
						String text = tEvoPostconditions.getText();				
						String[] Variables;
						try
						{
							if (text == null || text == "")
							{
								MessageBox warn = new MessageBox(shlConsistencyValidating);
								warn.setMessage("Some variables were not set");
								warn.setText("Un-set Variable error");
								warn.open();
							}
							else
							{
								Variables = Data.getInstance().evoPost.analyzeText(Data.getInstance().ctx,text);
								Display d = Display.getDefault();
								VariableWindows variablesList = new VariableWindows(d);
								variablesList.setText("Evolution Postcondition");
								//variablesList.setItem(Variables);
								variablesList.setItem(Variables,nv,"EvolutionPostconditions");
								variablesList.open();
							}
						}
						catch (Z3Exception e1)
						{
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				formToolkit.adapt(btnInitialPostconditionVariables, true, true);
				btnInitialPostconditionVariables.setText("Evolution Postcondition Variables");
		
		Menu menu = new Menu(shlConsistencyValidating, SWT.BAR);
		shlConsistencyValidating.setMenuBar(menu);
		
		MenuItem mFile = new MenuItem(menu, SWT.CASCADE);
		mFile.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				 FileDialog fd = new FileDialog(shlConsistencyValidating, SWT.OPEN);
			        fd.setText("Open");
			        fd.setFilterPath("C:/");
			        String[] filterExt = { "*.xml" };
			        fd.setFilterExtensions(filterExt);
			        String selected = fd.open();
			        try {
						readfilexml(selected);
					} catch (ParserConfigurationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SAXException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
		});
				mFile.setText("File");
				
				MenuItem mntmOclfol = new MenuItem(menu, SWT.CASCADE);
				mntmOclfol.setText("Help");
		
				MenuItem miAbout = new MenuItem(menu, SWT.NONE);
				miAbout.setText("About");
				
				Group grpEvolutionModel = new Group(shlConsistencyValidating, SWT.NONE);
				grpEvolutionModel.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
				grpEvolutionModel.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_FOREGROUND));
				grpEvolutionModel.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
				grpEvolutionModel.setText("Evolution Model");
				grpEvolutionModel.setBounds(510, 42, 264, 372);
				formToolkit.adapt(grpEvolutionModel);
				formToolkit.paintBordersFor(grpEvolutionModel);
				
						tEvoInvarants = new Text(grpEvolutionModel,
								SWT.BORDER | SWT.WRAP | SWT.H_SCROLL | SWT.V_SCROLL | SWT.CANCEL | SWT.MULTI);
						tEvoInvarants.setBounds(10, 20, 233, 75);
						formToolkit.adapt(tEvoInvarants, true, true);
						
								tEvoPreconditions = new Text(grpEvolutionModel,
										SWT.BORDER | SWT.WRAP | SWT.H_SCROLL | SWT.V_SCROLL | SWT.CANCEL | SWT.MULTI);
								tEvoPreconditions.setBounds(10, 105, 233, 109);
								formToolkit.adapt(tEvoPreconditions, true, true);
														
																tEvoPostconditions = new Text(grpEvolutionModel,
																		SWT.BORDER | SWT.WRAP | SWT.H_SCROLL | SWT.V_SCROLL | SWT.CANCEL | SWT.MULTI);
																tEvoPostconditions.setBounds(10, 220, 233, 130);
																formToolkit.adapt(tEvoPostconditions, true, true);
																
																button_1 = new Button(grpEvolutionModel, SWT.BORDER | SWT.FLAT);
																button_1.setBounds(37, 82, 165, 29);
																button_1.setVisible(false);
																button_1.setText("Initial Precondition Variables");
																button_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_FOREGROUND));
																formToolkit.adapt(button_1, true, true);
				
				grpFunction = new Group(shlConsistencyValidating, SWT.NONE);
				grpFunction.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
				grpFunction.setText("Function");
				grpFunction.setBounds(10, 42, 181, 372);
				formToolkit.adapt(grpFunction);
				formToolkit.paintBordersFor(grpFunction);
				//gd_btnCheckInVariants.horizontalAlignment=183;
				//gd_btnCheckInVariants.verticalAlignment=180;
				btnCheckInVariants = new Button(grpFunction, SWT.BORDER | SWT.FLAT);
				btnCheckInVariants.setBounds(10, 31, 141, 69);
				btnCheckInVariants.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent arg0) 
					{
						String iniInvarant= tIniInvarants.getText();
						String evoInvarant = tEvoInvarants.getText();
						MessageBox r1 = new MessageBox(shlConsistencyValidating, SWT.CENTER|SWT.OK|SWT.ICON_ERROR);
						MessageBox r= new MessageBox(shlConsistencyValidating,SWT.OK|SWT.CENTER);
						r.setText("Check values");
						r1.setText("Missing values");
						if (iniInvarant.equals(evoInvarant))
						{		
							r.setMessage("Invarants is Satisfy");
							r.open();
						}
						else
						{
							r1.setMessage("Invarants is not Satisfy");
							r1.open();
						}
						
					}
				});
				formToolkit.adapt(btnCheckInVariants, true, true);
				btnCheckInVariants.setText("Check InVariants");
				
				btnCheckPreconditions =  new Button(grpFunction, SWT.BORDER | SWT.CENTER|SWT.WRAP);
				btnCheckPreconditions.setBounds(10, 131, 141, 65);
				btnCheckPreconditions.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) 
					{
						// Add for InitialPreconditions
						String item = "InitialPreconditions";
						String text = tIniPreconditions.getText();
						String[] Variablesn = new String[Data.getInstance().iniPre.analyzeText(Data.getInstance().ctx,text).length];
						String[] variableType = new String[Data.getInstance().iniPre.analyzeText(Data.getInstance().ctx,text).length];;
						
						Variablesn = Data.getInstance().iniPre.analyzeText(Data.getInstance().ctx,text);
						if (nv.getNodeType() == Node.ELEMENT_NODE) 
						{
							Element eElement = (Element) nv;
							NodeList nList = eElement.getElementsByTagName(item);
							Node nNode = nList.item(0);
							Reader r= new Reader();
							if (nNode.getNodeType() == Node.ELEMENT_NODE) 
							{
								Element eElementn = (Element) nNode;
								for (int i = 0; i < Variablesn.length; i++)
								{							
									if(r.isNumber(Variablesn[i])) 
									{
										variableType[i] = "number";
									}
									else
									{
										//System.out.println(Variablesn[i]);
										String values = eElementn.getElementsByTagName(Variablesn[i]).item(0).getTextContent();
										variableType[i] = values;
									}
								}
							}
						}
						Data.getInstance().iniPre.setVariables(Data.getInstance().ctx, variableType, Variablesn);
						// Add for EvolutionPreconditions
						String itemm = "EvolutionPreconditions";
						String textm = tEvoPreconditions.getText();
						String[] Variablesm = new String[Data.getInstance().evoPre.analyzeText(Data.getInstance().ctx,textm).length];
						String[] variableTypem = new String[Data.getInstance().evoPre.analyzeText(Data.getInstance().ctx,textm).length];;
						Variablesm = Data.getInstance().evoPre.analyzeText(Data.getInstance().ctx,textm);
						if (nv.getNodeType() == Node.ELEMENT_NODE) 
						{
							Element eElement = (Element) nv;
							NodeList nList = eElement.getElementsByTagName(itemm);
							Node nNode = nList.item(0);
							Reader r= new Reader();
							if (nNode.getNodeType() == Node.ELEMENT_NODE) 
							{
								Element eElementn = (Element) nNode;
								for (int i = 0; i < Variablesm.length; i++)
								{
									if(r.isNumber(Variablesm[i])) 
									{
										variableTypem[i] = "number";
									}
									else
									{
										String values = eElementn.getElementsByTagName(Variablesm[i]).item(0).getTextContent();
										variableTypem[i] = values;
									}
								}
							}
						}
						Data.getInstance().evoPre.setVariables(Data.getInstance().ctx, variableTypem, Variablesm);
						
						
						if(Data.getInstance().iniPre.variables==null 
								||Data.getInstance().evoPre.variables==null)
						{
							MessageBox r = new MessageBox(shlConsistencyValidating, SWT.CENTER|SWT.OK|SWT.ICON_ERROR);
							r.setText("Missing variables");
							r.setMessage("Some of variable was not set");
							r.open();
						}
						else
						{
						Expr iniPrecondition = null;
                                    try {
                                        iniPrecondition = Data.getInstance().iniPre.generateExpr(Data.getInstance().ctx);
                                    } catch (Z3Exception ex) {
                                        Logger.getLogger(Main_Window.class.getName()).log(Level.SEVERE, null, ex);
                                    }
						//Expr iniPostcondition =Data.getInstance().iniPost.generateExpr(Data.getInstance().ctx);
						Expr evoPrecondition = null;
                                    try {
                                        evoPrecondition = Data.getInstance().evoPre.generateExpr(Data.getInstance().ctx);
                                    } catch (Z3Exception ex) {
                                        Logger.getLogger(Main_Window.class.getName()).log(Level.SEVERE, null, ex);
                                    }
						//Expr evoPostcondition =Data.getInstance().evoPost.generateExpr(Data.getInstance().ctx);
						//String iniInvarant= tIniInvarants.getText();
						//String evoInvarant = tEvoInvarants.getText();
                //System.out.println(iniPrecondition);
                //System.out.println(evoPrecondition);
						boolean r = false;
                                    try {
                                        r = validator.checkPrecondition(Data.getInstance().ctx, iniPrecondition, evoPrecondition);
                                    } catch (Z3Exception ex) {
                                        Logger.getLogger(Main_Window.class.getName()).log(Level.SEVERE, null, ex);
                                    }
						MessageBox resultBox= new MessageBox(shlConsistencyValidating,SWT.OK|SWT.CENTER);
						resultBox.setText("Result");
						if(r== true)
							resultBox.setMessage("Precondition is Satisfy");
						else resultBox.setMessage("Precondition is not Satisfy");
						resultBox.open();
						}
					}
				});
				formToolkit.adapt(btnCheckPreconditions, true, true);
				btnCheckPreconditions.setText("Check Preconditions");
				
				btnCheckPostconditions = new Button(grpFunction, SWT.BORDER | SWT.CENTER);
				btnCheckPostconditions.setBounds(10, 237, 141, 69);
				btnCheckPostconditions.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) 
					{
						// Add for iniPost
						String item = "InitialPostconditions";
						String text = tIniPostconditions.getText();
						String[] Variablesn = new String[Data.getInstance().iniPost.analyzeText(Data.getInstance().ctx,text).length];
						String[] variableType = new String[Data.getInstance().iniPost.analyzeText(Data.getInstance().ctx,text).length];;
						
						Variablesn = Data.getInstance().iniPost.analyzeText(Data.getInstance().ctx,text);
						
						if (nv.getNodeType() == Node.ELEMENT_NODE) 
						{
							Element eElement = (Element) nv;
							NodeList nList = eElement.getElementsByTagName(item);
							Node nNode = nList.item(0);
							Reader r= new Reader();
							if (nNode.getNodeType() == Node.ELEMENT_NODE) 
							{
								Element eElementn = (Element) nNode;
								for (int i = 0; i < Variablesn.length; i++)
								{							
									if(r.isNumber(Variablesn[i])) 
									{
										variableType[i] = "number";
									}
									else
									{
										String values = eElementn.getElementsByTagName(Variablesn[i]).item(0).getTextContent();
										variableType[i] = values;
									}
								}
							}
						}
										
						Data.getInstance().iniPost.setVariables(Data.getInstance().ctx, variableType, Variablesn);
						
						
						
						// Add for iniPost
						String itemm = "EvolutionPostconditions";
						String textm = tEvoPostconditions.getText();
						String[] Variablesm = new String[Data.getInstance().evoPost.analyzeText(Data.getInstance().ctx,textm).length];
						String[] variableTypem = new String[Data.getInstance().evoPost.analyzeText(Data.getInstance().ctx,textm).length];;
						Variablesm = Data.getInstance().evoPost.analyzeText(Data.getInstance().ctx,textm);
						if (nv.getNodeType() == Node.ELEMENT_NODE) 
						{
							Element eElement = (Element) nv;
							NodeList nList = eElement.getElementsByTagName(itemm);
							Node nNode = nList.item(0);
							Reader r= new Reader();
							if (nNode.getNodeType() == Node.ELEMENT_NODE) 
							{
								Element eElementn = (Element) nNode;
								for (int i = 0; i < Variablesm.length; i++)
								{
									if(r.isNumber(Variablesm[i])) 
									{
										variableTypem[i] = "number";
									}
									else
									{
										String values = eElementn.getElementsByTagName(Variablesm[i]).item(0).getTextContent();
										variableTypem[i] = values;
									}
								}
							}
						}
						Data.getInstance().evoPost.setVariables(Data.getInstance().ctx, variableTypem, Variablesm);
						
						if(Data.getInstance().iniPost.variables==null 
								||Data.getInstance().evoPost.variables==null)
						{
							MessageBox r = new MessageBox(shlConsistencyValidating, SWT.CENTER|SWT.OK|SWT.ICON_ERROR);
							r.setText("Missing variables"); 
							r.setMessage("Some of variable was not set");
							r.open();
						}
						else
						{
							//System.out.println("ok");
						//Expr iniPrecondition = Data.getInstance().iniPre.generateExpr(Data.getInstance().ctx);
						Expr iniPostcondition = null;
                                    try {
                                        iniPostcondition = Data.getInstance().iniPost.generateExpr(Data.getInstance().ctx);
                                    } catch (Z3Exception ex) {
                                        Logger.getLogger(Main_Window.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                    //System.out.println("ok");
						//Expr evoPrecondition = Data.getInstance().evoPre.generateExpr(Data.getInstance().ctx);
						Expr evoPostcondition = null;
                                    try {
                                        evoPostcondition = Data.getInstance().evoPost.generateExpr(Data.getInstance().ctx);
                                    } catch (Z3Exception ex) {
                                        Logger.getLogger(Main_Window.class.getName()).log(Level.SEVERE, null, ex);
                                    }
						//String iniInvarant= tIniInvarants.getText();
						//String evoInvarant = tEvoInvarants.getText();
						int r = 0;
                                    try {
                                       // r = validator.checkPostCondition(Data.getInstance().ctx, iniPostcondition, evoPostcondition);
                                    } catch (Z3Exception ex) {
                                        Logger.getLogger(Main_Window.class.getName()).log(Level.SEVERE, null, ex);
                                    }
						MessageBox resultBox= new MessageBox(shlConsistencyValidating,SWT.OK|SWT.CENTER);
						resultBox.setText("Result");
						//System.out.print(r);
						//System.out.println("iniPostconditionn");
						//System.out.println(iniPostcondition.toString());
						//System.out.println("iniPostconditionn");
						//System.out.println(iniPostcondition.toString());
						if(r== 0)
							resultBox.setMessage("Postcondition is Equivalent");
						else if(r==1) resultBox.setMessage("Initial implies Evolution");
						else resultBox.setMessage("Postcondition not equivalent");
						resultBox.open();
						}
					}
				});
				formToolkit.adapt(btnCheckPostconditions, true, true);
				btnCheckPostconditions.setText("Check Postconditions");
				
						btnResult = new Button(grpFunction, SWT.BORDER);
						btnResult.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
						btnResult.setBounds(10, 325, 141, 37);
						btnResult.setText("Total Consistency");
						btnResult.addSelectionListener(new SelectionAdapter()
						{
							public void widgetSelected(SelectionEvent e)
							{
//				IntExpr a= ctx.mkIntConst("a");
//				IntExpr b= ctx.mkIntConst("b");
//				Solver s= ctx.mkSolver();
//				s.add(ctx.mkEq(a, b));
//				Status st= s.check();
//				if(st == Status.SATISFIABLE) 
//				{
//					MessageBox r = new MessageBox(shlConsistencyValidating,SWT.OK);
//					r.setMessage("valid");
//					r.open();
//				}
								
								if(Data.getInstance().iniPre.variables==null
										||Data.getInstance().iniPost.variables==null
										||Data.getInstance().evoPre.variables==null
										||Data.getInstance().evoPost.variables==null
										||tIniInvarants.getText()==null|| tIniInvarants.getText().length()==0
										||tEvoInvarants.getText()==null||tEvoInvarants.getText().length()==0)
								{
									MessageBox r = new MessageBox(shlConsistencyValidating, SWT.CENTER|SWT.OK|SWT.ICON_ERROR);
									r.setText("Missing variables");
									r.setMessage("Some of variable was not set");
									r.open();
									/*MessageBox resultBox= new MessageBox(shlConsistencyValidating,SWT.OK|SWT.CENTER);
									resultBox.setText("Result");
									resultBox.setMessage("Total Consistency");
									resultBox.open();*/
								}
								else
								{
								Expr iniPrecondition = null;
                                                                                    try {
                                                                                        iniPrecondition = Data.getInstance().iniPre.generateExpr(Data.getInstance().ctx);
                                                                                    } catch (Z3Exception ex) {
                                                                                        Logger.getLogger(Main_Window.class.getName()).log(Level.SEVERE, null, ex);
                                                                                    }
								Expr iniPostcondition = null;
                                                                                    try {
                                                                                        iniPostcondition = Data.getInstance().iniPost.generateExpr(Data.getInstance().ctx);
                                                                                    } catch (Z3Exception ex) {
                                                                                        Logger.getLogger(Main_Window.class.getName()).log(Level.SEVERE, null, ex);
                                                                                    }
								Expr evoPrecondition = null;
                                                                                    try {
                                                                                        evoPrecondition = Data.getInstance().evoPre.generateExpr(Data.getInstance().ctx);
                                                                                    } catch (Z3Exception ex) {
                                                                                        Logger.getLogger(Main_Window.class.getName()).log(Level.SEVERE, null, ex);
                                                                                    }
								Expr evoPostcondition = null;
                                                                                    try {
                                                                                        evoPostcondition = Data.getInstance().evoPost.generateExpr(Data.getInstance().ctx);
                                                                                    } catch (Z3Exception ex) {
                                                                                        Logger.getLogger(Main_Window.class.getName()).log(Level.SEVERE, null, ex);
                                                                                    }
								String iniInvarant= tIniInvarants.getText();
								String evoInvarant = tEvoInvarants.getText();
								//System.out.println(evoPrecondition.toString());
								//System.out.println(evoPostcondition.toString());
								Result r = null;
                                try {
                                    r = validator.validateConditions(Data.getInstance().ctx, iniInvarant, evoInvarant, iniPrecondition,evoPrecondition, iniPostcondition,  evoPostcondition);
                                } catch (Z3Exception ex) {
                                    Logger.getLogger(Main_Window.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                MessageBox resultBox= new MessageBox(shlConsistencyValidating,SWT.OK|SWT.CENTER);
                                resultBox.setText("Result");
                                switch (r)
                                {
                                	case TOTAL_CONSISTENCY:
                                		resultBox.setMessage("Total Consistency");
                                		break;
                                	case PARTIAL_CONSISTENCY:
                                		resultBox.setMessage("Partial Consistency");
                                		break;
                                	case UNCONSISTENCY:
                                		resultBox.setMessage("Unconsistency");
                                		break;
                                	default:
                                		break;
}                             resultBox.open();
								}
							}
						});
				
				grpInitialModel = new Group(shlConsistencyValidating, SWT.NONE);
				grpInitialModel.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
				grpInitialModel.setText("Initial Model");
				grpInitialModel.setBounds(209, 42, 274, 372);
				formToolkit.adapt(grpInitialModel);
				formToolkit.paintBordersFor(grpInitialModel);
										
												tIniPostconditions = new Text(grpInitialModel,
														SWT.BORDER | SWT.WRAP | SWT.H_SCROLL | SWT.V_SCROLL | SWT.CANCEL | SWT.MULTI);
												tIniPostconditions.setBounds(20, 220, 244, 130);
												formToolkit.adapt(tIniPostconditions, true, true);
												
														tIniPreconditions = new Text(grpInitialModel,
																SWT.BORDER | SWT.WRAP | SWT.H_SCROLL | SWT.V_SCROLL | SWT.CANCEL | SWT.MULTI);
														tIniPreconditions.setBounds(20, 100, 244, 107);
														formToolkit.adapt(tIniPreconditions, true, true);
														
																tIniInvarants = new Text(grpInitialModel,
																		SWT.BORDER | SWT.WRAP | SWT.H_SCROLL | SWT.V_SCROLL | SWT.CANCEL);
																tIniInvarants.setBounds(20, 23, 244, 71);
																formToolkit.adapt(tIniInvarants, true, true);
																
																button = new Button(grpInitialModel, SWT.BORDER | SWT.FLAT);
																button.setBounds(10, 70, 165, 29);
																button.setVisible(false);
																button.setText("Initial Precondition Variables");
																button.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_FOREGROUND));
																formToolkit.adapt(button, true, true);
	}
	
	public void readfilexml(String fileName) throws ParserConfigurationException, SAXException, IOException
	{
		try
		{
			File fXmlFile = new File(fileName);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			
			NodeList nList = doc.getElementsByTagName("OCL");
			Node nNode = nList.item(0);
			String[] listTmp = {"@initial_invarant: ","@initial_precondition: ","@initial_postcondition: "
					,"@evolution_invarant: ","@evolution_precondition: ","@evolution_postcondition:"};
			if (nNode.getNodeType() == Node.ELEMENT_NODE) 
			{
				Element eElement = (Element) nNode;
				tIniInvarants.setText(eElement.getElementsByTagName("InitialInvariants").item(0).getTextContent());
				tEvoInvarants.setText(eElement.getElementsByTagName("EvolutionInvariants").item(0).getTextContent());
				
				tIniPreconditions.setText(eElement.getElementsByTagName("InitialPreconditions").item(0).getTextContent());
				tEvoPreconditions.setText(eElement.getElementsByTagName("EvolutionPreconditions").item(0).getTextContent());
				
				tIniPostconditions.setText(eElement.getElementsByTagName("InitialPostconditions").item(0).getTextContent());
				tEvoPostconditions.setText(eElement.getElementsByTagName("EvolutionPostconditions").item(0).getTextContent());
			}
			NodeList nListv = doc.getElementsByTagName("Datatypes");
			//System.out.print(nListv);
			nv = nListv.item(0);
		}
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public void readfile(String fileName)
	{
		try
		{
			BufferedReader br = new BufferedReader( new FileReader(fileName));
			String currentLine= null;
			try
			{
				String[] listTmp = {"@initial_invarant: ","@initial_precondition: ","@initial_postcondition: "
						,"@evolution_invarant: ","@evolution_precondition: ","@evolution_postcondition:"};
				while((currentLine= br.readLine())!= null)
				{
					for(int i=0;i<listTmp.length;i++)
					{
						if(currentLine.contains(listTmp[i]))
						{
							String tmp = currentLine.substring(listTmp[i].length());
							switch(i)
							{
							case 0:
								tIniInvarants.setText(tmp);
								break;
							case 1:
								tIniPreconditions.setText(tmp);
								break;
							case 2:
								tIniPostconditions.setText(tmp);
								break;
							case 3:
								tEvoInvarants.setText(tmp);
								break;
							case 4:
								tEvoPreconditions.setText(tmp);
								break;
							case 5:
								tEvoPostconditions.setText(tmp);
								break;
								default: break;
							}
						}
					}
				}
			}
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

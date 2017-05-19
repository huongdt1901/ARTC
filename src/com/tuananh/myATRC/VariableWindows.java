package com.tuananh.myATRC;

//import java.awt.Dialog;
//import java.util.HashMap;
//
//import javax.swing.text.TableView.TableRow;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
//import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Table;
//import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
//import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
//import org.eclipse.ui.internal.dnd.SwtUtil;

//import com.microsoft.z3.Context;
import com.microsoft.z3.Z3Exception;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Control;
//import org.eclipse.swt.layout.RowLayout;
//import org.eclipse.swt.layout.FillLayout;
//import swing2swt.layout.FlowLayout;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Text;
import org.w3c.dom.Element;
//import org.eclipse.jface.viewers.TableViewer;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class VariableWindows extends Shell
{
	/**
	 * @uml.property  name="table"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private Table table;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String args[])
	{
		try
		{
			Display display = Display.getDefault();
			VariableWindows shell = new VariableWindows(display);
			shell.open();
			shell.layout();
			while (!shell.isDisposed())
			{
				if (!display.readAndDispatch())
				{
					display.sleep();
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Create the shell.
	 * 
	 * @param display
	 */
	public VariableWindows(Display display)
	{
		setModified(true);
		setLayout(null);

		table = new Table(this, SWT.BORDER | SWT.FULL_SELECTION | SWT.VIRTUAL | SWT.MULTI);
		table.setHeaderVisible(true);
		table.setBounds(10, 10, 414, 223);
		table.setLinesVisible(true);

		final TableEditor editor = new TableEditor(table);

		TableColumn column1 = new TableColumn(table, SWT.NONE);
		column1.setMoveable(true);
		column1.setWidth(250);
		column1.setText("Variable");
		// column1.pack();
		TableColumn column2 = new TableColumn(table, SWT.LEFT);
		column2.setMoveable(true);
		column2.setWidth(200);
		column2.setText("Type");
		// column2.pack();

		Button btnOk = new Button(this, SWT.NONE);
		btnOk.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				if (isVariableSet())
				{
					String[] variableName = new String[table.getItemCount()];
					String[] variableType = new String[table.getItemCount()];
					for(int i=0;i<table.getItemCount();i++)
					{
						variableName[i]= table.getItem(i).getText(0);
						variableType[i]=table.getItem(i).getText(1);
					}
					try
					{
				
						String tmp = getText();
						if(tmp.equals("Initial Precondition"))
						Data.getInstance().iniPre.setVariables(Data.getInstance().ctx, variableType, variableName);
						else if(tmp.equals("Initial Postcondition"))
							Data.getInstance().iniPost.setVariables(Data.getInstance().ctx, variableType, variableName);
						else if(tmp.equals("Evolution Precondition"))
							Data.getInstance().evoPre.setVariables(Data.getInstance().ctx, variableType, variableName);
						else if(tmp.equals("Evolution Postcondition"))
							Data.getInstance().evoPost.setVariables(Data.getInstance().ctx, variableType, variableName);
					}
					catch (Z3Exception e1)
					{
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					getShell().setVisible(false);
				}
				else
				{
					MessageBox warn = new MessageBox(getShell());
					warn.setMessage("Some variables were not set");
					warn.setText("Un-set Variable error");
					warn.open();
				}
			}
		});
		btnOk.setBounds(349, 237, 75, 25);
		btnOk.setText("OK");
		// The editor must have the same size as the cell and must
		// not be any smaller than 50 pixels.
		editor.horizontalAlignment = SWT.LEFT;
		editor.grabHorizontal = true;
		editor.minimumWidth = 50;
		// editing the second column
		final int EDITABLECOLUMN = 1;

		table.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				// Clean up any previous editor control
				Control oldEditor = editor.getEditor();
				if (oldEditor != null)
					oldEditor.dispose();

				// Identify the selected row
				TableItem item = (TableItem) e.item;
				if (item == null)
					return;

				// The control that will be the editor must be a child of the
				// Table
				Text newEditor = new Text(table, SWT.NONE);
				newEditor.setText(item.getText(EDITABLECOLUMN));
				newEditor.addModifyListener(me ->
				{
					Text text = (Text) editor.getEditor();
					editor.getItem().setText(EDITABLECOLUMN, text.getText());
				});
				newEditor.selectAll();
				newEditor.setFocus();
				editor.setEditor(newEditor, item, EDITABLECOLUMN);
			}
		});
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents()
	{
		setText("Setting Variables Types");
		setSize(450, 300);

	}

	@Override
	protected void checkSubclass()
	{
		// Disable the check that prevents subclassing of SWT components
	}

	public void setItem(String[] itemList)
	{

		Reader r= new Reader();
		for (int i = 0; i < itemList.length; i++)
		{
			if(r.isNumber(itemList[i])) 
			{
				TableItem tableItem = new TableItem(table, SWT.NONE);
				tableItem.setText(new String[]{itemList[i],"number"});
			}
			else
			{
			TableItem tableItem = new TableItem(table, SWT.NONE);
			tableItem.setText(itemList[i]);
			}
		}
	}
	public void setItem(String[] itemList, Node nNodev, String item)
	{
		if (nNodev.getNodeType() == Node.ELEMENT_NODE) 
		{
		Element eElement = (Element) nNodev;
		NodeList nList = eElement.getElementsByTagName(item);
		Node nNode = nList.item(0);
		Reader r= new Reader();
		if (nNode.getNodeType() == Node.ELEMENT_NODE) 
		{
		Element eElementn = (Element) nNode;
		for (int i = 0; i < itemList.length; i++)
		{
			if(r.isNumber(itemList[i])) 
			{
				TableItem tableItem = new TableItem(table, SWT.NONE);
				tableItem.setText(new String[]{itemList[i],"number"});
			}
			else
			{
				String values = eElementn.getElementsByTagName(itemList[i]).item(0).getTextContent();
			TableItem tableItem = new TableItem(table, SWT.NONE);
			tableItem.setText(new String[]{itemList[i],values});
			}
		}
		}
		}
	}

	public String[] getVariableType()
	{
		String[] tmp = new String[table.getItemCount()];
		for (int i = 0; i < table.getItemCount(); i++)
		{
			tmp[i] = table.getItem(i).getText(1);
		}
		return tmp;
	}

	public boolean isVariableSet()
	{
		for (int i = 0; i < table.getItemCount(); i++)
		{
			String tmp =table.getItem(i).getText(1); 
			if (tmp == null||tmp=="")
			{
				return false;
			}
		}
		return true;
	}
}

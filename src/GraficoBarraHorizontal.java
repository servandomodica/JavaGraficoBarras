import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class GraficoBarraHorizontal extends JFrame
{
	
private JPanel contentPane;
private JTextField tf3;
private JTextField tf1;
private JTextField tf2;
private boolean bandera=false;


public static void main(String[] args)
{
EventQueue.invokeLater(new Runnable() {
public void run() {
try {
GraficoBarraHorizontal frame = new
GraficoBarraHorizontal();
frame.setVisible(true);
} catch (Exception e) {
e.printStackTrace();
}
}
});
}


public GraficoBarraHorizontal()
{
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setBounds(100, 100, 800, 600);
contentPane = new JPanel();
contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
setContentPane(contentPane);
contentPane.setLayout(null);
JLabel lblPartido = new JLabel("Partido 1:");
lblPartido.setBounds(46, 39, 61, 14);
contentPane.add(lblPartido);
JLabel lblPartido_1 = new JLabel("Partido 2:");
lblPartido_1.setBounds(46, 69, 61, 14);
contentPane.add(lblPartido_1);
JLabel lblPartido_2 = new JLabel("Partido 3:");
lblPartido_2.setBounds(46, 103, 61, 14);
contentPane.add(lblPartido_2);
tf1 = new JTextField();
tf1.setBounds(117, 36, 86, 20);
contentPane.add(tf1);
tf1.setColumns(10);
tf2 = new JTextField();
tf2.setBounds(117, 66, 86, 20);
contentPane.add(tf2);
tf2.setColumns(10);
tf3 = new JTextField();
tf3.setBounds(117, 97, 86, 20);
contentPane.add(tf3);
tf3.setColumns(10);
JButton btnGraficar = new JButton("Graficar");
btnGraficar.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent arg0)
{
bandera=true;
repaint();
}
});
btnGraficar.setBounds(45, 138, 107, 37);
contentPane.add(btnGraficar);
}


public void paint(Graphics g)
{
	
super.paint(g);

if (bandera==true)
{
String s1=tf1.getText();
String s2=tf2.getText();
String s3=tf3.getText();
int v1=Integer.parseInt(s1);
int v2=Integer.parseInt(s2);
int v3=Integer.parseInt(s3);
int mayor=retornarMayor(v1,v2,v3);
int largo1=v1*400/mayor;
int largo2=v2*400/mayor;
int largo3=v3*400/mayor;
g.setColor(new Color(255,0,0));
g.fillRect(100,250,largo1,40);
g.drawString("Partido 1", 10, 270);
g.setColor(new Color(0,128,0));
g.fillRect(100,300,largo2,40);
g.drawString("Partido 2", 10, 320);
g.setColor(new Color(0,0,255));
g.fillRect(100,350,largo3,40);
g.drawString("Partido 3", 10, 370);
}

}


private int retornarMayor(int v1,int v2,int v3)
{
if (v1>v2 && v1>v3)
return v1;
	else
		if (v2>v3)
		return v2;
			else
				return v3;
}


}
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.IO;

namespace WindowsFormsApplication1
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }
        

        void Buscar(String texto)
		{
            int numertotal = 0;
			bool mostrado;
			int i;
			StreamReader lee = new StreamReader("Medicamentos.txt");
			String linea = "";
			bool sw = false;
			while((lee.Peek() != (-1)) && (sw==false))
			{
				i=0;
				mostrado= false;
				linea = lee.ReadLine();
			String[] vec = linea.Split(';');
				int n= vec[0].Length-texto.Length;
				if (n >= 0)
				{
					while(i < n+1 && mostrado == false)//for (int i = 0; i < n+1; i++)
					{
						if (texto == vec[0].Substring(i,texto.Length))
						{
							MostrarLista(vec[0]);
                            numertotal += 1;
							mostrado= true;
						}
						i++;
					}
					
				}
			}
			lee.Close();
            label1.Text = numertotal.ToString();
		}

        void MostrarLista(String cad){

			listBox1.Items.Add(cad);

		}

        private void button1_Click(object sender, EventArgs e)
        {
            listBox1.Items.Clear();
            Buscar(textBox1.Text);
        }





    }
}

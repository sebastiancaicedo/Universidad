#pragma once
#include<stdlib.h>
#include<time.h>

#include "Ventana.h"
#include "RegistrarJugador.h"
#include "Puntajes.h"

namespace Lab_Datos {

	using namespace System;
	using namespace System::ComponentModel;
	using namespace System::Collections;
	using namespace System::Windows::Forms;
	using namespace System::Data;
	using namespace System::Drawing;
	using namespace System::IO;
	/// <summary>
	/// Resumen de Form1
	/// </summary>
	public ref class Form1 : public System::Windows::Forms::Form
	{
	public:

		Form1(void)
		{
			InitializeComponent();
			
		}

	protected:
		/// <summary>
		/// Limpiar los recursos que se estén utilizando.
		/// </summary>
		~Form1()
		{
			if (components)
			{
				delete components;
			}
		}
	private: System::Windows::Forms::MenuStrip^  menuStrip1;
	protected: 
	private: System::Windows::Forms::ToolStripMenuItem^  menúToolStripMenuItem;
	private: System::Windows::Forms::ToolStripMenuItem^  registarJugadorToolStripMenuItem;
	private: System::Windows::Forms::GroupBox^  groupBox1;
	private: System::Windows::Forms::Button^  button1;
	private: System::Windows::Forms::ComboBox^  comboBox1;
	private: System::Windows::Forms::Label^  label1;


	private: System::Windows::Forms::Panel^  panel1;
	private: System::Windows::Forms::ComboBox^  comboBox2;
	private: System::Windows::Forms::Label^  label5;

	private: System::Windows::Forms::ComboBox^  comboBox9;
	private: System::Windows::Forms::ComboBox^  comboBox8;
	private: System::Windows::Forms::ComboBox^  comboBox7;
	private: System::Windows::Forms::ComboBox^  comboBox6;
	private: System::Windows::Forms::ComboBox^  comboBox5;
	private: System::Windows::Forms::ComboBox^  comboBox4;
	private: System::Windows::Forms::ComboBox^  comboBox3;


	private: System::Windows::Forms::PictureBox^  pictureBox3;
	private: System::Windows::Forms::PictureBox^  pictureBox2;
	private: System::Windows::Forms::ToolStripMenuItem^  verPuntajesToolStripMenuItem;


	private:
		/// <summary>
		/// Variable del diseñador requerida.
		/// </summary>
		System::ComponentModel::Container ^components;

#pragma region Windows Form Designer generated code
		/// <summary>
		/// Método necesario para admitir el Diseñador. No se puede modificar
		/// el contenido del método con el editor de código.
		/// </summary>
		void InitializeComponent(void)
		{
			System::ComponentModel::ComponentResourceManager^  resources = (gcnew System::ComponentModel::ComponentResourceManager(Form1::typeid));
			this->menuStrip1 = (gcnew System::Windows::Forms::MenuStrip());
			this->menúToolStripMenuItem = (gcnew System::Windows::Forms::ToolStripMenuItem());
			this->registarJugadorToolStripMenuItem = (gcnew System::Windows::Forms::ToolStripMenuItem());
			this->verPuntajesToolStripMenuItem = (gcnew System::Windows::Forms::ToolStripMenuItem());
			this->groupBox1 = (gcnew System::Windows::Forms::GroupBox());
			this->panel1 = (gcnew System::Windows::Forms::Panel());
			this->comboBox3 = (gcnew System::Windows::Forms::ComboBox());
			this->comboBox9 = (gcnew System::Windows::Forms::ComboBox());
			this->comboBox8 = (gcnew System::Windows::Forms::ComboBox());
			this->comboBox7 = (gcnew System::Windows::Forms::ComboBox());
			this->comboBox6 = (gcnew System::Windows::Forms::ComboBox());
			this->comboBox5 = (gcnew System::Windows::Forms::ComboBox());
			this->comboBox4 = (gcnew System::Windows::Forms::ComboBox());
			this->pictureBox3 = (gcnew System::Windows::Forms::PictureBox());
			this->comboBox2 = (gcnew System::Windows::Forms::ComboBox());
			this->label5 = (gcnew System::Windows::Forms::Label());
			this->button1 = (gcnew System::Windows::Forms::Button());
			this->comboBox1 = (gcnew System::Windows::Forms::ComboBox());
			this->label1 = (gcnew System::Windows::Forms::Label());
			this->pictureBox2 = (gcnew System::Windows::Forms::PictureBox());
			this->menuStrip1->SuspendLayout();
			this->groupBox1->SuspendLayout();
			this->panel1->SuspendLayout();
			(cli::safe_cast<System::ComponentModel::ISupportInitialize^  >(this->pictureBox3))->BeginInit();
			(cli::safe_cast<System::ComponentModel::ISupportInitialize^  >(this->pictureBox2))->BeginInit();
			this->SuspendLayout();
			// 
			// menuStrip1
			// 
			this->menuStrip1->BackColor = System::Drawing::Color::DodgerBlue;
			this->menuStrip1->Items->AddRange(gcnew cli::array< System::Windows::Forms::ToolStripItem^  >(1) {this->menúToolStripMenuItem});
			this->menuStrip1->Location = System::Drawing::Point(0, 0);
			this->menuStrip1->Name = L"menuStrip1";
			this->menuStrip1->Size = System::Drawing::Size(488, 24);
			this->menuStrip1->TabIndex = 0;
			this->menuStrip1->Text = L"menuStrip1";
			// 
			// menúToolStripMenuItem
			// 
			this->menúToolStripMenuItem->DropDownItems->AddRange(gcnew cli::array< System::Windows::Forms::ToolStripItem^  >(2) {this->registarJugadorToolStripMenuItem, 
				this->verPuntajesToolStripMenuItem});
			this->menúToolStripMenuItem->Name = L"menúToolStripMenuItem";
			this->menúToolStripMenuItem->Size = System::Drawing::Size(50, 20);
			this->menúToolStripMenuItem->Text = L"Menú";
			// 
			// registarJugadorToolStripMenuItem
			// 
			this->registarJugadorToolStripMenuItem->Name = L"registarJugadorToolStripMenuItem";
			this->registarJugadorToolStripMenuItem->Size = System::Drawing::Size(161, 22);
			this->registarJugadorToolStripMenuItem->Text = L"Registar Jugador";
			this->registarJugadorToolStripMenuItem->Click += gcnew System::EventHandler(this, &Form1::registarJugadorToolStripMenuItem_Click);
			// 
			// verPuntajesToolStripMenuItem
			// 
			this->verPuntajesToolStripMenuItem->Name = L"verPuntajesToolStripMenuItem";
			this->verPuntajesToolStripMenuItem->Size = System::Drawing::Size(161, 22);
			this->verPuntajesToolStripMenuItem->Text = L"Ver Puntajes";
			this->verPuntajesToolStripMenuItem->Click += gcnew System::EventHandler(this, &Form1::verPuntajesToolStripMenuItem_Click);
			// 
			// groupBox1
			// 
			this->groupBox1->BackColor = System::Drawing::Color::LightBlue;
			this->groupBox1->Controls->Add(this->panel1);
			this->groupBox1->Controls->Add(this->comboBox2);
			this->groupBox1->Controls->Add(this->label5);
			this->groupBox1->Controls->Add(this->button1);
			this->groupBox1->Controls->Add(this->comboBox1);
			this->groupBox1->Controls->Add(this->label1);
			this->groupBox1->Controls->Add(this->pictureBox2);
			this->groupBox1->Font = (gcnew System::Drawing::Font(L"Microsoft Sans Serif", 9.75F, System::Drawing::FontStyle::Bold, System::Drawing::GraphicsUnit::Point, 
				static_cast<System::Byte>(0)));
			this->groupBox1->Location = System::Drawing::Point(30, 234);
			this->groupBox1->Name = L"groupBox1";
			this->groupBox1->Size = System::Drawing::Size(406, 318);
			this->groupBox1->TabIndex = 1;
			this->groupBox1->TabStop = false;
			this->groupBox1->Text = L"Nuevo Juego";
			// 
			// panel1
			// 
			this->panel1->Controls->Add(this->comboBox3);
			this->panel1->Controls->Add(this->comboBox9);
			this->panel1->Controls->Add(this->comboBox8);
			this->panel1->Controls->Add(this->comboBox7);
			this->panel1->Controls->Add(this->comboBox6);
			this->panel1->Controls->Add(this->comboBox5);
			this->panel1->Controls->Add(this->comboBox4);
			this->panel1->Controls->Add(this->pictureBox3);
			this->panel1->Location = System::Drawing::Point(25, 111);
			this->panel1->Name = L"panel1";
			this->panel1->Size = System::Drawing::Size(299, 132);
			this->panel1->TabIndex = 6;
			// 
			// comboBox3
			// 
			this->comboBox3->FormattingEnabled = true;
			this->comboBox3->Items->AddRange(gcnew cli::array< System::Object^  >(6) {L"----------", L"Azulejo-xy", L"Loro-HG10", L"Aguila-5000", 
				L"Gavilan-J4", L"Condor-2000"});
			this->comboBox3->Location = System::Drawing::Point(3, 8);
			this->comboBox3->Name = L"comboBox3";
			this->comboBox3->Size = System::Drawing::Size(121, 24);
			this->comboBox3->TabIndex = 1;
			// 
			// comboBox9
			// 
			this->comboBox9->FormattingEnabled = true;
			this->comboBox9->Items->AddRange(gcnew cli::array< System::Object^  >(6) {L"----------", L"Azulejo-xy", L"Loro-HG10", L"Aguila-5000", 
				L"Gavilan-J4", L"Condor-2000"});
			this->comboBox9->Location = System::Drawing::Point(148, 76);
			this->comboBox9->Name = L"comboBox9";
			this->comboBox9->Size = System::Drawing::Size(121, 24);
			this->comboBox9->TabIndex = 7;
			// 
			// comboBox8
			// 
			this->comboBox8->FormattingEnabled = true;
			this->comboBox8->Items->AddRange(gcnew cli::array< System::Object^  >(6) {L"----------", L"Azulejo-xy", L"Loro-HG10", L"Aguila-5000", 
				L"Gavilan-J4", L"Condor-2000"});
			this->comboBox8->Location = System::Drawing::Point(148, 48);
			this->comboBox8->Name = L"comboBox8";
			this->comboBox8->Size = System::Drawing::Size(121, 24);
			this->comboBox8->TabIndex = 6;
			// 
			// comboBox7
			// 
			this->comboBox7->FormattingEnabled = true;
			this->comboBox7->Items->AddRange(gcnew cli::array< System::Object^  >(6) {L"----------", L"Azulejo-xy", L"Loro-HG10", L"Aguila-5000", 
				L"Gavilan-J4", L"Condor-2000"});
			this->comboBox7->Location = System::Drawing::Point(148, 21);
			this->comboBox7->Name = L"comboBox7";
			this->comboBox7->Size = System::Drawing::Size(121, 24);
			this->comboBox7->TabIndex = 5;
			// 
			// comboBox6
			// 
			this->comboBox6->FormattingEnabled = true;
			this->comboBox6->Items->AddRange(gcnew cli::array< System::Object^  >(6) {L"----------", L"Azulejo-xy", L"Loro-HG10", L"Aguila-5000", 
				L"Gavilan-J4", L"Condor-2000"});
			this->comboBox6->Location = System::Drawing::Point(3, 89);
			this->comboBox6->Name = L"comboBox6";
			this->comboBox6->Size = System::Drawing::Size(121, 24);
			this->comboBox6->TabIndex = 4;
			// 
			// comboBox5
			// 
			this->comboBox5->FormattingEnabled = true;
			this->comboBox5->Items->AddRange(gcnew cli::array< System::Object^  >(6) {L"----------", L"Azulejo-xy", L"Loro-HG10", L"Aguila-5000", 
				L"Gavilan-J4", L"Condor-2000"});
			this->comboBox5->Location = System::Drawing::Point(3, 62);
			this->comboBox5->Name = L"comboBox5";
			this->comboBox5->Size = System::Drawing::Size(121, 24);
			this->comboBox5->TabIndex = 3;
			// 
			// comboBox4
			// 
			this->comboBox4->FormattingEnabled = true;
			this->comboBox4->Items->AddRange(gcnew cli::array< System::Object^  >(6) {L"----------", L"Azulejo-xy", L"Loro-HG10", L"Aguila-5000", 
				L"Gavilan-J4", L"Condor-2000"});
			this->comboBox4->Location = System::Drawing::Point(3, 35);
			this->comboBox4->Name = L"comboBox4";
			this->comboBox4->Size = System::Drawing::Size(121, 24);
			this->comboBox4->TabIndex = 2;
			// 
			// pictureBox3
			// 
			this->pictureBox3->Image = (cli::safe_cast<System::Drawing::Image^  >(resources->GetObject(L"pictureBox3.Image")));
			this->pictureBox3->Location = System::Drawing::Point(-19, -92);
			this->pictureBox3->Name = L"pictureBox3";
			this->pictureBox3->Size = System::Drawing::Size(394, 293);
			this->pictureBox3->SizeMode = System::Windows::Forms::PictureBoxSizeMode::StretchImage;
			this->pictureBox3->TabIndex = 7;
			this->pictureBox3->TabStop = false;
			// 
			// comboBox2
			// 
			this->comboBox2->FormattingEnabled = true;
			this->comboBox2->Items->AddRange(gcnew cli::array< System::Object^  >(2) {L"MANUAL", L"ALEATORIO"});
			this->comboBox2->Location = System::Drawing::Point(231, 84);
			this->comboBox2->Name = L"comboBox2";
			this->comboBox2->Size = System::Drawing::Size(131, 24);
			this->comboBox2->TabIndex = 5;
			this->comboBox2->SelectedIndexChanged += gcnew System::EventHandler(this, &Form1::comboBox2_SelectedIndexChanged);
			// 
			// label5
			// 
			this->label5->AutoSize = true;
			this->label5->Location = System::Drawing::Point(12, 87);
			this->label5->Name = L"label5";
			this->label5->Size = System::Drawing::Size(213, 16);
			this->label5->TabIndex = 4;
			this->label5->Text = L"Elegir los 7 Barcos de Forma:";
			// 
			// button1
			// 
			this->button1->Location = System::Drawing::Point(106, 249);
			this->button1->Name = L"button1";
			this->button1->Size = System::Drawing::Size(141, 45);
			this->button1->TabIndex = 3;
			this->button1->Text = L"button1";
			this->button1->UseVisualStyleBackColor = true;
			this->button1->Click += gcnew System::EventHandler(this, &Form1::button1_Click);
			// 
			// comboBox1
			// 
			this->comboBox1->FormattingEnabled = true;
			this->comboBox1->Items->AddRange(gcnew cli::array< System::Object^  >(1) {L"*Seleccione Jugador*"});
			this->comboBox1->Location = System::Drawing::Point(113, 39);
			this->comboBox1->Name = L"comboBox1";
			this->comboBox1->Size = System::Drawing::Size(150, 24);
			this->comboBox1->TabIndex = 2;
			this->comboBox1->Click += gcnew System::EventHandler(this, &Form1::comboBox1_Click);
			// 
			// label1
			// 
			this->label1->AutoSize = true;
			this->label1->Location = System::Drawing::Point(12, 42);
			this->label1->Name = L"label1";
			this->label1->Size = System::Drawing::Size(95, 16);
			this->label1->TabIndex = 1;
			this->label1->Text = L"Jugar Como:";
			// 
			// pictureBox2
			// 
			this->pictureBox2->Image = (cli::safe_cast<System::Drawing::Image^  >(resources->GetObject(L"pictureBox2.Image")));
			this->pictureBox2->Location = System::Drawing::Point(0, 19);
			this->pictureBox2->Name = L"pictureBox2";
			this->pictureBox2->Size = System::Drawing::Size(406, 299);
			this->pictureBox2->SizeMode = System::Windows::Forms::PictureBoxSizeMode::StretchImage;
			this->pictureBox2->TabIndex = 6;
			this->pictureBox2->TabStop = false;
			// 
			// Form1
			// 
			this->AutoScaleDimensions = System::Drawing::SizeF(6, 13);
			this->AutoScaleMode = System::Windows::Forms::AutoScaleMode::Font;
			this->BackColor = System::Drawing::Color::LightSteelBlue;
			this->BackgroundImage = (cli::safe_cast<System::Drawing::Image^  >(resources->GetObject(L"$this.BackgroundImage")));
			this->BackgroundImageLayout = System::Windows::Forms::ImageLayout::Stretch;
			this->ClientSize = System::Drawing::Size(488, 572);
			this->Controls->Add(this->groupBox1);
			this->Controls->Add(this->menuStrip1);
			this->MainMenuStrip = this->menuStrip1;
			this->Name = L"Form1";
			this->Text = L"Form1";
			this->Load += gcnew System::EventHandler(this, &Form1::Form1_Load);
			this->menuStrip1->ResumeLayout(false);
			this->menuStrip1->PerformLayout();
			this->groupBox1->ResumeLayout(false);
			this->groupBox1->PerformLayout();
			this->panel1->ResumeLayout(false);
			(cli::safe_cast<System::ComponentModel::ISupportInitialize^  >(this->pictureBox3))->EndInit();
			(cli::safe_cast<System::ComponentModel::ISupportInitialize^  >(this->pictureBox2))->EndInit();
			this->ResumeLayout(false);
			this->PerformLayout();

		}
		void EscribirArchivo(String^ archivo, String^ registro){
			StreamWriter^ esc = gcnew StreamWriter(archivo, false);//Con StreamWriter se abre el archivo en modo de escritura
			//con true se escribe sobre la ultima linea del archivo, si está vacio empieza del principio, si el archivo tiene n lineas, escribira sobre la linea n+1. Con false el archivo anterior se borra y comienza a escribir desde el principio... ruta es el nombre del archivo

			esc->WriteLine(registro);//Escribe una linea en el archivo

			esc->Close();
		}

		void cargarJugadores(String^ archivo){
			//con StreamReader se abre el archivo en modo lectura
			StreamReader^ lee = gcnew StreamReader(archivo);
			String^ linea = "";
			while(lee->Peek() != (-1)){//MQ (¬EoF)
				linea = lee->ReadLine();//Se lee una linea del archivo
				comboBox1->Items->Add(linea);
			}
			lee->Close();//Se cierra el archivo
		}

		void escogerAleatorio(){
			int num;
			String^ linea= "";
			for (int i = 0; i < 7; i++)
			{
				num=numeroAleatorio();
				if (i == 0)
				{
					if (num == 0)
					{
						linea= "Azulejo-xy";
					}
					else
						if (num == 1)
						{
							linea= "Loro-HG10";
						}
						else
							if (num == 2)
							{
								linea= "Aguila-5000";
							}
							else
								if (num == 3)
								{
									linea= "Gavilan-J4";
								}
								else
								{
									linea= "Condor-2000";
								}
				}
				else
				{
					if (num == 0)
					{
						linea= linea+";"+"Azulejo-xy";
					}
					else
						if (num == 1)
						{
							linea= linea+";"+"Loro-HG10";
						}
						else
							if (num == 2)
							{
								linea= linea+";"+"Aguila-5000";
							}
							else
								if (num == 3)
								{
									linea= linea+";"+"Gavilan-J4";
								}
								else
								{
									linea= linea+";"+"Condor-2000";
								}
				}
				
			}
			EscribirArchivo("utilizabarcos.txt",linea);

		}
		 int numeroAleatorio(){
			 return rand()%5;
		 }
#pragma endregion
	private: System::Void Form1_Load(System::Object^  sender, System::EventArgs^  e) {
				 srand(time(NULL));
				 comboBox1->SelectedIndex=0;
				 comboBox2->SelectedIndex=0;
				 comboBox3->SelectedIndex=0;
				 comboBox4->SelectedIndex=0;
				 comboBox5->SelectedIndex=0;
				 comboBox6->SelectedIndex=0;
				 comboBox7->SelectedIndex=0;
				 comboBox8->SelectedIndex=0;
				 comboBox9->SelectedIndex=0;
				 cargarJugadores("jugadores.txt");

		 }
private: System::Void comboBox2_SelectedIndexChanged(System::Object^  sender, System::EventArgs^  e) {
			 if (comboBox2->SelectedIndex == 0)
			 {
				 panel1->Visible=true;
			 }
			 else
			 {
				 panel1->Visible=false;
			 }
		 }
private: System::Void button1_Click(System::Object^  sender, System::EventArgs^  e) {
			 if (comboBox1->SelectedIndex != 0)
			 {
				 if (comboBox2->SelectedIndex == 0)
				 {
					 if (comboBox3->SelectedIndex != 0 && comboBox4->SelectedIndex != 0 && comboBox5->SelectedIndex != 0 && comboBox6->SelectedIndex != 0 && comboBox7->SelectedIndex != 0 && comboBox8->SelectedIndex != 0 && comboBox9->SelectedIndex != 0)
					 {
						EscribirArchivo("utilizabarcos.txt",comboBox3->SelectedItem+";"+comboBox4->SelectedItem+";"+comboBox5->SelectedItem+";"+comboBox6->SelectedItem+";"+comboBox7->SelectedItem+";"+comboBox8->SelectedItem+";"+comboBox9->SelectedItem);
						EscribirArchivo("usuariojugando.txt",comboBox1->SelectedItem+"");
						Ventana^ ventanaJuego= gcnew Ventana();
						ventanaJuego->ShowDialog();

					 }
					 else
					 {
						 MessageBox::Show("Por Favor Seleccione todos los barcos");
					 }
					 
				 }
				 else
				 {//Codigo de seleccion de barcos aleatorios
					 escogerAleatorio();
					 //MessageBox::Show("El modo de selección aleatorio no está Habilitado.\nEstará disponible en una futura actualización");
					 EscribirArchivo("usuariojugando.txt",comboBox1->SelectedItem+"");
					 Ventana^ ventanaJuego= gcnew Ventana();
					 ventanaJuego->ShowDialog();
				 }
			 }
			 else
			 {
				 MessageBox::Show("Por Favor Seleccione un Jugador Valido");
			 }

		 }

private: System::Void registarJugadorToolStripMenuItem_Click(System::Object^  sender, System::EventArgs^  e) {
			 RegistrarJugador^ ventanaregistrar= gcnew RegistrarJugador();
			 ventanaregistrar->ShowDialog();
		 }
private: System::Void comboBox1_Click(System::Object^  sender, System::EventArgs^  e) {
			 comboBox1->Items->Clear();
			 comboBox1->Items->Add("*Seleccione un Jugador*");
			 cargarJugadores("jugadores.txt");
		 }
private: System::Void verPuntajesToolStripMenuItem_Click(System::Object^  sender, System::EventArgs^  e) {
			 Puntajes^ ventanapuntajes= gcnew Puntajes();
			 ventanapuntajes->Show();
		 }
};
}


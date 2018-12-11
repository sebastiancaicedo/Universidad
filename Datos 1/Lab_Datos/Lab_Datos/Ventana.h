#pragma once

#include<stdlib.h>
#include<time.h>
#include<ctime>
namespace Lab_Datos {

	using namespace System;
	using namespace System::ComponentModel;
	using namespace System::Collections;
	using namespace System::Windows::Forms;
	using namespace System::Data;
	using namespace System::Drawing;
	using namespace System::IO;
	/// <summary>
	/// Resumen de Ventana
	/// </summary>

	public ref class Ventana : public System::Windows::Forms::Form
	{
	public:
		int disparos;
		array<String^ >^ utilizabarcos;
		clock_t start;

		ref struct Botes
		{
			String^ posiciones;
			array<String^>^ pos;
			String^ disparos;
			array<String^>^ disparosrec;
			Botes^ link3;
		};

		ref struct TiposBotes
		{
			String^ tipo;
			int cant;
			TiposBotes^ link1;
			Botes^ link2;
		};
		static TiposBotes^ PTRB = nullptr;

		ref struct NodoCol{
			int info;
			NodoCol^ link3;
		};

		ref struct NodoFila{

			int info;
			NodoFila^ Link1;
			NodoCol^ link2;
		};
		static NodoFila^ PTR = nullptr;
	private: System::Windows::Forms::Label^  label5;
	private: System::Windows::Forms::Label^  label6;
	private: System::Windows::Forms::Label^  label7;
	private: System::Windows::Forms::GroupBox^  groupBox1;
	private: System::Windows::Forms::Label^  label10;
	private: System::Windows::Forms::Label^  label9;
	private: System::Windows::Forms::Label^  label8;



	public: 


	public: 
		Ventana(void)
		{
			InitializeComponent();
			//
			//TODO: agregar código de constructor aquí
			//
		}

	protected:
		/// <summary>
		/// Limpiar los recursos que se estén utilizando.
		/// </summary>
		~Ventana()
		{
			if (components)
			{
				delete components;
			}
		}
	private: System::Windows::Forms::PictureBox^  pictureBox1;
	private: System::Windows::Forms::Label^  label4;
	private: System::Windows::Forms::Label^  label3;
	private: System::Windows::Forms::PictureBox^  pictureBox2;
	private: System::Windows::Forms::PictureBox^  pictureBox3;
	private: System::Windows::Forms::Label^  label1;
	private: System::Windows::Forms::Label^  label2;

	protected: 

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
			System::ComponentModel::ComponentResourceManager^  resources = (gcnew System::ComponentModel::ComponentResourceManager(Ventana::typeid));
			this->pictureBox1 = (gcnew System::Windows::Forms::PictureBox());
			this->label4 = (gcnew System::Windows::Forms::Label());
			this->label3 = (gcnew System::Windows::Forms::Label());
			this->pictureBox2 = (gcnew System::Windows::Forms::PictureBox());
			this->pictureBox3 = (gcnew System::Windows::Forms::PictureBox());
			this->label1 = (gcnew System::Windows::Forms::Label());
			this->label2 = (gcnew System::Windows::Forms::Label());
			this->label5 = (gcnew System::Windows::Forms::Label());
			this->label6 = (gcnew System::Windows::Forms::Label());
			this->label7 = (gcnew System::Windows::Forms::Label());
			this->label8 = (gcnew System::Windows::Forms::Label());
			this->groupBox1 = (gcnew System::Windows::Forms::GroupBox());
			this->label9 = (gcnew System::Windows::Forms::Label());
			this->label10 = (gcnew System::Windows::Forms::Label());
			(cli::safe_cast<System::ComponentModel::ISupportInitialize^  >(this->pictureBox1))->BeginInit();
			(cli::safe_cast<System::ComponentModel::ISupportInitialize^  >(this->pictureBox2))->BeginInit();
			(cli::safe_cast<System::ComponentModel::ISupportInitialize^  >(this->pictureBox3))->BeginInit();
			this->groupBox1->SuspendLayout();
			this->SuspendLayout();
			// 
			// pictureBox1
			// 
			this->pictureBox1->Image = (cli::safe_cast<System::Drawing::Image^  >(resources->GetObject(L"pictureBox1.Image")));
			this->pictureBox1->Location = System::Drawing::Point(0, 0);
			this->pictureBox1->Name = L"pictureBox1";
			this->pictureBox1->Size = System::Drawing::Size(509, 309);
			this->pictureBox1->SizeMode = System::Windows::Forms::PictureBoxSizeMode::AutoSize;
			this->pictureBox1->TabIndex = 0;
			this->pictureBox1->TabStop = false;
			this->pictureBox1->Click += gcnew System::EventHandler(this, &Ventana::pictureBox1_Click);
			// 
			// label4
			// 
			this->label4->AutoSize = true;
			this->label4->Font = (gcnew System::Drawing::Font(L"Microsoft Sans Serif", 9.75F, System::Drawing::FontStyle::Bold, System::Drawing::GraphicsUnit::Point, 
				static_cast<System::Byte>(0)));
			this->label4->Location = System::Drawing::Point(12, 312);
			this->label4->Name = L"label4";
			this->label4->Size = System::Drawing::Size(476, 16);
			this->label4->TabIndex = 11;
			this->label4->Text = L"1           2           3           4           5           6           7        " 
				L"   8           9       10";
			// 
			// label3
			// 
			this->label3->AutoSize = true;
			this->label3->Font = (gcnew System::Drawing::Font(L"Microsoft Sans Serif", 9.75F, System::Drawing::FontStyle::Bold, System::Drawing::GraphicsUnit::Point, 
				static_cast<System::Byte>(0)));
			this->label3->Location = System::Drawing::Point(515, 5);
			this->label3->Name = L"label3";
			this->label3->Size = System::Drawing::Size(19, 304);
			this->label3->TabIndex = 12;
			this->label3->Text = L"A\r\n\r\nB\r\n\r\nC\r\n\r\nD\r\n\r\nE\r\n\r\nF\r\n\r\nG\r\n\r\nH\r\n\r\nI\r\n\r\nJ";
			// 
			// pictureBox2
			// 
			this->pictureBox2->Image = (cli::safe_cast<System::Drawing::Image^  >(resources->GetObject(L"pictureBox2.Image")));
			this->pictureBox2->Location = System::Drawing::Point(88, 286);
			this->pictureBox2->Name = L"pictureBox2";
			this->pictureBox2->Size = System::Drawing::Size(50, 30);
			this->pictureBox2->SizeMode = System::Windows::Forms::PictureBoxSizeMode::StretchImage;
			this->pictureBox2->TabIndex = 13;
			this->pictureBox2->TabStop = false;
			// 
			// pictureBox3
			// 
			this->pictureBox3->Image = (cli::safe_cast<System::Drawing::Image^  >(resources->GetObject(L"pictureBox3.Image")));
			this->pictureBox3->Location = System::Drawing::Point(144, 286);
			this->pictureBox3->Name = L"pictureBox3";
			this->pictureBox3->Size = System::Drawing::Size(50, 30);
			this->pictureBox3->TabIndex = 14;
			this->pictureBox3->TabStop = false;
			// 
			// label1
			// 
			this->label1->AutoSize = true;
			this->label1->Location = System::Drawing::Point(700, 345);
			this->label1->Name = L"label1";
			this->label1->Size = System::Drawing::Size(26, 13);
			this->label1->TabIndex = 15;
			this->label1->Text = L"¡Hit!";
			// 
			// label2
			// 
			this->label2->AutoSize = true;
			this->label2->Location = System::Drawing::Point(643, 345);
			this->label2->Name = L"label2";
			this->label2->Size = System::Drawing::Size(29, 13);
			this->label2->TabIndex = 16;
			this->label2->Text = L"¡Fail!";
			// 
			// label5
			// 
			this->label5->AutoSize = true;
			this->label5->Font = (gcnew System::Drawing::Font(L"Microsoft Sans Serif", 15.75F, System::Drawing::FontStyle::Underline, System::Drawing::GraphicsUnit::Point, 
				static_cast<System::Byte>(0)));
			this->label5->Location = System::Drawing::Point(36, 26);
			this->label5->Name = L"label5";
			this->label5->Size = System::Drawing::Size(206, 25);
			this->label5->TabIndex = 19;
			this->label5->Text = L"Disparos Restantes:";
			// 
			// label6
			// 
			this->label6->AutoSize = true;
			this->label6->Font = (gcnew System::Drawing::Font(L"Microsoft Sans Serif", 15.75F, System::Drawing::FontStyle::Bold, System::Drawing::GraphicsUnit::Point, 
				static_cast<System::Byte>(0)));
			this->label6->Location = System::Drawing::Point(100, 70);
			this->label6->Name = L"label6";
			this->label6->Size = System::Drawing::Size(76, 25);
			this->label6->TabIndex = 20;
			this->label6->Text = L"label6";
			// 
			// label7
			// 
			this->label7->AutoSize = true;
			this->label7->Font = (gcnew System::Drawing::Font(L"Microsoft Sans Serif", 15.75F, System::Drawing::FontStyle::Underline, System::Drawing::GraphicsUnit::Point, 
				static_cast<System::Byte>(0)));
			this->label7->Location = System::Drawing::Point(56, 156);
			this->label7->Name = L"label7";
			this->label7->Size = System::Drawing::Size(176, 25);
			this->label7->TabIndex = 21;
			this->label7->Text = L"Botes Restantes:";
			// 
			// label8
			// 
			this->label8->AutoSize = true;
			this->label8->Font = (gcnew System::Drawing::Font(L"Microsoft Sans Serif", 14.25F, System::Drawing::FontStyle::Bold, System::Drawing::GraphicsUnit::Point, 
				static_cast<System::Byte>(0)));
			this->label8->Location = System::Drawing::Point(110, 201);
			this->label8->Name = L"label8";
			this->label8->Size = System::Drawing::Size(66, 24);
			this->label8->TabIndex = 22;
			this->label8->Text = L"label8";
			// 
			// groupBox1
			// 
			this->groupBox1->Controls->Add(this->label10);
			this->groupBox1->Controls->Add(this->label9);
			this->groupBox1->Controls->Add(this->label7);
			this->groupBox1->Controls->Add(this->label8);
			this->groupBox1->Controls->Add(this->pictureBox2);
			this->groupBox1->Controls->Add(this->pictureBox3);
			this->groupBox1->Controls->Add(this->label6);
			this->groupBox1->Controls->Add(this->label5);
			this->groupBox1->Location = System::Drawing::Point(540, 12);
			this->groupBox1->Name = L"groupBox1";
			this->groupBox1->Size = System::Drawing::Size(280, 382);
			this->groupBox1->TabIndex = 23;
			this->groupBox1->TabStop = false;
			this->groupBox1->Text = L"Juego";
			// 
			// label9
			// 
			this->label9->AutoSize = true;
			this->label9->Location = System::Drawing::Point(102, 320);
			this->label9->Name = L"label9";
			this->label9->Size = System::Drawing::Size(29, 13);
			this->label9->TabIndex = 23;
			this->label9->Text = L"¡Fail!";
			// 
			// label10
			// 
			this->label10->AutoSize = true;
			this->label10->Location = System::Drawing::Point(160, 320);
			this->label10->Name = L"label10";
			this->label10->Size = System::Drawing::Size(26, 13);
			this->label10->TabIndex = 24;
			this->label10->Text = L"¡Hit!";
			// 
			// Ventana
			// 
			this->AutoScaleDimensions = System::Drawing::SizeF(6, 13);
			this->AutoScaleMode = System::Windows::Forms::AutoScaleMode::Font;
			this->BackColor = System::Drawing::SystemColors::ActiveCaption;
			this->ClientSize = System::Drawing::Size(848, 405);
			this->Controls->Add(this->groupBox1);
			this->Controls->Add(this->label2);
			this->Controls->Add(this->label1);
			this->Controls->Add(this->label3);
			this->Controls->Add(this->label4);
			this->Controls->Add(this->pictureBox1);
			this->Name = L"Ventana";
			this->Text = L"Ventana";
			this->Load += gcnew System::EventHandler(this, &Ventana::Ventana_Load);
			(cli::safe_cast<System::ComponentModel::ISupportInitialize^  >(this->pictureBox1))->EndInit();
			(cli::safe_cast<System::ComponentModel::ISupportInitialize^  >(this->pictureBox2))->EndInit();
			(cli::safe_cast<System::ComponentModel::ISupportInitialize^  >(this->pictureBox3))->EndInit();
			this->groupBox1->ResumeLayout(false);
			this->groupBox1->PerformLayout();
			this->ResumeLayout(false);
			this->PerformLayout();

		}
		void crearListaTipoBotes(){
			TiposBotes^ P=gcnew TiposBotes();
			PTRB=P;
			for (int i = 0; i < 5; i++)
			{
				P->cant=0;
				TiposBotes^ Q=gcnew TiposBotes();
				if (i == 0)
				{
					P->tipo= "Azulejo-xy";
				}
				else
					if (i == 1)
					{
						P->tipo= "Loro-HG10";
					}
					else
						if (i == 2)
						{
							P->tipo= "Aguila-5000";
						}
						else
							if (i == 3)
							{
								P->tipo= "Gavilan-J4";
							}
							else
							{
								P->tipo= "Condor-2000";
							}
							if(i != 4){
								P->link1= Q;
							}
							else
							{
								P->link1=nullptr;
							}
							P->link2=nullptr;
							P=Q;
							Q=nullptr;
							delete(Q);
			}
		}

		void listarBarcos(){
			crearListaTipoBotes();
			LeerBarcos("utilizabarcos.txt");
			TiposBotes^ P=gcnew TiposBotes();
			P=PTRB;
			for (int i = 0; i < 5; i++)//5 tipos de barcos
			{
				for (int j = 0; j < 7; j++)//7 veces porque es el numero de barcos que usa el usuario
				{
					
					if(P->tipo == utilizabarcos[j])
					{
						P->cant= P->cant+1;
						Botes^ Q= gcnew Botes();
						if (P->link2 == nullptr)
						{
							P->link2=Q;
							posicionAleatoria(Q,P->tipo);
							Q->link3=nullptr;
							Q=nullptr;
							delete(Q);
						}
						else
						{
							Q=P->link2;
							while (Q->link3 != nullptr)
							{
								Q=Q->link3;
							}
							Botes^ S= gcnew Botes();
							Q->link3=S;
							posicionAleatoria(S,P->tipo);
							S->link3=nullptr;
							S=nullptr;
							delete(S);
						}
					}
				}
				P=P->link1;
			}
		}

		void posicionAleatoria(Botes^ P, String^ tipodeBarco){
			bool sw=false;
			String^ postemporales="";
			if (tipodeBarco == "Azulejo-xy")
			{
				do
				{
					String^ letra= Letra(numeroAleatorio());
					int col= numeroAleatorio();
					if (verifPosiciones(tipodeBarco,valorLetra(letra),col) == true)
					{
						asignarPosdeBarco(valorLetra(letra),col);
						P->posiciones =letra+(col+1+"");
						P->pos= P->posiciones->Split(',');
						P->disparos="8";//El 8 quiere decir que no ha sido destruido en la posicion esa, pero como es 1 solo cuadro, solo es una sola pos
						P->disparosrec= P->disparos->Split(',');//Cuando le peguen se debe cambiar a 9
						sw=true;
					}
				} while (sw == false);

			}
			else
				{
					int limite;
					if (tipodeBarco == "Loro-HG10")
					{
						limite=2;
					}
					else
						if (tipodeBarco == "Aguila-5000")
						{
							limite= 3;
						}
						else
							if (tipodeBarco == "Gavilan-J4")
							{
								limite= 4;
							}
							else
							{
								limite= 5;
							}
					do
					{
						sw=true;
						String^ letra= Letra(numeroAleatorio());
						int col= numeroAleatorio();
						postemporales="";
						int sentidobarco= HorizoVertic();
						if (limite == 2 && sentidobarco == 1 && valorLetra(letra) >= 9)//validacion que no se salga del tablero
						{
							sw= false;
						}
						else
							if (limite == 2 && sentidobarco == 0 && col >= 9)
							{
								sw= false;
							}
							else
								if (limite == 3 && sentidobarco == 1 && valorLetra(letra) >=8)
								{
									sw= false;
								}
								else
									if (limite == 3 && sentidobarco == 0 && col >= 8)
									{
										sw=false;
									}
									else
										if (limite == 4 && sentidobarco == 1 && valorLetra(letra) >= 7)
										{
											sw= false;
										}
										else
											if (limite == 4 && sentidobarco == 0 && col >= 7)
											{
												sw=false;
											}
											else
												if (limite == 5 && sentidobarco == 1 && valorLetra(letra) >= 6)
												{
													sw=false;
												}
												else
													if (limite == 5 && sentidobarco == 0 && col >= 6)
													{
														sw=false;
													}
						if (sentidobarco == 0 && sw == true)//horizontal
						{
							for (int i = 0; i < limite; i++)
							{
								if (verifPosiciones(tipodeBarco,valorLetra(letra),col+i) == false && sw == true)
								{
									sw=false;
								}
								else
								{
									if (i==0)
									{
										postemporales=letra+((col+1+i)+"");
									}
									else
									{
										postemporales= postemporales+","+(letra+((col+1+i)+""));
									}
									
								}
							}
						}
						else
						{
							for (int i = 0; i < limite; i++)
							{
								if (verifPosiciones(tipodeBarco,valorLetra(Letra(valorLetra(letra)+i)),col) == false && sw == true)
								{
									sw= false;
								}
								else
								{
									if (i == 0)
									{
										postemporales=Letra(valorLetra(letra)+i)+((col+1)+"");
									}
									else
									{
										postemporales= postemporales+","+(Letra(valorLetra(letra)+i)+((col+1)+""));
									}
								}
							}
						}
					} while (sw == false);
					P->posiciones =postemporales;
					P->pos= postemporales->Split(',');
					for (int j = 0; j < P->pos->Length; j++)
					{
						if (j == 0)
						{
							P->disparos= "8";
						}
						else
						{
							P->disparos=P->disparos+","+"8";
						}
					}
					P->disparosrec = P->disparos->Split(',');
					for (int k = 0; k < P->pos->Length; k++)
					{
						String^l= P->pos[k]->Substring(0,1);
						int c= System::Int32::Parse(P->pos[k]->Substring(1,1))-1;
						asignarPosdeBarco(valorLetra(l),c);
					}
					
				}
		}

		String^ Letra(int num){
			if(num==0)
			{
				return "A";

			}
			else
				if(num==1)
				{
					return "B";
				}
				else
					if(num==2)
					{
						return "C";
					}
					else
						if(num==3)
						{
							return "D";
						}
						else
							if(num==4)
							{
								return "E";
							}
							else
								if(num==5)
								{
									return "F";
								}
								else
									if(num==6)
									{
										return "G";
									}
									else
										if(num==7)
										{
											return "H";
											}
										else
											if(num==8)
											{
												return "I";
											}
											else
												if(num==9)
												{
													return "J";
												}
		}

		int valorLetra(String^ letra){
		if(letra=="A")
		{
			return 0;
		}
		else
			if(letra=="B")
			{
				return 1;
			}
			else
				if(letra=="C")
				{
					return 2;
				}
				else
					if(letra=="D")
					{
						return 3;
					}
					else
						if(letra=="E")
						{
							return 4;
						}
						else
							if(letra=="F")
							{
								return 5;
							}
							else
								if(letra=="G")
								{
									return 6;
								}
								else
									if(letra=="H")
									{
										return 7;
									}
									else
										if(letra=="I")
										{
											return 8;
										}
										else
											if(letra=="J")
											{
												return 9;
											}
		}

		void asignarPosdeBarco(int valorletra, int col){
			NodoFila^ P=gcnew NodoFila();
			P=PTR;
			for (int i = 0; i < valorletra; i++)
			{
				P=P->Link1;
			}
			NodoCol^ Q= gcnew NodoCol();

				if (col == 0)
				{
						P->info=1;
				}
				else
				{		
					Q=P->link2;
					for (int j = 1; j < col; j++)
					{
						Q=Q->link3;
					}
					Q->info=1;
				}
		}

		bool verifPosiciones(String^ tipodebarco,int valorletra,int col){
			NodoFila^ P=gcnew NodoFila();
			P=PTR;
			for (int i = 0; i < valorletra; i++)
			{
				P=P->Link1;
			}
			NodoCol^ Q= gcnew NodoCol();

				if (col == 0)
				{
						if (P->info == 0)
						{
							return true;
						}
						else
						{
							return false;
						}
				}
				else
				{		
					Q=P->link2;
					for (int j = 1; j < col; j++)
					{
						Q=Q->link3;
					}
						if (Q->info == 0)
						{
							return true;
						}
						else
						{
							return false;
						}
				}
		}

		int numeroAleatorio(){ 
			return rand()%10;
		}

		int HorizoVertic(){
			return rand()%2;
		}


		void LeerBarcos(String^ archivo){
			//con StreamReader se abre el archivo en modo lectura
			StreamReader^ lee = gcnew StreamReader(archivo);
			String^ linea = "";
			while(lee->Peek() != (-1)){//MQ (¬EoF)
				linea = lee->ReadLine();//Se lee una linea del archivo
				utilizabarcos= linea->Split(';');
			}
			lee->Close();//Se cierra el archivo
		}

		void EscribirArchivo(String^ archivo, String^ registro){
			StreamWriter^ esc = gcnew StreamWriter(archivo, true);//Con StreamWriter se abre el archivo en modo de escritura
			//con true se escribe sobre la ultima linea del archivo, si está vacio empieza del principio, si el archivo tiene n lineas, escribira sobre la linea n+1. Con false el archivo anterior se borra y comienza a escribir desde el principio... ruta es el nombre del archivo

			esc->WriteLine(registro);//Escribe una linea en el archivo

			esc->Close();
		}
		
		String^ cargarJugador(String^ archivo){
			//con StreamReader se abre el archivo en modo lectura
			StreamReader^ lee = gcnew StreamReader(archivo);
			String^ linea = "";
			while(lee->Peek() != (-1)){//MQ (¬EoF)
				linea = lee->ReadLine();//Se lee una linea del archivo
			}
			lee->Close();//Se cierra el archivo
			return linea;
		}

		void crearTablero(){
			NodoFila^ P=gcnew NodoFila();
			PTR=P;
			P->info=0;
			for (int i = 0; i <= 9; i++){
				NodoCol^ Q=gcnew NodoCol();
				P->link2=Q;
				Q->info=0;
				for (int j = 1; j  < 9; j ++){
					NodoCol^ S= gcnew NodoCol();
					Q->link3=S;
					S->info=0;
					Q=S;
					S=nullptr;
					delete(S);
				}
				NodoFila^ R=gcnew NodoFila();
				P->Link1=R;
				R->info=0;
				P=R;
				R=nullptr;
				delete(R);
			}
		}

		bool verifDisparo(int x,int y){
			NodoFila^ P= gcnew NodoFila();
			NodoCol^ Q= gcnew NodoCol();
			P=PTR;
			int col, fila;
			x=x-(x%50);
			col=(x/50);
			y=y-(y%30);
			fila= (y/30);
			if (fila == 0)
			{
				if (col == 0)//caso A1 fila 0 col 0
				{
					if (P->info == 0)
					{
						return false;
					}
					else
					{
						registrarDisparo((Letra(fila)+((col+1)+"")));
						return true;
					}
				}
				else//caso A(otro) fila A col otro
				{

					Q=P->link2;
					for (int k = 1; k < col; k++)
					{
						Q=Q->link3;
					}
					if (Q->info == 0)
					{
						return false;
					}
					else
					{
						registrarDisparo((Letra(fila)+((col+1)+"")));
						return true;
					}
				}
			}
			else
			{
				for (int i = 0; i < fila; i++)
				{
					P=P->Link1;
				}
				if (col == 0)
				{
					if (P->info == 0)
					{
						return false;
					}
					else
					{
						registrarDisparo((Letra(fila)+((col+1)+"")));
						return true;
					}
				}
				else
				{
					Q=P->link2;
					for (int j = 1; j < col; j++)
					{
						Q=Q->link3;
					}
					if (Q->info == 0)
					{
						return false;
					}
					else
					{
						registrarDisparo((Letra(fila)+((col+1)+"")));
						return true;
					}
				}
			}
		}

		void registrarDisparo(String^ posdisparo){
			TiposBotes^ P= gcnew TiposBotes();
			bool sw= false;
			P=PTRB;
			while (sw == false && P != nullptr)
			{
				if (P->link2 != nullptr)
				{
					Botes^ Q= gcnew Botes();
					Q=P->link2;
					while (Q != nullptr && sw == false)
					{
					
						int i=0;
						while (i < Q->pos->Length && sw==false)
						{
							if (posdisparo == Q->pos[i])
							{
								sw= true;
								Q->disparosrec[i]="9";
								if (verifDestruccionBarco(Q) == true)
								{
									P->cant=P->cant-1;
									//se borra el nodo
								}
							}
							i++;
						}
						Q=Q->link3;
					}
					P=P->link1;

				}
				else
				{
					P=P->link1;
				}
				
			}

		}

		bool verifDestruccionBarco(Botes^ P){
			for (int i = 0; i < P->disparosrec->Length; i++)
			{
				if (P->disparosrec[i] == "8")
				{
					return false;
				}
			}
			return true;
		}
		int cantidaddeBotes(){
			int x;
			TiposBotes^ P= gcnew TiposBotes();
			P=PTRB;
			for (int i = 0; i < 5; i++)
			{
				x=x+P->cant;
				P=P->link1;
				
			}
			return x;
		}

		int verifFinaldelJuego(int disparosrestantes, int barcosrestantes){
			if (barcosrestantes == 0)
			{
				return 1;//Gana el Juego
			}
			else
			{
				if (disparosrestantes == 0)
				{
					return 3;// pierde el juego
				}
				else
				{
					return 2;//continua jugando
				}
			}
		}
		void ubicarTiro(int x,int y){
			PictureBox^ p= gcnew PictureBox();
			p->Size = System::Drawing::Size(50, 30);
			if (verifDisparo(x,y) == true)
			{
				p->Image= pictureBox3->Image;
			}
			else
			{
				p->Image=pictureBox2->Image;
			}
			Controls->Add(p);
			x=x-(x%50);
			y=y-(y%30);
			y=y+y/30;//y/30+1=x
			x=x+x/50;
			p->Location = System::Drawing::Point(x, y);
			p->BringToFront();

		}
		int tiempo(){
			//clock_t start;
			int diff;
			//start = clock();
			return diff = ( std::clock() - start ) / (int)CLOCKS_PER_SEC;
		}

		
#pragma endregion
	private: System::Void pictureBox1_Click(System::Object^  sender, System::EventArgs^  e) {
				 int x = System::Windows::Forms::Control::MousePosition.X;
				 int y = System::Windows::Forms::Control::MousePosition.Y;
				 int xe = System::Windows::Forms::Control::Location.X+8;
				 int ye = System::Windows::Forms::Control::Location.Y+30;
				 int x1=x-xe;
				 int y1=y-ye;
				 ubicarTiro(x1, y1);
				 disparos=disparos-1;
				 label6->Text= disparos+"";
				 label8->Text= cantidaddeBotes()+"";
				 if (verifFinaldelJuego(disparos,cantidaddeBotes()) == 1)
				 {
					 String^ usuario= cargarJugador("usuariojugando.txt");
					 int tiempofinal=tiempo();
					 int puntos= (50-disparos)*tiempofinal;
					 MessageBox::Show("Felicidades "+usuario+" Has completado el\nJuego con una puntuacion de "+puntos+" Puntos"+ "en "+tiempofinal+" segundos");
					 EscribirArchivo("puntajes.txt",usuario+","+puntos+","+tiempofinal);
					 this->Close();
					 //Se abre otra ventana donde muestra el puntaje y la lista de los puntajes maximos
				 }
				 else
					 if (verifFinaldelJuego(disparos,cantidaddeBotes()) == 3)
					 {
						 MessageBox::Show("Te acabaste los disparos, has perdido, vuelve a intentarlo luego");
						 this->Close();
						 //se cierra la ventana
					 }
//				 MessageBox::Show((x1)+" - "+(y1));
			 }
	private: System::Void Ventana_Load(System::Object^  sender, System::EventArgs^  e) {
				 start = clock();
				 srand(time(NULL));
				 crearTablero();
				 listarBarcos();
				 disparos= 50;
				 label6->Text= disparos+"";
				 label8->Text= cantidaddeBotes()+"";
				 tiempo();

			 }
};
}

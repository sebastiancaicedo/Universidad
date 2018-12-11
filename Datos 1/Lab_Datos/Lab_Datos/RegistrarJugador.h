#pragma once

namespace Lab_Datos {

	using namespace System;
	using namespace System::ComponentModel;
	using namespace System::Collections;
	using namespace System::Windows::Forms;
	using namespace System::Data;
	using namespace System::Drawing;
	using namespace System::IO;

	/// <summary>
	/// Resumen de RegistrarJugador
	/// </summary>
	public ref class RegistrarJugador : public System::Windows::Forms::Form
	{
	public:
		RegistrarJugador(void)
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
		~RegistrarJugador()
		{
			if (components)
			{
				delete components;
			}
		}
	private: System::Windows::Forms::Label^  label1;
	private: System::Windows::Forms::TextBox^  textBox1;
	private: System::Windows::Forms::Button^  button1;


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
			System::ComponentModel::ComponentResourceManager^  resources = (gcnew System::ComponentModel::ComponentResourceManager(RegistrarJugador::typeid));
			this->label1 = (gcnew System::Windows::Forms::Label());
			this->textBox1 = (gcnew System::Windows::Forms::TextBox());
			this->button1 = (gcnew System::Windows::Forms::Button());
			this->SuspendLayout();
			// 
			// label1
			// 
			this->label1->AutoSize = true;
			this->label1->Location = System::Drawing::Point(43, 109);
			this->label1->Name = L"label1";
			this->label1->Size = System::Drawing::Size(47, 13);
			this->label1->TabIndex = 0;
			this->label1->Text = L"Nombre:";
			// 
			// textBox1
			// 
			this->textBox1->Location = System::Drawing::Point(147, 106);
			this->textBox1->Name = L"textBox1";
			this->textBox1->Size = System::Drawing::Size(100, 20);
			this->textBox1->TabIndex = 1;
			// 
			// button1
			// 
			this->button1->Location = System::Drawing::Point(171, 203);
			this->button1->Name = L"button1";
			this->button1->Size = System::Drawing::Size(99, 39);
			this->button1->TabIndex = 2;
			this->button1->Text = L"button1";
			this->button1->UseVisualStyleBackColor = true;
			this->button1->Click += gcnew System::EventHandler(this, &RegistrarJugador::button1_Click);
			// 
			// RegistrarJugador
			// 
			this->AutoScaleDimensions = System::Drawing::SizeF(6, 13);
			this->AutoScaleMode = System::Windows::Forms::AutoScaleMode::Font;
			this->BackgroundImage = (cli::safe_cast<System::Drawing::Image^  >(resources->GetObject(L"$this.BackgroundImage")));
			this->BackgroundImageLayout = System::Windows::Forms::ImageLayout::Stretch;
			this->ClientSize = System::Drawing::Size(499, 277);
			this->Controls->Add(this->button1);
			this->Controls->Add(this->textBox1);
			this->Controls->Add(this->label1);
			this->Name = L"RegistrarJugador";
			this->Text = L"RegistrarJugador";
			this->ResumeLayout(false);
			this->PerformLayout();

		}

		void EscribirArchivo(String^ archivo, String^ registro){
			StreamWriter^ esc = gcnew StreamWriter(archivo, true);//Con StreamWriter se abre el archivo en modo de escritura
			//con true se escribe sobre la ultima linea del archivo, si está vacio empieza del principio, si el archivo tiene n lineas, escribira sobre la linea n+1. Con false el archivo anterior se borra y comienza a escribir desde el principio... ruta es el nombre del archivo

			esc->WriteLine(registro);//Escribe una linea en el archivo

			esc->Close();
		}

		bool verifCampo(String^ texto){
			if (texto != "")
			{
				return true;
			}
			else
			{
				return false;
			}

		}
#pragma endregion
	private: System::Void button1_Click(System::Object^  sender, System::EventArgs^  e) {
				 String^ nombre= textBox1->Text;
				 if (verifCampo(nombre) == true)
				 {
					 EscribirArchivo("jugadores.txt",nombre);
					 this->Close();
					 MessageBox::Show("Registro de jugador "+nombre+" exitoso.");
				 }
				 else
				 {
					 MessageBox::Show("Por favor Igrese un Nombre Valido");
				 }
				 
			 }
	};
}

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
	/// Resumen de Puntajes
	/// </summary>
	public ref class Puntajes : public System::Windows::Forms::Form
	{
	public:
		Puntajes(void)
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
		~Puntajes()
		{
			if (components)
			{
				delete components;
			}
		}
	private: System::Windows::Forms::ListBox^  listBox1;
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
			this->listBox1 = (gcnew System::Windows::Forms::ListBox());
			this->SuspendLayout();
			// 
			// listBox1
			// 
			this->listBox1->FormattingEnabled = true;
			this->listBox1->Location = System::Drawing::Point(12, 54);
			this->listBox1->Name = L"listBox1";
			this->listBox1->Size = System::Drawing::Size(279, 251);
			this->listBox1->TabIndex = 0;
			// 
			// Puntajes
			// 
			this->AutoScaleDimensions = System::Drawing::SizeF(6, 13);
			this->AutoScaleMode = System::Windows::Forms::AutoScaleMode::Font;
			this->ClientSize = System::Drawing::Size(367, 334);
			this->Controls->Add(this->listBox1);
			this->Name = L"Puntajes";
			this->Text = L"Puntajes";
			this->Load += gcnew System::EventHandler(this, &Puntajes::Puntajes_Load);
			this->ResumeLayout(false);

		}

		void leerPuntajes(String^ archivo){
			array<String^ >^ cad;
			//con StreamReader se abre el archivo en modo lectura
			StreamReader^ lee = gcnew StreamReader(archivo);
			String^ linea = "";
			int i=0;
			while( i < 10 || lee->Peek() != (-1)){//MQ (¬EoF)
				linea = lee->ReadLine();//Se lee una linea del archivo
				cad= linea->Split(',');
				listBox1->Items->Add(cad[0]+".........."+cad[1]+"........."+cad[2]);
				i++;
			}
			lee->Close();//Se cierra el archivo
		}
#pragma endregion
	private: System::Void Puntajes_Load(System::Object^  sender, System::EventArgs^  e) {
				 listBox1->Items->Clear();
				 listBox1->Items->Add("NOMBRE..........PUNTAJE.........TIEMPO");
				 leerPuntajes("puntajes.txt");

			 }
	};
}

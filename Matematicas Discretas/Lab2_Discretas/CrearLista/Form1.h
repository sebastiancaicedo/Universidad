#pragma once
#include<vector>

namespace CrearLista {

	using namespace System;
	using namespace System::ComponentModel;
	using namespace System::Collections;
	using namespace System::Windows::Forms;
	using namespace System::Data;
	using namespace System::Drawing;

	/// <summary>
	/// Resumen de Form1
	/// </summary>
	public ref class Form1 : public System::Windows::Forms::Form
	{
	public:
//----------------------------------------------------------------------------------------------------------------------
		ref struct Nodo{
			String^ info;
			Nodo^ Link;
		};
		static Nodo^ PTR = nullptr;

		array<String^>^ Aristas;
		array<String^>^ Vertices;
		String^ arisarbol;
		array<String^>^ vec;
	private: System::Windows::Forms::ListBox^  listBox1;
	private: System::Windows::Forms::Label^  label3;
	private: System::Windows::Forms::ListBox^  listBox2;
	private: System::Windows::Forms::ListBox^  listBox3;
	public: 
		String^ bosque;
//----------------------------------------------------------------------------------------------------------
		Form1(void)
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
		~Form1()
		{
			if (components)
			{
				delete components;
			}
		}
	private: System::Windows::Forms::Label^  label1;
	protected: 
	private: System::Windows::Forms::TextBox^  textBox1;
	private: System::Windows::Forms::Label^  label2;
	private: System::Windows::Forms::TextBox^  textBox2;
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
			this->label1 = (gcnew System::Windows::Forms::Label());
			this->textBox1 = (gcnew System::Windows::Forms::TextBox());
			this->label2 = (gcnew System::Windows::Forms::Label());
			this->textBox2 = (gcnew System::Windows::Forms::TextBox());
			this->button1 = (gcnew System::Windows::Forms::Button());
			this->listBox1 = (gcnew System::Windows::Forms::ListBox());
			this->label3 = (gcnew System::Windows::Forms::Label());
			this->listBox2 = (gcnew System::Windows::Forms::ListBox());
			this->listBox3 = (gcnew System::Windows::Forms::ListBox());
			this->SuspendLayout();
			// 
			// label1
			// 
			this->label1->AutoSize = true;
			this->label1->Location = System::Drawing::Point(20, 44);
			this->label1->Name = L"label1";
			this->label1->Size = System::Drawing::Size(48, 13);
			this->label1->TabIndex = 0;
			this->label1->Text = L"Vertices:";
			// 
			// textBox1
			// 
			this->textBox1->Location = System::Drawing::Point(23, 60);
			this->textBox1->Name = L"textBox1";
			this->textBox1->Size = System::Drawing::Size(100, 20);
			this->textBox1->TabIndex = 1;
			// 
			// label2
			// 
			this->label2->AutoSize = true;
			this->label2->Location = System::Drawing::Point(20, 86);
			this->label2->Name = L"label2";
			this->label2->Size = System::Drawing::Size(41, 13);
			this->label2->TabIndex = 2;
			this->label2->Text = L"Aristas:";
			// 
			// textBox2
			// 
			this->textBox2->Location = System::Drawing::Point(23, 102);
			this->textBox2->Name = L"textBox2";
			this->textBox2->Size = System::Drawing::Size(100, 20);
			this->textBox2->TabIndex = 3;
			// 
			// button1
			// 
			this->button1->Location = System::Drawing::Point(239, 60);
			this->button1->Name = L"button1";
			this->button1->Size = System::Drawing::Size(75, 23);
			this->button1->TabIndex = 4;
			this->button1->Text = L"button1";
			this->button1->UseVisualStyleBackColor = true;
			this->button1->Click += gcnew System::EventHandler(this, &Form1::button1_Click);
			// 
			// listBox1
			// 
			this->listBox1->FormattingEnabled = true;
			this->listBox1->Location = System::Drawing::Point(224, 155);
			this->listBox1->Name = L"listBox1";
			this->listBox1->Size = System::Drawing::Size(134, 173);
			this->listBox1->TabIndex = 5;
			// 
			// label3
			// 
			this->label3->AutoSize = true;
			this->label3->Location = System::Drawing::Point(270, 139);
			this->label3->Name = L"label3";
			this->label3->Size = System::Drawing::Size(31, 13);
			this->label3->TabIndex = 6;
			this->label3->Text = L"Árbol";
			// 
			// listBox2
			// 
			this->listBox2->FormattingEnabled = true;
			this->listBox2->Location = System::Drawing::Point(12, 155);
			this->listBox2->Name = L"listBox2";
			this->listBox2->Size = System::Drawing::Size(86, 121);
			this->listBox2->TabIndex = 7;
			// 
			// listBox3
			// 
			this->listBox3->FormattingEnabled = true;
			this->listBox3->Location = System::Drawing::Point(115, 155);
			this->listBox3->Name = L"listBox3";
			this->listBox3->Size = System::Drawing::Size(103, 121);
			this->listBox3->TabIndex = 8;
			// 
			// Form1
			// 
			this->AutoScaleDimensions = System::Drawing::SizeF(6, 13);
			this->AutoScaleMode = System::Windows::Forms::AutoScaleMode::Font;
			this->ClientSize = System::Drawing::Size(406, 340);
			this->Controls->Add(this->listBox3);
			this->Controls->Add(this->listBox2);
			this->Controls->Add(this->label3);
			this->Controls->Add(this->listBox1);
			this->Controls->Add(this->button1);
			this->Controls->Add(this->textBox2);
			this->Controls->Add(this->label2);
			this->Controls->Add(this->textBox1);
			this->Controls->Add(this->label1);
			this->Name = L"Form1";
			this->Text = L"Form1";
			this->ResumeLayout(false);
			this->PerformLayout();

		}
		
//----------------------------------------------------------------------------------------------

		//void Arbol(){
		//	int i;
		//	String^ aux;
		//	bosque=Vertices[0];
		//	for(i=1;i< Vertices->Length;i++){
		//			bosque=bosque+","+Vertices[i];
		//	}
		//		for(int j=0;j< Aristas->Length;j++){
		//			int p=PosicionEnelBosque(bosque,Aristas[j]->Substring(0,1));
		//			int q=PosicionEnelBosque(bosque,Aristas[j]->Substring(1,1));
		//			if(p != q ){
		//					if(p==0 || q==0){
		//						if(q==0){
		//							if(bosque->Split(',')[p]->Length>1){
		//								if(bosque->Split(',')[q]->Length>1){
		//									aux=bosque->Split(',')[0]+bosque->Split(',')[p]+Aristas[j]->Substring(0,1)+Aristas[j]->Substring(1,1);
		//								}else{
		//									aux=bosque->Split(',')[p]+Aristas[j]->Substring(0,1)+Aristas[j]->Substring(1,1);
		//								}
		//							}else{
		//								if(bosque->Split(',')[q]->Length>1){
		//									aux=bosque->Split(',')[0]+Aristas[j]->Substring(0,1)+Aristas[j]->Substring(1,1);
		//								}else{
		//									aux=Aristas[j]->Substring(0,1)+Aristas[j]->Substring(1,1);
		//								}
		//							}
		//						}
		//						if(p==0){
		//							if(bosque->Split(',')[q]->Length>1){
		//								if(bosque->Split(',')[p]->Length>1){
		//									aux=bosque->Split(',')[0]+bosque->Split(',')[q]+Aristas[j]->Substring(0,1)+Aristas[j]->Substring(1,1);
		//								}else{
		//									aux=bosque->Split(',')[q]+Aristas[j]->Substring(0,1)+Aristas[j]->Substring(1,1);
		//								}
		//							}else{
		//								if(bosque->Split(',')[p]->Length>1){
		//									aux=bosque->Split(',')[0]+Aristas[j]->Substring(0,1)+Aristas[j]->Substring(1,1);
		//								}else{
		//									aux=Aristas[j]->Substring(0,1)+Aristas[j]->Substring(1,1);
		//								}
		//							}
		//						}

		//						for(int k=1; k< bosque->Split(',')->Length;k++){//mirar si es 0 o es 1
		//							if(k!=p && k!=q){
		//							aux=aux+","+bosque->Split(',')[k];
		//							}
		//						}
		//						}else{
		//							if(p>q){ //caso 1
		//								aux=bosque->Split(',')[0];
		//								for(int l=1; l<q;l++){ //resisar si es l<q-1
		//									aux=aux+","+bosque->Split(',')[l]; //revisar si el aux se ve afectado por el si j==0
		//								}
		//								if(bosque->Split(',')[p]->Length>1){
		//									if(bosque->Split(',')[q]->Length>1){
		//										aux=aux+","+bosque->Split(',')[q]+bosque->Split(',')[p]+Aristas[j]->Substring(0,1)+Aristas[j]->Substring(1,1);
		//									}else{
		//									aux=aux+","+bosque->Split(',')[p]+Aristas[j]->Substring(0,1)+Aristas[j]->Substring(1,1);
		//									}
		//								}else{
		//									if(bosque->Split(',')[q]->Length>1){
		//										aux=aux+","+bosque->Split(',')[q]+Aristas[j]->Substring(0,1)+Aristas[j]->Substring(1,1);
		//									}else{
		//									aux=aux+","+Aristas[j]->Substring(0,1)+Aristas[j]->Substring(1,1);
		//									}
		//								}
		//									for(int l=q+1;l< bosque->Split(',')->Length;l++){
		//										if(l!=p){
		//											aux=aux+","+bosque->Split(',')[l];
		//										}
		//									}
		//							}

		//							if(q>p){ //caso 2
		//								aux=bosque->Split(',')[0];
		//								for(int l=1; l<p;l++){ //resisar si es l<q-1
		//									aux=aux+","+bosque->Split(',')[l]; //revisar si el aux se ve afectado por el si j==0
		//								}
		//								if(bosque->Split(',')[q]->Length>1){
		//									if(bosque->Split(',')[p]->Length>1){
		//										aux=aux+","+bosque->Split(',')[p]+bosque->Split(',')[q]+Aristas[j]->Substring(0,1)+Aristas[j]->Substring(1,1);
		//									}else{
		//									aux=aux+","+bosque->Split(',')[q]+Aristas[j]->Substring(0,1)+Aristas[j]->Substring(1,1);
		//									}
		//								}else{
		//									if(bosque->Split(',')[p]->Length>1){
		//										aux=aux+","+Aristas[j]->Substring(0,1)+Aristas[j]->Substring(1,1);
		//									}
		//									aux=aux+","+bosque->Split(',')[p]+Aristas[j]->Substring(0,1)+Aristas[j]->Substring(1,1);
		//								}
		//									for(int l=p+1;l< bosque->Split(',')->Length;l++){
		//										if(l!=q){
		//											aux=aux+","+bosque->Split(',')[l];
		//										}
		//									}
		//							}

		//						}
		//				bosque=aux;
		//			}

		//	}
		//}

		//int PosicionEnelBosque(String^ bosque,String^ vertice){
		//	
		//	array<String^>^ arraybosque= bosque->Split(',');
		//	for(int i=0;i < bosque->Split(',')->Length;i++){

		//		for(int j=0;j < bosque->Split(',')[i]->Length;j++){
		//			if(bosque->Split(',')[i]->Substring(j,1) == vertice){
		//				return i;
		//			}
		//		}
		//	}
		//}

		//int Conjunto(String^ conj, String^ vertice){
		//	for(int j=0;j<2;j++){
		//		for(int k=0;k<conj->Split(',')[j]->Length;k++){
		//			if(conj->Split(',')[j]->Substring(k,1)== vertice){
		//				return j;
		//			}
		//		}
		//	}
		//}

		//bool existencia(String^ conj, String^ vertice){
		//	for(int j=0;j<2;j++){
		//		for(int i=0;i<conj->Split(',')[j]->Length; i++){
		//			if(conj->Split(',')[j]->Substring(i,1)== vertice){
		//				return true;
		//			}
		//		}
		//	}
		//	return false;
		//}

		//bool Bipartidad(){
		//	//String^ auxiAris;
		//	int a,b, indPrimerNoAparece=0;
		//	bool sw=true;
		//	bool sw1=true;
		//	conjuntos=Aristas[0]->Substring(0,1)+","+Aristas[0]->Substring(1,1);
		//	//for(int i=1;i<Aristas->Length; i++){
		//	int i=1;
		//	while(i<Aristas->Length){
		//		if(existencia(conjuntos, Aristas[i]->Substring(0,1))==true){// si de la arista existe el primer vertice en los conjuntos (1)
		//			a=Conjunto(conjuntos, Aristas[i]->Substring(0,1));
		//			if(existencia(conjuntos, Aristas[i]->Substring(1,1))==true){// (1) y ademas existe el segundo vertice en los conjuntos 
		//				b=Conjunto(conjuntos, Aristas[i]->Substring(1,1));
		//				if(a==b){  // si ambos vertices de la arista estan en el mismo conjunto no es bipartido 
		//					return false;
		//				}
		//			}else{// (1) y si no existe el segundo vertice en los conjuntos
		//				if(a==0){ // si el primer vertice esta en el conjunto 1, el segundo vertice se coloca en el conjunto 2
		//					conjuntos=conjuntos+Aristas[i]->Substring(1,1);
		//				}else{//si el primer vertice esta en el conjunto 2, el segundo vertice se coloca en el conjunto 1
		//					conjuntos=Aristas[i]->Substring(1,1)+conjuntos;
		//				}
		//			}
		//		}else{//si de la arista no existe el primer vertice en el los conjuntos (2)
		//			if(existencia(conjuntos, Aristas[i]->Substring(1,1))==true){ // (2) pero si existe el segundo vertice en los conjuntos
		//				b=Conjunto(conjuntos, Aristas[i]->Substring(1,1));
		//				if(b=0){//si el segundo vertice esta en el conjunto 1, el primer vertice se coloca en el conjunto 2
		//					conjuntos=conjuntos+Aristas[i]->Substring(0,1);
		//				}else{//si el segundo vertice esta en el conjunto 2, el primer vertice se coloca en el conjunto 1
		//					conjuntos=Aristas[i]->Substring(0,1)+conjuntos;
		//				}
		//			}else{// si no existe ninguno de los vertices de la arista en los conjuntos, pero ya hay elementos 
		//				sw1=false;
		//				if(indPrimerNoAparece==0){
		//				indPrimerNoAparece=i;
		//				}
		//			}
		//		}
		//		i++;
		//		if(sw1==false && i==Aristas->Length){
		//			i=indPrimerNoAparece;
		//			sw1=true;
		//		}
		//	}
		//	return sw;
		//}

		void OrdenarVertArist(){
			for(int i=0;i<Aristas->Length;i++){
				if(Indice(Aristas[i]->Substring(0,1)) > Indice(Aristas[i]->Substring(1,1))){
					Aristas[i]= Aristas[i]->Substring(1,1)+Aristas[i]->Substring(0,1);
				}
			}
		}

		int Indice(String^ vertice){
			for(int i=0;i<Vertices->Length;i++){
				if(vertice == Vertices[i]){
					return i;
				}
			}
		}

		void OrdenarAristas(){
			String^ aux;
			for(int i=1; i<Aristas->Length; i++){
				for(int j=0 ; j<Aristas->Length - 1; j++){
					if (Indice(Aristas[j]->Substring(0,1)) > Indice(Aristas[j+1]->Substring(0,1))){
						aux = Aristas[j];
						Aristas[j] = Aristas[j+1];
						Aristas[j+1] = aux;
					}
					else
						if(Indice(Aristas[j]->Substring(0,1)) == Indice(Aristas[j+1]->Substring(0,1))){
							if(Indice(Aristas[j]->Substring(1,1)) > Indice(Aristas[j+1]->Substring(1,1))){
								aux = Aristas[j];
								Aristas[j] = Aristas[j+1];
								Aristas[j+1] = aux;
							}
						}
				}
			}
			
		}



		int PosicionEnelBosque(String^ bosque,String^ vertice){

			array<String^>^ arraybosque= bosque->Split(',');
			for(int i=0;i < bosque->Split(',')->Length;i++){
				array<String^>^ arrayarboles = arraybosque[i]->Split(' ');
				for(int j=0;j < arrayarboles->Length-1;j++){
					if(arrayarboles[j] == vertice){
						return i;
					}
				}
			}
		}


/*		void Arbol(){
			int i;
			String^ aux;
			bosque=Vertices[0]+" ";
			for(i=1;i< Vertices->Length;i++){
				bosque=bosque+","+Vertices[i]+" ";
			}
			for(int j=0;j< Aristas->Length;j++){
				int p=PosicionEnelBosque(bosque,Aristas[j]->Substring(0,1));
				int q=PosicionEnelBosque(bosque,Aristas[j]->Substring(1,1));
				if(p != q ){ 
					if(j==0){
						aux= Aristas[j]->Substring(0,1)+" "+Aristas[j]->Substring(1,1)+" ";
					}
					else
					{ 
						aux=bosque->Split(',')[0]+Aristas[j]->Substring(0,1)+" "+Aristas[j]->Substring(1,1)+" ";
					} 
					for(int k=1; k< bosque->Split(',')->Length;k++){ 
						if(k!=p && k!=q){
							aux=aux+","+bosque->Split(',')[k]; 
						} 			
					}
					bosque=aux;
				} 
			} 
	}*/

		void MostrarArbol(){
			listBox1->Items->Clear();
			array<String^>^ vec= bosque->Split(' ');
			for(int i=0;i< vec->Length-1;i=i+2){
				listBox1->Items->Add(vec[i]+vec[i+1]);
			}
		}


		void ConjuntoVertices(){
			String^ v1=Vertices[0];
			String^ v2= "";
			int j=0;
			int i=0;
			while(j < Vertices->Length){
				if(v1->Substring(i,1) != Vertices[j]){
					if(VerifExist(v1,v2,Vertices[j])== false){
						if(VerifAdyacencia(v1->Substring(i,1),Vertices[j]) == true){
							if(v2 == ""){
								v2=Vertices[j];
							}
							else
							{
								v2= v2+","+Vertices[j];
							}
						}
						else
						{
							v1=v1+","+Vertices[j];
							i=i+2;
							j=-1;
						}
					}
				}
				j++;
			}
			listBox2->Items->Add(v1);
			listBox3->Items->Add(v2);
		}
		bool VerifExist(String^ v1,String^ v2, String^ vertice){
			for(int i=0;i<v1->Split(',')->Length;i++){
				if(vertice == v1->Split(',')[i]){
					return true;
				}
			}
			for(int j=0;j<v2->Split(',')->Length;j++){
				if(vertice == v2->Split(',')[j]){
					return true;
				}
			}
			return false;
		}

		bool VerifAdyacencia(String^ vertice1,String^ vertice2){
			for(int i=0;i<Aristas->Length;i++){
				if(vertice1 == Aristas[i]->Substring(0,1) || vertice1 == Aristas[i]->Substring(1,1)){
						if(vertice2 == Aristas[i]->Substring(1,1) || vertice2 == Aristas[i]->Substring(0,1)){
							return true;
						}
				}
			}
			return false;
		}

/*		int PosicionEnelBosque(String^ bosque,String^ vertice){
			array<String^>^ arraybosque= bosque->Split(',');
			for(int i=0;i < arraybosque->Length;i++){
				for(int j=0;j < arraybosque[i]->Length;j++){
					if(arraybosque[i]->Substring(j,1) == vertice){
						return i;
					}
				}
			}
		}*/

		void Arbol(){
			int i; String^ aux;
			bosque=Vertices[0];
			for(i=1;i< Vertices->Length;i++){
				bosque=bosque+","+Vertices[i];
			} 
			for(int j=0;j< Aristas->Length;j++){
				int p=PosicionEnelBosque(bosque,Aristas[j]->Substring(0,1));
				int q=PosicionEnelBosque(bosque,Aristas[j]->Substring(1,1)); 
				if(p != q ){
					if(p==0 || q==0){
						if(q==0){
							if(bosque->Split(',')[p]->Length>1){
								if(bosque->Split(',')[q]->Length>1){
									aux=bosque->Split(',')[0]+bosque->Split(',')[p]+Aristas[j]->Substring(0,1)+Aristas[j]->Substring(1,1);
								}
								else
								{ 
									aux=bosque->Split(',')[p]+Aristas[j]->Substring(0,1)+Aristas[j]->Substring(1,1);
								}
							}
							else
							{
								if(bosque->Split(',')[q]->Length>1){
									aux=bosque->Split(',')[0]+Aristas[j]->Substring(0,1)+Aristas[j]->Substring(1,1);
								}else{ aux=Aristas[j]->Substring(0,1)+Aristas[j]->Substring(1,1);
								}
							} 
						} 
						if(p==0){ 
							if(bosque->Split(',')[q]->Length>1){
								if(bosque->Split(',')[p]->Length>1){
									aux=bosque->Split(',')[0]+bosque->Split(',')[q]+Aristas[j]->Substring(0,1)+Aristas[j]->Substring(1,1);
								}
								else
								{
									aux=bosque->Split(',')[q]+Aristas[j]->Substring(0,1)+Aristas[j]->Substring(1,1);
								} 
							}
							else
							{
								if(bosque->Split(',')[p]->Length>1){ aux=bosque->Split(',')[0]+Aristas[j]->Substring(0,1)+Aristas[j]->Substring(1,1);
								}
								else
								{
									aux=Aristas[j]->Substring(0,1)+Aristas[j]->Substring(1,1);
								}
							} 
						} for(int k=1; k< bosque->Split(',')->Length;k++){
							//mirar si es 0 o es 1 
							if(k!=p && k!=q){ aux=aux+","+bosque->Split(',')[k];
							}
						}
					}
					else
					{
						if(p>q){
							//caso 1
							aux=bosque->Split(',')[0];
							for(int l=1; l<q;l++){
								//resisar si es l<q-1 
								aux=aux+","+bosque->Split(',')[l];
								//revisar si el aux se ve afectado por el si j==0 
							} if(bosque->Split(',')[p]->Length>1){
								if(bosque->Split(',')[q]->Length>1){
									aux=aux+","+bosque->Split(',')[q]+bosque->Split(',')[p]+Aristas[j]->Substring(0,1)+Aristas[j]->Substring(1,1);
								}
								else
								{
									aux=aux+","+bosque->Split(',')[p]+Aristas[j]->Substring(0,1)+Aristas[j]->Substring(1,1);
								}
							}
							else
							{
								if(bosque->Split(',')[q]->Length>1){
									aux=aux+","+bosque->Split(',')[q]+Aristas[j]->Substring(0,1)+Aristas[j]->Substring(1,1);
								}
								else
								{ 
									aux=aux+","+Aristas[j]->Substring(0,1)+Aristas[j]->Substring(1,1); 
								}
							}
							for(int l=q+1;l< bosque->Split(',')->Length;l++){
								if(l!=p){ aux=aux+","+bosque->Split(',')[l];
								} 
							} 
						} if(q>p){ 
							//caso 2
							aux=bosque->Split(',')[0];
							for(int l=1; l<p;l++){
								//resisar si es l<q-1
								aux=aux+","+bosque->Split(',')[l];
								//revisar si el aux se ve afectado por el si j==0
							} 
							if(bosque->Split(',')[q]->Length>1){
								if(bosque->Split(',')[p]->Length>1){
									aux=aux+","+bosque->Split(',')[p]+bosque->Split(',')[q]+Aristas[j]->Substring(0,1)+Aristas[j]->Substring(1,1);
								}
								else
								{
									aux=aux+","+bosque->Split(',')[q]+Aristas[j]->Substring(0,1)+Aristas[j]->Substring(1,1);
								} 
							}
							else
							{
								if(bosque->Split(',')[p]->Length>1){
									aux=aux+","+Aristas[j]->Substring(0,1)+Aristas[j]->Substring(1,1);
								} aux=aux+","+bosque->Split(',')[p]+Aristas[j]->Substring(0,1)+Aristas[j]->Substring(1,1);
							}
							for(int l=p+1;l< bosque->Split(',')->Length;l++){
								if(l!=q){
									aux=aux+","+bosque->Split(',')[l];
								}
							} 
						}
 } 
 bosque=aux; 
} 
} 
}
//-----------------------------------------------------------------------------------------------
#pragma endregion
private: System::Void button1_Click(System::Object^  sender, System::EventArgs^  e) {
			 Vertices= textBox1->Text->Split(' ');
			 Aristas= textBox2->Text->Split(' ');
			 OrdenarVertArist();
			 OrdenarAristas();
			 ConjuntoVertices();
			// Arbol();
		//	 MostrarArbol();

			 /*Vertices= textBox1->Text->Split(' ');
			 Aristas= textBox2->Text->Split(' ');
			 Arbol();
			 label1->Text= bosque;
			 if(Bipartidad()==true){
				 label3->Text = "El grafo es bipartido: "+conjuntos;
			 }else{
				 label3->Text = "El grafo no es bipartido";
			 }*/
		 }
};
}


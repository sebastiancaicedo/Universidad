#include "stdafx.h"
#include "lector_escritor.h"


lector_escritor::lector_escritor(void)
{
			void Escribir(String^ ruta, String^ registro){
			StreamWriter^ esc = gcnew StreamWriter(ruta, true);//Con StreamWriter se abre el archivo en modo de escritura
			//con true se escribe sobre la ultima linea del archivo, si está vacio empieza del principio, si el archivo tiene n lineas, escribira sobre la linea n+1. Con false el archivo anterior se borra y comienza a escribir desde el principio... ruta es el nombre del archivo

			esc->WriteLine(registro);//Escribe una linea en el archivo

			esc->Close();
		}

		void Leer(String^ ruta, ListBox^ listbox){
			//con StreamReader se abre el archivo en modo lectura
			StreamReader^ lee = gcnew StreamReader(ruta);
			String^ linea = "";
			listbox->Items->Clear();

			while(lee->Peek() != (-1)){//MQ (¬EoF)
				linea = lee->ReadLine();//Se lee una linea del archivo
				listbox->Items->Add(linea);
			}
			lee->Close();//Se cierra el archivo
		}
}

import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Persona } from '../Model/Persona';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  Url = 'http://localhost:8080/api';

  constructor(private http: HttpClient) { }

  getPersonas() {
    return this.http.get(`${this.Url}/clientes`);
  }

  getPersonaId(id: string) {
    return this.http.get(`${this.Url}/clientes/${id}`);
  }

  deletePersona(id: number) {
    return this.http.delete(`${this.Url}/clientes/${id}`);
  }

  createPersona(persona: Persona) {
    return this.http.post(`${this.Url}/clientes`, persona);
  }

  updatePersona(id: string | number, updatePersona: Persona) {
    return this.http.put(`${this.Url}/clientes/${id}`, updatePersona);
  }
}

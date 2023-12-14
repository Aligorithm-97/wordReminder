import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { WordModel } from './api/models/word-model';

@Injectable({
  providedIn: 'root'
})
export class WordService {
  private baseUrl = 'http://localhost:8080/api/v1/word/getAll';
  constructor(private http:HttpClient) {
   }

   getAllWords() {
    const wordUrl = `${this.baseUrl}`;
    return this.http.get<Array<WordModel>>(wordUrl);
  }
}

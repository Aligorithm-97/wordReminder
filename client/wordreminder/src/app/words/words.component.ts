import { CommonModule } from '@angular/common';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Component,  OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { WordService } from '../services/word.service';
import { WordModel } from '../services/api/models/word-model';
@Component({
  selector: 'app-words',
  standalone: true,
  imports: [FormsModule,CommonModule,HttpClientModule],
  templateUrl: './words.component.html',
  styleUrl: './words.component.scss'
})
export class WordsComponent implements OnInit{
  name:string="";
  email:string="";
  isSubmitted:boolean=false;
  words: Array<WordModel> = [];
  constructor(private http:HttpClient,private service:WordService){
    
  }
  ngOnInit(): void {
    this.service.getAllWords()
    .subscribe({
      next: (result: WordModel[]) => {
        this.words = result;
        console.log(result)
      }
    });
  }
  onSubmit() {
    console.log(this.name,this.email)
    this.isSubmitted=true
    this.http.post("http://localhost:8080/api/v1/word/add",{
      word:this.name,
      meaningOfTheWord:this.email
    }).subscribe((res)=>{
      this.service.getAllWords()
      .subscribe({
        next: (result: WordModel[]) => {
          this.words = result;
          console.log(result)
        }
      });
    })
  }
}

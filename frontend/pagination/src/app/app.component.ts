import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from './model/user';
import { HttpErrorResponse } from '@angular/common/http';
import { UserService } from './service/user.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
 // usersState$?: Observable<{appState: String, appData?: User, error?:HttpErrorResponse}>;
 usersList:User[] = [];
 numberOfpages: number[] = [];
 constructor(private userService: UserService){}

  ngOnInit(): void {
    this.initializeUsers();
  }

  initializeUsers(){
    this.userService.getUsers().subscribe({
      next:(responce :any)=>{
        console.log("Responce" , responce)
        this.usersList = responce.userList
        let pages = responce.pageNumbers
        this.numberOfpages = Array.from({length: responce.pageNumbers}, (_, index) => index + 1);
      },
      error:(error:any)=>{
        console.log("Error " + error)
      }
    })
  }

}

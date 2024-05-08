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

 constructor(private userService: UserService){}

  ngOnInit(): void {
    this.initializeUsers();
  }

  initializeUsers(){
    this.userService.getUsers().subscribe({
      next:(responce :any)=>{
        console.log("Responce" , responce)
      },
      error:(error:any)=>{
        console.log("Error " + error)
      }
    })
  }

}

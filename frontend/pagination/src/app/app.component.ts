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
 private currentPageNumber:number = 0;

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
        this.numberOfpages = Array.from({length: pages}, (_, index) => index);
        this.currentPageNumber = responce.currentPage
      },
      error:(error:any)=>{
        console.log("Error " + error)
      }
    })
  }

  goToPage(name:string, pageNumber?:number){
    this.userService.getUsers(name!, pageNumber).subscribe({
      next:(responce :any)=>{
        console.log("Responce" , responce)
        this.usersList = responce.userList
        let pages = responce.pageNumbers
        this.numberOfpages = Array.from({length: pages}, (_, index) => index);
        this.currentPageNumber = responce.currentPage
      },
      error:(error:any)=>{
        console.log("Error " + error)
      }
    })
  }

  goToNextOrPrevPage(direction: string, name: string) {
    let currentPageIndex = this.currentPageNumber;
    if (direction === 'prev') {
        if (currentPageIndex > 0) {
            currentPageIndex--;
        } else {
            return;
        }
    } else if (direction === 'next') {
        if (currentPageIndex < this.numberOfpages.length - 1) {
            currentPageIndex++;
        } else {
            return;
        }
    }

    const pageNumber = this.numberOfpages[currentPageIndex];
    this.goToPage(name, pageNumber);
}


}

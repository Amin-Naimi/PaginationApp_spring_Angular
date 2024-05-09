import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../model/user';
@Injectable({
  providedIn: 'root'
})
export class UserService {

  private readonly API_GET_USERS :string = "http://localhost:8086/pagination/get/users"
  constructor(private http:HttpClient) { }

  getUsers(name:string = '',page:number = 0,size:number = 20):Observable<User> {
    return this.http.get<User>(`${this.API_GET_USERS}`,{
      params:{
        name:name,
        page:page,
        size:size,
      }
    })
  }

}

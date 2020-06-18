import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { AuthService } from '../../services/auth.service';
import { Route } from '@angular/compiler/src/core';
import { RouterStateSnapshot, Router } from '@angular/router';


@Component({
  selector: 'app-log-in',
  templateUrl: './log-in.component.html',
  styleUrls: ['./log-in.component.css']
})
export class LogInComponent implements OnInit {

  user: any;

  loginForm = new FormGroup({
    username: new FormControl(''),
    password: new FormControl(''),
  });

  constructor(private authSevice: AuthService, private router: Router) { 

  }

  ngOnInit() {

  }

  login() {
    this.authSevice.auth(this.loginForm.get('username').value, this.loginForm.get('password').value).then((value)=>{
      this.router.navigate(['/appointments']);
    });
  }

}

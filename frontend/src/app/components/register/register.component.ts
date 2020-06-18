import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { AuthService } from '../../services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})

export class RegisterComponent implements OnInit {

  user: any;

  registerForm = new FormGroup({
    username: new FormControl(''),
    password: new FormControl(''),
  });

  constructor(private authService: AuthService, private router: Router) { 

  }

  ngOnInit() {

  }

  createUser() {
    this.authService.registerAccount(this.registerForm.get('username').value, this.registerForm.get('password').value)
    .then(()=> {
      this.router.navigate(['login']);
    });
  }

}
// login.ts
import {Component} from 'angular2/core';
import {FORM_DIRECTIVES, FormBuilder, Validators, ControlGroup, NgIf} from 'angular2/common';
import {Router} from 'angular2/router';
import {Authentification} from './../../service/authentification.ts';
import {AppState} from "../../app.service";


@Component({
  selector: 'login',
  directives: [ FORM_DIRECTIVES, NgIf],
  template: `
    <form [ngFormModel]="form" (submit)="$event.preventDefault(); onSubmit(form.value)">
      <div *ngIf="error">Check your password</div>
      <div>
        <label for="username">Username</label>
        <input type="text" ngControl="username">
      </div>
      <div>
        <label for="password">Password</label>
        <input type="password" ngControl="password">
      </div>
      <div class="form-group">
        <button type="submit" [disabled]="!form.valid">Login</button>
      </div>
    </form>
  `
})
export class Login {
  form: ControlGroup;
  error: boolean = false;
  constructor(fb: FormBuilder, public auth: Authentification, public router: Router, public appState: AppState) {
    this.form = fb.group({
      username:  ['', Validators.required],
      password:  ['', Validators.required]
    });
  }

  onSubmit(value: any) {
    this.appState.set('classes', ['2sd Genérale Scientifique A', 'Term Genérale Littéraire B']);
    this.appState.set('nom','Jean');
    this.appState.set('prenom','Dupond');
    this.appState.set('role','Enseignant');
    this.router.navigate(['../PrivateApp']);
    this.auth.login(value.username, value.password)
        .subscribe(
            (token: any) => {
              // TODO ask the values from the web service

              this.router.navigate(['../PrivateApp']);
            },
            (err) => { this.error = true; }
        );
  }
}
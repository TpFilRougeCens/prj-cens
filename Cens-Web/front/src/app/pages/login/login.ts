// login.ts
import {Component} from 'angular2/core';
import {FORM_DIRECTIVES, FormBuilder, Validators, ControlGroup, NgIf} from 'angular2/common';
import {Router} from 'angular2/router';
import {Authentification} from './../../service/authentification.ts';
import {AppState} from '../../app.service';


@Component({
    selector: 'login',
    directives: [FORM_DIRECTIVES, NgIf],
    template: `

<div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
            <img src="/assets/img/logo/full300x300.png" alt="Cens LPC" class="login-logo-panel">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Livret de compétences</h3>
                    </div>
                    <div class="panel-body">
                        <form role="form" [ngFormModel]="form" 
                            (submit)="$event.preventDefault(); onSubmit(form.value)">
                            <fieldset>
                                <div class="control-label" for="inputError" 
                                    *ngIf="error" style="color:red">
                                    Identifiant ou mot de passe invalide
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Identifiant" 
                                        name="username" autofocus ngControl="username">
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Mot de passe" 
                                        name="password" type="password" 
                                        value="" ngControl="password">
                                </div>
                                  <div class="form-group">
                                    <button type="submit" class="btn btn-lg btn-success btn-block" 
                                        [disabled]="!form.valid">Connexion</button>
                                  </div>
                            </fieldset>
                        </form>
                      
                    </div>
                </div>
            </div>
        </div>
    </div>
  `
})
/* <button (click)="onSubmit({'username': 'eleve'})">Eleve</button>
 <button (click)="onSubmit({'username': 'enseignant'})">Enseignant</button>
 <button (click)="onSubmit({'username': 'manager'})">Manager</button>
 <button (click)="onSubmit({'username': 'pedagogie'})">Pedagogie</button>
 <button (click)="onSubmit({'username': 'directeur'})">Directeur</button> */
export class Login {
    form: ControlGroup;
    error: boolean = false;

    constructor(fb: FormBuilder, public auth: Authentification, public router: Router,
                public appState:
        AppState) {
        this.form = fb.group({
            username: ['', Validators.required],
            password: ['', Validators.required]
        });
    }

    ngOnInit() {

    }

    onSubmit(value: any) {

        console.log(value);
        this.auth.login(value.username, value.password)
            .subscribe(
                (token: any) => {
                    console.log('token: ' + token);
                    this.router.navigate(['../PrivateApp']);
                },
                (err) => {
                    console.log('erreur: ' + err);
                    this.error = true;
                }
            );

    }
}

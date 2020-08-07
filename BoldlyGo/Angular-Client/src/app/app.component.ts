import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title: string;

  myimage1: string = 'assets/images/logo.png';
  myimage2: string = 'assets/images/logoLetters.png';
  myimage3: string = 'assets/images/tinylogo.png';

  constructor() {
    this.title = 'Spring Boot - Angular Application';
  }
}

import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { UserService } from './user.service';
import { MapComponent } from './map/map.component';
import { MapEditorComponent } from './map-editor/map-editor.component';

@NgModule({
  declarations: [AppComponent, MapComponent, MapEditorComponent],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule],
  providers: [UserService],
  bootstrap: [AppComponent],
})
export class AppModule {}

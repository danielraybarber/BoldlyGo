import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { MapComponent } from './map/map.component';
import { MapEditorComponent } from './map-editor/map-editor.component';

const routes: Routes = [
  { path: 'map', component: MapComponent },
  { path: 'map-editor', component: MapEditorComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}

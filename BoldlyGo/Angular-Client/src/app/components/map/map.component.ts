/// <reference types="@types/googlemaps" />
import {
  Component,
  AfterViewInit,
  ViewChild,
  ElementRef,
  OnInit,
} from '@angular/core';

@Component({
  selector: 'app-map',
  templateUrl: './map.component.html',
  styleUrls: ['./map.component.css'],
})
export class MapComponent implements AfterViewInit {
  @ViewChild('mapContainer', { static: true }) gmap: ElementRef;
  map: google.maps.Map;
  lat = 40.73061;
  lng = -73.935242;

  coordinates = new google.maps.LatLng(this.lat, this.lng);

  mapOptions: google.maps.MapOptions = {
    center: this.coordinates,
    zoom: 2,
  };

  marker = new google.maps.Marker({
    position: this.coordinates,
    map: this.map,
  });

  ngAfterViewInit() {
    this.mapInitializer();
  }

  mapInitializer() {
    this.map = new google.maps.Map(this.gmap.nativeElement, this.mapOptions);
    this.marker.setMap(this.map);
  }

  constructor() {}
  x = 1;
  onClickMe() {
    for (let i = 0; i < this.x; i++) {
      let longs: Array<number> = [
        -74.044502,
        2.352222,
        0,
        86.924973,
        116.570374,
        -77.03653,
        115.793,
        25,
        116.5323,
        104.523,
      ];
      let lats: Array<number> = [
        40.689247,
        48.56613,
        0,
        27.988121,
        40.431908,
        38.897675,
        37.2431,
        71,
        36.5323,
        104.523,
      ];
      this.lat = lats[i];
      this.lng = longs[i];
    }

    this.x++;
    if (this.x > 10) {
      this.x = 1;
    }
    this.coordinates = new google.maps.LatLng(this.lat, this.lng);
    this.marker = new google.maps.Marker({
      position: this.coordinates,
      map: this.map,
    });

    this.mapInitializer();
  }
}

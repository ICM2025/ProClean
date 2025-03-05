import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ServicioInfo, SensorInfo } from './project.model';
@Component({
  selector: 'app-project',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './project.component.html',
  styleUrl: './project.component.css'
})
export class ProjectComponent {
  
  servicios: ServicioInfo[] = [
    {
      nombre: 'Plomería y Electricidad',
      icono: 'fa-wrench',
      descripcion: 'Reparaciones y mantenimiento para problemas eléctricos o de plomería'
    },
    {
      nombre: 'Limpieza a Domicilio',
      icono: 'fa-broom',
      descripcion: 'Servicios de limpieza profesional para hogares y oficinas'
    },
    {
      nombre: 'Cerrajería',
      icono: 'fa-key',
      descripcion: 'Soluciones para problemas con cerraduras, llaves y seguridad'
    },
    {
      nombre: 'Mecánica y Asistencia Vehicular',
      icono: 'fa-car',
      descripcion: 'Reparaciones de vehículos y asistencia en carretera'
    },
    {
      nombre: 'Fletes y Mudanzas',
      icono: 'fa-truck',
      descripcion: 'Transporte de muebles y servicios de mudanza (opcional)'
    }
  ];

  sensores: SensorInfo[] = [
    {
      nombre: 'Huella Digital',
      icono: 'fa-fingerprint',
      descripcion: 'Autenticación segura para acceder a la app o realizar pagos'
    },
    {
      nombre: 'NFC',
      icono: 'fa-wifi',
      descripcion: 'Validación del servicio mediante confirmación del empleador y prestador'
    },
    {
      nombre: 'Micrófono',
      icono: 'fa-microphone',
      descripcion: 'Captura de búsquedas por voz para mayor comodidad'
    },
    {
      nombre: 'Sensor de Luz',
      icono: 'fa-sun',
      descripcion: 'Ajuste automático del tema oscuro o claro según la luz ambiental'
    }
  ];

  constructor() { }

}

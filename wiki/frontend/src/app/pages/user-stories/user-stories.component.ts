import { Component, OnInit } from '@angular/core';
import { UserStory } from './user-stories.model';
import { StoriesModalComponent } from '../../components/stories-modal/stories-modal.component';
import { CommonModule } from '@angular/common';
@Component({
  selector: 'app-user-stories',
  standalone: true,
  imports: [StoriesModalComponent, CommonModule],
  templateUrl: './user-stories.component.html',
  styleUrl: './user-stories.component.css'
})
export class UserStoriesComponent {
  userStories: UserStory[] = [
    {
      id: 1,
      title: 'Buscar trabajadores domésticos cercanos',
      role: 'cliente',
      feature: 'buscar trabajadores domésticos cerca de mi ubicación',
      benefit: 'contratar de manera rápida y segura cuando los necesite',
      acceptanceCriteria: [
        'La app debe permitir filtrar por tipo de servicio.',
        'Debe mostrar perfiles con información relevante.',
        'Los resultados deben ordenarse por cercanía utilizando GPS.',
        'Los usuarios deben poder contactar directamente al trabajador desde la app.'
      ]
    },
    {
      id: 2,
      title: 'Registro de trabajadores domésticos',
      role: 'trabajador doméstico',
      feature: 'registrarme en la app con mis datos personales y experiencia',
      benefit: 'acceder a oportunidades laborales fácilmente',
      acceptanceCriteria: [
        'Debe permitir cargar datos personales.',
        'Debe permitir cargar foto de perfil utilizando la camara.',
        'Debe incluir un sistema de verificación de identidad.',
        'El trabajador debe poder actualizar su perfil y disponibilidad en cualquier momento.'
      ]
    },
    {
      id: 3,
      title: 'Ver calificaciones y verificaciones',
      role: 'cliente',
      feature: 'ver calificaciones y verificaciones de otros clientes sobre los trabajadores',
      benefit: 'tomar decisiones informadas al contratar un servicio',
      acceptanceCriteria: [
        'Debe permitir a los clientes calificar y dejar comentarios sobre el servicio recibido.',
        'Debe mostrar el promedio de calificaciones en cada perfil.'
      ]
    },
    {
      id: 4,
      title: 'Notificaciones en tiempo real',
      role: 'trabajador doméstico',
      feature: 'recibir notificaciones en tiempo real cuando alguien solicite un servicio',
      benefit: 'no perder oportunidades laborales',
      acceptanceCriteria: [
        'La app debe enviar notificaciones push cuando se recibe una solicitud.',
        'El trabajador debe poder aceptar o rechazar la solicitud desde la notificación.',
        'Debe mostrar detalles de la solicitud (ubicación, tipo de servicio, horario) antes de aceptarla.'
      ]
    },
    {
      id: 5,
      title: 'Autenticación con huella dactilar',
      role: 'cliente',
      feature: 'usar mi huella dactilar para autenticarse en la app',
      benefit: 'mantener mi cuenta segura y agilizar el acceso',
      acceptanceCriteria: [
        'La app debe permitir a los usuarios habilitar la autenticación con huella dactilar desde la configuración de seguridad.',
        'Debe ser posible iniciar sesión o acceder a secciones sensibles de la app utilizando el sensor de huellas dactilares.',
        'La app debe ofrecer una alternativa para dispositivos sin sensor de huellas (como autenticación por PIN o contraseña).'
      ]
    },
    {
      id: 6,
      title: 'Perfiles destacados para empresas',
      role: 'empresa prestadora de servicios domésticos',
      feature: 'tener la opción de pagar para que los perfiles de mis trabajadores aparezcan destacados',
      benefit: 'aumentar la visibilidad y atraer más clientes potenciales',
      acceptanceCriteria: [
        'La app debe permitir a las empresas realizar pagos para destacar los perfiles de sus trabajadores durante un período específico.',
        'Los perfiles destacados deben aparecer en las primeras posiciones en las búsquedas realizadas por los clientes.',
        'Debe haber una etiqueta visible ("Destacado") o un diseño especial que diferencie estos perfiles del resto.',
        'La app debe enviar notificaciones al administrador de la empresa antes de que el período destacado termine, con la opción de renovar.'
      ]
    },
    {
      id: 7,
      title: 'Tema adaptativo (claro/oscuro)',
      role: 'usuario',
      feature: 'que la app ajuste automáticamente el tema (claro u oscuro) de la interfaz',
      benefit: 'mejorar la visibilidad en diferentes condiciones de iluminación',
      acceptanceCriteria: [
        'La app debe cambiar al modo oscuro cuando detecte poca luz ambiental.',
        'Debe permitir configurar manualmente si el usuario desea desactivar esta función.'
      ]
    },
    {
      id: 8,
      title: 'Orientación automática',
      role: 'usuario',
      feature: 'que la app ajuste automáticamente la orientación de la interfaz al girar el dispositivo',
      benefit: 'visualizar los mapas o las imágenes de manera más clara según mi posición',
      acceptanceCriteria: [
        'La app debe detectar automáticamente cuando el dispositivo cambia de orientación (de vertical a horizontal o viceversa).',
        'La visualización de mapas y fotos debe adaptarse a la nueva orientación del dispositivo.',
        'El cambio de orientación debe ser fluido y sin interrupciones en la funcionalidad de la app.',
        'Debe permitir bloquear la orientación de la pantalla si el usuario lo prefiere.'
      ]
    }
  ];
  
  selectedStory: UserStory | null = null;
  showModal: boolean = false;
  
  constructor() { }

  ngOnInit(): void {
  }
  
  openStoryDetails(story: UserStory): void {
    this.selectedStory = story;
    this.showModal = true;
  }
  
  closeModal(): void {
    this.showModal = false;
  }

}

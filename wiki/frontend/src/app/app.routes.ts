import { Routes } from '@angular/router';
import { TeamComponent } from './pages/team/team.component';    
import { UserStoriesComponent } from './pages/user-stories/user-stories.component';
import { ClassesSchemaComponent } from './pages/classes-schema/classes-schema.component';
import { MockupsComponent } from './pages/mockups/mockups.component';
import { NotFoundComponent } from './pages/not-found/not-found.component';

export const routes: Routes = [
  { path: '', component: TeamComponent, title: 'Equipo' },
  { path: 'user-stories', component: UserStoriesComponent, title: 'Historias de usuario' },
  { path: 'class-schema', component: ClassesSchemaComponent, title: 'Diagrama de clases' },
  { path: 'mockups', component: MockupsComponent, title: 'Diseño Interfaz' },
  { path: '**', component: NotFoundComponent, title: 'Página no encontrada' },
];

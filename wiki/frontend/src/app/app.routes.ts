import { Routes } from '@angular/router';
import { TeamComponent } from './pages/team/team.component';    
import { UserStoriesComponent } from './pages/user-stories/user-stories.component';
import { ClassesSchemaComponent } from './pages/classes-schema/classes-schema.component';
import { MockupsComponent } from './pages/mockups/mockups.component';
import { NotFoundComponent } from './pages/not-found/not-found.component';
import { ProjectComponent } from './pages/project/project.component';
export const routes: Routes = [
  { path: '', component: TeamComponent, title: 'Equipo' },
  { path: 'project-overview', component: ProjectComponent, title: '¿Qué hacemos?' },
  { path: 'user-stories', component: UserStoriesComponent, title: 'Historias de usuario' },
  { path: 'class-schema', component: ClassesSchemaComponent, title: 'Diagrama de clases' },
  { path: 'mockups', component: MockupsComponent, title: 'Diseño Interfaz' },
  { path: '**', component: NotFoundComponent, title: 'Página no encontrada' },
];

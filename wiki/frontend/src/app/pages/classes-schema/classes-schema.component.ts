import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
@Component({
  selector: 'app-classes-schema',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './classes-schema.component.html',
  styleUrl: './classes-schema.component.css'
})
export class ClassesSchemaComponent {
  isImageExpanded: boolean = false;
  
  // Puedes cambiar esta URL por la de tu imagen
  imageUrl: string = 'assets/images/proclean-architecture.jpg';
  
  toggleImageSize(): void {
    this.isImageExpanded = !this.isImageExpanded;
  }
}

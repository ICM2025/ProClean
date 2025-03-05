import { Component, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-stories-modal',
  standalone: true,
  imports: [],
  templateUrl: './stories-modal.component.html',
  styleUrl: './stories-modal.component.css'
})
export class StoriesModalComponent {
  @Input() title: string = '';
  @Input() showModal: boolean = false;
  @Output() close = new EventEmitter<void>();

  constructor() { }

  closeModal(): void {
    this.close.emit();
  }

  stopPropagation(event: MouseEvent): void {
    event.stopPropagation();
  }
}

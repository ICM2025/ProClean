import { Component, OnInit, OnDestroy, HostListener } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

interface Slide {
  imageUrl: string;
  alt: string;
}

@Component({
  selector: 'app-mockups',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './mockups.component.html',
  styleUrl: './mockups.component.css'
})

export class MockupsComponent{
  
  slides: Slide[] = [
    { imageUrl: 'assets/mockups/mockup1.png', alt: 'mockup1' },
    { imageUrl: 'assets/mockups/mockup2.png', alt: 'mockup2' },
    { imageUrl: 'assets/mockups/mockup3.png', alt: 'mockup3' },
    { imageUrl: 'assets/mockups/mockup4.png', alt: 'mockup4' },
    { imageUrl: 'assets/mockups/mockup5.png', alt: 'mockup5' }
  ];
  
  currentIndex = 0;
  
  nextSlide(): void {
    this.currentIndex = (this.currentIndex + 1) % this.slides.length;
  }
  
  prevSlide(): void {
    this.currentIndex = (this.currentIndex - 1 + this.slides.length) % this.slides.length;
  }
  
  goToSlide(index: number): void {
    this.currentIndex = index;
  }
}

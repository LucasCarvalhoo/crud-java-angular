import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Course } from '../../model/course';
import { ActivatedRoute, Router } from '@angular/router';
import { CoursesService } from '../../services/courses.service';

@Component({
  selector: 'app-courses-list',
  templateUrl: './courses-list.component.html',
  styleUrls: ['./courses-list.component.scss']
})
export class CoursesListComponent implements OnInit {

  @Input() courses: Course[] = [];
  @Output() add = new EventEmitter(false);
  @Output() edit = new EventEmitter(false);
  @Output() remove = new EventEmitter(false);

  readonly displayedColumns = ['name', 'category', 'actions']; // colunas que estão sendo mostradas
  // readonly diz que aquele é um objeto final e que não será feito mais modificações

  constructor(private myService: CoursesService) { }

  ngOnInit(): void {
    const id = 'some-id';
    const courses = 'some-courses';
    const limit = 5;

    this.myService.loadByIdAndLimit(limit).subscribe(
    (data: Course[]) => {
      this.courses = data.slice(0, limit);  // Garantir que apenas 5 cursos sejam exibidos
    },
    (error) => {
      console.error('Erro ao carregar cursos', error);
    }
  );
}

  

onAdd(){
  this.add.emit(true);
}

onEdit(course: Course){
  this.edit.emit(course);
}

onRemove(course: Course){
  this.remove.emit(course)
}

}

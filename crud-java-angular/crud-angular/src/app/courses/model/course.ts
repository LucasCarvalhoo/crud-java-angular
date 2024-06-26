import { lesson } from './lesson';
export interface Course {
    _id: string;
    name: string;
    category: string;
    lesson?: lesson[]; // Lição é opcional
  }

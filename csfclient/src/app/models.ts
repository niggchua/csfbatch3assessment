
import { TagsComponent } from './tags/tags.component';

export interface TagsComponent {
  name: string,
  quantity: number,
  unitPrice: number
}

export interface News {
  title: string,
  description: string,
  express: boolean,
  tags: TagsComponent[]
}

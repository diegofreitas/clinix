import { Injectable } from '@angular/core';
import { Observable, BehaviorSubject } from 'rxjs';

export enum NotificationType {
  ERROR,
  INFO 
}

export interface NotificationData {
  message: string;
  type: NotificationType;
}

@Injectable({
  providedIn: 'root'
})
export class NotificationDataService {

  public notificationData: BehaviorSubject<NotificationData> = new BehaviorSubject(null);

  constructor() { 
    
  }
}

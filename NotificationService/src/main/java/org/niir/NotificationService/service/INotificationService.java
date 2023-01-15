package org.niir.NotificationService.service;

import org.niir.NotificationService.config.ProductDTO;
import org.niir.NotificationService.domain.Notification;

public interface INotificationService {
    public Notification getAllNotification(String email);
    public void saveNotification(ProductDTO productDTO);
}

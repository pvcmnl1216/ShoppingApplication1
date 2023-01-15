package org.niir.NotificationService.service;

import org.niir.NotificationService.config.ProductDTO;
import org.niir.NotificationService.domain.Notification;
import org.niir.NotificationService.repository.NotifocatioRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements INotificationService{
    @Autowired
    private NotifocatioRepository notifocatioRepository;


    @Override
    public Notification getAllNotification(String email) {
        return notifocatioRepository.findById(email).get() ;
    }



    @RabbitListener(queues = "productQueue")
    @Override
    public void saveNotification(ProductDTO productDTO) {

        //object of notification
        Notification notification=new Notification();
        //fetch email from DTO object
        String email= productDTO.getJsonObject().get("email").toString();
        if(notifocatioRepository.findById(email).isEmpty()){
            notification.setEmail(email);
        }
        notification.setNotificationMessage("List of no watched movies");
        notification.setJsonObject(productDTO.getJsonObject());
        notifocatioRepository.save(notification);
    }
}

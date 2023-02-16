package com.example.landonhotel.convertor;



import com.example.landonhotel.entity.ReservationEntity;
import com.example.landonhotel.entity.RoomEntity;
import com.example.landonhotel.model.request.ReservationRequest;
import com.example.landonhotel.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ReservationRequestToReservationEntityConverter implements Converter<ReservationRequest, ReservationEntity> {
private final ApplicationContext context;

    public ReservationRequestToReservationEntityConverter(ApplicationContext context) {
        this.context = context;
    }

    @Override
    public ReservationEntity convert(ReservationRequest source) {

        ReservationEntity reservationEntity = new ReservationEntity();
        reservationEntity.setCheckin(source.getCheckin());
        reservationEntity.setCheckout(source.getCheckout());
        RoomService repository=context.getBean(RoomServiceImpl.class);
        RoomEntity associatedRoom=repository.findById(source.getRoomId());

        reservationEntity.setRoomEntity(associatedRoom);
        if (null != source.getId())
            reservationEntity.setId(source.getId());

        return reservationEntity;
    }
}
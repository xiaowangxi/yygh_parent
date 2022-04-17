package com.xiaowangzi.yygh.hosp.receiver;

import com.rabbitmq.client.Channel;
import com.xiaowangzi.yygh.common.constant.MqConst;
import com.xiaowangzi.yygh.common.service.RabbitService;
import com.xiaowangzi.yygh.hosp.service.ScheduleService;
import com.xiaowangzi.yygh.model.hosp.Schedule;
import com.xiaowangzi.yygh.vo.msm.MsmVo;
import com.xiaowangzi.yygh.vo.order.OrderMqVo;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class HospitalReceiver {

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private RabbitService rabbitService;

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = MqConst.QUEUE_ORDER, durable = "true"),
            exchange = @Exchange(value = MqConst.EXCHANGE_DIRECT_ORDER),
            key = {MqConst.ROUTING_ORDER}
    ))
    public void receiver(OrderMqVo orderMqVo, Message message, Channel channel) throws IOException {
        //下单成功更新预约数
        Schedule schedule = (Schedule) scheduleService.getScheduleId(orderMqVo.getScheduleId());
        schedule.setReservedNumber(orderMqVo.getReservedNumber());
        schedule.setAvailableNumber(orderMqVo.getAvailableNumber());
        scheduleService.updateSchedule(schedule);
        //发送短信
        MsmVo msmVo = orderMqVo.getMsmVo();
        if (null != msmVo) {
            String phone=msmVo.getPhone();
            rabbitService.sendMessage(MqConst.EXCHANGE_DIRECT_MSM, MqConst.ROUTING_MSM_ITEM, phone);
        }
    }

}

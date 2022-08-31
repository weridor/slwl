package com.sl.ms.work.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sl.ms.work.domain.dto.CourierTaskCountDTO;
import com.sl.ms.work.domain.dto.PickupDispatchTaskDTO;
import com.sl.ms.work.domain.enums.pickupDispatchtask.PickupDispatchTaskType;
import com.sl.ms.work.entity.PickupDispatchTaskEntity;

import java.util.List;

/**
 * 取件、派件任务信息表 服务类
 */
public interface PickupDispatchTaskService extends IService<PickupDispatchTaskEntity> {

    /**
     * 更新取派件状态，不允许 NEW 状态
     *
     * @param pickupDispatchTaskDTO 修改的数据
     * @return 是否成功
     */
    Boolean updateStatus(PickupDispatchTaskDTO pickupDispatchTaskDTO);

    /**
     * 改派快递员
     *
     * @param id                任务id
     * @param originalCourierId 原快递员id
     * @param targetCourierId   目标快递员id
     * @return 是否成功
     */
    Boolean updateCourierId(Long id, Long originalCourierId, Long targetCourierId);

    /**
     * 新增取派件任务
     *
     * @param taskPickupDispatch 取派件任务信息
     * @return 取派件任务信息
     */
    PickupDispatchTaskEntity saveTaskPickupDispatch(PickupDispatchTaskEntity taskPickupDispatch);

    /**
     * 获取取派件任务分页数据
     *
     * @param page     页码
     * @param pageSize 页尺寸
     * @param dispatch 查询条件
     * @return 取派件任务分页数据
     */
    Page<PickupDispatchTaskEntity> findByPage(Integer page, Integer pageSize, PickupDispatchTaskEntity dispatch);

    /**
     * 获取取派件任务列表
     *
     * @param ids      取派件任务id列表
     * @param dispatch 查询条件
     * @return 取派件任务列表
     */
    List<PickupDispatchTaskEntity> findAll(List<Long> ids, List<Long> orderIds, PickupDispatchTaskEntity dispatch);

    /**
     * 按照当日快递员id列表查询每个快递员的取派件任务数
     *
     * @param courierIds             快递员id列表
     * @param pickupDispatchTaskType 任务类型
     * @param date                   日期，格式：yyyy-MM-dd 或 yyyyMMdd
     * @return 任务数
     */
    List<CourierTaskCountDTO> findCountByCourierIds(List<Long> courierIds, PickupDispatchTaskType pickupDispatchTaskType, String date);

    /**
     * 查询快递员当日的单据
     *
     * @return 任务列表
     */
    List<PickupDispatchTaskDTO> findTodayTaskByCourierId(Long courierId);

    /**
     * 根据订单id查询取派件任务
     *
     * @param orderId  订单id
     * @param taskType 任务类型
     * @return 任务
     */
    PickupDispatchTaskEntity findByOrderId(Long orderId, PickupDispatchTaskType taskType);

    /**
     * 根据id批量删除取派件任务信息（逻辑删除）
     *
     * @param ids id列表
     * @return 是否成功
     */
    boolean deleteByIds(List<Long> ids);
}

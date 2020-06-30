package com.wllt.qxwl.modules.custom.log.entity;

import lombok.Data;

import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author Devil
 * @since 2020-04-11
 */
@Data
public class WlltLog implements Serializable {

    /**
     * 操作人ID
     */
    private Long userId;

    /**
     * 操作时间
     */
    private LocalDateTime logTime;

    /**
     * 操作SQL
     */
    private Long logSql;

    /**
     * 操作前数据
     */
    private String logBeforeData;

    /**
     * 操作类型
     */
    private String logType;


}

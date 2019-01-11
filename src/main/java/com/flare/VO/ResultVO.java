package com.flare.VO;

import lombok.Data;

/**
 * @ClassName ResultVO
 * @Description 返回对象
 * @Author EyesSmile
 * @Date 2018/12/30
 * @Version 1.0
 */
@Data
public class ResultVO<T> {
    /** 错误码*/
    private Integer code;

    /** 提示信息*/
    private String msg;

    /** 具体内容*/
    private T data;
}

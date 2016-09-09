package com.ctao.demos.blogcodes.mvp.http;

import java.util.List;

/**
 * Created by A Miracle on 2016/9/9.
 */
//Model 业务回调接口
public interface OnResultListener<T> {
    /** 请求异常 */
    int STATE_ERROR = -1;
    /** 请求成功 */
    int STATE_SUCCEED = 0x11;
    /** 请求成功, 无数据 */
    int STATE_SUCCEED_EMPTY = 0x22;
    /** 请求成功, JSON异常 */
    int STATE_SUCCEED_JSON_ERROR = 0x33;
    /** 未请求 */
    int STATE_UNGEBETEN = 0x44;

    /**
     * 请求结果返回
     * @param state 状态码
     * @param data List集合返回
     * @param result json字符串返回
     * @return 是否自行处理结果
     */
    boolean onResult(int state, List<T> data, T result);
}

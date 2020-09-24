package com.bsoft.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    //404 not_found
    private Integer code;
    private String message;
    private  T      data;

    public CommonResult(Integer code, String message){
        this(code,message,null);//写此方法记得给idea安装lombok插件
    }
}
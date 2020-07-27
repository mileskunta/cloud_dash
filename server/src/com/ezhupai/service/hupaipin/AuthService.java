package com.ezhupai.service.hupaipin;

import com.ezhupai.vo.HupaiPinAuthResultVo;

/**
 * Created by Administrator on 2018/2/28.
 */
public interface AuthService {

    HupaiPinAuthResultVo getPinAuth(String pin);
}

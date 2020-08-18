package com.rest.api.service;

import com.rest.api.model.response.CommonResult;
import com.rest.api.model.response.ListResult;
import com.rest.api.model.response.SingleResult;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ResponseService {
    public enum CommonResponse {
        SUCESS(0, "성공하였습니다."),
        FAIL(-1, "실패하였습니다");

        @Getter
        int code;
        @Getter
        String msg;

        CommonResponse(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }
    }

    // 단일 처리
    public <T> SingleResult<T> getSingleResult(T data) {
        SingleResult<T> result = new SingleResult<>();
        result.setData(data);
        setSuccessResult(result);
        return result;
    }

    // 다중 처리
    public <T> ListResult<T> getListResult(List<T> list) {
        ListResult<T> result = new ListResult<>();
        result.setList(list);
        setSuccessResult(result);
        return result;
    }

    public CommonResult getSuccessResult() {
        CommonResult result = new CommonResult();
        return result;
    }

    // 실패 처리
    public CommonResult getFailResult() {
        CommonResult result = new CommonResult();
        result.setSucess(false);
        result.setCode(CommonResponse.FAIL.getCode());
        result.setMsg(CommonResponse.FAIL.getMsg());
        return result;
    }

    // api 결과 세팅
    private void setSuccessResult(CommonResult result) {
        result.setSucess(true);
        result.setCode(CommonResponse.SUCESS.getCode());
        result.setMsg(CommonResponse.SUCESS.getMsg());
    }

}

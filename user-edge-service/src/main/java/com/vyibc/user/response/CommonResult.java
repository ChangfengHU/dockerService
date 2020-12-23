package com.vyibc.user.response;

import groovy.transform.ToString;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: �Զ�����Ӧ���ݽṹ
 * 				��������ṩ���Ż���ios����׿��΢���̳��õ�
 * 				�Ż����ܴ������ݺ���Ҫʹ�ñ���ķ���ת���ɶ��ڵ��������͸�ʽ���࣬����list��
 * 				�������д���
 * 				200����ʾ�ɹ�
 * 				500����ʾ���󣬴�����Ϣ��msg�ֶ���
 * 				501��bean��֤���󣬲��ܶ��ٸ�������map��ʽ����
 * 				502�����������ص��û�token����
 * 				555���쳣�׳���Ϣ
 */
@Data
@ToString
public class CommonResult<T> implements Serializable {

    // ��Ӧҵ��״̬
    private Integer status;

    // ��Ӧ��Ϣ
    private String msg;

    //��������
    private T  value;
    private String ok;	// ��ʹ��

    public static CommonResult build(Integer status, String msg, Object data) {
        return new CommonResult(status, msg, data);
    }

    public static CommonResult ok(Object data) {
        return new CommonResult(data);
    }

    public static CommonResult ok() {
        return new CommonResult(null);
    }

    public static CommonResult errorMsg(String msg) {
        return new CommonResult(500, msg, null);
    }

    public static CommonResult errorMap(Object data) {
        return new CommonResult(501, "error", data);
    }

    public static CommonResult errorTokenMsg(String msg) {
        return new CommonResult(502, msg, null);
    }

    public static CommonResult errorException(String msg) {
        return new CommonResult(555, msg, null);
    }

    public CommonResult() {

    }

//    public static LeeJSONResult build(Integer status, String msg) {
//        return new LeeJSONResult(status, msg, null);
//    }

    public CommonResult(Integer status, String msg,  T value) {
        this.status = status;
        this.msg = msg;
        this.value = value;
    }

    public CommonResult( T value) {
        this.status = 200;
        this.msg = "OK";
        this.value = value;
    }

    public Boolean isOK() {
        return this.status == 200;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getValue() {
        return value;
    }

    public void setValue( T value) {
        this.value = value;
    }

    public String getOk() {
		return ok;
	}

	public void setOk(String ok) {
		this.ok = ok;
	}

}

package wang.aemon.skt.domain

import java.io.Serializable


enum class CodeMessage(val code: String, val message: String) : Serializable {
    SUCCESS("200", "请求成功！"),
    FAILED("000", "请求失败！"),
    FORBIDDEN("403", "未授权！"),
    NOTFOUND("404", "资源未找到！"),
    SERVERERROR("500", "服务器内部错误！");
}

data class CommonResponse(
    var code: String,
    var message: String,
    var data: Any?
) : Serializable {
    companion object StaticParams {

        // only return custom code and message
        fun success(message: String): CommonResponse =
            CommonResponse(CodeMessage.SUCCESS.code, CodeMessage.SUCCESS.message, null)

        // return custom code and message, data
        fun success(message: String, data: Any?): CommonResponse =
            CommonResponse(CodeMessage.SUCCESS.code, message, data)

        //  return whole CommonResponse object
        fun success(codeMessage: CodeMessage, data: Any?): CommonResponse =
            CommonResponse(codeMessage.code, codeMessage.message, data)

        // return whole CommonResponse object
        fun fail(codeMessage: CodeMessage, data: Any?): CommonResponse =
            CommonResponse(codeMessage.code, codeMessage.message, data)

    }
}
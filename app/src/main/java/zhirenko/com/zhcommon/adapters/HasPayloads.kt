package zhirenko.com.zhcommon.adapters

interface HasPayloads{
    fun getPayload(old: Any): Any?
}
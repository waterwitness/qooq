package com.weiyun.sdk.context;

import android.util.Log;
import android.util.SparseArray;

public class ErrorMessages
{
  public static final String ERR_COMMON_TIPS = "出现错误，请重试!";
  public static final String ERR_DST_FILE_NOT_EXIST = "文件不存在或已经被删除";
  public static final String ERR_FILE_MODIFIED = "文件不存在或已经被删除";
  public static final String ERR_FILE_NOT_ACCESS = "读写文件失败";
  public static final String ERR_FILE_SIZE_EXCEED = "文件大小超出2G限制!";
  public static final String ERR_FILE_TYPE_NOT_SUPPORT = "该文件类型暂不支持!";
  public static final String ERR_INVALID_PARAMETER = "无效的参数!";
  public static final String ERR_INVALID_PROTO = "无效的协议!";
  public static final String ERR_NETWORK_EXCEPTION = "网络发生异常，请检查您的网络设置!";
  public static final String ERR_NETWORK_NOT_AVAILABLE = "当前网络不可用!";
  public static final String ERR_NETWORK_TIMEOUT = "网络超时，请检查您的网络设置!";
  public static final String ERR_NO_NETWORK = "没有网络!";
  public static final String ERR_QQDISK_ADD_UPLOAD_TASK_FAIL = "上传任务添加失败!";
  public static final String ERR_QQDISK_DOWNLOAD_DIR = "暂不支持下载目录!";
  public static final String ERR_QQDISK_DOWNLOAD_LACK_SPACE = "sd卡空间不足!";
  public static final String ERR_QQDISK_DOWNLOAD_UNABLE_OVERWRITE = "无法覆盖同名文件!";
  public static final String ERR_QQDISK_INVALID_RSP = "无效的响应!";
  public static final String ERR_QQDISK_NO_LOGIN = "您还没有登录，请先登录!";
  public static final String ERR_QQDISK_SERVER_ERROR = "服务器错误!";
  public static final String ERR_QQDISK_TOO_MANY_FILES = "文件数量太多!";
  public static final String ERR_QQDISK_UPLOAD_DIR = "暂时不支持上传目录!";
  public static final String ERR_QQDISK_UPLOAD_LACK_SPACE = "转存失败，微云空间不足!";
  public static final String ERR_QQDISK_UPLOAD_TO_ROOT = "不能上传到根目录!";
  public static final String ERR_RECV_FAILED = "接收数据失败!";
  public static final String ERR_SEND_FAILED = "数据发送失败!";
  public static final String ERR_SRC_FILE_NOT_EXIST = "文件不存在或已经被删除";
  public static final String ERR_THUNBNAIL_NOT_EXIST = "缩略图不存在!";
  public static final String ERR_UNKOWN_EXCEPTION = "操作出错，请重试！";
  public static final String ERR_USER_CANCELED = "取消了上传、下载过程!";
  public static final String ERR_WRONG_HTTP_RESPONSE = "下载失败，文件被删除或者没有权限下载!";
  private static final String TAG = "ErrorMessages";
  private static final SparseArray<String> sErrorMessageMap = new SparseArray();
  
  static
  {
    sErrorMessageMap.put(35535, "网络超时，请检查您的网络设置!");
    sErrorMessageMap.put(35534, "网络超时，请检查您的网络设置!");
    sErrorMessageMap.put(35508, "网络超时，请检查您的网络设置!");
    sErrorMessageMap.put(35507, "网络超时，请检查您的网络设置!");
    sErrorMessageMap.put(35533, "网络发生异常，请检查您的网络设置!");
    sErrorMessageMap.put(35532, "网络发生异常，请检查您的网络设置!");
    sErrorMessageMap.put(35531, "网络发生异常，请检查您的网络设置!");
    sErrorMessageMap.put(35530, "网络发生异常，请检查您的网络设置!");
    sErrorMessageMap.put(35529, "网络发生异常，请检查您的网络设置!");
    sErrorMessageMap.put(35528, "网络发生异常，请检查您的网络设置!");
    sErrorMessageMap.put(35527, "网络发生异常，请检查您的网络设置!");
    sErrorMessageMap.put(35526, "网络发生异常，请检查您的网络设置!");
    sErrorMessageMap.put(35525, "网络发生异常，请检查您的网络设置!");
    sErrorMessageMap.put(35524, "网络发生异常，请检查您的网络设置!");
    sErrorMessageMap.put(35523, "无效的协议!");
    sErrorMessageMap.put(35522, "网络发生异常，请检查您的网络设置!");
    sErrorMessageMap.put(35521, "网络发生异常，请检查您的网络设置!");
    sErrorMessageMap.put(35520, "网络发生异常，请检查您的网络设置!");
    sErrorMessageMap.put(35519, "网络发生异常，请检查您的网络设置!");
    sErrorMessageMap.put(35518, "网络发生异常，请检查您的网络设置!");
    sErrorMessageMap.put(35512, "网络超时，请检查您的网络设置!");
    sErrorMessageMap.put(35511, "网络发生异常，请检查您的网络设置!");
    sErrorMessageMap.put(35510, "网络发生异常，请检查您的网络设置!");
    sErrorMessageMap.put(35513, "网络发生异常，请检查您的网络设置!");
    sErrorMessageMap.put(35509, "网络发生异常，请检查您的网络设置!");
    sErrorMessageMap.put(35446, "网络超时，请检查您的网络设置!");
    sErrorMessageMap.put(35445, "网络发生异常，请检查您的网络设置!");
    sErrorMessageMap.put(35517, "网络发生异常，请检查您的网络设置!");
    sErrorMessageMap.put(35516, "网络发生异常，请检查您的网络设置!");
    sErrorMessageMap.put(35515, "网络发生异常，请检查您的网络设置!");
    sErrorMessageMap.put(35514, "网络发生异常，请检查您的网络设置!");
    sErrorMessageMap.put(36535, "下载失败，文件被删除或者没有权限下载!");
    sErrorMessageMap.put(36531, "下载失败，文件被删除或者没有权限下载!");
    sErrorMessageMap.put(36534, "无效的参数!");
    sErrorMessageMap.put(36533, "下载失败，文件被删除或者没有权限下载!");
    sErrorMessageMap.put(37535, "无效的协议!");
    sErrorMessageMap.put(37534, "接收数据失败!");
    sErrorMessageMap.put(37533, "无效的协议!");
    sErrorMessageMap.put(37532, "接收数据失败!");
    sErrorMessageMap.put(55525, "网络发生异常，请检查您的网络设置!");
    sErrorMessageMap.put(55524, "无效的参数!");
    sErrorMessageMap.put(55523, "无效的参数!");
    sErrorMessageMap.put(55535, "无效的参数!");
    sErrorMessageMap.put(55533, "没有网络!");
    sErrorMessageMap.put(55532, "当前网络不可用!");
    sErrorMessageMap.put(55531, "文件不存在或已经被删除");
    sErrorMessageMap.put(55530, "文件不存在或已经被删除");
    sErrorMessageMap.put(55528, "读写文件失败");
    sErrorMessageMap.put(55529, "读写文件失败");
    sErrorMessageMap.put(55520, "读写文件失败");
    sErrorMessageMap.put(55526, "该文件类型暂不支持!");
    sErrorMessageMap.put(55527, "文件不存在或已经被删除");
    sErrorMessageMap.put(55521, "文件大小超出2G限制!");
    sErrorMessageMap.put(36532, "缩略图不存在!");
    sErrorMessageMap.put(55534, "取消了上传、下载过程!");
    sErrorMessageMap.put(55522, "操作出错，请重试！");
    sErrorMessageMap.put(55513, "服务器错误!");
    sErrorMessageMap.put(55512, "无效的响应!");
    sErrorMessageMap.put(55511, "上传任务添加失败!");
    sErrorMessageMap.put(55510, "您还没有登录，请先登录!");
    sErrorMessageMap.put(55509, "文件数量太多!");
    sErrorMessageMap.put(55508, "不能上传到根目录!");
    sErrorMessageMap.put(55507, "转存失败，微云空间不足!");
    sErrorMessageMap.put(55506, "暂时不支持上传目录!");
    sErrorMessageMap.put(55505, "sd卡空间不足!");
    sErrorMessageMap.put(55504, "暂不支持下载目录!");
    sErrorMessageMap.put(55503, "无法覆盖同名文件!");
  }
  
  public static String getErrorString(int paramInt)
  {
    try
    {
      String str2 = (String)sErrorMessageMap.get(paramInt);
      String str1 = str2;
      if (str2 == null)
      {
        Log.w("ErrorMessages", "do not find the error string,please check ErrorCode.java and ErrorMessage.java.");
        str1 = null;
      }
      return str1;
    }
    finally {}
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\weiyun\sdk\context\ErrorMessages.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
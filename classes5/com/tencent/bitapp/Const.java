package com.tencent.bitapp;

import android.os.Environment;
import com.tencent.bitapp.pre.PreConst;
import java.io.File;

public class Const
{
  public static final int ACTION_FAIL = 3;
  public static final int ACTION_LOAD = 1;
  public static final int ACTION_RESULT_FAIL = 2;
  public static final int ACTION_RESULT_SUCCESS = 1;
  public static final int ACTION_SUCCESS = 2;
  public static final int BD_NULL = 5;
  public static final int BS_NULL = 2;
  public static final int BUFFER_SIZE = 8192;
  public static final String BUNDLE_CSS_REGEX_STR = "\\$\\{css_replace_%d\\}";
  public static final String BUNDLE_HTML_REGEX_STR = "\\$\\{jsx_replace_%d\\}";
  public static final int COMMON_FAIL = 6;
  public static final int CONTEXT_ERROR = 3;
  public static final int DEFAULT_ACTION_RESULT = 0;
  public static final String DEFAULT_CHARSET = "utf-8";
  public static final String DEFAULT_MODULE_DOWNLOAD_URL = "http://mp.gtimg.cn/sites/client/lola/";
  public static final String DEFAULT_MODULE_DOWNLOAD_URL_SUFFIX = ".zip";
  public static final String DEFAULT_SAVE_FOLDER = Environment.getExternalStorageDirectory().getPath() + "/tencent/react";
  public static final String DEFAULT_VIEW_THUMBNAIL_SAVE_FOLDER = DEFAULT_SAVE_FOLDER + File.separator + "view_thumbnail";
  public static final int NO_ERROR = 0;
  public static final int NO_EXIST_ERROR = 4;
  public static final String TAG_PERFORMANCE = "bitapp_performance";
  public static final int UNKNOW_ERROR = 1;
  public static boolean isAddTextToBitmap = false;
  public static boolean isCheckBundleModify;
  public static boolean isDebug = true;
  public static boolean isTestPerformance = PreConst.isTestPerformance;
  
  static
  {
    isCheckBundleModify = true;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\bitapp\Const.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
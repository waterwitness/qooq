package com.tencent.biz.now;

import android.os.Handler;
import android.util.Log;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import hkd;
import hke;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.zip.GZIPInputStream;
import org.json.JSONObject;

public class CgiHelper
{
  public static String a;
  private static final int jdField_b_of_type_Int = 1001;
  private static final String jdField_b_of_type_JavaLangString = "http://now.qq.com/cgi-bin/now/web/room/get_room_info_v2?room_id=";
  private int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private CgiHelper.cigHelperCallback jdField_a_of_type_ComTencentBizNowCgiHelper$cigHelperCallback;
  private String c;
  private String d;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = CgiHelper.class.getName();
  }
  
  private String a(String paramString)
  {
    Log.i(jdField_a_of_type_JavaLangString, "开始访问cgi url= " + paramString);
    StringBuilder localStringBuilder;
    for (;;)
    {
      try
      {
        paramString = new URL(paramString);
        Log.i(jdField_a_of_type_JavaLangString, " new URL 结束");
        paramString = paramString.openConnection();
        Log.i(jdField_a_of_type_JavaLangString, "openConnection结束");
        if (paramString == null) {
          return "";
        }
        paramString.setRequestProperty("Accept-Encoding", "identity");
        Log.i(jdField_a_of_type_JavaLangString, "getInputStream结束");
        if ((paramString instanceof HttpURLConnection)) {
          this.jdField_a_of_type_Int = ((HttpURLConnection)paramString).getResponseCode();
        }
        Log.i(jdField_a_of_type_JavaLangString, "getResponseCode结束");
        paramString.getContentEncoding();
        if ("gzip".equals(paramString.getContentEncoding()))
        {
          paramString = new InputStreamReader(new GZIPInputStream(paramString.getInputStream()));
          paramString = new BufferedReader(paramString);
          localStringBuilder = new StringBuilder();
          String str = paramString.readLine();
          if (str == null) {
            break;
          }
          localStringBuilder.append(str);
          continue;
        }
        paramString = new InputStreamReader(paramString.getInputStream());
      }
      catch (Exception paramString)
      {
        Log.i(jdField_a_of_type_JavaLangString, "getHeaderFields结束");
        return "";
      }
    }
    paramString = localStringBuilder.toString();
    return paramString;
  }
  
  private void a(String paramString)
  {
    this.c = null;
    this.d = null;
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString.getInt("retcode") != 0)
      {
        Log.i(jdField_a_of_type_JavaLangString, "retcode != 0");
        return;
      }
      paramString = paramString.getJSONObject("result");
      if (paramString == null)
      {
        Log.i(jdField_a_of_type_JavaLangString, "result == null");
        return;
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      return;
    }
    this.c = paramString.getString("vid");
    this.d = paramString.getString("recorded_share_url");
  }
  
  public void a(long paramLong, CgiHelper.cigHelperCallback paramcigHelperCallback)
  {
    this.jdField_a_of_type_AndroidOsHandler = new hke(this);
    this.jdField_a_of_type_ComTencentBizNowCgiHelper$cigHelperCallback = paramcigHelperCallback;
    ThreadManager.d(new hkd(this, paramLong));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\now\CgiHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
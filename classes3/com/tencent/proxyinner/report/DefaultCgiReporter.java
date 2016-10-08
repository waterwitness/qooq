package com.tencent.proxyinner.report;

import com.tencent.proxyinner.log.XLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class DefaultCgiReporter
  extends CgiReporter
{
  private static final String REPORT_URL = "http://tiantian.qq.com/cgi-bin/love/report?type=1";
  private static final String TAG = "XProxy|DataReport|Def";
  
  protected CgiReporter.ReportType getReportType()
  {
    return CgiReporter.ReportType.REPORT_TYPE_POST;
  }
  
  protected String getReportUrl()
  {
    return "http://tiantian.qq.com/cgi-bin/love/report?type=1";
  }
  
  protected Map<String, String> reportPairs2CgiPairs(Map<String, String> paramMap)
  {
    localObject = new JSONObject();
    try
    {
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        ((JSONObject)localObject).put(str, paramMap.get(str));
      }
      return (Map<String, String>)localObject;
    }
    catch (JSONException paramMap)
    {
      paramMap.printStackTrace();
      paramMap = ((JSONObject)localObject).toString();
      localObject = new HashMap();
      ((Map)localObject).put("jsonString", paramMap);
      XLog.i("XProxy|DataReport|Def", "准备数据上报，上报json：" + paramMap);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\proxyinner\report\DefaultCgiReporter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
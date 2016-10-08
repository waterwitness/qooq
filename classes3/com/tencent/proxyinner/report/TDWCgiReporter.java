package com.tencent.proxyinner.report;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;

public class TDWCgiReporter
  extends CgiReporter
{
  private static final String DATAREPORT_TABLENAME = "personal_live_base";
  private static final String REPORT_URL = "http://now.qq.com/cgi-bin/now/web/tdw/report?a=1";
  private static final String TAG = "ODSDK|DataReport|TDW";
  
  protected CgiReporter.ReportType getReportType()
  {
    return CgiReporter.ReportType.REPORT_TYPE_POST;
  }
  
  protected String getReportUrl()
  {
    return "http://now.qq.com/cgi-bin/now/web/tdw/report?a=1";
  }
  
  protected Map<String, String> reportPairs2CgiPairs(Map<String, String> paramMap)
  {
    HashMap localHashMap = new HashMap();
    JSONArray localJSONArray1 = new JSONArray();
    JSONArray localJSONArray2 = new JSONArray();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      localJSONArray1.put(localEntry.getKey());
      localJSONArray2.put(localEntry.getValue());
    }
    paramMap = new JSONArray();
    paramMap.put(localJSONArray2);
    localHashMap.put("table", "personal_live_base");
    localHashMap.put("fields", localJSONArray1.toString());
    localHashMap.put("datas", paramMap.toString());
    return localHashMap;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\proxyinner\report\TDWCgiReporter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
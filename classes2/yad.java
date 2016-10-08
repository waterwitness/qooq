import com.tencent.av.service.LBSInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import cooperation.c2b.C2BLBSUtil;
import cooperation.c2b.C2BLBSUtil.C2BLBSObserver;
import cooperation.c2b.C2BWebPlugin;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class yad
  extends C2BLBSUtil.C2BLBSObserver
{
  private LBSInfo jdField_a_of_type_ComTencentAvServiceLBSInfo;
  private C2BLBSUtil jdField_a_of_type_CooperationC2bC2BLBSUtil;
  public String a;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  public String b;
  private String c;
  private String d;
  
  public yad(C2BWebPlugin paramC2BWebPlugin, String paramString1, String paramString2, String paramString3)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_CooperationC2bC2BLBSUtil = new C2BLBSUtil();
    this.b = "";
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramString3;
  }
  
  public void a(int paramInt, LBSInfo paramLBSInfo)
  {
    if (paramInt == 0) {
      this.jdField_a_of_type_ComTencentAvServiceLBSInfo = paramLBSInfo;
    }
    String str = C2BLBSUtil.a(paramLBSInfo, new JSONArray());
    if (QLog.isColorLevel()) {
      QLog.d("C2BWebPlugin", 2, "onUpdateAddress ->" + str);
    }
    if ((this.jdField_a_of_type_ComTencentAvServiceLBSInfo != null) && (this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) && (this.jdField_a_of_type_ComTencentAvServiceLBSInfo.equals(paramLBSInfo))) {}
    for (int i = 1; i != 0; i = 0)
    {
      a(0, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentAvServiceLBSInfo);
      return;
    }
    if (paramLBSInfo != null) {
      this.jdField_a_of_type_CooperationC2bC2BWebPlugin.a(this.jdField_a_of_type_JavaLangString, paramInt, str, 0, this.c);
    }
    this.jdField_a_of_type_CooperationC2bC2BLBSUtil.a(this.jdField_a_of_type_CooperationC2bC2BWebPlugin.mRuntime.a(), this.jdField_a_of_type_CooperationC2bC2BWebPlugin.mRuntime.a(), this.b, this, paramLBSInfo);
  }
  
  public void a(int paramInt, ArrayList paramArrayList, LBSInfo paramLBSInfo)
  {
    if (paramInt == 0) {
      this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    }
    JSONObject localJSONObject1;
    if (paramArrayList != null)
    {
      paramLBSInfo = new JSONArray();
      localJSONObject1 = new JSONObject();
      try
      {
        paramArrayList = paramArrayList.iterator();
        for (;;)
        {
          if (paramArrayList.hasNext())
          {
            TroopBarPOI localTroopBarPOI = (TroopBarPOI)paramArrayList.next();
            JSONObject localJSONObject2 = new JSONObject();
            localJSONObject2.put("title", localTroopBarPOI.j);
            localJSONObject2.put("address", localTroopBarPOI.k);
            paramLBSInfo.put(localJSONObject2);
            continue;
            if (!QLog.isColorLevel()) {
              break;
            }
          }
        }
      }
      catch (JSONException paramArrayList)
      {
        paramArrayList = "";
      }
    }
    for (;;)
    {
      QLog.d("C2BWebPlugin", 2, "onUpdatePOI ->" + paramArrayList);
      this.jdField_a_of_type_CooperationC2bC2BWebPlugin.a(this.jdField_a_of_type_JavaLangString, paramInt, paramArrayList, 1, this.d);
      return;
      localJSONObject1.put("nearby", paramLBSInfo);
      paramArrayList = localJSONObject1.toString();
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("C2BWebPlugin", 2, "Get POI fail!");
      }
      paramArrayList = "";
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
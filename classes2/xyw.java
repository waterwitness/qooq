import android.os.Bundle;
import com.tencent.av.service.LBSInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.qphone.base.util.QLog;
import cooperation.c2b.C2BLBSUtil.C2BLBSObserver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class xyw
  implements HttpWebCgiAsyncTask.Callback
{
  private LBSInfo jdField_a_of_type_ComTencentAvServiceLBSInfo;
  private List jdField_a_of_type_JavaUtilList;
  
  public xyw(LBSInfo paramLBSInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentAvServiceLBSInfo = paramLBSInfo;
  }
  
  private void a(int paramInt, ArrayList paramArrayList)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      C2BLBSUtil.C2BLBSObserver localC2BLBSObserver = (C2BLBSUtil.C2BLBSObserver)localIterator.next();
      try
      {
        localC2BLBSObserver.a(paramInt, paramArrayList, this.jdField_a_of_type_ComTencentAvServiceLBSInfo);
      }
      catch (Exception localException) {}
      if (QLog.isColorLevel()) {
        QLog.e("C2BLBSUtil", 2, "Call observer onUpdatePOI fail, we can do nothing", localException);
      }
    }
  }
  
  public void a(C2BLBSUtil.C2BLBSObserver paramC2BLBSObserver)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramC2BLBSObserver);
  }
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    switch (paramInt)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.d("C2BLBSUtil", 2, "onResult unhandle requestCode:" + paramInt);
      }
      break;
    }
    ArrayList localArrayList;
    int i;
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      return;
      localArrayList = new ArrayList();
      paramInt = -3;
      if (paramJSONObject != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("C2BLBSUtil", 2, "onResult result=" + paramJSONObject.toString());
        }
        try
        {
          paramInt = paramJSONObject.getInt("retcode");
          if (paramInt != 0) {}
        }
        catch (JSONException paramBundle)
        {
          try
          {
            paramBundle = paramJSONObject.getJSONObject("result");
            paramJSONObject = paramBundle;
            i = paramInt;
            if (paramJSONObject == null) {}
          }
          catch (JSONException paramBundle)
          {
            for (;;)
            {
              try
              {
                paramJSONObject = paramJSONObject.getJSONArray("poilist");
                int j = 0;
                i = paramInt;
                if (j >= paramJSONObject.length()) {
                  break;
                }
                localArrayList.add(new TroopBarPOI(paramJSONObject.getJSONObject(j)));
                j += 1;
                continue;
                paramBundle = paramBundle;
                paramBundle.printStackTrace();
                paramInt = -3;
              }
              catch (JSONException paramJSONObject)
              {
                i = -2;
                paramJSONObject.printStackTrace();
              }
              paramBundle = paramBundle;
              try
              {
                i = paramJSONObject.optInt("retcode", -1);
                paramInt = i;
                if (i != 0) {
                  paramInt = paramJSONObject.optInt("errno", -1);
                }
                if (QLog.isColorLevel()) {
                  QLog.d("C2BLBSUtil", 2, "Get poi data error, error code = " + paramInt);
                }
                paramJSONObject = null;
                paramInt = -1;
              }
              catch (Exception paramJSONObject)
              {
                paramJSONObject = null;
                paramInt = -1;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      a(i, localArrayList);
      break;
      i = paramInt;
      if (QLog.isColorLevel())
      {
        QLog.e("C2BLBSUtil", 2, "Get poi data error, result == null, errorCode = " + -3);
        i = paramInt;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xyw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
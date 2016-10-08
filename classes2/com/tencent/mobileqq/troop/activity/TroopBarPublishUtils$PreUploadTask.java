package com.tencent.mobileqq.troop.activity;

import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.jsp.MediaApiPlugin;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import mqq.manager.TicketManager;
import mqq.util.WeakReference;
import org.json.JSONObject;

public class TroopBarPublishUtils$PreUploadTask
  implements Runnable
{
  protected String a;
  protected ArrayList a;
  protected WeakReference a;
  protected boolean a;
  
  public TroopBarPublishUtils$PreUploadTask(BaseActivity paramBaseActivity, ArrayList paramArrayList, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramArrayList);
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramBaseActivity);
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void run()
  {
    BaseActivity localBaseActivity;
    if (this.jdField_a_of_type_MqqUtilWeakReference == null)
    {
      localBaseActivity = null;
      if ((localBaseActivity != null) && (localBaseActivity.app != null)) {
        break label49;
      }
      if (QLog.isColorLevel()) {
        QLog.d("TroopBarPublishUtils", 2, "PreUploadTask activity is null!");
      }
    }
    label49:
    label220:
    for (;;)
    {
      return;
      localBaseActivity = (BaseActivity)this.jdField_a_of_type_MqqUtilWeakReference.get();
      break;
      String str1 = localBaseActivity.app.a();
      String str2 = ((TicketManager)localBaseActivity.app.getManager(2)).getSkey(str1);
      if (!TextUtils.isEmpty(str2))
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label220;
          }
          String str3 = (String)localIterator.next();
          if ((localBaseActivity.isFinishing()) || (this.jdField_a_of_type_Boolean)) {
            break;
          }
          if ((TroopBarPublishActivity.Pic_list)TroopBarUtils.a.get(str3) == null)
          {
            Object localObject = MediaApiPlugin.a(str3, 0);
            if (!TextUtils.isEmpty((CharSequence)localObject))
            {
              HashMap localHashMap = new HashMap();
              localHashMap.put("type", "2");
              localObject = TroopBarUtils.a(this.jdField_a_of_type_JavaLangString, localBaseActivity, (String)localObject, str1, str2, localHashMap);
              if (localObject != null)
              {
                localObject = new TroopBarPublishActivity.Pic_list((JSONObject)localObject);
                TroopBarUtils.a.put(str3, localObject);
              }
            }
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\activity\TroopBarPublishUtils$PreUploadTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
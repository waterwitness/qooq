package com.tencent.mobileqq.troop.activity;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
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

public class TroopBarPublishUtils$PicUploadThread
  implements Runnable
{
  protected Handler a;
  protected String a;
  protected ArrayList a;
  protected WeakReference a;
  
  public TroopBarPublishUtils$PicUploadThread(BaseActivity paramBaseActivity, Handler paramHandler, ArrayList paramArrayList, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramArrayList);
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramBaseActivity);
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_MqqUtilWeakReference == null)
    {
      localObject1 = null;
      if ((localObject1 != null) && (((BaseActivity)localObject1).app != null)) {
        break label69;
      }
      if (QLog.isColorLevel()) {
        QLog.d("TroopBarPublishUtils", 2, "PicUploadThread activity is null!");
      }
      localObject1 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1001);
      this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject1);
    }
    label69:
    String str1;
    label312:
    do
    {
      return;
      localObject1 = (BaseActivity)this.jdField_a_of_type_MqqUtilWeakReference.get();
      break;
      String str2 = ((BaseActivity)localObject1).app.a();
      String str3 = ((TicketManager)((BaseActivity)localObject1).app.getManager(2)).getSkey(str2);
      if (TextUtils.isEmpty(str3))
      {
        localObject1 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1001);
        this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject1);
        return;
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label369;
        }
        str1 = (String)localIterator.next();
        if ((TroopBarPublishActivity.Pic_list)TroopBarUtils.a.get(str1) == null)
        {
          if (((BaseActivity)localObject1).isFinishing()) {
            break;
          }
          Object localObject2 = MediaApiPlugin.a(str1, 0);
          if (TextUtils.isEmpty((CharSequence)localObject2))
          {
            localObject1 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1001);
            ((Message)localObject1).obj = str1;
            this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject1);
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("TroopBarPublishUtils", 2, "scalePublishImage failed: path = " + str1);
            return;
          }
          HashMap localHashMap = new HashMap();
          localHashMap.put("type", "2");
          localObject2 = TroopBarUtils.a(this.jdField_a_of_type_JavaLangString, (Context)localObject1, (String)localObject2, str2, str3, localHashMap);
          if (localObject2 == null) {
            break label312;
          }
          localObject2 = new TroopBarPublishActivity.Pic_list((JSONObject)localObject2);
          TroopBarUtils.a.put(str1, localObject2);
        }
      }
      localObject1 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1001);
      ((Message)localObject1).obj = str1;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject1);
    } while (!QLog.isColorLevel());
    QLog.d("TroopBarPublishUtils", 2, "scalePublishImage failed: path = " + str1);
    return;
    label369:
    Object localObject1 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1003);
    this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject1);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\activity\TroopBarPublishUtils$PicUploadThread.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
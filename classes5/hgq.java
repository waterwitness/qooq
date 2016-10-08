import android.os.Handler;
import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.offline.util.IThreadManager;
import com.tencent.biz.common.util.NetworkUtil;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.webviewplugin.OfflinePlugin;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

class hgq
  implements AsyncBack
{
  hgq(hgp paramhgp, long paramLong)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt) {}
  
  public void a(String paramString, int paramInt)
  {
    boolean bool = true;
    int i = 0;
    int j = (int)(System.currentTimeMillis() - this.jdField_a_of_type_Long);
    if ((HtmlOffline.a != null) && (HtmlOffline.a.containsKey(this.jdField_a_of_type_Hgp.jdField_a_of_type_JavaLangString))) {
      HtmlOffline.a.remove(this.jdField_a_of_type_Hgp.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_Hgp.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
    if (paramInt == 0)
    {
      OfflinePlugin.d(this.jdField_a_of_type_Hgp.jdField_a_of_type_JavaLangString);
      if (this.jdField_a_of_type_Hgp.jdField_b_of_type_Boolean)
      {
        if (!HtmlOffline.c(this.jdField_a_of_type_Hgp.jdField_a_of_type_JavaLangString))
        {
          Util.b(this.jdField_a_of_type_Hgp.jdField_b_of_type_JavaLangString);
          Util.a(HtmlOffline.a(this.jdField_a_of_type_Hgp.jdField_a_of_type_JavaLangString) + this.jdField_a_of_type_Hgp.jdField_a_of_type_JavaLangString);
          paramString = this.jdField_a_of_type_Hgp.jdField_a_of_type_AndroidOsHandler.obtainMessage(2, 10, j);
          this.jdField_a_of_type_Hgp.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString);
          HtmlOffline.a(this.jdField_a_of_type_Hgp.jdField_a_of_type_JavaLangString, 14, 0L, NetworkUtil.a(hgp.jdField_a_of_type_AndroidContentContext), "lixian_update", "0");
          OfflinePlugin.a(this.jdField_a_of_type_Hgp.jdField_a_of_type_JavaLangString, "Offline_Update_BSDiff", j, 14, "", "", "");
        }
      }
      else if (((this.jdField_a_of_type_Hgp.d) || (this.jdField_a_of_type_Hgp.e)) && (!this.jdField_a_of_type_Hgp.b()))
      {
        QLog.e(hgp.a(), 1, "businessId " + this.jdField_a_of_type_Hgp.jdField_a_of_type_JavaLangString + " now un compress file error! " + this.jdField_a_of_type_Hgp.jdField_b_of_type_JavaLangString);
        return;
      }
      if (2 == this.jdField_a_of_type_Hgp.jdField_a_of_type_Int)
      {
        bool = HtmlOffline.d(this.jdField_a_of_type_Hgp.jdField_a_of_type_JavaLangString);
        paramString = this.jdField_a_of_type_Hgp.jdField_a_of_type_AndroidOsHandler.obtainMessage(2, -1, j);
        this.jdField_a_of_type_Hgp.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString);
      }
      while (this.jdField_a_of_type_Hgp.jdField_b_of_type_Boolean)
      {
        OfflinePlugin.a(this.jdField_a_of_type_Hgp.jdField_a_of_type_JavaLangString, "Offline_Update_BSDiff", j, 0, "", "", "");
        HtmlOffline.a(this.jdField_a_of_type_Hgp.jdField_a_of_type_JavaLangString, paramInt, j, NetworkUtil.a(hgp.jdField_a_of_type_AndroidContentContext), "lixian_update", this.jdField_a_of_type_Hgp.c + "");
        return;
        if (this.jdField_a_of_type_Hgp.jdField_a_of_type_Boolean) {
          bool = HtmlOffline.d(this.jdField_a_of_type_Hgp.jdField_a_of_type_JavaLangString);
        }
        paramString = this.jdField_a_of_type_Hgp.jdField_a_of_type_AndroidOsHandler.obtainMessage(2, 0, j);
        this.jdField_a_of_type_Hgp.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString);
      }
      paramString = this.jdField_a_of_type_Hgp.jdField_a_of_type_JavaLangString;
      if (bool) {}
      for (;;)
      {
        OfflinePlugin.a(paramString, "Offline_Update", j, i, "", "", "");
        break;
        i = 13;
      }
    }
    hgp.a(this.jdField_a_of_type_Hgp);
    if (hgp.b(this.jdField_a_of_type_Hgp) < 3)
    {
      hgp.jdField_a_of_type_ComTencentBizCommonOfflineUtilIThreadManager.c(new hgr(this));
      return;
    }
    paramString = this.jdField_a_of_type_Hgp.jdField_a_of_type_AndroidOsHandler.obtainMessage(2, 2, j);
    this.jdField_a_of_type_Hgp.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString);
    HtmlOffline.a(this.jdField_a_of_type_Hgp.jdField_a_of_type_JavaLangString, paramInt, j, NetworkUtil.a(hgp.jdField_a_of_type_AndroidContentContext), "lixian_update", this.jdField_a_of_type_Hgp.c + "");
    OfflinePlugin.a(this.jdField_a_of_type_Hgp.jdField_a_of_type_JavaLangString, "Offline_Update", j, paramInt, "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hgq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
import android.content.Context;
import android.content.res.Resources;
import com.facebook.react.bridge.ReadableMap;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.rn.QQBaseModule;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public class ujv
  implements Runnable
{
  public ujv(QQBaseModule paramQQBaseModule, ReadableMap paramReadableMap)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int k = 1;
    int j = 0;
    String str;
    int i;
    if (this.jdField_a_of_type_ComFacebookReactBridgeReadableMap.hasKey("icon"))
    {
      str = this.jdField_a_of_type_ComFacebookReactBridgeReadableMap.getString("icon");
      if ("info".equals(Integer.valueOf(-1))) {
        i = 0;
      }
    }
    for (;;)
    {
      str = "";
      if (this.jdField_a_of_type_ComFacebookReactBridgeReadableMap.hasKey("msg")) {
        str = this.jdField_a_of_type_ComFacebookReactBridgeReadableMap.getString("msg");
      }
      if (this.jdField_a_of_type_ComFacebookReactBridgeReadableMap.hasKey("duration")) {
        j = this.jdField_a_of_type_ComFacebookReactBridgeReadableMap.getInt("duration");
      }
      BaseApplication localBaseApplication = BaseApplication.getContext();
      k = localBaseApplication.getResources().getDimensionPixelSize(2131492908);
      QQToast.a(localBaseApplication, i, str, j).b(k);
      return;
      if ("suc".equals(str))
      {
        i = 2;
      }
      else
      {
        i = k;
        if (!"warn".equals(str))
        {
          i = k;
          if (!"warn2".equals(str)) {
            if ("none".equals(str)) {
              i = -1;
            } else {
              i = -1;
            }
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ujv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
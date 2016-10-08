import android.app.Activity;
import com.tencent.biz.common.util.Util;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.jsp.DataApiPlugin;

class sxn
  implements Runnable
{
  sxn(sxm paramsxm, Activity paramActivity, String paramString, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (!this.jdField_a_of_type_AndroidAppActivity.isFinishing())
    {
      if (this.jdField_a_of_type_JavaLangString == null) {
        this.jdField_a_of_type_Sxm.a.callJs(this.jdField_a_of_type_Sxm.c, new String[] { "null", Integer.toString(this.jdField_a_of_type_Int) });
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Sxm.a.callJs(this.jdField_a_of_type_Sxm.c, new String[] { Util.b(this.jdField_a_of_type_JavaLangString), Integer.toString(this.jdField_a_of_type_Int) });
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\sxn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
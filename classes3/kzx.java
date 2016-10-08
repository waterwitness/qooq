import android.view.View;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

class kzx
  implements Runnable
{
  kzx(kzw paramkzw, ArrayList paramArrayList)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return;
    }
    View localView = this.jdField_a_of_type_Kzw.a.a[12];
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)) {
      localView.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_Kzw.a.a(12, localView, this.jdField_a_of_type_JavaUtilArrayList, true, true);
      return;
      localView.setVisibility(0);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kzx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
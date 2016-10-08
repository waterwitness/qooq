import android.content.res.Resources;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQSettingSettingActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class mhb
  implements Runnable
{
  mhb(mha parammha, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_Mha.a.getResources();
    String str = ((Resources)localObject).getString(2131370785);
    if (this.jdField_a_of_type_Long != 0L) {
      localObject = str + ((Resources)localObject).getString(2131370788);
    }
    for (;;)
    {
      this.jdField_a_of_type_Mha.a.e.setText((CharSequence)localObject);
      return;
      if ((this.b != 0L) || (!this.jdField_a_of_type_Boolean)) {
        localObject = str + ((Resources)localObject).getString(2131370787);
      } else {
        localObject = str + ((Resources)localObject).getString(2131370786);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mhb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
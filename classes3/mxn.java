import android.os.Handler;
import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class mxn
  extends TroopObserver
{
  public mxn(TroopRequestActivity paramTroopRequestActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(int paramInt, byte paramByte)
  {
    if ((paramInt == 4) || (paramInt == 5) || (paramInt == 6) || (paramInt == 7)) {
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    }
    if (paramInt == 8) {
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    }
  }
  
  protected void a(int paramInt, byte paramByte, String paramString)
  {
    if ((paramInt == 4) || (paramInt == 5) || (paramInt == 6) || (paramInt == 7))
    {
      if (paramByte != 0) {
        break label68;
      }
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
      this.a.finish();
    }
    for (;;)
    {
      if (paramInt == 8)
      {
        if (paramByte != 0) {
          break;
        }
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
      }
      return;
      label68:
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    }
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
  }
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt1, TroopInfo paramTroopInfo, int paramInt2, String paramString)
  {
    if (this.a.r == null) {}
    do
    {
      for (;;)
      {
        return;
        this.a.r = this.a.r.trim();
        try
        {
          long l = Long.parseLong(this.a.r);
          if (paramLong != l) {}
        }
        catch (NumberFormatException paramString)
        {
          for (;;)
          {
            if (QLog.isColorLevel())
            {
              QLog.e("Q.systemmsg.TroopRequestActivity", 2, "onOIDB0X88D_1_Ret=>NumberFormatException");
              continue;
              QQToast.a(this.a.app.getApplication(), 2131368626, 0).b(this.a.getTitleBarHeight());
            }
          }
          this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
        }
      }
      this.a.i();
      if (!paramBoolean) {
        break label215;
      }
      if ((paramTroopInfo.cGroupOption == 4) || (paramTroopInfo.cGroupOption == 5))
      {
        this.a.J = paramTroopInfo.joinTroopQuestion;
        this.a.K = paramTroopInfo.joinTroopAnswer;
      }
      this.a.jdField_a_of_type_Short = paramTroopInfo.cGroupOption;
      if (this.a.jdField_a_of_type_Short == 3) {
        break;
      }
      TroopRequestActivity.a(this.a);
    } while (!QLog.isColorLevel());
    QLog.i("Q.systemmsg.TroopRequestActivity", 2, "troop.cGroupOption = " + paramTroopInfo.cGroupOption);
    return;
    label215:
  }
  
  protected void b(boolean paramBoolean, long paramLong, int paramInt1, TroopInfo paramTroopInfo, int paramInt2, String paramString)
  {
    if (this.a.r == null) {}
    do
    {
      for (;;)
      {
        return;
        try
        {
          this.a.r = this.a.r.trim();
          long l = Long.parseLong(this.a.r);
          if (paramLong != l) {}
        }
        catch (NumberFormatException paramString)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("Q.systemmsg.TroopRequestActivity", 2, "onOIDB0X88D_10_Ret=>NumberFormatException");
            }
          }
        }
      }
      this.a.i();
    } while ((!paramBoolean) || (paramTroopInfo == null));
    ThreadManager.a(new mxo(this, paramTroopInfo), 8, null, true);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mxn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
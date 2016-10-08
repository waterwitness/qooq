import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.qcall.LightalkShieldObserver;
import com.tencent.mobileqq.qcall.QCallDetailActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class tzq
  extends LightalkShieldObserver
{
  public tzq(QCallDetailActivity paramQCallDetailActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.d("lightalk_shield_activity", 2, "onShieldQuery| isSuccess:" + paramBoolean);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    super.a(paramBoolean, paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("lightalk_shield_activity", 2, "onShieldAdd| isSuccess:" + paramBoolean + " ret:" + paramInt);
    }
    if ((!paramBoolean) && (QCallDetailActivity.a(this.a) == 26)) {
      QQToast.a(this.a, 1, "添加屏蔽失败", 0).a();
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    super.a(paramBoolean1, paramBoolean2);
    if ((paramBoolean1) && (QLog.isColorLevel())) {
      QLog.d("lightalk_shield_activity", 2, "onShieldCheck| isSuccess:" + paramBoolean1 + " isBlock:" + paramBoolean2);
    }
  }
  
  public void b(boolean paramBoolean, int paramInt)
  {
    super.b(paramBoolean, paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("lightalk_shield_activity", 2, "onShieldRemove| isSuccess:" + paramBoolean + " ret:" + paramInt);
    }
    if ((!paramBoolean) && (QCallDetailActivity.a(this.a) == 26)) {
      QQToast.a(this.a, 1, "移除屏蔽失败", 0).a();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tzq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
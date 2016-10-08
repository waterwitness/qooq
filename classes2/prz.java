import android.text.TextUtils;
import com.tencent.mobileqq.apollo.ApolloRenderInterfaceImpl;
import com.tencent.mobileqq.apollo.ApolloTextureView;
import com.tencent.mobileqq.apollo.IRenderCallback;
import com.tencent.mobileqq.apollo.barrage.BarrageView;
import com.tencent.mobileqq.apollo.store.ApolloStoreActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;

public class prz
  implements IRenderCallback
{
  public prz(ApolloStoreActivity paramApolloStoreActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    if (!"me".equals(paramString)) {}
    for (;;)
    {
      return;
      this.a.a();
      paramString = this.a.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(18, 1, 0);
      this.a.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessage(paramString);
      this.a.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.a(1000L);
      if (!TextUtils.isEmpty(ApolloStoreActivity.a(this.a)))
      {
        if (!ApolloStoreActivity.a(this.a)) {
          break label126;
        }
        if ((ApolloStoreActivity.b(this.a) == 1) && (this.a.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView != null)) {
          this.a.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView.b();
        }
      }
      while (QLog.isColorLevel())
      {
        QLog.d("ApolloStoreActivity", 2, "mSurfaceView onCompleteRender");
        return;
        label126:
        if (ApolloStoreActivity.b(this.a) == 1)
        {
          if (this.a.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView != null) {
            this.a.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView.a(true);
          }
        }
        else {
          this.a.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.a().a(1, "Bubble");
        }
      }
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (!"me".equals(paramString)) {}
    do
    {
      return;
      this.a.d(ApolloStoreActivity.a(this.a));
    } while (!QLog.isColorLevel());
    QLog.d("ApolloStoreActivity", 2, "mSurfaceView onStartRender");
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\prz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
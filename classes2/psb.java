import android.text.TextUtils;
import com.tencent.mobileqq.apollo.ApolloRenderInterfaceImpl;
import com.tencent.mobileqq.apollo.ApolloTextureView;
import com.tencent.mobileqq.apollo.IRenderCallback;
import com.tencent.mobileqq.apollo.barrage.BarrageView;
import com.tencent.mobileqq.apollo.store.ApolloStoreActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.lang.ref.WeakReference;

public class psb
  implements IRenderCallback
{
  WeakReference a;
  
  public psb(ApolloStoreActivity paramApolloStoreActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = new WeakReference(paramApolloStoreActivity);
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    if (!"me".equals(paramString)) {}
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              if (QLog.isColorLevel()) {
                QLog.d("ApolloStoreActivity", 2, "mOtherSurfaceView onCompleteRender");
              }
            } while (this.a == null);
            paramString = (ApolloStoreActivity)this.a.get();
          } while ((paramString == null) || (paramString.b == null));
          paramString.a();
          paramString.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(15);
          paramString.b.a(1000L);
        } while (TextUtils.isEmpty(ApolloStoreActivity.a(paramString)));
        if (!ApolloStoreActivity.a(paramString)) {
          break;
        }
      } while ((ApolloStoreActivity.b(paramString) != 1) || (paramString.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView == null));
      paramString.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView.b();
      return;
      if (ApolloStoreActivity.b(paramString) != 1) {
        break;
      }
    } while (paramString.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView == null);
    paramString.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView.a(true);
    return;
    paramString.b.a().a(1, "Bubble");
  }
  
  public void a(int paramInt, String paramString)
  {
    if (!"me".equals(paramString)) {}
    do
    {
      do
      {
        return;
      } while (this.a == null);
      paramString = (ApolloStoreActivity)this.a.get();
      if ((paramString != null) && (paramString.b != null)) {
        paramString.d(ApolloStoreActivity.a(paramString));
      }
    } while (!QLog.isColorLevel());
    QLog.d("ApolloStoreActivity", 2, "mOtherSurfaceView onStartRender");
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\psb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
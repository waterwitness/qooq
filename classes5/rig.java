import android.os.Bundle;
import com.tencent.mobileqq.apollo.store.ApolloResDownloader.OnApolloDownLoadListener;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class rig
  implements ApolloResDownloader.OnApolloDownLoadListener
{
  rig(rhz paramrhz, int paramInt1, int[] paramArrayOfInt, int paramInt2, int paramInt3, int paramInt4, float paramFloat, Bundle paramBundle, MessengerService paramMessengerService)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    paramArrayOfInt = new Bundle();
    if (paramBoolean)
    {
      paramArrayOfInt.putInt("apollo_result", 0);
      paramArrayOfInt.putInt("apollo_roleId", this.jdField_a_of_type_Int);
      paramArrayOfInt.putIntArray("apollo_dressIds", this.jdField_a_of_type_ArrayOfInt);
      paramArrayOfInt.putInt("apollo_x", this.b);
      paramArrayOfInt.putInt("apollo_y", this.c);
      paramArrayOfInt.putInt("apollo_type", this.d);
      paramArrayOfInt.putFloat("apollo_rate", this.jdField_a_of_type_Float);
      paramArrayOfInt.putString("apollo_uin", paramString);
      this.jdField_a_of_type_AndroidOsBundle.putBundle("response", paramArrayOfInt);
      this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService.a(this.jdField_a_of_type_AndroidOsBundle);
      return;
    }
    paramArrayOfInt.putInt("apollo_result", 1);
    this.jdField_a_of_type_AndroidOsBundle.putBundle("response", paramArrayOfInt);
    this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService.a(this.jdField_a_of_type_AndroidOsBundle);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
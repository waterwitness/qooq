import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.business.sougou.WordMatchManager;
import com.tencent.mobileqq.business.sougou.WordMatchManager.HotWordMatcher;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class quy
  implements Runnable
{
  public quy(WordMatchManager.HotWordMatcher paramHotWordMatcher, byte[] paramArrayOfByte1, int paramInt, int[] paramArrayOfInt, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$HotWordMatcher.Match(this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Int, this.jdField_a_of_type_ArrayOfInt, this.b, this.c, this.d, this.e);
      if (!bool) {
        this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$HotWordMatcher.a.a.runOnUiThread(new quz(this));
      }
      return;
    }
    catch (Exception localException)
    {
      localException = localException;
      this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$HotWordMatcher.a.a.runOnUiThread(new quz(this));
      return;
    }
    finally
    {
      localObject = finally;
      this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$HotWordMatcher.a.a.runOnUiThread(new quz(this));
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\quy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
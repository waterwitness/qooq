import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.Message;
import android.widget.RelativeLayout;
import com.tencent.biz.common.util.ImageUtil;
import com.tencent.mobileqq.apollo.store.ApolloImageShareLayout;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.lang.ref.WeakReference;

public class prv
  implements Runnable
{
  private final int jdField_a_of_type_Int;
  private final long jdField_a_of_type_Long;
  WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private final int[] jdField_a_of_type_ArrayOfInt;
  private final int b;
  private final int c;
  
  public prv(ApolloImageShareLayout paramApolloImageShareLayout, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramApolloImageShareLayout);
    this.b = paramInt1;
    this.c = paramInt2;
    this.jdField_a_of_type_Int = paramInt3;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_ArrayOfInt = paramArrayOfInt;
  }
  
  public void run()
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_ArrayOfInt == null)) {}
    ApolloImageShareLayout localApolloImageShareLayout;
    do
    {
      return;
      localApolloImageShareLayout = (ApolloImageShareLayout)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while ((localApolloImageShareLayout == null) || (ApolloImageShareLayout.a(localApolloImageShareLayout) == null) || (localApolloImageShareLayout.jdField_a_of_type_ComTencentUtilWeakReferenceHandler == null));
    for (;;)
    {
      int i;
      try
      {
        Object localObject1 = new int[this.b * this.c];
        i = 0;
        int j = 0;
        if (j < this.c)
        {
          int k = 0;
          if (k < this.b)
          {
            int m = this.jdField_a_of_type_ArrayOfInt[(this.b * j + k)];
            localObject1[((this.c - i - 1) * this.b + k)] = (m & 0xFF00FF00 | m << 16 & 0xFFFF0000 | m >> 16 & 0xFF);
            k += 1;
            continue;
          }
        }
        else
        {
          localObject1 = Bitmap.createBitmap((int[])localObject1, this.b, this.c, Bitmap.Config.ARGB_8888);
          if (localObject1 != null)
          {
            Object localObject3 = Bitmap.createBitmap(ApolloImageShareLayout.a(localApolloImageShareLayout).getWidth(), ApolloImageShareLayout.a(localApolloImageShareLayout).getHeight(), Bitmap.Config.ARGB_8888);
            if (localObject3 != null)
            {
              Canvas localCanvas = new Canvas((Bitmap)localObject3);
              Bitmap localBitmap = ApolloImageShareLayout.a(localApolloImageShareLayout).getDrawingCache();
              if (localBitmap != null) {
                localCanvas.drawBitmap(localBitmap, 0.0F, 0.0F, null);
              }
              localCanvas.drawBitmap((Bitmap)localObject1, (ApolloImageShareLayout.a(localApolloImageShareLayout).getWidth() - ((Bitmap)localObject1).getWidth()) / 2, ApolloImageShareLayout.a(localApolloImageShareLayout), null);
              localObject1 = ImageUtil.a((Bitmap)localObject3);
              localObject3 = localApolloImageShareLayout.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(this.jdField_a_of_type_Int);
              ((Message)localObject3).obj = localObject1;
              ((Message)localObject3).sendToTarget();
            }
          }
          else
          {
            return;
          }
          QLog.e("ApolloImageShareLayout", 2, "error! layout.mBackLayout.getDrawingCache() null");
          continue;
        }
        j += 1;
      }
      catch (Exception localException)
      {
        QLog.e("ApolloImageShareLayout", 2, localException.getMessage());
        return;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        QLog.e("ApolloImageShareLayout", 2, localOutOfMemoryError.getMessage());
        return;
      }
      finally
      {
        localApolloImageShareLayout.jdField_a_of_type_Boolean = false;
      }
      i += 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\prv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
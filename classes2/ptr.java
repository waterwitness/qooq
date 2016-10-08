import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import com.tencent.mobileqq.apollo.view.SimpleFrameZipDecoder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.lang.ref.WeakReference;

public class ptr
  extends AsyncTask
{
  private int jdField_a_of_type_Int;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  
  public ptr(SimpleFrameZipDecoder paramSimpleFrameZipDecoder, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramSimpleFrameZipDecoder);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  protected Bitmap a(Integer... paramVarArgs)
  {
    SimpleFrameZipDecoder localSimpleFrameZipDecoder = (SimpleFrameZipDecoder)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (localSimpleFrameZipDecoder != null)
    {
      localObject1 = localObject2;
      if (paramVarArgs != null)
      {
        localObject1 = localObject2;
        if (paramVarArgs.length <= 0) {}
      }
    }
    for (;;)
    {
      try
      {
        paramVarArgs = localSimpleFrameZipDecoder.b + paramVarArgs[0];
        if (0 != 0) {
          break label128;
        }
        paramVarArgs = BitmapFactory.decodeStream(new BufferedInputStream(new FileInputStream(paramVarArgs)));
        localObject1 = paramVarArgs;
      }
      catch (OutOfMemoryError paramVarArgs)
      {
        localObject1 = localObject2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("SimpleFrameZipDecoder", 2, paramVarArgs.getMessage());
        return null;
      }
      catch (Throwable paramVarArgs)
      {
        localObject1 = localObject2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("SimpleFrameZipDecoder", 2, paramVarArgs.getMessage());
        return null;
      }
      return (Bitmap)localObject1;
      label128:
      paramVarArgs = null;
    }
  }
  
  protected void a(Bitmap paramBitmap)
  {
    super.onPostExecute(paramBitmap);
    SimpleFrameZipDecoder localSimpleFrameZipDecoder = (SimpleFrameZipDecoder)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localSimpleFrameZipDecoder != null) && (paramBitmap != null) && (!paramBitmap.isRecycled())) {
      localSimpleFrameZipDecoder.a(paramBitmap, this.jdField_a_of_type_Int);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ptr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
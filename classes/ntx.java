import android.app.Activity;
import android.os.AsyncTask;
import com.dataline.util.file.FileUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public final class ntx
  extends AsyncTask
{
  public ntx(File paramFile1, File paramFile2, Activity paramActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected String a(Void... paramVarArgs)
  {
    paramVarArgs = this.jdField_a_of_type_JavaIoFile.getAbsolutePath();
    try
    {
      if (FileUtil.a(this.b, this.jdField_a_of_type_JavaIoFile))
      {
        ImageUtil.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaIoFile.getAbsolutePath());
        return this.jdField_a_of_type_AndroidAppActivity.getString(2131368777) + " " + paramVarArgs;
      }
      paramVarArgs = this.jdField_a_of_type_AndroidAppActivity.getString(2131368778);
      return paramVarArgs;
    }
    catch (OutOfMemoryError paramVarArgs)
    {
      paramVarArgs = this.jdField_a_of_type_AndroidAppActivity.getString(2131368778);
      if (QLog.isColorLevel()) {
        QLog.e("AIOGalleryUtils", 2, "savePhoto  OOM ");
      }
    }
    return paramVarArgs;
  }
  
  protected void a(String paramString)
  {
    if ((this.jdField_a_of_type_AndroidAppActivity instanceof BaseActivity)) {}
    for (int i = ((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).getTitleBarHeight();; i = 0)
    {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 2, paramString, 0).b(i);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ntx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
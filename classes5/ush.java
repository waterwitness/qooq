import android.os.AsyncTask;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.ptvfilter.utils.FileUtils;
import com.tencent.mobileqq.shortvideo.ptvfilter.utils.FileUtils.OnFileCopyListener;
import java.io.InputStream;

public class ush
  extends AsyncTask
{
  FileUtils.OnFileCopyListener jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterUtilsFileUtils$OnFileCopyListener;
  InputStream jdField_a_of_type_JavaIoInputStream;
  String jdField_a_of_type_JavaLangString;
  
  public ush(InputStream paramInputStream, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaIoInputStream = paramInputStream;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  protected Boolean a(String... paramVarArgs)
  {
    return Boolean.valueOf(FileUtils.a(this.jdField_a_of_type_JavaIoInputStream, this.jdField_a_of_type_JavaLangString));
  }
  
  public void a(FileUtils.OnFileCopyListener paramOnFileCopyListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterUtilsFileUtils$OnFileCopyListener = paramOnFileCopyListener;
  }
  
  protected void a(Boolean paramBoolean)
  {
    super.onPostExecute(paramBoolean);
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterUtilsFileUtils$OnFileCopyListener != null)
    {
      if (paramBoolean.booleanValue()) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterUtilsFileUtils$OnFileCopyListener.b();
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterUtilsFileUtils$OnFileCopyListener.c();
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterUtilsFileUtils$OnFileCopyListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterUtilsFileUtils$OnFileCopyListener.a();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ush.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
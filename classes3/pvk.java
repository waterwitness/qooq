import android.util.SparseArray;
import com.tencent.mobileqq.app.ClubContentUpdateHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileFilter;
import org.json.JSONObject;

public class pvk
  implements FileFilter
{
  public pvk(ClubContentUpdateHandler paramClubContentUpdateHandler, SparseArray paramSparseArray)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean accept(File paramFile)
  {
    Object localObject = new File(paramFile, "config.json");
    if ((((File)localObject).exists()) && (((File)localObject).isFile())) {
      localObject = FileUtils.a((File)localObject);
    }
    try
    {
      int i = Integer.parseInt(paramFile.getName());
      long l = new JSONObject((String)localObject).optLong("version");
      this.jdField_a_of_type_AndroidUtilSparseArray.append(i, Long.valueOf(l));
      QLog.i("ClubContentUpdateHandler", 1, "getApolloRoleReqInfo roleId: " + i + ", ver: " + l / 1000L);
      return false;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ClubContentUpdateHandler", 1, "getApolloRoleReqInfo failed role: " + paramFile.getAbsolutePath());
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pvk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
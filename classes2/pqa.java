import android.text.TextUtils;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.json.JSONObject;

public class pqa
  implements Runnable
{
  public pqa(ApolloManager paramApolloManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject13 = null;
    Object localObject7 = null;
    Object localObject9 = null;
    if (this.a.jdField_a_of_type_OrgJsonJSONObject == null) {}
    label431:
    for (;;)
    {
      return;
      if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {}
      Object localObject6;
      for (Object localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();; localObject6 = null)
      {
        if (localObject1 == null) {
          break label431;
        }
        localObject1 = new File(ApolloConstant.j);
        ((File)localObject1).mkdirs();
        File localFile = new File((File)localObject1, "apollo_res_version_info.json");
        if (localFile.exists()) {
          localFile.delete();
        }
        localObject1 = localObject7;
        try
        {
          JSONObject localJSONObject = this.a.jdField_a_of_type_OrgJsonJSONObject;
          localObject1 = localObject7;
          try
          {
            String str = this.a.jdField_a_of_type_OrgJsonJSONObject.toString();
            localObject1 = localObject7;
            boolean bool = TextUtils.isEmpty(str);
            if (bool)
            {
              if (0 == 0) {
                break;
              }
              try
              {
                throw new NullPointerException();
              }
              catch (IOException localIOException1) {}
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("ApolloManager", 2, localIOException1.getMessage());
              return;
            }
          }
          finally
          {
            localObject2 = localObject7;
          }
        }
        catch (FileNotFoundException localFileNotFoundException1)
        {
          localObject7 = null;
          Object localObject2 = localObject7;
          try
          {
            if (QLog.isColorLevel())
            {
              localObject2 = localObject7;
              QLog.d("ApolloManager", 2, localFileNotFoundException1.getMessage());
            }
            if (localObject7 == null) {
              break;
            }
            try
            {
              ((FileOutputStream)localObject7).close();
              return;
            }
            catch (IOException localIOException2) {}
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("ApolloManager", 2, localIOException2.getMessage());
            return;
          }
          finally
          {
            for (;;)
            {
              Object localObject3;
              Object localObject10;
              Object localObject4;
              Object localObject5;
              Object localObject8 = localObject6;
              localObject6 = localObject12;
            }
          }
          localObject3 = localObject7;
          localObject7 = new FileOutputStream(localFile);
          localObject3 = localObject7;
        }
        catch (OutOfMemoryError localOutOfMemoryError1)
        {
          localOutOfMemoryError1 = localOutOfMemoryError1;
          localObject7 = localFileNotFoundException1;
          localObject10 = localOutOfMemoryError1;
          localObject4 = localObject7;
          if (QLog.isColorLevel())
          {
            localObject4 = localObject7;
            QLog.d("ApolloManager", 2, ((OutOfMemoryError)localObject10).getMessage());
          }
          if (localObject7 == null) {
            break;
          }
          try
          {
            ((FileOutputStream)localObject7).close();
            return;
          }
          catch (IOException localIOException4) {}
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("ApolloManager", 2, localIOException4.getMessage());
          return;
        }
        catch (Exception localException1)
        {
          localObject7 = localObject13;
          localObject5 = localObject7;
          if (QLog.isColorLevel())
          {
            localObject5 = localObject7;
            QLog.d("ApolloManager", 2, localException1.getMessage());
          }
          if (localObject7 == null) {
            break;
          }
          try
          {
            ((FileOutputStream)localObject7).close();
            return;
          }
          catch (IOException localIOException5) {}
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("ApolloManager", 2, localIOException5.getMessage());
          return;
        }
        finally
        {
          for (;;)
          {
            localObject7 = localIOException5;
            localObject6 = localObject11;
            if (localObject7 != null) {}
            try
            {
              ((FileOutputStream)localObject7).close();
              throw ((Throwable)localObject6);
            }
            catch (IOException localIOException6)
            {
              for (;;)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("ApolloManager", 2, localIOException6.getMessage());
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\pqa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
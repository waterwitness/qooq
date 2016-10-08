import com.tencent.biz.common.util.ZipUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.store.ApolloResDownloader;
import com.tencent.mobileqq.apollo.store.ApolloResDownloader.OnApolloDownLoadListener;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public final class prw
  implements ApolloResDownloader.OnApolloDownLoadListener
{
  public prw(AppInterface paramAppInterface, int[] paramArrayOfInt, ApolloResDownloader.OnApolloDownLoadListener paramOnApolloDownLoadListener, boolean paramBoolean, int paramInt)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    int[] arrayOfInt1;
    if (paramBoolean)
    {
      File localFile = new File(ApolloResDownloader.a(1, paramInt1), "dress.zip");
      int[] arrayOfInt2 = null;
      Object localObject2 = null;
      paramArrayOfInt = null;
      Object localObject1;
      if (localFile.exists())
      {
        arrayOfInt1 = arrayOfInt2;
        localObject1 = localObject2;
      }
      try
      {
        paramArrayOfInt = ApolloConstant.m;
        if (paramInt1 == 0)
        {
          arrayOfInt1 = arrayOfInt2;
          localObject1 = localObject2;
          paramArrayOfInt = ApolloConstant.k + "/def/dress/";
        }
        arrayOfInt1 = arrayOfInt2;
        localObject1 = localObject2;
        new File(paramArrayOfInt).mkdirs();
        arrayOfInt1 = arrayOfInt2;
        localObject1 = localObject2;
        ZipUtils.a(localFile, paramArrayOfInt);
        arrayOfInt1 = arrayOfInt2;
        localObject1 = localObject2;
        arrayOfInt2 = ApolloResDownloader.a(paramInt1);
        if (arrayOfInt2 != null)
        {
          arrayOfInt1 = arrayOfInt2;
          localObject1 = arrayOfInt2;
          if (arrayOfInt2.length > 0)
          {
            arrayOfInt1 = arrayOfInt2;
            localObject1 = arrayOfInt2;
            int j = arrayOfInt2.length;
            int i = 0;
            while (i < j)
            {
              int k = arrayOfInt2[i];
              arrayOfInt1 = arrayOfInt2;
              localObject1 = arrayOfInt2;
              ApolloResDownloader.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, 2, k);
              i += 1;
            }
          }
        }
        paramArrayOfInt = arrayOfInt2;
        arrayOfInt1 = arrayOfInt2;
        localObject1 = arrayOfInt2;
        if (QLog.isColorLevel())
        {
          arrayOfInt1 = arrayOfInt2;
          localObject1 = arrayOfInt2;
          QLog.d("ApolloResDownloader", 2, "downloadApolloResOrder down load role succ  id: " + paramInt1 + ", uin: " + paramString);
          paramArrayOfInt = arrayOfInt2;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          paramArrayOfInt = arrayOfInt1;
          if (QLog.isColorLevel())
          {
            QLog.d("ApolloResDownloader", 2, "downloadApolloResOrder unZipFile file error resType->" + paramInt1 + " error->" + localException.getMessage(), localException);
            paramArrayOfInt = arrayOfInt1;
          }
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        do
        {
          for (;;)
          {
            paramArrayOfInt = localException;
            if (QLog.isColorLevel())
            {
              QLog.d("ApolloResDownloader", 2, "downloadApolloResOrder unZipFile file error resType->" + paramInt1 + " error->" + localOutOfMemoryError.getMessage());
              paramArrayOfInt = localException;
            }
          }
        } while (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloResDownloader$OnApolloDownLoadListener == null);
        this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloResDownloader$OnApolloDownLoadListener.a(true, paramString, this.jdField_a_of_type_Int, paramArrayOfInt, paramInt2);
        return;
      }
      if ((this.jdField_a_of_type_ArrayOfInt != null) && (this.jdField_a_of_type_ArrayOfInt.length > 0)) {
        ApolloResDownloader.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramString, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloResDownloader$OnApolloDownLoadListener, -1, this.jdField_a_of_type_ArrayOfInt, -1, -1, this.jdField_a_of_type_Boolean);
      }
    }
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloResDownloader$OnApolloDownLoadListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloResDownloader$OnApolloDownLoadListener.a(false, paramString, this.jdField_a_of_type_Int, this.jdField_a_of_type_ArrayOfInt, paramInt2);
      }
    } while (!QLog.isColorLevel());
    QLog.d("ApolloResDownloader", 2, "downloadApolloResOrder down load role fail id: " + this.jdField_a_of_type_Int + ", uin:" + paramString);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\prw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
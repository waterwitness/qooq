import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.activity.aio.photo.IAIOImageProviderCallBack;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ThumbnailInfo;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.app.AccountNotMatchException;

public class nuk
  extends FMObserver
{
  public nuk(AIOImageProviderService paramAIOImageProviderService)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(ThumbnailInfo paramThumbnailInfo)
  {
    if (this.a.c == null) {
      if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver == null) {}
    }
    label246:
    for (;;)
    {
      try
      {
        ((QQAppInterface)BaseApplicationImpl.a.getAppRuntime(this.a.jdField_b_of_type_JavaLangString)).a().deleteObserver(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
        return;
      }
      catch (AccountNotMatchException paramThumbnailInfo)
      {
        paramThumbnailInfo.printStackTrace();
        return;
      }
      long l = paramThumbnailInfo.a;
      Object localObject = this.a.c.iterator();
      FileManagerEntity localFileManagerEntity;
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localFileManagerEntity = (FileManagerEntity)((Iterator)localObject).next();
      } while (localFileManagerEntity.nSessionId != l);
      for (;;)
      {
        if (localFileManagerEntity == null) {
          break label246;
        }
        this.a.c.remove(localFileManagerEntity);
        localObject = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack;
        if (localObject == null) {
          break;
        }
        int i = 18;
        if (paramThumbnailInfo.jdField_b_of_type_Int == 5) {
          i = 16;
        }
        if (FileUtil.a(paramThumbnailInfo.jdField_b_of_type_JavaLangString))
        {
          ((IAIOImageProviderCallBack)localObject).a(localFileManagerEntity.uniseq, localFileManagerEntity.status, i, 1, paramThumbnailInfo.jdField_b_of_type_JavaLangString, false);
          this.a.a(localFileManagerEntity.uniseq, localFileManagerEntity.status, i, paramThumbnailInfo.jdField_b_of_type_JavaLangString);
          return;
        }
        ((IAIOImageProviderCallBack)localObject).a(localFileManagerEntity.uniseq, localFileManagerEntity.status, i, 2, null, false);
        this.a.a(localFileManagerEntity.uniseq, localFileManagerEntity.status, i, "I:E");
        return;
        localFileManagerEntity = null;
      }
    }
  }
  
  protected void a(ThumbnailInfo paramThumbnailInfo, int paramInt)
  {
    if (this.a.c == null) {
      if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver == null) {}
    }
    label150:
    for (;;)
    {
      try
      {
        ((QQAppInterface)BaseApplicationImpl.a.getAppRuntime(this.a.jdField_b_of_type_JavaLangString)).a().deleteObserver(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
        return;
      }
      catch (AccountNotMatchException paramThumbnailInfo)
      {
        paramThumbnailInfo.printStackTrace();
        return;
      }
      long l = paramThumbnailInfo.a;
      Object localObject = this.a.c.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        paramThumbnailInfo = (FileManagerEntity)((Iterator)localObject).next();
      } while (paramThumbnailInfo.nSessionId != l);
      for (;;)
      {
        if (paramThumbnailInfo == null) {
          break label150;
        }
        localObject = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack;
        if ((localObject == null) || (paramThumbnailInfo == null)) {
          break;
        }
        ((IAIOImageProviderCallBack)localObject).a(paramThumbnailInfo.uniseq, paramThumbnailInfo.status, 18, paramInt, paramThumbnailInfo.fileSize, false);
        return;
        paramThumbnailInfo = null;
      }
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    if (this.a.c == null) {
      if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver == null) {}
    }
    IAIOImageProviderCallBack localIAIOImageProviderCallBack;
    do
    {
      do
      {
        try
        {
          ((QQAppInterface)BaseApplicationImpl.a.getAppRuntime(this.a.jdField_b_of_type_JavaLangString)).a().deleteObserver(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
          return;
        }
        catch (AccountNotMatchException paramString)
        {
          paramString.printStackTrace();
          return;
        }
        localIAIOImageProviderCallBack = null;
        Iterator localIterator = this.a.c.iterator();
        do
        {
          paramString = localIAIOImageProviderCallBack;
          if (!localIterator.hasNext()) {
            break;
          }
          paramString = (FileManagerEntity)localIterator.next();
        } while (paramString.nSessionId != paramLong2);
      } while (paramString == null);
      localIAIOImageProviderCallBack = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack;
    } while ((localIAIOImageProviderCallBack == null) || (paramString == null));
    localIAIOImageProviderCallBack.a(paramLong1, paramString.status, 20, (int)(paramString.fProgress * 10000.0F), paramString.fileSize, false);
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (this.a.c == null) {
      if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver == null) {}
    }
    label306:
    for (;;)
    {
      try
      {
        ((QQAppInterface)BaseApplicationImpl.a.getAppRuntime(this.a.jdField_b_of_type_JavaLangString)).a().deleteObserver(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
        return;
      }
      catch (AccountNotMatchException paramString1)
      {
        paramString1.printStackTrace();
        return;
      }
      paramString2 = this.a.c.iterator();
      for (;;)
      {
        if (paramString2.hasNext())
        {
          paramString1 = (FileManagerEntity)paramString2.next();
          if (paramString1.nSessionId == paramLong2) {
            if ((paramBoolean) && (TextUtils.isEmpty(paramString1.getFilePath())))
            {
              QLog.d("AIOImageProviderService", 2, "find tempEntity,cloudtype: " + paramString1.cloudType + ",filepath:" + paramString1.strFilePath + ",sessionid:" + paramString1.nSessionId);
              paramString1 = null;
            }
          }
        }
      }
      for (;;)
      {
        if (paramString1 == null) {
          break label306;
        }
        this.a.c.remove(paramString1);
        paramString2 = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack;
        if (paramString2 == null) {
          break;
        }
        if (paramBoolean)
        {
          paramString2.a(paramLong1, paramString1.status, 20, 1, paramString1.getFilePath(), false);
          this.a.a(paramLong1, paramString1.status, 20, paramString1.getFilePath());
          return;
        }
        else
        {
          paramString2.a(paramLong1, paramString1.status, 20, 2, paramString1.getFilePath(), false);
          this.a.a(paramLong1, paramString1.status, 20, "I:E");
          return;
          paramString1 = null;
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nuk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
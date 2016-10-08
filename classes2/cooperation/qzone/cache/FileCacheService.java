package cooperation.qzone.cache;

import android.text.TextUtils;
import com.tencent.component.network.utils.FileUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class FileCacheService
{
  private static final int jdField_a_of_type_Int = 5;
  public static final String a = ".lru";
  private FileCacheService.StorageHandler jdField_a_of_type_CooperationQzoneCacheFileCacheService$StorageHandler;
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private int jdField_b_of_type_Int;
  private final String jdField_b_of_type_JavaLangString;
  private int c;
  
  public FileCacheService(String paramString, int paramInt1, int paramInt2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    if (TextUtils.isEmpty(paramString)) {
      throw new NullPointerException("file cache: name can NOT be empty!");
    }
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_Int = paramInt1;
    this.c = paramInt2;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement() < 5) {}
    String str;
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
          str = a();
        } while (TextUtils.isEmpty(str));
        for (localObject = new File(str); !((File)localObject).exists(); localObject = ((File)localObject).getParentFile()) {}
      } while (!FileStorageHandler.a(((File)localObject).getAbsolutePath()));
      localObject = this.jdField_a_of_type_CooperationQzoneCacheFileCacheService$StorageHandler;
    } while (localObject == null);
    if (!CacheManager.a(str)) {}
    for (boolean bool = true;; bool = false)
    {
      ((FileCacheService.StorageHandler)localObject).a(this, bool);
      return;
    }
  }
  
  public static boolean a(File paramFile)
  {
    return (paramFile != null) && (paramFile.exists()) && (paramFile.isFile());
  }
  
  private File b(String paramString)
  {
    paramString = a(paramString);
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = new File(paramString);
    if (a(paramString)) {
      FileUtils.delete(paramString);
    }
    try
    {
      paramString.createNewFile();
      return paramString;
    }
    catch (IOException localIOException)
    {
      QLog.e(CacheManager.a, 1, "", localIOException);
    }
    return paramString;
  }
  
  public int a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return this.jdField_b_of_type_Int;
    }
    return this.c;
  }
  
  public File a(String paramString)
  {
    return a(paramString, false);
  }
  
  public File a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    String str = a(paramString);
    Object localObject;
    if (str == null)
    {
      localObject = null;
      if (!a((File)localObject)) {
        break label59;
      }
      a(str, false);
      label37:
      if (!a((File)localObject)) {
        break label92;
      }
    }
    for (;;)
    {
      return (File)localObject;
      localObject = new File(str);
      break;
      label59:
      if (!paramBoolean) {
        break label37;
      }
      paramString = b(paramString);
      localObject = paramString;
      if (!a(paramString)) {
        break label37;
      }
      a(paramString.getAbsolutePath(), true);
      localObject = paramString;
      break label37;
      label92:
      localObject = null;
    }
  }
  
  public String a()
  {
    return CacheManager.a(this.jdField_b_of_type_JavaLangString);
  }
  
  public String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    String str = a();
    if (TextUtils.isEmpty(str)) {
      return "";
    }
    return str + File.separator + paramString;
  }
  
  public void a(FileCacheService.StorageHandler paramStorageHandler)
  {
    this.jdField_a_of_type_CooperationQzoneCacheFileCacheService$StorageHandler = paramStorageHandler;
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i(CacheManager.a, 2, "FileCacheService deleteFile fileName:" + paramString);
    }
    paramString = a(paramString);
    FileUtils.delete(paramString);
    FileUtils.delete(paramString + ".lru");
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    paramString = new File(paramString + ".lru");
    if (paramString.exists()) {
      paramString.delete();
    }
    try
    {
      paramString.createNewFile();
      a();
      return;
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        QLog.e(CacheManager.a, 1, "", paramString);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\cache\FileCacheService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
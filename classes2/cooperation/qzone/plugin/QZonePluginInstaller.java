package cooperation.qzone.plugin;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.mobileqq.pluginsdk.PluginUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import yoc;
import yod;
import yoe;
import yof;
import yog;

public class QZonePluginInstaller
  implements Handler.Callback
{
  private static final int jdField_a_of_type_Int = 0;
  private static final int jdField_b_of_type_Int = 1;
  private static final int c = 2;
  private static final int d = 3;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  Map jdField_a_of_type_JavaUtilMap;
  yog jdField_a_of_type_Yog;
  Map jdField_b_of_type_JavaUtilMap;
  
  QZonePluginInstaller(Context paramContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.b(), this);
    this.b = new HashMap();
    yoc localyoc = new yoc(this);
    QZonePluginUtils.a(paramContext, this.b, localyoc);
  }
  
  private boolean a(PluginRecord paramPluginRecord)
  {
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1;
    if (paramPluginRecord != null)
    {
      File localFile = QZonePluginUtils.a(BaseApplicationImpl.getContext(), paramPluginRecord.g);
      bool1 = bool3;
      if (localFile != null)
      {
        bool1 = bool3;
        if (localFile.exists())
        {
          bool1 = bool3;
          if (localFile.isFile())
          {
            if (!a(paramPluginRecord, localFile)) {
              break label112;
            }
            bool1 = true;
            paramPluginRecord.e = 4;
          }
        }
      }
    }
    for (;;)
    {
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d("plugin_tag", 2, "verifyInstalledPlugin :" + paramPluginRecord + "," + bool1);
        bool2 = bool1;
      }
      return bool2;
      label112:
      a(paramPluginRecord, null);
      paramPluginRecord.e = 0;
      bool1 = bool3;
    }
  }
  
  static boolean a(PluginRecord paramPluginRecord, File paramFile)
  {
    if ((!paramFile.exists()) || (!paramFile.isFile())) {
      if (QLog.isColorLevel()) {
        QLog.e("plugin_tag", 2, "isValidPluginFile file not exist");
      }
    }
    do
    {
      return false;
      paramFile = PluginStatic.encodeFile(paramFile.getPath());
      if ((paramPluginRecord.i != null) && (paramPluginRecord.i.equalsIgnoreCase(paramFile))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("plugin_tag", 2, "isValidPluginFile lenth invalid:" + paramPluginRecord.i + ", " + paramFile);
    return false;
    return true;
  }
  
  private void b(yod paramyod)
  {
    Object localObject2 = paramyod.jdField_a_of_type_Yoe;
    Object localObject1 = paramyod.jdField_a_of_type_CooperationQzonePluginPluginRecord;
    ((yoe)localObject2).f(paramyod.jdField_a_of_type_CooperationQzonePluginPluginRecord);
    localObject2 = QZonePluginUtils.e(this.jdField_a_of_type_AndroidContentContext, ((PluginRecord)localObject1).g);
    File localFile1 = QZonePluginUtils.a(this.jdField_a_of_type_AndroidContentContext, ((PluginRecord)localObject1).g);
    File localFile2 = QZonePluginUtils.b(this.jdField_a_of_type_AndroidContentContext, ((PluginRecord)localObject1).g);
    if (!a((PluginRecord)localObject1, (File)localObject2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("patch", 2, "installPluginInner invalidate record:" + localObject1 + ",downLoadedfile");
      }
      Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 2, paramyod).sendToTarget();
      return;
    }
    if (!((File)localObject2).renameTo(localFile1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("patch", 2, "安装apk失败");
      }
      Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 2, paramyod).sendToTarget();
      return;
    }
    localObject1 = PluginUtils.extractLibs(localFile1.getAbsolutePath(), localFile2.getAbsolutePath());
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("patch", 2, "释放so失败:" + (String)localObject1);
      }
      Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 2, paramyod).sendToTarget();
      return;
    }
    Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 3, paramyod).sendToTarget();
  }
  
  public PluginRecord a(String paramString)
  {
    return (PluginRecord)this.b.get(paramString);
  }
  
  public void a(PluginRecord paramPluginRecord, yoe paramyoe)
  {
    yod localyod = new yod(this);
    localyod.jdField_a_of_type_CooperationQzonePluginPluginRecord = paramPluginRecord;
    localyod.jdField_a_of_type_Yoe = paramyoe;
    localyod.jdField_a_of_type_JavaLangString = paramPluginRecord.g;
    Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 0, localyod).sendToTarget();
  }
  
  public void a(PluginRecord paramPluginRecord, yof paramyof)
  {
    yod localyod = new yod(this);
    localyod.jdField_a_of_type_CooperationQzonePluginPluginRecord = paramPluginRecord;
    localyod.jdField_a_of_type_Yof = paramyof;
    Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 1, localyod).sendToTarget();
  }
  
  public void a(yod paramyod)
  {
    paramyod = paramyod.jdField_a_of_type_CooperationQzonePluginPluginRecord;
    File localFile1 = QZonePluginUtils.a(this.jdField_a_of_type_AndroidContentContext, paramyod.g);
    File localFile2 = QZonePluginUtils.b(this.jdField_a_of_type_AndroidContentContext, paramyod.g);
    localFile1.delete();
    localFile2.delete();
    QZonePluginUtils.c(paramyod);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    Object localObject1;
    do
    {
      do
      {
        Object localObject2;
        do
        {
          do
          {
            do
            {
              return false;
              localObject2 = (yod)paramMessage.obj;
            } while (this.jdField_a_of_type_JavaUtilMap.containsKey(((yod)localObject2).jdField_a_of_type_JavaLangString));
            this.jdField_a_of_type_JavaUtilMap.put(((yod)localObject2).jdField_a_of_type_JavaLangString, localObject2);
            localObject1 = ((yod)localObject2).jdField_a_of_type_CooperationQzonePluginPluginRecord;
            localObject2 = ((yod)localObject2).jdField_a_of_type_Yoe;
            if (localObject2 != null) {
              ((yoe)localObject2).f((PluginRecord)localObject1);
            }
            b((yod)paramMessage.obj);
            return false;
            paramMessage = (yod)paramMessage.obj;
          } while (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramMessage.jdField_a_of_type_JavaLangString));
          localObject1 = paramMessage.jdField_a_of_type_CooperationQzonePluginPluginRecord;
          localObject2 = paramMessage.jdField_a_of_type_Yoe;
          if (localObject2 != null) {
            ((yoe)localObject2).a(false, (PluginRecord)localObject1);
          }
          this.jdField_a_of_type_JavaUtilMap.remove(paramMessage.jdField_a_of_type_JavaLangString);
          return false;
          paramMessage = (yod)paramMessage.obj;
          localObject1 = paramMessage.jdField_a_of_type_CooperationQzonePluginPluginRecord;
          localObject2 = paramMessage.jdField_a_of_type_Yof;
          if (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramMessage.jdField_a_of_type_JavaLangString))
          {
            if (localObject2 != null) {
              ((yof)localObject2).g((PluginRecord)localObject1);
            }
            this.jdField_a_of_type_JavaUtilMap.put(paramMessage.jdField_a_of_type_JavaLangString, paramMessage);
            a(paramMessage);
            this.jdField_a_of_type_JavaUtilMap.remove(paramMessage.jdField_a_of_type_JavaLangString);
            this.b.remove(((PluginRecord)localObject1).g);
            QZonePluginUtils.c((PluginRecord)localObject1);
            if (localObject2 != null) {
              ((yof)localObject2).b(true, (PluginRecord)localObject1);
            }
          }
        } while (localObject2 == null);
        ((yof)localObject2).b(false, (PluginRecord)localObject1);
        return false;
        localObject1 = (yod)paramMessage.obj;
      } while (!this.jdField_a_of_type_JavaUtilMap.containsKey(((yod)localObject1).jdField_a_of_type_JavaLangString));
      paramMessage = ((yod)localObject1).jdField_a_of_type_CooperationQzonePluginPluginRecord;
      this.jdField_a_of_type_JavaUtilMap.remove(((yod)localObject1).jdField_a_of_type_JavaLangString);
      paramMessage.e = 4;
      this.b.put(paramMessage.g, paramMessage);
      if (QLog.isColorLevel()) {
        QLog.d("patch", 2, "QZonePluginInstaller 安装成功 record:" + paramMessage);
      }
      QZonePluginUtils.b(paramMessage);
      localObject1 = ((yod)localObject1).jdField_a_of_type_Yoe;
    } while (localObject1 == null);
    ((yoe)localObject1).a(true, paramMessage);
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\plugin\QZonePluginInstaller.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
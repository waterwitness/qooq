package cooperation.qzone.plugin;

import NS_MOBILE_CLIENT_UPDATE.SQ_CLIENT_UPDATE_RSP;
import NS_MOBILE_CLIENT_UPDATE.UPDATE_INFO;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.patch.QZonePatchService;
import cooperation.qzone.patch.QzoneUpdatePatchServlet;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import yol;

public class QZonePluginUpdater
{
  public static final String a = "forceDownLoadPlugins";
  private static final String b = "QZonePluginUpdater";
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public QZonePluginUpdater.OnUpdateListner a;
  HashMap jdField_a_of_type_JavaUtilHashMap;
  private Map jdField_a_of_type_JavaUtilMap;
  
  public QZonePluginUpdater(QQAppInterface paramQQAppInterface, Context paramContext, Handler paramHandler)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    paramQQAppInterface = new PluginRecord();
    paramQQAppInterface.e = "0";
    this.jdField_a_of_type_JavaUtilHashMap.put("qzone_live_video_plugin_hack.apk", "com.tencent.mobileqq:qzonelive");
    paramQQAppInterface.jdField_f_of_type_JavaLangString = "qzone_live_video_plugin_hack.apk";
    paramQQAppInterface.g = "qzone_live_video_plugin_hack.apk";
    this.jdField_a_of_type_JavaUtilMap.put(paramQQAppInterface.g, paramQQAppInterface);
    QZonePluginUtils.a(paramContext, this.jdField_a_of_type_JavaUtilMap);
  }
  
  public static String a(Map paramMap, Integer paramInteger)
  {
    if (paramMap != null) {
      return (String)paramMap.get(paramInteger);
    }
    return null;
  }
  
  private void a(SQ_CLIENT_UPDATE_RSP paramSQ_CLIENT_UPDATE_RSP)
  {
    if (paramSQ_CLIENT_UPDATE_RSP != null)
    {
      String str1 = paramSQ_CLIENT_UPDATE_RSP.md5;
      String str2 = paramSQ_CLIENT_UPDATE_RSP.upUrl;
      if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QZonePluginUpdater", 2, "收到补丁包信息：" + paramSQ_CLIENT_UPDATE_RSP);
        }
        QZonePatchService.a().a(str1, str2);
      }
    }
  }
  
  private void a(SQ_CLIENT_UPDATE_RSP paramSQ_CLIENT_UPDATE_RSP, String[] paramArrayOfString)
  {
    if (paramSQ_CLIENT_UPDATE_RSP != null)
    {
      if ((paramSQ_CLIENT_UPDATE_RSP.vPlugin == null) || (paramSQ_CLIENT_UPDATE_RSP.vPlugin.size() <= 0)) {
        break label62;
      }
      a(paramSQ_CLIENT_UPDATE_RSP.vPlugin, paramArrayOfString);
      if (QLog.isColorLevel()) {
        QLog.d("QZonePluginUpdater", 2, "插件需要升级：" + paramSQ_CLIENT_UPDATE_RSP);
      }
    }
    label62:
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("QZonePluginUpdater", 2, "插件不需升级：" + paramSQ_CLIENT_UPDATE_RSP);
  }
  
  private void a(UPDATE_INFO paramUPDATE_INFO, PluginRecord paramPluginRecord)
  {
    if ((paramPluginRecord == null) || (paramUPDATE_INFO == null)) {
      return;
    }
    paramPluginRecord.d = paramUPDATE_INFO.app;
    paramPluginRecord.g = paramUPDATE_INFO.id;
    paramPluginRecord.jdField_f_of_type_Int = paramUPDATE_INFO.actype;
    paramPluginRecord.h = paramUPDATE_INFO.mainVersion;
    paramPluginRecord.i = paramUPDATE_INFO.md5;
    paramPluginRecord.jdField_f_of_type_JavaLangString = paramUPDATE_INFO.name;
    paramPluginRecord.e = paramUPDATE_INFO.ver;
    paramPluginRecord.jdField_f_of_type_Int = paramUPDATE_INFO.actype;
    paramPluginRecord.c = a(paramUPDATE_INFO.plugin_info, Integer.valueOf(0));
    paramPluginRecord.j = ((String)this.jdField_a_of_type_JavaUtilHashMap.get(paramPluginRecord.g));
    paramPluginRecord.k = QZonePluginUtils.a(BaseApplicationImpl.getContext(), paramPluginRecord.g).getAbsolutePath();
  }
  
  private void a(QQAppInterface paramQQAppInterface, String[] paramArrayOfString)
  {
    PluginIntent localPluginIntent = new PluginIntent(BaseApplicationImpl.getContext(), QzoneUpdatePatchServlet.class);
    localPluginIntent.a = a();
    localPluginIntent.a(new yol(this));
    localPluginIntent.putExtra("forceDownLoadPlugins", paramArrayOfString);
    paramQQAppInterface.startServlet(localPluginIntent);
  }
  
  private void a(PluginRecord paramPluginRecord)
  {
    File localFile = QZonePluginUtils.c(BaseApplicationImpl.getContext(), paramPluginRecord.g);
    if ((localFile != null) && (localFile.exists())) {
      localFile.delete();
    }
    QZonePluginUtils.a(paramPluginRecord);
  }
  
  private void a(String paramString)
  {
    paramString = QZonePluginUtils.c(BaseApplicationImpl.getContext(), paramString);
    if ((paramString != null) && (paramString.exists())) {
      paramString.delete();
    }
  }
  
  private static void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("patch", 2, paramString);
    }
  }
  
  public PluginRecord a(String paramString)
  {
    return (PluginRecord)this.jdField_a_of_type_JavaUtilMap.get(paramString);
  }
  
  public ArrayList a()
  {
    ArrayList localArrayList = new ArrayList();
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext())
    {
      PluginRecord localPluginRecord = (PluginRecord)localIterator.next();
      UPDATE_INFO localUPDATE_INFO = new UPDATE_INFO();
      localUPDATE_INFO.id = localPluginRecord.g;
      localUPDATE_INFO.app = localPluginRecord.g;
      localUPDATE_INFO.ver = (localPluginRecord.e + "");
      localArrayList.add(localUPDATE_INFO);
      localStringBuilder.append("id=").append(localUPDATE_INFO.id).append(",app=").append(localUPDATE_INFO.app).append(",ver=").append(localUPDATE_INFO.ver).append("\r\n");
    }
    b("getRequestUpdateInfo:" + localStringBuilder);
    return localArrayList;
  }
  
  public Map a()
  {
    return this.jdField_a_of_type_JavaUtilMap;
  }
  
  public void a()
  {
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null);
  }
  
  public void a(QZonePluginUpdater.OnUpdateListner paramOnUpdateListner)
  {
    this.jdField_a_of_type_CooperationQzonePluginQZonePluginUpdater$OnUpdateListner = paramOnUpdateListner;
  }
  
  public void a(ArrayList paramArrayList, String[] paramArrayOfString)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        paramArrayOfString = (UPDATE_INFO)paramArrayList.next();
        if (paramArrayOfString.actype == 4)
        {
          b("delete plugin, " + paramArrayOfString.name);
          if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramArrayOfString.id))
          {
            this.jdField_a_of_type_JavaUtilMap.remove(paramArrayOfString.id);
            a(paramArrayOfString.id);
          }
        }
        else
        {
          PluginRecord localPluginRecord1 = new PluginRecord();
          a(paramArrayOfString, localPluginRecord1);
          if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramArrayOfString.id))
          {
            PluginRecord localPluginRecord2 = (PluginRecord)this.jdField_a_of_type_JavaUtilMap.get(paramArrayOfString.id);
            if (!localPluginRecord1.equals(localPluginRecord2))
            {
              if (localPluginRecord2 != null) {
                a(paramArrayOfString, localPluginRecord2);
              }
              for (;;)
              {
                a((PluginRecord)this.jdField_a_of_type_JavaUtilMap.get(paramArrayOfString.id));
                break;
                this.jdField_a_of_type_JavaUtilMap.put(paramArrayOfString.id, localPluginRecord1);
              }
            }
          }
          else
          {
            this.jdField_a_of_type_JavaUtilMap.put(paramArrayOfString.id, localPluginRecord1);
            a((PluginRecord)this.jdField_a_of_type_JavaUtilMap.get(paramArrayOfString.id));
          }
        }
      }
    }
  }
  
  public boolean a(PluginRecord paramPluginRecord)
  {
    Object localObject2 = null;
    if (paramPluginRecord == null) {
      return false;
    }
    PluginRecord localPluginRecord = b(paramPluginRecord.g);
    Object localObject1;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("pre: ");
      if (paramPluginRecord != null)
      {
        localObject1 = paramPluginRecord.i;
        QLog.d("QZonePluginUpdater", 2, (String)localObject1);
        localStringBuilder = new StringBuilder().append("new: ");
        localObject1 = localObject2;
        if (localPluginRecord != null) {
          localObject1 = localPluginRecord.i;
        }
        QLog.d("QZonePluginUpdater", 2, (String)localObject1);
      }
    }
    else
    {
      if ((localPluginRecord == null) || (paramPluginRecord == null) || (!localPluginRecord.i.equals(paramPluginRecord.i))) {
        break label141;
      }
    }
    label141:
    for (boolean bool = true;; bool = false)
    {
      return bool;
      localObject1 = null;
      break;
    }
  }
  
  public PluginRecord b(String paramString)
  {
    return (PluginRecord)this.jdField_a_of_type_JavaUtilMap.get(paramString);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\plugin\QZonePluginUpdater.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
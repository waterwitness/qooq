package com.tencent.biz.qqstory.model;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.model.item.DoodleEmojiItem;
import com.tencent.biz.qqstory.model.lbs.BasicLocation;
import com.tencent.biz.qqstory.model.lbs.LbsManager;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetPOIPosters;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.GpsMsg;
import com.tencent.biz.qqstory.network.request.CommonRequest;
import com.tencent.biz.qqstory.network.request.GetEmojiPackInfoListRequest;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import ije;
import ijf;
import ijg;
import ijh;
import iji;
import ijj;
import ijk;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class DoodleEmojiManager
  implements IManager
{
  public static final String a = "DoodleEmojiManager";
  public static final String b = "1";
  public static final String c = "0";
  public static final String d;
  public static final String e = "emoji_folder_";
  public static final String f = "emoji_zip_";
  public final int a;
  public DoodleEmojiItem a;
  public final Object a;
  public final List a;
  public final Queue a;
  public final ConcurrentHashMap a;
  public volatile AtomicInteger a;
  public final Object b = new Object[0];
  public String g = "";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    d = QQStoryConstant.o + "emoji";
    a(d);
  }
  
  public DoodleEmojiManager()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_a_of_type_JavaLangObject = new Object[0];
    this.jdField_a_of_type_JavaUtilQueue = new LinkedList();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Int = 20;
  }
  
  public static String a(StoryConfigManager paramStoryConfigManager, String paramString)
  {
    return (String)paramStoryConfigManager.a("emoji_pack_url_" + paramString, "");
  }
  
  private static String a(File paramFile)
  {
    return paramFile.getName().substring("emoji_folder_".length());
  }
  
  private static void a(String paramString)
  {
    paramString = new File(paramString);
    boolean bool;
    if (paramString.isFile())
    {
      bool = paramString.delete();
      SLog.d("DoodleEmojiManager", "delete file : " + bool);
    }
    if (!paramString.exists())
    {
      bool = paramString.mkdirs();
      SLog.d("DoodleEmojiManager", "create folder : " + bool);
    }
  }
  
  private boolean a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 2;
  }
  
  private static boolean a(File paramFile)
  {
    if ((paramFile == null) || (!paramFile.exists()) || (!paramFile.isDirectory())) {}
    do
    {
      return false;
      paramFile = paramFile.listFiles(new ijk());
    } while ((paramFile == null) || (paramFile.length <= 0));
    return true;
  }
  
  public static String b(StoryConfigManager paramStoryConfigManager, String paramString)
  {
    return (String)paramStoryConfigManager.a("emoji_pack_name_" + paramString, "");
  }
  
  private static String c(String paramString)
  {
    return d + File.separator + "emoji_zip_" + paramString;
  }
  
  private void c()
  {
    SLog.b("DoodleEmojiManager", "startDownload");
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryModelItemDoodleEmojiItem == null)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryModelItemDoodleEmojiItem = ((DoodleEmojiItem)this.jdField_a_of_type_JavaUtilQueue.poll());
        if (this.jdField_a_of_type_ComTencentBizQqstoryModelItemDoodleEmojiItem != null)
        {
          SLog.b("DoodleEmojiManager", "downloader startDownload : " + this.jdField_a_of_type_ComTencentBizQqstoryModelItemDoodleEmojiItem);
          Bosses.get().postJob(new ijg(this, this.jdField_a_of_type_ComTencentBizQqstoryModelItemDoodleEmojiItem));
        }
        return;
      }
      SLog.b("DoodleEmojiManager", "can not start download because find one is still downloading : " + this.jdField_a_of_type_ComTencentBizQqstoryModelItemDoodleEmojiItem);
    }
  }
  
  private static void c(StoryConfigManager paramStoryConfigManager, String paramString1, String paramString2)
  {
    paramStoryConfigManager.a("emoji_pack_url_" + paramString1, paramString2);
  }
  
  private static String d(String paramString)
  {
    return d + File.separator + "emoji_folder_" + paramString;
  }
  
  private void d()
  {
    SLog.b("DoodleEmojiManager", "fireRequestEmojiPackList, cookie = " + this.g);
    CmdTaskManger.a().a(new GetEmojiPackInfoListRequest(this.g, 20), new ijj(this));
  }
  
  private static void d(StoryConfigManager paramStoryConfigManager, String paramString1, String paramString2)
  {
    paramStoryConfigManager.a("emoji_pack_name_" + paramString1, paramString2);
  }
  
  private static void e()
  {
    if (Looper.getMainLooper() != Looper.myLooper()) {
      throw new IllegalStateException("can only be invoked at main thread");
    }
  }
  
  public List a(boolean paramBoolean)
  {
    if (!a()) {
      return Collections.EMPTY_LIST;
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (!this.jdField_a_of_type_JavaUtilList.isEmpty()) {
        if (!paramBoolean) {
          break label53;
        }
      }
    }
    synchronized (this.b)
    {
      this.g = "";
      d();
      label53:
      ??? = new ArrayList();
      ((List)???).addAll(this.jdField_a_of_type_JavaUtilList);
      return (List)???;
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
  }
  
  public void a() {}
  
  public void a(Context paramContext)
  {
    SLog.b("DoodleEmojiManager", "initLocalPackages, doodle emoji path : " + d);
    File[] arrayOfFile;
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.compareAndSet(0, 1))
    {
      paramContext = (StoryConfigManager)SuperManager.a(10);
      ??? = new File(d);
      if ((((File)???).exists()) && (((File)???).isDirectory()))
      {
        arrayOfFile = ((File)???).listFiles(new ije(this));
        if (arrayOfFile == null) {
          break label462;
        }
      }
    }
    for (;;)
    {
      int i;
      File localFile;
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        int j = arrayOfFile.length;
        i = 0;
        if (i >= j) {
          break label423;
        }
        localFile = arrayOfFile[i];
        Object localObject2 = localFile.listFiles(new ijf(this));
        if ((localObject2 != null) && (localObject2.length > 0))
        {
          localObject2 = a(localFile);
          String str1 = b(paramContext, (String)localObject2);
          String str2 = a(paramContext, (String)localObject2);
          DoodleEmojiItem localDoodleEmojiItem = new DoodleEmojiItem((String)localObject2, str2, str1, null);
          localDoodleEmojiItem.a(localFile.getPath());
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localObject2, localDoodleEmojiItem);
          SLog.b("DoodleEmojiManager", "load local emoji pack : " + localDoodleEmojiItem);
          if ((!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str1)))
          {
            this.jdField_a_of_type_JavaUtilList.add(localDoodleEmojiItem);
            SLog.b("DoodleEmojiManager", "add to display list : " + localDoodleEmojiItem);
          }
          else
          {
            SLog.d("DoodleEmojiManager", "loss logo or name, don't add to display list : id=%s, name=%s, logo=%s", new Object[] { localObject2, str1, str2 });
          }
        }
      }
      try
      {
        FileUtils.d(localFile.getPath());
        SLog.d("DoodleEmojiManager", "find empty local emoji folder : " + localFile.getName() + ", delete it");
      }
      catch (Exception localException)
      {
        SLog.d("DoodleEmojiManager", "find empty local emoji folder : " + localFile.getName() + ", delete failed : " + localException);
      }
      label423:
      if (this.jdField_a_of_type_JavaUtilList.size() > 0) {
        Collections.sort(this.jdField_a_of_type_JavaUtilList, new DoodleEmojiManager.DoodleEmojiItemComparator("1"));
      }
      for (;;)
      {
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(2);
        return;
        label462:
        SLog.d("DoodleEmojiManager", "local emoji folder is empty");
      }
      i += 1;
    }
  }
  
  public void a(DoodleEmojiManager.POIPostersRequestCallback paramPOIPostersRequestCallback)
  {
    SLog.b("DoodleEmojiManager", "requestPoiFaces " + paramPOIPostersRequestCallback);
    WeakReference localWeakReference = new WeakReference(paramPOIPostersRequestCallback);
    BasicLocation localBasicLocation = LbsManager.a();
    if (localBasicLocation == null)
    {
      SosoInterface.a(new ijh(this, "NewStoryTakeVideoActivity", localWeakReference, paramPOIPostersRequestCallback));
      return;
    }
    paramPOIPostersRequestCallback = new qqstory_service.ReqGetPOIPosters();
    paramPOIPostersRequestCallback.coordinate.set(1);
    paramPOIPostersRequestCallback.gps.lat.set(localBasicLocation.jdField_a_of_type_Int);
    paramPOIPostersRequestCallback.gps.lng.set(localBasicLocation.b);
    paramPOIPostersRequestCallback.gps.setHasFlag(true);
    CmdTaskManger.a().a(new CommonRequest("StorySvc.video_poi_posters_get", paramPOIPostersRequestCallback, null), new iji(this, localWeakReference));
  }
  
  public boolean a(String paramString, boolean paramBoolean)
  {
    if (!a()) {
      return false;
    }
    if (paramString == null) {
      throw new IllegalArgumentException("pack id should not be null");
    }
    DoodleEmojiItem localDoodleEmojiItem = (DoodleEmojiItem)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (localDoodleEmojiItem == null)
    {
      SLog.d("DoodleEmojiManager", "can not find pack item by id " + paramString);
      return false;
    }
    ??? = new File(d(localDoodleEmojiItem.a));
    if ((a((File)???)) && (!paramBoolean))
    {
      SLog.d("DoodleEmojiManager", "already has local emoji folder, notify download success directly");
      localDoodleEmojiItem.a(((File)???).getPath());
      Dispatchers.get().dispatch(new DoodleEmojiManager.DoodleEmojiDownloadEvent(localDoodleEmojiItem, 0, true, 0L, 0L));
      return true;
    }
    if (!TextUtils.isEmpty(localDoodleEmojiItem.a()))
    {
      SLog.d("DoodleEmojiManager", "local emoji folder is missing");
      localDoodleEmojiItem.a(null);
    }
    if (TextUtils.isEmpty(localDoodleEmojiItem.e))
    {
      SLog.d("DoodleEmojiManager", "can not start download because of empty download-url is found");
      return false;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (!this.jdField_a_of_type_JavaUtilQueue.contains(localDoodleEmojiItem))
      {
        this.jdField_a_of_type_JavaUtilQueue.offer(localDoodleEmojiItem);
        SLog.b("DoodleEmojiManager", "downloadEmojiPack pack " + paramString + " enqueue");
        c();
        return true;
      }
      SLog.b("DoodleEmojiManager", "downloadEmojiPack pack " + paramString + " is already in pending list");
    }
  }
  
  public void b() {}
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\model\DoodleEmojiManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
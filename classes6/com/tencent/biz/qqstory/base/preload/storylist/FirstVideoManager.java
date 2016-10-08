package com.tencent.biz.qqstory.base.preload.storylist;

import android.util.Pair;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.FirstVideoEntry;
import com.tencent.biz.qqstory.database.LiveVideoEntry;
import com.tencent.biz.qqstory.model.IManager;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class FirstVideoManager
  implements IManager
{
  public static final String a = "Q.qqstory.download.preload.FirstVideoManager";
  protected Map a;
  
  public FirstVideoManager()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = new HashMap(300);
  }
  
  private QQStoryContext a()
  {
    return QQStoryContext.a();
  }
  
  public static List a(EntityManager paramEntityManager, Class paramClass, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    return paramEntityManager.a(paramClass, paramString1, false, paramString2, paramArrayOfString, null, null, null, null, null);
  }
  
  public StoryVideoItem a(String paramString1, String paramString2)
  {
    String str = a(paramString1, paramString2);
    StoryVideoItem localStoryVideoItem = (StoryVideoItem)this.a.get(str);
    if (localStoryVideoItem != null) {
      paramString1 = localStoryVideoItem;
    }
    do
    {
      return paramString1;
      paramString1 = a(a().a().createEntityManager(), FirstVideoEntry.class, FirstVideoEntry.class.getSimpleName(), FirstVideoEntry.getVidSelection(), new String[] { paramString1, paramString2 });
      if ((paramString1 == null) || (paramString1.size() == 0))
      {
        SLog.d("Q.qqstory.download.preload.FirstVideoManager", "getFirstStoryItem null ! ");
        return null;
      }
      paramString1 = ((FirstVideoEntry)paramString1.get(0)).vid;
      paramString2 = ((StoryManager)SuperManager.a(5)).a(paramString1);
      paramString1 = paramString2;
    } while (paramString2 == null);
    this.a.put(str, paramString2);
    return paramString2;
  }
  
  public String a(String paramString1, String paramString2)
  {
    return paramString1 + "." + paramString2;
  }
  
  public List a(String paramString)
  {
    Object localObject = a(a().a().createEntityManager(), FirstVideoEntry.class, FirstVideoEntry.class.getSimpleName(), FirstVideoEntry.getCoordinateSelectionWithoutArg(), new String[] { paramString });
    paramString = new ArrayList();
    if (localObject == null)
    {
      SLog.d("Q.qqstory.download.preload.FirstVideoManager", "getVideoCoordinate null ! ");
      return paramString;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      FirstVideoEntry localFirstVideoEntry = (FirstVideoEntry)((Iterator)localObject).next();
      paramString.add(new Pair(localFirstVideoEntry.category, localFirstVideoEntry.uin));
    }
    return paramString;
  }
  
  public void a() {}
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    SLog.b("Q.qqstory.download.preload.FirstVideoManager", "setFirstVideo:" + paramString1 + ",uin=" + paramString2 + ",vid=" + paramString3);
    Object localObject = a(paramString1, paramString2);
    StoryVideoItem localStoryVideoItem = ((StoryManager)SuperManager.a(5)).a(paramString3);
    if (localStoryVideoItem != null) {
      this.a.put(localObject, localStoryVideoItem);
    }
    localObject = new FirstVideoEntry();
    ((FirstVideoEntry)localObject).key = FirstVideoEntry.getKey(paramString1, paramString2);
    ((FirstVideoEntry)localObject).category = paramString1;
    ((FirstVideoEntry)localObject).uin = paramString2;
    ((FirstVideoEntry)localObject).vid = paramString3;
    a().a().createEntityManager().b((Entity)localObject);
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    return a(paramString1, paramString2, false);
  }
  
  public boolean a(String paramString1, String paramString2, boolean paramBoolean)
  {
    Object localObject = a(paramString1, paramString2);
    if (localObject == null) {
      localObject = (StoryManager)SuperManager.a(5);
    }
    for (;;)
    {
      long l;
      try
      {
        l = Long.parseLong(paramString2);
        if (paramString1.equals(IPreloadVideoSource.b))
        {
          paramString1 = ((StoryManager)localObject).a(l, 0);
          if ((paramString1 == null) || (paramString1.liveVideo == null) || (paramString1.liveVideo.roomId == 0)) {
            break label95;
          }
          return true;
        }
      }
      catch (Exception paramString1)
      {
        return false;
      }
      if (paramString1.equals(IPreloadVideoSource.a))
      {
        paramString1 = ((StoryManager)localObject).a(l, 1);
        continue;
        label95:
        return false;
        return ((StoryVideoItem)localObject).isPreloadSuc(paramBoolean);
      }
      else
      {
        paramString1 = null;
      }
    }
  }
  
  public void b() {}
  
  public void c()
  {
    this.a.clear();
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\base\preload\storylist\FirstVideoManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
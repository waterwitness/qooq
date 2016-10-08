package com.tencent.mobileqq.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.unique;
import java.util.List;

public class ResourcePluginInfo
  extends Entity
{
  public static final int PLUGIN_TYPE_ABOUT = 32;
  public static final int PLUGIN_TYPE_LEBA = 64;
  public static final int PLUGIN_TYPE_NETWORK_PLUGIN = 128;
  public byte cCanChangeState;
  public byte cDataType;
  public byte cDefaultState;
  public byte cLocalState;
  public int iPluginType;
  public byte isNew;
  public int lebaSearchResultType;
  public String pluginBg;
  public String pluginSetTips;
  public short sLanType;
  public short sPriority;
  public short sResSubType;
  public String strGotoUrl;
  public String strNewPluginDesc;
  public String strNewPluginURL;
  @unique
  public String strPkgName;
  public String strResDesc;
  public String strResName;
  public String strResURL;
  public long timeStamp;
  public long uiCurVer;
  public long uiResId;
  
  public ResourcePluginInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.iPluginType = 64;
  }
  
  public static ResourcePluginInfo find(EntityManager paramEntityManager, String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramEntityManager != null)
    {
      localObject1 = localObject2;
      if (paramString != null) {
        localObject1 = (ResourcePluginInfo)paramEntityManager.a(ResourcePluginInfo.class, "strPkgName=?", new String[] { paramString });
      }
    }
    return (ResourcePluginInfo)localObject1;
  }
  
  public static List getAll(EntityManager paramEntityManager, int paramInt, boolean paramBoolean)
  {
    List localList = null;
    if (paramEntityManager != null)
    {
      if (paramBoolean) {
        localList = paramEntityManager.a(ResourcePluginInfo.class, false, "iPluginType=?", new String[] { String.valueOf(paramInt) }, null, null, "cLocalState desc", null);
      }
    }
    else {
      return localList;
    }
    return paramEntityManager.a(ResourcePluginInfo.class, false, "iPluginType=?", new String[] { String.valueOf(paramInt) }, null, null, null, null);
  }
  
  public static void persistOrReplace(EntityManager paramEntityManager, ResourcePluginInfo paramResourcePluginInfo)
  {
    if ((paramEntityManager != null) && (paramResourcePluginInfo != null) && (paramResourcePluginInfo.strPkgName != null) && (!paramResourcePluginInfo.strPkgName.equals("")))
    {
      ResourcePluginInfo localResourcePluginInfo = (ResourcePluginInfo)paramEntityManager.a(ResourcePluginInfo.class, "strPkgName=?", new String[] { paramResourcePluginInfo.strPkgName });
      if (localResourcePluginInfo != null)
      {
        localResourcePluginInfo.strResName = paramResourcePluginInfo.strResName;
        localResourcePluginInfo.strResURL = paramResourcePluginInfo.strResURL;
        localResourcePluginInfo.uiCurVer = paramResourcePluginInfo.uiCurVer;
        localResourcePluginInfo.sLanType = paramResourcePluginInfo.sLanType;
        localResourcePluginInfo.sResSubType = paramResourcePluginInfo.sResSubType;
        localResourcePluginInfo.strGotoUrl = paramResourcePluginInfo.strGotoUrl;
        localResourcePluginInfo.sPriority = paramResourcePluginInfo.sPriority;
        localResourcePluginInfo.strResDesc = paramResourcePluginInfo.strResDesc;
        localResourcePluginInfo.cCanChangeState = paramResourcePluginInfo.cCanChangeState;
        localResourcePluginInfo.cDefaultState = paramResourcePluginInfo.cDefaultState;
        if (paramResourcePluginInfo.cDefaultState != localResourcePluginInfo.cDefaultState) {
          localResourcePluginInfo.cLocalState = paramResourcePluginInfo.cLocalState;
        }
        localResourcePluginInfo.isNew = paramResourcePluginInfo.isNew;
        localResourcePluginInfo.uiResId = paramResourcePluginInfo.uiResId;
        localResourcePluginInfo.iPluginType = paramResourcePluginInfo.iPluginType;
        localResourcePluginInfo.strNewPluginDesc = paramResourcePluginInfo.strNewPluginDesc;
        localResourcePluginInfo.strNewPluginURL = paramResourcePluginInfo.strNewPluginURL;
        localResourcePluginInfo.pluginSetTips = paramResourcePluginInfo.pluginSetTips;
        localResourcePluginInfo.lebaSearchResultType = paramResourcePluginInfo.lebaSearchResultType;
        paramEntityManager.a(localResourcePluginInfo);
      }
    }
    else
    {
      return;
    }
    paramEntityManager.a(paramResourcePluginInfo);
  }
  
  public static void remove(EntityManager paramEntityManager, String paramString)
  {
    if ((paramEntityManager != null) && (paramString != null))
    {
      paramString = find(paramEntityManager, paramString);
      if (paramString != null) {
        paramEntityManager.b(paramString);
      }
    }
  }
  
  public String toString()
  {
    return this.strPkgName + "|" + this.strResName + "|" + this.strResURL + "|" + this.uiCurVer + "|" + this.sLanType + "|" + this.strGotoUrl + "|" + this.sResSubType + "|" + this.sPriority + "|" + this.strResDesc + "|" + this.cDefaultState + "|" + this.cCanChangeState + "|" + this.uiResId + "|" + this.cLocalState;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\ResourcePluginInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
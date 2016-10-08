package com.tencent.qidian.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.qidian.proto.mobileqq_qidian.ConfigGroupInfo;
import com.tencent.qidian.proto.mobileqq_qidian.GetUserDetailInfoRspBody;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class QidianProfileUiInfo
  extends Entity
{
  public static final int CONFIG_INFO_EVENT_CALL_MOBILE = 2;
  public static final int CONFIG_INFO_EVENT_CALL_TEL = 1;
  public static final int CONFIG_INFO_EVENT_MAIL = 3;
  public static final int CONFIG_INFO_EVENT_NONE = 0;
  public static final int CONFIG_INFO_EVENT_OPEN_BROWSER = 6;
  public static final int CONFIG_INFO_EVENT_OPEN_MAP = 5;
  public static final int CONFIG_INFO_EVENT_PLUGIN_APP = 7;
  public static final int CONFIG_INFO_EVENT_SHOW_ALL_TEXT = 4;
  public static final int CONFIG_INFO_TYPE_GROUP = 3;
  public static final int CONFIG_INFO_TYPE_PA = 2;
  public static final int CONFIG_INFO_TYPE_TEXT = 1;
  private static final String TAG = "QidianProfileUiInfo";
  public byte[] infoByte;
  public List mConfigGroupInfos;
  @unique
  public String uin;
  
  public QidianProfileUiInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.uin = "";
  }
  
  private void initList()
  {
    try
    {
      if (this.infoByte != null)
      {
        Object localObject1 = new mobileqq_qidian.GetUserDetailInfoRspBody();
        ((mobileqq_qidian.GetUserDetailInfoRspBody)localObject1).mergeFrom(this.infoByte);
        if (((mobileqq_qidian.GetUserDetailInfoRspBody)localObject1).rpt_msg_config_group_info.has())
        {
          Object localObject2 = ((mobileqq_qidian.GetUserDetailInfoRspBody)localObject1).rpt_msg_config_group_info.get();
          if ((localObject2 != null) && (((List)localObject2).size() > 0))
          {
            this.infoByte = ((mobileqq_qidian.GetUserDetailInfoRspBody)localObject1).toByteArray();
            this.mConfigGroupInfos = new ArrayList(((List)localObject2).size());
            localObject1 = ((List)localObject2).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = new QidianProfileUiInfo.ConfigGroupInfo((mobileqq_qidian.ConfigGroupInfo)((Iterator)localObject1).next());
              this.mConfigGroupInfos.add(localObject2);
            }
          }
        }
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      if (paramObject == this) {
        return true;
      }
    } while (paramObject.getClass() != getClass());
    paramObject = (QidianProfileUiInfo)paramObject;
    return Arrays.equals(this.infoByte, ((QidianProfileUiInfo)paramObject).infoByte);
  }
  
  public void from(String paramString, mobileqq_qidian.GetUserDetailInfoRspBody paramGetUserDetailInfoRspBody)
  {
    this.uin = paramString;
    this.infoByte = paramGetUserDetailInfoRspBody.toByteArray();
    initList();
  }
  
  public List getConfigGroupInfos()
  {
    if (this.mConfigGroupInfos == null)
    {
      initList();
      if (this.mConfigGroupInfos == null) {
        this.mConfigGroupInfos = new ArrayList();
      }
    }
    return this.mConfigGroupInfos;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(this.infoByte);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\qidian\data\QidianProfileUiInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */